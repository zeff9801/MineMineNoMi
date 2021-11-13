package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelVenomDemon extends ModelZoanMorph 
{
    public ModelRenderer base1;
    public ModelRenderer base2;
    public ModelRenderer waist;
    public ModelRenderer body1;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer body5;
    public ModelRenderer body6;
    public ModelRenderer rightwing;
    public ModelRenderer leftwing;
    public ModelRenderer rightforearm;
    public ModelRenderer rightarm;
    public ModelRenderer leftforearm;
    public ModelRenderer leftarm;
    public ModelRenderer neck;
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer jaw;
    public ModelRenderer righthand;
    public ModelRenderer finger11;
    public ModelRenderer finger12;
    public ModelRenderer finger21;
    public ModelRenderer finger22;
    public ModelRenderer finger31;
    public ModelRenderer finger32;
    public ModelRenderer finger41;
    public ModelRenderer finger42;
    public ModelRenderer finger51;
    public ModelRenderer finger52;
    public ModelRenderer lefthand;
    public ModelRenderer finger11_1;
    public ModelRenderer finger12_1;
    public ModelRenderer finger21_1;
    public ModelRenderer finger22_1;
    public ModelRenderer finger31_1;
    public ModelRenderer finger32_1;
    public ModelRenderer finger41_1;
    public ModelRenderer finger42_1;
    public ModelRenderer finger51_1;
    public ModelRenderer finger52_1;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer righthorn3;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    public ModelRenderer lefthorn3;
    public ModelRenderer spine1;
    public ModelRenderer spine2;
    public ModelRenderer vertebrae1;
    public ModelRenderer vertebrae2;

    public ModelVenomDemon() 
    {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.lefthorn3 = new ModelRenderer(this, 252, 1);
        this.lefthorn3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lefthorn3.addBox(-1.6F, -2.5F, 1.9F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lefthorn3, -0.296705972839036F, 0.05235987755982988F, 0.0F);
        this.righthand = new ModelRenderer(this, 232, 37);
        this.righthand.setRotationPoint(0.0F, 14.7F, 0.0F);
        this.righthand.addBox(-6.0F, 0.0F, -6.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(righthand, -0.017453292519943295F, -0.008726646259971648F, -0.03490658503988659F);
        this.finger11_1 = new ModelRenderer(this, 225, 33);
        this.finger11_1.setRotationPoint(18.799999237060547F, 3.0F, -19.5F);
        this.finger11_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger11_1, -0.22426562616892315F, -0.20892176742572516F, 0.07136760431497328F);
        this.finger22_1 = new ModelRenderer(this, 225, 29);
        this.finger22_1.setRotationPoint(17.399999618530273F, 2.0999999046325684F, -22.100000381469727F);
        this.finger22_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger22_1, 0.1053292094111233F, 0.03490126616776876F, 0.017463928777144696F);
        this.body2 = new ModelRenderer(this, 0, 73);
        this.body2.setRotationPoint(-8.0F, 3.0F, 6.5F);
        this.body2.addBox(0.0F, 0.0F, -15.0F, 16, 5, 15, 0.0F);
        this.setRotateAngle(body2, 0.05235987901687623F, -0.0F, 0.0F);
        this.leftforearm = new ModelRenderer(this, 180, 0);
        this.leftforearm.setRotationPoint(8.0F, -17.0F, 0.0F);
        this.leftforearm.addBox(0.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
        this.setRotateAngle(leftforearm, -0.5235987901687622F, -0.5235987901687622F, 0.0F);
        this.lefthand = new ModelRenderer(this, 232, 28);
        this.lefthand.setRotationPoint(12.0F, 6.0F, -16.0F);
        this.lefthand.addBox(0.0F, 0.0F, -6.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(lefthand, -0.969075876183741F, -0.086787198024932F, 0.10511683586917409F);
        this.base2 = new ModelRenderer(this, 0, 17);
        this.base2.setRotationPoint(-6.5F, 19.0F, -6.5F);
        this.base2.addBox(0.0F, 0.0F, 0.0F, 13, 3, 13, 0.0F);
        this.base1 = new ModelRenderer(this, 0, 0);
        this.base1.setRotationPoint(-7.0F, 22.0F, -7.0F);
        this.base1.addBox(0.0F, 0.0F, 0.0F, 14, 2, 14, 0.0F);
        this.spine1 = new ModelRenderer(this, 233, 9);
        this.spine1.setRotationPoint(-0.5F, -23.200000762939453F, -10.600000381469727F);
        this.spine1.addBox(0.0F, 0.0F, 0.0F, 1, 17, 1, 0.0F);
        this.setRotateAngle(spine1, 1.483529806137085F, -0.0F, 0.0F);
        this.finger31 = new ModelRenderer(this, 225, 42);
        this.finger31.setRotationPoint(-2.5F, 1.5F, -6.0F);
        this.finger31.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger31, 0.7504915783575618F, -0.03490658503988659F, -0.03490658503988659F);
        this.finger12_1 = new ModelRenderer(this, 225, 29);
        this.finger12_1.setRotationPoint(19.299999237060547F, 2.5F, -21.600000381469727F);
        this.finger12_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger12_1, 0.20210794645576605F, -0.1044637328378902F, 0.07019646143917842F);
        this.leftarm = new ModelRenderer(this, 205, 0);
        this.leftarm.setRotationPoint(12.0F, -4.0F, -5.0F);
        this.leftarm.addBox(0.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
        this.setRotateAngle(leftarm, -0.9032739243347407F, -0.17185474647631838F, 0.17716979319067175F);
        this.rightarm = new ModelRenderer(this, 205, 0);
        this.rightarm.setRotationPoint(-1.1F, 14.9F, 0.5F);
        this.rightarm.addBox(-6.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
        this.setRotateAngle(rightarm, -0.2792526803190927F, -0.27314402793711257F, -0.36425021489121656F);
        this.lefthorn2 = new ModelRenderer(this, 241, 0);
        this.lefthorn2.setRotationPoint(0.0F, 0.0F, 2.8F);
        this.lefthorn2.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(lefthorn2, -0.4363323129985824F, 0.12217304763960307F, 0.0F);
        this.finger11 = new ModelRenderer(this, 225, 42);
        this.finger11.setRotationPoint(-6.0F, 1.5F, -6.0F);
        this.finger11.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger11, 0.7504915783575618F, -0.03490658503988659F, -0.03490658503988659F);
        this.neck = new ModelRenderer(this, 189, 49);
        this.neck.setRotationPoint(-2.0F, -23.0F, -12.800000190734863F);
        this.neck.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(neck, -0.05235987901687623F, -0.0F, 0.0F);
        this.finger12 = new ModelRenderer(this, 225, 38);
        this.finger12.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.finger12.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger12, 0.19198621771937624F, 0.03490658503988659F, -0.03490658503988659F);
        this.finger22 = new ModelRenderer(this, 225, 38);
        this.finger22.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.finger22.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger22, 0.19198621771937624F, -0.03490658503988659F, 0.0F);
        this.righthorn2 = new ModelRenderer(this, 241, 0);
        this.righthorn2.setRotationPoint(0.0F, 0.0F, 2.8F);
        this.righthorn2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(righthorn2, -0.4363323129985824F, 0.12217304763960307F, 0.0F);
        this.waist = new ModelRenderer(this, 0, 34);
        this.waist.setRotationPoint(-6.0F, 11.0F, -6.0F);
        this.waist.addBox(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
        this.body4 = new ModelRenderer(this, 0, 116);
        this.body4.setRotationPoint(-10.0F, -10.0F, 6.5F);
        this.body4.addBox(0.0F, 0.0F, -17.0F, 20, 8, 17, 0.0F);
        this.setRotateAngle(body4, 0.06981316953897475F, -0.0F, 0.0F);
        this.finger21_1 = new ModelRenderer(this, 225, 33);
        this.finger21_1.setRotationPoint(17.299999237060547F, 2.5F, -20.0F);
        this.finger21_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger21_1, -0.21309528173463158F, -0.05223221672568185F, 0.06990866572962749F);
        this.jaw = new ModelRenderer(this, 240, 49);
        this.jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jaw.addBox(0.5F, 7.0F, -2.5F, 4, 2, 4, 0.0F);
        this.setRotateAngle(jaw, 0.4363323129985824F, -0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 202, 46);
        this.head1.setRotationPoint(-2.5F, -24.0F, -17.5F);
        this.head1.addBox(0.0F, 0.0F, 0.0F, 5, 4, 5, 0.0F);
        this.head2 = new ModelRenderer(this, 223, 49);
        this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head2.addBox(0.5F, 3.9F, 0.6F, 4, 2, 4, 0.0F);
        this.rightwing = new ModelRenderer(this, 151, 0);
        this.rightwing.setRotationPoint(-6.0F, -20.0F, 6.0F);
        this.rightwing.addBox(-14.0F, 0.0F, 0.0F, 14, 9, 0, 0.0F);
        this.setRotateAngle(rightwing, 0.20299471776698425F, 0.22606446757040743F, 0.5387391349116264F);
        this.leftwing = new ModelRenderer(this, 151, 10);
        this.leftwing.setRotationPoint(6.0F, -20.0F, 6.0F);
        this.leftwing.addBox(0.0F, 0.0F, 0.0F, 14, 9, 0, 0.0F);
        this.setRotateAngle(leftwing, 0.20299471776698425F, -0.22606446757040743F, -0.5387391349116264F);
        this.finger32_1 = new ModelRenderer(this, 225, 29);
        this.finger32_1.setRotationPoint(15.399999618530273F, 1.7000000476837158F, -22.5F);
        this.finger32_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger32_1, 0.13962633907794952F, -0.0F, 0.05235987901687623F);
        this.vertebrae1 = new ModelRenderer(this, 243, 7);
        this.vertebrae1.setRotationPoint(0.0F, -24.100000381469727F, -10.5F);
        this.vertebrae1.addBox(0.0F, 0.0F, 0.0F, 0, 17, 3, 0.0F);
        this.setRotateAngle(vertebrae1, 1.483529806137085F, -0.0F, 0.0F);
        this.vertebrae2 = new ModelRenderer(this, 250, 6);
        this.vertebrae2.setRotationPoint(0.0F, -22.0F, 7.0F);
        this.vertebrae2.addBox(0.0F, 0.0F, 0.0F, 0, 18, 3, 0.0F);
        this.setRotateAngle(vertebrae2, 0.03490658476948738F, -0.0F, 0.0F);
        this.lefthorn1 = new ModelRenderer(this, 230, 0);
        this.lefthorn1.setRotationPoint(1.5F, -23.0F, -14.0F);
        this.lefthorn1.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(lefthorn1, 0.8726646259971648F, 0.9599310885968813F, 0.12217304763960307F);
        this.righthorn1 = new ModelRenderer(this, 230, 0);
        this.righthorn1.setRotationPoint(-1.5F, -23.0F, -14.0F);
        this.righthorn1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(righthorn1, 0.8726646259971648F, -0.9599310885968813F, -0.12217304763960307F);
        this.rightforearm = new ModelRenderer(this, 180, 0);
        this.rightforearm.setRotationPoint(-8.0F, -17.0F, 0.0F);
        this.rightforearm.addBox(-6.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
        this.setRotateAngle(rightforearm, -0.5235987901687622F, 0.5235987901687622F, 0.0F);
        this.finger42 = new ModelRenderer(this, 225, 38);
        this.finger42.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.finger42.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger42, 0.19198621771937624F, -0.0F, 0.0F);
        this.body1 = new ModelRenderer(this, 0, 55);
        this.body1.setRotationPoint(-7.0F, 8.0F, 6.5F);
        this.body1.addBox(0.0F, 0.0F, -14.0F, 14, 3, 14, 0.0F);
        this.setRotateAngle(body1, 0.05235987901687623F, -0.0F, 0.0F);
        this.finger31_1 = new ModelRenderer(this, 225, 33);
        this.finger31_1.setRotationPoint(15.399999618530273F, 2.0F, -20.5F);
        this.finger31_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger31_1, -0.13962633907794952F, -0.0F, 0.05235987901687623F);
        this.finger21 = new ModelRenderer(this, 225, 42);
        this.finger21.setRotationPoint(-4.3F, 1.5F, -6.0F);
        this.finger21.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger21, 0.7504915783575618F, -0.03490658503988659F, -0.03490658503988659F);
        this.righthorn3 = new ModelRenderer(this, 252, 1);
        this.righthorn3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.righthorn3.addBox(0.4F, -2.5F, 1.9F, 1, 3, 1, 0.0F);
        this.setRotateAngle(righthorn3, -0.296705972839036F, 0.05235987755982988F, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 94);
        this.body3.setRotationPoint(-9.0F, -2.0F, 6.5F);
        this.body3.addBox(0.0F, 0.0F, -16.0F, 18, 5, 16, 0.0F);
        this.setRotateAngle(body3, 0.06981316953897475F, -0.0F, 0.0F);
        this.finger51_1 = new ModelRenderer(this, 218, 33);
        this.finger51_1.setRotationPoint(13.0F, 5.0F, -19.0F);
        this.finger51_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger51_1, 0.2940720837206191F, 0.3659931338364577F, -0.056077476188642984F);
        this.finger51 = new ModelRenderer(this, 218, 42);
        this.finger51.setRotationPoint(-0.5F, 1.9F, -2.3F);
        this.finger51.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger51, 1.1344640137963142F, -0.3665191429188092F, -0.4363323129985824F);
        this.finger41 = new ModelRenderer(this, 225, 42);
        this.finger41.setRotationPoint(-1.0F, 1.5F, -6.0F);
        this.finger41.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger41, 0.7504915783575618F, -0.03490658503988659F, -0.10471975511965977F);
        this.body5 = new ModelRenderer(this, 0, 142);
        this.body5.setRotationPoint(-10.0F, -19.5F, 6.5F);
        this.body5.addBox(0.0F, 0.0F, -18.0F, 20, 10, 18, 0.0F);
        this.setRotateAngle(body5, 0.05235987901687623F, -0.0F, 0.0F);
        this.finger42_1 = new ModelRenderer(this, 225, 29);
        this.finger42_1.setRotationPoint(13.699999809265137F, 1.7000000476837158F, -22.5F);
        this.finger42_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger42_1, 0.17453292012214658F, -0.0F, 0.05235987901687623F);
        this.finger32 = new ModelRenderer(this, 225, 38);
        this.finger32.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.finger32.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger32, 0.19198621771937624F, -0.0F, 0.0F);
        this.body6 = new ModelRenderer(this, 0, 171);
        this.body6.setRotationPoint(-9.5F, -21.5F, 6.099999904632568F);
        this.body6.addBox(0.0F, 0.0F, -17.0F, 19, 5, 17, 0.0F);
        this.setRotateAngle(body6, -0.1047197580337524F, -0.0F, 0.0F);
        this.spine2 = new ModelRenderer(this, 238, 7);
        this.spine2.setRotationPoint(-0.5F, -22.200000762939453F, 6.0F);
        this.spine2.addBox(0.0F, 0.0F, 0.0F, 1, 19, 1, 0.0F);
        this.setRotateAngle(spine2, 0.03490658476948738F, -0.0F, 0.0F);
        this.finger41_1 = new ModelRenderer(this, 225, 33);
        this.finger41_1.setRotationPoint(13.699999809265137F, 2.0F, -20.5F);
        this.finger41_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(finger41_1, -0.13962633907794952F, -0.0F, 0.05235987901687623F);
        this.lefthorn2.addChild(this.lefthorn3);
        this.rightarm.addChild(this.righthand);
        this.righthand.addChild(this.finger31);
        this.rightforearm.addChild(this.rightarm);
        this.lefthorn1.addChild(this.lefthorn2);
        this.righthand.addChild(this.finger11);
        this.finger11.addChild(this.finger12);
        this.finger21.addChild(this.finger22);
        this.righthorn1.addChild(this.righthorn2);
        this.head1.addChild(this.jaw);
        this.head1.addChild(this.head2);
        this.finger41.addChild(this.finger42);
        this.righthand.addChild(this.finger21);
        this.righthorn2.addChild(this.righthorn3);
        this.righthand.addChild(this.finger51);
        this.righthand.addChild(this.finger41);
        this.finger31.addChild(this.finger32);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        this.finger11_1.render(f5);
        this.finger22_1.render(f5);
        this.body2.render(f5);
        this.leftforearm.render(f5);
        this.lefthand.render(f5);
        this.base2.render(f5);
        this.base1.render(f5);
        this.spine1.render(f5);
        this.finger12_1.render(f5);
        this.leftarm.render(f5);
        this.neck.render(f5);
        this.waist.render(f5);
        this.body4.render(f5);
        this.finger21_1.render(f5);
        this.head1.render(f5);
        this.rightwing.render(f5);
        this.leftwing.render(f5);
        this.finger32_1.render(f5);
        this.vertebrae1.render(f5);
        this.vertebrae2.render(f5);
        this.lefthorn1.render(f5);
        this.righthorn1.render(f5);
        this.rightforearm.render(f5);
        this.body1.render(f5);
        this.finger31_1.render(f5);
        this.body3.render(f5);
        this.finger51_1.render(f5);
        this.body5.render(f5);
        this.finger42_1.render(f5);
        this.body6.render(f5);
        this.spine2.render(f5);
        this.finger41_1.render(f5);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
    {
    	EntityLivingBase entity = ((EntityLivingBase)ent);
    	
	    if(!Minecraft.getMinecraft().isGamePaused())
	    {
	    	//TODO Head animation
	        //this.head1.rotateAngleY = headYaw / (270F / (float)Math.PI);
	        //this.head1.rotateAngleX = headPitch / (360F / (float)Math.PI);
	    	
	    	if( entity.isSwingInProgress )
	    	{
	    		this.rightforearm.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + (float)Math.PI) * 1.2F;
	    		this.rightforearm.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + (float)Math.PI) * -0.2F;
	    		this.rightforearm.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + (float)Math.PI) * 0.5F;
	    	}
	    	else
	    	{
	    		this.rightforearm.rotateAngleX = -0.523F;
	    		this.rightforearm.rotateAngleY = 0.523F;
	    		this.rightforearm.rotateAngleZ = 0;
	    	}
	    }
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public ModelRenderer getHandRenderer() 
	{
		GL11.glScaled(1.2, 1.2, 1);
		GL11.glTranslated(0.2, 0.2, 0.5);
		GL11.glRotated(45, 1, 0, 0);
		return this.rightforearm;
	}
}