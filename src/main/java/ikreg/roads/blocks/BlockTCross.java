package ikreg.roads.blocks;

import ikreg.roads.blocks.BlockStripline.RoadType;
import ikreg.roads.util.StateHelper;
import ikreg.roads.util.StateHelper.Direction;
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
import net.minecraft.world.World;

public class BlockTCross extends BlockStandardCross {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", Direction.class);

	public BlockTCross(Material material) {
		super(material);
		setHardness(5.0F);
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
		return new BlockStateContainer(this, new IProperty[] { FACING, TYPE });
	}
	
	public static enum Direction implements IStringSerializable
	{
		NONE, DOWN;

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

			if ((StateHelper.isNeighborStateSame(state, world, pos, (EnumFacing) state.getValue(FACING), StateHelper.Direction.DOWN)))
			{
				down = true;
			}
			
			if(down) return state.withProperty(TYPE, Direction.DOWN);
			return state.withProperty(TYPE, Direction.NONE);
	}
}
