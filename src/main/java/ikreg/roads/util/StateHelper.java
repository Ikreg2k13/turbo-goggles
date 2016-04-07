package ikreg.roads.util;

import scala.Console;
import ikreg.roads.blocks.BlockRoads;
import ikreg.roads.blocks.BlockStripline;
import ikreg.roads.blocks.BlockStripline.RoadType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class StateHelper {
	
		public static Block getBlock(IBlockAccess world, BlockPos pos, EnumFacing facing, Direction dir)
		{
			BlockPos target = getBlockPosRelativeTo(world, pos, facing, dir);
			return world.getBlockState(target).getBlock();
		}
		
		public static Direction getNeighborRotation(IBlockAccess world, BlockPos pos, EnumFacing facing, Direction dir)
		{
			BlockPos target = getBlockPosRelativeTo(world, pos, facing, dir);
			EnumFacing other = (EnumFacing) world.getBlockState(target).getValue(BlockRoads.FACING);
			Direction dir_2 = getDirectionRelativeTo(facing, other);
			return dir_2;
		}
		
		public static Direction getRotation(IBlockAccess world, BlockPos pos, EnumFacing facing)
		{
			EnumFacing other = (EnumFacing) world.getBlockState(pos).getValue(BlockRoads.FACING);
			Direction dir_2 = getDirectionRelativeTo(facing, other);
			return dir_2;
		}
		
		public static boolean isNeighborStateSame(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing, Direction dir) {
			if(isStripline(world, pos, facing, dir)) {
				switch(dir) {
				case UP:
				case DOWN:
					if((getNeighborRotation(world, pos, facing, dir) == StateHelper.Direction.DOWN) || (getNeighborRotation(world, pos, facing, dir) == StateHelper.Direction.UP)) {
						return true;
					}
					else return false;
				case RIGHT:
				case LEFT:
					if((getNeighborRotation(world, pos, facing, dir) == StateHelper.Direction.RIGHT) || (getNeighborRotation(world, pos, facing, dir) == StateHelper.Direction.LEFT)) {
						return true;
					}
					else return false;
				default:
					return false;
				}
			}
			return false;

		}
		
		public static boolean isAirBlock(IBlockAccess world, BlockPos pos, EnumFacing facing, Direction dir)
		{
			BlockPos target = getBlockPosRelativeTo(world, pos, facing, dir);
			return world.getBlockState(target).getBlock() instanceof BlockAir;
		}
		
		public static boolean isStripline(IBlockAccess world, BlockPos pos, EnumFacing facing, Direction dir) {
			BlockPos target = getBlockPosRelativeTo(world, pos, facing, dir);
			return world.getBlockState(target).getBlock() instanceof BlockRoads;
		}
		
		
		public static BlockPos getBlockPosRelativeTo(IBlockAccess world, BlockPos pos, EnumFacing facing, Direction dir)
		{
			switch (dir)
			{
			case LEFT:
				return pos.offset(facing.rotateY());
			case RIGHT:
				return pos.offset(facing.rotateYCCW());
			case UP:
				return pos.offset(facing);
			case DOWN:
				return pos.offset(facing.getOpposite());
			default:
				return pos;
			}
		}

		private static Direction getDirectionRelativeTo(EnumFacing thisBlock, EnumFacing otherBlock)
		{
			int num = thisBlock.getHorizontalIndex() - otherBlock.getHorizontalIndex();
			switch (num)
			{
			case -3:
				return Direction.LEFT;
			case -2:
				return Direction.UP;
			case -1:
				return Direction.RIGHT;
			case 0:
				return Direction.DOWN;
			case 1:
				return Direction.LEFT;
			case 2:
				return Direction.UP;
			case 3:
				return Direction.RIGHT;
			}
			return Direction.NONE;
		}

		public static enum Direction
		{
			UP, DOWN, LEFT, RIGHT, NONE;
		}
}
