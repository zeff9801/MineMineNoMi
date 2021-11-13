package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBisonSpeed extends ModelZoanMorph
{
	public ModelRenderer head1;
	public ModelRenderer head2;
	public ModelRenderer body1;
	public ModelRenderer body2;
	public ModelRenderer body3;
	public ModelRenderer rightleg2;
	public ModelRenderer leftleg2;
	public ModelRenderer rearleftleg1;
	public ModelRenderer rearrightleg1;
	public ModelRenderer righthorn1;
	public ModelRenderer righthorn2;
	public ModelRenderer lefthorn1;
	public ModelRenderer lefthorn2;
	public ModelRenderer tail;
	public ModelRenderer rightleg1;
	public ModelRenderer righthull2;
	public ModelRenderer righthull1;
	public ModelRenderer leftleg1;
	public ModelRenderer lefthull1;
	public ModelRenderer lefthull2;
	public ModelRenderer rearlefthull1;
	public ModelRenderer rearlefthull2;
	public ModelRenderer rearrighthull1;
	public ModelRenderer rearrighthull2;

	public ModelBisonSpeed()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.rearrighthull2 = new ModelRenderer(this, 0, 52);
		this.rearrighthull2.setRotationPoint(0.0F, 9.1F, -0.5F);
		this.rearrighthull2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rearrighthull2, -0.12112585008840647F, -0.4883431247080134F, -0.03944444109507184F);
		this.righthull1 = new ModelRenderer(this, 0, 55);
		this.righthull1.setRotationPoint(0.0F, 3.1F, -0.5F);
		this.righthull1.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(righthull1, -0.12112585008840647F, 0.4883431247080134F, 0.03944444109507184F);
		this.lefthorn2 = new ModelRenderer(this, 122, 0);
		this.lefthorn2.setRotationPoint(2.0999999046325684F, 6.099999904632568F, -5.0F);
		this.lefthorn2.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(lefthorn2, 0.0F, -0.0F, -1.9024088382720947F);
		this.head1 = new ModelRenderer(this, 13, 29);
		this.head1.setRotationPoint(-2.5F, 8.0F, -8.5F);
		this.head1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
		this.setRotateAngle(head1, 0.08726646006107329F, -0.0F, 0.0F);
		this.righthull2 = new ModelRenderer(this, 0, 55);
		this.righthull2.setRotationPoint(0.0F, 3.1F, -0.5F);
		this.righthull2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(righthull2, -0.12112585008840647F, -0.4883431247080134F, -0.03944444109507184F);
		this.body3 = new ModelRenderer(this, 76, 0);
		this.body3.setRotationPoint(-4.0F, 7.0F, 7.0F);
		this.body3.addBox(0.0F, 0.0F, 0.0F, 8, 7, 8, 0.0F);
		this.leftleg1 = new ModelRenderer(this, 0, 22);
		this.leftleg1.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.leftleg1.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.head2 = new ModelRenderer(this, 13, 40);
		this.head2.setRotationPoint(-2.0F, 10.0F, -11.0F);
		this.head2.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
		this.setRotateAngle(head2, 0.08726646006107329F, -0.0F, 0.0F);
		this.righthorn2 = new ModelRenderer(this, 122, 0);
		this.righthorn2.setRotationPoint(-2.0999999046325684F, 6.099999904632568F, -5.0F);
		this.righthorn2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(righthorn2, 0.0F, -0.0F, 1.9024088382720947F);
		this.tail = new ModelRenderer(this, 110, 0);
		this.tail.setRotationPoint(0.0F, 10.0F, 14.5F);
		this.tail.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(tail, 0.3490658503988659F, -0.0F, 0.0F);
		this.lefthull2 = new ModelRenderer(this, 0, 55);
		this.lefthull2.setRotationPoint(0.0F, 3.1F, -0.5F);
		this.lefthull2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(lefthull2, -0.12112585008840647F, -0.4883431247080134F, -0.03944444109507184F);
		this.righthorn1 = new ModelRenderer(this, 115, 0);
		this.righthorn1.setRotationPoint(-3.0F, 7.0F, -5.0F);
		this.righthorn1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(righthorn1, 0.0F, -0.0F, 0.7330383062362671F);
		this.rearleftleg1 = new ModelRenderer(this, 0, 39);
		this.rearleftleg1.setRotationPoint(3.0F, 14.0F, 14.0F);
		this.rearleftleg1.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.rearrighthull1 = new ModelRenderer(this, 0, 52);
		this.rearrighthull1.setRotationPoint(0.0F, 9.1F, -0.5F);
		this.rearrighthull1.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rearrighthull1, -0.12112585008840647F, 0.4883431247080134F, 0.03944444109507184F);
		this.rearrightleg1 = new ModelRenderer(this, 0, 39);
		this.rearrightleg1.setRotationPoint(-3.0F, 14.0F, 14.0F);
		this.rearrightleg1.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.rearlefthull2 = new ModelRenderer(this, 0, 52);
		this.rearlefthull2.setRotationPoint(0.0F, 9.1F, -0.5F);
		this.rearlefthull2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rearlefthull2, -0.12112585008840647F, 0.4883431247080134F, 0.03944444109507184F);
		this.body1 = new ModelRenderer(this, 0, 0);
		this.body1.setRotationPoint(-4.5F, 7.0F, -3.5F);
		this.body1.addBox(0.0F, 0.0F, 0.0F, 9, 7, 11, 0.0F);
		this.body2 = new ModelRenderer(this, 41, 0);
		this.body2.setRotationPoint(-4.0F, 2.0F, 0.0F);
		this.body2.addBox(0.0F, 0.0F, 0.0F, 8, 6, 9, 0.0F);
		this.setRotateAngle(body2, -0.593411922454834F, -0.0F, 0.0F);
		this.lefthull1 = new ModelRenderer(this, 0, 55);
		this.lefthull1.setRotationPoint(0.0F, 3.1F, -0.5F);
		this.lefthull1.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(lefthull1, -0.12112585008840647F, 0.4883431247080134F, 0.03944444109507184F);
		this.rearlefthull1 = new ModelRenderer(this, 0, 52);
		this.rearlefthull1.setRotationPoint(0.0F, 9.1F, -0.5F);
		this.rearlefthull1.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rearlefthull1, -0.12112585008840647F, -0.4883431247080134F, -0.03944444109507184F);
		this.leftleg2 = new ModelRenderer(this, 0, 29);
		this.leftleg2.setRotationPoint(3.0F, 14.0F, 0.0F);
		this.leftleg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 3, 0.0F);
		this.rightleg1 = new ModelRenderer(this, 0, 22);
		this.rightleg1.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.rightleg1.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.rightleg2 = new ModelRenderer(this, 0, 29);
		this.rightleg2.setRotationPoint(-3.0F, 14.0F, 0.0F);
		this.rightleg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 3, 0.0F);
		this.lefthorn1 = new ModelRenderer(this, 115, 0);
		this.lefthorn1.setRotationPoint(3.0F, 7.0F, -5.0F);
		this.lefthorn1.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(lefthorn1, 0.0F, -0.0F, -0.7330383062362671F);
		this.rearrightleg1.addChild(this.rearrighthull2);
		this.rightleg1.addChild(this.righthull1);
		this.rightleg1.addChild(this.righthull2);
		this.leftleg2.addChild(this.leftleg1);
		this.leftleg1.addChild(this.lefthull2);
		this.rearrightleg1.addChild(this.rearrighthull1);
		this.rearleftleg1.addChild(this.rearlefthull2);
		this.leftleg1.addChild(this.lefthull1);
		this.rearleftleg1.addChild(this.rearlefthull1);
		this.rightleg2.addChild(this.rightleg1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.righthorn2.render(f5);
		this.rearrightleg1.render(f5);
		this.lefthorn1.render(f5);
		this.head1.render(f5);
		this.lefthorn2.render(f5);
		this.body2.render(f5);
		this.rightleg2.render(f5);
		this.righthorn1.render(f5);
		this.head2.render(f5);
		this.body1.render(f5);
		this.tail.render(f5);
		this.leftleg2.render(f5);
		this.rearleftleg1.render(f5);
		this.body3.render(f5);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
	{
		leftleg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
		rightleg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.3F * limbSwingAmount;

		rearrightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		rearleftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public ModelRenderer getHandRenderer()
	{
		return null;
	}
}