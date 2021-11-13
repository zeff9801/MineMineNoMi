package xyz.pixelatedw.MineMineNoMi3.events.customevents;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class EventDoriki extends EntityEvent
{
	public EntityPlayer player;
	public ExtendedEntityData props;
	public int doriki;
	
	public EventDoriki(EntityPlayer entity) 
	{
		super(entity);
		this.player = entity;
		this.props = ExtendedEntityData.get(player);
	}

}
