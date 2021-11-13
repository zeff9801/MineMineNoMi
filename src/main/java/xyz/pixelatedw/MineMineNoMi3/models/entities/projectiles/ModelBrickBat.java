package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrickBat extends ModelBase
{
	public ModelRenderer body1;
	public ModelRenderer body2;
	public ModelRenderer body3;
	public ModelRenderer body4;
	public ModelRenderer rightear;
	public ModelRenderer leftear;
	public ModelRenderer rightWing1;
	public ModelRenderer leftWing1;
	public ModelRenderer rightWing2;
	public ModelRenderer leftWing2;

	public ModelBrickBat()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.body1 = new ModelRenderer(this, 0, 0);
		this.body1.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.body1.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
		this.leftear = new ModelRenderer(this, 0, 11);
		this.leftear.setRotationPoint(1.899999976158142F, 4.599999904632568F, 0.0F);
		this.leftear.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(leftear, 0.0F, -0.0F, 0.5235987901687622F);
		this.rightWing2 = new ModelRenderer(this, 93, 0);
		this.rightWing2.setRotationPoint(-6.0F, 0.0F, 0.0F);
		this.rightWing2.addBox(-5.0F, 0.0F, 0.0F, 5, 4, 0, 0.0F);
		this.setRotateAngle(rightWing2, 0.0F, -0.40142572795869574F, 0.0F);
		this.body2 = new ModelRenderer(this, 21, 0);
		this.body2.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.body2.addBox(-3.0F, -2.0F, -2.0F, 6, 4, 4, 0.0F);
		this.body3 = new ModelRenderer(this, 42, 0);
		this.body3.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.body3.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 6, 0.0F);
		this.leftWing2 = new ModelRenderer(this, 93, 5);
		this.leftWing2.setRotationPoint(6.0F, 0.0F, 0.0F);
		this.leftWing2.addBox(0.0F, 0.0F, 0.0F, 5, 4, 0, 0.0F);
		this.setRotateAngle(leftWing2, 0.0F, 0.40142572795869574F, 0.0F);
		this.rightWing1 = new ModelRenderer(this, 80, 0);
		this.rightWing1.setRotationPoint(-1.0F, 6.0F, -1.0F);
		this.rightWing1.addBox(-6.0F, 0.0F, 0.0F, 6, 4, 0, 0.0F);
		this.setRotateAngle(rightWing1, 0.8726646304130553F, -0.0F, 0.43633231520652765F);
		this.leftWing1 = new ModelRenderer(this, 80, 5);
		this.leftWing1.setRotationPoint(1.0F, 6.0F, -1.0F);
		this.leftWing1.addBox(0.0F, 0.0F, 0.0F, 6, 4, 0, 0.0F);
		this.setRotateAngle(leftWing1, 0.8726646304130553F, -0.0F, -0.43633231520652765F);
		this.rightear = new ModelRenderer(this, 0, 11);
		this.rightear.setRotationPoint(-1.899999976158142F, 4.599999904632568F, 0.0F);
		this.rightear.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rightear, 0.0F, -0.0F, -0.5235987901687622F);
		this.body4 = new ModelRenderer(this, 63, 0);
		this.body4.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.body4.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4, 0.0F);
		this.rightWing1.addChild(this.rightWing2);
		this.leftWing1.addChild(this.leftWing2);
	}

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
    {  
	    double[] animationWingMovement = new double[]
				{25, 30, 35, 40, 45, 50, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5, 0, -5, -10, -15, -10, -5, 0, 5, 10, 15, 20, 25};       	    

        int cycleIndexFly = (int) ((ent.ticksExisted * 1.75) % animationWingMovement.length);

        if(!Minecraft.getMinecraft().isGamePaused())
	    {
        	rightWing1.rotateAngleZ = (float) degToRad(animationWingMovement[cycleIndexFly]);
        	leftWing1.rotateAngleZ = (float) degToRad(animationWingMovement[cycleIndexFly]) * -1;
	    }
    }
	
    protected float degToRad(double degrees)
    {
        return (float) (degrees * (double)Math.PI / 180) ;
    }
    
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.body1.render(f5);
		this.leftear.render(f5);
		this.body2.render(f5);
		this.body3.render(f5);
		this.rightWing1.render(f5);
		this.leftWing1.render(f5);
		this.rightear.render(f5);
		this.body4.render(f5);
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
