package xyz.pixelatedw.MineMineNoMi3.models.effects;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAbareHimatsuri extends ModelBase
{
	public ModelRenderer Platform1;
	public ModelRenderer Platform2;

	public ModelAbareHimatsuri()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Platform2 = new ModelRenderer(this, 0, 0);
		this.Platform2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Platform2.addBox(-10.0F, 10.0F, -10.0F, 20, 10, 20, 0.0F);
		this.Platform1 = new ModelRenderer(this, 0, 0);
		this.Platform1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Platform1.addBox(-15.0F, 0.0F, -15.0F, 30, 10, 30, 0.0F);
		this.Platform1.addChild(this.Platform2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Platform1.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
