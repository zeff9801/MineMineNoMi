package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Negative Hollow Attack.tcn - TechneToTabulaImporter
 * Created using Tabula 7.0.0
 */
public class ModelNegativeHollow extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightarm1;
    public ModelRenderer rightarm2;
    public ModelRenderer leftarm1;
    public ModelRenderer leftarm2;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;

    public ModelNegativeHollow() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 35, 0);
        this.body.setRotationPoint(0.0F, 5.0F, -6.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 3, 8, 2, 0.0F);
        this.setRotateAngle(body, 1.5707963705062866F, -0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 46, 0);
        this.leftleg.setRotationPoint(2.0F, 4.5F, 2.0F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(leftleg, 1.5707963705062866F, -0.0F, 0.0F);
        this.rightarm1 = new ModelRenderer(this, 28, 0);
        this.rightarm1.setRotationPoint(-3.0F, 5.0F, -9.0F);
        this.rightarm1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(rightarm1, 1.5707963705062866F, 0.5585053563117981F, 0.0F);
        this.leftarm1 = new ModelRenderer(this, 28, 0);
        this.leftarm1.setRotationPoint(5.0F, 5.0F, -9.5F);
        this.leftarm1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(leftarm1, 1.5707963705062866F, -0.5585053563117981F, 0.0F);
        this.leftarm2 = new ModelRenderer(this, 17, 0);
        this.leftarm2.setRotationPoint(4.0F, 5.5F, -14.5F);
        this.leftarm2.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
        this.setRotateAngle(leftarm2, 1.5707963705062866F, -0.0F, 0.0F);
        this.rightarm2 = new ModelRenderer(this, 17, 0);
        this.rightarm2.setRotationPoint(-3.0F, 5.5F, -14.5F);
        this.rightarm2.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
        this.setRotateAngle(rightarm2, 1.5707963705062866F, -0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 46, 0);
        this.rightleg.setRotationPoint(0.0F, 4.5F, 2.0F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rightleg, 1.5707963705062866F, -0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.mirror = true;
        this.head.setRotationPoint(-0.5F, 2.0F, -10.0F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
        this.leftleg.render(f5);
        this.rightarm1.render(f5);
        this.leftarm1.render(f5);
        this.leftarm2.render(f5);
        this.rightarm2.render(f5);
        this.rightleg.render(f5);
        this.head.render(f5);
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
