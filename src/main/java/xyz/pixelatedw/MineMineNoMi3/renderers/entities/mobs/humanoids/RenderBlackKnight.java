package xyz.pixelatedw.MineMineNoMi3.renderers.entities.mobs.humanoids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.MobRenderer;

@SideOnly(Side.CLIENT)
public class RenderBlackKnight extends MobRenderer
{

	public RenderBlackKnight()
	{
		super(new ModelBiped());
	}
		
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		ResourceLocation rs = AbstractClientPlayer.locationStevePng;
		
        Minecraft minecraft = Minecraft.getMinecraft();
        rs = minecraft.thePlayer.getLocationSkin();
        
		return rs;
	}
}
