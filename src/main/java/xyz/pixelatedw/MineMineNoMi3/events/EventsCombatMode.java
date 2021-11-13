package xyz.pixelatedw.MineMineNoMi3.events;

import java.awt.Color;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

@SideOnly(Side.CLIENT)
public class EventsCombatMode extends Gui
{
	private Minecraft mc;
	protected static final RenderItem itemRenderer = new RenderItem();
	private int trackDistance = 15;
	private EntityLivingBase trackMob = null;

	public EventsCombatMode(Minecraft mc)
	{
		this.mc = mc;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderUI(RenderGameOverlayEvent event)
	{
		EntityPlayer player = mc.thePlayer;
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);
		
		int posX = event.resolution.getScaledWidth();
		int posY = event.resolution.getScaledHeight();

		GuiIngameForge.left_height += 1;

		/*GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        
		WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#FF69B4").getRGB(), 7, 0, 0, 512, 512, 0);
		
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);*/
		
		if (event.type == ElementType.FOOD && props.getUsedFruit().equalsIgnoreCase("yomiyomi") && props.getZoanPoint().equalsIgnoreCase("yomi"))
			event.setCanceled(true);
		
		if (event.type == ElementType.HEALTH)
		{
			event.setCanceled(true);
			double maxHealth = player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
			double health = player.getHealth();

			this.drawCenteredString(this.mc.fontRenderer, (int) health + "", posX / 2 - 20, posY - 39, Color.RED.getRGB());

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			this.mc.getTextureManager().bindTexture(icons);
			double f2 = player.getAbsorptionAmount();

			for (int i = MathHelper.ceiling_double_int((maxHealth) / 2.0F) - 1; i >= 0; i--)
			{
				int k = (posX / 2 - 91) + i % 10 * 6;

				this.drawTexturedModalRect(k, posY - 39, 16, 0, 9, 9);
			}

			for (int i = 0; i < (100 - (((maxHealth - health) / maxHealth)) * 100) / 10; i++)
			{
				int k = (posX / 2 - 91) + i % 10 * 6;

				this.drawTexturedModalRect(k, posY - 39, 16 + 36, 9 * 0, 9, 9);
			}
		}

		if (props.isInCombatMode() && event.type == ElementType.HOTBAR)
		{
			event.setCanceled(true);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);

			for (int i = 0; i < 8; i++)
			{
				//if(abilityProps.getAbilityFromSlot(0) != null)
				//	System.out.println("" + abilityProps.getAbilityFromSlot(0).isOnCooldown());
				GL11.glEnable(GL11.GL_BLEND);
				if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isOnCooldown() && !abilityProps.getAbilityFromSlot(i).isDisabled())
					this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 23, 24, 0, 23, 23);
				else if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isCharging())
					this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 23, 72, 0, 23, 23);
				else if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isPassiveActive())
					this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 23, 48, 0, 23, 23);
				else if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isDisabled())
					this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 23, 96, 0, 23, 23);
				else
					this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 23, 0, 0, 23, 23);
			}

			if (props.isCyborg())
			{
				this.drawTexturedModalRect((posX - 260) / 2, posY - 42, 0, 52, 23, 40);
				int barHeight = (int) (((float) props.getCola() / props.getMaxCola()) * 30) + 23;

				if (barHeight > 0 && barHeight < 24)
					barHeight = 24;
				else if (barHeight > 52)
					barHeight = 52;

				this.drawTexturedModalRect((posX - 252) / 2, posY - 42, 32, barHeight, 16, 32);
				this.drawCenteredString(this.mc.fontRenderer, props.getCola() + "", (posX - 237) / 2, posY - 12, Color.WHITE.getRGB());
			}

			for (int i = 0; i < 8; i++)
			{
				OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				if (abilityProps.getAbilityFromSlot(i) != null)
				{
					AbilityAttribute attr = abilityProps.getAbilityFromSlot(i).getAttribute();
				    WyRenderHelper.drawAbilityIcon(WyHelper.getFancyName(attr.getAbilityTexture()), (posX - 192 + (i * 50)) / 2, posY - 19, 16, 16);
				}
			}

			int trackDistance = 15;
			if (props.hasKenHakiActive())
			{
				List<EntityLivingBase> nearbyEnemies = WyHelper.getEntitiesNear(player, 15);
				for (EntityLivingBase elb : nearbyEnemies)
				{
					if (trackMob == null)
					{
						trackMob = elb;
					} else
					{
						if (player.getDistanceToEntity(elb) <= player.getDistanceToEntity(trackMob))
							trackMob = elb;
						else if (trackMob.getHealth() <= 0 || !trackMob.isEntityAlive())
							trackMob = null;
						if (trackMob != null && player.getDistanceToEntity(trackMob) < trackDistance)
						{
							trackDistance = (int) player.getDistanceToEntity(trackMob);
							float angle = (float) Math.toDegrees(Math.atan2(trackMob.posZ - player.posZ, trackMob.posX - player.posX));
							String text = "";

							text += trackDistance + " blocks";

							Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_HARROW);
							GL11.glPushMatrix();

							// GL11.glTranslated(270, 60, 0);

							int posX2 = (posX - 256) / 2;
							int posY2 = (posY - 256);

							GL11.glTranslated(posX2 + 190, posY2 + 60, 0);

							GL11.glTranslated(128, 128, 128);
							GL11.glScaled(0.2, 0.2, 0);

							Direction playerDir = WyHelper.get8Directions(player);

							if (playerDir == Direction.SOUTH)
								GL11.glRotated(angle - 90, 0.0, 0.0, 1.0);
							else if (playerDir == Direction.SOUTH_EAST)
								GL11.glRotated(angle - 45, 0.0, 0.0, 1.0);
							if (playerDir == Direction.EAST)
								GL11.glRotated(angle, 0.0, 0.0, 1.0);
							else if (playerDir == Direction.NORTH_EAST)
								GL11.glRotated(angle + 45, 0.0, 0.0, 1.0);
							else if (playerDir == Direction.NORTH)
								GL11.glRotated(angle + 90, 0.0, 0.0, 1.0);
							else if (playerDir == Direction.NORTH_WEST)
								GL11.glRotated(angle + 135, 0.0, 0.0, 1.0);
							else if (playerDir == Direction.WEST)
								GL11.glRotated(angle + 180, 0.0, 0.0, 1.0);
							else if (playerDir == Direction.SOUTH_WEST)
								GL11.glRotated(angle + 225, 0.0, 0.0, 1.0);

							GL11.glTranslated(-128, -128, -128);
							this.drawTexturedModalRect(0, 0, 0, 0, 256, 256);

							GL11.glPopMatrix();

							WyRenderHelper.drawEntityOnScreen((posX + 320) / 2, posY - 42, 40, 40, 0, trackMob);
							this.drawCenteredString(this.mc.fontRenderer, text, (posX + 320) / 2, posY - 32, Color.WHITE.getRGB());
						}
					}
				}
			}

			GL11.glDisable(GL11.GL_BLEND);
		}
	}

	@SubscribeEvent
	public void updateFOV(FOVUpdateEvent event)
	{
		if (!MainConfig.enableFOVModifier)
		{
			if (event.entity.isPotionActive(Potion.moveSlowdown))
				event.newfov = 1.0F;

			if (event.entity.isPotionActive(Potion.moveSpeed))
				event.newfov = 1.0F;

			if ((event.entity.isPotionActive(Potion.moveSpeed)) && (event.entity.isSprinting()))
				event.newfov = 1.1F;
		}
	}

}
