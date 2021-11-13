package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class GoeAbilities 
{
	static
	{
		Values.abilityWebAppExtraParams.put("todoroki", new String[] {"desc", "The user shouts and creates a powerful sound blast."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Todoroki()};	
	
	public static class Todoroki extends Ability
	{
		public Todoroki() 
		{
			super(ListAttributes.TODOROKI); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new GoeProjectiles.Todoroki(player.worldObj, player, attr);
			super.use(player);
		} 
	}
}
