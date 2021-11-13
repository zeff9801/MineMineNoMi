package xyz.pixelatedw.MineMineNoMi3.lists;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import xyz.pixelatedw.MineMineNoMi3.MainKeys;
import xyz.pixelatedw.MineMineNoMi3.events.EventsBounty;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCombatMode;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCore;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCrafting;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCrew;
import xyz.pixelatedw.MineMineNoMi3.events.EventsDrops;
import xyz.pixelatedw.MineMineNoMi3.events.EventsEnchantments;
import xyz.pixelatedw.MineMineNoMi3.events.EventsHakiGain;
import xyz.pixelatedw.MineMineNoMi3.events.EventsMorphs;
import xyz.pixelatedw.MineMineNoMi3.events.EventsOnGain;
import xyz.pixelatedw.MineMineNoMi3.events.EventsQuestsProgress;
import xyz.pixelatedw.MineMineNoMi3.events.EventsSpecialEffects;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsAbilityValidation;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsDFWeaknesses;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsEffectOverlay;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsLogiaInvulnerability;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsOneDevilFruit;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsPassives;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsSpecialFlying;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsZoanPassives;

public class ListForge 
{

	public static void init()
	{
		// Handles some core features of the mod, like IEEP registrations, update notifications or Early Access protection 		
		MinecraftForge.EVENT_BUS.register(new EventsCore());
		FMLCommonHandler.instance().bus().register(new EventsCore());
		
		// Handles different event driven logic about crew members
		MinecraftForge.EVENT_BUS.register(new EventsCrew());
		
		// Handles any bounty/wanted poster related event
		MinecraftForge.EVENT_BUS.register(new EventsBounty());
		FMLCommonHandler.instance().bus().register(new EventsBounty());
		
		// Handles the drop events from different sources
		MinecraftForge.EVENT_BUS.register(new EventsDrops());
		
		// Handles the crafting events, only anvil logic
		MinecraftForge.EVENT_BUS.register(new EventsCrafting());
		
		// Handles the custom enchantment effects added by this mod
		MinecraftForge.EVENT_BUS.register(new EventsEnchantments());
		
		// Handles all the custom onGain events added by this mod
		MinecraftForge.EVENT_BUS.register(new EventsOnGain());

		// Handles the logic behind the new haki system, exp system and gaining abilities
		MinecraftForge.EVENT_BUS.register(new EventsHakiGain());
		
		// Handles all the custom effects like kairoseki and dial related enchantments
		MinecraftForge.EVENT_BUS.register(new EventsSpecialEffects());
		
		// Handles the quest related stuff, accepting quests or progressing them throught different means
		MinecraftForge.EVENT_BUS.register(new EventsQuestsProgress());
		
		// Handles the logic when the config option is true
		MinecraftForge.EVENT_BUS.register(new EventsOneDevilFruit());
		
		// Core devil fruit events
		MinecraftForge.EVENT_BUS.register(new EventsAbilityValidation());
		MinecraftForge.EVENT_BUS.register(new EventsDFWeaknesses());
		MinecraftForge.EVENT_BUS.register(new EventsSpecialFlying());
		MinecraftForge.EVENT_BUS.register(new EventsLogiaInvulnerability());
		MinecraftForge.EVENT_BUS.register(new EventsZoanPassives());
		MinecraftForge.EVENT_BUS.register(new EventsPassives());
		
		// Handles client sided stuff only
		if (FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			// Devil Fruit related client-sided events
			MinecraftForge.EVENT_BUS.register(new EventsEffectOverlay());
			FMLCommonHandler.instance().bus().register(new EventsEffectOverlay());

			// Handles Combat Mode GUI (including extra hearts, cola bar and obviously the ability slots) and the FOV remover
			MinecraftForge.EVENT_BUS.register(new EventsCombatMode(Minecraft.getMinecraft()));
			
			// Morphing related code including both full body model and 1st person hand
			MinecraftForge.EVENT_BUS.register(new EventsMorphs(Minecraft.getMinecraft()));
			FMLCommonHandler.instance().bus().register(new EventsMorphs(Minecraft.getMinecraft()));
			
			// Custom Keys
			FMLCommonHandler.instance().bus().register(new MainKeys());
			MainKeys.init();
		}
	}
	
}
