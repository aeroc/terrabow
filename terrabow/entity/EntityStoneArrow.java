package terrabow.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import terrabow.TerraBowSettings;
import terrabow.manager.ItemManager;

public class EntityStoneArrow extends EntityTerraArrow {

	public EntityStoneArrow( World world ){
		super( world );
	}
	public EntityStoneArrow( World world, double par2, double par4, double par6 ){
		super( world, par2, par4, par6 );
	}
	public EntityStoneArrow( World world, EntityLiving shootingEntity, EntityLiving entityLiving2, float par4, float par5 ){
		super( world, shootingEntity, entityLiving2, par4, par5 );
	}
	public EntityStoneArrow( World world, EntityLiving entityLiving, float par3 ){
		super( world, entityLiving, par3 );
	}
	public EntityStoneArrow( World world, EntityLiving entityLiving, float par3, float accuracyModifier, float durabilityRatio ){
		super( world, entityLiving, par3, accuracyModifier, durabilityRatio );
	}
	@Override
	public ItemStack pickupItem(){
		return new ItemStack( ItemManager.Arrow, 1, 0 );
	}
	@Override
	public double getDamageFromConfiguration(){
		return TerraBowSettings.StoneArrowDamage;
	}
    //TerraBow method
	@Override
    public ItemStack arrowDrop(){
    	return this.pickupItem();
    }
    //TerraBow method
	@Override
    public ItemStack arrowheadDrop(){
    	return new ItemStack( ItemManager.Arrowhead, 1, 0 );
    }
}
