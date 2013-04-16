package terrabow.item;

import java.util.List;

import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;

public class ItemPlaneBlade extends ItemTerra{

	public ItemPlaneBlade( int id ){
		super( id );
		this.setMaxDamage( 100 );
		this.setMaxStackSize( TerraBowSettings.StackLimitPlaneBlades );
		this.setCreativeTab( CreativeTabs.tabMisc );
	}
	@Override
	public EnumSize getSize(){
		return EnumSize.SMALL;
	}
	@Override
	public EnumWeight getWeight(){
		return EnumWeight.MEDIUM;
	}
	@Override
    public int getItemStackLimit(){
		return this.maxStackSize;
    }
	@Override
	public void updateIcons( IconRegister iconRegister ){
		this.iconIndex = iconRegister.registerIcon( "planeblades/PlaneBlade" + this.getUnlocalizedName().replace( "PlaneBlade", "" ).replace( "item.", "" ) );
	}
}
