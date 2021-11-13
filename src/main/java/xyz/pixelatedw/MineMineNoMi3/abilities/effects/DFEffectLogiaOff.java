package xyz.pixelatedw.MineMineNoMi3.abilities.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class DFEffectLogiaOff extends DFEffect
{

	public DFEffectLogiaOff(EntityLivingBase entity, int timer)
	{
		super(entity, timer, ID.EXTRAEFFECT_LOGIA_OFF);
	}

	@Override
	public void onEffectStart(EntityLivingBase entity)
	{
		ExtendedEntityData.get(entity).setIsLogia(false);
	}

	@Override
	public void onEffectEnd(EntityLivingBase entity)
	{
		ExtendedEntityData props = ExtendedEntityData.get(entity);
		if (!props.isLogia())
		{
			Values.logias.forEach(x ->
			{
				String name = WyHelper.getFancyName(new ItemStack(x).getDisplayName());

				if (name.equalsIgnoreCase(props.getUsedFruit() + "nomi") && !props.getUsedFruit().equalsIgnoreCase("yamiyami"))
				{
					System.out.println("###");
					props.setIsLogia(true);
				}
			});
		}
	}

}