package ikreg.roads.util;

import ikreg.roads.Main;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityCreator {
	
	public static void createEntity(Class entityClass, Render render, String entityName, EnumCreatureType type, int solidColor, int spotColor, boolean hasSpawnEgg) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityRegistry.registerModEntity(entityClass, entityName, id, Main.instance, 64, 1, true);
		RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
		
		if(hasSpawnEgg) {
			EntityList.entityEggs.put(entityName, new EntityList.EntityEggInfo(entityName, solidColor, spotColor));
		}
	}

}
