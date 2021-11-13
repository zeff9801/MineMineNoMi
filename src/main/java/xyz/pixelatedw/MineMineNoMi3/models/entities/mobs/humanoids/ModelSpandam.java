package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Spandam.tcn - TechneToTabulaImporter Created using Tabula 7.0.0
 */
public class ModelSpandam extends ModelBiped 
{
	public ModelRenderer head;
	public ModelRenderer body;
	public ModelRenderer nose;
	public ModelRenderer rightarm;
	public ModelRenderer leftarm;
	public ModelRenderer rightleg;
	public ModelRenderer leftleg;
	public ModelRenderer masks1;
	public ModelRenderer masks2;
	public ModelRenderer masks3;
	public ModelRenderer masks4;
	public ModelRenderer sword1;
	public ModelRenderer sword2;
	public ModelRenderer sword3;
	public ModelRenderer sword4;
	public ModelRenderer sword5;
	public ModelRenderer sword6;
	public ModelRenderer sword7;
	public ModelRenderer sword8;
	public ModelRenderer sword9;
	public ModelRenderer sword10;

	public ModelSpandam() 
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.sword10 = new ModelRenderer(this, 59, 5);
		this.sword10.setRotationPoint(-5.5F, 10.199999809265137F, -6.5F);
		this.sword10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(sword10, -0.3141592741012573F, -0.0F, 0.0F);
		this.masks2 = new ModelRenderer(this, 39, 0);
		this.masks2.setRotationPoint(-4.0F, -6.0F, -4.199999809265137F);
		this.masks2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
		this.rightarm = new ModelRenderer(this, 40, 16);
		this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.leftleg = new ModelRenderer(this, 0, 16);
		this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.sword9 = new ModelRenderer(this, 59, 5);
		this.sword9.setRotationPoint(-7.5F, 10.199999809265137F, -6.5F);
		this.sword9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(sword9, -0.3141592741012573F, -0.0F, 0.0F);
		this.sword3 = new ModelRenderer(this, 49, 4);
		this.sword3.setRotationPoint(-6.5F, 12.699999809265137F, 0.5F);
		this.sword3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(sword3, 0.8726646304130553F, -0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 0, 16);
		this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.sword7 = new ModelRenderer(this, 41, 12);
		this.sword7.setRotationPoint(-7.5F, 10.399999618530273F, -4.0F);
		this.sword7.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.masks4 = new ModelRenderer(this, 68, 10);
		this.masks4.setRotationPoint(-2.0F, -1.0F, -4.199999809265137F);
		this.masks4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.body = new ModelRenderer(this, 16, 16);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.masks1 = new ModelRenderer(this, 34, 0);
		this.masks1.setRotationPoint(-0.5F, -8.199999809265137F, -4.199999809265137F);
		this.masks1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.sword2 = new ModelRenderer(this, 49, 4);
		this.sword2.setRotationPoint(-6.5F, 11.199999809265137F, -2.4000000953674316F);
		this.sword2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(sword2, -0.8726646304130553F, -0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 59, 10);
		this.nose.setRotationPoint(-0.5F, -4.0F, -4.699999809265137F);
		this.nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(nose, 0.7853981852531433F, -0.0F, 0.0F);
		this.sword5 = new ModelRenderer(this, 59, -1);
		this.sword5.setRotationPoint(-6.0F, 11.0F, 3.0F);
		this.sword5.addBox(0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F);
		this.setRotateAngle(sword5, -0.6981316804885863F, -0.0F, 0.0F);
		this.leftarm = new ModelRenderer(this, 40, 16);
		this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.masks3 = new ModelRenderer(this, 68, 5);
		this.masks3.setRotationPoint(-4.0F, -3.0F, -4.199999809265137F);
		this.masks3.addBox(0.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
		this.sword1 = new ModelRenderer(this, 34, 4);
		this.sword1.setRotationPoint(-6.5F, 10.899999618530273F, -3.0F);
		this.sword1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.sword4 = new ModelRenderer(this, 68, 0);
		this.sword4.setRotationPoint(-6.5F, 12.399999618530273F, -1.7999999523162842F);
		this.sword4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.sword6 = new ModelRenderer(this, 59, 13);
		this.sword6.setRotationPoint(-6.5F, 13.600000381469727F, 6.0F);
		this.sword6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(sword6, -0.6981316804885863F, -0.0F, 0.0F);
		this.sword8 = new ModelRenderer(this, 57, 20);
		this.sword8.setRotationPoint(-6.0F, 10.0F, -17.0F);
		this.sword8.addBox(0.0F, 0.0F, 0.0F, 0, 1, 13, 0.0F);
		this.setRotateAngle(sword8, -0.06981317007977318F, -0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.sword10.render(f5);
		this.masks2.render(f5);
		this.rightarm.render(f5);
		this.leftleg.render(f5);
		this.sword9.render(f5);
		this.sword3.render(f5);
		this.rightleg.render(f5);
		this.sword7.render(f5);
		this.head.render(f5);
		this.masks4.render(f5);
		this.body.render(f5);
		this.masks1.render(f5);
		this.sword2.render(f5);
		this.nose.render(f5);
		this.sword5.render(f5);
		this.leftarm.render(f5);
		this.masks3.render(f5);
		this.sword1.render(f5);
		this.sword4.render(f5);
		this.sword6.render(f5);
		this.sword8.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
