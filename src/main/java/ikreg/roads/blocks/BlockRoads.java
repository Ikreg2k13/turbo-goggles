package ikreg.roads.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRoads extends Block {
	
		public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		
		public BlockRoads(Material material)
		{
			super(material);
			this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		}

		@Override
		public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
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
		protected BlockStateContainer createBlockState()
		{
			return new BlockStateContainer(this, new IProperty[] { FACING });
		}
	
	/*	@SideOnly(Side.CLIENT)
		public IBlockState getStateForEntityRender(IBlockState state) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		}
	*/
}
