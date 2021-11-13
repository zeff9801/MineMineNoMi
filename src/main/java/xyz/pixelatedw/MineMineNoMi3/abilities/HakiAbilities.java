package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class HakiAbilities 
{		
	static
	{
		Values.abilityWebAppExtraParams.put("busoshokuhaki", new String[] {"desc", "The user forms an invisible armor around themselves using their willpower, By using this form of Haki, the user can damage Logias.", "dorikiRequiredForHumans", "9000", "dorikiRequiredForFishman", "9000", "dorikiRequiredForCyborgs", "8500"});
		Values.abilityWebAppExtraParams.put("kenbunshokuhaki", new String[] {"desc", "Allows the user to sense the presence of others, pointing them to the opponent, Can also locate invisible mobs and players.", "dorikiRequiredForHumans", "5000", "dorikiRequiredForFishman", "4000", "dorikiRequiredForCyborgs", "5500"});
	}
	
	public static final Ability KENBUNSHOKU_HAKI_AURA = new KenbunshokuHakiAura();
	public static final Ability KENBUNSHOKU_HAKI_FUTURE_SIGHT = new KenbunshokuHakiFutureSight();
	public static final Ability BUSOSHOKU_HAKI_HARDENING = new BusoshokuHakiHardening();
	public static final Ability BUSOSHOKU_HAKI_FULL_BODY_HARDENING = new BusoshokuHakiFullBodyHardening();
	public static final Ability BUSOSHOKU_HAKI_IMBUING = new BusoshokuHakiImbuing();
	public static final Ability HAOSHOKU_HAKI = new HaoshokuHaki();

	public static Ability[] abilitiesArray = new Ability[] {KENBUNSHOKU_HAKI_AURA, KENBUNSHOKU_HAKI_FUTURE_SIGHT, BUSOSHOKU_HAKI_HARDENING, BUSOSHOKU_HAKI_FULL_BODY_HARDENING, BUSOSHOKU_HAKI_IMBUING, HAOSHOKU_HAKI};
	
	public static class HaoshokuHaki extends Ability
	{
		public HaoshokuHaki() 
		{
			super(ListAttributes.HAOSHOKU_HAKI); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(true);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);

			super.startCharging(player);
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(false);

			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_HAOSHOKU_HAKI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

			DevilFruitsHelper.haoAttackEntities(player);
			
			super.endCharging(player);
		}
	}
	
	public static class KenbunshokuHakiAura extends Ability
	{
		public KenbunshokuHakiAura() 
		{
			super(ListAttributes.KENBUNSHOKU_HAKI_AURA); 
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(true);
			props.triggerKenHaki(true);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(false);
			props.triggerKenHaki(false);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
	}
	
	public static class KenbunshokuHakiFutureSight extends Ability
	{
		private int protection = 700;
		
		public KenbunshokuHakiFutureSight() 
		{
			super(ListAttributes.KENBUNSHOKU_HAKI_FUTURE_SIGHT); 
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(true);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			
			this.protection = 700;
		}
		
		@Override
		public void duringPassive(EntityPlayer player, int timer)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(this.protection <= 0)
			{		
				props.triggerActiveHaki(false);
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);

				this.getAttribute().setAbilityCooldown(200);
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				super.endPassive(player);
			}
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(false);		
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			
			if(this.protection <= 100)
			{
				this.getAttribute().setAbilityCooldown(20);
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				super.endPassive(player);
			}
		}
		
		public void reduceProtection(float ammount)
		{
			this.protection -= ammount;
		}
	}
	
	public static class BusoshokuHakiFullBodyHardening extends Ability
	{
		public BusoshokuHakiFullBodyHardening() 
		{
			super(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING); 			
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(true);
			props.triggerBusoHaki(true);

			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(false);
			props.triggerBusoHaki(false);

			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
		
		@Override
		public void duringPassive(EntityPlayer player, int timer)
		{
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 99999, true));
		}
	}
	
	public static class BusoshokuHakiHardening extends Ability
	{
		public BusoshokuHakiHardening() 
		{
			super(ListAttributes.BUSOSHOKU_HAKI_HARDENING); 			
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(true);
			props.triggerBusoHaki(true);

			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(false);
			props.triggerBusoHaki(false);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
	}
	
	public static class BusoshokuHakiImbuing extends Ability
	{
		public BusoshokuHakiImbuing() 
		{
			super(ListAttributes.BUSOSHOKU_HAKI_IMBUING); 			
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(true);
			props.triggerBusoHaki(true);

			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.triggerActiveHaki(false);
			props.triggerBusoHaki(false);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
	}
}
