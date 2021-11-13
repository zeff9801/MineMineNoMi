package xyz.pixelatedw.MineMineNoMi3.renderers.items;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.models.items.ModelWeaponMace;

public class RenderWeaponMace implements IItemRenderer
{

	private ModelWeaponMace model;
	
	public RenderWeaponMace()
	{
		this.model = new ModelWeaponMace();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
			case EQUIPPED:
				return true;
			case EQUIPPED_FIRST_PERSON:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data)
	{
		switch (type)
		{

			case EQUIPPED:
			{
				GL11.glPushMatrix();
				//TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
				
				//this.model.render(null, 0, 0, 0, 0, 0, 0.625F);
				
				/*IIcon iicon = Minecraft.getMinecraft().thePlayer.getItemIcon(itemStack, 0);

				if (iicon == null)
				{
					GL11.glPopMatrix();
					return;
				}

				texturemanager.bindTexture(texturemanager.getResourceLocation(itemStack.getItemSpriteNumber()));
				TextureUtil.func_152777_a(false, false, 1.0F);
				Tessellator tessellator = Tessellator.instance;
				float f = iicon.getMinU();
				float f1 = iicon.getMaxU();
				float f2 = iicon.getMinV();
				float f3 = iicon.getMaxV();
				float f4 = 0.0F;
				float f5 = 0.3F;
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
				GL11.glTranslatef(-f4, -f5, 0.0F);
				float f6 = 1.8F;
				GL11.glScalef(f6, f6, f6);
				GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(345.0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.47F, 0.15F, 0.0F);

				GL11.glDisable(GL12.GL_RESCALE_NORMAL);
				texturemanager.bindTexture(texturemanager.getResourceLocation(itemStack.getItemSpriteNumber()));
				TextureUtil.func_147945_b();*/
				GL11.glPopMatrix();
			}
			case EQUIPPED_FIRST_PERSON:
			{

				GL11.glPushMatrix();

				TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();

				texturemanager.bindTexture(new ResourceLocation(ID.PROJECT_ID, "textures/models/items/mace.png"));

				float f4 = 0.0F;
				float f5 = 0.3F;
				
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
				GL11.glTranslatef(-f4, -f5, 0.0F);
				float f6 = 0.11F;
				GL11.glScalef(f6, f6, f6);
				GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(270.0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(4F, 2.0F, 1.5F);
				
				this.model.render(null, 0, 0, 0, 0, 0, 0.625F);
				
				boolean isFirstPerson = false;
				if (data[1] != null && data[1] instanceof EntityPlayer)
				{
					if (!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)))
					{
						GL11.glTranslatef(-0.01F, 0.01F, 0F);
					}
					else
					{
						GL11.glTranslatef(0.15F, 0.11F, -0.05F);
						GL11.glScalef(0.6F, 0.6F, 0.6F);
						isFirstPerson = true;
					}
				}

				GL11.glPopMatrix();
			}
			default:
				break;
		}
	}
}