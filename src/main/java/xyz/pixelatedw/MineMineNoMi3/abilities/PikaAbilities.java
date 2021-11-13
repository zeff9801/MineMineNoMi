package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.PikaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class PikaAbilities
{

	static
	{
		Values.abilityWebAppExtraParams.put("yasakaninomagatama", new String[] {"desc", "Fires a torrent of deadly light particles, causing huge destruction."});
		Values.abilityWebAppExtraParams.put("yatanokagami", new String[] {"desc", "Uses light to instantly teleport the user to their desired location."});
		Values.abilityWebAppExtraParams.put("amaterasu", new String[] {"desc", "Creates an immense beam of light, which causes massive damage."});
		Values.abilityWebAppExtraParams.put("flash", new String[] {"desc", "The user creates a bright flash of light, blinding their opponents."});
		Values.abilityWebAppExtraParams.put("amanomurakumo", new String[] {"desc", "Focuses light in the user's hand to create a sword."});

	}
	
	public static Ability[] abilitiesArray = new Ability[] {new YataNoKagami(), new AmaNoMurakumo(), new YasakaniNoMagatama(), new Amaterasu(), new Flash()};
	
	
	public static class Flash extends Ability
	{
		public Flash() 
		{
			super(ListAttributes.FLASH); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_FLASH, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.use(player);
		} 
	}
	
	public static class AmaNoMurakumo extends Ability
	{
		public AmaNoMurakumo() 
		{
			super(ListAttributes.AMA_NO_MURAKUMO); 
		}
		
		public void startPassive(EntityPlayer player) 
		{
			if(player.inventory.getCurrentItem() == null)
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ListMisc.AmaNoMurakumo));
			else
			{
				WyHelper.sendMsgToPlayer(player, "Cannot equip " + this.getAttribute().getAttributeName() + " while holding another item in hand !");
				this.passive(player);
			}
		}
		
		public void endPassive(EntityPlayer player) 
		{
			player.inventory.clearInventory(ListMisc.AmaNoMurakumo, -1);
		}
	}
	
	public static class Amaterasu extends Ability
	{
		public Amaterasu() 
		{
			super(ListAttributes.AMATERASU); 
		}
		
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_AMATERASU, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.startCharging(player);				
		}

		public void endCharging(EntityPlayer player)
		{						
			this.projectile = new PikaProjectiles.Amaterasu(player.worldObj, player, attr);
			super.endCharging(player);
		}

	}
	
	public static class YasakaniNoMagatama extends Ability
	{
		public YasakaniNoMagatama() 
		{
			super(ListAttributes.YASAKANI_NO_MAGATAMA); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new PikaProjectiles.YasakaniNoMagatama(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class YataNoKagami extends Ability
	{
		public YataNoKagami() 
		{
			super(ListAttributes.YATA_NO_KAGAMI); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				if(WyHelper.rayTraceBlocks(player) != null)
				{
					MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);
					
					int x = mop.blockX;
					int y = mop.blockY;
					int z = mop.blockZ;
					if (player.isRiding())
						player.mountEntity((Entity)null);
					EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 5.0F);
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_YATANOKAGAMI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
	                player.setPositionAndUpdate(event.targetX, event.targetY + 1, event.targetZ);
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_YATANOKAGAMI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
	                player.fallDistance = 0.0F;
				}
				super.use(player);
			}
		} 
	}

}
