package ikreg.roads;

import java.util.Random;

import ikreg.roads.entity.EntityTestCar;
import ikreg.roads.init.Blocks;
import ikreg.roads.init.Items;
import ikreg.roads.proxy.CommonProxy;
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
		Items.init(event);
		Items.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		proxy.registerRenders();
		//EntityCreator.createEntity(EntityTestCar.class, new RenderTestCar(), "TestCar", EnumCreatureType.CREATURE, 0xFF00FB, 0xD69D00, true);
		//EntityRegistry.registerModEntity(EntityTestCar.class, "TestCar", 0, this, 0, 1, false, 3, 2);
	
		registerEntity(EntityTestCar.class, "Car");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	//FIXME: Deprecated API usage
	public static void registerEntity(Class entityClass, String name) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = name.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
	}
}
