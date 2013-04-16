package terrabow.item;

import terrabow.CommonProxy;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTerraPlan extends ItemTerra{

	public ItemTerraPlan( int id ){
		super( id );
		this.setCreativeTab( CreativeTabs.tabMisc );
	}
	@Override
	public EnumSize getSize(){
		return EnumSize.MEDIUM;
	}
	@Override
	public EnumWeight getWeight(){
		return EnumWeight.LIGHT;
	}
}
