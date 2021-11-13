package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kilo;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

import java.util.Random;

public class ParticleEffectHeavyPunch extends ParticleEffect
{

    public void spawn(EntityPlayer player, double posX, double posY, double posZ)
    {
        for (int i = 0; i < 20; i++)
        {
            double offsetX = (new Random().nextInt(10) + 1.0D - 10.0D) / 10.0D;
            double offsetY = (new Random().nextInt(30) + 1.0D - 10.0D) / 10.0D;
            double offsetZ = (new Random().nextInt(10) + 1.0D - 10.0D) / 10.0D;

            MainMod.proxy.spawnCustomParticles(player,
                    new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_KILO,
                            posX + offsetX,
                            posY + offsetY,
                            posZ + offsetZ,
                            0, 0, 0)
                            .setParticleScale(3F).setParticleGravity(0).setParticleAge(1));
        }
    }

}
