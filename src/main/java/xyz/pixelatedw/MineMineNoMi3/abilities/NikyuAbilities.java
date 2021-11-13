package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.NikyuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class NikyuAbilities 
{

	static
	{
		Values.abilityWebAppExtraParams.put("ursusshock", new String[] {"desc", "The user compresses air and sends it towards the opponent to create a massive explosion."});
		Values.abilityWebAppExtraParams.put("padho", new String[] {"desc", "Launches a paw-shaped shockwave at the opponent."});
		Values.abilityWebAppExtraParams.put("tsupparipadho", new String[] {"desc", "Similar to 'Pad Ho', but fires a barrage of shockwaves."});
		Values.abilityWebAppExtraParams.put("hanpatsu", new String[] {"desc", "Anyone the user punches gets sent flying far into the air."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new PadHo(), new TsuppariPadHo(), new Hanpatsu(), new UrsusShock()};
	
	public static class Hanpatsu extends Ability
	{
		public Hanpatsu() 
		{
			super(ListAttributes.HANPATSU); 
		}
		
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{			
			double newPosX = 0, newPosY = 0, newPosZ = 0;
			
			newPosY += 55;
			Direction dir = WyHelper.get4Directions(player);
			if(dir == WyHelper.Direction.SOUTH)
				newPosX += WyMathHelper.randomWithRange(-200, 200);
			else if(dir == WyHelper.Direction.EAST)
				newPosX -= WyMathHelper.randomWithRange(-200, 200);
			else if(dir == WyHelper.Direction.NORTH)
				newPosZ += WyMathHelper.randomWithRange(-200, 200);
			else if(dir == WyHelper.Direction.WEST)  
				newPosZ -= WyMathHelper.randomWithRange(-200, 200);

			target.setPositionAndUpdate(target.posX + newPosX, target.posY + newPosY, target.posZ + newPosZ);

			super.hitEntity(player, target);
		}
	}
	
	public static class TsuppariPadHo extends Ability
	{
		public TsuppariPadHo() 
		{
			super(ListAttributes.TSUPPARI_PAD_HO); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new NikyuProjectiles.PadHo(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class PadHo extends Ability
	{
		public PadHo() 
		{
			super(ListAttributes.PAD_HO); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new NikyuProjectiles.PadHo(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class UrsusShock extends Ability
	{
		public UrsusShock() 
		{
			super(ListAttributes.URSUS_SHOCK); 
		}
		
		public void endCharging(EntityPlayer player)
		{		
			this.projectile = new NikyuProjectiles.UrsusShock(player.worldObj, player, attr);
			super.endCharging(player);
		}
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
}
