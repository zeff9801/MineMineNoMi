package xyz.pixelatedw.MineMineNoMi3.abilities.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class DFEffectSakeDrunk extends DFEffect
{

	private int stacks = 0;
	
	public DFEffectSakeDrunk(EntityLivingBase entity, int timer)
	{
		super(entity, timer, ID.EXTRAEFFECT_SAKE_DRUNK, false);
			
		this.props.addExtraEffect(effect);
		if(entity instanceof EntityPlayerMP)
			WyNetworkHelper.sendTo(new PacketSync(this.props), (EntityPlayerMP) entity);
		WyNetworkHelper.sendToAll(new PacketSyncInfo(entity.getEntityId(), this.props));
		this.updateThread = (new Update(this.props, timer));
		this.updateThread.start();
		
		for(String str : this.props.getExtraEffects())
		{
			if(!WyHelper.isNullOrEmpty(str) && str.equalsIgnoreCase(ID.EXTRAEFFECT_SAKE_DRUNK))
				this.stacks++;
		}		
	}

	@Override
	public void onEffectStart(EntityLivingBase entity)
	{
		if(this.stacks >= 3)
			entity.addPotionEffect(new PotionEffect(Potion.confusion.id, this.timer, 1));
	}

	@Override
	public void onEffectEnd(EntityLivingBase entity)
	{
		System.out.println("#####");
		for(String str : this.props.getExtraEffects())
		{
			if(!WyHelper.isNullOrEmpty(str) && str.equalsIgnoreCase(ID.EXTRAEFFECT_SAKE_DRUNK))
				props.removeExtraEffects(ID.EXTRAEFFECT_SAKE_DRUNK);
		}
	}

}
