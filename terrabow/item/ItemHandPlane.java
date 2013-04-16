package terrabow.item;

import terrabow.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerraTool;

public class ItemHandPlane extends ItemTerraTool{
	

	public ItemHandPlane( int id, EnumToolMaterial enumToolMaterial ){
		super( id, 1, enumToolMaterial, new Block[] {} );
		this.setMaxDamage( enumToolMaterial.getMaxUses() );
		this.setCreativeTab( CreativeTabs.tabTools );
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
	public boolean canStack() {
		return false;
	}
	@Override
	public void updateIcons( IconRegister iconRegister ){
		this.iconIndex = iconRegister.registerIcon( "handplanes/" + this.getUnlocalizedName().replace( "item.", "" ) );
	}
}
