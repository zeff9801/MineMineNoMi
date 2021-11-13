package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SukeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class SukeAbilities
{

	static
	{
		Values.abilityWebAppExtraParams.put("shishanote", new String[] {"desc", "Shoots invisible projectiles that explode upon impact."});
		Values.abilityWebAppExtraParams.put("skatting", new String[] {"desc", "Turns the user's entire body invisible."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new ShishaNoTe(), new Skatting(), new SukePunch()};
	
	public static class SukePunch extends Ability
	{
		public SukePunch()
		{
			super(ListAttributes.SUKE_PUNCH);
		}

		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			if (target.isPotionActive(Potion.invisibility))
				target.removePotionEffect(Potion.invisibility.id);
			else
				target.addPotionEffect(new PotionEffect(Potion.invisibility.id, 400, 5, true));

			super.hitEntity(player, target);
		}
	}
	
	public static class ShishaNoTe extends Ability
	{
		public ShishaNoTe() 
		{
			super(ListAttributes.SHISHA_NO_TE); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new SukeProjectiles.ShishaNoTe(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Skatting extends Ability
	{
		public Skatting() 
		{
			super(ListAttributes.SKATTING); 
		}	
	}

}
