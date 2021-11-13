package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSakeCup extends ModelBase
{
	public ModelRenderer cup_base;
	public ModelRenderer cup_wall_1;
	public ModelRenderer cup_wall_2;
	public ModelRenderer cup_wall_3;
	public ModelRenderer cup_wall_4;
	public ModelRenderer cup_liquid;

	public ModelSakeCup()
	{
		this.textureWidth = 16;
		this.textureHeight = 16;
		this.cup_wall_3 = new ModelRenderer(this, 0, 0);
		this.cup_wall_3.setRotationPoint(0.0F, -1.0F, -1.0F);
		this.cup_wall_3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.cup_base = new ModelRenderer(this, 0, 0);
		this.cup_base.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.cup_base.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		this.cup_liquid = new ModelRenderer(this, 0, 7);
		this.cup_liquid.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.cup_liquid.addBox(0.0F, 0.0F, 0.0F, 2, 0, 2, 0.0F);
		this.cup_wall_4 = new ModelRenderer(this, 0, 0);
		this.cup_wall_4.setRotationPoint(0.0F, -1.0F, 2.0F);
		this.cup_wall_4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.cup_wall_1 = new ModelRenderer(this, 0, 0);
		this.cup_wall_1.setRotationPoint(-1.0F, -1.0F, -1.0F);
		this.cup_wall_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.cup_wall_2 = new ModelRenderer(this, 0, 0);
		this.cup_wall_2.setRotationPoint(2.0F, -1.0F, -1.0F);
		this.cup_wall_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.cup_base.addChild(this.cup_wall_3);
		this.cup_base.addChild(this.cup_liquid);
		this.cup_base.addChild(this.cup_wall_4);
		this.cup_base.addChild(this.cup_wall_1);
		this.cup_base.addChild(this.cup_wall_2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.cup_base.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
