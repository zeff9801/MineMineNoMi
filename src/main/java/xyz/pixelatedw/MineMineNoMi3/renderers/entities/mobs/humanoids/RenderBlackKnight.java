package xyz.pixelatedw.MineMineNoMi3.renderers.entities.mobs.humanoids;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.IDynamicRenderer;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityBlackKnight;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityDoppelman;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMarine;
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
        rs = ((AbstractClientPlayer)minecraft.thePlayer).getLocationSkin();
        
		return rs;
	}
}
