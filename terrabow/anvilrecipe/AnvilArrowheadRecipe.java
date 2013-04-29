package terrabow.anvilrecipe;

import terrabow.TerraBowSettings;
import net.minecraft.item.ItemStack;
import TFC.Core.AnvilRecipe;
import TFC.Core.AnvilReq;
import TFC.Enums.CraftingRuleEnum;

public class AnvilArrowheadRecipe extends AnvilRecipe{

	public AnvilArrowheadRecipe( ItemStack in, ItemStack p, int cv, CraftingRuleEnum rule0, CraftingRuleEnum rule1, CraftingRuleEnum rule2, boolean flux, AnvilReq req, ItemStack result ){
		super( in, p, cv, rule0, rule1, rule2, flux, req, result );
	}
	public AnvilArrowheadRecipe( ItemStack in, ItemStack p, int cv, CraftingRuleEnum rule0, CraftingRuleEnum rule1, CraftingRuleEnum rule2, boolean flux, int req, ItemStack result ){
		super( in, p, cv, rule0, rule1, rule2, flux, req, result );
	}
	public AnvilArrowheadRecipe( ItemStack in, ItemStack p, boolean flux, AnvilReq req ){
        super( in, p, flux, req );
    }
    
    public AnvilArrowheadRecipe( ItemStack in, ItemStack p, boolean flux, int req ){
        super( in, p, flux, req );
    }
    
    public AnvilArrowheadRecipe( ItemStack in, ItemStack p, boolean flux, AnvilReq req, ItemStack res ){
    	super( in, p, flux, req, res );
    }
    
    public AnvilArrowheadRecipe( ItemStack in, ItemStack p, AnvilReq req, ItemStack res ){
        super( in, p, req, res );
    }
    public ItemStack getCraftingResult(){
    	ItemStack result = super.getCraftingResult();
    	result.stackSize = (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods );
        return result;
    }
}
