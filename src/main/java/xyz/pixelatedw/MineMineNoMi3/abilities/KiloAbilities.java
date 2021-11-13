package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class KiloAbilities {

    public static Ability[] abilitiesArray = new Ability[]{new Weightless(), new KickOffJump(), new HeavyPunch(), new KiloPress()};


    private static boolean hasStrength(EntityPlayer player) {
        Object[] effects = player.getActivePotionEffects().toArray();
        for (int i = 0; i < effects.length; i++) {
            PotionEffect currentEffect = (PotionEffect) effects[i];
            if (currentEffect.getPotionID() == 5 && currentEffect.getAmplifier() == 8) {
                return true;
            }
        } return false;
    }


    private static void movePlayer(String c, double x, double y, double z, EntityPlayer p) {
        WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
    }

    public static class Weightless extends Ability {

        public Weightless() {
            super(ListAttributes.WEIGHTLESS);
        }

        public void passive(EntityPlayer player) {
            if (!this.isOnCooldown) {
                super.passive(player);
            }


        }

        public void duringPassive(EntityPlayer player, int passiveTimer) {
                if (player.onGround) {
                    replaceUmbrella(player);
                    this.setPassiveActive(false);
                    this.setCooldownActive(true);
                    this.endPassive(player);
                } else if (player.getHeldItem() != null && player.getHeldItem().getItem() == ListMisc.UmbrellaOpen) {
                    double mZ = 0;
                    double mX = 0;
                   WyHelper.Direction dir = WyHelper.get8Directions(player);
                    if(dir == WyHelper.Direction.NORTH) mZ -= 0.25;
                    if(dir == WyHelper.Direction.NORTH_WEST) {mZ -= 0.20; mX -= 0.20;}
                    if(dir == WyHelper.Direction.SOUTH) mZ += 0.25;
                    if(dir == WyHelper.Direction.NORTH_EAST) {mZ -= 0.20; mX += 0.20;}
                    if(dir == WyHelper.Direction.WEST) mX -= 0.25;
                    if(dir == WyHelper.Direction.SOUTH_WEST) {mZ += 0.20; mX -= 0.20;}
                    if(dir == WyHelper.Direction.EAST) mX += 0.25;
                    if(dir == WyHelper.Direction.SOUTH_EAST) {mZ += 0.20; mX += 0.20;}
                    player.fallDistance = 0;
                    movePlayer("=",mX,-0.1,mZ,player);
                } else if (player.getHeldItem() != null && player.getHeldItem().getItem() == ListMisc.Umbrella) {
                    int slot = player.inventory.currentItem;
                    player.inventory.setInventorySlotContents(slot, new ItemStack(ListMisc.UmbrellaOpen));
                } else {
                    replaceUmbrella(player);
                }


        }

        public void endPassive(EntityPlayer player) {
        	this.setPassiveActive(false);
            replaceUmbrella(player);

        }

        public void replaceUmbrella(EntityPlayer player) {
            for (int count = 0; count < player.inventory.getSizeInventory(); count++) {
                if (player.inventory.getStackInSlot(count) != null && player.inventory.getStackInSlot(count).getItem() == ListMisc.UmbrellaOpen) {
                    player.inventory.setInventorySlotContents(count, new ItemStack(ListMisc.Umbrella));
                }
            }
        }


    }

    public static class KickOffJump extends Ability {
        private double initialY = 255;
        private boolean isFlying = false;
        private int countDoon = 0;


        public KickOffJump() {
            super(ListAttributes.KICK_OFF_JUMP);
        }

        public void passive(EntityPlayer player) {
            if (!this.isOnCooldown) {
                this.initialY = player.posY;
                super.passive(player);
            }


        }

        public void duringPassive(EntityPlayer player, int passiveTimer) {
            if (!isFlying && player.posY > this.initialY) {
                this.isFlying = true;
            } else if (isFlying && this.countDoon <= 10) {
                movePlayer("=",player.motionX,2.5,player.motionZ,player);
                this.countDoon += 1;
            } else if (isFlying && this.countDoon >=4) {
                this.setPassiveActive(false);
                this.setCooldownActive(true);
                this.endPassive(player);
            } else if (player.onGround) {
                this.initialY = player.posY;
            }
        }

        public void endPassive(EntityPlayer player) {
            this.countDoon = 0;
            this.isFlying = false;
            this.startCooldown();
            this.startExtUpdate(player);
        }
    }

    public static class HeavyPunch extends Ability {
        public HeavyPunch() {
            super (ListAttributes.HEAVY_PUNCH);
        }
/*
        public void passive(EntityPlayer player) {
            if (!this.isOnCooldown) {
                super.passive(player);
            }

        }

        public void duringPassive(EntityPlayer player, int timer) {
            player.addPotionEffect(new PotionEffect(2, 4, 40));
            movePlayer("=",0,-2,0,player);
            if (timer == 130) {
                player.addPotionEffect(new PotionEffect(5,40,8));
                WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KILO, player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

            } else if (timer > 130 && hasStrength(player)) {

                player.addPotionEffect(new PotionEffect(5,40,8));
            } else if (timer > 130 && !hasStrength(player)) {
                this.setPassiveActive(false);
                this.setCooldownActive(true);
                this.endPassive(player);
            }

        }

        public void endPassive(EntityPlayer player) {
            this.startCooldown();
            this.startExtUpdate(player);
        }

*/

    }

    public static class KiloPress extends Ability {

        private double initialY;

        public KiloPress() {
            super(ListAttributes.KILO_PRESS);
        }

        public void passive(EntityPlayer player) {
            if (!this.isOnCooldown) {
            	AbilityProperties abilityProps = AbilityProperties.get(player);
            	Weightless weightless = (Weightless) abilityProps.getAbilityFromName(ListAttributes.WEIGHTLESS.getAttributeName());
            	if(weightless != null && weightless.isPassiveActive())
            	{
            		weightless.endPassive(player);
    				WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);					
            	}
                this.initialY = player.posY;
                super.passive(player);
            }

        }

        public void duringPassive(EntityPlayer player, int timer) {
            if(player.onGround) {
                this.setPassiveActive(false);
                this.setCooldownActive(true);
                this.endPassive(player);
            } else {
                movePlayer("=", 0, -2, 0, player);
            }
        }

        public void endPassive(EntityPlayer player) {
            double damage = this.initialY - player.posY;
            if (!(damage <= 0)) {
                for(EntityLivingBase entity : WyHelper.getEntitiesNear(player, 5))
                {
                    entity.attackEntityFrom(DamageSource.causePlayerDamage(player),  (float) (damage * 0.75));
                }
            }

			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KILOPRESS, player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
            this.startExtUpdate(player);
        }
    }


}

