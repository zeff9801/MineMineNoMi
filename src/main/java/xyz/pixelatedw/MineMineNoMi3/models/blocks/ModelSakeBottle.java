package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSakeBottle extends ModelBase
{
	public ModelRenderer sake_bottle_bottom_1;
	public ModelRenderer sake_bottle_bottom_2;
	public ModelRenderer sake_bottle_middle;
	public ModelRenderer sake_bottle_top_1;
	public ModelRenderer sake_bottle_neck;
	public ModelRenderer sake_bottle_mouth_1;
	public ModelRenderer sake_bottle_mouth_2;
	public ModelRenderer sake_bottle_mouth_3;
	public ModelRenderer sake_bottle_mouth_4;
	public ModelRenderer sake_bottle_liquid;

	public ModelSakeBottle()
	{
		this.textureWidth = 32;
		this.textureHeight = 32;
		this.sake_bottle_bottom_2 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_bottom_2.setRotationPoint(-0.5F, -2.0F, -0.5F);
		this.sake_bottle_bottom_2.addBox(0.0F, 0.0F, 0.0F, 5, 2, 5, 0.0F);
		this.sake_bottle_middle = new ModelRenderer(this, 0, 20);
		this.sake_bottle_middle.setRotationPoint(-1.0F, -8.0F, -1.0F);
		this.sake_bottle_middle.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
		this.sake_bottle_mouth_1 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_mouth_1.setRotationPoint(0.0F, -12.0F, 0.0F);
		this.sake_bottle_mouth_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.sake_bottle_mouth_3 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_mouth_3.setRotationPoint(1.0F, -12.0F, 0.0F);
		this.sake_bottle_mouth_3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.sake_bottle_top_1 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_top_1.setRotationPoint(0.0F, -9.0F, 0.0F);
		this.sake_bottle_top_1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
		this.sake_bottle_neck = new ModelRenderer(this, 7, 15);
		this.sake_bottle_neck.setRotationPoint(0.5F, -11.0F, 0.5F);
		this.sake_bottle_neck.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
		this.sake_bottle_mouth_2 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_mouth_2.setRotationPoint(3.0F, -12.0F, 0.0F);
		this.sake_bottle_mouth_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.sake_bottle_bottom_1 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_bottom_1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.sake_bottle_bottom_1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
		this.sake_bottle_mouth_4 = new ModelRenderer(this, 0, 0);
		this.sake_bottle_mouth_4.setRotationPoint(1.0F, -12.0F, 3.0F);
		this.sake_bottle_mouth_4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.sake_bottle_liquid = new ModelRenderer(this, 0, 15);
		this.sake_bottle_liquid.setRotationPoint(1.0F, -12.0F, 1.0F);
		this.sake_bottle_liquid.addBox(0.0F, 0.0F, 0.0F, 2, 0, 2, 0.0F);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_bottom_2);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_middle);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_mouth_1);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_mouth_3);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_top_1);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_neck);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_mouth_2);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_mouth_4);
		this.sake_bottle_bottom_1.addChild(this.sake_bottle_liquid);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.sake_bottle_bottom_1.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}