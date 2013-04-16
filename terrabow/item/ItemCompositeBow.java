package terrabow.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import terrabow.TerraBowSettings;
import terrabow.manager.ItemManager;

public class ItemCompositeBow extends ItemTerraBow{
	
	public ItemCompositeBow( int id ){
		super( id );
		this.setMaxStackSize( 1 );
		this.setMaxDamage( TerraBowSettings.CompositeBowDurability );
        this.setCreativeTab(CreativeTabs.tabCombat);
	}
	@Override
    public float getArrowVelocityModifier(){
    	return (float) TerraBowSettings.CompositeBowVelocityModifier;
    }
	@Override
    public float getArrowAccuracyModifier(){
    	return (float) TerraBowSettings.CompositeBowAccuracyModifier;
    }
	@Override
	public void updateIcons( IconRegister iconRegister ){
		this.iconIndex = iconRegister.registerIcon( "compositebow/CompositeBow" );
		for( int i = 0; i < TerraBowSettings.UniqueArrows; i++ ){
			for( int j = 0; j < 3; j++ ){ //3 loops, 1 for each nocking animation
				this.iconArrowArray[i * 3 + j] = iconRegister.registerIcon( "compositebow/Composite" + TerraBowSettings.ArrowheadNames[i].replaceAll( "\\s", "" ) + j );
			}
		}
	}
}