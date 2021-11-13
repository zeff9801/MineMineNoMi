package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMilkyDial extends ModelBase
{
	public ModelRenderer shellA1;
	public ModelRenderer shellA2;
	public ModelRenderer shellA3;
	public ModelRenderer shellA4;
	public ModelRenderer shellA5;
	public ModelRenderer shellA6;
	public ModelRenderer shellB1;
	public ModelRenderer shellB2;
	public ModelRenderer shellB3;
	public ModelRenderer shellB4;

	public ModelMilkyDial()
	{
		this.textureWidth = 50;
		this.textureHeight = 25;
		this.shellA5 = new ModelRenderer(this, 0, 17);
		this.shellA5.setRotationPoint(-1.600000023841858F, 23.399999618530273F, 0.5F);
		this.shellA5.addBox(-2.0F, -1.0F, -2.5F, 4, 2, 5, 0.0F);
		this.setRotateAngle(shellA5, 0.2376517289754121F, 0.34354184013562056F, 0.18548632869502668F);
		this.shellB1 = new ModelRenderer(this, 19, 0);
		this.shellB1.setRotationPoint(0.0F, 21.799999237060547F, 3.5F);
		this.shellB1.addBox(-2.5F, -1.0F, -1.0F, 5, 3, 2, 0.0F);
		this.setRotateAngle(shellB1, -0.34906584024429316F, -0.0F, 0.0F);
		this.shellA1 = new ModelRenderer(this, 0, 0);
		this.shellA1.setRotationPoint(0.0F, 23.399999618530273F, 1.0F);
		this.shellA1.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(shellA1, 0.17453292012214658F, -0.0F, 0.0F);
		this.shellA4 = new ModelRenderer(this, 0, 12);
		this.shellA4.setRotationPoint(1.5F, 23.5F, -2.9000000953674316F);
		this.shellA4.addBox(0.0F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
		this.setRotateAngle(shellA4, -0.15707963705062866F, -0.296705961227417F, 0.0F);
		this.shellB2 = new ModelRenderer(this, 19, 6);
		this.shellB2.setRotationPoint(0.0F, 21.600000381469727F, 1.100000023841858F);
		this.shellB2.addBox(-2.0F, -1.0F, -2.5F, 4, 1, 5, 0.0F);
		this.setRotateAngle(shellB2, 0.17453292012214658F, -0.0F, 0.0F);
		this.shellB4 = new ModelRenderer(this, 19, 13);
		this.shellB4.setRotationPoint(-2.0999999046325684F, 21.600000381469727F, 0.8999999761581421F);
		this.shellB4.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 4, 0.0F);
		this.setRotateAngle(shellB4, 0.19246193402363374F, 0.34238675079420233F, -0.20397832886692308F);
		this.shellA3 = new ModelRenderer(this, 0, 12);
		this.shellA3.setRotationPoint(-1.5F, 23.5F, -2.9000000953674316F);
		this.shellA3.addBox(-3.0F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
		this.setRotateAngle(shellA3, -0.15707963705062866F, 0.296705961227417F, 0.0F);
		this.shellA6 = new ModelRenderer(this, 0, 17);
		this.shellA6.setRotationPoint(1.600000023841858F, 23.399999618530273F, 0.5F);
		this.shellA6.addBox(-2.0F, -1.0F, -2.5F, 4, 2, 5, 0.0F);
		this.setRotateAngle(shellA6, 2.9039409067136246F, 0.34354192995911276F, 2.95610631886536F);
		this.shellA2 = new ModelRenderer(this, 0, 7);
		this.shellA2.setRotationPoint(0.0F, 23.5F, -2.9000000953674316F);
		this.shellA2.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
		this.setRotateAngle(shellA2, -0.15707963705062866F, -0.0F, 0.0F);
		this.shellB3 = new ModelRenderer(this, 19, 13);
		this.shellB3.setRotationPoint(2.0999999046325684F, 21.600000381469727F, 0.8999999761581421F);
		this.shellB3.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 4, 0.0F);
		this.setRotateAngle(shellB3, 2.9491307392197434F, 0.3423868402906765F, -2.9376143181244485F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shellA5.render(f5);
		this.shellB1.render(f5);
		this.shellA1.render(f5);
		this.shellA4.render(f5);
		this.shellB2.render(f5);
		this.shellB4.render(f5);
		this.shellA3.render(f5);
		this.shellA6.render(f5);
		this.shellA2.render(f5);
		this.shellB3.render(f5);
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
