package xyz.pixelatedw.MineMineNoMi3.helpers;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans.RenderZoanMorph;

public class HandRendererHelper
{

	private static HashMap<String, Object[][]> handEffectsMap = new HashMap<String, Object[][]>();
	
	public static HashMap<String, Object[][]> getMap()
	{
		return handEffectsMap;
	}

	static
	{
		handEffectsMap.put("baribari", new Object[][] 
				{
						{ "power", "" },			
				});
	}
	
	public static void renderHand(EntityClientPlayerMP player)
	{
		Minecraft mc = Minecraft.getMinecraft();

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		
		Project.gluPerspective(mc.gameSettings.fovSetting, (float) mc.displayWidth / (float) mc.displayHeight, 0.20F, mc.gameSettings.renderDistanceChunks * 16 * 2.0F);
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		if (mc.gameSettings.viewBobbing)
			setupViewBobbing(0.07F);
		
		RenderHelper.enableStandardItemLighting();
		Minecraft.getMinecraft().entityRenderer.enableLightmap(0);
		
        int i2 = mc.theWorld.getLightBrightnessForSkyBlocks(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ), 0);
        int j = i2 % 65536;
        int k = i2 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		if (mc.gameSettings.thirdPersonView == 0 && !mc.renderViewEntity.isPlayerSleeping() && !mc.gameSettings.hideGUI)
		{
			if (player.inventory.getCurrentItem() != null)
				Minecraft.getMinecraft().entityRenderer.itemRenderer.renderItemInFirstPerson(0.07F);
			else			
				renderCustomHand(player);
		}
		
		Minecraft.getMinecraft().entityRenderer.disableLightmap(0);
		RenderHelper.disableStandardItemLighting();
	}
	
	private static void renderCustomHand(EntityClientPlayerMP player)
	{
		Minecraft mc = Minecraft.getMinecraft();
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);
		
		Ability hotBoilingSpecial = abilityProps.getAbilityFromName(ListAttributes.HOT_BOILING_SPECIAL.getAttributeName());
		boolean hasHotBoilingSpecial = (hotBoilingSpecial != null && hotBoilingSpecial.isPassiveActive());
		
		Ability hardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_HARDENING.getAttributeName());
		boolean hasHardeningBuso = (hardeningBuso != null && hardeningBuso.isPassiveActive());
		
		Ability fullBodyHardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING.getAttributeName());
		boolean hasFullBodyHardeningBuso = (fullBodyHardeningBuso != null && fullBodyHardeningBuso.isPassiveActive());
		
		float f5;
		float f6;
		float f7;

		GL11.glPushMatrix();
		float f13 = 0.8F;
		f5 = player.getSwingProgress(0);
		f6 = MathHelper.sin(f5 * (float) Math.PI);
		f7 = MathHelper.sin(MathHelper.sqrt_float(f5) * (float) Math.PI);
		GL11.glTranslatef(-f7 * 0.3F, MathHelper.sin(MathHelper.sqrt_float(f5) * (float) Math.PI * 2.0F) * 0.4F, -f6 * 0.4F);
		GL11.glTranslatef(0.8F * f13, -0.75F * f13 - (1.0F - 1) * 0.6F, -0.9F * f13);
		GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		f5 = player.getSwingProgress(0);
		f6 = MathHelper.sin(f5 * f5 * (float) Math.PI);
		f7 = MathHelper.sin(MathHelper.sqrt_float(f5) * (float) Math.PI);
		GL11.glRotatef(f7 * 70.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-f6 * 20.0F, 0.0F, 0.0F, 1.0F);
		if (hasHardeningBuso || hasFullBodyHardeningBuso)
			mc.getTextureManager().bindTexture(ID.HANDTEXTURE_ZOANMORPH_BUSO);
		else if(hasHotBoilingSpecial)
			mc.getTextureManager().bindTexture(ID.HANDTEXTURE_ZOANMORPH_HOTBOILINGSPECIAL);
		else
			mc.getTextureManager().bindTexture(getTextureFromMorph(player));
		GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
		GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glTranslatef(5.6F, 0.0F, 0.0F);
		Render render = null;

		if (props.getZoanPoint().toLowerCase().equals("n/a"))
		{
			render = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
			RenderPlayer renderplayer = (RenderPlayer) render;
			float i = 1.0F;
			GL11.glScalef(i, i, i);
			renderplayer.renderFirstPersonArm(mc.thePlayer);
		} 
		else
		{
			if(MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
			{
				for(Object[] x : MorphsHelper.getMorphsMap().get(props.getUsedFruit()))
				{
					if(props.getZoanPoint().equalsIgnoreCase((String) x[0]))
						render = (RenderZoanMorph) x[1];
				}
			}
			
			RenderZoanMorph renderZoan = (RenderZoanMorph) render;
			float i = 1.0F;
			GL11.glScalef(i, i, i);
			GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.2f, 0.0f, -0.5f);
			renderZoan.renderFirstPersonArm(mc.thePlayer);
		}

		GL11.glPopMatrix();

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	}
	
	private static ResourceLocation getTextureFromMorph(EntityClientPlayerMP player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		RenderZoanMorph render = null;
		
		if(MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
		{
			for(Object[] x : MorphsHelper.getMorphsMap().get(props.getUsedFruit()))
			{
				if(props.getZoanPoint().equalsIgnoreCase((String) x[0]))
				{
					render = (RenderZoanMorph)x[1];
					break;
				}
			}
		}

		if(render != null)
			return render.getEntityTexture(null);
		
		return player.getLocationSkin();
	}

	public static void setupViewBobbing(float swing)
	{
		Minecraft mc = Minecraft.getMinecraft();
		
		if (mc.renderViewEntity instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer) mc.renderViewEntity;
			float f1 = entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified;
			float f2 = -(entityplayer.distanceWalkedModified + f1 * swing);
			float f3 = entityplayer.prevCameraYaw + (entityplayer.cameraYaw - entityplayer.prevCameraYaw) * swing;
			float f4 = entityplayer.prevCameraPitch + (entityplayer.cameraPitch - entityplayer.prevCameraPitch) * swing;
			GL11.glTranslatef(MathHelper.sin(f2 * (float) Math.PI) * f3 * 0.5F, -Math.abs(MathHelper.cos(f2 * (float) Math.PI) * f3), 0.0F);
			GL11.glRotatef(MathHelper.sin(f2 * (float) Math.PI) * f3 * 3.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(Math.abs(MathHelper.cos(f2 * (float) Math.PI - 0.2F) * f3) * 5.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(f4, 1.0F, 0.0F, 0.0F);
		}
	}
}
	