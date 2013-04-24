package terrabow.entity;

import java.util.List;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import terrabow.manager.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityTerraArrow extends Entity implements IProjectile{
	
	private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private int inData = 0;
    private boolean inGround = false;
	public int canBePickedUp = 0;
	public int arrowShake = 0;
	public Entity shootingEntity;
	private int ticksInGround;
    private int ticksInAir = 0;
    private double damage = 2.0D;
    private int knockbackStrength;
    private float durabilityRatio = 0.0f; //The durability ratio of the bow that fired this arrow
	
	public EntityTerraArrow( World world ){
        super( world );
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
    }
	public EntityTerraArrow( World world, double par2, double par4, double par6 ){
        super( world );
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        this.setPosition(par2, par4, par6);
        this.yOffset = 0.0F;
    }
	public EntityTerraArrow( World world, EntityLiving shootingEntity, EntityLiving entityLiving2, float par4, float par5 ){
        super( world );
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shootingEntity;

        if (shootingEntity instanceof EntityPlayer)
        {
            this.canBePickedUp = 1;
        }

        this.posY = shootingEntity.posY + (double)shootingEntity.getEyeHeight() - 0.10000000149011612D;
        double var6 = entityLiving2.posX - shootingEntity.posX;
        double var8 = entityLiving2.posY + (double)entityLiving2.getEyeHeight() - 0.699999988079071D - this.posY;
        double var10 = entityLiving2.posZ - shootingEntity.posZ;
        double var12 = (double)MathHelper.sqrt_double(var6 * var6 + var10 * var10);

        if (var12 >= 1.0E-7D)
        {
            float var14 = (float)(Math.atan2(var10, var6) * 180.0D / Math.PI) - 90.0F;
            float var15 = (float)(-(Math.atan2(var8, var12) * 180.0D / Math.PI));
            double var16 = var6 / var12;
            double var18 = var10 / var12;
            this.setLocationAndAngles(shootingEntity.posX + var16, this.posY, shootingEntity.posZ + var18, var14, var15);
            this.yOffset = 0.0F;
            float var20 = (float)var12 * 0.2F;
            this.setThrowableHeading(var6, var8 + (double)var20, var10, par4, par5);
        }
    }
	public EntityTerraArrow( World world, EntityLiving entityLiving, float par3 ){
        super( world );
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = entityLiving;

        if (entityLiving instanceof EntityPlayer)
        {
            this.canBePickedUp = 1;
        }

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(entityLiving.posX, entityLiving.posY + (double)entityLiving.getEyeHeight(), entityLiving.posZ, entityLiving.rotationYaw, entityLiving.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        //if( world.isRemote ) PacketDispatcher.sendPacketToAllPlayers( new Packet3Chat( "par3 before throwable heading: " + ( par3 * 1.5F ) ) );
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
    }
	//Terrabow mod constructor
	public EntityTerraArrow( World world, EntityLiving entityLiving, float par3, float accuracyModifier, float durabilityRatio ){
        super( world );
        this.durabilityRatio = durabilityRatio;
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = entityLiving;
        par3 = this.modifySpeedWithBowCondition( par3 );

        if( entityLiving instanceof EntityPlayer ){
            this.canBePickedUp = 1;
        }

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(entityLiving.posX, entityLiving.posY + (double)entityLiving.getEyeHeight(), entityLiving.posZ, entityLiving.rotationYaw, entityLiving.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));

        this.setThrowableHeading( this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F, accuracyModifier );
    }
	protected void entityInit(){
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
	public void setThrowableHeading( double par1, double par3, double par5, float par7, float par8 ){
        float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)var9;
        par3 /= (double)var9;
        par5 /= (double)var9;
        //These three make the arrows less accurate I believe
        par1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
        par3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
        par5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)var10) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }
	//Terrabow mod version
	public void setThrowableHeading( double par1, double par3, double par5, float par7, float par8, float accuracyModifier ){
        float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)var9;
        par3 /= (double)var9;
        par5 /= (double)var9;
        //These three make the arrows less accurate I believe
        par1 += this.rand.nextGaussian() * accuracyModifier;// * (double)par8;
        par3 += this.rand.nextGaussian() * ( accuracyModifier / 4.0f );// * (double)par8;
        par5 += this.rand.nextGaussian() * accuracyModifier;// * (double)par8;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)var10) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2( double par1, double par3, double par5, float par7, float par8, int par9 ){
        this.setPosition(par1, par3, par5);
        this.setRotation(par7, par8);
    }
	@SideOnly(Side.CLIENT)
	public void setVelocity( double par1, double par3, double par5 ){
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;

        if( this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F ){
            float var7 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)var7) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }
	@Override
	public void onUpdate(){
        super.onUpdate();

        if( ( !this.inGround && this.ticksInAir < 4 ) || ( this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F ) ){
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
        }

        int i = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

        if( i > 0 ){
            Block.blocksList[i].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB var2 = Block.blocksList[i].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

            if (var2 != null && var2.isVecInside(this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if( this.arrowShake > 0 ){
            --this.arrowShake;
        }

        if( this.inGround ){
            int j = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            int k = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

            if( j == this.inTile && k == this.inData ){
                ++this.ticksInGround;

                if( this.ticksInGround == 1200 ){
                    this.setDead();
                }
            }
            else{
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else{
            ++this.ticksInAir;
            Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
            Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingObjectPosition = this.worldObj.rayTraceBlocks_do_do(vec3, vec31, false, true);
            vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
            vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if( movingObjectPosition != null ){
                vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingObjectPosition.hitVec.xCoord, movingObjectPosition.hitVec.yCoord, movingObjectPosition.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            int l;
            float f1;

            for( l = 0; l < list.size(); ++l ){
                Entity entity1 = (Entity)list.get(l);

                if( entity1.canBeCollidedWith() && ( entity1 != this.shootingEntity || this.ticksInAir >= 5 ) ){
                    f1 = 0.3F;
                    AxisAlignedBB axisAlignedBB1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
                    MovingObjectPosition movingObjectPosition1 = axisAlignedBB1.calculateIntercept(vec3, vec31);

                    if (movingObjectPosition1 != null){
                        double d1 = vec3.distanceTo(movingObjectPosition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D){
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null){
                movingObjectPosition = new MovingObjectPosition(entity);
            }

            float f2;
            float f3;

            if (movingObjectPosition != null){
                if (movingObjectPosition.entityHit != null){
                	
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int i1 = MathHelper.ceiling_double_int((double)f2 * this.getDamage() );
                    //if( !this.worldObj.isRemote ){ PacketDispatcher.sendPacketToAllPlayers( new Packet3Chat( "Arrow Damage: " + var23 ) ); }
                    if (this.getIsCritical()){
                        i1 += this.rand.nextInt(i1 / 2 + 2);
                    }

                    DamageSource damageSource = null;

                    if (this.shootingEntity == null){
                        //var21 = DamageSource.causeArrowDamage(this, this);
                    	damageSource = ( new EntityDamageSourceIndirect( "arrow", this, this ) ).setProjectile();
                    }
                    else{
                        //var21 = DamageSource.causeArrowDamage(this, this.shootingEntity);
                    	damageSource = ( new EntityDamageSourceIndirect( "arrow", this, this.shootingEntity ) ).setProjectile();
                    }

                    if (this.isBurning() && !(movingObjectPosition.entityHit instanceof EntityEnderman)){
                        movingObjectPosition.entityHit.setFire(5);
                    }

                    if (movingObjectPosition.entityHit.attackEntityFrom(damageSource, i1)){
                    	
                        if (movingObjectPosition.entityHit instanceof EntityLiving){
                            EntityLiving entityLiving = (EntityLiving)movingObjectPosition.entityHit;

                            if (!this.worldObj.isRemote){
                                entityLiving.setArrowCountInEntity(entityLiving.getArrowCountInEntity() + 1);
                            }

                            if (this.knockbackStrength > 0){
                                f3 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (f3 > 0.0F){
                                    movingObjectPosition.entityHit.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f3, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f3);
                                }
                            }

                            if( this.shootingEntity != null ){
                            	EnchantmentThorns.func_92096_a( this.shootingEntity, entityLiving, this.rand );
                            }

                            if (this.shootingEntity != null && movingObjectPosition.entityHit != this.shootingEntity && movingObjectPosition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP ){
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacketToPlayer(new Packet70GameEvent(6, 0));
                            }
                        }

                        this.playSound( "random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F ) );

                        if (!(movingObjectPosition.entityHit instanceof EntityEnderman)){
                            this.setDead();
                            //Terrabowmod spawn an arrow or arrowhead after striking a living entity
                            if( !this.worldObj.isRemote ){
	                            if( this.rand.nextDouble() <= TerraBowSettings.ChanceToDropArrow ){
	                            	this.worldObj.spawnEntityInWorld( new EntityItem( this.worldObj, this.posX, this.posY, this.posZ, this.arrowDrop() ) );
	                            }
	                            else if( this.rand.nextDouble() <= TerraBowSettings.ChanceToDropArrowhead ){
	                            	this.worldObj.spawnEntityInWorld( new EntityItem( this.worldObj, this.posX, this.posY, this.posZ, this.arrowheadDrop() ) );
	                            }
                            }
                        }
                    }
                    else{
                        this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                }
                else{
                    this.xTile = movingObjectPosition.blockX;
                    this.yTile = movingObjectPosition.blockY;
                    this.zTile = movingObjectPosition.blockZ;
                    this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (double)((float)(movingObjectPosition.hitVec.xCoord - this.posX));
                    this.motionY = (double)((float)(movingObjectPosition.hitVec.yCoord - this.posY));
                    this.motionZ = (double)((float)(movingObjectPosition.hitVec.zCoord - this.posZ));
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
                    this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);

                    if (this.inTile != 0){
                        Block.blocksList[this.inTile].onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
                    }
                }
            }

            if (this.getIsCritical()){
                for (l = 0; l < 4; ++l){
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)l / 4.0D, this.posY + this.motionY * (double)l / 4.0D, this.posZ + this.motionZ * (double)l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F){
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F){
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F){
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F){
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float var22 = 0.99F;
            f1 = 0.05F;

            if (this.isInWater()){
                for (int var25 = 0; var25 < 4; ++var25){
                    f3 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
                }

                var22 = 0.8F;
            }

            this.motionX *= (double)var22;
            this.motionY *= (double)var22;
            this.motionZ *= (double)var22;
            this.motionY -= (double)f1;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }
    }
	public void writeEntityToNBT( NBTTagCompound par1NBTTagCompound ){
        par1NBTTagCompound.setShort("xTile", (short)this.xTile);
        par1NBTTagCompound.setShort("yTile", (short)this.yTile);
        par1NBTTagCompound.setShort("zTile", (short)this.zTile);
        par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
        par1NBTTagCompound.setByte("inData", (byte)this.inData);
        par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
        par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
        par1NBTTagCompound.setDouble("damage", this.getDamage() );
    }
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound){
        this.xTile = par1NBTTagCompound.getShort("xTile");
        this.yTile = par1NBTTagCompound.getShort("yTile");
        this.zTile = par1NBTTagCompound.getShort("zTile");
        this.inTile = par1NBTTagCompound.getByte("inTile") & 255;
        this.inData = par1NBTTagCompound.getByte("inData") & 255;
        this.arrowShake = par1NBTTagCompound.getByte("shake") & 255;
        this.inGround = par1NBTTagCompound.getByte("inGround") == 1;

        if (par1NBTTagCompound.hasKey("damage")){
            this.damage = par1NBTTagCompound.getDouble("damage");
        }

        if (par1NBTTagCompound.hasKey("pickup")){
            this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
        }
        else if (par1NBTTagCompound.hasKey("player")){
            this.canBePickedUp = par1NBTTagCompound.getBoolean("player") ? 1 : 0;
        }
    }
	public void onCollideWithPlayer( EntityPlayer entityPlayer ){
        if( !this.worldObj.isRemote && this.inGround && this.arrowShake <= 0 ){
            boolean var2 = this.canBePickedUp == 1 || this.canBePickedUp == 2 && entityPlayer.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1 && !entityPlayer.inventory.addItemStackToInventory( this.pickupItem() ) ){
                var2 = false;
            }

            if (var2){
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                entityPlayer.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
	protected boolean canTriggerWalking(){
        return false;
    }
	@SideOnly(Side.CLIENT)
    public float getShadowSize(){
        return 0.0F;
    }

    public void setDamage( double par1 ){
        this.damage = par1;
    }
  
    public double getDamage(){
    	double baseDamage = this.getDamageFromConfiguration() - ( TerraBowSettings.BowConditionArrowDamageRatio * this.getDamageFromConfiguration() );
    	//The base damage is the portion of damage that is not affected by bow condition
    	double affectedDamage = ( this.getDamageFromConfiguration() - baseDamage ) * this.durabilityRatio;
    	//The affectedDamage is the portion that is affected by bow condition
        return ( baseDamage + affectedDamage );
    }
  //TerraBow method
    public double getDamageFromConfiguration(){
    	return 2.0d;
    }
    public void setKnockbackStrength(int par1){
        this.knockbackStrength = par1;
    }
    public boolean canAttackWithItem(){
        return false;
    }
    public void setIsCritical(boolean par1){
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if( par1 ){
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 1)));
        }
        else{
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -2)));
        }
    }
    public boolean getIsCritical(){
        byte var1 = this.dataWatcher.getWatchableObjectByte(16);
        return (var1 & 1) != 0;
    }
    //This is a TerraBow method
    public ItemStack pickupItem(){
    	return new ItemStack( ItemManager.Arrow, 1, 1 );
    }
    //TerraBow method
    public float modifySpeedWithBowCondition( float speed ){
    	float baseSpeed = ( speed - ( (float) TerraBowSettings.BowConditionArrowSpeedRatio * speed ));
    	float affectedSpeed = ( speed - baseSpeed ) * this.durabilityRatio;
    	
    	return ( baseSpeed + affectedSpeed );
    }
    //TerraBow method
    public ItemStack arrowDrop(){
    	return null;
    }
    //TerraBow method
    public ItemStack arrowheadDrop(){
    	return null;
    }
}
