package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBazooka extends ModelBase
{
	public ModelRenderer rightarm;
	public ModelRenderer leftarm;
	public ModelRenderer righthand;
	public ModelRenderer rightfinger10;
	public ModelRenderer rightfinger11;
	public ModelRenderer rightfinger20;
	public ModelRenderer rightfinger21;
	public ModelRenderer rightfinger30;
	public ModelRenderer rightfinger31;
	public ModelRenderer rightfinger40;
	public ModelRenderer rightfinger41;
	public ModelRenderer rightfinger50;
	public ModelRenderer lefthand;
	public ModelRenderer leftfinger10;
	public ModelRenderer leftfinger11;
	public ModelRenderer leftfinger20;
	public ModelRenderer leftfinger21;
	public ModelRenderer leftfinger30;
	public ModelRenderer leftfinger31;
	public ModelRenderer leftfinger40;
	public ModelRenderer leftfinger41;
	public ModelRenderer leftfinger50;

	public ModelBazooka()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.rightfinger20 = new ModelRenderer(this, 17, 6);
		this.rightfinger20.setRotationPoint(-3.9000000953674316F, 7.5F, -10.399999618530273F);
		this.rightfinger20.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger20, -1.5861630689193318F, 0.1738619824220216F, -0.08860570372773739F);
		this.leftfinger21 = new ModelRenderer(this, 17, 10);
		this.leftfinger21.setRotationPoint(4.300000190734863F, 7.5F, -11.600000381469727F);
		this.leftfinger21.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(leftfinger21, -1.5551676149207603F, 0.6602555273375126F, 0.11057186725363863F);
		this.leftfinger20 = new ModelRenderer(this, 17, 6);
		this.leftfinger20.setRotationPoint(3.9000000953674316F, 7.5F, -10.399999618530273F);
		this.leftfinger20.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(leftfinger20, -1.5861630689193318F, -0.1738619824220216F, 0.08860570372773739F);
		this.leftfinger10 = new ModelRenderer(this, 17, 6);
		this.leftfinger10.setRotationPoint(3.9000000953674316F, 8.5F, -10.399999618530273F);
		this.leftfinger10.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(leftfinger10, -1.5859874479621299F, -0.08593738767230333F, 0.17518607543307713F);
		this.leftfinger31 = new ModelRenderer(this, 17, 10);
		this.leftfinger31.setRotationPoint(4.300000190734863F, 6.5F, -11.600000381469727F);
		this.leftfinger31.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(leftfinger31, -1.5709533680144794F, 0.6439374485599775F, -0.08733512567168028F);
		this.rightfinger40 = new ModelRenderer(this, 17, 6);
		this.rightfinger40.setRotationPoint(-3.9000000953674316F, 5.5F, -10.399999618530273F);
		this.rightfinger40.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger40, -1.548156507116753F, 0.08428574030529916F, 0.2627541098554542F);
		this.rightfinger41 = new ModelRenderer(this, 17, 10);
		this.rightfinger41.setRotationPoint(-4.300000190734863F, 5.400000095367432F, -11.600000381469727F);
		this.rightfinger41.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rightfinger41, -1.5916332605651753F, -0.7872448808866414F, 0.24858259380151068F);
		this.leftfinger50 = new ModelRenderer(this, 22, 6);
		this.leftfinger50.setRotationPoint(0.5F, 5.0F, -9.800000190734863F);
		this.leftfinger50.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(leftfinger50, -2.094395160675049F, 0.08726646006107329F, 0.0F);
		this.rightfinger21 = new ModelRenderer(this, 17, 10);
		this.rightfinger21.setRotationPoint(-4.300000190734863F, 7.5F, -11.600000381469727F);
		this.rightfinger21.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rightfinger21, -1.5551676149207603F, -0.6602555273375126F, -0.11057186725363863F);
		this.rightfinger50 = new ModelRenderer(this, 22, 6);
		this.rightfinger50.setRotationPoint(-0.5F, 5.0F, -9.800000190734863F);
		this.rightfinger50.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger50, -2.094395160675049F, -0.08726646006107329F, 0.0F);
		this.lefthand = new ModelRenderer(this, 17, 0);
		this.lefthand.setRotationPoint(2.299999952316284F, 7.0F, -10.0F);
		this.lefthand.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
		this.setRotateAngle(lefthand, -1.5707963705062866F, 0.17453292012214658F, 0.0F);
		this.rightfinger30 = new ModelRenderer(this, 17, 6);
		this.rightfinger30.setRotationPoint(-3.9000000953674316F, 6.5F, -10.399999618530273F);
		this.rightfinger30.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger30, -1.5554296720932415F, 0.1738619824220216F, 0.08860570372773739F);
		this.leftfinger40 = new ModelRenderer(this, 17, 6);
		this.leftfinger40.setRotationPoint(3.9000000953674316F, 5.5F, -10.399999618530273F);
		this.leftfinger40.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(leftfinger40, -1.548156507116753F, -0.08428574030529916F, -0.2627541098554542F);
		this.rightarm = new ModelRenderer(this, 0, 0);
		this.rightarm.setRotationPoint(-2.299999952316284F, 7.0F, 0.0F);
		this.rightarm.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
		this.setRotateAngle(rightarm, -1.5707963705062866F, -0.0F, 0.0F);
		this.leftarm = new ModelRenderer(this, 0, 0);
		this.leftarm.setRotationPoint(2.299999952316284F, 7.0F, 0.0F);
		this.leftarm.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
		this.setRotateAngle(leftarm, -1.5707963705062866F, -0.0F, 0.0F);
		this.rightfinger31 = new ModelRenderer(this, 17, 10);
		this.rightfinger31.setRotationPoint(-4.300000190734863F, 6.5F, -11.600000381469727F);
		this.rightfinger31.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rightfinger31, -1.5709533680144794F, -0.6439374485599775F, 0.08733512567168028F);
		this.leftfinger30 = new ModelRenderer(this, 17, 6);
		this.leftfinger30.setRotationPoint(3.9000000953674316F, 6.5F, -10.399999618530273F);
		this.leftfinger30.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(leftfinger30, -1.5554296720932415F, -0.1738619824220216F, -0.08860570372773739F);
		this.righthand = new ModelRenderer(this, 17, 0);
		this.righthand.setRotationPoint(-2.299999952316284F, 7.0F, -10.0F);
		this.righthand.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
		this.setRotateAngle(righthand, -1.5707963705062866F, -0.17453292012214658F, 0.0F);
		this.rightfinger11 = new ModelRenderer(this, 17, 10);
		this.rightfinger11.setRotationPoint(-4.300000190734863F, 8.600000381469727F, -11.600000381469727F);
		this.rightfinger11.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rightfinger11, -1.6060332597431428F, -0.7816000870348907F, -0.12310202715083182F);
		this.rightfinger10 = new ModelRenderer(this, 17, 6);
		this.rightfinger10.setRotationPoint(-3.9000000953674316F, 8.5F, -10.399999618530273F);
		this.rightfinger10.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightfinger10, -1.5859874479621299F, 0.08593738767230333F, -0.17518607543307713F);
		this.leftfinger41 = new ModelRenderer(this, 17, 10);
		this.leftfinger41.setRotationPoint(4.300000190734863F, 5.400000095367432F, -11.600000381469727F);
		this.leftfinger41.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(leftfinger41, -1.5916332605651753F, 0.7872448808866414F, -0.24858259380151068F);
		this.leftfinger11 = new ModelRenderer(this, 17, 10);
		this.leftfinger11.setRotationPoint(4.300000190734863F, 8.600000381469727F, -11.600000381469727F);
		this.leftfinger11.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(leftfinger11, -1.6060332597431428F, 0.7816000870348907F, 0.12310202715083182F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.rightfinger20.render(f5);
		this.leftfinger21.render(f5);
		this.leftfinger20.render(f5);
		this.leftfinger10.render(f5);
		this.leftfinger31.render(f5);
		this.rightfinger40.render(f5);
		this.rightfinger41.render(f5);
		this.leftfinger50.render(f5);
		this.rightfinger21.render(f5);
		this.rightfinger50.render(f5);
		this.lefthand.render(f5);
		this.rightfinger30.render(f5);
		this.leftfinger40.render(f5);
		this.rightarm.render(f5);
		this.leftarm.render(f5);
		this.rightfinger31.render(f5);
		this.leftfinger30.render(f5);
		this.righthand.render(f5);
		this.rightfinger11.render(f5);
		this.rightfinger10.render(f5);
		this.leftfinger41.render(f5);
		this.leftfinger11.render(f5);
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
