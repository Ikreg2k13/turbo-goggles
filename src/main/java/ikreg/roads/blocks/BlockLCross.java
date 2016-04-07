package ikreg.roads.blocks;

import ikreg.roads.blocks.BlockStripline.RoadType;
import ikreg.roads.blocks.BlockTCross.Direction;
import ikreg.roads.util.StateHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;

public class BlockLCross extends BlockStandardCross {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", Direction.class);
	
	public BlockLCross(Material material) {
		super(material);
		setHardness(2.0F);
		setStepSound(SoundType.STONE);
		IBlockState baseState = this.blockState.getBaseState();
		this.setDefaultState(baseState.withProperty(FACING, EnumFacing.NORTH).withProperty(TYPE, Direction.NONE));
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING, TYPE});
	}
	
	public static enum Direction implements IStringSerializable
	{
		NONE, UP, RIGHT, BOTH;

		@Override
		public String getName()
		{
			return this.toString().toLowerCase();
		}
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{	
			boolean up = false;
			boolean right = false;
			EnumFacing facing = state.getValue(FACING);

			if (StateHelper.isNeighborStateSame(state, world, pos, facing, StateHelper.Direction.UP) || world.getBlockState(StateHelper.getBlockPosRelativeTo(world, pos, facing, StateHelper.Direction.UP)).getBlock() instanceof BlockStandardCross)
			{
				up = true;
			}
			if (StateHelper.isNeighborStateSame(state, world, pos, facing, StateHelper.Direction.RIGHT) || world.getBlockState(StateHelper.getBlockPosRelativeTo(world, pos, facing, StateHelper.Direction.DOWN)).getBlock() instanceof BlockStandardCross)
			{
				right = true;
			}
			
			if(up && !right) return state.withProperty(TYPE, Direction.UP);
			if(!up && right) return state.withProperty(TYPE, Direction.RIGHT);
			if(up && right) return state.withProperty(TYPE, Direction.BOTH);
			return state.withProperty(TYPE, Direction.NONE);
	}

}
