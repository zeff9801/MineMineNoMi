package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BomuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class BomuAbilities 
{

	static
	{
		Values.abilityWebAppExtraParams.put("kickbomb", new String[] {"desc", "The user kicks their opponent, detonating their leg on impact."});
		Values.abilityWebAppExtraParams.put("nosefancycannon", new String[] {"desc", "Shoots dried mucus at the opponent, which explodes on impact."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new KickBomb(), new NoseFancyCannon()};

	public static class KickBomb extends Ability
	{
		public KickBomb() 
		{
			super(ListAttributes.KICK_BOMB); 
		}
		
		public void use(EntityPlayer player)
		{			
			super.use(player);
		} 
	}
	
	public static class NoseFancyCannon extends Ability
	{
		public NoseFancyCannon() 
		{
			super(ListAttributes.NOSE_FANCY_CANNON); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new BomuProjectiles.NoseFancyCannon(player.worldObj, player, attr);
			super.use(player);
		} 
	}
}
