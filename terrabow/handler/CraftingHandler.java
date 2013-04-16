package terrabow.handler;

import terrabow.TerraBowMod;
import terrabow.manager.ItemManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet3Chat;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.network.PacketDispatcher;

public class CraftingHandler implements ICraftingHandler{
	
	@Override 
	public void onCrafting( EntityPlayer entityPlayer, ItemStack itemStack, IInventory inventory ){
		if( inventory != null ){
			if( itemStack.itemID == ItemManager.RoughWoodShaft.itemID ||
					 itemStack.itemID == ItemManager.LongbowBody.itemID ){
				TFC.Handlers.CraftingHandler.HandleItem( entityPlayer, inventory, TFC.Core.Recipes.Saws );
			}
			else if( itemStack.itemID == ItemManager.FootedShaft.itemID ||
					 itemStack.itemID == ItemManager.FinishedWoodShaft.itemID ){
				TFC.Handlers.CraftingHandler.HandleItem( entityPlayer, inventory, ItemManager.getPlanes() );
			}
			else if( ( itemStack.itemID == ItemManager.Arrowhead.itemID && itemStack.getItemDamage() == 1 ) || 
					 itemStack.itemID == ItemManager.SwimBladder.itemID ){
				TFC.Handlers.CraftingHandler.HandleItem( entityPlayer, inventory, TFC.Core.Recipes.Knives );
			}
			else if( itemStack.itemID == ItemManager.Arrow.itemID ||
					 itemStack.itemID == ItemManager.RoughFootedShaft.itemID ||
					 itemStack.itemID == ItemManager.CompositeBow.itemID ){
				TFC.Handlers.CraftingHandler.HandleItem( entityPlayer, inventory, new Item[] { ItemManager.GlueBottle } );
			}
			else if( itemStack.itemID == ItemManager.Longbow.itemID ){
				TFC.Handlers.CraftingHandler.HandleItem( entityPlayer, inventory, ItemManager.getPlanes() );
			}
		}
	}
	@Override
	public void onSmelting( EntityPlayer entityPlayer, ItemStack itemStack ){
		
	}
}
