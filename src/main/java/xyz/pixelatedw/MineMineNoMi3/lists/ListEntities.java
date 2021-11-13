package xyz.pixelatedw.MineMineNoMi3.lists;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.BiomeDictionary.Type;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityKungFuDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityLapahn;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.arlongPirates.EntityArlong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.arlongPirates.EntityChew;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.arlongPirates.EntityKuroobi;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.EntityBandit;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.baroqueWorks.EntityMr0;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.kriegPirates.EntityDonKrieg;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.kriegPirates.EntityGin;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.kriegPirates.EntityPearl;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarine;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMorgan;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityBlackKnight;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityDoppelman;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityMirageClone;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityFatPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers.EntityDojoSensei;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.EntitySniperTarget;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityLapahn;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityBlueno;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityFukuro;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityJabra;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityJabraL;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKaku;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKakuL;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKalifa;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKumadori;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityLucci;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityLucciL;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntitySpandam;

public class ListEntities 
{
	
	public static void init()
	{
		int ids = 0;
		for(int i = 0; i < ListDevilFruits.ALL_ENTITIES.length; i++)
		{
			for(int j = 0; j < ((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).size(); j++)
			{
				EntityRegistry.registerModEntity(((Class)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[0]), ((AbilityAttribute)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[1]).getAttributeName(), ids++, MainMod.getMineMineNoMi(), 64, 10, true);
			}
		}
		
		Type[] generalBiomes = new Type[]
				{Type.BEACH, Type.JUNGLE, Type.SWAMP, Type.SAVANNA, Type.FOREST, Type.HILLS, Type.CONIFEROUS};
		Type[] dugongBiomes = new Type[]
				{Type.BEACH, Type.SANDY};
		
		//Bandits
		WyRegistry.registerMob("Bandit with Sword", EntityBandit.class, 0x5B2929, 0xFFFFFF);
		WyRegistry.registerSpawnBiomesFor(EntityBandit.class, 30, 2, 5, generalBiomes);
		
		//Marines
		WyRegistry.registerMob("Marine with Sword", EntityMarine.class, 0x02258e, 0xFFFFFF);
		WyRegistry.registerSpawnBiomesFor(EntityMarine.class, 20, 3, 6, generalBiomes);
		WyRegistry.registerMob("Marine with Gun", EntityMarineWithGun.class, 0x02258e, 0xFFFFFF);
		WyRegistry.registerSpawnBiomesFor(EntityMarineWithGun.class, 20, 3, 6, generalBiomes);
		WyRegistry.registerMob("Marine Captain", EntityMarineCaptain.class, 0x02258e, 0xFFFFFF);
		WyRegistry.registerMob("Captain Morgan", EntityMorgan.class);
		 
		//W.GOV
		WyRegistry.registerMob("Lucci", EntityLucci.class);
		WyRegistry.registerMob("LucciL", EntityLucciL.class);
		WyRegistry.registerMob("Kaku", EntityKaku.class);
		WyRegistry.registerMob("KakuL", EntityKakuL.class);
		WyRegistry.registerMob("Jabra", EntityJabra.class);
		WyRegistry.registerMob("JabraL", EntityJabraL.class);
		WyRegistry.registerMob("Fukuro", EntityFukuro.class);
		WyRegistry.registerMob("Kalifa", EntityKalifa.class);
		WyRegistry.registerMob("Kumadori", EntityKumadori.class);
		WyRegistry.registerMob("Blueno", EntityBlueno.class);
		WyRegistry.registerMob("Spandam", EntitySpandam.class);
		
		//Pirates
		WyRegistry.registerMob("Pirate with Sword", EntityPirate.class, 0x960606, 0xFFFFFF);
		WyRegistry.registerSpawnBiomesFor(EntityPirate.class, 20, 3, 6, generalBiomes);
		WyRegistry.registerMob("Pirate with Gun", EntityPirateWithGun.class, 0x960606, 0xFFFFFF);
		WyRegistry.registerSpawnBiomesFor(EntityPirateWithGun.class, 20, 3, 6, generalBiomes);
		WyRegistry.registerMob("Pirate Captain", EntityPirateCaptain.class, 0x960606, 0xFFFFFF);
		WyRegistry.registerMob("Fat Pirate", EntityFatPirate.class, 0x960606, 0xFFFFFF);
		//Arlong Pirates
		WyRegistry.registerMob("Arlong", EntityArlong.class);
		WyRegistry.registerMob("Chew", EntityChew.class);
		WyRegistry.registerMob("Kuroobi", EntityKuroobi.class);
		//Krieg Pirates
		WyRegistry.registerMob("Don Krieg", EntityDonKrieg.class);
		WyRegistry.registerMob("Gin", EntityGin.class);
		WyRegistry.registerMob("Pearl", EntityPearl.class);
		//Baroque Works Pirates
		WyRegistry.registerMob("Mr 0", EntityMr0.class);
		
		//Others
		WyRegistry.registerMob("Doppelman", EntityDoppelman.class);
		WyRegistry.registerMob("Black Knight", EntityBlackKnight.class);
		WyRegistry.registerMob("Mirage Clone", EntityMirageClone.class);
		WyRegistry.registerMob("Dojo Sensei", EntityDojoSensei.class, 0xFF00FF, 0x00FF00);
		WyRegistry.registerMob("Wanted Posters Package", EntityWantedPostersPackage.class);
		WyRegistry.registerMob("Sniper Targets", EntitySniperTarget.class);
		
		//Animals
		WyRegistry.registerMob("Den Den Mushi", EntityDenDenMushi.class, 0xFF00FF, 0x00FF00);
		WyRegistry.registerSpawnBiomesFor(EntityDenDenMushi.class, 50, 1, 3, Type.PLAINS, Type.SAVANNA, Type.DRY, Type.SPARSE, Type.CONIFEROUS, Type.MOUNTAIN);
		WyRegistry.registerMob("Kung Fu Dugong", EntityKungFuDugong.class, 0xdbac64, 0x26815a);
		WyRegistry.registerSpawnBiomesFor(EntityKungFuDugong.class, 30, 5, 7, dugongBiomes);
		WyRegistry.registerMob("Lapahn", EntityLapahn.class, 0xaedbd7, 0x449a94);
		WyRegistry.registerSpawnBiomesFor(EntityKungFuDugong.class, 30, 3, 5, Type.COLD);
		WyRegistry.registerMob("Yagara Bull", EntityYagaraBull.class, 0xf0ad4e, 0x5CB85C);
		WyRegistry.registerSpawnBiomesFor(EntityYagaraBull.class, 40, 1, 2, Type.WATER);
		
		//Temp
		//WyRegistry.registerMob("TEMP_Dummy", TempEntityDummy.class);
		WyRegistry.registerMob("TEMP_Dugong", TempEntityDugong.class);
		WyRegistry.registerMob("TEMP_Laphan", TempEntityLapahn.class);
		WyRegistry.registerMob("TEMP_YagaraBull", TempEntityYagaraBull.class);

	}
	
}
