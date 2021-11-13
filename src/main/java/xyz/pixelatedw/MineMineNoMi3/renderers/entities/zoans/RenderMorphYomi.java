package xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelYomi;

public class RenderMorphYomi extends RenderZoanMorph
{

	private ModelYomi model;
	
	public RenderMorphYomi(ModelYomi model, String texture, double scale, float[] offset)
	{
		super(model, texture, scale, offset);
		this.model = model;
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v)
	{
		super.doRender(entity, x, y, z, u, v);
		
		this.model.afro.isHidden = true;
		if(entity instanceof EntityPlayer)
		{
			int age = ((EntityPlayer) entity).getAge();
			if(age > 2000)
			{
				this.model.afro.isHidden = false;
			}
		}
	}
}
