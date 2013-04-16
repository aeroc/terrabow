package terrabow.item;

import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRoughFootedShaft extends ItemTerra{

	public ItemRoughFootedShaft( int id ){
		super( id );
		this.setCreativeTab( CreativeTabs.tabMaterials );
		this.setMaxStackSize( TerraBowSettings.StackLimitWoodShafts );
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
    public int getItemStackLimit(){
		return this.maxStackSize;
    }
}
