package terrabow.manager;

import terrabow.TerraBowSettings;
import terrabow.item.ItemArrowHead;
import terrabow.item.ItemCompositeBow;
import terrabow.item.ItemFinishedWoodShaft;
import terrabow.item.ItemFootedShaft;
import terrabow.item.ItemGlueBottle;
import terrabow.item.ItemHandPlane;
import terrabow.item.ItemLongbow;
import terrabow.item.ItemLongbowBody;
import terrabow.item.ItemMetalRod;
import terrabow.item.ItemPlaneBlade;
import terrabow.item.ItemPrimitiveBow;
import terrabow.item.ItemRoughFootedShaft;
import terrabow.item.ItemRoughWoodShaft;
import terrabow.item.ItemSwimBladder;
import terrabow.item.ItemSwimBladderBottle;
import terrabow.item.ItemTerraArrow;
import terrabow.item.ItemTerraPlan;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class ItemManager {
    
    public static Item Arrowhead;
    
    public static Item FinishedWoodShaft;
	public static Item FootedShaft;
	public static Item RoughFootedShaft;
	public static Item RoughWoodShaft;

	//Hand Planes
	public static Item HandPlaneBismuth;
    public static Item HandPlaneBismuthBronze;
    public static Item HandPlaneBlackBronze;
    public static Item HandPlaneBlackSteel;
    public static Item HandPlaneBlueSteel;
    public static Item HandPlaneBronze;
    public static Item HandPlaneCopper;
    public static Item HandPlaneWroughtIron;
    public static Item HandPlaneRedSteel;
    public static Item HandPlaneRoseGold;
    public static Item HandPlaneSteel;
    public static Item HandPlaneTin;
    public static Item HandPlaneZinc;
    
    
    //Old versions

	
    
    public static Item PlanPlaneBlade;
    public static Item PlanMetalRod;
    public static Item PlanArrowHead;
    
    public static Item PlaneBladeBismuth;
    public static Item PlaneBladeBismuthBronze;
    public static Item PlaneBladeBlackBronze;
    public static Item PlaneBladeBlackSteel;
    public static Item PlaneBladeBlueSteel;
    public static Item PlaneBladeBronze;
    public static Item PlaneBladeCopper;
    public static Item PlaneBladeWroughtIron;
    public static Item PlaneBladeRedSteel;
    public static Item PlaneBladeRoseGold;
    public static Item PlaneBladeSteel;
    public static Item PlaneBladeTin;
    public static Item PlaneBladeZinc;
	
    public static Item MetalRod;
    
    public static Item Arrow;
    
    public static Item SwimBladder;
    public static Item SwimBladderBottle;
    public static Item GlueBottle;
    
    public static Item PrimitiveBow;
    public static Item Longbow;
    public static Item CompositeBow;
    
    public static Item LongbowBody;
    
	public static void SetItems(){
		ItemManager.Arrowhead = new ItemArrowHead( TerraBowSettings.ArrowHeadID ).setUnlocalizedName( "ArrowHead" );
		
		ItemManager.FinishedWoodShaft = new ItemFinishedWoodShaft( TerraBowSettings.FinishedWoodShaftID ).setUnlocalizedName( "FinishedWoodShaft" );
		ItemManager.FootedShaft = new ItemFootedShaft( TerraBowSettings.FootedShaftID ).setUnlocalizedName( "FootedShaft" );
		ItemManager.RoughFootedShaft = new ItemRoughFootedShaft( TerraBowSettings.RoughFootedShaftID ).setUnlocalizedName( "RoughFootedShaft" );
		ItemManager.RoughWoodShaft = new ItemRoughWoodShaft( TerraBowSettings.RoughWoodShaftID ).setUnlocalizedName( "RoughWoodShaft" );

		ItemManager.SwimBladder = new ItemSwimBladder( TerraBowSettings.SwimBladderID ).setUnlocalizedName( "SwimBladder" );
		ItemManager.SwimBladderBottle = new ItemSwimBladderBottle( TerraBowSettings.SwimBladderBottleID ).setUnlocalizedName( "SwimBladderBottle" );
		ItemManager.GlueBottle = new ItemGlueBottle( TerraBowSettings.GlueBottleID ).setUnlocalizedName( "GlueBottle" );
		
		//Hand Planes
		ItemManager.HandPlaneBismuth = new ItemHandPlane( TerraBowSettings.HandPlaneBismuthID, TFC.TFCItems.BismuthToolMaterial ).setUnlocalizedName( "HandPlaneBismuth" );
		ItemManager.HandPlaneBismuthBronze = new ItemHandPlane( TerraBowSettings.HandPlaneBismuthBronzeID, TFC.TFCItems.BismuthBronzeToolMaterial ).setUnlocalizedName( "HandPlaneBismuthBronze" );
		ItemManager.HandPlaneBlackBronze = new ItemHandPlane( TerraBowSettings.HandPlaneBlackBronzeID, TFC.TFCItems.BlackBronzeToolMaterial ).setUnlocalizedName( "HandPlaneBlackBronze" );
		ItemManager.HandPlaneBlackSteel = new ItemHandPlane( TerraBowSettings.HandPlaneBlackSteelID, TFC.TFCItems.BlackSteelToolMaterial ).setUnlocalizedName( "HandPlaneBlackSteel" );
		ItemManager.HandPlaneBlueSteel = new ItemHandPlane( TerraBowSettings.HandPlaneBlueSteelID, TFC.TFCItems.BlueSteelToolMaterial ).setUnlocalizedName( "HandPlaneBlueSteel" );
		ItemManager.HandPlaneBronze = new ItemHandPlane( TerraBowSettings.HandPlaneBronzeID, TFC.TFCItems.BronzeToolMaterial ).setUnlocalizedName( "HandPlaneBronze" );
		ItemManager.HandPlaneCopper = new ItemHandPlane( TerraBowSettings.HandPlaneCopperID, TFC.TFCItems.CopperToolMaterial ).setUnlocalizedName( "HandPlaneCopper" );
		ItemManager.HandPlaneWroughtIron = new ItemHandPlane( TerraBowSettings.HandPlaneWroughtIronID, TFC.TFCItems.IronToolMaterial ).setUnlocalizedName( "HandPlaneIron" );
		ItemManager.HandPlaneRedSteel = new ItemHandPlane( TerraBowSettings.HandPlaneRedSteelID, TFC.TFCItems.RedSteelToolMaterial ).setUnlocalizedName( "HandPlaneRedSteel" );
		ItemManager.HandPlaneRoseGold = new ItemHandPlane( TerraBowSettings.HandPlaneRoseGoldID, TFC.TFCItems.RoseGoldToolMaterial ).setUnlocalizedName( "HandPlaneRoseGold" );
		ItemManager.HandPlaneSteel = new ItemHandPlane( TerraBowSettings.HandPlaneSteelID, TFC.TFCItems.SteelToolMaterial ).setUnlocalizedName( "HandPlaneSteel" );
		ItemManager.HandPlaneTin = new ItemHandPlane( TerraBowSettings.HandPlaneTinID, TFC.TFCItems.TinToolMaterial ).setUnlocalizedName( "HandPlaneTin" );
		ItemManager.HandPlaneZinc = new ItemHandPlane( TerraBowSettings.HandPlaneZincID, TFC.TFCItems.ZincToolMaterial ).setUnlocalizedName( "HandPlaneZinc" );
		
		//Plans
		ItemManager.PlanPlaneBlade = new ItemTerraPlan( TerraBowSettings.PlanPlaneBladeID ).setUnlocalizedName( "PlaneBladePlan" );
		ItemManager.PlanMetalRod = new ItemTerraPlan( TerraBowSettings.PlanMetalRodID ).setUnlocalizedName( "MetalRodPlan" );
		ItemManager.PlanArrowHead = new ItemTerraPlan( TerraBowSettings.PlanArrowHeadID ).setUnlocalizedName( "ArrowheadPlan" );
		
		//Plane Blades
		ItemManager.PlaneBladeBismuth = new ItemPlaneBlade( TerraBowSettings.PlaneBladeBismuthID ).setUnlocalizedName( "BismuthPlaneBlade" );
		ItemManager.PlaneBladeBismuthBronze = new ItemPlaneBlade( TerraBowSettings.PlaneBladeBismuthBronzeID ).setUnlocalizedName( "BismuthBronzePlaneBlade" );
		ItemManager.PlaneBladeBlackBronze = new ItemPlaneBlade( TerraBowSettings.PlaneBladeBlackBronzeID ).setUnlocalizedName( "BlackBronzePlaneBlade" );
		ItemManager.PlaneBladeBlackSteel = new ItemPlaneBlade( TerraBowSettings.PlaneBladeBlackSteelID ).setUnlocalizedName( "BlackSteelPlaneBlade" );
		ItemManager.PlaneBladeBlueSteel = new ItemPlaneBlade( TerraBowSettings.PlaneBladeBlueSteelID ).setUnlocalizedName( "BlueSteelPlaneBlade" );
		ItemManager.PlaneBladeBronze = new ItemPlaneBlade( TerraBowSettings.PlaneBladeBronzeID ).setUnlocalizedName( "BronzePlaneBlade" );
		ItemManager.PlaneBladeCopper = new ItemPlaneBlade( TerraBowSettings.PlaneBladeCopperID ).setUnlocalizedName( "CopperPlaneBlade" );
		ItemManager.PlaneBladeWroughtIron = new ItemPlaneBlade( TerraBowSettings.PlaneBladeWroughtIronID ).setUnlocalizedName( "IronPlaneBlade" );
		ItemManager.PlaneBladeRedSteel = new ItemPlaneBlade( TerraBowSettings.PlaneBladeRedSteelID ).setUnlocalizedName( "RedSteelPlaneBlade" );
		ItemManager.PlaneBladeRoseGold = new ItemPlaneBlade( TerraBowSettings.PlaneBladeRoseGoldID ).setUnlocalizedName( "RoseGoldPlaneBlade" );
		ItemManager.PlaneBladeSteel = new ItemPlaneBlade( TerraBowSettings.PlaneBladeSteelID ).setUnlocalizedName( "SteelPlaneBlade" );
		ItemManager.PlaneBladeTin = new ItemPlaneBlade( TerraBowSettings.PlaneBladeTinID ).setUnlocalizedName( "TinPlaneBlade" );
		ItemManager.PlaneBladeZinc = new ItemPlaneBlade( TerraBowSettings.PlaneBladeZincID ).setUnlocalizedName( "ZincPlaneBlade" );

		ItemManager.MetalRod = new ItemMetalRod( TerraBowSettings.MetalRodID ).setUnlocalizedName( "MetalRod" );

		ItemManager.Arrow = new ItemTerraArrow( TerraBowSettings.ArrowID ).setUnlocalizedName( "TerraArrow" );
		
		ItemManager.PrimitiveBow = new ItemPrimitiveBow( TerraBowSettings.PrimitiveBowID ).setUnlocalizedName( "PrimitiveBow" );
		ItemManager.Longbow = new ItemLongbow( TerraBowSettings.LongbowID ).setUnlocalizedName( "Longbow" );
		ItemManager.CompositeBow = new ItemCompositeBow( TerraBowSettings.CompositeBowID ).setUnlocalizedName( "CompositeBow" );
		
		ItemManager.LongbowBody = new ItemLongbowBody( TerraBowSettings.LongbowBodyID ).setUnlocalizedName( "LongbowBody" );
	}
	public static void RegisterItems(){
		GameRegistry.registerItem( ItemManager.Arrowhead, "itemArrowHead" );
		
		GameRegistry.registerItem( ItemManager.FinishedWoodShaft, "itemFinishedWoodShaft" );
		GameRegistry.registerItem( ItemManager.FootedShaft, "itemFootedShaft" );
		GameRegistry.registerItem( ItemManager.RoughWoodShaft, "itemRoughWoodShaft" );
		GameRegistry.registerItem( ItemManager.RoughFootedShaft, "itemRoughFootedShaft" );
		
		GameRegistry.registerItem( ItemManager.SwimBladder, "itemSwimBladder" );
		GameRegistry.registerItem( ItemManager.SwimBladderBottle, "itemSwimBladderBottle" );
		GameRegistry.registerItem( ItemManager.GlueBottle, "itemGlueBottle" );
		
		//Hand Planes
		GameRegistry.registerItem( ItemManager.HandPlaneBismuth, "itemHandPlaneBismuth" );
		GameRegistry.registerItem( ItemManager.HandPlaneBismuthBronze, "itemHandPlaneBismuthBronze" );
		GameRegistry.registerItem( ItemManager.HandPlaneBlackBronze, "itemHandPlaneBlackBronze" );
		GameRegistry.registerItem( ItemManager.HandPlaneBlackSteel, "itemHandPlaneBlackSteel" );
		GameRegistry.registerItem( ItemManager.HandPlaneBlueSteel, "itemHandPlaneBlueSteel" );
		GameRegistry.registerItem( ItemManager.HandPlaneBronze, "itemHandPlaneBronze" );
		GameRegistry.registerItem( ItemManager.HandPlaneCopper, "itemHandPlaneCopper" );
		GameRegistry.registerItem( ItemManager.HandPlaneWroughtIron, "itemHandPlaneWroughtIron" );
		GameRegistry.registerItem( ItemManager.HandPlaneRedSteel, "itemHandPlaneRedSteel" );
		GameRegistry.registerItem( ItemManager.HandPlaneRoseGold, "itemHandPlaneRoseGold" );
		GameRegistry.registerItem( ItemManager.HandPlaneSteel, "itemHandPlaneSteel" );
		GameRegistry.registerItem( ItemManager.HandPlaneTin, "itemHandPlaneTin" );
		GameRegistry.registerItem( ItemManager.HandPlaneZinc, "itemHandPlaneZinc" );
		
		//Plans
		GameRegistry.registerItem( ItemManager.PlanPlaneBlade, "itemHandPlanePlan" );
		GameRegistry.registerItem( ItemManager.PlanMetalRod, "itemMetalRodPlan" );
		GameRegistry.registerItem( ItemManager.PlanArrowHead, "itemArrowHeadPlan" );
		
		//Plane Blades
		GameRegistry.registerItem( ItemManager.PlaneBladeBismuth, "itemPlaneBladeBismuth" );
		GameRegistry.registerItem( ItemManager.PlaneBladeBismuthBronze, "itemPlaneBladeBismuthBronze" );
		GameRegistry.registerItem( ItemManager.PlaneBladeBlackBronze, "itemPlaneBladeBlackBronze" );
		GameRegistry.registerItem( ItemManager.PlaneBladeBlackSteel, "itemPlaneBladeBlackSteel" );
		GameRegistry.registerItem( ItemManager.PlaneBladeBlueSteel, "itemPlaneBladeBlueSteel" );
		GameRegistry.registerItem( ItemManager.PlaneBladeBronze, "itemPlaneBladeBronze" );
		GameRegistry.registerItem( ItemManager.PlaneBladeCopper, "itemPlaneBladeCopper" );
		GameRegistry.registerItem( ItemManager.PlaneBladeWroughtIron, "itemPlaneBladeWroughtIron" );
		GameRegistry.registerItem( ItemManager.PlaneBladeRedSteel, "itemPlaneBladeRedSteel" );
		GameRegistry.registerItem( ItemManager.PlaneBladeRoseGold, "itemPlaneBladeRoseGold" );
		GameRegistry.registerItem( ItemManager.PlaneBladeSteel, "itemPlaneBladeSteel" );
		GameRegistry.registerItem( ItemManager.PlaneBladeTin, "itemPlaneBladeTin" );
		GameRegistry.registerItem( ItemManager.PlaneBladeZinc, "itemPlaneBladeZinc" );
		
		GameRegistry.registerItem( ItemManager.MetalRod, "itemMetalRod" );

		GameRegistry.registerItem( ItemManager.Arrow, "itemArrow" );
		
		GameRegistry.registerItem( ItemManager.PrimitiveBow, "itemPrimitiveBow" );
		GameRegistry.registerItem( ItemManager.Longbow, "itemLongbow" );
		GameRegistry.registerItem( ItemManager.CompositeBow, "itemCompositeBow" );
		
		GameRegistry.registerItem( ItemManager.LongbowBody, "itemLongbowBody" );
	}
	public static void RegisterItemNames(){
		//Arrowheads
		ItemArrowHead arrowHead = (ItemArrowHead) ItemManager.Arrowhead;
		for( int i = 0; i < arrowHead.MetaNames.length; i++ ){
			String key = "item.ArrowHead." + arrowHead.MetaNames[i] + ".name";
			String value = arrowHead.MetaNames[i] + " Arrowhead";
			LanguageRegistry.instance().addStringLocalization( key, value );
		}
		
		//Finished Wood Shaft
		ItemFinishedWoodShaft finishedWoodShaft = (ItemFinishedWoodShaft) ItemManager.FinishedWoodShaft;
		for( int i = 0; i < finishedWoodShaft.MetaNames.length; i++ ){
			String key = "item.FinishedWoodShaft." + finishedWoodShaft.MetaNames[i] + ".name";
			String value = "Finished " + finishedWoodShaft.MetaNames[i] + " Shaft";
			LanguageRegistry.instance().addStringLocalization( key, value );
		}
		
		LanguageRegistry.addName( ItemManager.FootedShaft, "Footed Shaft" );
		
		LanguageRegistry.addName( ItemManager.GlueBottle, "Glue Bottle" );
		
		LanguageRegistry.addName( ItemManager.RoughFootedShaft, "Rough Footed Shaft" );
		
		//Hand Planes
		LanguageRegistry.addName( ItemManager.HandPlaneBismuth, "Bismuth Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneBismuthBronze, "Bismuth Bronze Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneBlackBronze, "Black Bronze Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneBlackSteel, "Black Steel Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneBlueSteel, "Blue Steel Plane " );
		LanguageRegistry.addName( ItemManager.HandPlaneBronze, "Bronze Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneCopper, "Copper Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneWroughtIron, "Wrought Iron Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneRedSteel, "Red Steel Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneRoseGold, "Rose Gold Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneSteel, "Steel Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneTin, "Tin Plane" );
		LanguageRegistry.addName( ItemManager.HandPlaneZinc, "Zinc Plane" );
		
		//Plans
		LanguageRegistry.addName( ItemManager.PlanPlaneBlade, "Plane Blade Plan" );
		LanguageRegistry.addName( ItemManager.PlanMetalRod, "Metal Rod Plan" );
		LanguageRegistry.addName( ItemManager.PlanArrowHead, "Arrowhead Plan" );
		
		//Plane Blades
		LanguageRegistry.addName( ItemManager.PlaneBladeBismuth, "Bismuth Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeBismuthBronze, "Bismuth Bronze Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeBlackBronze, "Black Bronze Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeBlackSteel, "Black Steel Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeBlueSteel, "Blue Steel Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeBronze, "Bronze Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeCopper, "Copper Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeWroughtIron, "Iron Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeRedSteel, "Red Steel Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeRoseGold, "Rose Gold Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeSteel, "Steel Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeTin, "Tin Plane Blade" );
		LanguageRegistry.addName( ItemManager.PlaneBladeZinc, "Zinc Plane Blade" );
//		
		ItemMetalRod metalRod = (ItemMetalRod) ItemManager.MetalRod;
		for( int i = 0; i < metalRod.MetaNames.length; i++ ){
			String key = "item.MetalRod." + metalRod.MetaNames[i] + ".name";
			String value = metalRod.MetaNames[i] + " Rod";
			LanguageRegistry.instance().addStringLocalization( key, value );
		}

		ItemTerraArrow terraArrow = (ItemTerraArrow) ItemManager.Arrow;
		for( int i = 0; i < terraArrow.MetaNames.length; i++ ){
			String key = "item.TerraArrow." + terraArrow.MetaNames[i] + ".name";
			String value = terraArrow.MetaNames[i] + " Arrow";
			LanguageRegistry.instance().addStringLocalization( key, value );
		}

		LanguageRegistry.addName( ItemManager.SwimBladder, "Swim Bladder" );
		LanguageRegistry.addName( ItemManager.SwimBladderBottle, "Swim Bladder Bottle" );

		LanguageRegistry.addName( ItemManager.PrimitiveBow, "Primitive Bow" );
		LanguageRegistry.addName( ItemManager.Longbow, "Longbow" );
		LanguageRegistry.addName( ItemManager.CompositeBow, "Composite Bow" );

		ItemLongbowBody longbowBody = (ItemLongbowBody) ItemManager.LongbowBody;
		for( int i = 0; i < longbowBody.MetaNames.length; i++ ){
			String key = "item.LongbowBody." + longbowBody.MetaNames[i] + ".name";
			String value = longbowBody.MetaNames[i] + " Longbow Body";
			LanguageRegistry.instance().addStringLocalization( key, value );
		}
		
		ItemRoughWoodShaft roughWoodShaft = (ItemRoughWoodShaft) ItemManager.RoughWoodShaft;
		for( int i = 0; i < roughWoodShaft.MetaNames.length; i++ ){
			String key = "item.RoughWoodShaft." + roughWoodShaft.MetaNames[i] + ".name";
			String value = "Rough " + roughWoodShaft.MetaNames[i] + " Shaft";
			LanguageRegistry.instance().addStringLocalization( key, value );
		}
	}
	public static Item[] getPlanes(){
		//Must be in same order as getPlaneBlades
		return new Item[] {	ItemManager.HandPlaneBismuth,
							ItemManager.HandPlaneBismuthBronze,
							ItemManager.HandPlaneBlackBronze,
							ItemManager.HandPlaneBlackSteel,
							ItemManager.HandPlaneBlueSteel,
							ItemManager.HandPlaneBronze,
							ItemManager.HandPlaneCopper,
							ItemManager.HandPlaneRedSteel,
							ItemManager.HandPlaneRoseGold,
							ItemManager.HandPlaneSteel,
							ItemManager.HandPlaneTin,
							ItemManager.HandPlaneWroughtIron,
							ItemManager.HandPlaneZinc };
	}
	public static Item[] getPlaneBlades(){
		//Must be in same order as getPlanes
		return new Item[] { ItemManager.PlaneBladeBismuth,
							ItemManager.PlaneBladeBismuthBronze,
							ItemManager.PlaneBladeBlackBronze,
							ItemManager.PlaneBladeBlackSteel,
							ItemManager.PlaneBladeBlueSteel,
							ItemManager.PlaneBladeBronze,
							ItemManager.PlaneBladeCopper,
							ItemManager.PlaneBladeWroughtIron,
							ItemManager.PlaneBladeRedSteel,
							ItemManager.PlaneBladeRoseGold,
							ItemManager.PlaneBladeSteel,
							ItemManager.PlaneBladeTin,
							ItemManager.PlaneBladeZinc };
	}
}
