package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelMarine extends ModelBiped
{

	public ModelMarine()
	{
		super(0, 0, 64, 64);
		this.bipedHeadwear.showModel = false;
	}

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
    {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scaleFactor, ent);
	}
}

