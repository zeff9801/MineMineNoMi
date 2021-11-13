package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectRustOverlay;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class SabiAbilities {
    public static Ability[] abilitiesArray = new Ability[]{new RustTouch()};

    public static class RustTouch extends Ability {
        public RustTouch() {
            super(ListAttributes.RUST_TOUCH);
        }

        public void hitEntity(EntityPlayer player, EntityLivingBase target) {
            if (!this.isOnCooldown()) {
                target.addPotionEffect(new PotionEffect(2, 30 * 4, 2));
                target.addPotionEffect(new PotionEffect(4, 30 * 4, 4));
                target.addPotionEffect(new PotionEffect(20, 30 * 4, 1));
                new DFEffectRustOverlay(target, 30 * 4);
    			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_RUSTTOUCH, target), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

                super.hitEntity(player, target);
            }
        }
    }
}
