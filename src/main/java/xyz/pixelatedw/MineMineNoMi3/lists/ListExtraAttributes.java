package xyz.pixelatedw.MineMineNoMi3.lists;

import java.awt.Color;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelCube;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelSphere;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.EffectType;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelArrow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelBazooka;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelFist;

public class ListExtraAttributes
{

	public static final AbilityAttribute WEATHER_CLOUD = new AbilityAttribute("Weather Cloud").setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileColor(Color.WHITE).setProjectileAlpha(150).setProjectileTicks(200).setProjectileCollisionSizes(65, 5, 65).setProjectileMoveThroughBlocks(true);

	public static final AbilityAttribute LIBERATION_BLOCK = new AbilityAttribute("Liberation Block").setProjectileModel(new ModelCube()).setProjectileColor(Color.BLACK).setProjectileDamage(20).setProjectileSize(3, 3, 3);
	 
	public static final AbilityAttribute METEOR = new AbilityAttribute("Meteor").setProjectileTicks(500).setProjectileModel(new ModelSphere()).setProjectileSize(20, 20, 20).setProjectileColor("56494B").setProjectileExplosion(13);
	
	public static final AbilityAttribute EL_THOR_THUNDER = new AbilityAttribute("El Thor Thunder").setProjectileTicks(500).setProjectileModel(new ModelCube()).setProjectileSize(60, 10, 10).setProjectileColor("77abff").setProjectileExplosion(2);
	
	public static final AbilityAttribute TSUNOTOKAGE_PILLAR = new AbilityAttribute("Tsuno-Tokage Pillar").setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileSize(4, 4, 20).setProjectileColor(Color.BLACK).setProjectileTicks(5);

	public static final AbilityAttribute GOMU_GOMU_NO_PISTOL = new AbilityAttribute("Gomu Gomu no Pistol").setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunopistol").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileDamage(6).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_JET_PISTOL = new AbilityAttribute("Gomu Gomu no Jet Pistol").setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunojetpistol").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileSpeed(4).setProjectileDamage(12).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_ELEPHANT_GUN = new AbilityAttribute("Gomu Gomu no Elephant Gun").setProjectileTicks(40).setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunoelephantgun").setProjectileSize(15, 15, 13).setModelOffsets(-1, 5, 0).setProjectileDamage(20).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1, 1, 1).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_KONG_GUN = new AbilityAttribute("Gomu Gomu no Kong Gun").setProjectileTicks(30).setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunokonggun").setProjectileSize(15, 15, 13).setModelOffsets(-1, 5, 0).setProjectileDamage(30).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1, 1, 1).setProjectilePhysical();
	
	public static final AbilityAttribute GOMU_GOMU_NO_BAZOOKA = new AbilityAttribute("Gomu Gomu no Bazooka").setProjectileModel(new ModelBazooka()).setProjectileTexture("gomugomunobazooka").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileDamage(10).setProjectileCollisionSizes(0.75, 0.3, 0.75).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_JET_BAZOOKA = new AbilityAttribute("Gomu Gomu no Jet Bazooka").setProjectileModel(new ModelBazooka()).setProjectileTexture("gomugomunojetbazooka").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileSpeed(4).setProjectileCollisionSizes(0.75, 0.3, 0.75).setProjectileDamage(16).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_GRIZZLY_MAGNUM = new AbilityAttribute("Gomu Gomu no Grizzly Magnum").setProjectileTicks(40).setProjectileModel(new ModelBazooka()).setProjectileTexture("gomugomunogrizzlymagnum").setProjectileSize(15, 15, 13).setModelOffsets(-1, 5, 0).setProjectileDamage(30).setProjectileCollisionSizes(1.75, 0.8, 1.75).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_LEO_BAZOOKA = new AbilityAttribute("Gomu Gomu no Leo Bazooka").setProjectileTicks(30).setProjectileModel(new ModelBazooka()).setProjectileTexture("gomugomunoleobazooka").setProjectileSize(15, 15, 13).setModelOffsets(-1, 5, 0).setProjectileDamage(50).setProjectileCollisionSizes(1.75, 0.8, 1.75).setProjectilePhysical();
	
	public static final AbilityAttribute GOMU_GOMU_NO_GATLING = new AbilityAttribute("Gomu Gomu no Gatling").setProjectileTicks(5).setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunopistol").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileDamage(6).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_JET_GATLING = new AbilityAttribute("Gomu Gomu no Jet Gatling").setProjectileTicks(5).setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunojetpistol").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileSpeed(4).setProjectileDamage(12).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_ELEPHANT_GATLING = new AbilityAttribute("Gomu Gomu no Elephant Gatling").setProjectileTicks(5).setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunoelephantgun").setProjectileSize(15, 15, 13).setModelOffsets(-1, 5, 0).setProjectileDamage(20).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1, 1, 1).setProjectilePhysical();
	public static final AbilityAttribute GOMU_GOMU_NO_KONG_ORGAN = new AbilityAttribute("Gomu Gomu no Kong Organ").setProjectileTicks(5).setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunokonggun").setProjectileSize(15, 15, 13).setModelOffsets(-1, 5, 0).setProjectileDamage(30).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1, 1, 1).setProjectilePhysical();
	
	public static final AbilityAttribute VOLT_VARI_5_MILLION = new AbilityAttribute("5 Million Volt Vari").setProjectileTicks(10).setProjectileModel(new ModelSphere()).setProjectileModel(new ModelSphere()).setProjectileSize(1, 1, 1).setProjectileDamage(2).setProjectileColor("92c1e5");
	public static final AbilityAttribute VOLT_VARI_20_MILLION = new AbilityAttribute("20 Million Volt Vari").setProjectileTicks(20).setProjectileModel(new ModelSphere()).setProjectileModel(new ModelSphere()).setProjectileSize(3, 3, 3).setProjectileDamage(5).setProjectileColor("7CB9E8");
	public static final AbilityAttribute VOLT_VARI_60_MILLION = new AbilityAttribute("60 Million Volt Vari").setProjectileTicks(30).setProjectileModel(new ModelSphere()).setProjectileModel(new ModelSphere()).setProjectileSize(5, 5, 5).setProjectileDamage(7).setProjectileColor("6bb0e5");
	public static final AbilityAttribute VOLT_VARI_200_MILLION = new AbilityAttribute("200 Million Volt Vari").setProjectileTicks(50).setProjectileModel(new ModelSphere()).setProjectileModel(new ModelSphere()).setProjectileSize(7, 7, 7).setProjectileDamage(10).setProjectileExplosion(3, false).setProjectileColor("3170a0");
	
	public static final AbilityAttribute GRAVITO = new AbilityAttribute("Gravito").setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileSize(6, 0.4, 1.5).setProjectileTicks(100).setProjectileColor("E590DF").setProjectileAlpha(50).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 550, 1), new PotionEffect(Potion.weakness.id, 550, 1));                       
	
	public static final AbilityAttribute NORMAL_BULLET = new AbilityAttribute("Bullet").setProjectileModel(new ModelSphere()).setProjectileDamage(4).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#878787").setProjectileSpeed(2);
	public static final AbilityAttribute KAIROSEKI_BULLET = new AbilityAttribute("Kairoseki Bullet").setProjectileModel(new ModelSphere()).setProjectileDamage(6).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#F3F3F3").setProjectileSpeed(2);
	public static final AbilityAttribute POP_GREEN = new AbilityAttribute("Pop Green").setProjectileModel(new ModelSphere()).setProjectileDamage(2).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#7ccc6a");
	public static final AbilityAttribute KUJA_ARROW = new AbilityAttribute("Kuja Arrow").setProjectileModel(new ModelArrow()).setProjectileTexture("kujaarrow").setProjectileDamage(4).setProjectileSize(1.25, 1.25, 1.25).setProjectileTicks(100).setProjectileSpeed(5).setProjectileCollisionSizes(0.5);

	public static final AbilityAttribute DIAL_AXE = new AbilityAttribute("Axe Dial").setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileSize(6, 0.4, 1.5).setProjectileTicks(100).setProjectileColor("69E3FF");
	public static final AbilityAttribute DIAL_MILKY = new AbilityAttribute("Milky Dial").setProjectileModel(new ModelSphere()).setProjectileSize(.1, .1, .1).setProjectileTicks(40).setProjectileColor("69E3FF").setProjectileMoveThroughBlocks(true);

	public static final AbilityAttribute CANNON_BALL = new AbilityAttribute("Cannon Ball").setProjectileModel(new ModelSphere()).setProjectileSize(3, 3, 3).setProjectileTicks(100).setProjectileColor("0B2D41").setProjectileExplosion(3, false);
}
