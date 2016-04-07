package ikreg.roads.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAsphalt extends Block {

	public BlockAsphalt(Material material) {
		super(material);
		setHardness(5.0F);
		setStepSound(SoundType.STONE);
		
	}
}
