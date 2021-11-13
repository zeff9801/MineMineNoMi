package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.RenderLivingEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelCandleLock;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelChains;
import xyz.pixelatedw.MineMineNoMi3.renderers.effects.RenderCandleLock;
import xyz.pixelatedw.MineMineNoMi3.renderers.effects.RenderChains;

public class EventsEffectOverlay
{

	private RenderCandleLock candleLock = new RenderCandleLock(new ModelCandleLock());
	private RenderChains oriBind = new RenderChains(new ModelChains());

	@SubscribeEvent
	public void onEntityRendered(RenderLivingEvent.Pre event)
	{
		ExtendedEntityData props = ExtendedEntityData.get(event.entity);
		
		if (props.hasExtraEffects(ID.EXTRAEFFECT_MERO))
		{
			GL11.glPushMatrix();

			Color c = WyHelper.hexToRGB("#5d6060");
			GL11.glColor3d((double) c.getRed() / 255, (double) c.getGreen() / 255, (double) c.getBlue() / 255);

			GL11.glPopMatrix();
		}
		else if(props.hasExtraEffects(ID.EXTRAEFFECT_LOGIA_OFF))
		{
			GL11.glPushMatrix();
			
			Color c = WyHelper.hexToRGB("#011F4B");
			GL11.glColor3d((double) c.getRed() / 255, (double) c.getGreen() / 255, (double) c.getBlue() / 255);

			GL11.glPopMatrix();
		}
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_HIE))
		{
			GL11.glPushMatrix();

			Color c = WyHelper.hexToRGB("#1be2e2");
			GL11.glColor3d((double) c.getRed() / 255, (double) c.getGreen() / 255, (double) c.getBlue() / 255);

			GL11.glPopMatrix();
		}
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_NORO))
		{
			GL11.glPushMatrix();

			Color c = WyHelper.hexToRGB("#ce83d3");
			GL11.glColor3d((double) c.getRed() / 255, (double) c.getGreen() / 255, (double) c.getBlue() / 255);

			GL11.glPopMatrix();
		}
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_DORULOCK))
		{
			candleLock.doRender(event.entity, event.x, event.y, event.z, 0F, 0.0625F);
		}
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_RUSTOVERLAY))
		{
			GL11.glPushMatrix();

			Color c = WyHelper.hexToRGB("#a04921");
			GL11.glColor3d((double) c.getRed() / 255, (double) c.getGreen() / 255, (double) c.getBlue() / 255);

			GL11.glPopMatrix();
		}
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_SPIDEROVERLAY))
		{
			GL11.glPushMatrix();

			Color c = WyHelper.hexToRGB("#606875");
			GL11.glColor3d((double) c.getRed() / 255, (double) c.getGreen() / 255, (double) c.getBlue() / 255);

			GL11.glPopMatrix();
		}
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_ORIBIND))
		{
			oriBind.doRender(event.entity, event.x, event.y, event.z, 0F, 0.0625F);
		}
	}
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;

		if (player == null)
			return;

		ExtendedEntityData props = ExtendedEntityData.get(player);
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

		if (props.hasExtraEffects(ID.EXTRAEFFECT_MERO))
			WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#5d6060").getRGB(), 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_HIE))
			WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#1be2e2").getRGB(), 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_NORO))
			WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#ce83d3").getRGB(), 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_RUSTOVERLAY))
			WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#a04921").getRGB(), 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_SPIDEROVERLAY))
			WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#3e4247").getRGB(), 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
		else if (props.hasExtraEffects(ID.EXTRAEFFECT_HAO))
		{
			if(player.isPotionActive(Potion.blindness.id))
				WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#000000").getRGB(), 240, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
			else
				WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#72399d").getRGB(), 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
		}
		if(props.isInAirWorld())
			WyRenderHelper.drawColourOnScreen(0, 50, 0, 100, 0, 0, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200);
	}
	
}
