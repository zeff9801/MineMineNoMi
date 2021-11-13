package xyz.pixelatedw.MineMineNoMi3.models.armors;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMedicBag extends ModelBiped
{
	public ModelRenderer backpack;
	public ModelRenderer backpack_2;
	public ModelRenderer backpack_strings;

	public ModelMedicBag()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.backpack_2 = new ModelRenderer(this, 0, 9);
		this.backpack_2.setRotationPoint(0.0F, 3.7F, 2.0F);
		this.backpack_2.addBox(-3.5F, -2.5F, -2.0F, 7, 4, 4, 0.0F);
		this.backpack_strings = new ModelRenderer(this, 20, 0);
		this.backpack_strings.setRotationPoint(0.0F, 3.7F, 2.0F);
		this.backpack_strings.addBox(-5.0F, -7.0F, -1.9F, 10, 9, 0, 0.0F);
		this.backpack = new ModelRenderer(this, 0, 0);
		this.backpack.setRotationPoint(0.0F, 3.7F, 2.0F);
		this.backpack.addBox(-2.5F, -1.5F, 0.0F, 5, 5, 3, 0.0F);
		this.backpack.addChild(this.backpack_2);
		this.backpack.addChild(this.backpack_strings);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.backpack.render(f5);
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