package ikreg.roads.init;

import ikreg.roads.Main;
import ikreg.roads.Reference;
import ikreg.roads.blocks.BlockAsphalt;
import ikreg.roads.blocks.BlockLCross;
import ikreg.roads.blocks.BlockTCross;
import ikreg.roads.blocks.BlockStripline;
import ikreg.roads.blocks.BlockXCross;
import ikreg.roads.blocks.BlockYellowLCross;
import ikreg.roads.blocks.BlockYellowStripline;
import ikreg.roads.blocks.BlockYellowTCross;
import ikreg.roads.blocks.BlockYellowXCross;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Blocks {
	
	public static Block asphalt;
	public static Block stripline;
	public static Block tcross;
	public static Block xcross;
	public static Block lcross;
	public static Block yellowstripline;
	public static Block yellowlcross;
	public static Block yellowtcross;
	public static Block yellowxcross;
	
	public static void init() {
		asphalt = new BlockAsphalt(Material.rock).setUnlocalizedName("asphalt").setCreativeTab(Main.tabRoads);
		stripline = new BlockStripline(Material.rock).setUnlocalizedName("stripline").setCreativeTab(Main.tabRoads);
		tcross = new BlockTCross(Material.rock).setUnlocalizedName("tcross").setCreativeTab(Main.tabRoads);
		xcross = new BlockXCross(Material.rock).setUnlocalizedName("xcross").setCreativeTab(Main.tabRoads);
		lcross = new BlockLCross(Material.rock).setUnlocalizedName("lcross").setCreativeTab(Main.tabRoads);
		yellowstripline = new BlockYellowStripline(Material.rock).setUnlocalizedName("yellowstripline").setCreativeTab(Main.tabRoads);
		yellowlcross = new BlockYellowLCross(Material.rock).setUnlocalizedName("yellowlcross").setCreativeTab(Main.tabRoads);
		yellowtcross = new BlockYellowTCross(Material.rock).setUnlocalizedName("yellowtcross").setCreativeTab(Main.tabRoads);
		yellowxcross = new BlockYellowXCross(Material.rock).setUnlocalizedName("yellowxcross").setCreativeTab(Main.tabRoads);
	}
	
	public static void register() {
		GameRegistry.registerBlock(asphalt, asphalt.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stripline, stripline.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tcross, tcross.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(xcross, xcross.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(lcross, lcross.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(yellowstripline, yellowstripline.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(yellowlcross, yellowlcross.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(yellowtcross, yellowtcross.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(yellowxcross, yellowxcross.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(asphalt);
		registerRender(stripline);	
		registerRender(tcross);
		registerRender(xcross);
		registerRender(lcross);
		registerRender(yellowstripline);
		registerRender(yellowlcross);
		registerRender(yellowtcross);
		registerRender(yellowxcross);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
