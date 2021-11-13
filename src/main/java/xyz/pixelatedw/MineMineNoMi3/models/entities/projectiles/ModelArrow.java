package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArrow extends ModelBase
{
	public ModelRenderer body;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer head1;
	public ModelRenderer head2;

	public ModelArrow()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-0.5F, 0.0F, -5.0F, 1, 1, 10, 0.0F);
		this.tail1 = new ModelRenderer(this, 15, 0);
		this.tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail1.addBox(-5.0F, -1.7F, 0.4F, 4, 4, 0, 0.0F);
		this.setRotateAngle(tail1, 0.0F, 1.5707963267948966F, 0.7853981633974483F);
		this.tail2 = new ModelRenderer(this, 15, 5);
		this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail2.addBox(-5.0F, -1.8F, -0.3F, 4, 4, 0, 0.0F);
		this.setRotateAngle(tail2, 0.0F, 1.5707963267948966F, -0.7853981633974483F);
		this.head2 = new ModelRenderer(this, 0, 4);
		this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head2.addBox(-0.5F, 0.0F, -7.0F, 1, 1, 1, 0.0F);
		this.head1 = new ModelRenderer(this, 0, 0);
		this.head1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head1.addBox(-1.0F, -0.5F, -6.0F, 2, 2, 1, 0.0F);
		this.body.addChild(this.tail1);
		this.body.addChild(this.tail2);
		this.head1.addChild(this.head2);
		this.body.addChild(this.head1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.body.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
