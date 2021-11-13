package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMorgan extends ModelBiped
{
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightarm1;
    public ModelRenderer leftarm1;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer jaw;
    public ModelRenderer rightarm2;
    public ModelRenderer axe_hand;
    public ModelRenderer cable;
    public ModelRenderer axe1;
    public ModelRenderer axe2;
    public ModelRenderer axe4;
    public ModelRenderer axe41;
    public ModelRenderer axe5;
    public ModelRenderer axe51;
    public ModelRenderer axe6;
    public ModelRenderer axe61; 
    public ModelRenderer leftarm2;

	private int cycleIndex; 
	private boolean canAnimate = true;
	private double frame;
    
    public ModelMorgan()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.axe51 = new ModelRenderer(this, 105, 59);
        this.axe51.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe51.addBox(-1.5F, 12.1F, 5.8F, 1, 3, 2, 0.0F);
        this.setRotateAngle(axe51, -0.41887902047863906F, -0.0F, 0.0F);
        this.axe2 = new ModelRenderer(this, 76, 53);
        this.axe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe2.addBox(-2.0F, 10.0F, 9.5F, 2, 7, 4, 0.0F);
        this.setRotateAngle(axe2, -0.9599310885968813F, 0.0F, 0.0F);
        this.jaw = new ModelRenderer(this, 25, 0);
        this.jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jaw.addBox(-3.6F, -2.0F, -4.0F, 7, 2, 7, 0.0F);
        this.leftarm1 = new ModelRenderer(this, 21, 35);
        this.leftarm1.setRotationPoint(6.0F, -7.0F, 0.0F);
        this.leftarm1.addBox(-1.0F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
        this.setRotateAngle(leftarm1, 0.0F, -0.0F, -0.05235987755982988F);
        this.body = new ModelRenderer(this, 54, 0);
        this.body.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.body.addBox(-5.0F, 0.0F, -2.5F, 10, 16, 5, 0.0F);
        this.axe61 = new ModelRenderer(this, 112, 59);
        this.axe61.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe61.addBox(-1.5F, 7.4F, 19.9F, 1, 3, 2, 0.0F);
        this.setRotateAngle(axe61, -1.53588974175501F, -0.0F, 0.0F);
        this.axe41 = new ModelRenderer(this, 100, 54);
        this.axe41.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe41.addBox(-1.5F, 9.0F, 13.5F, 1, 9, 1, 0.0F);
        this.setRotateAngle(axe41, -0.9599310885968813F, -0.0F, 0.0F);
        this.leftarm2 = new ModelRenderer(this, 21, 50);
        this.leftarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftarm2.addBox(-0.9F, 6.9F, -2.5F, 5, 9, 5, 0.0F);
        this.setRotateAngle(leftarm2, 0.0F, -0.0F, 0.017453292519943295F);
        this.axe5 = new ModelRenderer(this, 105, 52);
        this.axe5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe5.addBox(-2.0F, 12.1F, 2.5F, 2, 2, 4, 0.0F);
        this.setRotateAngle(axe5, -0.41887902047863906F, -0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.head.addBox(-3.0F, -7.0F, -3.0F, 6, 7, 6, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 42);
        this.leftleg.setRotationPoint(2.5F, 7.0F, 0.0F);
        this.leftleg.addBox(-2.5F, 0.0F, -2.5F, 5, 17, 5, 0.0F);
        this.rightarm2 = new ModelRenderer(this, 21, 14);
        this.rightarm2.mirror = true;
        this.rightarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightarm2.addBox(-4.0F, 3.2F, 3.9F, 5, 7, 5, 0.0F);
        this.setRotateAngle(rightarm2, -0.9599310885968813F, -0.0F, 0.0F);
        this.cable = new ModelRenderer(this, 42, 47);
        this.cable.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cable.addBox(-2.5F, 0.0F, 5.5F, 2, 20, 2, 0.0F);
        this.setRotateAngle(cable, -0.9599310885968813F, 0.0F, 0.0F);
        this.axe_hand = new ModelRenderer(this, 0, 0);
        this.axe_hand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe_hand.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(axe_hand, 0.9599310885968813F, 0.0F, 0.0F);
        this.rightarm1 = new ModelRenderer(this, 0, 14);
        this.rightarm1.setRotationPoint(-6.0F, -7.0F, 0.0F);
        this.rightarm1.addBox(-4.0F, -2.0F, -2.5F, 5, 11, 5, 0.0F);
        this.axe1 = new ModelRenderer(this, 51, 51);
        this.axe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe1.addBox(-4.5F, 10.0F, 3.5F, 6, 7, 6, 0.0F);
        this.setRotateAngle(axe1, -0.9599310885968813F, -0.0F, 0.0F);
        this.axe6 = new ModelRenderer(this, 105, 52);
        this.axe6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe6.addBox(-2.0F, 8.6F, 16.6F, 2, 2, 4, 0.0F);
        this.setRotateAngle(axe6, -1.5184364492350666F, -0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 42);
        this.rightleg.setRotationPoint(-2.5F, 7.0F, 0.0F);
        this.rightleg.addBox(-2.5F, 0.0F, -2.5F, 5, 17, 5, 0.0F);
        this.axe4 = new ModelRenderer(this, 89, 52);
        this.axe4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axe4.addBox(-2.0F, 9.0F, 10.5F, 2, 9, 3, 0.0F);
        this.setRotateAngle(axe4, -0.9599310885968813F, -0.0F, 0.0F);
        this.axe_hand.addChild(this.axe51);
        this.axe_hand.addChild(this.axe2);
        this.head.addChild(this.jaw);
        this.axe_hand.addChild(this.axe61);
        this.axe_hand.addChild(this.axe41);
        this.leftarm1.addChild(this.leftarm2);
        this.axe_hand.addChild(this.axe5);
        this.rightarm1.addChild(this.rightarm2);
        this.axe_hand.addChild(this.cable);
        this.rightarm2.addChild(this.axe_hand);
        this.axe_hand.addChild(this.axe1);
        this.axe_hand.addChild(this.axe6);
        this.axe_hand.addChild(this.axe4);
    }

    @Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.leftarm1.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.leftleg.render(f5);
        this.rightarm1.render(f5);
        this.rightleg.render(f5);
    }

    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
    {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scaleFactor, ent);

	    double[] animationChopX = new double[]
				{0, -28, -45, -65, -80, -106, -120, -120, -106, -80, -75, -65,  -45, -35, -25,  0};
	    double[] animationChopY = new double[]
				{0,  0,   0,   10,   14,  17,   20,   20,   20,  20,  18,  17,   12,  10,  9,   0};
	    double[] animationChopZ = new double[]
				{0,  0,   0,   0,    0,   0,   -20,  -20,  -24,  -26, -24, -22, -22, -20, -20,  0};

	    
	    if(!Minecraft.getMinecraft().isGamePaused())
	    {
			/*if(((EntityNewMob) ent).getState() == 0)
	    	{
	    		this.body.rotateAngleY = 0;
	    		this.leftarm1.rotateAngleX = this.rightarm1.rotateAngleX = 0;
	    		
	    		this.rightarm1.rotateAngleX = this.rightarm1.rotateAngleY = this.rightarm1.rotateAngleZ = 0;
	    		
	    		canAnimate = true;
	    		
	    		frame = 0;
	    	}
	    	else if(((EntityNewMob) ent).getState() == 1 && canAnimate)
	    	{	
	    		frame += 0.58;
	    		
	    		if(((int)frame) < animationChopX.length)
	    		{
		    		cycleIndex = (int)frame;
		    		this.rightarm1.rotateAngleX  = degToRad(animationChopX[cycleIndex]);
		    		this.rightarm1.rotateAngleY  = degToRad(animationChopY[cycleIndex]);
		    		this.rightarm1.rotateAngleZ  = degToRad(animationChopZ[cycleIndex]);
		    		if(frame == animationChopX.length - 1)
		    			canAnimate = false;
	    		}
	    	}*/
	    }
		
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount;
		leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;

    }
    
    protected float degToRad(double degrees)
    {
        return (float) (degrees * Math.PI / 180) ;
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

