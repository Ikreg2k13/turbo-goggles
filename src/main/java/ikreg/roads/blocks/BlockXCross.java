package ikreg.roads.blocks;

import ikreg.roads.blocks.BlockTCross.Direction;
import ikreg.roads.util.StateHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockXCross extends BlockRoads {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", Direction.class);
	
	public BlockXCross(Material material) {
		super(material);
		setHardness(5.0F);
		setStepSound(SoundType.STONE);
		IBlockState baseState = this.blockState.getBaseState();
		this.setDefaultState(baseState.withProperty(FACING, EnumFacing.NORTH).withProperty(TYPE, Direction.NONE));
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING, TYPE });
	}
	
	public static enum Direction implements IStringSerializable
	{
		NONE, RIGHT, UP, DOWN, LEFT;

		@Override
		public String getName()
		{
			return this.toString().toLowerCase();
		}
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{	
			boolean down = false;
			boolean up = false;
			boolean right = false;
			boolean left = false;

			if (StateHelper.isStripline(world, pos, EnumFacing.NORTH, StateHelper.Direction.DOWN))
			{
				down = true;
			}
			if (StateHelper.isStripline(world, pos, EnumFacing.NORTH, StateHelper.Direction.UP))
			{
				up = true;
			}
			if (StateHelper.isStripline(world, pos, EnumFacing.NORTH, StateHelper.Direction.RIGHT))
			{
				right = true;
			}
			if (StateHelper.isStripline(world, pos, EnumFacing.NORTH, StateHelper.Direction.LEFT))
			{
				left = true;
			}			
			if(down) return state.withProperty(TYPE, Direction.DOWN);
			if(right) return state.withProperty(TYPE, Direction.RIGHT);
			if(left) return state.withProperty(TYPE, Direction.LEFT);
			if(up) return state.withProperty(TYPE, Direction.UP);
			
			return state.withProperty(TYPE, Direction.NONE);
	}

}
