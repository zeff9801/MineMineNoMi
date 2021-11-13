package xyz.pixelatedw.MineMineNoMi3.models.armors;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTomoeDrums extends ModelBiped
{
	public ModelRenderer Bar1;
	public ModelRenderer Bar2;
	public ModelRenderer Bar3;
	public ModelRenderer Bar4;
	public ModelRenderer Bar5;
	public ModelRenderer Bar6;
	public ModelRenderer Bar7;
	public ModelRenderer Bar8;
	public ModelRenderer Bar9;
	public ModelRenderer Bar10;
	public ModelRenderer Bar11;
	public ModelRenderer Drum1;
	public ModelRenderer Drum2;
	public ModelRenderer Drum3;
	public ModelRenderer Drum4;

	public ModelTomoeDrums()
	{
		this.textureWidth = 32;
		this.textureHeight = 32;
		this.Bar4 = new ModelRenderer(this, 0, 0);
		this.Bar4.setRotationPoint(5.0F, 1.0F, 2.0F);
		this.Bar4.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar4, 0.0F, -0.0F, -0.8726646259971648F);
		this.Bar5 = new ModelRenderer(this, 0, 0);
		this.Bar5.setRotationPoint(8.0F, -2.0F, 2.0F);
		this.Bar5.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar5, 0.0F, -0.0F, -1.6580627893946132F);
		this.Bar9 = new ModelRenderer(this, 0, 0);
		this.Bar9.setRotationPoint(5.7F, -10.4F, 2.0F);
		this.Bar9.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar9, 0.0F, -0.0F, -2.792526803190927F);
		this.Bar2 = new ModelRenderer(this, 0, 0);
		this.Bar2.setRotationPoint(-1.0F, 3.0F, 2.0F);
		this.Bar2.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar2, 0.0F, -0.0F, 0.4886921905584123F);
		this.Drum2 = new ModelRenderer(this, 0, 5);
		this.Drum2.setRotationPoint(7.0F, -4.0F, 1.0F);
		this.Drum2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.Drum1 = new ModelRenderer(this, 0, 5);
		this.Drum1.setRotationPoint(-10.0F, -4.0F, 1.0F);
		this.Drum1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.Bar7 = new ModelRenderer(this, 0, 0);
		this.Bar7.setRotationPoint(7.7F, -6.5F, 2.0F);
		this.Bar7.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar7, 0.0F, -0.0F, -2.0943951023931953F);
		this.Drum4 = new ModelRenderer(this, 0, 5);
		this.Drum4.setRotationPoint(4.0F, -12.0F, 1.0F);
		this.Drum4.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.Bar6 = new ModelRenderer(this, 0, 0);
		this.Bar6.setRotationPoint(-8.0F, -2.0F, 2.0F);
		this.Bar6.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar6, 0.0F, -0.0F, 1.6580627893946132F);
		this.Drum3 = new ModelRenderer(this, 0, 5);
		this.Drum3.setRotationPoint(-8.0F, -12.0F, 1.0F);
		this.Drum3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.Bar10 = new ModelRenderer(this, 0, 0);
		this.Bar10.setRotationPoint(-5.7F, -10.4F, 2.0F);
		this.Bar10.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar10, 0.0F, -0.0F, 2.792526803190927F);
		this.Bar1 = new ModelRenderer(this, 0, 0);
		this.Bar1.setRotationPoint(1.0F, 3.0F, 2.0F);
		this.Bar1.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar1, 0.0F, -0.0F, -0.4886921905584123F);
		this.Bar8 = new ModelRenderer(this, 0, 0);
		this.Bar8.setRotationPoint(-7.7F, -6.5F, 2.0F);
		this.Bar8.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar8, 0.0F, -0.0F, 2.0943951023931953F);
		this.Bar11 = new ModelRenderer(this, 0, 0);
		this.Bar11.setRotationPoint(-1.5F, -13.1F, 2.0F);
		this.Bar11.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Bar3 = new ModelRenderer(this, 0, 0);
		this.Bar3.setRotationPoint(-5.0F, 1.0F, 2.0F);
		this.Bar3.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(Bar3, 0.0F, -0.0F, 0.8726646259971648F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Bar4.render(f5);
		this.Drum1.render(f5);
		this.Bar11.render(f5);
		this.Bar2.render(f5);
		this.Bar6.render(f5);
		this.Bar10.render(f5);
		this.Bar8.render(f5);
		this.Bar9.render(f5);
		this.Bar7.render(f5);
		this.Bar5.render(f5);
		this.Bar1.render(f5);
		this.Bar3.render(f5);
		this.Drum2.render(f5);
		this.Drum4.render(f5);
		this.Drum3.render(f5);
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
