package terrabow.manager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import TFC.TFCItems;
import TFC.Core.AnvilCraftingManagerTFC;
import TFC.Core.AnvilRecipe;
import TFC.Core.AnvilReq;
import TFC.Core.CraftingManagerTFC;
import TFC.Core.HeatIndex;
import TFC.Core.HeatManager;
import TFC.Core.HeatRaw;
import TFC.Core.Recipes;
import TFC.Enums.CraftingRuleEnum;

import terrabow.TerraBowMod;
import terrabow.TerraBowSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

public class RecipeManager {
	
	public static enum WoodType { Softwood, Hardwood };
	public static WoodType[] PlankType = new WoodType[] { 	WoodType.Hardwood,	//Oak
															WoodType.Hardwood,	//Aspen
															WoodType.Hardwood,	//Birch
															WoodType.Hardwood,	//Chestnut
															WoodType.Softwood,	//Douglas Fir
															WoodType.Hardwood,	//Hickory
															WoodType.Hardwood,	//Maple
															WoodType.Hardwood,	//Ash
															WoodType.Softwood,	//Pine
															WoodType.Softwood,	//Sequoia/Redwood
															WoodType.Softwood,	//Spruce
															WoodType.Hardwood,	//Sycamore
															WoodType.Softwood,	//White Cedar
															WoodType.Hardwood,	//White Elm
															WoodType.Hardwood,	//Willow
															WoodType.Hardwood };//Kapok
	
	public static void RemoveRecipes(){
		TFC.Core.Recipes.RemoveRecipe( new ItemStack( Item.bow ) );
		TFC.Core.Recipes.RemoveRecipe( new ItemStack( Item.arrow ) );
	}
	
	public static void RegisterRecipes(){
		//Convert vanilla bow and arrow recipes to Terra Bow items
		ModLoader.addShapelessRecipe( new ItemStack( ItemManager.PrimitiveBow, 1, 0 ), new Object[] { new ItemStack( Item.bow, 1 ) } );
		ModLoader.addShapelessRecipe( new ItemStack( ItemManager.Arrow, 1, 0 ), new Object[] { new ItemStack( Item.arrow, 1 ) } );
		
		//Rough Shafts from Planks using Saws
		for( int i = 0; i < RecipeManager.PlankType.length; i++ ){
			for( int j = 0; j < TFC.Core.Recipes.Saws.length; j++ ){
				ModLoader.addRecipe( new ItemStack( ItemManager.RoughWoodShaft, 8, i ), new Object[] { "A", "B", Character.valueOf( 'B' ), new ItemStack( TFC.TFCItems.SinglePlank, 1, i ), Character.valueOf( 'A' ), new ItemStack( TFC.Core.Recipes.Saws[j], 1, 32767 ) } );
			}
		}
		//Rough Footed Shafts
		for( int i = 0; i < PlankType.length; i++ ){
			if( PlankType[i] == WoodType.Hardwood ){
				for( int j = 0; j < PlankType.length; j++ ){
					if( PlankType[j] == WoodType.Softwood ){
						ModLoader.addShapelessRecipe( new ItemStack( ItemManager.RoughFootedShaft ), new Object[] { new ItemStack( ItemManager.RoughWoodShaft, 1, i ), new ItemStack( ItemManager.RoughWoodShaft, 1, j ), new ItemStack( ItemManager.GlueBottle, 1, 32767 ) } );
					}
				}
			}
		}
		
		//Footed Shafts
		Item[] planeArray = ItemManager.getPlanes();
		for( int i = 0; i < planeArray.length; i++ ){
			ModLoader.addShapelessRecipe( new ItemStack( ItemManager.FootedShaft ), new Object[] { new ItemStack( ItemManager.RoughFootedShaft, 1, 0 ), new ItemStack( planeArray[i], 1, 32767 ) } );
		}
		//Hand Planes
		for( int i = 0; i < 5; i++ ){
			double damage = i * 5.0d / 100.0d;
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneBismuth, 1, (int) ( TFCItems.BismuthUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeBismuth, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneBismuthBronze, 1, (int) ( TFCItems.BismuthBronzeUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeBismuthBronze, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneBlackBronze, 1, (int) ( TFCItems.BlackBronzeUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeBlackBronze, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneBlackSteel, 1, (int) ( TFCItems.BlackSteelUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeBlackSteel, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneBlueSteel, 1, (int) ( TFCItems.BlueSteelUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeBlueSteel, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneBronze, 1, (int) ( TFCItems.BronzeUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeBronze, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneCopper, 1, (int) ( TFCItems.CopperUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeCopper, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneWroughtIron, 1, (int) ( TFCItems.WroughtIronUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeWroughtIron, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneRedSteel, 1, (int) ( TFCItems.RedSteelUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeRedSteel, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneRoseGold, 1, (int) ( TFCItems.RoseGoldUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeRoseGold, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneSteel, 1, (int) ( TFCItems.SteelUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeSteel, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneTin, 1, (int) ( TFCItems.TinUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeTin, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.HandPlaneZinc, 1, (int) ( TFCItems.ZincUses * damage ) ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( ItemManager.PlaneBladeZinc, 1, i * 5 ), Character.valueOf( 'b' ), new ItemStack( Item.stick, 1, 32767 ) } );
		}
		//Knives Recipes:
		//Bone Arrowheads
		//Swim Bladders
		for( int i = 0; i < TFC.Core.Recipes.Knives.length; i++ ){
			ModLoader.addRecipe( new ItemStack( ItemManager.Arrowhead, TerraBowSettings.ArrowHeadsFromBones, 1 ), new Object[] { "a", "b", Character.valueOf( 'b' ), new ItemStack( Item.bone, 1 ), Character.valueOf( 'a' ), new ItemStack( TFC.Core.Recipes.Knives[i], 1, 32767 ) } );
			ModLoader.addRecipe( new ItemStack( ItemManager.SwimBladder, 1, 0 ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( Item.fishRaw ), Character.valueOf( 'b' ), new ItemStack( TFC.Core.Recipes.Knives[i], 1, 32767 ) } );
		}
		//Arrows
		for( int i = 0; i < TerraBowSettings.UniqueArrows; i++ ){
			ModLoader.addRecipe( new ItemStack( ItemManager.Arrow, 1, i ), new Object[] { " a ", " b ", " cd", Character.valueOf( 'a' ), new ItemStack( ItemManager.Arrowhead, 1, i ), Character.valueOf( 'b' ), new ItemStack( ItemManager.FootedShaft ), Character.valueOf( 'c' ), new ItemStack( Item.feather ), Character.valueOf( 'd' ), new ItemStack( ItemManager.GlueBottle, 1, 32767 ) } );
		}
		
		ModLoader.addRecipe( new ItemStack( ItemManager.SwimBladderBottle, 1, 0 ), new Object[] { "a", "b", Character.valueOf( 'b' ), new ItemStack( ItemManager.SwimBladder ), Character.valueOf( 'a' ), new ItemStack( Item.potion ) } );

		ModLoader.addRecipe( new ItemStack( ItemManager.PrimitiveBow, 1, 0 ), new Object[] { " ab", "a b", " ab", Character.valueOf( 'a' ), new ItemStack( Item.stick ), Character.valueOf( 'b' ), new ItemStack( Item.silk ) } );
		ModLoader.addRecipe( new ItemStack( ItemManager.PrimitiveBow, 1, 0 ), new Object[] { " ab", "a b", " ab", Character.valueOf( 'a' ), new ItemStack( Item.stick ), Character.valueOf( 'b' ), new ItemStack( TFCItems.WoolYarn, 1 ) } );

		//Longbow Bodies
		for( int i = 0; i < TFC.Core.Recipes.Saws.length; i++ ){
			for( int j = 0; j < PlankType.length; j++ ){
				ModLoader.addRecipe( new ItemStack( ItemManager.LongbowBody, 1, j ), new Object[] { "a", "b", "b", Character.valueOf( 'a' ), new ItemStack( TFC.Core.Recipes.Saws[i], 1, 32767 ), Character.valueOf( 'b' ), new ItemStack( TFC.TFCItems.Logs, 1, j ) } );
			}
		}
		
		//Longbows
		for( int i = 0; i < PlankType.length; i++ ){
			for( int j = 0; j < planeArray.length; j++ ){
				ModLoader.addRecipe( new ItemStack( ItemManager.Longbow, 1, RecipeManager.GetLongBowDamage( i ) ), new Object[] { "  a", "cba", "  a", Character.valueOf( 'a' ), new ItemStack( Item.silk ), Character.valueOf( 'b' ), new ItemStack( ItemManager.LongbowBody, 1, i ), Character.valueOf( 'c' ), new ItemStack( planeArray[j], 1, 32767 ) } );
				ModLoader.addRecipe( new ItemStack( ItemManager.Longbow, 1, RecipeManager.GetLongBowDamage( i ) ), new Object[] { "  a", "cba", "  a", Character.valueOf( 'a' ), new ItemStack( TFCItems.WoolYarn, 1 ), Character.valueOf( 'b' ), new ItemStack( ItemManager.LongbowBody, 1, i ), Character.valueOf( 'c' ), new ItemStack( planeArray[j], 1, 32767 ) } );
			}
		}
		
		//Finished Shafts from Rough Shafts using Planes
		for( int i = 0; i < planeArray.length; i++ ){
			for( int j = 0; j < PlankType.length; j++ ){
				ModLoader.addRecipe( new ItemStack( ItemManager.FinishedWoodShaft, 1, j ), new Object[] { "a", "b", Character.valueOf( 'a' ), new ItemStack( planeArray[i], 1, 32767 ), Character.valueOf( 'b' ), new ItemStack( ItemManager.RoughWoodShaft, 1, j ) } );
			}
		}
		
		//Composite Bow
		for( int i = 0; i < PlankType.length; i++ ){
			for( int j = 0; j < PlankType.length; j++ ){
				if( i != j ){
					ModLoader.addRecipe( new ItemStack( ItemManager.CompositeBow, 1, GetCompositeDamage( j, i ) ), new Object[] { " ab", "cdb", "eab", Character.valueOf( 'a' ), new ItemStack( ItemManager.FinishedWoodShaft, 1, j ), Character.valueOf( 'b' ), new ItemStack( Item.silk, 1 ), Character.valueOf( 'c' ), new ItemStack( ItemManager.FinishedWoodShaft, 1, i ), Character.valueOf( 'd' ), new ItemStack( TFCItems.TerraLeather, 1 ), Character.valueOf( 'e' ), new ItemStack( ItemManager.GlueBottle, 1, 32767 ) } );
					ModLoader.addRecipe( new ItemStack( ItemManager.CompositeBow, 1, GetCompositeDamage( j, i ) ), new Object[] { " ab", "cdb", "eab", Character.valueOf( 'a' ), new ItemStack( ItemManager.FinishedWoodShaft, 1, j ), Character.valueOf( 'b' ), new ItemStack( TFCItems.WoolYarn, 1 ), Character.valueOf( 'c' ), new ItemStack( ItemManager.FinishedWoodShaft, 1, i ), Character.valueOf( 'd' ), new ItemStack( TFCItems.TerraLeather, 1 ), Character.valueOf( 'e' ), new ItemStack( ItemManager.GlueBottle, 1, 32767 ) } );
				}
			}
		}
	}
	public static void RegisterAnvilRecipes(){
		AnvilCraftingManagerTFC anvilManager = AnvilCraftingManagerTFC.getInstance();
		
		//Plane Blades
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BismuthIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeBismuth, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BismuthBronzeIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.BISMUTHBRONZE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeBismuthBronze, 1,0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BlackBronzeIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.BLACKBRONZE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeBlackBronze, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BlackSteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.BLACKSTEEL, new ItemStack( terrabow.manager.ItemManager.PlaneBladeBlackSteel, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BlueSteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.BLUESTEEL, new ItemStack( terrabow.manager.ItemManager.PlaneBladeBlueSteel, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BronzeIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.BRONZE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeBronze, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.CopperIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.COPPER, new ItemStack( terrabow.manager.ItemManager.PlaneBladeCopper, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.WroughtIronIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.WROUGHTIRON, new ItemStack( terrabow.manager.ItemManager.PlaneBladeWroughtIron, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.RedSteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.REDSTEEL, new ItemStack( terrabow.manager.ItemManager.PlaneBladeRedSteel, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.RoseGoldIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.BRONZE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeRoseGold, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.SteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.STEEL, new ItemStack( terrabow.manager.ItemManager.PlaneBladeSteel, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.TinIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeTin, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.ZincIngot ), new ItemStack( terrabow.manager.ItemManager.PlanPlaneBlade ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.PUNCHLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.PlaneBladeZinc, 1, 0 ) ) );
		
		//Metal Rods
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BismuthIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 0 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BismuthBronzeIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BISMUTHBRONZE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 1 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BlackBronzeIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BLACKBRONZE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 2 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BlackSteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BLACKSTEEL, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 3 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BlueSteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BLUESTEEL, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 4 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.BronzeIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BRONZE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 5 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.CopperIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.COPPER, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 6 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.WroughtIronIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.WROUGHTIRON, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 7 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.RedSteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.REDSTEEL, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 8 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.RoseGoldIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BRONZE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 9 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.SteelIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STEEL, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 10 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.TinIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 11 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( TFCItems.ZincIngot ), new ItemStack( terrabow.manager.ItemManager.PlanMetalRod ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.HITSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.MetalRod, 1, 12 ) ) );
		
		//Arrowheads
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 0 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 2 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 1 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BISMUTHBRONZE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 3 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 2 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BLACKBRONZE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 4 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 3 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BLACKSTEEL, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 5 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 4 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BLUESTEEL, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 6 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 5 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BRONZE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 7 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 6 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.COPPER, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 8 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 7 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.WROUGHTIRON, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 9 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 8 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.REDSTEEL, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 10 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 9 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.BRONZE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 11 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 10 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STEEL, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 12 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 11 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 13 ) ) );
		anvilManager.addRecipe( new AnvilRecipe( new ItemStack( ItemManager.MetalRod, 1, 12 ), new ItemStack( terrabow.manager.ItemManager.PlanArrowHead ), 10, CraftingRuleEnum.DRAWTHIRDFROMLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.HITLAST, false, AnvilReq.STONE, new ItemStack( terrabow.manager.ItemManager.Arrowhead, (int) Math.floor( TerraBowSettings.ArrowHeadsFromRods ), 14 ) ) );
	}
	public static void RegisterKnappingRecipes() {
		CraftingManagerTFC craftingManager = CraftingManagerTFC.getInstance();
		
		//Stone Arrowhead
		craftingManager.addRecipe( new ItemStack( ItemManager.Arrowhead, TerraBowSettings.ArrowHeadsFromKnapping, 0 ), new Object[] { "  #  ", " ### ", "#####", "#####", " ### ", Character.valueOf( '#' ), new ItemStack( TFC.TFCItems.FlatRock, 1, 32767 ) } );
		
		//Plane Blade Plan
		craftingManager.addRecipe( new ItemStack( ItemManager.PlanPlaneBlade, 1 ), new Object[] { "  ###", "  ###", "  ###", " ### ", "###  ", Character.valueOf( '#' ), TFCItems.Ink } );
		
		//Metal Rod Plan
		craftingManager.addRecipe( new ItemStack( ItemManager.PlanMetalRod, 1 ), new Object[] { "##   ", "##   ", "##   ", "##   ", "##   ", Character.valueOf( '#' ), TFCItems.Ink } );

		//Arrowhead Plan
		craftingManager.addRecipe( new ItemStack( ItemManager.PlanArrowHead, 1 ), new Object[] { "  #  ", " ### ", "#####", "#####", " ### ", Character.valueOf( '#' ), TFCItems.Ink } );
	}
	public static void RegisterItemHeat(){
		HeatManager heatManager = HeatManager.getInstance();
		
		HeatRaw rawBismuth = 		new HeatRaw( 0.70f,  271f, 1564f );
		HeatRaw rawBismuthBronze =	new HeatRaw( 0.65f,  985f, 1941f );
		HeatRaw rawBlackBronze = 	new HeatRaw( 0.70f, 1070f, 2219f );
		HeatRaw rawBlackSteel =	 	new HeatRaw( 0.66f, 1485f, 2726f );
		HeatRaw rawBlueSteel = 		new HeatRaw( 0.63f, 1540f, 3460f );
		HeatRaw rawBronze = 		new HeatRaw( 0.68f,  950f, 2380f );
		HeatRaw rawCopper = 		new HeatRaw( 0.70f, 1084f );
		HeatRaw rawWroughtIron =	new HeatRaw( 0.67f, 1536f );
		HeatRaw rawRedSteel = 		new HeatRaw( 0.63f, 1540f, 3589f );
		HeatRaw rawRoseGold = 		new HeatRaw( 0.69f,  960f, 2650f );
		HeatRaw rawSteel = 			new HeatRaw( 0.66f, 1540f, 3500f );
		HeatRaw rawTin = 			new HeatRaw( 0.69f, 232f );
		HeatRaw rawZinc = 			new HeatRaw( 0.66f, 420f, 907f );
		
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 0 ), rawBismuth, new ItemStack( TFCItems.BismuthUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 1 ), rawBismuthBronze, new ItemStack( TFCItems.BismuthBronzeUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 2 ), rawBlackBronze, new ItemStack( TFCItems.BlackBronzeUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 3 ), rawBlackSteel, new ItemStack( TFCItems.BlackSteelUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 4 ), rawBlueSteel, new ItemStack( TFCItems.BlueSteelUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 5 ), rawBronze, new ItemStack( TFCItems.BronzeUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 6 ), rawCopper, new ItemStack( TFCItems.CopperUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 7 ), rawWroughtIron, new ItemStack( TFCItems.WroughtIronUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 8 ), rawRedSteel, new ItemStack( TFCItems.RedSteelUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 9 ), rawRoseGold, new ItemStack( TFCItems.RoseGoldUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 10 ), rawSteel, new ItemStack( TFCItems.SteelUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 11 ), rawTin, new ItemStack( TFCItems.TinUnshaped, 1 ) ) );
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.MetalRod, 1, 12 ), rawZinc, new ItemStack( TFCItems.ZincUnshaped, 1 ) ) );
		
		heatManager.addIndex( new HeatIndex( new ItemStack( ItemManager.SwimBladderBottle, 1 ), 0.15f, 100.0f, 425f, new ItemStack( ItemManager.GlueBottle, 1 ) ) );
	}
	public static int GetLongBowDamage( int woodIndex ){
		return  TerraBowSettings.LongbowDurability - (int) ( TerraBowSettings.WoodStrength[woodIndex] * (double) TerraBowSettings.LongbowDurability  );
	}
	public static int GetCompositeDamage( int limbIndex, int bodyIndex ){
		float damageRatio = ( (float) TerraBowSettings.WoodStrength[limbIndex] * 2.0f + (float) TerraBowSettings.WoodStrength[bodyIndex] ) / 3;
		
		return TerraBowSettings.CompositeBowDurability - (int) ( (float) TerraBowSettings.CompositeBowDurability * damageRatio );
	}
}
