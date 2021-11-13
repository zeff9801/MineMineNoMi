package xyz.pixelatedw.MineMineNoMi3.renderers.effects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelCandleLock;

public class RenderCandleLock extends Render
{
	private final ResourceLocation texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/zoanmorph/candlelock.png");
	private final ModelCandleLock model;
	private final double scale;
	private final float[] offset = new float[3];
	
	public RenderCandleLock(ModelBase model)
	{
		this.shadowSize = 0;
		this.model = (ModelCandleLock) model;
		this.scale = 1;
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v) 
	{
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float) x + this.offset[0], (float)y + 1.3F + this.offset[1], (float) z + this.offset[2]);

		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
    	GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * v - 180.0F, 0.0F, 1.0F, 0.0F);
		
    	GL11.glScaled(this.scale, this.scale, this.scale);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(this.getEntityTexture(entity));
		this.model.render(entity, 0.0F, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
		
		GL11.glPopMatrix();
	}

	public ResourceLocation getEntityTexture(Entity p_110775_1_) 
	{
		return texture;
	}

}