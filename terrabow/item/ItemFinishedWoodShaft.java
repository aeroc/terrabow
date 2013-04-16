package terrabow.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;

public class ItemFinishedWoodShaft extends ItemTerra{
	
	public Icon[] icons;

	public ItemFinishedWoodShaft( int id ){
		super( id );
		this.setCreativeTab( CreativeTabs.tabMaterials );
		this.setHasSubtypes( true );
		this.setMaxDamage( 0 );
		this.setMaxStackSize( TerraBowSettings.StackLimitWoodShafts );
		this.MetaNames = new String[] { "Oak", "Aspen", "Birch", "Chestnut", "Douglas Fir", "Hickory", "Maple", "Ash", "Pine",
										"Sequoia", "Spruce", "Sycamore", "White Cedar", "White Elm", "Willow", "Kapok" };
		this.icons = new Icon[this.MetaNames.length];
	}
	@Override
	public EnumSize getSize(){
		return EnumSize.MEDIUM;
	}
	@Override
	public EnumWeight getWeight(){
		return EnumWeight.LIGHT;
	}
	@Override
	public void getSubItems( int par1, CreativeTabs creativeTabs, List list ){
		for( int i = 0; i < this.icons.length; i++ ){
			list.add( new ItemStack( this, 1, i ) );
		}
	}
	@Override
    public int getItemStackLimit(){
		return this.maxStackSize;
    }
	@Override
	public Icon getIconFromDamage( int meta ){
		return this.icons[meta];
	}
	@Override
	public void updateIcons( IconRegister iconRegister ){
		for( int i = 0; i < this.icons.length; i++ ){
			this.icons[i] = iconRegister.registerIcon( "finishedwoodshafts/FinishedWoodShaft" + this.MetaNames[i].replaceAll( "\\s", "" ) );
		}
	}
	@Override
	public String getUnlocalizedName( ItemStack itemStack ){
		return this.getUnlocalizedName() + "." + this.MetaNames[itemStack.getItemDamage()];
	}
}
