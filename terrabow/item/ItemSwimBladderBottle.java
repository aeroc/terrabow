package terrabow.item;

import net.minecraft.creativetab.CreativeTabs;
import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;

public class ItemSwimBladderBottle extends ItemTerra{

	public ItemSwimBladderBottle( int id ) {
		super(id);
		this.setMaxStackSize( TerraBowSettings.StackLimitSwimBladderBottles );
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
