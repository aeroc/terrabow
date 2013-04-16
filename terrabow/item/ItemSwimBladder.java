package terrabow.item;

import net.minecraft.creativetab.CreativeTabs;
import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;

public class ItemSwimBladder extends ItemTerra{

	public ItemSwimBladder( int id ) {
		super( id );
		this.setMaxStackSize( TerraBowSettings.StackLimitSwimBladders );
		this.setCreativeTab( CreativeTabs.tabMisc );
	}
	@Override
	public EnumSize getSize(){
		return EnumSize.SMALL;
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
