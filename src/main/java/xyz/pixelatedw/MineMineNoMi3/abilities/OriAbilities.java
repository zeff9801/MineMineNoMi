package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectOriBind;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.OriProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

import java.util.ArrayList;

public class OriAbilities {

    public static Ability[] abilitiesArray = new Ability[]{new GreatCage(), new PrisonBreak(), new AwaseBaori(), new Bind()};

    public static ArrayList<int[]> makeShapeSquare(EntityPlayer player, int blockX, int blockY, int blockZ, Block blockCheck, Block blockReplace) {

        ArrayList<int[]> blockList = new ArrayList<>();

        for (int count = blockX - 1; count < blockX + 2; count++) {
            Block blockToReplace = player.worldObj.getBlock(count, blockY, blockZ);
            if (blockToReplace == blockCheck) {
                player.worldObj.setBlock(count, blockY, blockZ, blockReplace);
                blockList.add(new int[]{count, blockY, blockZ});
            }

        }
        for (int count = blockY - 1; count < blockY + 2; count++) {
            Block blockToReplace = player.worldObj.getBlock(blockX, count, blockZ);
            if (blockToReplace == blockCheck) {
                player.worldObj.setBlock(blockX, count, blockZ, blockReplace);
                blockList.add(new int[]{blockX, count, blockZ});
            }

        }
        for (int count = blockZ - 1; count < blockZ + 2; count++) {
            Block blockToReplace = player.worldObj.getBlock(blockX, blockY, count);
            if (blockToReplace == blockCheck) {
                player.worldObj.setBlock(blockX, blockY, count, blockReplace);
                blockList.add(new int[]{blockX, blockY, count});

            }

        }
        return blockList;
    }

    public static class GreatCage extends Ability {
        public GreatCage() {
            super(ListAttributes.GREAT_CAGE);
        }

        public void use(EntityPlayer player) {
            if (!isOnCooldown) {
                if (MainConfig.enableGriefing) {
                	WyHelper.createEmptyCube(player, new int[] {5, 3, 5}, ListMisc.OriBars, "air");
                }

                super.use(player);
            }
        }
    }

    public static class PrisonBreak extends Ability {

        private ArrayList<int[]> blockList;

        public PrisonBreak() {
            super(ListAttributes.PRISON_BREAK);
        }

        public void passive(EntityPlayer player) {
            MovingObjectPosition point = WyHelper.rayTraceBlocks(player);
            if (!this.isOnCooldown && point != null) {
                if (this.blockList == null) {
                    this.blockList = makeShapeSquare(player,point.blockX,point.blockY,point.blockZ,ListMisc.OriBars,Blocks.air);
                }
                super.passive(player);
            }
        }

        public void endPassive(EntityPlayer player) {
        	if(blockList != null)
        	{
	            for (int count = 0; count < blockList.size(); count++) {
	                int[] currentArray = blockList.get(count);
	                if (player.worldObj.getBlock(currentArray[0], currentArray[1], currentArray[2]) == Blocks.air) {
	                    player.worldObj.setBlock(currentArray[0],currentArray[1],currentArray[2], ListMisc.OriBars);
	                }
	            }
        	}
            this.blockList = null;
            this.startCooldown();
            this.startExtUpdate(player);
        }
    }

    public static class AwaseBaori extends Ability {


        public AwaseBaori() {
            super(ListAttributes.AWASE_BAORI);
        }

        public void use(final EntityPlayer player) {
            this.projectile = new OriProjectiles.AwaseBaori(player.worldObj,player,attr);
        	super.use(player);
        }
    }

    public static class Bind extends Ability {
        public Bind() {
            super(ListAttributes.BIND);
        }

        public void hitEntity(EntityPlayer player, EntityLivingBase target) {
            target.addPotionEffect(new PotionEffect(2, 20 * 8, 40));
            target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 8, 30));
            new DFEffectOriBind(target, 20 * 8);
            super.hitEntity(player,target);
        }
    }
}
