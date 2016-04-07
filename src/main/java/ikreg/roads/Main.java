package ikreg.roads;

import ikreg.roads.entity.EntityTestCar;
import ikreg.roads.init.Blocks;
import ikreg.roads.init.Items;
import ikreg.roads.proxy.CommonProxy;
import ikreg.roads.render.RenderTestCar;
import ikreg.roads.util.EntityCreator;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Main {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final RoadsTab tabRoads = new RoadsTab("tabRoads");
	
	@Instance
	public static Main instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		Blocks.init();
		Blocks.register();
		Items.init();
		Items.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		proxy.registerRenders();
		//EntityCreator.createEntity(EntityTestCar.class, new RenderTestCar(), "TestCar", EnumCreatureType.CREATURE, 0xFF00FB, 0xD69D00, true);
		//EntityRegistry.registerModEntity(EntityTestCar.class, "TestCar", 0, this, 0, 1, false, 3, 2);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
