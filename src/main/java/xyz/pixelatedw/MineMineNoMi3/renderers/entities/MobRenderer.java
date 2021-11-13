package xyz.pixelatedw.MineMineNoMi3.renderers.entities;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.IDynamicRenderer;

@SideOnly(Side.CLIENT)
public class MobRenderer extends RenderBiped
{

	private ResourceLocation texture;
	private float scale;

	public MobRenderer(ModelBiped model, float scale, String tex)
	{
		super(model, 0.0F);
		this.scale = scale;
		this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/" + tex + ".png");
	}

	public MobRenderer(ModelBiped model, String tex)
	{
		super(model, 0.0F);
		this.scale = 1.0F;
		this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/" + tex + ".png");
	}

	public MobRenderer(ModelBiped model)
	{
		super(model, 0.0F);
		this.scale = 1.0F;
		this.texture = null;
	}

	public void doRender(EntityLivingBase entity, double x, double y, double z, float u, float v)
	{
		super.doRender(entity, x, y, z, u, v);
	}

	protected void preRenderCallback(EntityLivingBase livingBase, float f)
	{
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	protected void renderEquippedItems(EntityLiving entity, float f)
	{
		GL11.glPushMatrix();
		if (entity instanceof IDynamicRenderer)
		{
			GL11.glScaled(((IDynamicRenderer) entity).itemScale()[0], ((IDynamicRenderer) entity).itemScale()[1], ((IDynamicRenderer) entity).itemScale()[2]);
			GL11.glTranslated(((IDynamicRenderer) entity).itemOffset()[0], ((IDynamicRenderer) entity).itemOffset()[1], ((IDynamicRenderer) entity).itemOffset()[2]);
		}

		ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase) entity);
		boolean hasHaki = props.hasBusoHakiActive();

		if(hasHaki)
		{
			this.bindTexture(ID.HANDTEXTURE_ZOANMORPH_BUSO);
			GL11.glColor3d(0.5, 0, 0.5);
			super.renderEquippedItems(entity, f);
		}
		else
		{
			super.renderEquippedItems(entity, f);
		}
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if ((this.texture == null && entity instanceof IDynamicRenderer) || this.texture.equals(new ResourceLocation(ID.PROJECT_ID + ":textures/models/null.png")))
			return new ResourceLocation(ID.PROJECT_ID + ":textures/models/" + ((IDynamicRenderer) entity).getMobTexture() + ".png");
		else
			return this.texture;
	}

}
