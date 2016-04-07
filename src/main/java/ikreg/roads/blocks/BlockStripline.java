package ikreg.roads.blocks;

import ikreg.roads.util.StateHelper;
import ikreg.roads.util.StateHelper.Direction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStripline extends BlockRoads {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", RoadType.class);
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public BlockStripline (Material material) {
		super(material);
		setHardness(2.0F);
		setStepSound(SoundType.STONE);
		IBlockState baseState = this.blockState.getBaseState();
		this.setDefaultState(baseState.withProperty(FACING, EnumFacing.NORTH).withProperty(TYPE, RoadType.BOTH));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumFacing = EnumFacing.getFront(meta);
		
		if(enumFacing.getAxis() == EnumFacing.Axis.Y) {
			enumFacing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(FACING, enumFacing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	/*
	@Override
	public IBlockState getStateForEntityRender(IBlockState state) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	}
	*/
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING, TYPE });
	}
	
	public static enum RoadType implements IStringSerializable
	{
		NONE, UP, DOWN, BOTH, TRIGHT, TLEFT, TUP, TDOWN, LUPR, LUPL, LDOWNR, LDOWNL, XCROSS;

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
			boolean down = false;
			boolean right = false;
			boolean left = false;
			boolean sameup = false;
			boolean samedown = false;
			boolean sameright = false;
			boolean sameleft = false;

			EnumFacing facing = (EnumFacing) state.getValue(FACING);
		
			if (StateHelper.isStripline(world, pos, facing, StateHelper.Direction.UP))
			{
				up = true;
			}
			if (StateHelper.isStripline(world, pos, facing, StateHelper.Direction.DOWN))
			{
				down = true;
			}
			if (StateHelper.isStripline(world, pos, facing, StateHelper.Direction.LEFT))
			{
				left = true;
			}
			if (StateHelper.isStripline(world, pos, facing, StateHelper.Direction.RIGHT))
			{
				right = true;
			}
			if (StateHelper.isNeighborStateSame(state, world, pos, facing, StateHelper.Direction.UP))
			{
				sameup = true;
			}
			if (StateHelper.isNeighborStateSame(state, world, pos, facing, StateHelper.Direction.DOWN))
			{
				samedown = true;
			}
			if (StateHelper.isNeighborStateSame(state, world, pos, facing, StateHelper.Direction.LEFT))
			{
				sameleft = true;
			}
			if (StateHelper.isNeighborStateSame(state, world, pos, facing, StateHelper.Direction.RIGHT))
			{
				sameright = true;
			}
			
			// Type Declaration
			// T Cross Types
			if(sameup && samedown && !left && sameright) return state.withProperty(TYPE, RoadType.TRIGHT);
			if(!right && sameup && samedown && sameleft) return state.withProperty(TYPE, RoadType.TLEFT);
			if(sameup && sameleft && !down && sameright) return state.withProperty(TYPE, RoadType.TUP);
			if(sameright && samedown && !up && sameleft) return state.withProperty(TYPE, RoadType.TDOWN);
			// L Cross Types	
			if(sameup && sameright && !sameleft && !samedown) return state.withProperty(TYPE, RoadType.LUPR);
			if(sameup && !sameright && sameleft && !samedown) return state.withProperty(TYPE, RoadType.LUPL);
			if(!sameup && sameright && !sameleft && samedown) return state.withProperty(TYPE, RoadType.LDOWNR);
			if(!sameup && !sameright && sameleft && samedown) return state.withProperty(TYPE, RoadType.LDOWNL);
			//X Cross Types
			if(up && down && right && left) return state.withProperty(TYPE,RoadType.XCROSS);
			// Normal Types
			if(!up && !down && !left && !right) return state.withProperty(TYPE, RoadType.NONE);
			if(up && !down) return state.withProperty(TYPE, RoadType.UP);
			if(!up && down) return state.withProperty(TYPE, RoadType.DOWN);
			if(up && down) return state.withProperty(TYPE, RoadType.BOTH);			
			//default
			return state.withProperty(TYPE, RoadType.NONE);
	}
}
