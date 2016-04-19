package ikreg.roads.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTestCar extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer wheel1;
    ModelRenderer wheel2;
    ModelRenderer wheel3;
    ModelRenderer wheel4;
  
  public ModelTestCar()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 16, 15, 20);
      body.setRotationPoint(-8F, 6.933333F, -9.266666F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      wheel1 = new ModelRenderer(this, 72, 24);
      wheel1.addBox(-1F, -2F, -2F, 1, 4, 4);
      wheel1.setRotationPoint(-8F, 22F, -7F);
      wheel1.setTextureSize(64, 32);
      wheel1.mirror = true;
      setRotation(wheel1, 0F, 0F, 0F);
      wheel2 = new ModelRenderer(this, 72, 16);
      wheel2.addBox(-1F, -2F, -2F, 1, 4, 4);
      wheel2.setRotationPoint(-8F, 22F, 10F);
      wheel2.setTextureSize(64, 32);
      wheel2.mirror = true;
      setRotation(wheel2, 0F, 0F, 0F);
      wheel3 = new ModelRenderer(this, 72, 0);
      wheel3.addBox(0F, -2F, -2F, 1, 4, 4);
      wheel3.setRotationPoint(8F, 22F, -7F);
      wheel3.setTextureSize(64, 32);
      wheel3.mirror = true;
      setRotation(wheel3, 0F, 0F, 0F);
      wheel4 = new ModelRenderer(this, 72, 8);
      wheel4.addBox(0F, -2F, -2F, 1, 4, 4);
      wheel4.setRotationPoint(8F, 22F, 10F);
      wheel4.setTextureSize(64, 32);
      wheel4.mirror = true;
      setRotation(wheel4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    wheel1.render(f5);
    wheel2.render(f5);
    wheel3.render(f5);
    wheel4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.wheel1.rotateAngleX = (f * 0.5F) * f1 * -1.4F;
    this.wheel2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.wheel1.rotateAngleY = 0.0F;
    this.wheel2.rotateAngleY = 0.0F;
  }

}

