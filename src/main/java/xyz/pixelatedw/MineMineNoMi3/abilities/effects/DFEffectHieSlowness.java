package xyz.pixelatedw.MineMineNoMi3.abilities.effects;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;

public class DFEffectHieSlowness extends DFEffect
{

	public DFEffectHieSlowness(EntityLivingBase entity, int timer)
	{
		super(entity, timer, ID.EXTRAEFFECT_HIE);
	}

	public void onEffectStart(EntityLivingBase entity)
	{

	}

	public void onEffectEnd(EntityLivingBase entity)
	{
		
	}
		
}
