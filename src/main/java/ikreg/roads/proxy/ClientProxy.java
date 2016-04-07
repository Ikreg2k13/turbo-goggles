package ikreg.roads.proxy;

import ikreg.roads.init.Blocks;
import ikreg.roads.init.Items;

public class ClientProxy extends CommonProxy {
	
		@Override
		public void registerRenders() {
				Items.registerRenders();
				Blocks.registerRenders();
	}
}
