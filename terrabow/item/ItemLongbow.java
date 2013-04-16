package terrabow.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import terrabow.TerraBowSettings;
import terrabow.manager.ItemManager;

public class ItemLongbow extends ItemTerraBow{
	
	public ItemLongbow( int id ){
		super( id );
		this.setMaxStackSize( 1 );
		this.setMaxDamage( TerraBowSettings.LongbowDurability );
        this.setCreativeTab(CreativeTabs.tabCombat);
	}
	@Override
    public float getArrowVelocityModifier(){
    	return (float) TerraBowSettings.LongbowVelocityModifier;
    }
	@Override
    public float getArrowAccuracyModifier(){
    	return (float) TerraBowSettings.LongbowAccuracyModifier;
    }
	@Override
	public void updateIcons( IconRegister iconRegister ){
		this.iconIndex = iconRegister.registerIcon( "primitivebow/PrimitiveBow" );
		for( int i = 0; i < TerraBowSettings.UniqueArrows; i++ ){
			for( int j = 0; j < 3; j++ ){ //3 loops, 1 for each nocking animation
				this.iconArrowArray[i * 3 + j] = iconRegister.registerIcon( "primitivebow/Primitive" + TerraBowSettings.ArrowheadNames[i].replaceAll( "\\s", "" ) + j );
			}
		}
	}
}