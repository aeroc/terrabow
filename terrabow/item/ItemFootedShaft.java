package terrabow.item;

import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFootedShaft extends ItemTerra{

	public ItemFootedShaft( int id ){
		super( id );
		this.setCreativeTab( CreativeTabs.tabMaterials );
		this.setMaxStackSize( TerraBowSettings.StackLimitFootedShafts );
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
