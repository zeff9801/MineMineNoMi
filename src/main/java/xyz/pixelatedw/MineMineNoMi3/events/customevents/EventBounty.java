package xyz.pixelatedw.MineMineNoMi3.events.customevents;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class EventBounty extends EntityEvent
{
	public EntityPlayer player;
	public ExtendedEntityData props;
	public long amount;
	
	public EventBounty(EntityPlayer entity) 
	{
		this(entity, 0);
	}
	
	public EventBounty(EntityPlayer entity, long plusBounty) 
	{
		super(entity);
		this.player = entity;
		this.amount = plusBounty;
		this.props = ExtendedEntityData.get(player);
	}

}