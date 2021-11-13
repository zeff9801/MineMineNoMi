package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWantedPostersPackage extends ModelBiped
{
	public ModelRenderer poster1;
	public ModelRenderer poster2;
	public ModelRenderer poster3;
	public ModelRenderer poster4;
	public ModelRenderer poster5;
	public ModelRenderer poster6;
	public ModelRenderer poster7;
	public ModelRenderer package1;
	public ModelRenderer package2;
	public ModelRenderer package3;
	public ModelRenderer package4;
	public ModelRenderer package5;
	public ModelRenderer package6;
	public ModelRenderer package7;
	public ModelRenderer package8;
	public ModelRenderer package9;
	public ModelRenderer package10;
	public ModelRenderer package11;
	public ModelRenderer package12;
	public ModelRenderer parachute;
	public ModelRenderer parachute_cord1;
	public ModelRenderer parachute_cord2;
	public ModelRenderer parachute_cord3;
	public ModelRenderer parachute_cord4;
	public ModelRenderer parachute_cloth1;
	public ModelRenderer parachute_cloth2;
	public ModelRenderer parachute_cloth3;
	public ModelRenderer parachute_cloth4;
	public ModelRenderer parachute_cloth5;
	public ModelRenderer parachute_cloth6;
	public ModelRenderer parachute_cloth7;
	public ModelRenderer parachute_cloth8;

	public ModelWantedPostersPackage()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.package9 = new ModelRenderer(this, 7, 0);
		this.package9.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package9.addBox(-0.5F, -1.0F, -9.0F, 1, 1, 18, 0.0F);
		this.parachute_cloth8 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth8.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachute_cloth8, 0.2617993877991494F, 5.497787143782138F, 0.0F);
		this.parachute_cloth2 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth2.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachute_cloth2, 0.2617993877991494F, 0.7853981633974483F, 0.0F);
		this.package6 = new ModelRenderer(this, 30, 0);
		this.package6.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package6.addBox(-7.0F, -1.0F, 4.0F, 14, 1, 1, 0.0F);
		this.parachute = new ModelRenderer(this, 0, 30);
		this.parachute.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.parachute.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.poster1 = new ModelRenderer(this, -16, 0);
		this.poster1.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.poster1.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.parachute_cloth7 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth7.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachute_cloth7, 0.2617993877991494F, 4.71238898038469F, 0.0F);
		this.package1 = new ModelRenderer(this, 0, 20);
		this.package1.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package1.addBox(-7.0F, 0.0F, 4.0F, 1, 3, 1, 0.0F);
		this.package10 = new ModelRenderer(this, 7, 0);
		this.package10.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package10.addBox(-0.5F, 3.0F, -9.0F, 1, 1, 18, 0.0F);
		this.poster5 = new ModelRenderer(this, -16, 0);
		this.poster5.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.poster5.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.parachute_cord1 = new ModelRenderer(this, 0, 30);
		this.parachute_cord1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cord1.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachute_cord1, 0.4363323129985824F, 0.0F, 0.0F);
		this.parachute_cloth3 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth3.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachute_cloth3, 0.2617993877991494F, 1.5707963267948966F, 0.0F);
		this.parachute_cloth6 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth6.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachute_cloth6, 0.2617993877991494F, 3.9269908169872414F, 0.0F);
		this.parachute_cord2 = new ModelRenderer(this, 0, 30);
		this.parachute_cord2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cord2.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachute_cord2, 0.4363323129985824F, 3.141592653589793F, 0.0F);
		this.package11 = new ModelRenderer(this, 0, 20);
		this.package11.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package11.addBox(-0.5F, 0.0F, -9.0F, 1, 3, 1, 0.0F);
		this.package5 = new ModelRenderer(this, 30, 0);
		this.package5.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package5.addBox(-7.0F, -1.0F, -5.0F, 14, 1, 1, 0.0F);
		this.parachute_cord3 = new ModelRenderer(this, 0, 30);
		this.parachute_cord3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cord3.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachute_cord3, 0.4363323129985824F, 1.5707963267948966F, 0.0F);
		this.package4 = new ModelRenderer(this, 0, 20);
		this.package4.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package4.addBox(6.0F, 0.0F, -5.0F, 1, 3, 1, 0.0F);
		this.poster4 = new ModelRenderer(this, -16, 0);
		this.poster4.setRotationPoint(0.0F, 22.5F, 0.0F);
		this.poster4.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.parachute_cloth1 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth1.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachute_cloth1, 0.2617993877991494F, 0.0F, 0.0F);
		this.package2 = new ModelRenderer(this, 0, 20);
		this.package2.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package2.addBox(-7.0F, 0.0F, -5.0F, 1, 3, 1, 0.0F);
		this.poster6 = new ModelRenderer(this, -16, 0);
		this.poster6.setRotationPoint(0.0F, 21.5F, 0.0F);
		this.poster6.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.package8 = new ModelRenderer(this, 30, 0);
		this.package8.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package8.addBox(-7.0F, 3.0F, 4.0F, 14, 1, 1, 0.0F);
		this.parachute_cloth4 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth4.addBox(-4.0F, -11.5F, -8.0F, 8, 1, 10, 0.0F);
		this.setRotateAngle(parachute_cloth4, 0.2617993877991494F, 2.356194490192345F, 0.0F);
		this.poster3 = new ModelRenderer(this, -16, 0);
		this.poster3.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.poster3.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.parachute_cord4 = new ModelRenderer(this, 0, 30);
		this.parachute_cord4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cord4.addBox(0.0F, -11.0F, -1.0F, 1, 12, 1, 0.0F);
		this.setRotateAngle(parachute_cord4, 0.4363323129985824F, -1.5707963267948966F, 0.0F);
		this.poster7 = new ModelRenderer(this, -16, 0);
		this.poster7.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.poster7.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.parachute_cloth5 = new ModelRenderer(this, 5, 30);
		this.parachute_cloth5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.parachute_cloth5.addBox(-4.0F, -11.5F, -9.0F, 8, 1, 11, 0.0F);
		this.setRotateAngle(parachute_cloth5, 0.2617993877991494F, 3.141592653589793F, 0.0F);
		this.package7 = new ModelRenderer(this, 30, 0);
		this.package7.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package7.addBox(-7.0F, 3.0F, -5.0F, 14, 1, 1, 0.0F);
		this.poster2 = new ModelRenderer(this, -16, 0);
		this.poster2.setRotationPoint(0.0F, 23.5F, 0.0F);
		this.poster2.addBox(-6.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F);
		this.package3 = new ModelRenderer(this, 0, 20);
		this.package3.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package3.addBox(6.0F, 0.0F, 4.0F, 1, 3, 1, 0.0F);
		this.package12 = new ModelRenderer(this, 0, 20);
		this.package12.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.package12.addBox(-0.5F, 0.0F, 8.0F, 1, 3, 1, 0.0F);
		this.parachute.addChild(this.parachute_cloth8);
		this.parachute.addChild(this.parachute_cloth2);
		this.parachute.addChild(this.parachute_cloth7);
		this.parachute.addChild(this.parachute_cord1);
		this.parachute.addChild(this.parachute_cloth3);
		this.parachute.addChild(this.parachute_cloth6);
		this.parachute.addChild(this.parachute_cord2);
		this.parachute.addChild(this.parachute_cord3);
		this.parachute.addChild(this.parachute_cloth1);
		this.parachute.addChild(this.parachute_cloth4);
		this.parachute.addChild(this.parachute_cord4);
		this.parachute.addChild(this.parachute_cloth5);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.package9.render(f5);
		this.package6.render(f5);
		this.parachute.render(f5);
		this.poster1.render(f5);
		this.package1.render(f5);
		this.package10.render(f5);
		this.poster5.render(f5);
		this.package11.render(f5);
		this.package5.render(f5);
		this.package4.render(f5);
		this.poster4.render(f5);
		this.package2.render(f5);
		this.poster6.render(f5);
		this.package8.render(f5);
		this.poster3.render(f5);
		this.poster7.render(f5);
		this.package7.render(f5);
		this.poster2.render(f5);
		this.package3.render(f5);
		this.package12.render(f5);
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
