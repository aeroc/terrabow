package terrabow;

import terrabow.entity.EntityBismuthArrow;
import terrabow.entity.EntityBismuthBronzeArrow;
import terrabow.entity.EntityBlackBronzeArrow;
import terrabow.entity.EntityBlackSteelArrow;
import terrabow.entity.EntityBlueSteelArrow;
import terrabow.entity.EntityBoneArrow;
import terrabow.entity.EntityBronzeArrow;
import terrabow.entity.EntityCopperArrow;
import terrabow.entity.EntityIronArrow;
import terrabow.entity.EntityRedSteelArrow;
import terrabow.entity.EntityRoseGoldArrow;
import terrabow.entity.EntitySteelArrow;
import terrabow.entity.EntityStoneArrow;
import terrabow.entity.EntityTinArrow;
import terrabow.entity.EntityZincArrow;
import terrabow.render.RenderTerraArrow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerTextures(){
		MinecraftForgeClient.preloadTexture( CommonProxy.StoneArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BoneArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BismuthArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BismuthBronzeArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BlackBronzeArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BlackSteelArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BlueSteelArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.BronzeArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.CopperArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.IronArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.RedSteelArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.RoseGoldArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.SteelArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.TinArrowPNG );
		MinecraftForgeClient.preloadTexture( CommonProxy.ZincArrowPNG );

		RenderingRegistry.registerEntityRenderingHandler( EntityStoneArrow.class, new RenderTerraArrow( CommonProxy.StoneArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBoneArrow.class, new RenderTerraArrow( CommonProxy.BoneArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBismuthArrow.class, new RenderTerraArrow( CommonProxy.BismuthArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBismuthBronzeArrow.class, new RenderTerraArrow( CommonProxy.BismuthBronzeArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBlackBronzeArrow.class, new RenderTerraArrow( CommonProxy.BlackBronzeArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBlackSteelArrow.class, new RenderTerraArrow( CommonProxy.BlackSteelArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBlueSteelArrow.class, new RenderTerraArrow( CommonProxy.BlueSteelArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityBronzeArrow.class, new RenderTerraArrow( CommonProxy.BronzeArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityCopperArrow.class, new RenderTerraArrow( CommonProxy.CopperArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityIronArrow.class, new RenderTerraArrow( CommonProxy.IronArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityRedSteelArrow.class, new RenderTerraArrow( CommonProxy.RedSteelArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityRoseGoldArrow.class, new RenderTerraArrow( CommonProxy.RoseGoldArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntitySteelArrow.class, new RenderTerraArrow( CommonProxy.SteelArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityTinArrow.class, new RenderTerraArrow( CommonProxy.TinArrowPNG ) );
		RenderingRegistry.registerEntityRenderingHandler( EntityZincArrow.class, new RenderTerraArrow( CommonProxy.ZincArrowPNG ) );
	}
}
