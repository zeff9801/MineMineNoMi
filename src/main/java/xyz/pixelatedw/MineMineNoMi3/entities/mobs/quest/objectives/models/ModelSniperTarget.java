package xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSniperTarget extends ModelBiped
{
	public ModelRenderer parachute;
	public ModelRenderer target;
	public ModelRenderer parachuteChild;
	public ModelRenderer parachuteChild_1;
	public ModelRenderer parachuteChild_2;
	public ModelRenderer parachuteChild_3;
	public ModelRenderer parachuteChild_4;
	public ModelRenderer parachuteChild_5;
	public ModelRenderer parachuteChild_6;
	public ModelRenderer parachuteChild_7;
	public ModelRenderer parachuteChild_8;
	public ModelRenderer parachuteChild_9;
	public ModelRenderer parachuteChild_10;
	public ModelRenderer parachuteChild_11;

	public ModelSniperTarget()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.parachuteChild_4 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_4.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachuteChild_4, 0.2617993950843811F, 1.5707963705062866F, 0.0F);
		this.parachuteChild_11 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_11.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachuteChild_11, 0.2617993950843811F, 3.1415927410125732F, 0.0F);
		this.parachuteChild_3 = new ModelRenderer(this, 0, 30);
		this.parachuteChild_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_3.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachuteChild_3, 0.43633231520652765F, 0.0F, 0.0F);
		this.parachuteChild_9 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_9.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachuteChild_9, 0.2617993950843811F, 2.356194496154785F, 0.0F);
		this.parachuteChild_7 = new ModelRenderer(this, 0, 30);
		this.parachuteChild_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_7.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachuteChild_7, 0.43633231520652765F, 1.5707963705062866F, 0.0F);
		this.parachuteChild_5 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_5.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachuteChild_5, 0.2617993950843811F, 3.9269907474517822F, 0.0F);
		this.parachute = new ModelRenderer(this, 0, 30);
		this.parachute.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.parachute.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.target = new ModelRenderer(this, 0, 0);
		this.target.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.target.addBox(-4.0F, 0.0F, -0.5F, 8, 8, 1, 0.0F);
		this.parachuteChild_1 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_1.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachuteChild_1, 0.2617993950843811F, 0.7853981852531433F, 0.0F);
		this.parachuteChild_10 = new ModelRenderer(this, 0, 30);
		this.parachuteChild_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_10.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachuteChild_10, 0.43633231520652765F, -1.5707963705062866F, 0.0F);
		this.parachuteChild_8 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_8.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachuteChild_8, 0.2617993950843811F, 0.0F, 0.0F);
		this.parachuteChild = new ModelRenderer(this, 5, 30);
		this.parachuteChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachuteChild, 0.2617993950843811F, 5.497786998748779F, 0.0F);
		this.parachuteChild_2 = new ModelRenderer(this, 5, 30);
		this.parachuteChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_2.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachuteChild_2, 0.2617993950843811F, 4.71238899230957F, 0.0F);
		this.parachuteChild_6 = new ModelRenderer(this, 0, 30);
		this.parachuteChild_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachuteChild_6.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachuteChild_6, 0.43633231520652765F, 3.1415927410125732F, 0.0F);
		this.parachute.addChild(this.parachuteChild_4);
		this.parachute.addChild(this.parachuteChild_11);
		this.parachute.addChild(this.parachuteChild_3);
		this.parachute.addChild(this.parachuteChild_9);
		this.parachute.addChild(this.parachuteChild_7);
		this.parachute.addChild(this.parachuteChild_5);
		this.parachute.addChild(this.parachuteChild_1);
		this.parachute.addChild(this.parachuteChild_10);
		this.parachute.addChild(this.parachuteChild_8);
		this.parachute.addChild(this.parachuteChild);
		this.parachute.addChild(this.parachuteChild_2);
		this.parachute.addChild(this.parachuteChild_6);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.parachute.render(f5);
		this.target.render(f5);
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