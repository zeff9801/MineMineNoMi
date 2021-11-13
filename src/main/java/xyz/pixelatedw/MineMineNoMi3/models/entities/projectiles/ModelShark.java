package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShark extends ModelBase
{
	public ModelRenderer head1;
	public ModelRenderer head2;
	public ModelRenderer head3;
	public ModelRenderer head4;
	public ModelRenderer teeth1;
	public ModelRenderer teeth2;
	public ModelRenderer body1;
	public ModelRenderer body2;
	public ModelRenderer body3;
	public ModelRenderer body4;
	public ModelRenderer body5;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tail4;
	public ModelRenderer fin1;
	public ModelRenderer rightFin;
	public ModelRenderer leftFin;

	public ModelShark()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.fin1 = new ModelRenderer(this, 70, 0);
		this.fin1.setRotationPoint(0.0F, -2.5F, -2.0F);
		this.fin1.addBox(-0.5F, -1.5F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(fin1, 0.5585053563117981F, -0.0F, 0.0F);
		this.tail3 = new ModelRenderer(this, 0, 58);
		this.tail3.setRotationPoint(0.0F, 1.5F, 13.0F);
		this.tail3.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.setRotateAngle(tail3, -2.059488534927368F, -0.0F, 0.0F);
		this.body4 = new ModelRenderer(this, 0, 38);
		this.body4.setRotationPoint(0.0F, 0.0F, 10.5F);
		this.body4.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 3, 0.0F);
		this.teeth1 = new ModelRenderer(this, 37, 29);
		this.teeth1.setRotationPoint(0.0F, 0.6000000238418579F, -5.900000095367432F);
		this.teeth1.addBox(-2.5F, -0.5F, -6.0F, 5, 1, 6, 0.0F);
		this.tail1 = new ModelRenderer(this, 0, 58);
		this.tail1.setRotationPoint(0.0F, -1.5F, 13.0F);
		this.tail1.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.setRotateAngle(tail1, -0.9773843884468076F, -0.0F, 0.0F);
		this.tail4 = new ModelRenderer(this, 7, 58);
		this.tail4.setRotationPoint(0.0F, 3.799999952316284F, 14.800000190734863F);
		this.tail4.addBox(-0.5F, -3.0F, -1.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(tail4, -0.7853981852531433F, -0.0F, 0.0F);
		this.body2 = new ModelRenderer(this, 0, 16);
		this.body2.setRotationPoint(0.0F, 0.0F, 3.5F);
		this.body2.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 4, 0.0F);
		this.leftFin = new ModelRenderer(this, 83, 5);
		this.leftFin.setRotationPoint(3.5F, 2.0F, -2.0F);
		this.leftFin.addBox(0.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
		this.setRotateAngle(leftFin, 0.07461098434194052F, -0.5148495286887609F, 0.20085935168846825F);
		this.rightFin = new ModelRenderer(this, 83, 0);
		this.rightFin.setRotationPoint(-3.5F, 2.0F, -2.0F);
		this.rightFin.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
		this.setRotateAngle(rightFin, -0.2744548559023527F, 0.5148495286887609F, -0.20085935168846825F);
		this.head3 = new ModelRenderer(this, 37, 16);
		this.head3.setRotationPoint(0.0F, 3.200000047683716F, -6.400000095367432F);
		this.head3.addBox(-2.5F, -1.0F, -5.0F, 5, 1, 5, 0.0F);
		this.setRotateAngle(head3, 0.08726646006107329F, -0.0F, 0.0F);
		this.head4 = new ModelRenderer(this, 37, 23);
		this.head4.setRotationPoint(0.0F, -0.8999999761581421F, -6.0F);
		this.head4.addBox(-2.5F, -1.0F, -3.0F, 5, 2, 3, 0.0F);
		this.head2 = new ModelRenderer(this, 37, 8);
		this.head2.setRotationPoint(0.0F, 0.10000000149011612F, -6.0F);
		this.head2.addBox(-2.5F, -1.0F, -6.0F, 5, 1, 6, 0.0F);
		this.tail2 = new ModelRenderer(this, 7, 58);
		this.tail2.setRotationPoint(0.0F, -3.5999999046325684F, 14.0F);
		this.tail2.addBox(-0.5F, -3.133333444595337F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(tail2, -2.321287870407105F, -0.0F, 0.0F);
		this.head1 = new ModelRenderer(this, 37, 0);
		this.head1.setRotationPoint(0.0F, -2.0F, -6.0F);
		this.head1.addBox(-2.5F, -1.0F, -6.0F, 5, 1, 6, 0.0F);
		this.setRotateAngle(head1, 0.34906584024429316F, -0.0F, 0.0F);
		this.teeth2 = new ModelRenderer(this, 37, 37);
		this.teeth2.setRotationPoint(0.0F, 3.200000047683716F, -6.199999809265137F);
		this.teeth2.addBox(-2.5F, -2.0F, -5.0F, 5, 1, 5, 0.0F);
		this.setRotateAngle(teeth2, 0.15707963705062866F, -0.0F, 0.0F);
		this.body5 = new ModelRenderer(this, 0, 47);
		this.body5.setRotationPoint(0.0F, 0.0F, -6.5F);
		this.body5.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 3, 0.0F);
		this.body3 = new ModelRenderer(this, 0, 28);
		this.body3.setRotationPoint(0.0F, 0.0F, 7.5F);
		this.body3.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 3, 0.0F);
		this.body1 = new ModelRenderer(this, 0, 0);
		this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body1.addBox(-4.0F, -4.0F, -3.5F, 8, 8, 7, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.fin1.render(f5);
		this.tail3.render(f5);
		this.body4.render(f5);
		this.teeth1.render(f5);
		this.tail1.render(f5);
		this.tail4.render(f5);
		this.body2.render(f5);
		this.leftFin.render(f5);
		this.rightFin.render(f5);
		this.head3.render(f5);
		this.head4.render(f5);
		this.head2.render(f5);
		this.tail2.render(f5);
		this.head1.render(f5);
		this.teeth2.render(f5);
		this.body5.render(f5);
		this.body3.render(f5);
		this.body1.render(f5);
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
