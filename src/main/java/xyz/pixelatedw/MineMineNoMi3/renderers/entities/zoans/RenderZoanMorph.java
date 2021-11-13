package xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.MorphsHelper;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelZoanMorph;

public class RenderZoanMorph extends Render
{
	private ResourceLocation texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/null.png");
	private ModelBase model;
	private double scale;
	private float offset[] = new float[3];

	public RenderZoanMorph(ModelBase model, String texture)
	{
		this.shadowSize = 0;
		this.model = model;
		this.scale = 1;
		
		if (texture.contentEquals("$playerskin"))
		{
			ResourceLocation rs = AbstractClientPlayer.locationStevePng;

			Minecraft minecraft = Minecraft.getMinecraft();
			Map map = minecraft.func_152342_ad().func_152788_a(minecraft.thePlayer.getGameProfile());

			if (map.containsKey(Type.SKIN))
				rs = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture) map.get(Type.SKIN), Type.SKIN);

			this.texture = rs;
		}
		else
			this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/zoanmorph/" + texture + ".png");
		
		this.offset = new float[]
		{
				0, 0, 0
		};

		this.renderManager = RenderManager.instance;
	}

	public RenderZoanMorph(ModelBase model, String texture, double scale)
	{
		this.shadowSize = 0;
		this.model = model;
		this.scale = scale;
		if (texture.contentEquals("$playerskin"))
		{
			ResourceLocation rs = AbstractClientPlayer.locationStevePng;

			Minecraft minecraft = Minecraft.getMinecraft();
			Map map = minecraft.func_152342_ad().func_152788_a(minecraft.thePlayer.getGameProfile());

			if (map.containsKey(Type.SKIN))
				rs = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture) map.get(Type.SKIN), Type.SKIN);

			this.texture = rs;
		}
		else
			this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/zoanmorph/" + texture + ".png");
		this.offset = new float[]
		{
				0, 0, 0
		};

		this.renderManager = RenderManager.instance;
	}

	public RenderZoanMorph(ModelBase model, String texture, double scale, float offset[])
	{
		this.shadowSize = 0;
		this.model = model;
		this.scale = scale;
		if (texture.contentEquals("$playerskin"))
		{
			ResourceLocation rs = AbstractClientPlayer.locationStevePng;

			Minecraft minecraft = Minecraft.getMinecraft();
			Map map = minecraft.func_152342_ad().func_152788_a(minecraft.thePlayer.getGameProfile());

			if (map.containsKey(Type.SKIN))
				rs = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture) map.get(Type.SKIN), Type.SKIN);

			this.texture = rs;
		}
		else
			this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/zoanmorph/" + texture + ".png");
		this.offset = offset;

		this.renderManager = RenderManager.instance;
	}

	public void renderFirstPersonArm(EntityPlayer player)
	{
		float f = 1.0F;
		GL11.glColor3f(f, f, f);
		if (this.model instanceof ModelZoanMorph && ((ModelZoanMorph) this.model).getHandRenderer() != null)
			((ModelZoanMorph) this.model).getHandRenderer().render(0.0625F);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v)
	{
		EntityLivingBase entityLiving = ((EntityLivingBase) entity);

		GL11.glPushMatrix();

		GL11.glTranslatef((float) x + this.offset[0], (float) y + 1.3F + this.offset[1], (float) z + this.offset[2]);

		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		// GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw -
		// entity.prevRotationYaw) * v - 180.0F, 0.0F, 1.0F, 0.0F);

		GL11.glScaled(this.scale, this.scale, this.scale);
		//GL11.glScalef(1.0F, 1.0F, 1.0F);

		float ageInTicks = entityLiving.ticksExisted + v;

		float headYawOffset = this.interpolateRotation(entityLiving.prevRenderYawOffset, entityLiving.renderYawOffset, v);
		float headYaw = this.interpolateRotation(entityLiving.prevRotationYawHead, entityLiving.rotationYawHead, v);

		float headPitch = entityLiving.prevRotationPitch + (entityLiving.rotationPitch - entityLiving.prevRotationPitch) * v;

		this.rotateCorpse(entityLiving, ageInTicks, headYawOffset, v);

		float limbSwingAmount = entityLiving.prevLimbSwingAmount + (entityLiving.limbSwingAmount - entityLiving.prevLimbSwingAmount) * v;
		float limbSwing = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - v);

		this.model.onGround = entityLiving.getSwingProgress(v);

		Minecraft.getMinecraft().renderEngine.bindTexture(this.getEntityTexture(entity));
		this.model.render(entityLiving, limbSwing, limbSwingAmount, ageInTicks, headYaw - headYawOffset, headPitch, 0.0625F);

		//GL11.glScaled(this.scale/2, this.scale/2, this.scale/2);
		// In-hand item rendering
		GL11.glPushMatrix();
		{
			GL11.glDisable(GL11.GL_CULL_FACE);
			ModelRenderer hand = ((ModelZoanMorph) this.model).getHandRenderer();
			if(hand != null)
			{
				//System.out.println(hand.rotateAngleY);
				GL11.glRotated(hand.rotateAngleX * 50, 1, 0, 0);
				this.renderEquippedItems(entityLiving, v);
			}
			/*OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);*/

			// Some Rendering shits

			/*OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);*/
			
			GL11.glEnable(GL11.GL_CULL_FACE);
		}
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}

	protected void renderEquippedItems(EntityLivingBase entity, float age)
	{
		GL11.glColor3f(1.0F, 1.0F, 1.0F);

		ItemStack itemstack = entity.getHeldItem();
		Item item;
		float f1;

		if (itemstack != null && itemstack.getItem() != null)
		{
			item = itemstack.getItem();
			GL11.glPushMatrix();

			ExtendedEntityData props = ExtendedEntityData.get(entity);

			if(props == null || props.getZoanPoint().equalsIgnoreCase("n/a"))
				return;
			
			Optional<Object[]> opt = Arrays.stream(MorphsHelper.getMorphsMap().get(props.getUsedFruit())).filter(x ->
			{
				return props.getZoanPoint().equalsIgnoreCase((String) x[0]);
			}).findFirst();

			if(opt == null || opt.get()[3] == null)
			{
				GL11.glPopMatrix();
				return;
			}

			float[] itemOffset = (float[]) opt.get()[3];
						
			GL11.glTranslatef(itemOffset[0], itemOffset[1], itemOffset[2]);

			net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(itemstack, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, itemstack, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D));

			if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())))
			{
				f1 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				f1 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(-f1, -f1, f1);
			}
			else if (item == Items.bow)
			{
				f1 = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else if (item.isFull3D())
			{
				f1 = 0.625F;

				if (item.shouldRotateAroundWhenRendering())
				{
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				GL11.glTranslatef(0.0F, 0.2F, 0.0F);
				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else
			{
				f1 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f1, f1, f1);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			float f2;
			int i;
			float f5;

			if (itemstack.getItem().requiresMultipleRenderPasses())
			{
				for (i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++i)
				{
					int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
					f5 = (j >> 16 & 255) / 255.0F;
					f2 = (j >> 8 & 255) / 255.0F;
					float f3 = (j & 255) / 255.0F;
					GL11.glColor4f(f5, f2, f3, 1.0F);
					this.renderManager.itemRenderer.renderItem(entity, itemstack, i);
				}
			}
			else
			{
				i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
				float f4 = (i >> 16 & 255) / 255.0F;
				f5 = (i >> 8 & 255) / 255.0F;
				f2 = (i & 255) / 255.0F;
				GL11.glColor4f(f4, f5, f2, 1.0F);
				this.renderManager.itemRenderer.renderItem(entity, itemstack, 0);
			}

			GL11.glPopMatrix();
		}
	}

	private float interpolateRotation(float lowerLimit, float upperLimit, float range)
	{
		float f3;

		for (f3 = upperLimit - lowerLimit; f3 < -180.0F; f3 += 360.0F)
		{
			;
		}

		while (f3 >= 180.0F)
		{
			f3 -= 360.0F;
		}

		return lowerLimit + range * f3;
	}

	protected void rotateCorpse(EntityLivingBase entityLiving, float ageInTicks, float headYawOffset, float v)
	{
		GL11.glRotatef(180.0F + headYawOffset, 0.0F, 1.0F, 0.0F);

		if (entityLiving.deathTime > 0)
		{
			float f3 = (entityLiving.deathTime + v - 1.0F) / 20.0F * 1.6F;
			f3 = MathHelper.sqrt_float(f3);

			if (f3 > 1.0F)
			{
				f3 = 1.0F;
			}

			// GL11.glRotatef(f3 * this.getDeathMaxRotation(p_77043_1_), 0.0F,
			// 0.0F, 1.0F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return texture;
	}

}
