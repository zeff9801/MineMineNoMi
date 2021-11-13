package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.DoruProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DoruAbilities 
{
	static
	{
		Values.abilityWebAppExtraParams.put("candlewall", new String[] {"desc", "Creates a wax wall to protect the user."});
		Values.abilityWebAppExtraParams.put("candlehouse", new String[] {"desc", "Creates a big house-like structure made of wax, to protect the user."});
		Values.abilityWebAppExtraParams.put("dorudoruartsmori", new String[] {"desc", "The user fires a harpoon made of wax at the opponent."});
		Values.abilityWebAppExtraParams.put("dorudoruartsken", new String[] {"desc", "The user uses hardened wax to create a sword."});
		Values.abilityWebAppExtraParams.put("candlelock", new String[] {"desc", "Traps the opponent's feet in hardened wax, which makes them unable to move."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new DoruDoruArtsMori(), new DoruDoruArtsKen(), new CandleWall(), new CandleHouse(), new CandleLock()};

	public static class CandleLock extends Ability
	{
		public CandleLock() 
		{
			super(ListAttributes.CANDLE_LOCK); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new DoruProjectiles.CandleLock(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class DoruDoruArtsKen extends Ability
	{
		public DoruDoruArtsKen()
		{
			super(ListAttributes.DORU_DORU_ARTS_KEN); 
		}
		
		public void startPassive(EntityPlayer player) 
		{
			if(player.inventory.getCurrentItem() == null)
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ListMisc.DoruDoruArtsKen));
			else
			{
				WyHelper.sendMsgToPlayer(player, "Cannot equip " + this.getAttribute().getAttributeName() + " while holding another item in hand !");
				this.passive(player);
			}
		}
		
		public void endPassive(EntityPlayer player) 
		{
			player.inventory.clearInventory(ListMisc.DoruDoruArtsKen, -1);
		}
	}
	
	public static class CandleHouse extends Ability
	{
		public CandleHouse() 
		{
			super(ListAttributes.CANDLE_HOUSE); 
		}
		
		public void use(EntityPlayer player)
		{		
			if(!isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					for(int y = 0; y <= 3; y++)
					{
						for(int x = 0; x < 1; x++)
							for(int z = -5; z < 5; z++)
								player.worldObj.setBlock(((int) player.posX + 6) - x, (int) player.posY + y, (int) player.posZ - z, ListMisc.WaxBlock);
						for(int x = 0; x < 1; x++)
							for(int z = -5; z < 5; z++)
								player.worldObj.setBlock(((int) player.posX - 5) - x, (int) player.posY + y, (int) player.posZ - z, ListMisc.WaxBlock);
						for(int x = -5; x < 5; x++)
							for(int z = 0; z < 1; z++)
								player.worldObj.setBlock((int) player.posX - x, (int) player.posY + y, ((int) player.posZ + 6) - z, ListMisc.WaxBlock);
						for(int x = -5; x < 5; x++)
							for(int z = 0; z < 1; z++)
								player.worldObj.setBlock((int) player.posX - x, (int) player.posY + y, ((int) player.posZ - 5) - z, ListMisc.WaxBlock);
					}
					for(int x = -5; x < 5; x++)
						for(int y = 0; y < 1; y++)
							for(int z = -5; z < 5; z++)
						  		player.worldObj.setBlock((int) player.posX - x, ((int) player.posY + 4) + y, (int) player.posZ - z, ListMisc.WaxBlock);
				}
				
				super.use(player);
			}
		} 
	}
	
	public static class CandleWall extends Ability
	{
		public CandleWall() 
		{
			super(ListAttributes.CANDLE_WALL); 
		}
		
		public void use(EntityPlayer player)
		{		
			if(!isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
						WyHelper.createFilledCube(player.worldObj, player.posX, player.posY, player.posZ - 3, new int[] {3, 4, 1}, ListMisc.WaxBlock, "air", "foliage");
					if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
						WyHelper.createFilledCube(player.worldObj, player.posX, player.posY, player.posZ + 3, new int[] {3, 4, 1}, ListMisc.WaxBlock, "air", "foliage");
					if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
						WyHelper.createFilledCube(player.worldObj, player.posX + 3, player.posY, player.posZ, new int[] {1, 4, 3}, ListMisc.WaxBlock, "air", "foliage");
					if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
						WyHelper.createFilledCube(player.worldObj, player.posX - 3, player.posY, player.posZ, new int[] {1, 4, 3}, ListMisc.WaxBlock, "air", "foliage");
				}
					
				super.use(player);
			}
		} 
	}
	
	public static class DoruDoruArtsMori extends Ability
	{
		public DoruDoruArtsMori() 
		{
			super(ListAttributes.DORU_DORU_ARTS_MORI); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new DoruProjectiles.DoruDoruArtsMori(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
}
