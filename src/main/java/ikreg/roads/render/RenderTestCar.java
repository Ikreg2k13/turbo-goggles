package ikreg.roads.render;

import ikreg.roads.model.ModelTestCar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTestCar extends RenderLiving {

	public RenderTestCar() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelTestCar(), 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("rs", "textures/entity/testcar.png");
	}
}

