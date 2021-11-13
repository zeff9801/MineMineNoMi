package xyz.pixelatedw.MineMineNoMi3.lists;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.DimensionManager;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.NewBlock;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockAbilityProtection;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockAbilityProtectionArea;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockBarrier;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockCannon;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockCustomBars;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockDarkness;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockDemonPoison;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockEnchantmentTable2;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockKage;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockOpe;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockOpeMid;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockPoison;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockPoneglyph;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockSakeFeast;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockSkyblock;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockStringMid;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockStringWall;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockSunaSand;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockAxeDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockBreathDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockEisenDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockFlameDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockFlashDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockImpactDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockMilkyDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.dials.BlockRejectDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityAbilityProtection;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityAxeDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityBreathDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCannon;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityEisenDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityFlameDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityFlashDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityImpactDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityMilkyDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityOpe;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityPoneglyph;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityRejectDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntitySakeFeast;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityString;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMiBox;
import xyz.pixelatedw.MineMineNoMi3.items.BellyPouch;
import xyz.pixelatedw.MineMineNoMi3.items.CharacterCreator;
import xyz.pixelatedw.MineMineNoMi3.items.Cola;
import xyz.pixelatedw.MineMineNoMi3.items.ItemRumbleBall;
import xyz.pixelatedw.MineMineNoMi3.items.ItemSakeBottle;
import xyz.pixelatedw.MineMineNoMi3.items.ItemVivreCard;
import xyz.pixelatedw.MineMineNoMi3.items.SakeCup;
import xyz.pixelatedw.MineMineNoMi3.items.SeaKingMeat;
import xyz.pixelatedw.MineMineNoMi3.items.UltraCola;
import xyz.pixelatedw.MineMineNoMi3.items.WantedPoster;
import xyz.pixelatedw.MineMineNoMi3.items.armors.ItemCoreArmor;
import xyz.pixelatedw.MineMineNoMi3.items.armors.ItemMedicBag;
import xyz.pixelatedw.MineMineNoMi3.items.armors.ItemTomoeDrums;
import xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras.Heart;
import xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras.Shadow;
import xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras.WateringCan;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialAxe;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialBreath;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialEisen;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialFire;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialFlash;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialImpact;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialMilky;
import xyz.pixelatedw.MineMineNoMi3.items.dials.DialReject;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ClimaTact;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.Flintlock;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemAbilityWeapon;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemCoreWeapon;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.Kabuto;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.KujaBow;
import xyz.pixelatedw.MineMineNoMi3.world.WorldProviderScenarioArena;

public class ListMisc
{
	public static Block Ope = new BlockOpe();
	public static Block OpeMid = new BlockOpeMid();
	public static Block KairosekiBlock = new NewBlock(Material.rock).setHardness(10);
	public static Block KairosekiOre = new NewBlock(Material.rock)
	{
		@Override
		public int quantityDropped(Random random)
		{
			return 2 + random.nextInt(3);
		}

		@Override
		public Item getItemDropped(int id, Random rand, int fortune)
		{
			return Kairoseki;
		}
	}.setHardness(10);
	public static Block EnchantmentTable = new BlockEnchantmentTable2();
	public static Block DenDenMushi = new BlockDenDenMushi();
	public static Block SkyBlock = new BlockSkyblock();
	public static Block Barrier = new BlockBarrier();
	public static Block Poneglyph1 = new BlockPoneglyph();
	public static Block Poneglyph2 = new BlockPoneglyph();
	public static Block Poneglyph3 = new BlockPoneglyph();
	public static Block Poison = new BlockPoison();
	public static Block DemonPoison = new BlockDemonPoison();
	public static BlockCustomSpawner CustomSpawner = new BlockCustomSpawner();
	public static Block Darkness = new BlockDarkness();
	public static Block KageBlock = new BlockKage();
	public static Block StringWall = new BlockStringWall();
	public static Block StringMid = new BlockStringMid();
	public static Block SunaSand = new BlockSunaSand()
	{
		@Override
		public int quantityDropped(Random random)
		{
			return 0;
		}

	};
	public static Block WantedPostersPackage = new BlockWantedPostersPackage();
	public static Block WantedPosterBlock = new BlockWantedPoster();
	public static Block OriBars = new BlockCustomBars("oribars", "oribars");
	public static Block KairosekiBars = new BlockCustomBars("kairosekibars", "kairosekibars")
	{
		@Override
		public int quantityDropped(Random random)
		{
			return 1;
		}

		@Override
		public Item getItemDropped(int id, Random rand, int fortune)
		{
			return Item.getItemFromBlock(KairosekiBars);
		}
	};
	public static Block WaxBlock = new NewBlock(Material.clay);
	public static Block AbilityProtectionBlock = new BlockAbilityProtection();
	public static Block AbilityProtectionAreaBlock = new BlockAbilityProtectionArea();
	public static Block AbilityProtectionCenterBlock = new BlockAbilityProtectionArea();
	
	public static Block DialEisenBlock = new BlockEisenDial();
	public static Block DialFireBlock = new BlockFlameDial();
	public static Block DialAxeBlock = new BlockAxeDial();
	public static Block DialImpactBlock = new BlockImpactDial();
	public static Block DialMilkyBlock = new BlockMilkyDial();
	public static Block DialFlashBlock = new BlockFlashDial();
	public static Block DialRejectBlock = new BlockRejectDial();
	public static Block DialBreathBlock = new BlockBreathDial();
	
	public static Block Cannon = new BlockCannon();
	public static Block SakeBottleBlock = new BlockSakeFeast();
	
	public static Item CharacterCreator = new CharacterCreator();
	public static Item Kairoseki = new Item();
	public static Item DenseKairoseki = new Item();
	public static Item BlackMetal = new Item();
	public static Item Shadow = new Shadow();
	public static Item Heart = new Heart().setMaxStackSize(1);
	public static Item BellyPouch = new BellyPouch().setMaxStackSize(16);
	public static Item Key = new Item();
	public static Item Box1;
	public static Item Box2;
	public static Item Box3;
	public static WantedPoster WantedPoster = (WantedPoster) new WantedPoster().setMaxStackSize(1);
	public static Item SeaKingMeat = new SeaKingMeat();
	public static Item WateringCan = new WateringCan();
	
	public static Item Note = new Item().setMaxStackSize(1);
	
	public static Item DialEisen = new DialEisen();
	public static Item DialFire = new DialFire();
	public static Item DialAxe = new DialAxe();
	public static Item DialImpact = new DialImpact();
	public static Item DialMilky = new DialMilky();
	public static Item DialFlash = new DialFlash();
	public static Item DialReject = new DialReject();
	public static Item DialBreath = new DialBreath();
	
	public static Item Bullets = new Item();
	public static Item KairosekiBullets = new Item();
	public static Item KujaArrow = new Item();
	public static Item PopGreen = new Item();
	public static Item CannonBall = new Item();
	public static Item Cola = new Cola();
	public static Item UltraCola = new UltraCola();
	public static Item SakeCup = new SakeCup();
	public static Item SakeBottle = new ItemSakeBottle();
	public static Item VivreCard = new ItemVivreCard();
	public static Item RumbleBall = new ItemRumbleBall();

	public static Item MarineHelm = new ItemCoreArmor("marine", ID.ARMORMAT_USELESS, 0);
	public static Item MarineChestplate = new ItemCoreArmor("marine", ID.ARMORMAT_USELESS, 1);
	public static Item MarineLeggings = new ItemCoreArmor("marine", ID.ARMORMAT_USELESS, 2);
	public static Item MarineBoots = new ItemCoreArmor("marine", ID.ARMORMAT_USELESS, 3);

	public static Item PirateChestplate = new ItemCoreArmor("pirate", ID.ARMORMAT_USELESS, 1);
	public static Item PirateLeggings = new ItemCoreArmor("pirate", ID.ARMORMAT_USELESS, 2);
	public static Item PirateBoots = new ItemCoreArmor("pirate", ID.ARMORMAT_USELESS, 3);

	public static Item ColaBackpack = new ItemCoreArmor("colabackpack", ID.ARMORMAT_COLABACKPACK, 1);
	public static Item TomoeDrums = new ItemTomoeDrums();
	public static Item MedicBag = new ItemMedicBag();

	public static Item Flintlock = new Flintlock().setMaxStackSize(1).setFull3D();
	public static Item Kabuto = new Kabuto("kabuto").setMaxStackSize(1).setFull3D();
	public static Item KuroKabuto = new Kabuto("kurokabuto").setMaxStackSize(1).setFull3D();
	public static Item GingaPachinko = new Kabuto("gingapachinko").setMaxStackSize(1).setFull3D();
	public static Item GreenKujaBow = new KujaBow("green").setMaxStackSize(1).setFull3D();
	public static Item BlueKujaBow = new KujaBow("blue").setMaxStackSize(1).setFull3D();
	public static Item RedKujaBow = new KujaBow("red").setMaxStackSize(1).setFull3D();
	public static ItemCoreWeapon MarineSword = new ItemCoreWeapon(5).setMaxDamage(300);
	public static ItemCoreWeapon PirateCutlass = new ItemCoreWeapon(5).setMaxDamage(300);
	public static ItemCoreWeapon Pipe = new ItemCoreWeapon(4).setMaxDamage(200);
	public static ItemCoreWeapon Scissors = new ItemCoreWeapon(6);
	public static ItemCoreWeapon Kikoku = new ItemCoreWeapon(8);
	public static ItemCoreWeapon Kiribachi = new ItemCoreWeapon(6);
	public static ItemCoreWeapon Yoru = new ItemCoreWeapon(10);
	public static ItemCoreWeapon Biseto = new ItemCoreWeapon(8);
	public static ItemCoreWeapon Hook = new ItemCoreWeapon(6).setIsPoisonous();
	public static ItemCoreWeapon Umbrella = new ItemCoreWeapon(3);
	public static ItemCoreWeapon UmbrellaOpen = new ItemCoreWeapon(3);
	public static ItemCoreWeapon Jitte = new ItemCoreWeapon(7).setMaxDamage(500);
	public static ItemCoreWeapon BoStick = new ItemCoreWeapon(6);
	public static ItemCoreWeapon Hammer5t = new ItemCoreWeapon(1);
	public static ItemCoreWeapon Hammer10t = new ItemCoreWeapon(1);
	public static ItemCoreWeapon Hammer100t = new ItemCoreWeapon(1);
	public static ItemCoreWeapon Tonfa = new ItemCoreWeapon(4).setMaxDamage(500);
	public static ItemCoreWeapon Knife1 = new ItemCoreWeapon(3);
	public static ItemCoreWeapon Knife2 = new ItemCoreWeapon(3);
	public static ItemCoreWeapon Knife3 = new ItemCoreWeapon(3).setMaxDamage(250);
	public static ItemCoreWeapon WadoIchimonji = new ItemCoreWeapon(8);
	public static ItemCoreWeapon SandaiKitetsu = new ItemCoreWeapon(8);
	public static ItemCoreWeapon NidaiKitetsu = new ItemCoreWeapon(10);
	public static ItemCoreWeapon Shusui = new ItemCoreWeapon(8);
	public static ItemCoreWeapon SoulSolid = new ItemCoreWeapon(8);
	public static ItemCoreWeapon Durandal = new ItemCoreWeapon(7);
	public static ItemCoreWeapon Mace = new ItemCoreWeapon(6);
	
	public static ClimaTact ClimaTact = new ClimaTact().setDamage(1);
	public static ClimaTact PerfectClimaTact = new ClimaTact().setDamage(3);
	public static ClimaTact SorceryClimaTact = new ClimaTact().setDamage(6);
	
	public static ItemAbilityWeapon IceSaber = new ItemAbilityWeapon(9).setIsSlownessInducing();
	public static ItemAbilityWeapon AmaNoMurakumo = new ItemAbilityWeapon(9);
	public static ItemAbilityWeapon NoroNoroBeamSword = new ItemAbilityWeapon(5).setIsSlownessInducing(75, true);
	public static ItemAbilityWeapon DoruDoruArtsKen = new ItemAbilityWeapon(6);
	public static ItemAbilityWeapon BlueSword = new ItemAbilityWeapon(8).setIsFireAspect();
	public static ItemAbilityWeapon TabiraYuki = new ItemAbilityWeapon(8).setIsSlownessInducing(50);

	public static void init()
	{
		ID.DIMENSION_ID_SCENARIOARENA = DimensionManager.getNextFreeDimId();
		DimensionManager.registerProviderType(ID.DIMENSION_ID_SCENARIOARENA, WorldProviderScenarioArena.class, true);
		DimensionManager.registerDimension(ID.DIMENSION_ID_SCENARIOARENA, ID.DIMENSION_ID_SCENARIOARENA);

		Box1 = new AkumaNoMiBox(1).setMaxStackSize(1);
		Box2 = new AkumaNoMiBox(2).setMaxStackSize(1);
		Box3 = new AkumaNoMiBox(3).setMaxStackSize(1);

		addITEM(Kairoseki, "Kairoseki", ListCreativeTabs.tabMisc);
		addITEM(DenseKairoseki, "Dense Kairoseki", ListCreativeTabs.tabMisc);
		addITEM(BlackMetal, "Black Metal", ListCreativeTabs.tabMisc);
		addITEM(Shadow, "Shadow", ListCreativeTabs.tabMisc);
		addITEM(Heart, "Heart", null);
		addITEM(Cola, "Cola", ListCreativeTabs.tabMisc);
		addITEM(UltraCola, "Ultra Cola", ListCreativeTabs.tabMisc);
		addITEM(BellyPouch, "Belly Pouch", ListCreativeTabs.tabMisc);
		addITEM(Key, "Key", ListCreativeTabs.tabMisc);
		addITEM(Box1, "Wooden Box", ListCreativeTabs.tabMisc);
		addITEM(Box2, "Iron Box", ListCreativeTabs.tabMisc);
		addITEM(Box3, "Golden Box", ListCreativeTabs.tabMisc);
		addITEM(WantedPoster, "Wanted Poster", null);
		addITEM(SeaKingMeat, "Sea King Meat", ListCreativeTabs.tabMisc);
		addITEM(WateringCan, "Watering Can", ListCreativeTabs.tabMisc);
		addITEM(SakeCup, "Sake Cup", ListCreativeTabs.tabMisc);
		addITEM(SakeBottle, "Sake Bottle", ListCreativeTabs.tabMisc);
		
		addITEM(KujaArrow, "Kuja Arrow", ListCreativeTabs.tabWeapons);
		addITEM(PopGreen, "Pop Green", ListCreativeTabs.tabWeapons);
		addITEM(Bullets, "Bullets", ListCreativeTabs.tabWeapons);
		addITEM(KairosekiBullets, "Kairoseki Bullets", ListCreativeTabs.tabWeapons);
		addITEM(CannonBall, "Cannon Ball", ListCreativeTabs.tabWeapons);

		addITEM(MarineHelm, "Marine Helmet", ListCreativeTabs.tabWeapons);
		addITEM(MarineChestplate, "Marine Chestplate", ListCreativeTabs.tabWeapons);
		addITEM(MarineLeggings, "Marine Leggings", ListCreativeTabs.tabWeapons);
		addITEM(MarineBoots, "Marine Boots", ListCreativeTabs.tabWeapons);

		addITEM(PirateChestplate, "Pirate Chestplate", ListCreativeTabs.tabWeapons);
		addITEM(PirateLeggings, "Pirate Leggings", ListCreativeTabs.tabWeapons);
		addITEM(PirateBoots, "Pirate Boots", ListCreativeTabs.tabWeapons);

		addITEM(ColaBackpack, "Cola Backpack", ListCreativeTabs.tabWeapons);
		addITEM(TomoeDrums, "Tomoe Drums", ListCreativeTabs.tabWeapons);
		addITEM(Note, "Note", null);
		addITEM(MedicBag, "Medic Bag", ListCreativeTabs.tabWeapons);
		addITEM(VivreCard, "Vivre Card", null);
		//addITEM(RumbleBall, "Rumble Ball", ListCreativeTabs.tabWeapons);

		addITEM(GreenKujaBow, "Green Kuja Bow", ListCreativeTabs.tabWeapons);
		addITEM(BlueKujaBow, "Blue Kuja Bow", ListCreativeTabs.tabWeapons);
		addITEM(RedKujaBow, "Red Kuja Bow", ListCreativeTabs.tabWeapons);
		addITEM(Flintlock, "Flintlock", ListCreativeTabs.tabWeapons);
		addITEM(Kabuto, "Kabuto", ListCreativeTabs.tabWeapons);
		addITEM(KuroKabuto, "Kuro Kabuto", ListCreativeTabs.tabWeapons);
		addITEM(GingaPachinko, "Ginga Pachinko", ListCreativeTabs.tabWeapons);
		addITEM(MarineSword, "Marine Sword", ListCreativeTabs.tabWeapons);
		addITEM(PirateCutlass, "Pirate Cutlass", ListCreativeTabs.tabWeapons);
		addITEM(Pipe, "Pipe", ListCreativeTabs.tabWeapons);
		addITEM(Scissors, "Scissors", ListCreativeTabs.tabWeapons);
		addITEM(Kikoku, "Kikoku", ListCreativeTabs.tabWeapons);
		addITEM(Kiribachi, "Kiribachi", ListCreativeTabs.tabWeapons);
		addITEM(Yoru, "Yoru", ListCreativeTabs.tabWeapons);
		addITEM(Biseto, "Bisento", ListCreativeTabs.tabWeapons);
		addITEM(Hook, "Hook", ListCreativeTabs.tabWeapons);
		addITEM(Umbrella, "Umbrella", ListCreativeTabs.tabWeapons);
		addITEM(UmbrellaOpen, "Umbrella Open", null);
		addITEM(Jitte, "Jitte", ListCreativeTabs.tabWeapons);
		addITEM(BoStick, "Bo Staff", ListCreativeTabs.tabWeapons);
		addITEM(Hammer5t, "5t Hammer", ListCreativeTabs.tabWeapons);
		addITEM(Hammer10t, "10t Hammer", ListCreativeTabs.tabWeapons);
		addITEM(Hammer100t, "100t Hammer", ListCreativeTabs.tabWeapons);
		addITEM(Tonfa, "Tonfa", ListCreativeTabs.tabWeapons);
		addITEM(Knife1, "Mihawk's Knife", ListCreativeTabs.tabWeapons);
		addITEM(Knife2, "Ace's Knife", ListCreativeTabs.tabWeapons);
		addITEM(Knife3, "Bandit's Knife", ListCreativeTabs.tabWeapons);
		addITEM(WadoIchimonji, "Wado Ichimonji", ListCreativeTabs.tabWeapons);
		addITEM(SandaiKitetsu, "Sandai Kitetsu", ListCreativeTabs.tabWeapons);
		addITEM(NidaiKitetsu, "Nidai Kitetsu", ListCreativeTabs.tabWeapons);
		addITEM(Shusui, "Shusui", ListCreativeTabs.tabWeapons);
		addITEM(SoulSolid, "Soul Solid", ListCreativeTabs.tabWeapons);
		addITEM(Durandal, "Durandal", ListCreativeTabs.tabWeapons);
		addITEM(Mace, "Mace", ListCreativeTabs.tabWeapons);
		
		addITEM(ClimaTact, "Clima Tact", ListCreativeTabs.tabWeapons);
		addITEM(PerfectClimaTact, "Perfect Clima Tact", ListCreativeTabs.tabWeapons);
		addITEM(SorceryClimaTact, "Sorcery Clima Tact", ListCreativeTabs.tabWeapons);
		
		addITEM(IceSaber, "Ice Saber", null);
		addITEM(AmaNoMurakumo, "Ama no Murakumo", null);
		addITEM(NoroNoroBeamSword, "Noro Noro Beam Sword", null);
		addITEM(DoruDoruArtsKen, "Doru Doru Arts : Ken", null);
		addITEM(BlueSword, "Blue Sword", null);
		addITEM(TabiraYuki, "Tabira Yuki", null);

		addITEM(CharacterCreator, "Character Creator", ListCreativeTabs.tabMisc);

		addITEM(DialEisen, "Eisen Dial", ListCreativeTabs.tabMisc);
		addITEM(DialFire, "Flame Dial", ListCreativeTabs.tabMisc);
		addITEM(DialAxe, "Axe Dial", ListCreativeTabs.tabMisc);
		addITEM(DialImpact, "Impact Dial", ListCreativeTabs.tabMisc);
		addITEM(DialMilky, "Milky Dial", ListCreativeTabs.tabMisc);
		addITEM(DialReject, "Reject Dial", ListCreativeTabs.tabMisc);
		addITEM(DialFlash, "Flash Dial", ListCreativeTabs.tabMisc);
		addITEM(DialBreath, "Breath Dial", ListCreativeTabs.tabMisc);

		addBLOCK(Ope, "Ope", Float.POSITIVE_INFINITY, null, null);
		addBLOCK(OpeMid, "Ope Mid", Float.POSITIVE_INFINITY, TileEntityOpe.class, null);
		addBLOCK(KairosekiOre, "Kairoseki Ore", 3.5F, null, ListCreativeTabs.tabMisc);
		addBLOCK(KairosekiBlock, "Kairoseki Block", 3.5F, null, ListCreativeTabs.tabMisc);
		addBLOCK(EnchantmentTable, "Kairoseki Table", 3.5F, null, ListCreativeTabs.tabMisc);
		addBLOCK(DenDenMushi, "Den Den Mushi", 0.5F, TileEntityDenDenMushi.class, ListCreativeTabs.tabMisc);
		addBLOCK(SkyBlock, "Sky Block", 0.6F, null, ListCreativeTabs.tabMisc);
		addBLOCK(Barrier, "Crash Barrier", Float.POSITIVE_INFINITY, null, null);
		addBLOCK(Poneglyph1, "Poneglyph 1", Float.POSITIVE_INFINITY, TileEntityPoneglyph.class, ListCreativeTabs.tabMisc);
		addBLOCK(Poneglyph2, "Poneglyph 2", Float.POSITIVE_INFINITY, TileEntityPoneglyph.class, ListCreativeTabs.tabMisc);
		addBLOCK(Poneglyph3, "Poneglyph 3", Float.POSITIVE_INFINITY, TileEntityPoneglyph.class, ListCreativeTabs.tabMisc);
		addBLOCK(Poison, "Poison", 1.5F, null, null);
		addBLOCK(DemonPoison, "Demon Poison", 1.5F, null, null);
		addBLOCK(CustomSpawner, "Custom Spawner", Float.POSITIVE_INFINITY, TileEntityCustomSpawner.class, null);
		addBLOCK(Darkness, "Darkness", Float.POSITIVE_INFINITY, null, null);
		addBLOCK(KageBlock, "Kage Block", Float.POSITIVE_INFINITY, null, null);
		addBLOCK(StringWall, "String Wall", Float.POSITIVE_INFINITY, null, null);
		addBLOCK(StringMid, "String Mid", Float.POSITIVE_INFINITY, TileEntityString.class, null);
		addBLOCK(SunaSand, "Suna Sand", 0.2F, null, null);
		addBLOCK(WantedPostersPackage, "Posters Package", 1.0F, TileEntityWantedPostersPackage.class, null);
		addBLOCK(WantedPosterBlock, "Wanted Poster Block", 0.1F, TileEntityWantedPoster.class, null);
		addBLOCK(OriBars, "Ori Bars", 40.0F, null, null);
		addBLOCK(KairosekiBars, "Kairoseki Bars", 30.0F, null, ListCreativeTabs.tabMisc);
		addBLOCK(WaxBlock, "Wax Block", 6.0F, null, null);
		addBLOCK(AbilityProtectionBlock, "Ability Protection Block", Float.MAX_VALUE, null, null);
		addBLOCK(AbilityProtectionAreaBlock, "Ability Protection Area Block", Float.MAX_VALUE, null, null);
		addBLOCK(AbilityProtectionCenterBlock, "Ability Protection Center Block", Float.MAX_VALUE, TileEntityAbilityProtection.class, null);
		addBLOCK(Cannon, "Cannon", 1.0F, TileEntityCannon.class, ListCreativeTabs.tabMisc);
		addBLOCK(SakeBottleBlock, "Sake Bottle Block", 0.2F, TileEntitySakeFeast.class, null);
		
		addBLOCK(DialEisenBlock, "Eisen Dial Block", .3F, TileEntityEisenDial.class, null);
		addBLOCK(DialFireBlock, "Flame Dial Block", .3F, TileEntityFlameDial.class, null);
		addBLOCK(DialAxeBlock, "Axe Dial Block", .3F, TileEntityAxeDial.class, null);
		addBLOCK(DialImpactBlock, "Impact Dial Block", .3F, TileEntityImpactDial.class, null);
		addBLOCK(DialMilkyBlock, "Milky Dial Block", .3F, TileEntityMilkyDial.class, null);
		addBLOCK(DialRejectBlock, "Reject Dial Block", .3F, TileEntityRejectDial.class, null);
		addBLOCK(DialBreathBlock, "Breath Dial Block", .3F, TileEntityBreathDial.class, null);
		addBLOCK(DialFlashBlock, "Flash Dial Block", .3F, TileEntityFlashDial.class, null);

		WyRegistry.registerName("race.n/a.name", "N/A");
		WyRegistry.registerName("faction.n/a.name", "N/A");
		WyRegistry.registerName("style.n/a.name", "N/A");

		WyRegistry.registerName("race.human.name", "Human");
		WyRegistry.registerName("race.fishman.name", "Fishman");
		WyRegistry.registerName("race.cyborg.name", "Cyborg");

		WyRegistry.registerName("faction.pirate.name", "Pirate");
		WyRegistry.registerName("faction.marine.name", "Marine");
		WyRegistry.registerName("faction.bountyhunter.name", "Bounty Hunter");
		WyRegistry.registerName("faction.revolutionary.name", "Revolutionary Army");
		
		WyRegistry.registerName("style.swordsman.name", "Swordsman");
		WyRegistry.registerName("style.sniper.name", "Sniper");
		WyRegistry.registerName("style.doctor.name", "Doctor");
		WyRegistry.registerName("style.art of weather.name", "Art of Weather");
		
		WyRegistry.registerName("quest.none.name", "None");
		WyRegistry.registerName("gui.quests.started", "has started !");
		WyRegistry.registerName("gui.quests.completed", "has been completed !");

		WyRegistry.registerName("ability.gomugomunojetpistol.name", "Gomu Gomu no Jet Pistol");
		WyRegistry.registerName("ability.gomugomunoelephantgun.name", "Gomu Gomu no Elephant Gun");
		WyRegistry.registerName("ability.gomugomunokonggun.name", "Gomu Gomu no Kong Gun");

		WyRegistry.registerName("ability.gomugomunojetbazooka.name", "Gomu Gomu no Jet Bazooka");
		WyRegistry.registerName("ability.gomugomunogrizzlymagnum.name", "Gomu Gomu no Grizzly Magnum");
		WyRegistry.registerName("ability.gomugomunoleobazooka.name", "Gomu Gomu no Leo Bazooka");

		WyRegistry.registerName("ability.gomugomunojetgatling.name", "Gomu Gomu no Jet Gatling");
		WyRegistry.registerName("ability.gomugomunoelephantgatling.name", "Gomu Gomu no Elephant Gatling");
		WyRegistry.registerName("ability.gomugomunokongorgan.name", "Gomu Gomu no Kong Organ");

		WyRegistry.registerName("ability.1millionvoltvari.name", "1 Million Volt Vari");
		WyRegistry.registerName("ability.5millionvoltvari.name", "5 Million Volt Vari");
		WyRegistry.registerName("ability.10millionvoltvari.name", "10 Million Volt Vari");
		WyRegistry.registerName("ability.20millionvoltvari.name", "20 Million Volt Vari");
		WyRegistry.registerName("ability.50millionvoltvari.name", "50 Million Volt Vari");
		WyRegistry.registerName("ability.60millionvoltvari.name", "60 Million Volt Vari");
		WyRegistry.registerName("ability.100millionvoltvari.name", "100 Million Volt Vari");
		WyRegistry.registerName("ability.max200millionvoltvari.name", "Max 200 Million Volt Vari");
		
		// Swordsman Progression Questline
		WyRegistry.registerName("ability.mamaragan.name", "Mamaragan");

		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression01.getQuestID() + ".started", "<Swordsman Master> You want to become a swordsman master, young one ? I do like the sparks in your eyes so how about this, show me your best sword and I'll see if you're fit or not to start training with me.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression01.getQuestID() + ".completed", "<Swordsman Master> That's a really nice blade you have there, really strong indeed. Fine, I will train you, when you're ready come and talk with me again !");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression02.getQuestID() + ".started", "<Swordsman Master> First we'll test your determination, you must survive the night in the wilderness without dying !");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression02.getQuestID() + ".completed", "<Swordsman Master> Seems like it was too easy for you ?");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression03.getQuestID() + ".started", "<Swordsman Master> Next we will test your strength and stamina ! Go to the nearby mountains and kill 20 creatures of your choice while breathing some fresh air.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression03.getQuestID() + ".completed", "<Swordsman Master> Impressive.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression04.getQuestID() + ".started", "<Swordsman Master> Now for the last test we must train your movement during combat. Deal 25 critical hits.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression04.getQuestID() + ".completed", "<Swordsman Master> I hope you've learned something from this. You're free for now, I will need some time to think how to challenge your skill even more.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression05.getQuestID() + ".started", "<Swordsman Master> This can wait, we've got some bandit company outside kid, help me get rid of them.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression05.getQuestID() + ".completed", "<Swordsman Master> With so much explosive power they are probably planning something big, better to investigate first.");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression05.getQuestID() + ".dialogue.01", "<Swordsman Master> There are still some bandits nearby!");
		WyRegistry.registerName("quest." + ListQuests.swordsmanProgression05.getQuestID() + ".dialogue.02", "<Swordsman Master> No doubt they came here for this note. You must decipher it, a librarian will probably be able to crack this code.");
		
		// Sniper Progression Questline
		
		// Quest related items
		WyRegistry.registerName("quest.item.mysteriousnote", "Mysterious Note");
		WyRegistry.registerName("quest.item.decipherednote", "Deciphered Note");
				
		WyRegistry.registerName(ID.LANG_GUI_HISTORY, "History");
		WyRegistry.registerName(ID.LANG_GUI_CHALLENGES, "Challenges");
		WyRegistry.registerName(ID.LANG_GUI_FACTION, "Faction");
		WyRegistry.registerName(ID.LANG_GUI_RACE, "Race");
		WyRegistry.registerName(ID.LANG_GUI_STYLE, "Style");
		WyRegistry.registerName(ID.LANG_GUI_ABILITIES, "Abilities");
		WyRegistry.registerName("gui.epithet.name", "Epithets");
		WyRegistry.registerName(ID.LANG_GUI_QUESTS, "Quests");
		WyRegistry.registerName(ID.LANG_GUI_QUESTS_PROGRESS, "Progress");
		WyRegistry.registerName(ID.LANG_GUI_QUESTS_ACCEPT, "Accept");
		WyRegistry.registerName(ID.LANG_GUI_QUESTS_DECLINE, "Decline");
		WyRegistry.registerName(ID.LANG_GUI_QUESTS_ACCEPTTEXT, "Do you wish to accept this quest ?");
		
		WyRegistry.registerName("category.mmnmkeys", "Mine Mine no Mi Keys");
		WyRegistry.registerName("key.combatmode", "Combat Mode");
		WyRegistry.registerName("key.playerui", "Player UI");
		for(int i = 1; i < 9; i++)
			WyRegistry.registerName("key.combatslot." + i, "Ability Slot " + i);
		
	}

	private static void addITEM(Item item, String localizedName, CreativeTabs tab)
	{
		WyRegistry.registerItem(item, localizedName, tab);
		Values.miscItems.add(item);
	}

	private static void addBLOCK(Block block, String localizedName, float hard, Class<? extends TileEntity> tile, CreativeTabs tab)
	{
		addBLOCK(block, null, localizedName, hard, tile, tab);
	}
	
	private static void addBLOCK(Block block, Class<? extends ItemBlock> itemBlock, String localizedName, float hard, Class<? extends TileEntity> tile, CreativeTabs tab)
	{
		WyRegistry.registerBlock(block, itemBlock, localizedName, hard, tab, tile);
		Values.miscBlocks.add(block);
	}
}
