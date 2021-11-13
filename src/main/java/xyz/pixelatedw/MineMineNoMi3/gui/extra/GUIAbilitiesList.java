package xyz.pixelatedw.MineMineNoMi3.gui.extra;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.GuiScrollingList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.gui.GUISelectHotbarAbilities;

public class GUIAbilitiesList extends GuiScrollingList
{

	private GUISelectHotbarAbilities parent;
	private AbilityProperties props;
	
	private List<Ability> availableAbilities = new ArrayList<Ability>();
	
	public GUIAbilitiesList(GUISelectHotbarAbilities parent, AbilityProperties abilityProps, Ability[] abilities) 
	{
		super(parent.mc, 220, 300, (parent.relativePosY - 200) / 2, (parent.relativePosY + 60) / 2, (parent.relativePosX - 220) / 2, 26);
        this.parent = parent;
        this.props = abilityProps;
        availableAbilities.clear();
        
		for(int i = 0; i < abilities.length - 1; i++)
		{	
			if(abilities[i] != null)
				this.availableAbilities.add( abilities[i] );
		}	 
	}
	
    protected int getContentHeight()
    {
        return (this.getSize()) * 27 + 1;
    }

	protected int getSize() 
	{
		return this.availableAbilities.size();
	}

	protected void elementClicked(int index, boolean doubleClick) 
	{	
		if(parent.slotSelected > -1)
		{
			boolean flag = true;
			
			for(int i = 0; i < props.countAbilitiesInHotbar(); i++)
			{								
				if( props.getAbilityFromSlot(i) != null && props.getAbilityFromSlot(i).getAttribute().getAttributeName().equalsIgnoreCase(availableAbilities.get(index).getAttribute().getAttributeName()) )
				{
					flag = false;
				}
			}
						
			if(flag)
			{
				props.setAbilityInSlot(parent.slotSelected, AbilityManager.instance().getAbilityByName( WyHelper.getFancyName(availableAbilities.get(index).getAttribute().getAttributeName()) ));
				WyNetworkHelper.sendToServer(new PacketAbilitySync(props));
			}
		}
	}

	@Override
	protected boolean isSelected(int index) 
	{
        return false;
	}

	protected void drawBackground() 
	{
		
	}

	protected void drawSlot(int slotIndex, int entryRight, int slotTop, int slotBuffer, Tessellator tess) 
	{
    	boolean flag = false;
		AbilityAttribute attr = availableAbilities.get(slotIndex).getAttribute();

		for(int i = 0; i < props.countAbilitiesInHotbar(); i++)
		{	
			if(props.getAbilityFromSlot(i) != null && props.getAbilityFromSlot(i).getAttribute().getAttributeName().equalsIgnoreCase(availableAbilities.get(slotIndex).getAttribute().getAttributeName()))
			{
				flag = true;
			}
		
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow( I18n.format("ability." + WyHelper.getFancyName(availableAbilities.get(slotIndex).getAttribute().getAttributeName()) + ".name"), this.left + 40, slotTop + 7, flag ? 0xFF0000 : 0xFFFFFF);
		}
				
		GL11.glPushMatrix();
		{
	    	WyRenderHelper.drawAbilityIcon(WyHelper.getFancyName(attr.getAbilityTexture()), this.left + 10, slotTop + 2, 16, 16);
		}
		GL11.glPopMatrix();
	}
	
}
