package terrabow.manager;

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
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager {
	
	public static void RegisterGlobalEntityID(){
		EntityRegistry.registerGlobalEntityID( EntityStoneArrow.class, "TerraStoneArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBoneArrow.class, "TerraBoneArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBismuthArrow.class, "TerraBismuthArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBismuthBronzeArrow.class, "TerraBismuthBronzeArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBlackBronzeArrow.class, "TerraBlackBronzeArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBlackSteelArrow.class, "TerraBlackSteelArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBlueSteelArrow.class, "TerraBlueSteelArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityBronzeArrow.class, "TerraBronzeArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityCopperArrow.class, "TerraCopperArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityIronArrow.class, "TerraIronArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityRedSteelArrow.class, "TerraRedSteelArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityRoseGoldArrow.class, "TerraRoseGoldArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntitySteelArrow.class, "TerraSteelArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityTinArrow.class, "TerraTinArrow", EntityRegistry.findGlobalUniqueEntityId() );
		EntityRegistry.registerGlobalEntityID( EntityZincArrow.class, "TerraZincArrow", EntityRegistry.findGlobalUniqueEntityId() );
	}
	public static void RegisterModEntity( Object modObject ){
		EntityRegistry.registerModEntity( EntityStoneArrow.class, "TerraStoneArrow", 1, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBoneArrow.class, "TerraBoneArrow", 2, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBismuthArrow.class, "TerraBismuthArrow", 3, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBismuthBronzeArrow.class, "TerraBismuthBronzeArrow", 4, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBlackBronzeArrow.class, "TerraBlackBronzeArrow", 5, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBlackSteelArrow.class, "TerraBlackSteelArrow", 6, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBlueSteelArrow.class, "TerraBlueSteelArrow", 7, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityBronzeArrow.class, "TerraBronzeArrow", 8, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityCopperArrow.class, "TerraCopperArrow", 9, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityIronArrow.class, "TerraIronArrow", 10, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityRedSteelArrow.class, "TerraRedSteelArrow", 11, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityRoseGoldArrow.class, "TerraRoseGoldArrow", 12, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntitySteelArrow.class, "TerraSteelArrow", 13, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityTinArrow.class, "TerraTinArrow", 14, modObject, 128, 1, true );
		EntityRegistry.registerModEntity( EntityZincArrow.class, "TerraZincArrow", 15, modObject, 128, 1, true );
	}

}
