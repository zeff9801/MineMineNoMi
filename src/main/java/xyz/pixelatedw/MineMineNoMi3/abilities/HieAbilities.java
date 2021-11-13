package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectHieSlowness;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class HieAbilities
{
	static
	{
		Values.abilityWebAppExtraParams.put("iceblockpartisan", new String[] {"desc", "Creates several spears of ice that the user hurls at the enemy."});
		Values.abilityWebAppExtraParams.put("iceball", new String[] {"desc", "Creates a sphere of ice that surrounds the opponent."});
		Values.abilityWebAppExtraParams.put("iceage", new String[] {"desc", "Freezes a large area around the user and everyone inside of it."});
		Values.abilityWebAppExtraParams.put("icetimecapsule", new String[] {"desc", "A wave of ice is sent along the ground and freezes every enemy it hits."});
		Values.abilityWebAppExtraParams.put("iceblockpheasant", new String[] {"desc", "Releases a massive wave of ice in the shape of a pheasant."});
		Values.abilityWebAppExtraParams.put("icesaber", new String[] {"desc", "Creates a sharp blade made of solid ice."});
	}

	public static Ability[] abilitiesArray = new Ability[] {new IceBlockPartisan(), new IceSaber(), new IceAge(), new IceBall(), new IceTimeCapsule(), new IceBlockPheasant()};
	
	public static class IceSaber extends Ability
	{
		public IceSaber()
		{
			super(ListAttributes.ICE_SABER); 
		}
		
		@Override
		public void startPassive(EntityPlayer player) 
		{
			if(player.inventory.getCurrentItem() == null)
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ListMisc.IceSaber));
			else
			{
				WyHelper.sendMsgToPlayer(player, "Cannot equip " + this.getAttribute().getAttributeName() + " while holding another item in hand !");
				this.passive(player);
			}
		}
		
		@Override
		public void endPassive(EntityPlayer player) 
		{
			player.inventory.clearInventory(ListMisc.IceSaber, -1);
		}
	}
		
	
	public static class IceBlockPartisan extends Ability
	{
		public IceBlockPartisan() 
		{
			super(ListAttributes.ICE_BLOCK_PARTISAN); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBlockPartisan(player.worldObj, player, ListAttributes.ICE_BLOCK_PARTISAN);
			super.use(player);
		};	
	}

	public static class IceAge extends Ability
	{
		public IceAge() 
		{
			super(ListAttributes.ICE_AGE); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{		
				final World world = player.worldObj;

				if(MainConfig.enableGriefing)
				{
					for(int i = -15; i < 15; i++)
					for(int j = -10; j < 10; j++)
					for(int k = -15; k < 15; k++)
					{
						int posX = (int) (player.posX + i + (i < -WyMathHelper.randomWithRange(8, 12) || i > WyMathHelper.randomWithRange(8, 12) ? WyMathHelper.randomWithRange(-5, 5) : 0));
						int posY = (int) player.posY + j;
						int posZ = (int) (player.posZ + k + (k < -WyMathHelper.randomWithRange(8, 12) || k > WyMathHelper.randomWithRange(8, 12) ? WyMathHelper.randomWithRange(-5, 5) : 0));
						
						if(!player.worldObj.isAirBlock(posX, posY, posZ) && player.worldObj.getBlock(posX, posY, posZ) != ListMisc.Ope
								&& player.worldObj.getBlock(posX, posY, posZ) != ListMisc.OpeMid && player.worldObj.getBlock(posX, posY, posZ) != Blocks.bedrock)
							player.worldObj.setBlock(posX, posY, posZ, Blocks.packed_ice);				
					}
					
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_ICEAGE, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
				}
				
				for(EntityLivingBase target : WyHelper.getEntitiesNear(player, 15))
				{
					new DFEffectHieSlowness(target, 200);
				}
				
				super.use(player);
			}
		}
	}
	
	public static class IceBall extends Ability
	{
		public IceBall() 
		{
			super(ListAttributes.ICE_BALL); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBall(player.worldObj, player, ListAttributes.ICE_BALL);
			super.use(player);
		};	
	}
	
	public static class IceTimeCapsule extends Ability
	{
		public IceTimeCapsule() 
		{
			super(ListAttributes.ICE_TIME_CAPSULE); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown())
			{
				if(MainConfig.enableGriefing)
				{
					for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 25))
					{
						WyHelper.createFilledCube(l, new int[] {2, 4, 2}, Blocks.packed_ice, "air", "foliage");
					}	
				}
			
				super.use(player);
			}
		};	
	}
	
	public static class IceBlockPheasant extends Ability
	{
		public IceBlockPheasant() 
		{
			super(ListAttributes.ICE_BLOCK_PHEASANT); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBlockPheasant(player.worldObj, player, ListAttributes.ICE_BLOCK_PHEASANT);
			super.use(player);
		};		
	}
	
}
