package xyz.pixelatedw.MineMineNoMi3.entities.zoan;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

public class EntityRendererZoanEyes extends EntityRenderer
{
	private final Minecraft mc;
	private double offsetY;

	public EntityRendererZoanEyes(Minecraft mc, double height)
	{
		super(mc, mc.getResourceManager());
		this.mc = mc;
		this.offsetY = height;
	}

	@Override
	public void updateCameraAndRender(float partialTick)
	{
		if (mc.thePlayer == null || mc.thePlayer.isPlayerSleeping())
		{
			super.updateCameraAndRender(partialTick);
			return;
		}

		mc.thePlayer.yOffset -= offsetY;
		super.updateCameraAndRender(partialTick);
		mc.thePlayer.yOffset = 1.62F;
	}

	@Override
	public void getMouseOver(float partialTick)
	{
		if (mc.thePlayer == null || mc.thePlayer.isPlayerSleeping())
		{
			super.getMouseOver(partialTick);
			return;
		}

		mc.thePlayer.posY += offsetY;
		mc.thePlayer.prevPosY += offsetY;
		mc.thePlayer.lastTickPosY += offsetY;
		super.getMouseOver(partialTick);
		mc.thePlayer.posY -= offsetY;
		mc.thePlayer.prevPosY -= offsetY;
		mc.thePlayer.lastTickPosY -= offsetY;
	}
}