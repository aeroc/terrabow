package terrabow;

import net.minecraftforge.common.Configuration;

public class TerraBowSettings {
	
	public static String[] ArrowheadNames = new String[] {  "Stone", "Bone", "Bismuth", "Bismuth Bronze", "Black Bronze", "Black Steel", "Blue Steel", "Bronze",
															"Copper", "Iron", "Red Steel", "Rose Gold", "Steel", "Tin", "Zinc" };
	public static int UniqueArrows = ArrowheadNames.length;

	public static int ArrowHeadsFromBones = 2;
	public static int ArrowHeadsFromKnapping = 2;
	public static int ArrowHeadsFromRods = 16;
	public static int GlueBottleMaxUses = 256;
	
	//Stack limits
	public static int StackLimitArrows = 32;
	public static int StackLimitMetalRods = 4;
	public static int StackLimitArrowHeads = 32;
	public static int StackLimitWoodShafts = 16;
	public static int StackLimitFootedShafts = 32;
	public static int StackLimitPlaneBlades = 4;
	public static int StackLimitSwimBladders = 32;
	public static int StackLimitSwimBladderBottles = 8;
	
	public static double BowConditionArrowSpeedRatio = 0.5d;
	public static double BowConditionArrowDamageRatio = 0.8d;
	
	public static double StoneArrowDamage = 45.0d;
	public static double BoneArrowDamage = 35.0d;
	public static double BismuthArrowDamage = 50.0d; 
	public static double BismuthBronzeArrowDamage = 88.0d;
	public static double BlackBronzeArrowDamage = 88.0d;
	public static double BlackSteelArrowDamage = 175.0d;
	public static double BlueSteelArrowDamage = 250.0d;
	public static double BronzeArrowDamage = 88.0d;
	public static double CopperArrowDamage = 75.0d;
	public static double IronArrowDamage = 100.0d;
	public static double RedSteelArrowDamage = 250.0d;
	public static double RoseGoldArrowDamage = 88.0d;
	public static double SteelArrowDamage = 125.0d;
	public static double TinArrowDamage = 50.0d;
	public static double ZincArrowDamage = 50.0d;
	
	public static int PrimitiveBowDurability = 50;
	public static double PrimitiveBowVelocityModifier = 1.5d; //2.0f Vanilla default
	public static double PrimitiveBowAccuracyModifier = 0.015d; //0.007499999832361937D Vanilla default
	
	public static int LongbowDurability = 250;
	public static double LongbowVelocityModifier = 2.0d;
	public static double LongbowAccuracyModifier = 0.01d;
	
	public static int CompositeBowDurability = 500;
	public static double CompositeBowVelocityModifier = 2.2d;
	public static double CompositeBowAccuracyModifier = 0.007d;
	
	public static double[] WoodStrength = new double[] { 	0.8d,	//Oak
															0.2d,	//Aspen
															0.8d,	//Birch
															0.2d,	//Chestnut
															0.5d,	//Douglas Fir 	Soft
															0.9d,	//Hickory
															0.8d,	//Maple
															0.7d,	//Ash
															0.2d,	//Pine			Soft
															0.2d,	//Sequoia		Soft
															0.2d,	//Spruce		Soft
															0.5d,	//Sycamore
															0.2d,	//White Cedar	Soft
															1.0d,	//White Elm
															0.2d,	//Willow
															0.7d };	//Kapok
	
	//Item IDs
	public static int RoughWoodShaftID = 10800;
	public static int RoughFootedShaftID = 10801;
	public static int FootedShaftID = 10802;
    public static int FinishedWoodShaftID = 10803;
    
	public static int HandPlaneBismuthID = 10804;
    public static int HandPlaneBismuthBronzeID = 10805;
    public static int HandPlaneBlackBronzeID = 10806;
    public static int HandPlaneBlackSteelID = 10807;
    public static int HandPlaneBlueSteelID = 10808;
    public static int HandPlaneBronzeID = 10809;
    public static int HandPlaneCopperID = 10810;
    public static int HandPlaneWroughtIronID = 10811;
    public static int HandPlaneRedSteelID = 10812;
    public static int HandPlaneRoseGoldID = 10813;
    public static int HandPlaneSteelID = 10814;
    public static int HandPlaneTinID = 10815;
    public static int HandPlaneZincID = 10816;
    
    public static int PlanPlaneBladeID = 10817;
    public static int PlanMetalRodID = 10818;
    public static int PlanArrowHeadID = 10819;
    
    public static int PlaneBladeBismuthID = 10820;
    public static int PlaneBladeBismuthBronzeID = 10821;
    public static int PlaneBladeBlackBronzeID = 10822;
    public static int PlaneBladeBlackSteelID = 10823;
    public static int PlaneBladeBlueSteelID = 10824;
    public static int PlaneBladeBronzeID = 10825;
    public static int PlaneBladeCopperID = 10826;
    public static int PlaneBladeWroughtIronID = 10827;
    public static int PlaneBladeRedSteelID = 10828;
    public static int PlaneBladeRoseGoldID = 10829;
    public static int PlaneBladeSteelID = 10830;
    public static int PlaneBladeTinID = 10831;
    public static int PlaneBladeZincID = 10832;
    
    
    public static int ArrowHeadID = 10833;

    public static int MetalRodID = 10834;
    
    public static int ArrowID = 10861;
    
    public static int SwimBladderID = 10876;
    public static int SwimBladderBottleID = 10877;
    public static int GlueBottleID = 10878;
    
    public static int PrimitiveBowID = 10879;
    public static int LongbowID = 10880;
    public static int CompositeBowID = 10881;
    
    public static int LongbowBodyID = 10882;
	
	
	public static void config( Configuration config ){
		//Arrowhead Settings
		ArrowHeadsFromBones = config.get( "Arrow Head Settings", "ArrowHeadsFromBones", ArrowHeadsFromBones ).getInt();
		ArrowHeadsFromKnapping = config.get( "Arrow Head Settings", "ArrowHeadsFromKnapping", ArrowHeadsFromKnapping ).getInt();
		ArrowHeadsFromRods = config.get( "Arrow Head Settings", "ArrowHeadsFromRods", ArrowHeadsFromRods ).getInt();
		
		//Miscellaneous
		GlueBottleMaxUses = config.get( "Miscellaneous", "GlueBottleMaxUses", GlueBottleMaxUses ).getInt();
		BowConditionArrowSpeedRatio = config.get( "Miscellaneous", "BowConditionAffectsArrowSpeedRatio", BowConditionArrowSpeedRatio ).getDouble( BowConditionArrowSpeedRatio );
		BowConditionArrowDamageRatio = config.get( "Miscellaneous", "BowConditionAffectsArrowDamageRatio", BowConditionArrowDamageRatio ).getDouble( BowConditionArrowDamageRatio );
		
		//Stack Limits
		StackLimitMetalRods = config.get( "Stack Limits", "StackLimitMetalRods", StackLimitMetalRods ).getInt();
		StackLimitArrows = config.get( "Stack Limits", "StackLimitArrows", StackLimitArrows ).getInt();
		StackLimitArrowHeads = config.get( "Stack Limits", "StackLimitArrowHeads", StackLimitArrowHeads ).getInt();
		StackLimitWoodShafts = config.get( "Stack Limits", "StackLimitWoodShafts", StackLimitWoodShafts ).getInt();
		StackLimitFootedShafts = config.get( "Stack Limits", "StackLimitFootedShafts", StackLimitFootedShafts ).getInt();
		StackLimitPlaneBlades = config.get( "Stack Limits", "StackLimitPlaneBlades", StackLimitPlaneBlades ).getInt();
		StackLimitSwimBladders = config.get( "Stack Limits", "StackLimitSwimBladders", StackLimitSwimBladders ).getInt();
		StackLimitSwimBladderBottles = config.get( "Stack Limits", "StackLimitSwimBladderBottles", StackLimitSwimBladderBottles ).getInt();
		
		//Bow max durability
		StoneArrowDamage = config.get( "Arrow Damage", "StoneArrowDamage", StoneArrowDamage ).getDouble( StoneArrowDamage );
		BoneArrowDamage = config.get( "Arrow Damage", "BoneArrowDamage", BoneArrowDamage ).getDouble( BoneArrowDamage );
		BismuthArrowDamage = config.get( "Arrow Damage", "BismuthArrowDamage", BismuthArrowDamage ).getDouble( BismuthArrowDamage );
		BismuthBronzeArrowDamage = config.get( "Arrow Damage", "BismuthBronzeArrowDamage", BismuthBronzeArrowDamage ).getDouble( BismuthBronzeArrowDamage );
		BlackBronzeArrowDamage = config.get( "Arrow Damage", "BlackBronzeArrowDamage", BlackBronzeArrowDamage ).getDouble( BlackBronzeArrowDamage );
		BlackSteelArrowDamage = config.get( "Arrow Damage", "BlackSteelArrowDamage", BlackSteelArrowDamage ).getDouble( BlackSteelArrowDamage );
		BlueSteelArrowDamage = config.get( "Arrow Damage", "BlueSteelArrowDamage", BlueSteelArrowDamage ).getDouble( BlueSteelArrowDamage );
		BronzeArrowDamage = config.get( "Arrow Damage", "BronzeArrowDamage", BronzeArrowDamage ).getDouble( BronzeArrowDamage );
		CopperArrowDamage = config.get( "Arrow Damage", "CopperArrowDamage", CopperArrowDamage ).getDouble( CopperArrowDamage );
		IronArrowDamage = config.get( "Arrow Damage", "IronArrowDamage", IronArrowDamage ).getDouble( IronArrowDamage );
		RedSteelArrowDamage = config.get( "Arrow Damage", "RedSteelArrowDamage", RedSteelArrowDamage ).getDouble( RedSteelArrowDamage );
		RoseGoldArrowDamage = config.get( "Arrow Damage", "RoseGoldArrowDamage", RoseGoldArrowDamage ).getDouble( RoseGoldArrowDamage );
		SteelArrowDamage = config.get( "Arrow Damage", "SteelArrowDamage", SteelArrowDamage ).getDouble( SteelArrowDamage );
		TinArrowDamage = config.get( "Arrow Damage", "TinArrowDamage", TinArrowDamage ).getDouble( TinArrowDamage );
		ZincArrowDamage = config.get( "Arrow Damage", "ZincArrowDamage", ZincArrowDamage ).getDouble( ZincArrowDamage );
		
		//Primitive Bow
		PrimitiveBowDurability = config.get( "Primitive Bow", "PrimitiveBowDurability", PrimitiveBowDurability ).getInt();
		PrimitiveBowVelocityModifier = config.get( "Primitive Bow", "PrimitiveBowVelocityModifier", PrimitiveBowVelocityModifier ).getDouble( PrimitiveBowVelocityModifier );
		PrimitiveBowAccuracyModifier = config.get( "Primitive Bow", "PrimitiveBowAccuracyModifier", PrimitiveBowAccuracyModifier ).getDouble( PrimitiveBowAccuracyModifier );

		//Longbow
		LongbowDurability = config.get( "Longbow", "LongbowDurability", LongbowDurability ).getInt();
		LongbowVelocityModifier = config.get( "Longbow", "LongbowVelocityModifier", LongbowVelocityModifier ).getDouble( LongbowVelocityModifier );
		LongbowAccuracyModifier = config.get( "Longbow", "LongbowAccuracyModifier", LongbowAccuracyModifier ).getDouble( LongbowAccuracyModifier );
		
		//Composite Bow
		CompositeBowDurability = config.get( "Composite Bow", "CompositeBowDurability", CompositeBowDurability ).getInt();
		CompositeBowVelocityModifier = config.get( "Composite Bow", "CompositeBowVelocityModifier", CompositeBowVelocityModifier ).getDouble( CompositeBowVelocityModifier );
		CompositeBowAccuracyModifier = config.get( "Composite Bow", "CompositeBowAccuracyModifier", CompositeBowAccuracyModifier ).getDouble( CompositeBowAccuracyModifier );

		//Wood Strength
		WoodStrength[0] = config.get( "Wood Strength", "OakStrength", WoodStrength[0] ).getDouble( WoodStrength[0] );
		WoodStrength[1] = config.get( "Wood Strength", "AspenStrength", WoodStrength[1] ).getDouble( WoodStrength[1] );
		WoodStrength[2] = config.get( "Wood Strength", "BirchStrength", WoodStrength[2] ).getDouble( WoodStrength[2] );
		WoodStrength[3] = config.get( "Wood Strength", "ChestnutStrength", WoodStrength[3] ).getDouble( WoodStrength[3] );
		WoodStrength[4] = config.get( "Wood Strength", "DouglasFirStrength", WoodStrength[4] ).getDouble( WoodStrength[4] );
		WoodStrength[5] = config.get( "Wood Strength", "HickoryStrength", WoodStrength[5] ).getDouble( WoodStrength[5] );
		WoodStrength[6] = config.get( "Wood Strength", "MapleStrength", WoodStrength[6] ).getDouble( WoodStrength[6] );
		WoodStrength[7] = config.get( "Wood Strength", "AshStrength", WoodStrength[7] ).getDouble( WoodStrength[7] );
		WoodStrength[8] = config.get( "Wood Strength", "PineStrength", WoodStrength[8] ).getDouble( WoodStrength[8] );
		WoodStrength[9] = config.get( "Wood Strength", "SequoiaStrength", WoodStrength[9] ).getDouble( WoodStrength[9] );
		WoodStrength[10] = config.get( "Wood Strength", "SpruceStrength", WoodStrength[10] ).getDouble( WoodStrength[10] );
		WoodStrength[11] = config.get( "Wood Strength", "SycamoreStrength", WoodStrength[11] ).getDouble( WoodStrength[11] );
		WoodStrength[12] = config.get( "Wood Strength", "WhiteCedarStrength", WoodStrength[12] ).getDouble( WoodStrength[12] );
		WoodStrength[13] = config.get( "Wood Strength", "WhiteElmStrength", WoodStrength[13] ).getDouble( WoodStrength[13] );
		WoodStrength[14] = config.get( "Wood Strength", "WillowStrength", WoodStrength[14] ).getDouble( WoodStrength[14] );
		WoodStrength[15] = config.get( "Wood Strength", "KapokStrength", WoodStrength[15] ).getDouble( WoodStrength[15] );
		
		RoughWoodShaftID = config.get( "Item IDs", "RoughWoodShaft", RoughWoodShaftID ).getInt();
		RoughFootedShaftID = config.get( "Item IDs", "RoughFootedShaft", RoughFootedShaftID ).getInt();
		FootedShaftID = config.get( "Item IDs", "FootedShaft", FootedShaftID ).getInt();
	    FinishedWoodShaftID = config.get( "Item IDs", "FinishedWoodShaft", FinishedWoodShaftID ).getInt();
		
		//Hand Planes
		HandPlaneBismuthID = config.get( "Item IDs", "HandPlaneBismuth", HandPlaneBismuthID ).getInt();
	    HandPlaneBismuthBronzeID = config.get( "Item IDs", "HandPlaneBismuthBronze", HandPlaneBismuthBronzeID ).getInt();
	    HandPlaneBlackBronzeID = config.get( "Item IDs", "HandPlaneBlackBronze", HandPlaneBlackBronzeID ).getInt();
	    HandPlaneBlackSteelID = config.get( "Item IDs", "HandPlaneBlackSteel", HandPlaneBlackSteelID ).getInt();
	    HandPlaneBlueSteelID = config.get( "Item IDs", "HandPlaneBlueSteel", HandPlaneBlueSteelID ).getInt();
	    HandPlaneBronzeID = config.get( "Item IDs", "HandPlaneBronze", HandPlaneBronzeID ).getInt();
	    HandPlaneCopperID = config.get( "Item IDs", "HandPlaneCopper", HandPlaneCopperID ).getInt();
	    HandPlaneWroughtIronID = config.get( "Item IDs", "HandPlaneWroughtIron", HandPlaneWroughtIronID ).getInt();
	    HandPlaneRedSteelID = config.get( "Item IDs", "HandPlaneRedSteel", HandPlaneRedSteelID ).getInt();
	    HandPlaneRoseGoldID = config.get( "Item IDs", "HandPlaneRoseGold", HandPlaneRoseGoldID ).getInt();
	    HandPlaneSteelID = config.get( "Item IDs", "HandPlaneSteel", HandPlaneSteelID ).getInt();
	    HandPlaneTinID = config.get( "Item IDs", "HandPlaneTin", HandPlaneTinID ).getInt();
	    HandPlaneZincID = config.get( "Item IDs", "HandPlaneZinc", HandPlaneZincID ).getInt();
	    
	    PlanPlaneBladeID = config.get( "Item IDs", "PlanPlaneBlade", PlanPlaneBladeID ).getInt();
	    PlanMetalRodID = config.get( "Item IDs", "PlanMetalRod", PlanMetalRodID ).getInt();
	    PlanArrowHeadID = config.get( "Item IDs", "PlanArrowHead", PlanArrowHeadID ).getInt();
	    
	    PlaneBladeBismuthID = config.get( "Item IDs", "PlaneBladeBismuth", PlaneBladeBismuthID ).getInt();
	    PlaneBladeBismuthBronzeID = config.get( "Item IDs", "PlaneBladeBismuthBronze", PlaneBladeBismuthBronzeID ).getInt();
	    PlaneBladeBlackBronzeID = config.get( "Item IDs", "PlaneBladeBlackBronze", PlaneBladeBlackBronzeID ).getInt();
	    PlaneBladeBlackSteelID = config.get( "Item IDs", "PlaneBladeBlackSteel", PlaneBladeBlackSteelID ).getInt();
	    PlaneBladeBlueSteelID = config.get( "Item IDs", "PlaneBladeBlueSteel", PlaneBladeBlueSteelID ).getInt();
	    PlaneBladeBronzeID = config.get( "Item IDs", "PlaneBladeBronze", PlaneBladeBronzeID ).getInt();
	    PlaneBladeCopperID = config.get( "Item IDs", "PlaneBladeCopper", PlaneBladeCopperID ).getInt();
	    PlaneBladeWroughtIronID = config.get( "Item IDs", "PlaneBladeWroughtIron", PlaneBladeWroughtIronID ).getInt();
	    PlaneBladeRedSteelID = config.get( "Item IDs", "PlaneBladeRedSteel", PlaneBladeRedSteelID ).getInt();
	    PlaneBladeRoseGoldID = config.get( "Item IDs", "PlaneBladeRoseGold", PlaneBladeRoseGoldID ).getInt();
	    PlaneBladeSteelID = config.get( "Item IDs", "PlaneBladeSteel", PlaneBladeSteelID ).getInt();
	    PlaneBladeTinID = config.get( "Item IDs", "PlaneBladeTin", PlaneBladeTinID ).getInt();
	    PlaneBladeZincID = config.get( "Item IDs", "PlaneBladeZinc", PlaneBladeZincID ).getInt();
	    
	    ArrowHeadID = config.get( "Item IDs", "ArrowHead", ArrowHeadID ).getInt();
		
	    MetalRodID = config.get( "Item IDs", "MetalRod", MetalRodID ).getInt();
	    
	    ArrowID = config.get( "Item IDs", "Arrow", ArrowID ).getInt();
	    
	    SwimBladderID = config.get( "Item IDs", "SwimBladder", SwimBladderID ).getInt();
	    SwimBladderBottleID = config.get( "Item IDs", "SwimBladderBottle", SwimBladderBottleID ).getInt();
	    GlueBottleID = config.get( "Item IDs", "GlueBottle", GlueBottleID ).getInt();
	    
	    PrimitiveBowID = config.get( "Item IDs", "PrimitiveBow", PrimitiveBowID ).getInt();
	    LongbowID = config.get( "Item IDs", "Longbow", LongbowID ).getInt();
	    CompositeBowID = config.get( "Item IDs", "CompositeBow", CompositeBowID ).getInt();
	    
	    LongbowBodyID = config.get( "Item IDs", "LongbowBody", LongbowBodyID ).getInt();
	}
}
