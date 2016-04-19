package ikreg.roads.item;

import ikreg.roads.entity.EntityTestCar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCarSpawner extends Item {

	public ItemCarSpawner() {
		//GameRegistry.registerItem(this, getName());
		setUnlocalizedName(getName());
	}

	public String getName() {
		return "carSpawner";
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			EntityTestCar newAnt = new EntityTestCar(worldIn);
			newAnt.setLocationAndAngles(pos.getX() + 0.5d, pos.getY() + 1.1d, pos.getZ() + 0.5d, 0F, 0F);
			worldIn.spawnEntityInWorld(newAnt);
			return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		}
		else return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
}


