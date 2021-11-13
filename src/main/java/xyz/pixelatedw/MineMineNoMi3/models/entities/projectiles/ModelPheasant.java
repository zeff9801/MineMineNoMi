package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPheasant extends ModelBase
{
	public ModelRenderer body1;
	public ModelRenderer body2;
	public ModelRenderer body3;
	public ModelRenderer body4;
	public ModelRenderer body5;
	public ModelRenderer head;
	public ModelRenderer tuft1;
	public ModelRenderer tuft2;
	public ModelRenderer tuft3;
	public ModelRenderer beak1;
	public ModelRenderer beak2;
	public ModelRenderer beak3;
	public ModelRenderer beak4;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer rightleg1;
	public ModelRenderer rightleg2;
	public ModelRenderer rightfoot1;
	public ModelRenderer leftleg1;
	public ModelRenderer leftleg2;
	public ModelRenderer leftfoot1;
	public ModelRenderer rightWing1;
	public ModelRenderer leftWing1;
	public ModelRenderer rightWing2;
	public ModelRenderer rightWing3;
	public ModelRenderer rightWing4;
	public ModelRenderer rightWing5;
	public ModelRenderer leftWing2;
	public ModelRenderer leftWing3;
	public ModelRenderer leftWing4;
	public ModelRenderer leftWing5;

	public ModelPheasant()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.body3 = new ModelRenderer(this, 0, 27);
		this.body3.setRotationPoint(0.0F, 8.5F, -5.699999809265137F);
		this.body3.addBox(-3.0F, -3.0F, -1.0F, 6, 6, 2, 0.0F);
		this.setRotateAngle(body3, -0.05235987901687623F, -0.0F, 0.0F);
		this.leftWing5 = new ModelRenderer(this, 94, 5);
		this.leftWing5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftWing5.addBox(0.5F, 0.5F, 1.0F, 6, 0, 6, 0.0F);
		this.setRotateAngle(leftWing5, -0.017453292519943295F, 0.0F, 0.0F);
		this.tuft3 = new ModelRenderer(this, 29, 51);
		this.tuft3.setRotationPoint(0.0F, 7.0F, -12.5F);
		this.tuft3.addBox(0.0F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tuft3, 0.6981316804885863F, -0.0F, 0.34906584024429316F);
		this.rightleg2 = new ModelRenderer(this, 48, 0);
		this.rightleg2.setRotationPoint(-2.0F, 10.5F, 2.0F);
		this.rightleg2.addBox(-0.5F, 4.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(rightleg2, 0.7853981852531433F, -0.17453292012214658F, 0.0F);
		this.body1 = new ModelRenderer(this, 0, 0);
		this.body1.setRotationPoint(0.0F, 9.5F, 0.0F);
		this.body1.addBox(-3.5F, -4.0F, -5.0F, 7, 7, 10, 0.0F);
		this.rightWing3 = new ModelRenderer(this, 91, 0);
		this.rightWing3.setRotationPoint(-12.0F, -0.7F, -1.0F);
		this.rightWing3.addBox(-6.5F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(rightWing3, 0.0F, 0.24434609527920614F, 0.0F);
		this.beak4 = new ModelRenderer(this, 7, 61);
		this.beak4.setRotationPoint(0.0F, 8.899999618530273F, -13.199999809265137F);
		this.beak4.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(beak4, -0.17453292012214658F, -0.0F, 0.0F);
		this.beak1 = new ModelRenderer(this, 0, 58);
		this.beak1.setRotationPoint(0.0F, 8.399999618530273F, -13.5F);
		this.beak1.addBox(-0.800000011920929F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(beak1, 0.26647571930768615F, -0.2617585853470904F, -0.018068846194535408F);
		this.rightWing2 = new ModelRenderer(this, 70, 0);
		this.rightWing2.setRotationPoint(-3.1F, -0.1F, -0.5F);
		this.rightWing2.addBox(-9.5F, 0.0F, 0.5F, 9, 1, 1, 0.0F);
		this.setRotateAngle(rightWing2, -0.03577924966588375F, -0.10035643198967394F, 0.06073745796940267F);
		this.leftfoot1 = new ModelRenderer(this, 48, 5);
		this.leftfoot1.setRotationPoint(1.7999999523162842F, 14.800000190734863F, 3.9000000953674316F);
		this.leftfoot1.addBox(-1.0F, 1.0F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(leftfoot1, 1.3089969158172607F, 0.17453292012214658F, 0.0F);
		this.rightWing4 = new ModelRenderer(this, 57, 5);
		this.rightWing4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightWing4.addBox(-8.8F, 0.5F, 1.0F, 12, 0, 6, 0.0F);
		this.setRotateAngle(rightWing4, 0.017453292519943295F, 0.045553093477052F, 0.0F);
		this.leftWing4 = new ModelRenderer(this, 57, 5);
		this.leftWing4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftWing4.addBox(-2.8F, 0.5F, 1.0F, 12, 0, 6, 0.0F);
		this.setRotateAngle(leftWing4, 0.017453292519943295F, -0.045553093477052F, 0.0F);
		this.rightleg1 = new ModelRenderer(this, 35, 0);
		this.rightleg1.setRotationPoint(-2.0F, 10.5F, 2.0F);
		this.rightleg1.addBox(-1.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(rightleg1, 0.7853981852531433F, -0.17453292012214658F, 0.0F);
		this.tuft2 = new ModelRenderer(this, 22, 51);
		this.tuft2.setRotationPoint(0.0F, 7.0F, -12.5F);
		this.tuft2.addBox(-1.0F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tuft2, 0.6981316804885863F, -0.0F, -0.34906584024429316F);
		this.leftleg1 = new ModelRenderer(this, 35, 0);
		this.leftleg1.setRotationPoint(2.0F, 10.5F, 2.0F);
		this.leftleg1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(leftleg1, 0.7853981852531433F, 0.17453292012214658F, 0.0F);
		this.leftWing3 = new ModelRenderer(this, 91, 0);
		this.leftWing3.setRotationPoint(12.0F, -0.6F, -1.0F);
		this.leftWing3.addBox(0.5F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(leftWing3, 0.0F, -0.24434609527920614F, 0.0F);
		this.head = new ModelRenderer(this, 0, 51);
		this.head.setRotationPoint(0.0F, 8.0F, -11.5F);
		this.head.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(head, 0.08726646006107329F, -0.0F, 0.0F);
		this.beak2 = new ModelRenderer(this, 0, 61);
		this.beak2.setRotationPoint(0.0F, 8.399999618530273F, -13.5F);
		this.beak2.addBox(-0.20000000298023224F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(beak2, 0.26647571930768615F, 0.2617585853470904F, 0.018068846194535408F);
		this.beak3 = new ModelRenderer(this, 7, 58);
		this.beak3.setRotationPoint(0.0F, 8.300000190734863F, -13.5F);
		this.beak3.addBox(-0.5F, -0.5F, -1.2000000476837158F, 1, 1, 2, 0.0F);
		this.setRotateAngle(beak3, 0.2617993950843811F, -0.0F, 0.0F);
		this.rightfoot1 = new ModelRenderer(this, 48, 5);
		this.rightfoot1.setRotationPoint(-1.7999999523162842F, 14.800000190734863F, 3.9000000953674316F);
		this.rightfoot1.addBox(-1.0F, 1.0F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(rightfoot1, 1.3089969158172607F, -0.17453292012214658F, 0.0F);
		this.body2 = new ModelRenderer(this, 0, 18);
		this.body2.setRotationPoint(0.0F, 9.0F, 5.5F);
		this.body2.addBox(-3.0F, -3.0F, -1.0F, 6, 6, 2, 0.0F);
		this.tail3 = new ModelRenderer(this, 59, 18);
		this.tail3.setRotationPoint(0.0F, 8.0F, 6.0F);
		this.tail3.addBox(0.20000000298023224F, -0.5F, 0.0F, 3, 1, 7, 0.0F);
		this.setRotateAngle(tail3, 0.26179939508438105F, 0.2617993950843811F, 0.0F);
		this.tail1 = new ModelRenderer(this, 17, 18);
		this.tail1.setRotationPoint(0.0F, 8.0F, 6.0F);
		this.tail1.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 8, 0.0F);
		this.setRotateAngle(tail1, 0.2617993950843811F, -0.0F, 0.0F);
		this.tail2 = new ModelRenderer(this, 38, 18);
		this.tail2.setRotationPoint(0.0F, 8.0F, 6.0F);
		this.tail2.addBox(-3.200000047683716F, -0.5F, 0.0F, 3, 1, 7, 0.0F);
		this.setRotateAngle(tail2, 0.26179939508438105F, -0.2617993950843811F, 0.0F);
		this.leftleg2 = new ModelRenderer(this, 48, 0);
		this.leftleg2.setRotationPoint(2.0F, 10.5F, 2.0F);
		this.leftleg2.addBox(-1.5F, 4.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(leftleg2, 0.7853981852531433F, 0.17453292012214658F, 0.0F);
		this.tuft1 = new ModelRenderer(this, 13, 51);
		this.tuft1.setRotationPoint(0.0F, 7.0F, -12.5F);
		this.tuft1.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(tuft1, 0.6981316804885863F, -0.0F, 0.0F);
		this.rightWing1 = new ModelRenderer(this, 57, 0);
		this.rightWing1.setRotationPoint(-2.9000000953674316F, 6.099999904632568F, -4.0F);
		this.rightWing1.addBox(-4.0F, -0.5F, -0.5F, 4, 2, 2, 0.0F);
		this.setRotateAngle(rightWing1, -0.03727404891935047F, -0.25919263935540354F, 0.14448469804447148F);
		this.body4 = new ModelRenderer(this, 0, 36);
		this.body4.setRotationPoint(0.0F, 8.0F, -7.5F);
		this.body4.addBox(-2.5F, -2.5F, -1.0F, 5, 5, 2, 0.0F);
		this.setRotateAngle(body4, -0.05235987901687623F, -0.0F, 0.0F);
		this.rightWing5 = new ModelRenderer(this, 94, 5);
		this.rightWing5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightWing5.addBox(-6.2F, 0.5F, 1.0F, 6, 0, 6, 0.0F);
		this.setRotateAngle(rightWing5, -0.017453292519943295F, 0.0F, 0.0F);
		this.body5 = new ModelRenderer(this, 0, 44);
		this.body5.setRotationPoint(0.0F, 8.5F, -8.699999809265137F);
		this.body5.addBox(-2.0F, -2.5F, -1.5F, 4, 4, 2, 0.0F);
		this.leftWing2 = new ModelRenderer(this, 70, 0);
		this.leftWing2.setRotationPoint(3.0F, -0.1F, -0.5F);
		this.leftWing2.addBox(0.5F, 0.0F, 0.5F, 9, 1, 1, 0.0F);
		this.setRotateAngle(leftWing2, -0.03577924966588375F, 0.10035643198967394F, -0.06073745796940267F);
		this.leftWing1 = new ModelRenderer(this, 57, 0);
		this.leftWing1.setRotationPoint(2.9F, 6.1F, -4.0F);
		this.leftWing1.addBox(0.0F, -0.5F, -0.5F, 4, 2, 2, 0.0F);
		this.setRotateAngle(leftWing1, -0.03735004599267865F, 0.25918139392115797F, -0.1445132620651305F);
		this.leftWing3.addChild(this.leftWing5);
		this.rightWing1.addChild(this.rightWing3);
		this.rightWing1.addChild(this.rightWing2);
		this.rightWing2.addChild(this.rightWing4);
		this.leftWing2.addChild(this.leftWing4);
		this.leftWing1.addChild(this.leftWing3);
		this.rightWing3.addChild(this.rightWing5);
		this.leftWing1.addChild(this.leftWing2);
	}

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
    {  
	    double[] animationWingMovement = new double[]
				{5, 10, 15, 20, 25, 30, 35, 30, 25, 20, 15, 10, 5, 0, -5, -10, -15, -10, -5, 0, 5};       	    

        int cycleIndexFly = (int) ((ent.ticksExisted * 1.85) % animationWingMovement.length);

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
		this.body3.render(f5);
		this.tuft3.render(f5);
		this.rightleg2.render(f5);
		this.body1.render(f5);
		this.beak4.render(f5);
		this.beak1.render(f5);
		this.leftfoot1.render(f5);
		this.rightleg1.render(f5);
		this.tuft2.render(f5);
		this.leftleg1.render(f5);
		this.head.render(f5);
		this.beak2.render(f5);
		this.beak3.render(f5);
		this.rightfoot1.render(f5);
		this.body2.render(f5);
		this.tail3.render(f5);
		this.tail1.render(f5);
		this.tail2.render(f5);
		this.leftleg2.render(f5);
		this.tuft1.render(f5);
		this.rightWing1.render(f5);
		this.body4.render(f5);
		this.body5.render(f5);
		this.leftWing1.render(f5);
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
