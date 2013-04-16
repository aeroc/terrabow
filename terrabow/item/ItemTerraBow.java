package terrabow.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import terrabow.entity.EntityBismuthArrow;
import terrabow.entity.EntityBismuthBronzeArrow;
import terrabow.entity.EntityBlackBronzeArrow;
import terrabow.entity.EntityBlackSteelArrow;
import terrabow.entity.EntityBlueSteelArrow;
import terrabow.entity.EntityBoneArrow;
import terrabow.entity.EntityBronzeArrow;
import terrabow.entity.EntityCopperArrow;
import terrabow.entity.EntityIronArrow;
import terrabow.entity.EntityRedSteelArrow;
import terrabow.entity.EntityRoseGoldArrow;
import terrabow.entity.EntitySteelArrow;
import terrabow.entity.EntityStoneArrow;
import terrabow.entity.EntityTerraArrow;
import terrabow.entity.EntityTinArrow;
import terrabow.entity.EntityZincArrow;
import terrabow.manager.ItemManager;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;

public class ItemTerraBow extends ItemTerra{
	
	public static final String[] bowPullIconNameArray = new String[] {"TerraBowPull0", "TerraBowPull1", "TerraBowPull2"};
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    private int arrowIndex = 0;
    public Icon[] iconArrowArray = new Icon[TerraBowSettings.UniqueArrows * 3];
    
	public ItemTerraBow( int id ){
		super( id );
		this.setMaxStackSize( 1 );
        this.setCreativeTab( CreativeTabs.tabCombat );
        this.setFull3D();
	}
	
	@Override
	public EnumSize getSize(){
		return EnumSize.LARGE;
	}
	@Override
	public EnumWeight getWeight(){
		return EnumWeight.MEDIUM;
	}
	@Override
	public boolean canStack(){
		return false;
	}
	@Override
    public int getMaxItemUseDuration( ItemStack itemStack ){
        return 72000;
    }
    @Override
    public EnumAction getItemUseAction( ItemStack itemStack ){
        return EnumAction.bow;
    }
    @Override
    public void onPlayerStoppedUsing( ItemStack itemStack, World world, EntityPlayer entityPlayer, int par4 ){
        int var6 = this.getMaxItemUseDuration( itemStack ) - par4;
        
        ArrowLooseEvent event = new ArrowLooseEvent( entityPlayer, itemStack, var6 );
        MinecraftForge.EVENT_BUS.post( event );
        if( event.isCanceled() ){
            return;
        }
        var6 = event.charge;
        
        ItemStack firstTerraArrowStack = this.findTerraArrowStack( entityPlayer.inventory );

        if( firstTerraArrowStack != null ){
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

            if ((double)var7 < 0.1D){
                return;
            }

            if (var7 > 1.0F){
                var7 = 1.0F;
            }
            
            EntityTerraArrow entityTerraArrow =  this.getFirstArrowEntity( firstTerraArrowStack, world, entityPlayer, var7, getDurabilityRatio( itemStack ) );
            
            if (var7 == 1.0F)
            {
                entityTerraArrow.setIsCritical(true);
            }

            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

            if (var9 > 0)
            {
            	entityTerraArrow.setDamage( entityTerraArrow.getDamage() + (double)var9 * 0.5D + 0.5D);
            }

            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

            if (var10 > 0)
            {
            	entityTerraArrow.setKnockbackStrength(var10);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0)
            {
            	entityTerraArrow.setFire(100);
            }

            itemStack.damageItem( 1, entityPlayer ); //Damages the bow
            world.playSoundAtEntity(entityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

            entityPlayer.inventory.consumeInventoryItem( firstTerraArrowStack.getItem().itemID );

            if (!world.isRemote)
            {
                world.spawnEntityInWorld( entityTerraArrow );
            }
        }
    }
    @Override
    public ItemStack onEaten( ItemStack itemStack, World world, EntityPlayer entityPlayer ){
        return itemStack;
    }
    @Override
    public ItemStack onItemRightClick( ItemStack itemStack, World world, EntityPlayer entityPlayer ){
        ArrowNockEvent event = new ArrowNockEvent( entityPlayer, itemStack );
        MinecraftForge.EVENT_BUS.post( event );
        if( event.isCanceled() ){
            return event.result;
        }
        
        ItemStack firstTerraArrowStack = this.findTerraArrowStack( entityPlayer.inventory );
        this.setArrowIndex( firstTerraArrowStack );
        
        if( firstTerraArrowStack != null ){
            entityPlayer.setItemInUse( itemStack, this.getMaxItemUseDuration( itemStack ) );
        }

        return itemStack;
    }
    public ItemStack findTerraArrowStack( InventoryPlayer inventoryPlayer ){
    	for( int i = 0; i < inventoryPlayer.mainInventory.length; i++ ){
    		ItemStack slotStack = inventoryPlayer.mainInventory[i];
    		if( slotStack != null && slotStack.getItem() instanceof ItemTerraArrow ){
    			return slotStack;
    		}
    	}
    	
    	return null;
    }
    //Terrabow method
    public EntityTerraArrow getFirstArrowEntity( ItemStack firstTerraArrowStack, World world, EntityPlayer entityPlayer, float par7, float durabilityRatio ){
    	
    	switch( firstTerraArrowStack.getItemDamage() ){
    		case 0:	return new EntityStoneArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 1: return new EntityBoneArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 2: return new EntityBismuthArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 3: return new EntityBismuthBronzeArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 4: return new EntityBlackBronzeArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 5: return new EntityBlackSteelArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 6: return new EntityBlueSteelArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 7: return new EntityBronzeArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 8: return new EntityCopperArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 9: return new EntityIronArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 10: return new EntityRedSteelArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 11: return new EntityRoseGoldArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 12: return new EntitySteelArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 13: return new EntityTinArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    		case 14: return new EntityZincArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
			default: return new EntityStoneArrow( world, entityPlayer, par7 * this.getArrowVelocityModifier(), this.getArrowAccuracyModifier(), durabilityRatio );
    	}
    }
    public float getArrowVelocityModifier(){
    	return (float) TerraBowSettings.PrimitiveBowVelocityModifier;
    }
    public float getArrowAccuracyModifier(){
    	return (float) TerraBowSettings.PrimitiveBowAccuracyModifier;
    }
    @Override
    public boolean isRepairable(){
        return false;
    }
    //Terrabow method
    public float getDurabilityRatio( ItemStack itemStack ){
    	return ( 1.0f - (float) itemStack.getItemDamage() / (float) this.getMaxDamage() );
    }
    //Terrabow method
    public void setArrowIndex( ItemStack itemStack ){
    	if( itemStack != null ){
    		this.arrowIndex = itemStack.getItemDamage();
    	}
    }
    //Terrabow method
    public int getArrowIndex(){
    	return this.arrowIndex;
    }
	@Override
    public int getItemStackLimit(){
		return this.maxStackSize;
    }
	@SideOnly(Side.CLIENT)
	public void updateIcons( IconRegister iconRegister ){
		super.updateIcons( iconRegister ); //I believe this registers the non-pull icon, named after the item
		this.iconArray = new Icon[bowPullIconNameArray.length];
		
		for( int i = 0; i < this.iconArray.length; i++ ){
			this.iconArray[i] = iconRegister.registerIcon( bowPullIconNameArray[i] );
		}
	}

	@Override
	public Icon getIcon( ItemStack itemStack, int renderPass, EntityPlayer entityPlayer, ItemStack itemInUse, int useRemaining ){
        if( itemInUse != null && itemInUse.getItem().itemID == this.itemID ){
        	int index = itemInUse.getMaxItemUseDuration() - useRemaining;
        	
        	if( index >= 18 ){
        		return this.iconArrowArray[this.getArrowIndex() * 3 + 2];
        	}
        	else if( index > 13 ){
        		return this.iconArrowArray[this.getArrowIndex() * 3 + 1];
        	}
        	else if( index > 0 ){
        		return this.iconArrowArray[this.getArrowIndex() * 3];
        	}
        	return this.iconArrowArray[this.getArrowIndex() * 3];
        }
        return this.iconIndex;
    }
}
