package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEisenDial extends ModelBase
{
	public ModelRenderer shell1;
	public ModelRenderer shell2;
	public ModelRenderer shell3;
	public ModelRenderer shell4;
	public ModelRenderer shell5;
	public ModelRenderer shell6;
	public ModelRenderer shell7;
	public ModelRenderer shell8;

	public ModelEisenDial()
	{
		this.textureWidth = 40;
		this.textureHeight = 20;
		this.shell4 = new ModelRenderer(this, 16, 5);
		this.shell4.setRotationPoint(0.0F, 20.5F, -1.0F);
		this.shell4.addBox(0.0F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(shell4, 0.2617993950843811F, -0.4188790321350098F, 0.0F);
		this.shell7 = new ModelRenderer(this, 32, 0);
		this.shell7.setRotationPoint(0.0F, 20.600000381469727F, -1.0F);
		this.shell7.addBox(0.20000000298023224F, 0.0F, -2.700000047683716F, 1, 1, 1, 0.0F);
		this.setRotateAngle(shell7, 0.24434609711170194F, 0.5235987901687622F, 0.0F);
		this.shell2 = new ModelRenderer(this, 7, 0);
		this.shell2.setRotationPoint(0.0F, 20.5F, -1.0F);
		this.shell2.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shell2, 0.2617993950843811F, -0.0F, 0.0F);
		this.shell8 = new ModelRenderer(this, 32, 5);
		this.shell8.setRotationPoint(0.0F, 20.600000381469727F, -1.0F);
		this.shell8.addBox(-1.2000000476837158F, 0.0F, -2.700000047683716F, 1, 1, 1, 0.0F);
		this.setRotateAngle(shell8, 0.24434609711170194F, -0.5235987901687622F, 0.0F);
		this.shell5 = new ModelRenderer(this, 25, 0);
		this.shell5.setRotationPoint(0.0F, 20.5F, -1.0F);
		this.shell5.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(shell5, 0.2617993950843811F, 1.0471975803375244F, 0.0F);
		this.shell1 = new ModelRenderer(this, 0, 0);
		this.shell1.setRotationPoint(0.0F, 20.5F, 0.0F);
		this.shell1.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 1, 0.0F);
		this.shell6 = new ModelRenderer(this, 25, 5);
		this.shell6.setRotationPoint(0.0F, 20.5F, -1.0F);
		this.shell6.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(shell6, 0.2617993950843811F, -1.0471975803375244F, 0.0F);
		this.shell3 = new ModelRenderer(this, 16, 0);
		this.shell3.setRotationPoint(0.0F, 20.5F, -1.0F);
		this.shell3.addBox(-1.0F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(shell3, 0.2617993950843811F, 0.4188790321350098F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shell4.render(f5);
		this.shell7.render(f5);
		this.shell2.render(f5);
		this.shell8.render(f5);
		this.shell5.render(f5);
		this.shell1.render(f5);
		this.shell6.render(f5);
		this.shell3.render(f5);
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
