package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

import java.util.List;

public class KachiAbilities {

    public static Ability[] abilitiesArray = new Ability[]{new HotBoilingSpecial(), new Evaporate()};

    public static class HotBoilingSpecial extends Ability {
        public HotBoilingSpecial() {
            super(ListAttributes.HOT_BOILING_SPECIAL);
        }

        public void passive(EntityPlayer player) {
            if (!this.isOnCooldown()) {
                super.passive(player);
            }

        }

        public void duringPassive(EntityPlayer player, int timer) {
            player.addPotionEffect(new PotionEffect(11, 8, 2));
        }

        public void endPassive(EntityPlayer player) {
            player.removePotionEffect(1);
            this.startExtUpdate(player);
            this.startCooldown();
        }
        
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			super.hitEntity(player, target);
		}
    }

    public static class Evaporate extends Ability {
        public Evaporate() {
            super(ListAttributes.EVAPORATE);
        }

        public void use(EntityPlayer player) {
            if (!this.isOnCooldown) {
           	
            List<int[]> coords = WyHelper.createFilledSphere(player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ, 6,Blocks.air, "liquids");
            for (int count = 0; count < coords.size(); count++) {
                int[] ints = coords.get(count);
                if (player.getEntityWorld().getBlock(ints[0], ints[1], ints[2]).equals(Blocks.air)) {
                    WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_EVAPORATE, ints[0], ints[1], ints[2]), player.dimension, ints[0], ints[1], ints[2], ID.GENERIC_PARTICLES_RENDER_DISTANCE);
                }
            }
            }
            super.use(player);
        }
    }
}
