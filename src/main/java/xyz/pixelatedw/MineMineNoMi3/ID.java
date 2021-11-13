package xyz.pixelatedw.MineMineNoMi3;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class ID 
{ 
	
	public static final ResourceLocation
	
	PARTICLE_ICON_YUKI = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_yuki.png"),
	PARTICLE_ICON_PIKA = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_pika.png"),
	PARTICLE_ICON_MERA = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_mera.png"),
	PARTICLE_ICON_MERA2 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_mera2.png"),
	PARTICLE_ICON_MOKU = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_moku.png"),
	PARTICLE_ICON_MOKU2 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_moku2.png"),
	PARTICLE_ICON_MOKU3 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_moku3.png"),
	PARTICLE_ICON_SUNA = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_suna.png"),
	PARTICLE_ICON_SUNA2 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_suna2.png"),
	PARTICLE_ICON_GASU = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_gasu.png"),
	PARTICLE_ICON_GASU2 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_gasu2.png"),	
	PARTICLE_ICON_BLUEFLAME = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_blueflame.png"),	
	PARTICLE_ICON_DARKNESS = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_darkness.png"),	
	PARTICLE_ICON_GORO = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_goro.png"),
	PARTICLE_ICON_GORO2 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_goro2.png"),
	PARTICLE_ICON_GORO3 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_goro3.png"),
	PARTICLE_ICON_DOKU = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_doku.png"),	
	PARTICLE_ICON_ITO = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_ito.png"),	
	PARTICLE_ICON_GURA = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_gura.png"),	
	PARTICLE_ICON_GURA2 = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_gura2.png"),	
	PARTICLE_ICON_HIE = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_hie.png"),
	PARTICLE_ICON_KILO = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_kilo.png"),
	PARTICLE_ICON_MERO = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_mero.png"),
	PARTICLE_ICON_CHIYU = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_chiyu1.png"),
	PARTICLE_ICON_RUST = new ResourceLocation(ID.PROJECT_ID, "textures/particles/particle_rust.png"),
			
	ICON_HARROW = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_arrow.png"),
	
	ICON_PIRATE = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_pirate.png"),
	ICON_MARINE = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_marine.png"),
	ICON_BOUNTYHUNTER = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_bountyhunter.png"),
	ICON_REVOLUTIONARY = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_revolutionary.png"),
			
	ICON_HUMAN = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_human.png"),
	ICON_FISHMAN = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_fishman.png"),
	ICON_CYBORG = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_cyborg.png"),
	
	ICON_SWORDSMAN = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_swordsman.png"),
	ICON_SNIPER = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_sniper.png"),
	ICON_MEDIC = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_medic.png"),
	ICON_ARTOFWEATHER = new ResourceLocation(ID.PROJECT_ID, "textures/gui/icons/icon_artofweather.png"),
			
	HANDTEXTURE_ZOANMORPH_BUSO = new ResourceLocation(ID.PROJECT_ID, "textures/models/zoanmorph/hand_buso.png"),
	HANDTEXTURE_ZOANMORPH_HOTBOILINGSPECIAL = new ResourceLocation(ID.PROJECT_ID, "textures/models/zoanmorph/hand_hotboilingspecial.png"),
			
	TEXTURE_NULL = new ResourceLocation(ID.PROJECT_ID, "textures/gui/null.png"),
	
	TEXTURE_STRINGS1 = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_strings.png"),
	TEXTURE_BOUNTYPOSTER = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_bounty.png"),
	TEXTURE_BOUNTYPOSTER_LARGE = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_bounty_large.png"),
	TEXTURE_WIDGETS = new ResourceLocation(ID.PROJECT_ID, "textures/gui/widgets.png"),
	TEXTURE_CURRENCIES = new ResourceLocation(ID.PROJECT_ID, "textures/gui/currencies.png"),
	TEXTURE_BLANK = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_blank.png"),
	TEXTURE_JOB = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_job.png"),
	TEXTURE_RACE = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_race.png"),
	TEXTURE_FACTION = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_fac.png"),
	TEXTURE_COMBATMODE = new ResourceLocation(ID.PROJECT_ID, "textures/gui/combatmode.png");
	
	
	public static final ArmorMaterial
	
	ARMORMAT_COLABACKPACK = EnumHelper.addArmorMaterial("colabackpack", 400, new int[] {0, 4, 0, 0}, 0),
	ARMORMAT_USELESS = EnumHelper.addArmorMaterial("useless", 100, new int[] {1, 2, 1, 1}, 0);
	
	public static final String
	
	PROJECT_ID = "mineminenomi",
	PROJECT_NAME = "Mine Mine no Mi",
	PROJECT_VERSION = "0.6.1",
	PROJECT_MCVERSION = "1.7.10",

	PARTICLEFX_DOKUGOMU = "dokuGumo",
	PARTICLEFX_DAIENKAI1 = "daiEnkai1",
	PARTICLEFX_DAIENKAI2 = "daiEnkai2",			
	PARTICLEFX_FUBUKI = "fubuki",	
	PARTICLEFX_WHITELAUNCHER = "whiteLauncher",	
	PARTICLEFX_SAMEHADA = "samehada",
	PARTICLEFX_WATEREXPLOSION = "waterExplosion",
	PARTICLEFX_SABLES = "sables",
	PARTICLEFX_GROUNDDEATH = "groundDeath",
	PARTICLEFX_KOKUTEICROSS = "kokuteiCross",
	PARTICLEFX_GEARSECOND = "gearSecond",
	PARTICLEFX_TENSEINOSOEN1 = "tenseiNoSoen1",
	PARTICLEFX_TENSEINOSOEN2 = "tenseiNoSoen2",
	PARTICLEFX_BLACKWORLD = "blackWorld",
	PARTICLEFX_ELTHOR = "elThor",
	PARTICLEFX_YATANOKAGAMI = "yatanNoKagami",
	PARTICLEFX_AMATERASU = "amaterasu",
	PARTICLEFX_DARKMATTER = "darkMatter",
	PARTICLEFX_BLACKHOLE = "blackHole",
	PARTICLEFX_KUMONOSUGAKI = "kumoNoSugaki",
	PARTICLEFX_FLASH = "flash",
	PARTICLEFX_GEKISHIN = "gekishin",
	PARTICLEFX_KEMURIBOSHI = "kemuriBoshi",
	PARTICLEFX_GEPPO = "geppo",
	PARTICLEFX_BLUEFLAMES = "blueFlames",
	PARTICLEFX_ICEAGE = "iceAge",
	PARTICLEFX_VENOMDEMON = "venomDemon",
	PARTICLEFX_WHITESTRIKE = "whiteStrike",
	PARTICLEFX_DESERTGIRASOLE = "desertGirasole",
	PARTICLEFX_DESERTGIRASOLE2 = "desertGirasole2",
	PARTICLEFX_DESERTENCIERRO = "desertEncierro",
	PARTICLEFX_DESERTSPADA = "desertSpada",
	PARTICLEFX_KARI = "kari",
	PARTICLEFX_RAIGO = "raigo",
	PARTICLEFX_BAKUMUNCH = "bakuMunch",
	PARTICLEFX_KOROUZU = "korouzu",
	PARTICLEFX_KILO = "kilo",
	PARTICLEFX_KILOPRESS = "kiloPress",
	PARTICLEFX_GREATSTOMP = "greatStomp",
	PARTICLEFX_KASURIUTAFUBUKIGIRI = "kasuriutaFubukiGiri",
	PARTICLEFX_SOULPARADE = "soulParade",
	PARTICLEFX_COMMONEXPLOSION = "commonExplosion",
	PARTICLEFX_ATOMICSPURT = "atomicSpurt",
	PARTICLEFX_SLAVEARROW = "slaveArrow",
	PARTICLEFX_PERFUMEFEMUR = "perfumeFemur",
	PARTICLEFX_CHIYUPOPO = "chiyupopo",
	PARTICLEFX_EVAPORATE = "evaporate",
	PARTICLEFX_HEALINGTOUCH = "healingTouch",
	PARTICLEFX_RUSTTOUCH = "rustTouch",
	PARTICLEFX_CHLOROBALL = "chloroBall",
	PARTICLEFX_CHLOROBALLCLOUD = "chloroBallCloud",
	PARTICLEFX_ABOVEHEAD_ANGRY = "aboveHeadAngry",
	PARTICLEFX_ABOVEHEAD_HAPPY = "aboveHeadHappy",
	PARTICLEFX_ABOVEHEAD_HEART = "aboveHeadHeart",
	PARTICLEFX_MEDIC_BAG_EXPLOSION = "medicBagExplosion",
	PARTICLEFX_FIRST_AID = "firstAid",
	PARTICLEFX_HAOSHOKU_HAKI = "haoshokuHaki",
	
	EXTRAEFFECT_MERO = "mero",
	EXTRAEFFECT_HIE = "hie",
	EXTRAEFFECT_CHIYUHORMONE = "chiyuHormone",
	EXTRAEFFECT_TENSIONHORMONE = "tensionHormone",
	EXTRAEFFECT_NORO = "noro",
	EXTRAEFFECT_DORULOCK = "doruLock",
	EXTRAEFFECT_RUSTOVERLAY = "rustOverlay",	
	EXTRAEFFECT_SPIDEROVERLAY = "spiderOverlay",	
	EXTRAEFFECT_ORIBIND = "oriBind",
	EXTRAEFFECT_ABAREHIMATSURI = "abareHimatsuri",
	EXTRAEFFECT_LOGIA_OFF = "logiaOff",
	EXTRAEFFECT_SAKE_DRUNK = "sakeDrunk",
	EXTRAEFFECT_HAO = "haoHaki",
			
	CREW_ARLONG = "Arlong Pirates",
	CREW_BAROQUEWORKS = "Baroque Works",
	CREW_ALVIDAPIRATES = "Alvida Pirates",
	CREW_KRIEGPIRATES = "Krieg Pirates",
	
	FACTION_PIRATE = "Pirate",
	FACTION_MARINE = "Marine",
	FACTION_BOUNTYHUNTER = "Bounty Hunter",
	FACTION_REVOLUTIONARY = "Revolutionary",
	FACTION_BANDIT = "Bandit",
	
	RACE_HUMAN = "Human",
	RACE_FISHMAN = "Fishman",
	RACE_CYBORG = "Cyborg",
	RACE_MINK = "Mink",
	
	FSTYLE_SWORDSMAN = "Swordsman",
	FSTYLE_SNIPER = "Sniper",
	FSTYLE_DOCTOR = "Doctor",
	FSTYLE_ARTOFWEATHER = "Art of Weather",
	FSTYLE_OKAMA = "Okama",
	
	HISTORY_ENTRY_TYPE_CHALLENGE = "challenge",
	
	HISTORY_ENNTRY_NAME_CROCODILE = "crocodile",
	
	LANG_KEYS_CATEGORY = "category.mmnmkeys", //Mine Mine no Mi Keys
	LANG_KEY_PLAYER = "key.playerui", //Player UI
	LANG_KEY_COMBATMODE = "key.combatmode", //Combat Mode
	LANG_KEY_COMBATSLOT1 = "key.combatslot.1",
	LANG_KEY_COMBATSLOT2 = "key.combatslot.2",
	LANG_KEY_COMBATSLOT3 = "key.combatslot.3",
	LANG_KEY_COMBATSLOT4 = "key.combatslot.4",
	LANG_KEY_COMBATSLOT5 = "key.combatslot.5",
	LANG_KEY_COMBATSLOT6 = "key.combatslot.6",
	LANG_KEY_COMBATSLOT7 = "key.combatslot.7",
	LANG_KEY_COMBATSLOT8 = "key.combatslot.8",
	LANG_GUI_FACTION = "gui.faction.name",
	LANG_GUI_RACE = "gui.race.name",
	LANG_GUI_STYLE = "gui.style.name",
	LANG_GUI_ABILITIES = "gui.abilities.name",
	LANG_GUI_QUESTS = "gui.quests.name",
	LANG_GUI_HISTORY = "gui.history.name",
	LANG_GUI_CHALLENGES = "gui.challenges.name",
	LANG_GUI_QUESTS_PROGRESS = "gui.quests.progress.name",
	LANG_GUI_QUESTS_ACCEPT = "gui.quests.accept.name",	
	LANG_GUI_QUESTS_DECLINE = "gui.quests.decline.name",	
	LANG_GUI_QUESTS_ACCEPTTEXT = "gui.quests.accepttext.name",	
	LANG_GUI_QUESTS_STARTED = "gui.quests.started",	
	LANG_GUI_QUESTS_COMPLETED = "gui.quests.completed",	
						
	DIMENSION_NAME_SCENARIOARENA = "scenarioarena",
	
	SCENARIO_ROMANCEDAWN_CAPTAINMORGAN = "scenario_cptmorgan",
	
	//Auto assigned by the Deploy script
	BUILD_MODE = "DEV",
	NULL = "null";
	
	public static final int 
	
	GENERIC_PARTICLES_RENDER_DISTANCE = 128,

	ENTITY_STATE = 27,
	
	GUI_DIALTABLE = 0,
	GUI_PLAYER = 1,
	GUI_CHARACTERCREATOR = 2,
	GUI_ABILITIES = 3;	

	public static final int[]
			
	COORDS_SWORDSMANPROGRESSION05_DOJOAMBUSH = new int[] {-20000, 64, -20000};
	
	public static int
	
	DIMENSION_ID_SCENARIOARENA;
}
