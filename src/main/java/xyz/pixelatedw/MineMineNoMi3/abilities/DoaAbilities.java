package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

import java.util.Timer;
import java.util.TimerTask;

public class DoaAbilities {

    public static Ability[] abilitiesArray = new Ability[]{new AirDoor(), new Door()};

    public static class AirDoor extends Ability {
        
        public AirDoor() {
            super(ListAttributes.AIR_DOOR);
        }

        public void passive(EntityPlayer player) {
            if (!this.isOnCooldown()) {
                ExtendedEntityData propz = ExtendedEntityData.get(player);
            propz.setInAirWorld(true);
            WyNetworkHelper.sendTo(new PacketSync(propz), (EntityPlayerMP) player);
            WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getEntityId(), propz));
            super.passive(player);
        }
        }

        public void duringPassive(EntityPlayer player, int timer) {
            if (timer > 45 * 8) {
                this.setPassiveActive(false);
                this.setCooldownActive(true);
                this.endPassive(player);
            }
        }

        public void endPassive(EntityPlayer player) {
            this.startCooldown();
            this.startExtUpdate(player);
            ExtendedEntityData propz = ExtendedEntityData.get(player);
            propz.setInAirWorld(false);
            WyNetworkHelper.sendTo(new PacketSync(propz), (EntityPlayerMP) player);
            WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getEntityId(), propz));
        }

    }

    public static class Door extends Ability {
        public Door() {
            super(ListAttributes.DOOR);
        }

        public static boolean isBlock(int[] coords, EntityPlayer player) {
            if (player.getEntityWorld().getBlock(coords[0], coords[1], coords[2]) == Blocks.air && player.getEntityWorld().getBlock(coords[0], (coords[1] + 1), coords[2]) == Blocks.air) {
                return true;
            }
            return false;
        }

        public void use(EntityPlayer player) {
            if (!this.isOnCooldown()) {

            MovingObjectPosition MOP = WyHelper.rayTraceBlocks(player);

            if (MOP != null && (MOP.blockY >= (player.posY + 1))) {
                int checkX = MOP.blockX - (int) player.posX;
                int checkZ = MOP.blockZ - (int) player.posZ;

                if ((checkX > -3 && checkX < 3) && (checkZ > -3 && checkZ < 3)) {

                    int[] coords = new int[]{MOP.blockX, (int) player.posY, MOP.blockZ};
                    int timer = 0;
                    while (!isBlock(coords, player)) {
                        coords = WyMathHelper.moveAway(player, coords);
                        timer += 1;
                        if (timer >= 100) {
                            break;
                        }

                    }
                    WyMathHelper.moveAway(player, coords);

                    if (timer < 100) {
                        player.setPositionAndUpdate(coords[0], coords[1], coords[2]);
                        super.use(player);
                    }

                }
                }
            }
        }
    }

}
