package ikreg.roads.init;

import ikreg.roads.Main;
import ikreg.roads.Reference;
import ikreg.roads.item.ItemCarSpawner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Items {
	
	public static Item carSpawner;

	public static void init(FMLPreInitializationEvent event) {
		if(event.getSide() == Side.CLIENT) {
			carSpawner = new ItemCarSpawner().setCreativeTab(Main.tabRoads);
		}
	}
	public static void register() {
		
		GameRegistry.registerItem(carSpawner, carSpawner.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
	
		registerRender(carSpawner);
	}
	
	public static void registerRender(Item item) {
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	private static void registerRenderer(Item item, String name) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    	renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
	}
}
