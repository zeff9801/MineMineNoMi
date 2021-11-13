package xyz.pixelatedw.MineMineNoMi3.events;

import java.util.List;
import java.util.stream.Collectors;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class EventsCrew
{

	// Lmao you got bamboozeled there is no crew only us, the Dugongs
	// (ง •̀_•̀)ง
	
	@SubscribeEvent
	public void onEntityAttack(LivingHurtEvent event)
	{
		if (event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer attacker = (EntityPlayer) event.source.getSourceOfDamage();
			EntityLivingBase attacked = event.entityLiving;
			
			// TODO Should be replaced by actual crew data from some NBT when the time comes !
			List<EntityLivingBase> crewMembers = WyHelper.getEntitiesNear(attacker, 20, EntityMob.class).stream().collect(Collectors.toList());

			if(crewMembers.size() > 0)
			{
				crewMembers.stream().forEach(x -> 
				{
					if(x instanceof IEntityOwnable && x instanceof EntityMob)
					{
						IEntityOwnable ownableComponent = (IEntityOwnable) x;
						EntityMob mobComponent = (EntityMob) x;
						
						if(ownableComponent.getOwner() == attacker)
						{
							mobComponent.setAttackTarget(attacked);
						}
					}
				});
			}
		}
	}
}
