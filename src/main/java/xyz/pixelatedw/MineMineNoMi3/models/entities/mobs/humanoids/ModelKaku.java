package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Kaku.tcn - TechneToTabulaImporter
 * Created using Tabula 7.0.0
 */
public class ModelKaku extends ModelBiped {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer nose;
    public ModelRenderer visor;
    public ModelRenderer sword1;
    public ModelRenderer sword2;
    public ModelRenderer sword3;
    public ModelRenderer sword4;

    public ModelKaku() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.sword3 = new ModelRenderer(this, 44, 0);
        this.sword3.setRotationPoint(6.0F, 10.0F, -3.0F);
        this.sword3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 7, 0.0F);
        this.leftarm = new ModelRenderer(this, 40, 16);
        this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.0F, 0.0F, 1.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 6, 8, 6, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.sword4 = new ModelRenderer(this, 36, 0);
        this.sword4.setRotationPoint(6.5F, 10.0F, -15.0F);
        this.sword4.addBox(0.0F, 0.0F, 0.0F, 0, 1, 12, 0.0F);
        this.nose = new ModelRenderer(this, 25, 0);
        this.nose.setRotationPoint(-0.5F, -4.0F, -6.0F);
        this.nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.sword2 = new ModelRenderer(this, 36, 0);
        this.sword2.setRotationPoint(-6.5F, 10.0F, -15.0F);
        this.sword2.addBox(0.0F, 0.0F, 0.0F, 0, 1, 12, 0.0F);
        this.rightarm = new ModelRenderer(this, 40, 16);
        this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.visor = new ModelRenderer(this, 25, 5);
        this.visor.setRotationPoint(-3.0F, -6.0F, -6.0F);
        this.visor.addBox(0.0F, 0.0F, 0.0F, 6, 0, 3, 0.0F);
        this.sword1 = new ModelRenderer(this, 44, 0);
        this.sword1.setRotationPoint(-7.0F, 10.0F, -3.0F);
        this.sword1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 7, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rightleg.render(f5);
        this.sword3.render(f5);
        this.leftarm.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.leftleg.render(f5);
        this.sword4.render(f5);
        this.nose.render(f5);
        this.sword2.render(f5);
        this.rightarm.render(f5);
        this.visor.render(f5);
        this.sword1.render(f5);
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
