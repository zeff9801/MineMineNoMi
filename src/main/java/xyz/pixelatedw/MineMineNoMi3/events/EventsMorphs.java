package xyz.pixelatedw.MineMineNoMi3.events;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderPlayerEvent.SetArmorModel;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.HandRendererHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.MorphsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelAbareHimatsuri;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;
import xyz.pixelatedw.MineMineNoMi3.renderers.effects.RenderAbareHimatsuri;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans.RenderZoanMorph;

@SideOnly(Side.CLIENT)
public class EventsMorphs
{

	private Minecraft mc;

	private RenderAbareHimatsuri abareHimatsuri = new RenderAbareHimatsuri(new ModelAbareHimatsuri());

	private EntityRenderer renderer, prevRenderer;
	private String prevZoanPoint;

	public EventsMorphs(Minecraft mc)
	{
		this.mc = mc;
	}

	
	@SubscribeEvent
	public void onArmorRendering(SetArmorModel event)
	{
		EntityPlayer player = event.entityPlayer;
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);
		
		Ability fullBodyHakiAbility = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING.getAttributeName());

		if (fullBodyHakiAbility != null && fullBodyHakiAbility.isPassiveActive())
		{
			GL11.glPushMatrix();
			{
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_DST_COLOR);
							
	            float f2 = this.interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, event.partialRenderTick);
	            float f3 = this.interpolateRotation(player.prevRotationYawHead, player.rotationYawHead, event.partialRenderTick);
	            float f4 = this.handleRotationFloat(player, event.partialRenderTick);
	            
	            float f6 = player.prevLimbSwingAmount + (player.limbSwingAmount - player.prevLimbSwingAmount) * event.partialRenderTick;
	            float f7 = player.limbSwing - player.limbSwingAmount * (1.0F - event.partialRenderTick);
				
	            float f13 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * event.partialRenderTick;
	            
				ModelBiped fullBodyHakiModel = new ModelBiped(0.05F);
				GL11.glScaled(0.1, 0.1, 0.1);
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.HANDTEXTURE_ZOANMORPH_BUSO);
				fullBodyHakiModel.bipedHead.isHidden = false;
				fullBodyHakiModel.bipedHeadwear.isHidden = false;
				fullBodyHakiModel.isSneak = player.isSneaking();
				fullBodyHakiModel.isChild = false;
				event.renderer.setRenderPassModel(fullBodyHakiModel);
				fullBodyHakiModel.render(player, f7, f6, f4, f3 - f2, f13, 0.625F);
				
			}
			GL11.glPopMatrix();
		}
	}
	
    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_)
    {
        return p_77044_1_.ticksExisted + p_77044_2_;
    }
	
    private float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_)
    {
        float f3;

        for (f3 = p_77034_2_ - p_77034_1_; f3 < -180.0F; f3 += 360.0F)
        {
            ;
        }

        while (f3 >= 180.0F)
        {
            f3 -= 360.0F;
        }

        return p_77034_1_ + p_77034_3_ * f3;
    }
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event)
	{
		EntityPlayer player = this.mc.thePlayer;

		if (player == null)
			return;

		ExtendedEntityData props = ExtendedEntityData.get(this.mc.thePlayer);
		
		if (prevRenderer != null && props.getZoanPoint().equalsIgnoreCase("n/a"))
		{
			mc.entityRenderer = prevRenderer;
		}
		else
		{
			if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
			{
				Object[][] forms = MorphsHelper.getMorphsMap().get(props.getUsedFruit());

				for (Object[] form : forms)
				{
					if (props.getZoanPoint().equalsIgnoreCase((String) form[0]) && (EntityRenderer) form[2] != null)
					{
						if (renderer == null || !props.getZoanPoint().equalsIgnoreCase(this.prevZoanPoint))
							renderer = (EntityRenderer) form[2];

						if (mc.entityRenderer != renderer)
						{
							prevRenderer = mc.entityRenderer;
							mc.entityRenderer = renderer;
							this.prevZoanPoint = props.getZoanPoint();
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onRenderPlayerEvent(RenderPlayerEvent.Pre event)
	{
		ExtendedEntityData propz = ExtendedEntityData.get(event.entityPlayer);
		if (propz.isInAirWorld())
		{
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onEntityRendered(RenderLivingEvent.Pre event)
	{
		ExtendedEntityData props = ExtendedEntityData.get(event.entity);

		if (!props.getZoanPoint().toLowerCase().equals("n/a"))
		{
			if (event.entity.hurtTime > 0)
			{
				GL11.glPushMatrix();
				GL11.glColor3f(1.0f, 0, 0);
				GL11.glPopMatrix();
			}

			event.setCanceled(true);

			if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
			{
				Arrays.stream(MorphsHelper.getMorphsMap().get(props.getUsedFruit())).forEach(x ->
				{
					if (props.getZoanPoint().equalsIgnoreCase((String) x[0]))
					{
						this.doRenderZoanMorph((RenderZoanMorph) x[1], event.x, event.y, event.z, event.entity);
					}
				});
			}
		}

		if (props.getUsedFruit().equalsIgnoreCase("sukesuke") && event.entity.isInvisible())
			event.setCanceled(true);

		if (event.entity instanceof EntityPlayer)
		{
			if (props.hasExtraEffects(ID.EXTRAEFFECT_ABAREHIMATSURI))
			{
				if (event.entity.onGround)
				{
					Block block = event.entity.worldObj.getBlock((int) event.entity.posX, (int) event.entity.posY - 2, (int) event.entity.posZ);
					String texture = Blocks.dirt.getIcon(1, 0).getIconName();
					int blockTint = event.entity.worldObj.getBlock((int) event.entity.posX, (int) event.entity.posY - 2, (int) event.entity.posZ).colorMultiplier(event.entity.worldObj, (int) event.entity.posX, (int) event.entity.posY - 2, (int) event.entity.posZ);

					if (block.getIcon(1, 0) != null)
						texture = block.getIcon(1, 0).getIconName();

					abareHimatsuri.setTextureAndTint(texture, blockTint);
				}

				System.out.println(event.entity.onGround);

				if (!event.entity.onGround)
					abareHimatsuri.doRender(event.entity, event.x, event.y, event.z, 0F, 0.0625F);
			}
		}

		/*
		 * if(event.entity instanceof EntityDojoSensei) {
		 * GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
		 * GL11.glEnable(GL11.GL_LIGHTING); GL11.glClearStencil(0);
		 * GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);
		 * GL11.glEnable(GL11.GL_STENCIL_TEST);
		 * GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 0xFFFF);
		 * GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
		 * GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		 * GL11.glColor3f(1.0f, 1.0f, 1.0f);
		 * // Render original. //new RenderZoanMorph(new ModelBiped(), "null",
		 * 2).doRender(event.entity, event.x, event.y, event.z, 0, 0);
		 * GL11.glDisable(GL11.GL_LIGHTING);
		 * GL11.glStencilFunc(GL11.GL_NOTEQUAL, 1, 0xFFFF);
		 * GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
		 * GL11.glLineWidth(6.5f); GL11.glPolygonMode(GL11.GL_FRONT,
		 * GL11.GL_LINE); GL11.glColor4f(1.0F, 1.0F, 0.0F, 1.0F);
		 * GL11.glDisable(GL11.GL_TEXTURE_2D);
		 * // Render stencil. //new RenderZoanMorph(new ModelBiped(), "null",
		 * 1.35).doRender(event.entity, event.x, event.y + 1.3, event.z, 0, 0);
		 * zoanBisonPower.doRender(event.entity, event.x, event.y, event.z, 0F,
		 * 0F);
		 * GL11.glEnable(GL11.GL_TEXTURE_2D); GL11.glColor4f(1F, 1F, 1F, 1F);
		 * GL11.glPopAttrib();
		 * //event.setCanceled(true); }
		 */

	}

	private void doRenderZoanMorph(RenderZoanMorph render, double x, double y, double z, EntityLivingBase entity)
	{
		if (Minecraft.getMinecraft().thePlayer.equals(entity))
			render.doRender(entity, 0D, -1.625D, 0D, 0F, 0.0625F);
		else
			render.doRender(entity, x, y, z, 0F, 0.0625F);
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer owner = (EntityPlayer) event.entity;
			ExtendedEntityData props = ExtendedEntityData.get(owner);

			if (!props.getZoanPoint().toLowerCase().equals("n/a") && !props.getZoanPoint().toLowerCase().equals("yomi"))
			{
				props.setZoanPoint("n/a");

				WyNetworkHelper.sendToServer(new PacketSync(props));
				WyNetworkHelper.sendToAll(new PacketSyncInfo(owner.getDisplayName(), props));
			}
		}
	}

	@SubscribeEvent
	public void morphHandRendering(RenderHandEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);

		boolean renderHandFlag = false;
		boolean renderHandEffectFlag = false;

		Ability hotBoilingSpecial = abilityProps.getAbilityFromName(ListAttributes.HOT_BOILING_SPECIAL.getAttributeName());
		Ability hardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_HARDENING.getAttributeName());
		Ability fullBodyHardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING.getAttributeName());

		boolean hasHotBoilingSpecial = (hotBoilingSpecial != null && hotBoilingSpecial.isPassiveActive());
		boolean hasHardeningBuso = (hardeningBuso != null && hardeningBuso.isPassiveActive());
		boolean hasFullBodyHardeningBuso = (fullBodyHardeningBuso != null && fullBodyHardeningBuso.isPassiveActive());
		if (player.getHeldItem() == null && (hasFullBodyHardeningBuso || hasHardeningBuso || hasHotBoilingSpecial))
		{
			renderHandFlag = true;
		}

		if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
		{
			for (Object[] x : MorphsHelper.getMorphsMap().get(props.getUsedFruit()))
			{
				if (props.getZoanPoint().equalsIgnoreCase((String) x[0]))
				{
					renderHandFlag = true;
					break;
				}
			}
		}

		GL11.glPushMatrix();
		{
			int x = 0, y = 0, u = 16, v = 16;

			/*
			 * GL11.glMatrixMode(GL11.GL_PROJECTION); GL11.glLoadIdentity();
			 * Project.gluPerspective(mc.gameSettings.fovSetting, (float)
			 * mc.displayWidth / (float) mc.displayHeight, 0.20F, (float)
			 * (mc.gameSettings.renderDistanceChunks * 16) * 2.0F);
			 * GL11.glMatrixMode(GL11.GL_MODELVIEW); GL11.glLoadIdentity();
			 * RenderHelper.enableStandardItemLighting();
			 * Minecraft.getMinecraft().entityRenderer.enableLightmap(0);
			 * int i2 = mc.theWorld.getLightBrightnessForSkyBlocks(MathHelper.
			 * floor_double(player.posX), MathHelper.floor_double(player.posY),
			 * MathHelper.floor_double(player.posZ), 0); int j = i2 % 65536; int
			 * k = i2 / 65536;
			 * OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.
			 * lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
			 * GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 */

			/*
			 * if (mc.gameSettings.thirdPersonView == 0 &&
			 * !mc.renderViewEntity.isPlayerSleeping() &&
			 * !mc.gameSettings.hideGUI) { GL11.glRotated(180, 0, 0, 1);
			 * GL11.glScaled(0.05, 0.05, 0.05); GL11.glTranslated(0, 0, 4);
			 * Minecraft.getMinecraft().getTextureManager().bindTexture(new
			 * ResourceLocation(ID.PROJECT_ID, "textures/abilities/" +
			 * WyHelper.getFancyName("baribarinopistol") + ".png")); Tessellator
			 * tessellator = Tessellator.instance;
			 * tessellator.startDrawingQuads(); tessellator.addVertexWithUV(x ,
			 * y + v , 0, 0.0, 1.0); tessellator.addVertexWithUV(x + u , y + v ,
			 * 0, 1.0, 1.0); tessellator.addVertexWithUV(x + u , y , 0, 1.0,
			 * 0.0); tessellator.addVertexWithUV(x , y , 0, 0.0, 0.0);
			 * tessellator.draw();
			 * tessellator.startDrawingQuads(); tessellator.addVertexWithUV(x +
			 * u , y , 0, 1.0, 0.0); tessellator.addVertexWithUV(x + u , y + v ,
			 * 0, 1.0, 1.0); tessellator.addVertexWithUV(x , y + v , 0, 0.0,
			 * 1.0); tessellator.addVertexWithUV(x , y , 0, 0.0, 0.0);
			 * tessellator.draw(); }
			 */
		}
		GL11.glPopMatrix();

		if (renderHandFlag)
		{
			event.setCanceled(true);
			HandRendererHelper.renderHand((EntityClientPlayerMP) player);
		}

		/*
		 * for(Object[] x :
		 * HandEffectsHelper.getMap().get(props.getUsedFruit())) {
		 * }
		 */
	}

}
