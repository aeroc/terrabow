package terrabow.item;

import net.minecraft.creativetab.CreativeTabs;
import terrabow.CommonProxy;
import terrabow.TerraBowSettings;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;

public class ItemGlueBottle extends ItemTerra{

	public ItemGlueBottle(int id) {
		super( id );
		this.setCreativeTab( CreativeTabs.tabMisc );
		this.setMaxDamage( TerraBowSettings.GlueBottleMaxUses );
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
	public boolean canStack(){
		return false;
	}
}
