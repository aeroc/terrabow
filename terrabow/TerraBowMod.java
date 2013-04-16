package terrabow;

import net.minecraft.item.Item;
import net.minecraft.src.PlayerAPI;
import net.minecraftforge.common.Configuration;
import terrabow.handler.CraftingHandler;
import terrabow.item.*;
import terrabow.manager.EntityManager;
import terrabow.manager.ItemManager;
import terrabow.manager.RecipeManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod( modid = "TerraBow", name="TerraBow", version = "0.4" )
@NetworkMod( clientSideRequired = true, serverSideRequired = false )

public class TerraBowMod {

	@SidedProxy( clientSide = "terrabow.ClientProxy", serverSide = "terrabow.CommonProxy" )
	public static CommonProxy commonProxy;
	
	@PreInit
	public void preInit( FMLPreInitializationEvent event ){
		Configuration config = new Configuration( event.getSuggestedConfigurationFile() );
		TerraBowSettings.config( config );
		config.save();
		PlayerAPI.register( "TerraBow", TerraBowPlayerBase.class );
	}
	
	//TODO NEXT: Obsidian arrows?
	//Draw the last textures myself?
	//Make a recipe guide
	
	@Init
	public void init( FMLInitializationEvent event ){
		
		EntityManager.RegisterGlobalEntityID();
		EntityManager.RegisterModEntity( this );
		
		ItemManager.SetItems();	//Be certain to call this before registering crafting recipes
		ItemManager.RegisterItems();
		ItemManager.RegisterItemNames();
		
		this.commonProxy.registerTextures();
		
		RecipeManager.RemoveRecipes(); //Should call this before registering recipes.
		RecipeManager.RegisterRecipes();
		RecipeManager.RegisterAnvilRecipes();
		RecipeManager.RegisterKnappingRecipes();
		RecipeManager.RegisterItemHeat();
		
		GameRegistry.registerCraftingHandler( new CraftingHandler() );
	}
}