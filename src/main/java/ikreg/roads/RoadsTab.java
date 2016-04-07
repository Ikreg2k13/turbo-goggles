package ikreg.roads;

import ikreg.roads.init.Blocks;
import ikreg.roads.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RoadsTab extends CreativeTabs {

	public RoadsTab(String label) {
		super(label);
		this.setBackgroundImageName("roads.png");
	}
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.asphalt);
	}

}
