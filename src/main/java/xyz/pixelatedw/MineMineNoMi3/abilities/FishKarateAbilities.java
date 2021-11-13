package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.FishKarateProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class FishKarateAbilities 
{
	static
	{
		Values.abilityWebAppExtraParams.put("uchimizu", new String[] {"desc", "The user hurls big and fast water droplets at the opponent.", "dorikiRequiredForFishman", "800"});
		Values.abilityWebAppExtraParams.put("murasame", new String[] {"desc", "The user fires densely compressed shark-shaped waterbullet at the opponent.", "dorikiRequiredForFishman", "2000"});
		Values.abilityWebAppExtraParams.put("samehadashotei", new String[] {"desc", "The user concentrates their power to their palms, protecting themselves from attacks.", "dorikiRequiredForFishman", "3000"});
		Values.abilityWebAppExtraParams.put("karakusagawaraseiken", new String[] {"desc", "The user punches the air, which sends a shockwave through water vapor in the air.", "dorikiRequiredForFishman", "7500"});
		Values.abilityWebAppExtraParams.put("kachiagehaisoku", new String[] {"desc", "The user delivers a powerful kick to the opponent's chin.", "dorikiRequiredForFishman", "2500"});
	}
	
	public static final Ability UCHIMIZU = new Uchimizu();
	public static final Ability MURASAME = new Murasame();
	public static final Ability KACHIAGE_HAISOKU = new KachiageHaisoku();
	public static final Ability SAMEHADA_SHOTEI = new SamehadaShotei();
	public static final Ability KARAKUSAGAWARA_SEIKEN = new KarakusagawaraSeiken();
	
	public static Ability[] abilitiesArray = new Ability[] {UCHIMIZU, MURASAME, SAMEHADA_SHOTEI, KARAKUSAGAWARA_SEIKEN, KACHIAGE_HAISOKU};
	
	public static class Uchimizu extends Ability
	{
		public Uchimizu() 
		{
			super(ListAttributes.UCHIMIZU); 
		}
			
		public void use(EntityPlayer player)
		{
			this.projectile = new FishKarateProjectiles.Uchimizu(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class Murasame extends Ability
	{
		public Murasame() 
		{
			super(ListAttributes.MURASAME); 
		}
			
		public void use(EntityPlayer player)
		{
			this.projectile = new FishKarateProjectiles.Soshark(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class KachiageHaisoku extends Ability
	{
		public KachiageHaisoku() 
		{
			super(ListAttributes.KACHIAGE_HAISOKU); 
		}
			
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{
			super.hitEntity(player, target);
			int damage = 10;
			if(player.isInsideOfMaterial(Material.water))
				damage = 40;
			target.attackEntityFrom(DamageSource.causePlayerDamage(player), damage);
		}
	}
	
	public static class SamehadaShotei extends Ability
	{
		public SamehadaShotei() 
		{
			super(ListAttributes.SAMEHADA_SHOTEI); 
		}
		
		public void startPassive(EntityPlayer player) 
		{
			super.startPassive(player);
		}
		
		public void duringPassive(EntityPlayer player, int passiveTimer) 
		{
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_SAMEHADA, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			
			if(passiveTimer > 800)
			{
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				super.endPassive(player);
			}
		}
		
		public void endPassive(EntityPlayer player)
		{
			this.startCooldown();
			this.startExtUpdate(player);	
		}
	}
	
	public static class KarakusagawaraSeiken extends Ability
	{
		public KarakusagawaraSeiken() 
		{
			super(ListAttributes.KARAKUSAGAWARA_SEIKEN); 
		}
			
		public void use(EntityPlayer player)
		{	
			if(!this.isOnCooldown)
			{
				for(EntityLivingBase elb : WyHelper.getEntitiesNear(player, 10))
				{
					elb.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
				}
				super.use(player);
			}			
		}
	}
}
