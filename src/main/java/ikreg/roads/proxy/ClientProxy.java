package ikreg.roads.proxy;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ikreg.roads.entity.EntityTestCar;
import ikreg.roads.init.Blocks;
import ikreg.roads.init.Items;
import ikreg.roads.model.ModelTestCar;
import ikreg.roads.render.RenderTestCar;

public class ClientProxy extends CommonProxy {
	
		@Override
		public void registerRenders() {
			Items.registerRenders();
			Blocks.registerRenders();
		}
}
