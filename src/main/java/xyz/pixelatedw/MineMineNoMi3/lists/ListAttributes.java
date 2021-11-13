package xyz.pixelatedw.MineMineNoMi3.lists;

import java.awt.Color;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelCube;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelSphere;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.EffectType;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelArrow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelBrickBat;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelFist;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelHeart;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelHydra;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelMeigo;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelMiniHollow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelNegativeHollow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelNoroNoroBeam;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelPaw;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelPheasant;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelShark;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelSpear;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelTokuHollow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelTrident;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelYukiRabi;

public class ListAttributes 
{
	
	
	public static final AbilityAttribute MINI_MINI_NO_FULL_REBOUND = new AbilityAttribute("Mini Mini no Full Rebound").setAbilityCooldown(3).setAbilityPassive(true);
	
	public static final AbilityAttribute BIGAN = new AbilityAttribute("Bigan").setAbilityCooldown(8).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileColor("#6D5E24").setProjectileSize(1, 1, 2.4).setProjectileTicks(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.weakness.id, 600, 0), new PotionEffect(Potion.moveSlowdown.id, 600, 2)).setModelOffsets(0, 1.5, 0);
	public static final AbilityAttribute GIRAFFE_SPEED_POINT = new AbilityAttribute("Giraffe Speed Point").setAbilityDisplayName("Speed Point").setAbilityTexture("giraffefull").setAbilityCooldown(1).setAbilityPassive(true);
	public static final AbilityAttribute GIRAFFE_POWER_POINT = new AbilityAttribute("Giraffe Power Point").setAbilityDisplayName("Power Point").setAbilityTexture("giraffehybrid").setAbilityCooldown(1).setAbilityPassive(true);
	
	public static final AbilityAttribute MOGURA_TONPO = new AbilityAttribute("Mogura Tonpo: Mogugyo").setAbilityCooldown(10).setAbilityTexture("moguratonpo");
	public static final AbilityAttribute MOGURA_BANANA = new AbilityAttribute("Mogura Banana").setAbilityCooldown(12).setAbilityPunch(10);
	public static final AbilityAttribute MOGU_POWER_POINT = new AbilityAttribute("Mogu Power Point").setAbilityDisplayName("Mole Point").setAbilityTexture("molepoint").setAbilityCooldown(1).setAbilityPassive(true);
	
	public static final AbilityAttribute GANMEN_SEICHO_HORMONE = new AbilityAttribute("Ganmen Seicho Hormone").setAbilityCooldown(5).setAbilityPunch();
	public static final AbilityAttribute TENSION_HORMONE = new AbilityAttribute("Tension Hormone").setAbilityCooldown(40).setAbilityPunch();
	public static final AbilityAttribute CHIYU_HORMONE = new AbilityAttribute("Chiyu Hormone").setAbilityCooldown(20).setAbilityPunch();
	public static final AbilityAttribute ONNA_HORMONE = new AbilityAttribute("Onna Hormone").setAbilityCooldown(15).setAbilityPunch();
	
	public static final AbilityAttribute CHIYUPOPO = new AbilityAttribute("Chiyupopo").setAbilityCooldown(10);
	public static final AbilityAttribute HEALING_TOUCH = new AbilityAttribute("Healing Touch").setAbilityCooldown(15).setAbilityPunch();
	
	public static final AbilityAttribute ZOU_HYBRID_POINT = new AbilityAttribute("Zou Hybrid Point").setAbilityCooldown(1).setAbilityDisplayName("Hybrid Point").setAbilityTexture("zouhybrid").setAbilityPassive(true);
	public static final AbilityAttribute ZOU_FULL_POINT = new AbilityAttribute("Zou Point").setAbilityTexture("zoufull").setAbilityCooldown(1).setAbilityPassive(true);
	public static final AbilityAttribute IVORY_DART = new AbilityAttribute("Ivory Dart").setAbilityCooldown(10);
	public static final AbilityAttribute GREAT_STOMP = new AbilityAttribute("Great Stomp").setAbilityCooldown(15);
	public static final AbilityAttribute IVORY_STOMP = new AbilityAttribute("Ivory Stomp").setAbilityCooldown(8).setAbilityPunch();
	public static final AbilityAttribute TRUNK_SHOT = new AbilityAttribute("Trunk Shot").setAbilityCooldown(7).setProjectileModel(new ModelCube()).setProjectileTexture("zouskin").setProjectileSize(2.5, 2.5, 4).setProjectileColor("838993").setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.weakness.id, 5 * 20)).setProjectilePhysical();
	
	public static final AbilityAttribute SOUL_PARADE = new AbilityAttribute("Soul Parade").addEffects(EffectType.USER, new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100)).setAbilityCooldown(5).setAbilityPassive();
	public static final AbilityAttribute KASURIUTA_FUBUKI_GIRI = new AbilityAttribute("Kasuriuta: Fubuki Giri").setAbilityCooldown(10);
	
	public static final AbilityAttribute BAKU_BAKU_FACTORY = new AbilityAttribute("Baku Baku Factory");
	public static final AbilityAttribute BAKU_TSUIHO = new AbilityAttribute("Baku Tsuiho").setAbilityCooldown(10).setAbilityCharges(10 * 20).setProjectileModel(new ModelCube()).setProjectileSize(2, 2, 2).setProjectileColor("E3E3E3").setProjectileDamage(8);
	public static final AbilityAttribute BERO_CANNON = new AbilityAttribute("Bero Cannon").setAbilityCooldown(5).setProjectileModel(new ModelCube()).setProjectileSize(2, 2, 2).setProjectileColor("E3E3E3").setProjectileDamage(4);
	public static final AbilityAttribute BAKU_MUNCH = new AbilityAttribute("Baku Munch").setAbilityCooldown(5);
	
	public static final AbilityAttribute PHOENIX_HYBRID_POINT = new AbilityAttribute("Phoenix Hybrid Point").setAbilityCooldown(1).setAbilityDisplayName("Hybrid Point").setAbilityTexture("phoenixhybrid").setAbilityPassive(true);
	public static final AbilityAttribute PHOENIX_FULL_POINT = new AbilityAttribute("Phoenix Point").setAbilityTexture("phoenixfull").setAbilityCooldown(1).setAbilityPassive(true);
	public static final AbilityAttribute BLUE_FLAMES_OF_RESURRECTION = new AbilityAttribute("Blue Flames of Resurrection").setAbilityCooldown(20).addEffects(EffectType.USER, new PotionEffect(Potion.regeneration.id, 3 * 20, 4));
	public static final AbilityAttribute FLAME_OF_RESTORATION = new AbilityAttribute("Flame of Restoration").setAbilityCooldown(3).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute PHOENIX_GOEN = new AbilityAttribute("Phoenix Goen").setAbilityCooldown(10).setProjectileDamage(12);
	public static final AbilityAttribute TENSEI_NO_SOEN = new AbilityAttribute("Tensei no Soen").setAbilityCooldown(30).setAbilityCharges(5 * 20);
	
	public static final AbilityAttribute BISON_POWER_POINT = new AbilityAttribute("Bison Power Point").setAbilityCooldown(1).setAbilityDisplayName("Hybrid Point").setAbilityTexture("bisonhybrid").setAbilityPassive(true);
	public static final AbilityAttribute BISON_SPEED_POINT = new AbilityAttribute("Bison Speed Point").setAbilityCooldown(1).setAbilityDisplayName("Bison Point").setAbilityTexture("bisonfull").setAbilityPassive(true);	
	public static final AbilityAttribute FIDDLE_BANFF = new AbilityAttribute("Fiddle Banff").setAbilityCooldown(7);
	public static final AbilityAttribute KOKUTEI_CROSS = new AbilityAttribute("Kokutei Cross").setAbilityCooldown(7).setAbilityPassive().setAbilityPunch();
	
	public static final AbilityAttribute SAGARI_NO_RYUSEI = new AbilityAttribute("Sagari no Ryusei").setAbilityCooldown(20).setProjectileTicks(256).setProjectileModel(new ModelSphere()).setProjectileColor("51585B").setProjectileSize(50, 50, 50).setProjectileDamage(50).setProjectileExplosion(20, false).setProjectileCollisionSizes(2, 2, 2);
	public static final AbilityAttribute MOKO = new AbilityAttribute("Moko").setProjectileDamage(10).setAbilityCooldown(12).setProjectileModel(new ModelCube()).setProjectileSize(new double[] {0, 0, 0}).setProjectileMoveThroughBlocks(true);
	public static final AbilityAttribute ABARE_HIMATSURI = new AbilityAttribute("Abare Himatsuri").setAbilityCooldown(10).setAbilityPassive();
	public static final AbilityAttribute JURYOKU = new AbilityAttribute("Juryoku").setAbilityDisplayName("Jigoku Tabi").setAbilityCooldown(12).setAbilityPassive();
	
	public static final AbilityAttribute BLACK_WORLD = new AbilityAttribute("Black World").setAbilityCooldown(25).addEffects(EffectType.AOE, new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100), new PotionEffect(Potion.blindness.id, 200, 2)).setEffectRadius(20);
	public static final AbilityAttribute DARK_MATTER = new AbilityAttribute("Dark Matter").setAbilityCooldown(12).setProjectileModel(new ModelSphere()).setProjectileColor("000000").setProjectileSize(7, 7, 7);
	public static final AbilityAttribute KUROUZU = new AbilityAttribute("Kurouzu").setAbilityCooldown(10).setAbilityCharges(3 * 20);;
	public static final AbilityAttribute LIBERATION = new AbilityAttribute("Liberation").setAbilityCooldown(5);
	public static final AbilityAttribute BLACKHOLE = new AbilityAttribute("Black Hole").setAbilityCooldown(7);
	
	public static final AbilityAttribute TODOROKI = new AbilityAttribute("Todoroki").setAbilityCooldown(20).setProjectileModel(new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(2, 2, 4).setProjectileDamage(15).setAbilityRepeater(20, 3);
	
	public static final AbilityAttribute PERFUME_FEMUR = new AbilityAttribute("Perfume Femur").setAbilityCooldown(10).setAbilityPunch(10);
	public static final AbilityAttribute SLAVE_ARROW = new AbilityAttribute("Slave Arrow").setAbilityCooldown(10).setProjectileModel(new ModelArrow()).setProjectileColor("#FF69B4").setProjectileSize(1, 1, 2).setProjectileDamage(6).setAbilityRepeater().setAbilityCharges(7 * 20);
	public static final AbilityAttribute PISTOL_KISS = new AbilityAttribute("Pistol Kiss").setAbilityCooldown(5).setProjectileModel(new ModelHeart()).setProjectileSize(.5, .5, .5).setProjectileTexture("meromeromellow").setProjectileDamage(4).setModelOffsets(0, -0.5, 0).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 100, 5), new PotionEffect(Potion.digSlowdown.id, 100, 5));
	public static final AbilityAttribute MERO_MERO_MELLOW = new AbilityAttribute("Mero Mero Mellow").setAbilityCooldown(20).setProjectileModel(new ModelHeart()).setProjectileSize(3, 3, 3).setProjectileTexture("meromeromellow").setProjectileDamage(10).setModelOffsets(0, -1, 0).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 400, 100), new PotionEffect(Potion.digSlowdown.id, 400, 100)).setProjectileCollisionSizes(1.25, 1.25, 1.25);
	
	public static final AbilityAttribute SPARKLING_DAISY = new AbilityAttribute("Sparkling Daisy").setAbilityCooldown(12);
	public static final AbilityAttribute SPIRAL_HOLLOW = new AbilityAttribute("Spiral Hollow").setAbilityCooldown(10).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileColor("#F8F8FF").setProjectileSize(3, 3, 5).setProjectileTicks(3).setProjectilePhysical();
	public static final AbilityAttribute ATOMIC_SPURT = new AbilityAttribute("Atomic Spurt").setAbilityCooldown(25).setAbilityPassive();
	public static final AbilityAttribute SPAR_CLAW = new AbilityAttribute("Spar Claw").setAbilityCooldown(5).setAbilityPassive(true).setAbilityPunch(10);
	public static final AbilityAttribute SPIDER = new AbilityAttribute("Spider").addEffects(EffectType.USER, new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100), new PotionEffect(Potion.digSlowdown.id, 30, 5), new PotionEffect(Potion.jump.id, 30, -100)).setAbilityPassive();
	
	public static final AbilityAttribute NEGATIVE_HOLLOW = new AbilityAttribute("Negative Hollow").setAbilityCooldown(6).setProjectileModel(new ModelNegativeHollow()).setProjectileTexture("negativehollow").setProjectileAlpha(150).setProjectileSize(2, 2, 2).setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.confusion.id, 200, 1), new PotionEffect(Potion.moveSlowdown.id, 200, 1));
	public static final AbilityAttribute MINI_HOLLOW = new AbilityAttribute("Mini Hollow").setAbilityCooldown(3).setProjectileModel(new ModelMiniHollow()).setProjectileSize(0.4, 0.4, 0.4).setProjectileColor("#F8F8FF").setProjectileAlpha(150).setProjectileDamage(2).setProjectileExplosion(2, false).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.confusion.id, 120, 0), new PotionEffect(Potion.moveSlowdown.id, 120, 0)).setAbilityRepeater();
	public static final AbilityAttribute TOKU_HOLLOW = new AbilityAttribute("Toku Hollow").setAbilityCooldown(10).setProjectileModel(new ModelTokuHollow()).setProjectileTexture("tokuhollow").setProjectileAlpha(150).setProjectileSize(4, 4, 4).setProjectileDamage(10).setProjectileExplosion(7, false).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.confusion.id, 400, 1), new PotionEffect(Potion.moveSlowdown.id, 400, 1)).setProjectileCollisionSizes(1.5, 1.5, 1.5);
	
	public static final AbilityAttribute BLACK_KNIGHT = new AbilityAttribute("Black Knight").setAbilityCooldown(15).setAbilityPassive();
	public static final AbilityAttribute KUMO_NO_SUGAKI = new AbilityAttribute("Kumo no Sugaki").setAbilityCooldown(10).addEffects(EffectType.USER,new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100), new PotionEffect(Potion.digSlowdown.id, 30, 5), new PotionEffect(Potion.jump.id, 30, -100)).setAbilityPassive();;
	public static final AbilityAttribute TORIKAGO = new AbilityAttribute("Torikago").setAbilityCooldown(2).setAbilityPassive(true);
	public static final AbilityAttribute TAMAITO = new AbilityAttribute("Tamaito").setAbilityCooldown(5).setProjectileDamage(6).setProjectileModel(new ModelCube()).setProjectileSize(.5, .5, 1).setProjectileColor("#dee1e5");
	public static final AbilityAttribute OVERHEAT = new AbilityAttribute("Overheat").setAbilityCooldown(8).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileSize(1, 1, 5).setProjectileExplosion(3, false).setProjectileColor("#f77c25");
	public static final AbilityAttribute SORA_NO_MICHI = new AbilityAttribute("Sora no Michi").setAbilityCooldown(1);
	public static final AbilityAttribute PARASITE = new AbilityAttribute("Parasite").setAbilityCooldown(5);
	
	public static final AbilityAttribute BARRIERBILITY_STAIRS = new AbilityAttribute("Barrierbility Stairs").setProjectileTicks(60).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileMoveThroughBlocks(true).setAbilityPassive();
	public static final AbilityAttribute BARI_BARI_NO_PISTOL = new AbilityAttribute("Bari Bari no Pistol").setAbilityCooldown(5).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute BARRIER_BALL = new AbilityAttribute("Barrier Ball").setAbilityCooldown(0.5).setAbilityPassive();
	public static final AbilityAttribute BARRIER_CRASH = new AbilityAttribute("Barrier Crash").setAbilityCooldown(5).setProjectileTicks(60).setProjectileModel(new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(9, 9, .3).setProjectileDamage(15).setProjectileCollisionSizes(1.5, 2, 1.5);
	public static final AbilityAttribute BARRIER = new AbilityAttribute("Barrier").setAbilityPassive();
	
	public static final AbilityAttribute YUKI_GAKI = new AbilityAttribute("Yuki Gaki").setAbilityCooldown(8);
	public static final AbilityAttribute FUBUKI = new AbilityAttribute("Fubuki").setAbilityCooldown(12);
	public static final AbilityAttribute TABIRA_YUKI = new AbilityAttribute("Tabira Yuki").setAbilityPassive(true);
//	public static final AbilityAttribute MANNEN_YUKI = new AbilityAttribute("Mannen Yuki");
	public static final AbilityAttribute KAMAKURA_JUSSOSHI = new AbilityAttribute("Kamakura Jussoshi").setAbilityCooldown(18);
	public static final AbilityAttribute YUKI_RABI = new AbilityAttribute("Yuki Rabi").setAbilityCooldown(2).setProjectileColor(Color.WHITE).setProjectileDamage(5).setProjectileModel(new ModelYukiRabi()).setProjectileTexture("yukirabi").setProjectileSize(1, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 50, 1)).setAbilityRepeater(2, 2);
	public static final AbilityAttribute KAMAKURA = new AbilityAttribute("Kamakura").setAbilityCooldown(6);
	
//	public static final AbilityAttribute SHINOKUNI = new AbilityAttribute("Shinokuni");
	public static final AbilityAttribute KARAKUNI = new AbilityAttribute("Karakuni").setAbilityCooldown(20);
	public static final AbilityAttribute BLUE_SWORD = new AbilityAttribute("Blue Sword").setAbilityPassive(true);
	public static final AbilityAttribute GASTANET = new AbilityAttribute("Gastanet").setAbilityCooldown(6).setAbilityExplosion(5, false);
	public static final AbilityAttribute GASTILLE = new AbilityAttribute("Gastille").setAbilityCooldown(7).setProjectileSpeed(2).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileColor("324AB2").setProjectileSize(1, 1, 2).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 200, 1)).setAbilityRepeater().setProjectileExplosion(1, false);
	public static final AbilityAttribute GAS_ROBE = new AbilityAttribute("Gas Robe").setAbilityCooldown(6).setProjectileSpeed(2).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setAbilityRepeater();
	
	public static final AbilityAttribute DOKU_GUMO = new AbilityAttribute("Doku Gumo").setAbilityCooldown(30).setAbilityPassive();
	public static final AbilityAttribute DOKU_FUGU = new AbilityAttribute("Doku Fugu").setAbilityCooldown(8).setProjectileDamage(15).setProjectileModel(new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 240, 1)).setAbilityRepeater(10, 3);
	public static final AbilityAttribute VENOM_DEMON = new AbilityAttribute("Venom Demon").setAbilityCooldown(40).setAbilityPassive(true);
	public static final AbilityAttribute VENOM_ROAD = new AbilityAttribute("Venom Road").setAbilityCooldown(8).setProjectileDamage(20).setProjectileModel(new ModelHydra()).setProjectileTexture("hydra").setProjectileSize(2, 2, 2.4).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1));
	public static final AbilityAttribute CHLORO_BALL = new AbilityAttribute("Chloro Ball").setAbilityCooldown(6).setProjectileDamage(10).setProjectileModel(new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 240, 1));
	public static final AbilityAttribute HYDRA = new AbilityAttribute("Hydra").setAbilityCooldown(8).setProjectileDamage(30).setProjectileModel(new ModelHydra()).setProjectileTexture("hydra").setProjectileSize(2, 2, 2.4).setProjectileTicks(10).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 500, 1));
	
	public static final AbilityAttribute CANDLE_LOCK = new AbilityAttribute("Candle Lock").setAbilityCooldown(15).setProjectileDamage(6).setProjectileModel(new ModelCube()).setProjectileColor("A2ADD0").setProjectileSize(.5, .5, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 400, 100), new PotionEffect(Potion.digSlowdown.id, 400, 100), new PotionEffect(Potion.jump.id, 400, -1));
	public static final AbilityAttribute CANDLE_HOUSE = new AbilityAttribute("Candle House").setAbilityCooldown(30);
	public static final AbilityAttribute CANDLE_WALL = new AbilityAttribute("Candle Wall").setAbilityCooldown(4);
	public static final AbilityAttribute DORU_DORU_ARTS_KEN = new AbilityAttribute("Doru Doru Arts : Ken").setAbilityPassive(true);
	public static final AbilityAttribute DORU_DORU_ARTS_MORI = new AbilityAttribute("Doru Doru Arts : Mori").setAbilityCooldown(3).setProjectileDamage(15).setProjectileModel(new ModelSpear()).setProjectileTexture("dorudoruartsmori").setProjectileSize(2, 2, 2).setModelOffsets(0, 1, 0);
	
	public static final AbilityAttribute BAKURETSU_KAZAN = new AbilityAttribute("Bakuretsu Kazan").setAbilityCooldown(15);
	public static final AbilityAttribute RYUSEI_KAZAN = new AbilityAttribute("Ryusei Kazan").setAbilityCooldown(12).setProjectileDamage(10).setAbilityRepeater();
	public static final AbilityAttribute MEIGO = new AbilityAttribute("Meigo").setAbilityCooldown(10).setProjectileDamage(40).setProjectileModel(new ModelMeigo()).setProjectileTexture("meigo").setProjectileSize(4, 4, 4).setModelOffsets(0, 1.2, 0).setProjectileTicks(3);
	public static final AbilityAttribute DAI_FUNKA = new AbilityAttribute("Dai Funka").setAbilityCooldown(8).setProjectileDamage(20).setProjectileModel(new ModelFist()).setProjectileTexture("daifunka").setProjectileSize(4, 4, 4).setModelOffsets(0, 1, 0);
	
	public static final AbilityAttribute DESERT_GIRASOLE = new AbilityAttribute("Desert Girasole").setAbilityCooldown(25).setAbilityCharges(100);
	public static final AbilityAttribute DESERT_ENCIERRO = new AbilityAttribute("Desert Encierro").setAbilityCooldown(10).setAbilityPunch().addEffects(EffectType.HIT, new PotionEffect(Potion.hunger.id, 100, 1), new PotionEffect(Potion.weakness.id, 100, 1), new PotionEffect(Potion.moveSlowdown.id, 100, 1), new PotionEffect(Potion.digSlowdown.id, 100, 1));
	public static final AbilityAttribute GROUND_DEATH = new AbilityAttribute("Ground Death").setAbilityCooldown(15);
	public static final AbilityAttribute BARJAN = new AbilityAttribute("Barjan").setAbilityCooldown(5).setProjectileDamage(15).setProjectileModel(new ModelCube()).setProjectileColor("967117").setProjectileSize(6, 0.4, 1.5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.hunger.id, 500, 1)).setProjectileMoveThroughBlocks(true).setProjectileCollisionSizes(1.25, 0.3, 1.25);
	public static final AbilityAttribute SABLES = new AbilityAttribute("Sables").setAbilityCooldown(3).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute DESERT_SPADA = new AbilityAttribute("Desert Spada").setAbilityCooldown(10);
	
	public static final AbilityAttribute TSUNOTOKAGE = new AbilityAttribute("Tsuno-Tokage").setAbilityCooldown(10);
//	public static final AbilityAttribute SHADOWSASGARD = new AbilityAttribute("Shadow's Asgard").setAbilityCooldown(400).addTasks(Tasks.shadowsasgard);
	public static final AbilityAttribute BLACK_BOX = new AbilityAttribute("Black Box").setAbilityCooldown(6).setProjectileModel(new ModelCube()).setProjectileColor(Color.black).setProjectileSize(2, 2, 2);
	public static final AbilityAttribute KAGEMUSHA = new AbilityAttribute("Kagemusha").setAbilityCooldown(5);
	public static final AbilityAttribute DOPPELMAN = new AbilityAttribute("Doppelman").setAbilityCooldown(15).setAbilityPassive();
	public static final AbilityAttribute BRICK_BAT = new AbilityAttribute("Brick Bat").setAbilityCooldown(4).setProjectileDamage(5).setProjectileModel(new ModelBrickBat()).setProjectileSize(1, 1, 1).setModelOffsets(0, 0.5, 0).setProjectileTexture("brickbat").setAbilityRepeater(3, 2);
	
	public static final AbilityAttribute GEKISHIN = new AbilityAttribute("Gekishin").setAbilityCooldown(15).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute SHIMA_YURASHI = new AbilityAttribute("Shima Yurashi").setAbilityCooldown(15).setProjectileDamage(20).setProjectileExplosion(5, false).setProjectileMoveThroughBlocks(true);
	public static final AbilityAttribute KABUTOWARI = new AbilityAttribute("Kabutowari").setAbilityCooldown(7).setAbilityExplosion(5, false);
	public static final AbilityAttribute KAISHIN = new AbilityAttribute("Kaishin").setAbilityCooldown(7).setProjectileDamage(50).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileExplosion(3, false, false);
	
	public static final AbilityAttribute KICK_BOMB = new AbilityAttribute("Kick Bomb").setAbilityCooldown(7).setAbilityExplosion(7, false);
	public static final AbilityAttribute NOSE_FANCY_CANNON = new AbilityAttribute("Nose Fancy Cannon").setAbilityCooldown(3).setProjectileModel(new ModelCube()).setProjectileColor("3D2B1F").setProjectileSize(.4, .4, .8).setProjectileDamage(10).setProjectileExplosion(3, false);
	
	public static final AbilityAttribute URSUS_SHOCK = new AbilityAttribute("Ursus Shock").setAbilityCooldown(15).setProjectileModel(new ModelPaw()).setProjectileColor("F8F8FF").setProjectileAlpha(80).setProjectileSize(3.5, 3.5, 3.5).setProjectileDamage(50).setProjectileExplosion(8, false, true).setAbilityCharges(40).setProjectileCollisionSizes(1.5, 1.5, 1.5);
	public static final AbilityAttribute PAD_HO = new AbilityAttribute("Pad Ho").setAbilityCooldown(8).setProjectileModel(new ModelPaw()).setProjectileColor("F8F8FF").setProjectileAlpha(80).setProjectileSize(1, 1, 1).setProjectileDamage(10).setProjectileExplosion(1, false, true);
	public static final AbilityAttribute TSUPPARI_PAD_HO = new AbilityAttribute("Tsuppari Pad Ho").setAbilityCooldown(10).setProjectileDamage(15).setProjectileExplosion(1, false, true).setAbilityRepeater(5, 7);
	public static final AbilityAttribute HANPATSU = new AbilityAttribute("Hanpatsu").setAbilityCooldown(4).setAbilityPassive().setAbilityPunch();

	public static final AbilityAttribute WHITE_STRIKE = new AbilityAttribute("White Strike").setAbilityCooldown(35).addEffects(EffectType.AOE, new PotionEffect(Potion.moveSlowdown.id, 300, 1), new PotionEffect(Potion.digSlowdown.id, 300, 1), new PotionEffect(Potion.jump.id, 300, -10)).setEffectRadius(30);
	public static final AbilityAttribute WHITE_LAUNCHER = new AbilityAttribute("White Launcher").setAbilityCooldown(5).setAbilityCharges(20);
	public static final AbilityAttribute WHITE_SNAKE = new AbilityAttribute("White Snake").setAbilityCooldown(5).setProjectileTicks(120).setProjectileModel(new ModelCube()).setProjectileSpeed(5).setProjectileSize(0, 0, 0).setProjectileDamage(30).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.poison.id, 120, 0));
	public static final AbilityAttribute WHITE_OUT = new AbilityAttribute("White Out").setAbilityCooldown(4).setProjectileModel(new ModelCube()).setProjectileSpeed(5).setProjectileSize(0, 0, 0).setProjectileDamage(5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 240, 1), new PotionEffect(Potion.digSlowdown.id, 240, 1), new PotionEffect(Potion.jump.id, 240, -10));
	
	public static final AbilityAttribute SANGO = new AbilityAttribute("Sango").setAbilityCooldown(10).setProjectileTicks(128).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileColor("7CB9E8").setProjectileDamage(15).setAbilityRepeater();
	public static final AbilityAttribute KARI = new AbilityAttribute("Kari").setAbilityCharges(7 * 20).setAbilityCooldown(15).setAbilityExplosion(10, false, false);
	public static final AbilityAttribute RAIGO = new AbilityAttribute("Raigo").setAbilityCooldown(45).setProjectileTicks(256).setProjectileModel(new ModelSphere()).setProjectileColor("5D8AA8").setProjectileSize(50, 50, 50).setProjectileDamage(120).setProjectileExplosion(30, false).setProjectileCollisionSizes(2);
	public static final AbilityAttribute VOLT_VARI = new AbilityAttribute("Volt Vari").setAbilityCooldown(3).setAbilityCharges(10 * 20, true);
	public static final AbilityAttribute EL_THOR = new AbilityAttribute("El Thor").setAbilityCooldown(8).setAbilityCharges(6 * 20);
	public static final AbilityAttribute SPARK_STEP = new AbilityAttribute("Spark Step").setAbilityCooldown(3);
	
	public static final AbilityAttribute INJECTION_SHOT = new AbilityAttribute("Injection Shot").setAbilityCooldown(15);
	public static final AbilityAttribute SHAMBLES = new AbilityAttribute("Shambles").setAbilityCooldown(8);
	public static final AbilityAttribute TAKT = new AbilityAttribute("Takt").setAbilityCooldown(10).setAbilityPassive();
	public static final AbilityAttribute GAMMA_KNIFE = new AbilityAttribute("Gamma Knife").setAbilityCooldown(30).setProjectileTicks(20).setProjectileModel(new ModelCube()).setProjectileColor("00AB66").setProjectileDamage(100).setProjectileSize(1, 1, 5);
	public static final AbilityAttribute MES = new AbilityAttribute("Mes").setAbilityCooldown(5).setAbilityPassive().setAbilityPunch(1); 
	public static final AbilityAttribute COUNTER_SHOCK = new AbilityAttribute("Counter Shock").setAbilityCooldown(10).setAbilityPassive().setAbilityPunch(40).setAbilityExplosion(1, false);
	public static final AbilityAttribute ROOM = new AbilityAttribute("Room").setAbilityCooldown(1).setAbilityPassive(true);
	
	public static final AbilityAttribute NORO_NORO_BEAM = new AbilityAttribute("Noro Noro Beam").setAbilityCooldown(5).setProjectileTicks(10).setProjectileModel(new ModelNoroNoroBeam()).setProjectileTexture("noronorobeam").setProjectileSize(5, 5, 5).setProjectileSpeed(1.6F).setProjectileCollisionSizes(1);
	public static final AbilityAttribute KYUBI_RUSH = new AbilityAttribute("Kyubi Rush").setAbilityCooldown(7).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute NORO_NORO_BEAM_SWORD = new AbilityAttribute("Noro Noro Beam Sword").setAbilityPassive(true);

	public static final AbilityAttribute AIR_DOOR = new AbilityAttribute("Air Door").setAbilityPassive(true).setAbilityCooldown(40);
	public static final AbilityAttribute DOOR = new AbilityAttribute("Door").setAbilityCooldown(8);

	public static final AbilityAttribute SUKE_PUNCH = new AbilityAttribute("Suke Punch").setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute SHISHA_NO_TE = new AbilityAttribute("Shisha no Te").setAbilityCooldown(3).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileExplosion(3, false);
	public static final AbilityAttribute SKATTING = new AbilityAttribute("Skatting").addEffects(EffectType.USER, new PotionEffect(Potion.invisibility.id, 30, 5)).setAbilityPassive();  	
	 
	public static final AbilityAttribute GEAR_SECOND = new AbilityAttribute("Gear Second").setAbilityCooldown(60).setAbilityPassive();
	public static final AbilityAttribute GEAR_THIRD = new AbilityAttribute("Gear Third").setAbilityCooldown(90).setAbilityPassive();
	public static final AbilityAttribute GEAR_FOURTH = new AbilityAttribute("Gear Fourth").setAbilityCooldown(300).setAbilityPassive();
	public static final AbilityAttribute GOMU_GOMU_NO_ROCKET = new AbilityAttribute("Gomu Gomu no Rocket").setProjectileModel(new ModelFist()).setProjectileTexture("gomugomunopistol").setProjectileSize(3, 3, 3).setModelOffsets(0, 1, 0).setProjectileDamage(6).setAbilityCooldown(8).setProjectilePhysical().setProjectileSpeed(2.5F);
	public static final AbilityAttribute GOMU_GOMU_NO_BAZOOKA = new AbilityAttribute("Gomu Gomu no Bazooka").setAbilityCharges(10);
	public static final AbilityAttribute GOMU_GOMU_NO_GATLING = new AbilityAttribute("Gomu Gomu no Gatling").setProjectileTicks(10);
	public static final AbilityAttribute GOMU_GOMU_NO_PISTOL = new AbilityAttribute("Gomu Gomu no Pistol");
	
	public static final AbilityAttribute FLASH = new AbilityAttribute("Flash").setAbilityCooldown(5).addEffects(EffectType.AOE, new PotionEffect(Potion.blindness.id, 7 * 20, 3), new PotionEffect(Potion.moveSlowdown.id, 7 * 20, 1)).setEffectRadius(10);
	public static final AbilityAttribute AMA_NO_MURAKUMO = new AbilityAttribute("Ama no Murakumo").setAbilityPassive(true);
	public static final AbilityAttribute AMATERASU = new AbilityAttribute("Amaterasu").setAbilityCooldown(15).setProjectileTicks(150).setProjectileModel(new ModelCube()).setProjectileSize(1, 1, 1).setProjectileColor("FFFF00").setProjectileSpeed(5).setProjectileDamage(35).setProjectileExplosion(6, false).setAbilityCharges(2 * 20);
	public static final AbilityAttribute YASAKANI_NO_MAGATAMA = new AbilityAttribute("Yasakani no Magatama").setAbilityCooldown(2.5).setProjectileModel(new ModelSphere()).setProjectileSize(.5, .5, .5).setProjectileColor("FFFF00").setAbilityRepeater(2).setProjectileDamage(2).setProjectileExplosion(1, false).setProjectileSpeed(5);
	public static final AbilityAttribute YATA_NO_KAGAMI = new AbilityAttribute("Yata no Kagami").setAbilityCooldown(4);
	 
	public static final AbilityAttribute SPRING_DEATH_KNOCK = new AbilityAttribute("Spring Death Knock").setAbilityCooldown(6).setProjectileDamage(20).setProjectileModel(new ModelFist()).setProjectileTexture("springdeathknock").setModelOffsets(-1, 1.5, 0).setProjectileSize(7, 5, 5).setProjectileTicks(3).setProjectilePhysical();
	public static final AbilityAttribute SPRING_SNIPE = new AbilityAttribute("Spring Snipe").setAbilityCooldown(5).setAbilityCharges(20);
	public static final AbilityAttribute SPRING_HOPPER = new AbilityAttribute("Spring Hopper").setAbilityCooldown(0.6).setAbilityCharges(10);

	public static final AbilityAttribute ICE_TIME_CAPSULE = new AbilityAttribute("Ice Time Capsule").setAbilityCooldown(15);
	public static final AbilityAttribute ICE_SABER = new AbilityAttribute("Ice Saber").setAbilityPassive(true);
	public static final AbilityAttribute ICE_BALL = new AbilityAttribute("Ice Ball").setAbilityCooldown(6).setProjectileDamage(5).setProjectileModel(new ModelSphere()).setProjectileColor("00FFFF").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 100, 0), new PotionEffect(Potion.digSlowdown.id, 100, 0));
	public static final AbilityAttribute ICE_AGE = new AbilityAttribute("Ice Age").setAbilityCooldown(15).addEffects(EffectType.AOE, new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100)).setEffectRadius(20);
	public static final AbilityAttribute ICE_BLOCK_PARTISAN = new AbilityAttribute("Ice Block : Partisan").setAbilityCooldown(7).setProjectileDamage(10).setProjectileModel(new ModelTrident()).setProjectileTexture("iceblockpartisan").setProjectileSize(1.5, 1.5, 1.5).setModelOffsets(0, 1.0, 0).setAbilityRepeater().addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 100, 0), new PotionEffect(Potion.digSlowdown.id, 100, 0));
	public static final AbilityAttribute ICE_BLOCK_PHEASANT = new AbilityAttribute("Ice Block : Pheasant").setAbilityCooldown(20).setProjectileDamage(45).setProjectileModel(new ModelPheasant()).setProjectileTexture("iceblockpheasant").setProjectileSize(5, 5, 5).setModelOffsets(0, 2.5, 0).addEffects(EffectType.PROJECTILE, new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100)).setProjectileCollisionSizes(1.75, 1.5, 1.75);
	
	public static final AbilityAttribute ENJOMO  = new AbilityAttribute("Enjomo").setAbilityCooldown(10);
	public static final AbilityAttribute JUJIKA = new AbilityAttribute("Jujika").setAbilityCooldown(6).setProjectileDamage(5).setProjectileModel(new ModelSphere()).setProjectileColor("FF0000").setProjectileSize(.2, .2, .2);
	public static final AbilityAttribute HIDARUMA = new AbilityAttribute("Hidaruma").setAbilityCooldown(6).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0);
	public static final AbilityAttribute DAI_ENKAI_ENTEI = new AbilityAttribute("Dai Enkai : Entei").setAbilityCooldown(25).setProjectileModel(new ModelSphere()).setProjectileDamage(45).setProjectileColor("FF0000").setProjectileSize(9, 9, 9).setProjectileExplosion(7).setAbilityCharges(4 * 20).setProjectileCollisionSizes(2);
	public static final AbilityAttribute HIGAN = new AbilityAttribute("Higan").setAbilityCooldown(4).setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileColor("FF0000").setProjectileSize(.3, .3, .3).setAbilityRepeater(4);
	public static final AbilityAttribute HIKEN = new AbilityAttribute("Hiken").setAbilityCooldown(8).setProjectileModel(new ModelFist()).setProjectileTexture("hiken").setModelOffsets(0, 0.5, 0).setProjectileDamage(20).setProjectileSize(1.5, 1.5, 1.5).setProjectileExplosion(2);

	public static final AbilityAttribute GREAT_CAGE = new AbilityAttribute("Great Cage").setAbilityCooldown(20);
	public static final AbilityAttribute PRISON_BREAK = new AbilityAttribute("Prison Break").setAbilityCooldown(3).setAbilityPassive();
	public static final AbilityAttribute AWASE_BAORI = new AbilityAttribute("Awase Baori").setAbilityCooldown(12).setProjectileModel(new ModelSphere()).setProjectileColor("000000").setProjectileSize(7, 7, 7);
	public static final AbilityAttribute BIND = new AbilityAttribute("Bind").setAbilityCooldown(10).setAbilityPassive().setAbilityPunch();

	public static final AbilityAttribute SORU = new AbilityAttribute("Soru").addEffects(EffectType.USER, new PotionEffect(Potion.moveSpeed.id, 30, 6)).setAbilityPassive();
	public static final AbilityAttribute TEKKAI = new AbilityAttribute("Tekkai").setAbilityCooldown(10).addEffects(EffectType.USER, new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100), new PotionEffect(Potion.digSlowdown.id, 30, 5), new PotionEffect(Potion.jump.id, 30, -100)).setAbilityPassive();
	public static final AbilityAttribute GEPPO = new AbilityAttribute("Geppo").setAbilityCooldown(0.9);
	public static final AbilityAttribute RANKYAKU = new AbilityAttribute("Rankyaku").setAbilityCooldown(9).setProjectileTicks(100).setProjectileModel(new ModelCube()).setProjectileSize(6, 0.4, 1.5).setProjectileColor("69E3FF").setProjectileDamage(20).setProjectileExplosion(2, false).setProjectileCollisionSizes(1.5, 0.3, 1.5).setProjectileMoveThroughBlocks(true);
	public static final AbilityAttribute SHIGAN = new AbilityAttribute("Shigan").setAbilityCooldown(5).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute KAMIE = new AbilityAttribute("Kamie").setAbilityCooldown(10).addEffects(EffectType.USER, new PotionEffect(Potion.resistance.id, 20, 100)).setAbilityPassive();

	public static final AbilityAttribute HOT_BOILING_SPECIAL = new AbilityAttribute("Hot Boiling Special").setAbilityPassive().setAbilityPunch(10).setAbilityCooldown(7);
	public static final AbilityAttribute EVAPORATE = new AbilityAttribute("Evaporate").setAbilityCooldown(15);

	public static final AbilityAttribute WEIGHTLESS = new AbilityAttribute("Weightless").setAbilityPassive(true);
	public static final AbilityAttribute KICK_OFF_JUMP = new AbilityAttribute("Kick Off Jump").setAbilityPassive().setAbilityCooldown(4);
	public static final AbilityAttribute HEAVY_PUNCH = new AbilityAttribute("Heavy Punch").setAbilityCooldown(20).setAbilityPassive().setAbilityPunch(20);
	public static final AbilityAttribute KILO_PRESS = new AbilityAttribute("Kilo Press").setAbilityCooldown(10).setAbilityPassive();

	public static final AbilityAttribute RUST_TOUCH = new AbilityAttribute("Rust Touch").setAbilityCooldown(19).setAbilityPunch().setAbilityPassive();
	
	public static final AbilityAttribute FAILED_EXPERIMENT = new AbilityAttribute("Failed Experiment").setAbilityCooldown(7).setAbilityCharges(2 * 20);
	public static final AbilityAttribute MEDIC_BAG_EXPLOSION = new AbilityAttribute("Medic Bag Explosion").setAbilityCooldown(30);
	public static final AbilityAttribute FIRST_AID = new AbilityAttribute("First Aid").setAbilityCooldown(10).setAbilityPunch();
	
	public static final AbilityAttribute WEATHER_EGG = new AbilityAttribute("Weather Egg").setAbilityCooldown(10).setProjectileModel(new ModelSphere()).setProjectileColor("#BEBEBE").setProjectileAlpha(150).setProjectileSize(1.5, 1.5, 1.5);
	public static final AbilityAttribute GUST_SWORD = new AbilityAttribute("Gust Sword").setAbilityCooldown(8).setProjectileTicks(5).setProjectileSize(.01, .01, .01).setAbilityRepeater(3).setProjectileDamage(2).setProjectileSpeed(5);
	public static final AbilityAttribute THUNDER_BALL = new AbilityAttribute("Thunder Ball").setAbilityCooldown(5).setProjectileModel(new ModelSphere()).setProjectileColor("FFFF00").setProjectileAlpha(150).setProjectileSize(1.5, 1.5, 1.5).setProjectileTicks(300);
	public static final AbilityAttribute COOL_BALL = new AbilityAttribute("Cool Ball").setAbilityCooldown(5).setProjectileModel(new ModelSphere()).setProjectileColor("0000FF").setProjectileAlpha(150).setProjectileSize(1.5, 1.5, 1.5).setProjectileTicks(300);
	public static final AbilityAttribute HEAT_BALL = new AbilityAttribute("Heat Ball").setAbilityCooldown(5).setProjectileModel(new ModelSphere()).setProjectileColor("FF0000").setProjectileAlpha(150).setProjectileSize(1.5, 1.5, 1.5).setProjectileTicks(300);
	
	public static final AbilityAttribute UCHIMIZU = new AbilityAttribute("Uchimizu").setAbilityCooldown(5).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(.5, .5, 1).setProjectileDamage(5).setAbilityRepeater(3, 2);
	public static final AbilityAttribute MURASAME = new AbilityAttribute("Murasame").setAbilityCooldown(8).setProjectileModel(new ModelShark()).setProjectileTexture("murasame").setProjectileSize(.8, .8, 1.2).setProjectileDamage(25);
	public static final AbilityAttribute KACHIAGE_HAISOKU = new AbilityAttribute("Kachiage Haisoku").setAbilityCooldown(15).setAbilityPassive().setAbilityPunch();
	public static final AbilityAttribute SAMEHADA_SHOTEI = new AbilityAttribute("Samehada Shotei").setAbilityCooldown(10).addEffects(EffectType.USER, new PotionEffect(Potion.resistance.id, 10, 120), new PotionEffect(Potion.moveSlowdown.id, 10, 120), new PotionEffect(Potion.jump.id, 30, -100)).setAbilityPassive();	
	public static final AbilityAttribute KARAKUSAGAWARA_SEIKEN = new AbilityAttribute("Karakusagawara Seiken").setAbilityCooldown(25);
	
	public static final AbilityAttribute KAEN_BOSHI = new AbilityAttribute("Kaen Boshi").setAbilityCooldown(10).setAbilityPassive().setProjectileModel(new ModelSphere()).setProjectileDamage(8).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#D3D3D3");
	public static final AbilityAttribute KEMURI_BOSHI = new AbilityAttribute("Kemuri Boshi").setAbilityCooldown(10).setAbilityPassive().setProjectileModel(new ModelSphere()).setProjectileDamage(6).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#8741A8");
	public static final AbilityAttribute RENPATSU_NAMARI_BOSHI = new AbilityAttribute("Renpatsu Namari Boshi").setAbilityCooldown(15).setAbilityPassive().setProjectileModel(new ModelSphere()).setProjectileDamage(6).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileExplosion(1, false).setProjectileColor("#D3D3D3").setAbilityRepeater(10, 3);
	public static final AbilityAttribute SAKURETSU_SABOTEN_BOSHI = new AbilityAttribute("Sakuretsu Saboten Boshi").setAbilityCooldown(12).setAbilityPassive().setProjectileModel(new ModelSphere()).setProjectileDamage(12).setProjectileExplosion(2, false, false).setProjectileSize(.5, .5, .5).setProjectileTicks(100).setProjectileColor("#D3D3D3");
	
	public static final AbilityAttribute SHI_SHISHI_SONSON = new AbilityAttribute("Shi Shishi Sonson").setAbilityCooldown(7);
	public static final AbilityAttribute SANBYAKUROKUJU_POUND_HO = new AbilityAttribute("Sanbyakurokuju Pound Ho").setAbilityCooldown(5).setProjectileTicks(100).setProjectileModel(new ModelCube()).setProjectileSize(6, 0.4, 1.5).setProjectileColor("bbf7b4").setProjectileDamage(18).setProjectileExplosion(3, false);
	public static final AbilityAttribute YAKKODORI = new AbilityAttribute("Yakkodori").setAbilityCooldown(3).setAbilityCooldown(5).setProjectileTicks(20).setProjectileModel(new ModelCube()).setProjectileSize(0.4, 6, 0.4).setProjectileColor("bbf7b4").setProjectileDamage(10).setProjectileExplosion(1, false).setProjectileMoveThroughBlocks(true);
	public static final AbilityAttribute O_TATSUMAKI = new AbilityAttribute("O Tatsumaki").setAbilityCooldown(7);

	public static final AbilityAttribute FRESH_FIRE = new AbilityAttribute("Fresh Fire").setAbilityCooldown(1.5).setProjectileTicks(7).setProjectileSize(.01, .01, .01).setProjectileDamage(1);
	public static final AbilityAttribute COLA_OVERDRIVE = new AbilityAttribute("Cola Overdrive").setAbilityCooldown(7).addEffects(EffectType.USER, new PotionEffect(Potion.moveSpeed.id, 200, 0), new PotionEffect(Potion.damageBoost.id, 200, 1));
	public static final AbilityAttribute RADICAL_BEAM = new AbilityAttribute("Radical Beam").setAbilityCooldown(10).setProjectileModel(new ModelCube()).setProjectileColor("FFFF00").setProjectileSize(.5, .5, 1).setProjectileDamage(25).setProjectileExplosion(4, false);
	public static final AbilityAttribute STRONG_RIGHT = new AbilityAttribute("Strong Right").setAbilityCooldown(2.5).setProjectileModel(new ModelCube()).setProjectileColor("F5DEB3").setProjectileTicks(5).setProjectileSize(1, 1, 1.5).setProjectileDamage(20);
	public static final AbilityAttribute COUP_DE_VENT = new AbilityAttribute("Coup de Vent").setAbilityCooldown(10).setProjectileTicks(7).setProjectileSize(.01, .01, .01).setProjectileDamage(10).setAbilityCharges(30);
	
	public static final AbilityAttribute KENBUNSHOKU_HAKI_AURA = new AbilityAttribute("Kenbunshoku Haki: Aura").setAbilityPassive(true);
	public static final AbilityAttribute KENBUNSHOKU_HAKI_FUTURE_SIGHT = new AbilityAttribute("Kenbunshoku Haki: Future Sight").setAbilityPassive(true).setAbilityCooldown(60);
	public static final AbilityAttribute BUSOSHOKU_HAKI_HARDENING = new AbilityAttribute("Busoshoku Haki: Hardening").setAbilityPassive(true);
	public static final AbilityAttribute BUSOSHOKU_HAKI_FULL_BODY_HARDENING = new AbilityAttribute("Busoshoku Haki: Full-Body Hardening").setAbilityPassive(true);
	public static final AbilityAttribute BUSOSHOKU_HAKI_IMBUING = new AbilityAttribute("Busoshoku Haki: Imbuing").setAbilityPassive(true);
	public static final AbilityAttribute HAOSHOKU_HAKI = new AbilityAttribute("Haoshoku Haki").setAbilityCharges(3 * 20).setAbilityCooldown(90);
}
