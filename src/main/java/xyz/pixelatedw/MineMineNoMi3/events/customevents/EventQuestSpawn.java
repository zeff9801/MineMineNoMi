package xyz.pixelatedw.MineMineNoMi3.events.customevents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;

public class EventQuestSpawn extends EntityEvent
{
    public final World world;
    public final EntityPlayer questPlayer;

    public EventQuestSpawn(Entity entity, EntityPlayer questPlayer, World world)
    {
        super(entity);
        this.world = world;
        this.questPlayer = questPlayer;
    }
}
