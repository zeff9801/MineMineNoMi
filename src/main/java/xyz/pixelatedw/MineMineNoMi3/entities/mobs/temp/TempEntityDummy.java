package xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class TempEntityDummy extends EntityLiving
{

	public TempEntityDummy(World world)
	{
		super(world);
	}

	@Override
	public void onLivingUpdate() {}
	
	@Override
	public void onUpdate() {super.onUpdate();}
}
