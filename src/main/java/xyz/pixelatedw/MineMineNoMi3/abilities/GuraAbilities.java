package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class GuraAbilities 
{

	static
	{
		Values.abilityWebAppExtraParams.put("kaishin", new String[] {"desc", "The user cracks the air, which launches a small but powerful explosion towards the opponent."});
		Values.abilityWebAppExtraParams.put("kabutowari", new String[] {"desc", "The user punches the air and creates a massive explosion around themselves."});
		Values.abilityWebAppExtraParams.put("shimayurashi", new String[] {"desc", "Launches a powerful explosion which spreads towards the opponent."});
		Values.abilityWebAppExtraParams.put("gekishin", new String[] {"desc", "The user creates a tremor while punching the enemy, inflicting massive damage."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Kaishin(), new Kabutowari(), new ShimaYurashi(), new Gekishin()};

	public static class Gekishin extends Ability
	{
		public Gekishin() 
		{
			super(ListAttributes.GEKISHIN); 
		}
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{			
			ExtendedEntityData props = ExtendedEntityData.get(player);
			super.hitEntity(player, target);
			target.attackEntityFrom(DamageSource.causePlayerDamage(player), 100 * props.getDamageMultiplier());
			AbilityExplosion explosion = WyHelper.newExplosion(player, target.posX, target.posY, target.posZ, 3);
			explosion.setDamageOwner(false);
			explosion.setSmokeParticles("");
			explosion.doExplosion();
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_GEKISHIN, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}
	}
	
	public static class Kaishin extends Ability
	{
		public Kaishin() 
		{
			super(ListAttributes.KAISHIN); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{			
			this.projectile = new GuraProjectiles.Kaishin(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Kabutowari extends Ability
	{
		public Kabutowari() 
		{
			super(ListAttributes.KABUTOWARI); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{			
			super.use(player);
		} 
	}
	
	public static class ShimaYurashi extends Ability
	{
		public ShimaYurashi() 
		{
			super(ListAttributes.SHIMA_YURASHI); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{	
			this.projectile = new GuraProjectiles.ShimaYurashi(player.worldObj, player, attr);
			
			/*for(int[] loc : WyHelper.getBlockLocationsNearby(player, 5))
			{
				Block block = player.worldObj.getBlock(loc[0], loc[1], loc[2]);
                EntityFallingBlock entityfallingblock = new EntityFallingBlock(player.worldObj, (double)((float)loc[0] + 0.5F), (double)((float)loc[1] + 0.5F), (double)((float)loc[2] + 1.5F), block, player.worldObj.getBlockMetadata(loc[0], loc[1], loc[2]));
               
                entityfallingblock.motionY = 0.5;
                entityfallingblock.motionZ = 1;
                
                player.worldObj.spawnEntityInWorld(entityfallingblock);
			}*/
			
			super.use(player);
		} 
	}
}
