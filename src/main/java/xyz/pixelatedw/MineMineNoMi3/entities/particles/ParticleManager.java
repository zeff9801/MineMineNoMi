package xyz.pixelatedw.MineMineNoMi3.entities.particles;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.baku.ParticleEffectBakuMunch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.chiyu.ParticleEffectChiyupopo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.chiyu.ParticleEffectHealingTouch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common.ParticleEffectAboveHead;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common.ParticleEffectCommonExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common.ParticleEffectWaterExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectChloroBall;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectChloroBallCloud;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectDokuGumo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectVenomDemon;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.fishkarate.ParticleEffectSamehada;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.gomu.ParticleEffectGearSecond;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro.ParticleEffectElThor;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro.ParticleEffectKari;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro.ParticleEffectRaigo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.gura.ParticleEffectGekishin;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.haki.ParticleEffectHaoshokuHaki;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.hie.ParticleEffectIceAge;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ito.ParticleEffectKumoNoSugaki;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kachi.ParticleEffectEvaporate;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kilo.ParticleEffectHeavyPunch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kilo.ParticleEffectKiloPress;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic.ParticleEffectFirstAid;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic.ParticleEffectMedicBagExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mera.ParticleEffectDaiEnkai;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mera.ParticleEffectDaiEnkai2;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mero.ParticleEffectPerfumeFemur;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mero.ParticleEffectSlaveArrow;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.moku.ParticleEffectWhiteLauncher;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.moku.ParticleEffectWhiteStrike;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika.ParticleEffectAmaterasu;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika.ParticleEffectFlash;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika.ParticleEffectYataNoKagami;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.rokushiki.ParticleEffectGeppo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.sabi.ParticleEffectRustTouch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.sniper.ParticleEffectKemuriBoshi;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertEncierro;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertGirasole;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertGirasole2;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertSpada;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectGroundDeath;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectSables;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.supa.ParticleEffectAtomicSpurt;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix.ParticleEffectBlueFlames;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix.ParticleEffectTenseiNoSoen;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix.ParticleEffectTenseiNoSoen2;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ushibison.ParticleEffectKokuteiCross;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectBlackHole;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectBlackWorld;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectDarkMatter;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectKorouzu;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yomi.ParticleEffectKasuriutaFubukiGiri1;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yomi.ParticleEffectSoulParade;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yuki.ParticleEffectFubuki;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.zou.ParticleEffectGreatStomp;

public class ParticleManager
{

	private static ParticleManager instance;
	
	public static ParticleManager getInstance()
	{
		if(instance == null)
			instance = new ParticleManager();
		
		return instance;
	}
	
	private HashMap<String, ParticleEffect> particleEffects = createMap();
	
	private HashMap<String, ParticleEffect> createMap()
	{
		HashMap<String, ParticleEffect> map = new HashMap<String, ParticleEffect>();
		
		// Common
		map.put(ID.PARTICLEFX_COMMONEXPLOSION, new ParticleEffectCommonExplosion());
		map.put(ID.PARTICLEFX_WATEREXPLOSION, new ParticleEffectWaterExplosion());
		map.put(ID.PARTICLEFX_ABOVEHEAD_ANGRY, new ParticleEffectAboveHead(EnumParticleTypes.VILLAGER_ANGRY.getParticleName()));
		map.put(ID.PARTICLEFX_ABOVEHEAD_HAPPY, new ParticleEffectAboveHead(EnumParticleTypes.VILLAGER_HAPPY.getParticleName()));
		map.put(ID.PARTICLEFX_ABOVEHEAD_HEART, new ParticleEffectAboveHead(EnumParticleTypes.HEART.getParticleName()));

		// Haki
		map.put(ID.PARTICLEFX_HAOSHOKU_HAKI, new ParticleEffectHaoshokuHaki());

		// Sabi
		map.put(ID.PARTICLEFX_RUSTTOUCH, new ParticleEffectRustTouch());
		
		// Chiyu
		map.put(ID.PARTICLEFX_EVAPORATE, new ParticleEffectEvaporate());	
		
		// Chiyu
		map.put(ID.PARTICLEFX_CHIYUPOPO, new ParticleEffectChiyupopo());	
		map.put(ID.PARTICLEFX_HEALINGTOUCH, new ParticleEffectHealingTouch());	

		// Mero
		map.put(ID.PARTICLEFX_SLAVEARROW, new ParticleEffectSlaveArrow());	
		map.put(ID.PARTICLEFX_PERFUMEFEMUR, new ParticleEffectPerfumeFemur());
		
		// Medic
		map.put(ID.PARTICLEFX_FIRST_AID, new ParticleEffectFirstAid());	
		map.put(ID.PARTICLEFX_MEDIC_BAG_EXPLOSION, new ParticleEffectMedicBagExplosion());	
		
		// Supa
		map.put(ID.PARTICLEFX_ATOMICSPURT, new ParticleEffectAtomicSpurt());
		
		// Zou
		map.put(ID.PARTICLEFX_GREATSTOMP, new ParticleEffectGreatStomp());
		
		// Baku
		map.put(ID.PARTICLEFX_BAKUMUNCH, new ParticleEffectBakuMunch());
		
		// Mera
		map.put(ID.PARTICLEFX_DAIENKAI1, new ParticleEffectDaiEnkai());
		map.put(ID.PARTICLEFX_DAIENKAI2, new ParticleEffectDaiEnkai2());
		
		// Doku
		map.put(ID.PARTICLEFX_DOKUGOMU, new ParticleEffectDokuGumo());
		map.put(ID.PARTICLEFX_VENOMDEMON, new ParticleEffectVenomDemon());
		map.put(ID.PARTICLEFX_CHLOROBALL, new ParticleEffectChloroBall());
		map.put(ID.PARTICLEFX_CHLOROBALLCLOUD, new ParticleEffectChloroBallCloud());
		
		// Yuki
		map.put(ID.PARTICLEFX_FUBUKI, new ParticleEffectFubuki());
		
		// Moku
		map.put(ID.PARTICLEFX_WHITELAUNCHER, new ParticleEffectWhiteLauncher());
		map.put(ID.PARTICLEFX_WHITESTRIKE, new ParticleEffectWhiteStrike());
		
		// Fishman
		map.put(ID.PARTICLEFX_SAMEHADA, new ParticleEffectSamehada());	
		
		// Suna
		map.put(ID.PARTICLEFX_SABLES, new ParticleEffectSables());
		map.put(ID.PARTICLEFX_GROUNDDEATH, new ParticleEffectGroundDeath());	
		map.put(ID.PARTICLEFX_DESERTGIRASOLE, new ParticleEffectDesertGirasole());
		map.put(ID.PARTICLEFX_DESERTGIRASOLE2, new ParticleEffectDesertGirasole2());
		map.put(ID.PARTICLEFX_DESERTENCIERRO, new ParticleEffectDesertEncierro());
		map.put(ID.PARTICLEFX_DESERTSPADA, new ParticleEffectDesertSpada());
		
		// Ushi Bison
		map.put(ID.PARTICLEFX_KOKUTEICROSS, new ParticleEffectKokuteiCross());	
		
		// Gomu
		map.put(ID.PARTICLEFX_GEARSECOND, new ParticleEffectGearSecond());	
		
		// Tori Phoenix
		map.put(ID.PARTICLEFX_TENSEINOSOEN1, new ParticleEffectTenseiNoSoen());
		map.put(ID.PARTICLEFX_TENSEINOSOEN2, new ParticleEffectTenseiNoSoen2());
		map.put(ID.PARTICLEFX_BLUEFLAMES, new ParticleEffectBlueFlames());
		
		// Yami
		map.put(ID.PARTICLEFX_BLACKHOLE, new ParticleEffectBlackHole());
		map.put(ID.PARTICLEFX_BLACKWORLD, new ParticleEffectBlackWorld());
		map.put(ID.PARTICLEFX_DARKMATTER, new ParticleEffectDarkMatter());	
		map.put(ID.PARTICLEFX_KOROUZU, new ParticleEffectKorouzu());	
		
		// Pika 
		map.put(ID.PARTICLEFX_YATANOKAGAMI, new ParticleEffectYataNoKagami());
		map.put(ID.PARTICLEFX_AMATERASU, new ParticleEffectAmaterasu());
		map.put(ID.PARTICLEFX_FLASH, new ParticleEffectFlash());
		
		// Ito
		map.put(ID.PARTICLEFX_KUMONOSUGAKI, new ParticleEffectKumoNoSugaki());
		
		// Gura
		map.put(ID.PARTICLEFX_GEKISHIN, new ParticleEffectGekishin());
	
		// Goro
		map.put(ID.PARTICLEFX_ELTHOR, new ParticleEffectElThor());
		map.put(ID.PARTICLEFX_KARI, new ParticleEffectKari());
		map.put(ID.PARTICLEFX_RAIGO, new ParticleEffectRaigo());
		
		// Sniper
		map.put(ID.PARTICLEFX_KEMURIBOSHI, new ParticleEffectKemuriBoshi());
		
		// Rokushiki
		map.put(ID.PARTICLEFX_GEPPO, new ParticleEffectGeppo());		

		// Hie
		map.put(ID.PARTICLEFX_ICEAGE, new ParticleEffectIceAge());

		// Kilo
		map.put(ID.PARTICLEFX_KILO, new ParticleEffectHeavyPunch());
		map.put(ID.PARTICLEFX_KILOPRESS, new ParticleEffectKiloPress());
		
		// Yomi
		map.put(ID.PARTICLEFX_KASURIUTAFUBUKIGIRI, new ParticleEffectKasuriutaFubukiGiri1());
		map.put(ID.PARTICLEFX_SOULPARADE, new ParticleEffectSoulParade());
		
		return map;
	}
	
	public boolean spawnFX(EntityPlayer player, double posX, double posY, double posZ, String id)
	{
		if(Math.abs(Minecraft.getMinecraft().gameSettings.particleSetting - 2) == 0)
			return false;
		
		if(this.particleEffects.containsKey(id))
		{
			this.particleEffects.get(id).spawn(player, posX, posY, posZ);
			return true;
		}
		
		return false;
	}
	
	public HashMap<String, ParticleEffect> getParticleEffectsMap()
	{
		return particleEffects;
	}
	
}
