package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFist extends ModelBase
{
	public ModelRenderer rightarm;
	public ModelRenderer righthand1;
	public ModelRenderer righthand2;
	public ModelRenderer rightfinger10;
	public ModelRenderer rightfinger11;
	public ModelRenderer rightfinger20;
	public ModelRenderer rightfinger21;
	public ModelRenderer rightfinger30;
	public ModelRenderer rightfinger31;
	public ModelRenderer rightfinger40;
	public ModelRenderer rightfinger41;
	public ModelRenderer rightfinger50;

	public ModelFist()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.rightfinger41 = new ModelRenderer(this, 17, 10);
		this.rightfinger41.setRotationPoint(-1.2999999523162842F, 7.0F, -14.0F);
		this.rightfinger41.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger41, 1.884955644607544F, -0.08726646006107329F, 0.0F);
		this.rightfinger50 = new ModelRenderer(this, 17, 14);
		this.rightfinger50.setRotationPoint(0.10000000149011612F, 6.300000190734863F, -12.699999809265137F);
		this.rightfinger50.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger50, 0.06409869750148231F, 0.9545174550283035F, 1.6946307591911405F);
		this.rightfinger10 = new ModelRenderer(this, 17, 6);
		this.rightfinger10.setRotationPoint(-3.299999952316284F, 5.300000190734863F, -14.0F);
		this.rightfinger10.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger10, 0.0F, 0.08726646006107329F, 0.0F);
		this.rightfinger30 = new ModelRenderer(this, 17, 6);
		this.rightfinger30.setRotationPoint(-2.299999952316284F, 5.300000190734863F, -14.100000381469727F);
		this.rightfinger30.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger30, 0.0F, -0.05235987901687623F, 0.0F);
		this.rightarm = new ModelRenderer(this, 0, 0);
		this.rightarm.setRotationPoint(-2.299999952316284F, 6.0F, -0.10000000149011612F);
		this.rightarm.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
		this.setRotateAngle(rightarm, -1.5707963705062866F, -0.0F, 0.0F);
		this.righthand1 = new ModelRenderer(this, 17, 0);
		this.righthand1.setRotationPoint(-2.299999952316284F, 5.300000190734863F, -9.399999618530273F);
		this.righthand1.addBox(-2.0F, 0.0F, -0.5F, 4, 5, 1, 0.0F);
		this.setRotateAngle(righthand1, -1.5707963705062866F, -0.0F, 0.0F);
		this.rightfinger31 = new ModelRenderer(this, 17, 10);
		this.rightfinger31.setRotationPoint(-2.299999952316284F, 7.0F, -14.100000381469727F);
		this.rightfinger31.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger31, 1.884955644607544F, -0.05235987901687623F, 0.0F);
		this.rightfinger40 = new ModelRenderer(this, 17, 6);
		this.rightfinger40.setRotationPoint(-1.2999999523162842F, 5.300000190734863F, -14.0F);
		this.rightfinger40.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger40, 0.0F, -0.08726646006107329F, 0.0F);
		this.rightfinger11 = new ModelRenderer(this, 17, 10);
		this.rightfinger11.setRotationPoint(-3.299999952316284F, 7.0F, -14.0F);
		this.rightfinger11.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger11, 1.8675023317337036F, 0.08726646006107329F, 0.0F);
		this.rightfinger21 = new ModelRenderer(this, 17, 10);
		this.rightfinger21.setRotationPoint(-2.299999952316284F, 7.0F, -14.100000381469727F);
		this.rightfinger21.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger21, 1.8675023317337036F, 0.05235987901687623F, 0.0F);
		this.righthand2 = new ModelRenderer(this, 28, 0);
		this.righthand2.setRotationPoint(-1.399999976158142F, 5.400000095367432F, -10.300000190734863F);
		this.righthand2.addBox(0.0F, 0.0F, -0.5F, 1, 2, 2, 0.0F);
		this.setRotateAngle(righthand2, -1.5707963705062866F, -0.43633231520652765F, 0.0F);
		this.rightfinger20 = new ModelRenderer(this, 17, 6);
		this.rightfinger20.setRotationPoint(-2.299999952316284F, 5.300000190734863F, -14.100000381469727F);
		this.rightfinger20.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger20, 0.0F, 0.05235987901687623F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.rightfinger41.render(f5);
		this.rightfinger50.render(f5);
		this.rightfinger10.render(f5);
		this.rightfinger30.render(f5);
		this.rightarm.render(f5);
		this.righthand1.render(f5);
		this.rightfinger31.render(f5);
		this.rightfinger40.render(f5);
		this.rightfinger11.render(f5);
		this.rightfinger21.render(f5);
		this.righthand2.render(f5);
		this.rightfinger20.render(f5);
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
