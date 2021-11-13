package xyz.pixelatedw.MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;

public class GUIPlayer extends GuiScreen
{
	private EntityPlayer player;
	private RenderItem renderItem;
	private ExtendedEntityData props;
	private EntityNewMob testEntity;
	
	public GUIPlayer(EntityPlayer player)
	{
		this.player = player;
		this.props = ExtendedEntityData.get(player);
				 
		//testEntity = new EntityMorgan(Minecraft.getMinecraft().theWorld);
		//testEntity.onSpawnWithEgg(null);
	}

	@Override
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		//this.drawGradientRect(0, 0, this.width, this.height, WyHelper.hexToRGB("#FD637F").getRGB(), WyHelper.hexToRGB("#FD637F").getRGB());
		
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;		
		
		String factionGUI = I18n.format(ID.LANG_GUI_FACTION);
		String raceGUI = I18n.format(ID.LANG_GUI_RACE);
		String styleGUI = I18n.format(ID.LANG_GUI_STYLE);
		
		String factionActual = I18n.format("faction." + WyHelper.getFancyName(props.getFaction().toLowerCase()) + ".name");
		String raceActual = I18n.format("race." + props.getRace().toLowerCase() + ".name");
		String styleActual = I18n.format("style." + props.getFightStyle().toLowerCase() + ".name");
		
		//TODO DORIKI and COLA I18n strings
		if(props.isCyborg())
			mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "COLA: " + EnumChatFormatting.RESET + props.getCola() + " / " + props.getMaxCola(), posX - 30, posY + 50, -1) ;
		mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "DORIKI: " + EnumChatFormatting.RESET + props.getDoriki(), posX - 30, posY + 70, -1);
		mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + factionGUI + ": " + EnumChatFormatting.RESET + factionActual, posX - 30, posY + 90, -1);
		mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + raceGUI + ": " + EnumChatFormatting.RESET + raceActual, posX - 30, posY + 110, -1);
		mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + styleGUI + ": " + EnumChatFormatting.RESET + styleActual, posX - 30, posY + 130, -1);

		if(props.getBelly() > 0)
		{
			mc.fontRenderer.drawStringWithShadow("" + props.getBelly(), posX + 215, posY + 72, -1);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
			this.drawTexturedModalRect(posX + 190, posY + 60, 0, 32, 32, 64);
		}
		
		if(props.getExtol() > 0)
		{
			mc.fontRenderer.drawStringWithShadow("" + props.getExtol(), posX + 215, posY + 102, -1);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
			this.drawTexturedModalRect(posX + 190, posY + 90, 34, 32, 64, 86);
		}

		if(!props.getUsedFruit().equalsIgnoreCase("n/a") && !props.getUsedFruit().equals("null"))
		{			
			ItemStack yamiFruit = new ItemStack(GameRegistry.findItem(ID.PROJECT_ID, "yamiyaminomi"));
			ItemStack df;
			if(!props.getUsedFruit().equals("yamidummy"))
			{
				df = DevilFruitsHelper.getDevilFruitItem(props.getUsedFruit());
								
				if(props.hasYamiPower())
					mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + yamiFruit.getDisplayName() + " + " + df.getDisplayName(), posX - 28, posY + 194, -1);
				else
					mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + df.getDisplayName(), posX - 28, posY + 194, -1);
				
				if(props.hasYamiPower())
					this.drawItemStack(yamiFruit, posX - 56, posY + 187, "");
				this.drawItemStack(df, posX - 50, posY + 190, "");
			}
			else
			{
				mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + yamiFruit.getDisplayName(), posX - 28, posY + 194, -1);
				this.drawItemStack(yamiFruit, posX - 50, posY + 190, "");
			}
			
		}

		RenderHelper.disableStandardItemLighting();
		//WyRenderHelper.drawEntityOnScreen(posX + 140, posY + 180 , 68, 0, 0, this.player);
		//WyRenderHelper.drawEntityOnScreen(posX + 140, posY + 180 , 68, -50, 0, this.testEntity);
    
		/*
		if(props.isPirate() && props.getBounty() > 0)
		{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_BOUNTYPOSTER);
			this.drawTexturedModalRect(posX + 200, posY + 130, 0, 0, 180, 200);
			mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "" + props.getBounty(), posX + 220, posY + 208, -1);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
			this.drawTexturedModalRect(posX + 200, posY + 195, 0, 32, 32, 64);
		}
		*/		

		super.drawScreen(x, y, f);
	}

	@Override
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		this.buttonList.add(new GuiButton(1, posX - 20, posY + 210, 50, 20, I18n.format(ID.LANG_GUI_ABILITIES)));
		if(MainConfig.enableQuests)
			this.buttonList.add(new GuiButton(2, posX + 40, posY + 210, 50, 20, I18n.format(ID.LANG_GUI_QUESTS)));
		//this.buttonList.add(new GuiButton(3, posX + 100, posY + 210, 50, 20, I18n.format(ID.LANG_GUI_HISTORY)));
		
		//this.buttonList.add(new GuiButton(2, posX + 63, posY + 210, 80, 20, I18n.format("gui.epithet.name")));
	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			case 1: player.openGui(MainMod.getMineMineNoMi(), 4, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ); break;
			case 2: player.openGui(MainMod.getMineMineNoMi(), 5, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ); break;
			case 3: player.openGui(MainMod.getMineMineNoMi(), 6, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ); break;
		}
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

    private void drawItemStack(ItemStack itemStack, int x, int y, String string)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (itemStack != null) font = itemStack.getItem().getFontRenderer(itemStack);
        if (font == null) font = fontRendererObj;
        itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y);
        itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y - 0, string);
        this.zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
    }
}
