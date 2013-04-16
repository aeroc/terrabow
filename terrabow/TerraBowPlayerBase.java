package terrabow;

import terrabow.manager.ItemManager;
import net.minecraft.item.Item;
import net.minecraft.src.PlayerAPI;
import net.minecraft.src.PlayerBase;

public class TerraBowPlayerBase extends PlayerBase{

	public TerraBowPlayerBase( PlayerAPI playerAPI ){
		super( playerAPI );
	}
	@Override
	public float getFOVMultiplier(){
		
		float var1 = 1.0F;

        if( this.player.capabilities.isFlying ){
            var1 *= 1.1F;
        }

        var1 *= ( this.player.landMovementFactor * this.player.superGetSpeedModifier() / 0.1f + 1.0F ) / 2.0F;

        if( this.player.isUsingItem() && (  this.player.getItemInUse().itemID == Item.bow.itemID ||
        									this.player.getItemInUse().itemID == ItemManager.PrimitiveBow.itemID ||
        									this.player.getItemInUse().itemID == ItemManager.Longbow.itemID ||
        									this.player.getItemInUse().itemID == ItemManager.CompositeBow.itemID ) ){
            int var2 = this.player.getItemInUseDuration();
            float var3 = (float)var2 / 20.0F;

            if (var3 > 1.0F){
                var3 = 1.0F;
            }
            else{
                var3 *= var3;
            }

            var1 *= 1.0F - var3 * 0.15F;
        }

        return var1;
	}
}
