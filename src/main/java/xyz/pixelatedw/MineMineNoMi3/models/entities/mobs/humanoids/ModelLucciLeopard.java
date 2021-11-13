package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Hybrid Leopard Lucci.tcn - TechneToTabulaImporter
 * Created using Tabula 7.0.0
 */
public class ModelLucciLeopard extends ModelBiped {
    public ModelRenderer head;
    public ModelRenderer hair1;
    public ModelRenderer hair2;
    public ModelRenderer hair3;
    public ModelRenderer nose;
    public ModelRenderer body1;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer rightleg;
    public ModelRenderer rightleg2;
    public ModelRenderer rightleg3;
    public ModelRenderer rightfoot;
    public ModelRenderer leftleg;
    public ModelRenderer leftleg2;
    public ModelRenderer leftleg3;
    public ModelRenderer leftlfoot;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer rightarm1;
    public ModelRenderer rightarm2;
    public ModelRenderer righthand1;
    public ModelRenderer righthand2;
    public ModelRenderer leftarm1;
    public ModelRenderer leftarm2;
    public ModelRenderer lefthand1;
    public ModelRenderer lefthand2;
    public ModelRenderer rightear1;
    public ModelRenderer rightear2;
    public ModelRenderer leftear1;
    public ModelRenderer lefthear2;

    public ModelLucciLeopard() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.tail3 = new ModelRenderer(this, 75, 56);
        this.tail3.setRotationPoint(-0.5F, 11.699999809265137F, 13.199999809265137F);
        this.tail3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
        this.setRotateAngle(tail3, 1.0471975803375244F, -0.0F, 0.0F);
        this.body1 = new ModelRenderer(this, 0, 0);
        this.body1.setRotationPoint(-4.5F, -7.0F, 0.0F);
        this.body1.addBox(0.0F, 0.0F, 0.0F, 9, 18, 5, 0.0F);
        this.leftleg = new ModelRenderer(this, 52, 18);
        this.leftleg.setRotationPoint(2.0F, 18.100000381469727F, 2.5F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leftleg, -0.34906584024429316F, -0.0F, 0.0F);
        this.leftleg2 = new ModelRenderer(this, 52, 12);
        this.leftleg2.setRotationPoint(2.0F, 17.799999237060547F, 1.0F);
        this.leftleg2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(leftleg2, 0.6981316804885863F, -0.0F, 0.0F);
        this.hair3 = new ModelRenderer(this, 29, 23);
        this.hair3.setRotationPoint(-2.0F, -2.0F, 5.300000190734863F);
        this.hair3.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
        this.rightleg = new ModelRenderer(this, 52, 18);
        this.rightleg.setRotationPoint(-4.0F, 18.100000381469727F, 2.5F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(rightleg, -0.34906584024429316F, -0.0F, 0.0F);
        this.leftlfoot = new ModelRenderer(this, 29, 1);
        this.leftlfoot.setRotationPoint(3.5F, 23.0F, 0.0F);
        this.leftlfoot.addBox(-2.0F, 0.0F, -2.0F, 3, 1, 3, 0.0F);
        this.rightleg2 = new ModelRenderer(this, 52, 12);
        this.rightleg2.setRotationPoint(-4.0F, 17.799999237060547F, 1.0F);
        this.rightleg2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(rightleg2, 0.6981316804885863F, -0.0F, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 24);
        this.body3.setRotationPoint(-8.899999618530273F, -5.5F, 0.0F);
        this.body3.addBox(0.0F, 0.0F, 0.0F, 8, 13, 5, 0.0F);
        this.setRotateAngle(body3, 0.0F, -0.0F, -0.34906584024429316F);
        this.righthand1 = new ModelRenderer(this, 105, 59);
        this.righthand1.setRotationPoint(-11.300000190734863F, 11.5F, 2.0F);
        this.righthand1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(righthand1, 0.0F, -0.0F, -0.17453292012214658F);
        this.nose = new ModelRenderer(this, 65, 11);
        this.nose.setRotationPoint(-0.5F, -8.5F, -1.5F);
        this.nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(nose, 0.7853981852531433F, -0.0F, 0.0F);
        this.rightear2 = new ModelRenderer(this, 125, 60);
        this.rightear2.setRotationPoint(-2.0999999046325684F, -11.899999618530273F, 0.0F);
        this.rightear2.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(rightear2, 0.0F, -0.0F, -0.5410520434379578F);
        this.lefthear2 = new ModelRenderer(this, 125, 60);
        this.lefthear2.setRotationPoint(2.0F, -11.800000190734863F, 0.0F);
        this.lefthear2.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(lefthear2, 0.0F, -0.0F, 0.5410520434379578F);
        this.tail1 = new ModelRenderer(this, 90, 56);
        this.tail1.setRotationPoint(-0.5F, 8.0F, 5.0F);
        this.tail1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
        this.setRotateAngle(tail1, -0.8726646304130553F, -0.0F, 0.0F);
        this.lefthand2 = new ModelRenderer(this, 115, 60);
        this.lefthand2.setRotationPoint(8.199999809265137F, 11.0F, 2.0F);
        this.lefthand2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(lefthand2, 0.0F, -0.0F, 0.6108652353286743F);
        this.body2 = new ModelRenderer(this, 0, 43);
        this.body2.setRotationPoint(1.399999976158142F, -8.199999809265137F, 0.0F);
        this.body2.addBox(0.0F, 0.0F, 0.0F, 8, 13, 5, 0.0F);
        this.setRotateAngle(body2, 0.0F, -0.0F, 0.34906584024429316F);
        this.lefthand1 = new ModelRenderer(this, 105, 59);
        this.lefthand1.setRotationPoint(8.199999809265137F, 10.800000190734863F, 2.0F);
        this.lefthand1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(lefthand1, 0.0F, -0.0F, 0.17453292012214658F);
        this.rightear1 = new ModelRenderer(this, 121, 60);
        this.rightear1.setRotationPoint(-2.9000000953674316F, -11.399999618530273F, 1.0F);
        this.rightear1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 0, 0.0F);
        this.setRotateAngle(rightear1, 0.0F, -0.0F, -0.5410520434379578F);
        this.head = new ModelRenderer(this, 65, 0);
        this.head.setRotationPoint(-2.0F, -11.0F, -1.0F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
        this.rightfoot = new ModelRenderer(this, 29, 1);
        this.rightfoot.setRotationPoint(-2.5F, 23.0F, 0.0F);
        this.rightfoot.addBox(-2.0F, 0.0F, -2.0F, 3, 1, 3, 0.0F);
        this.tail2 = new ModelRenderer(this, 90, 56);
        this.tail2.mirror = true;
        this.tail2.setRotationPoint(-0.5F, 12.300000190734863F, 8.0F);
        this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
        this.setRotateAngle(tail2, 0.17453292012214658F, -0.0F, 0.0F);
        this.leftleg3 = new ModelRenderer(this, 52, 0);
        this.leftleg3.setRotationPoint(1.5F, 10.0F, 1.2000000476837158F);
        this.leftleg3.addBox(0.0F, 0.0F, 0.0F, 3, 8, 3, 0.0F);
        this.setRotateAngle(leftleg3, -0.1047197580337524F, -0.0F, 0.0F);
        this.leftarm2 = new ModelRenderer(this, 116, 42);
        this.leftarm2.setRotationPoint(8.399999618530273F, 3.4000000953674316F, 1.0F);
        this.leftarm2.addBox(0.0F, 0.0F, 0.0F, 3, 8, 3, 0.0F);
        this.setRotateAngle(leftarm2, 0.0F, -0.0F, 0.03490658476948738F);
        this.righthand2 = new ModelRenderer(this, 115, 60);
        this.righthand2.setRotationPoint(-9.0F, 11.800000190734863F, 2.0F);
        this.righthand2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(righthand2, 0.0F, -0.0F, -0.6108652353286743F);
        this.leftarm1 = new ModelRenderer(this, 112, 29);
        this.leftarm1.setRotationPoint(4.699999809265137F, -2.0F, 0.5F);
        this.leftarm1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(leftarm1, 0.0F, -0.0F, -0.43633231520652765F);
        this.rightarm2 = new ModelRenderer(this, 116, 42);
        this.rightarm2.setRotationPoint(-11.5F, 3.5999999046325684F, 1.0F);
        this.rightarm2.addBox(0.0F, 0.0F, 0.0F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rightarm2, 0.0F, -0.0F, -0.03490658476948738F);
        this.hair1 = new ModelRenderer(this, 29, 6);
        this.hair1.setRotationPoint(-2.5F, -11.0F, 4.0F);
        this.hair1.addBox(0.0F, 0.0F, 0.0F, 5, 4, 2, 0.0F);
        this.setRotateAngle(hair1, 0.34906584024429316F, -0.0F, 0.0F);
        this.rightarm1 = new ModelRenderer(this, 112, 29);
        this.rightarm1.setRotationPoint(-8.300000190734863F, -3.700000047683716F, 0.5F);
        this.rightarm1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(rightarm1, 0.0F, -0.0F, 0.43633231520652765F);
        this.leftear1 = new ModelRenderer(this, 121, 60);
        this.leftear1.setRotationPoint(2.0F, -11.800000190734863F, 1.0F);
        this.leftear1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 0, 0.0F);
        this.setRotateAngle(leftear1, 0.0F, -0.0F, 0.5410520434379578F);
        this.rightleg3 = new ModelRenderer(this, 52, 0);
        this.rightleg3.setRotationPoint(-4.5F, 10.0F, 1.2000000476837158F);
        this.rightleg3.addBox(0.0F, 0.0F, 0.0F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rightleg3, -0.1047197580337524F, -0.0F, 0.0F);
        this.hair2 = new ModelRenderer(this, 29, 13);
        this.hair2.setRotationPoint(-3.0F, -8.0F, 5.300000190734863F);
        this.hair2.addBox(0.0F, 0.0F, 0.0F, 6, 6, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)    
	{ 
    	
		this.bipedLeftLeg.isHidden = true;
		this.bipedRightLeg.isHidden = true;
		this.bipedLeftArm.isHidden = true;
		this.bipedRightArm.isHidden = true;
		this.bipedBody.isHidden = true;
		this.bipedHead.isHidden = true;
    	
        this.tail3.render(f5);
        this.body1.render(f5);
        this.leftleg.render(f5);
        this.leftleg2.render(f5);
        this.hair3.render(f5);
        this.rightleg.render(f5);
        this.leftlfoot.render(f5);
        this.rightleg2.render(f5);
        this.body3.render(f5);
        this.righthand1.render(f5);
        this.nose.render(f5);
        this.rightear2.render(f5);
        this.lefthear2.render(f5);
        this.tail1.render(f5);
        this.lefthand2.render(f5);
        this.body2.render(f5);
        this.lefthand1.render(f5);
        this.rightear1.render(f5);
        this.head.render(f5);
        this.rightfoot.render(f5);
        this.tail2.render(f5);
        this.leftleg3.render(f5);
        this.leftarm2.render(f5);
        this.righthand2.render(f5);
        this.leftarm1.render(f5);
        this.rightarm2.render(f5);
        this.hair1.render(f5);
        this.rightarm1.render(f5);
        this.leftear1.render(f5);
        this.rightleg3.render(f5);
        this.hair2.render(f5);
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
