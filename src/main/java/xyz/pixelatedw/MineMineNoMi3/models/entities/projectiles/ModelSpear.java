package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpear extends ModelBase
{
	public ModelRenderer harpooncable;
	public ModelRenderer harpoon1;
	public ModelRenderer harpoon2;
	public ModelRenderer harpoon3;
	public ModelRenderer harpoon4;
	public ModelRenderer harpoon5;
	public ModelRenderer harpoon6;

	public ModelSpear()
	{
		this.textureWidth = 128;
		this.textureHeight = 32;
		this.harpooncable = new ModelRenderer(this, 0, 0);
		this.harpooncable.setRotationPoint(0.0F, 10.0F, -5.0F);
		this.harpooncable.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 30, 0.0F);
		this.harpoon2 = new ModelRenderer(this, 0, 5);
		this.harpoon2.setRotationPoint(0.0F, 9.5F, -6.0F);
		this.harpoon2.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.harpoon6 = new ModelRenderer(this, 0, 18);
		this.harpoon6.setRotationPoint(2.5F, 9.5F, -6.0F);
		this.harpoon6.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(harpoon6, 0.0F, -1.1344640254974367F, 0.0F);
		this.harpoon1 = new ModelRenderer(this, 0, 0);
		this.harpoon1.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.harpoon1.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
		this.harpoon4 = new ModelRenderer(this, 0, 12);
		this.harpoon4.setRotationPoint(0.0F, 9.5F, -9.0F);
		this.harpoon4.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.harpoon5 = new ModelRenderer(this, 0, 15);
		this.harpoon5.setRotationPoint(-2.5F, 9.5F, -6.0F);
		this.harpoon5.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(harpoon5, 0.0F, 1.1344640254974367F, 0.0F);
		this.harpoon3 = new ModelRenderer(this, 0, 8);
		this.harpoon3.setRotationPoint(0.0F, 9.5F, -8.0F);
		this.harpoon3.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.harpooncable.render(f5);
		this.harpoon2.render(f5);
		this.harpoon6.render(f5);
		this.harpoon1.render(f5);
		this.harpoon4.render(f5);
		this.harpoon5.render(f5);
		this.harpoon3.render(f5);
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
