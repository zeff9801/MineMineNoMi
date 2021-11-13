package xyz.pixelatedw.MineMineNoMi3.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.CyborgAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.DoctorAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.FishKarateAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SniperAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SwordsmanAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeatherAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectHaoHaki;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.events.customevents.EventDoriki;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketShounenScream;

public class DevilFruitsHelper
{

	private static String[][] zoanModels = new String[][]
	{
			{
				"ushiushibison", "bison"
			},
			{
				"toritoriphoenix", "phoenix"
			},
			{
				"ushiushigiraffe", "giraffe"
			},
	};

	public static String[] flyingFruits = new String[]
	{
			"gasugasu", "sunasuna", "mokumoku"
	};

	private static HashMap<String, List<Block>> blockRules = createBlockRulesMap();
	
	private static HashMap<String, List<Block>> createBlockRulesMap()
	{
		HashMap<String, List<Block>> map = new HashMap<String, List<Block>>();
		
		map.put("core", Arrays.asList(new Block[]
				{
						Blocks.ice, Blocks.packed_ice, Blocks.stone, Blocks.grass, Blocks.dirt, Blocks.snow, Blocks.snow_layer, Blocks.sand, Blocks.sandstone, Blocks.sandstone_stairs, Blocks.wooden_door, 
						Blocks.wooden_slab, Blocks.log, Blocks.log2, Blocks.carpet, Blocks.cake, ListMisc.Poison, ListMisc.DemonPoison, Blocks.torch, Blocks.redstone_torch, Blocks.redstone_wire, 
						Blocks.cobblestone, Blocks.fence, Blocks.farmland, Blocks.fence_gate, Blocks.flower_pot, Blocks.clay, Blocks.gravel, ListMisc.SunaSand, ListMisc.WaxBlock
				}));
		
		map.put("air", Arrays.asList(new Block[]
				{
						Blocks.air
				}));

		map.put("foliage", Arrays.asList(new Block[]
				{
						Blocks.leaves, Blocks.leaves2, Blocks.waterlily, Blocks.double_plant, Blocks.yellow_flower, Blocks.red_flower, Blocks.vine, Blocks.brown_mushroom, Blocks.brown_mushroom_block, Blocks.red_mushroom, Blocks.red_mushroom_block, Blocks.tallgrass, Blocks.potatoes, Blocks.carrots, Blocks.cactus, Blocks.deadbush
				}));
		
		map.put("ores", Arrays.asList(new Block[]
				{
						Blocks.coal_ore, Blocks.coal_block, Blocks.diamond_ore, Blocks.diamond_block, Blocks.iron_ore, Blocks.iron_block, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.redstone_block, Blocks.gold_ore, Blocks.gold_block, ListMisc.KairosekiOre, ListMisc.KairosekiBlock
				}));

		map.put("liquids", Arrays.asList(new Block[]
				{
						Blocks.water, Blocks.flowing_water, Blocks.lava, Blocks.flowing_lava
				}));
		
		return map;
	}
	
	public static void haoAttackEntities(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);

		for(EntityLivingBase target : WyHelper.getEntitiesNear(player, 100))
		{
			double userHakiExp = (props.getHardeningHakiExp() * 3) + (props.getImbuingHakiExp() * 3) + (props.getObservationHakiExp() * 3);
			double targetHakiExp = 0;
			boolean hasBlindness = false;
			
			if(target instanceof EntityPlayer)
			{
				ExtendedEntityData propz = ExtendedEntityData.get(target);
				targetHakiExp = (propz.getHardeningHakiExp() * 3) + (propz.getImbuingHakiExp() * 3) + (propz.getObservationHakiExp() * 3);			
			}
			else if(target instanceof EntityNewMob)
				targetHakiExp = ((EntityNewMob) target).getDoriki();
			else if(target.getEntityAttribute(SharedMonsterAttributes.attackDamage) != null)
				targetHakiExp = target.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
			
			if(targetHakiExp < (userHakiExp / 1.5))
			{
				int duration = (int) (((userHakiExp / 1.5) - targetHakiExp) * 20);
				if(duration > 2000)
					duration = 2000;
				
				target.addPotionEffect(new PotionEffect(Potion.weakness.id, duration, 1));
				target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, duration, 1));
				target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, duration, 5));
				target.addPotionEffect(new PotionEffect(Potion.confusion.id, duration, 1));
				target.addPotionEffect(new PotionEffect(Potion.jump.id, duration, -5));

				if(targetHakiExp < (userHakiExp / 2))
				{
					target.addPotionEffect(new PotionEffect(Potion.blindness.id, duration, 1));
					target.addPotionEffect(new PotionEffect(Potion.hunger.id, duration, 1));
					target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, duration, 500));
					hasBlindness = true;
					new DFEffectHaoHaki(target, duration + 200);
				}
			}
			
			if(!hasBlindness)
				new DFEffectHaoHaki(target, 100);				
		}
	}
	
	public static int getParticleSettingModifier(int defaultAmount)
	{
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			return 0;
		
		int modifier = Math.abs(Minecraft.getMinecraft().gameSettings.particleSetting - 2);
		
		switch(modifier)
		{
			case 2:
				return defaultAmount;
			case 1:
				return defaultAmount / 2;
			case 0:
				return 0;
				
			default:
				return defaultAmount;
		}
	}
	
	public static void sendShounenScream(EntityPlayer player, String ability, int part)
	{
		if(MainConfig.enableAnimeScreaming)
    		WyNetworkHelper.sendToAllAround(new PacketShounenScream(player.getCommandSenderName(), ability, part), player.dimension, player.posX, player.posY, player.posZ, 15);
	}

	public static boolean canUseSwordsmanAbilities(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		Ability sparClaw = AbilityProperties.get(player).getAbilityFromName(ListAttributes.SPAR_CLAW.getAttributeName());
		
		if(props.getUsedFruit().equalsIgnoreCase("supasupa") && sparClaw != null && sparClaw.isPassiveActive())
		{
			return true;
		}		
		
		return false;
	}
	
	public static boolean checkForRestriction(EntityPlayer player)
	{
		ExtendedWorldData worldData = ExtendedWorldData.get(player.worldObj);

		if(worldData.isInsideRestrictedArea((int)player.posX, (int)player.posY, (int)player.posZ))
		{
			WyHelper.sendMsgToPlayer(player, "Cannot use abilites in a restricted area !");
			return true;
		}

		return false;
	}
		
	public static boolean isDevilFruitInWorld(World world, String devilFruitName)
	{
		ExtendedWorldData worldData = ExtendedWorldData.get(world);

		if(worldData.isDevilFruitInWorld(devilFruitName))
			return true;
		
		return false;
	}
	
	public static boolean isDevilFruitInWorld(World world, AkumaNoMi devilFruit)
	{
		if(devilFruit == null)
			return true;
		
		ExtendedWorldData worldData = ExtendedWorldData.get(world);
		String name = devilFruit.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", "");
		
		if(worldData.isDevilFruitInWorld(name))
			return true;
		
		return false;
	}
	
	public static boolean isAffectedByWater(EntityLivingBase entity)
	{
		Block level1Block = entity.worldObj.getBlock((int) entity.posX, (int) entity.posY - 1, (int) entity.posZ);
		Block level2Block = entity.worldObj.getBlock((int) entity.posX, (int) entity.posY - 2, (int) entity.posZ);
		if(entity.isInsideOfMaterial(Material.water) ||
				(entity.isWet() && !entity.isRiding() && 
				((level1Block == Blocks.water || level1Block == Blocks.flowing_water) && (level2Block == Blocks.water || level2Block == Blocks.flowing_water)) ))
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean isNearbyKairoseki(EntityPlayer player)
	{
		if (WyHelper.isBlockNearby(player, 4, ListMisc.KairosekiBlock, ListMisc.KairosekiOre, ListMisc.KairosekiBars) || ItemsHelper.hasKairosekiItem(player) || player.inventory.hasItem(Item.getItemFromBlock(ListMisc.KairosekiBlock)) || player.inventory.hasItem(Item.getItemFromBlock(ListMisc.KairosekiOre)) || player.inventory.hasItem(Item.getItemFromBlock(ListMisc.KairosekiBars))  || isAffectedByWater(player))
		{
			return true;
		}

		return false;
	}

	public static void verifyAndGiveAbility(Ability a, AbilityProperties abilityProps)
	{
		if(!verifyIfAbilityIsBanned(a))
			abilityProps.addRacialAbility(a);
	}
	
	public static boolean verifyIfAbilityIsBanned(Ability a)
	{
		for (String str : MainConfig.abilityRestrictions)
		{
			if (WyHelper.getFancyName(str).contains(WyHelper.getFancyName(a.getAttribute().getAttributeName())))
				return true;
		}

		return false;
	}

	public static void validateRacialMoves(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);

		EventDoriki e = new EventDoriki(player);
		if (MinecraftForge.EVENT_BUS.post(e))
			return;

		List<Ability> tempAblList = new ArrayList<Ability>();

		if (props.isHuman())
			for (Ability a : RokushikiAbilities.abilitiesArray)
				if (abilityProps.hasRacialAbility(a) && !verifyIfAbilityIsBanned(a))
					tempAblList.add(a);

		if (props.isFishman())
			for (Ability a : FishKarateAbilities.abilitiesArray)
				if (abilityProps.hasRacialAbility(a) && !verifyIfAbilityIsBanned(a))
					tempAblList.add(a);

		if (props.isCyborg())
			for (Ability a : CyborgAbilities.abilitiesArray)
				if (abilityProps.hasRacialAbility(a) && !verifyIfAbilityIsBanned(a))
					tempAblList.add(a);

		abilityProps.clearRacialAbilities();

		for (Ability a : tempAblList)
			abilityProps.addRacialAbility(a);

		tempAblList.clear();

		for (Ability a : HakiAbilities.abilitiesArray)
			if (abilityProps.hasHakiAbility(a) && !verifyIfAbilityIsBanned(a))
				tempAblList.add(a);

		abilityProps.clearHakiAbilities();

		for (Ability a : tempAblList)
			abilityProps.addHakiAbility(a);
	}

	public static void validateStyleMoves(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		QuestProperties questProps = QuestProperties.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);

		if (props.isSwordsman())
		{
			verifyAndGiveAbility(SwordsmanAbilities.SHI_SHISHI_SONSON, abilityProps);

			if (MainConfig.enableQuestProgression)
			{
				if (questProps.hasQuestCompleted(ListQuests.swordsmanProgression04) && !verifyIfAbilityIsBanned(SwordsmanAbilities.SANBYAKUROKUJU_POUND_HO))
					abilityProps.addRacialAbility(SwordsmanAbilities.SANBYAKUROKUJU_POUND_HO);
			}
			else
			{
				verifyAndGiveAbility(SwordsmanAbilities.SANBYAKUROKUJU_POUND_HO, abilityProps);
				verifyAndGiveAbility(SwordsmanAbilities.YAKKODORI, abilityProps);
				verifyAndGiveAbility(SwordsmanAbilities.OTATSUMAKI, abilityProps);
			}
		}
		else if (props.isSniper())
		{
			verifyAndGiveAbility(SniperAbilities.KAEN_BOSHI, abilityProps);

			if (MainConfig.enableQuestProgression)
			{

			}
			else
			{
				verifyAndGiveAbility(SniperAbilities.KEMURI_BOSHI, abilityProps);
				verifyAndGiveAbility(SniperAbilities.RENPATSU_NAMARI_BOSHI, abilityProps);
				verifyAndGiveAbility(SniperAbilities.SAKURETSU_SABOTEN_BOSHI, abilityProps);
			}
		}
		else if (props.isMedic())
		{
			verifyAndGiveAbility(DoctorAbilities.FIRST_AID, abilityProps);
			verifyAndGiveAbility(DoctorAbilities.MEDIC_BAG_EXPLOSION, abilityProps);
			verifyAndGiveAbility(DoctorAbilities.FAILED_EXPERIMENT, abilityProps);
		}
		else if (props.isWeatherWizard())
		{
			verifyAndGiveAbility(WeatherAbilities.HEAT_BALL, abilityProps);
			verifyAndGiveAbility(WeatherAbilities.COOL_BALL, abilityProps);
			verifyAndGiveAbility(WeatherAbilities.THUNDER_BALL, abilityProps);

			if (MainConfig.enableQuestProgression)
			{

			}
			else
			{
				verifyAndGiveAbility(WeatherAbilities.GUST_SWORD, abilityProps);
				verifyAndGiveAbility(WeatherAbilities.WEATHER_EGG, abilityProps);
			}
		}
	}

	public static boolean isSniperAbility(Ability abl)
	{
		for (Ability a : SniperAbilities.abilitiesArray)
		{
			if (abl.getAttribute().getAttributeName().equalsIgnoreCase(a.getAttribute().getAttributeName()))
				return true;
		}

		return false;
	}

	/**
	 * Will place a given block in the given positions IF the block it tries to
	 * replace can be replaced given some rules
	 * 
	 * rule format : "add core", "ignore core", if no formula (add, ignore) is
	 * specified "add" will be the default choice
	 * 
	 * core - basic blocks that will always be replaceable either due to their low value or commonness 
	 * air - specific filter for the air block 
	 * ores - self explanatory, also includes the compressed blocks for those ores
	 * foliage - things like flowers, vines and leaves 
	 * liquids - water and lava
	 * all - all blocks 
	 * restricted - removes some blocks that should never be replaced, has no use for add/ignore param
	 * 
	 * nogrief is used for abilities that should place blocks even if griefing is disabled, room or torikago for example
	 */
	
	public static boolean placeBlockIfAllowed(World world, int posX, int posY, int posZ, Block toPlace, int flag, String... rules)
	{
		return placeBlockIfAllowed(world, posX, posY, posZ, toPlace, 0, flag, rules);
	}
	
	public static boolean placeBlockIfAllowed(World world, int posX, int posY, int posZ, Block toPlace, String... rules)
	{
		return placeBlockIfAllowed(world, posX, posY, posZ, toPlace, 0, 3, rules);
	}
	
	public static boolean placeBlockIfAllowed(World world, int posX, int posY, int posZ, Block toPlace, int meta, int flag, String... rules)
	{
		Block b = world.getBlock(posX, posY, posZ);
		List<Block> bannedBlocks = new ArrayList<Block>();
		boolean noGriefFlag = Arrays.toString(rules).contains("nogrief");
		
		ExtendedWorldData worldData = ExtendedWorldData.get(world);

		if(worldData.isInsideRestrictedArea(posX, posY, posZ))
			return false;		
		
		Arrays.stream(rules).forEach(rule ->
		{
			String formula;
			if (rule.split(" ").length > 1)
			{
				formula = rule.split(" ")[0];
				rule = rule.split(" ")[1];
			}
			else
				formula = "add";
			
			if(blockRules.containsKey(rule))
			{
				if (formula.equalsIgnoreCase("add"))
					bannedBlocks.addAll(blockRules.get(rule));
				else if (formula.equalsIgnoreCase("ignore"))
					bannedBlocks.removeAll(blockRules.get(rule));
			}			

			if (rule.equalsIgnoreCase("all"))
			{
				if (formula.equalsIgnoreCase("add"))
				{
					Block.blockRegistry.forEach(block ->
					{
						bannedBlocks.add((Block) block);
					});
				}
				else if (formula.equalsIgnoreCase("ignore"))
				{
					Block.blockRegistry.forEach(block ->
					{
						bannedBlocks.remove(block);
					});
				}
			}
			else if (rule.equalsIgnoreCase("restricted"))
			{
				bannedBlocks.remove(Blocks.bedrock);
				bannedBlocks.remove(ListMisc.Ope);
				bannedBlocks.remove(ListMisc.OpeMid);
				bannedBlocks.remove(ListMisc.StringMid);
				bannedBlocks.remove(ListMisc.StringWall);
				bannedBlocks.remove(ListMisc.Darkness);
			}

		});

		if(MainConfig.enableGriefing || noGriefFlag)
		{
			for (Block blk : bannedBlocks)
			{
				if (b == blk)
				{
					world.setBlock(posX, posY, posZ, toPlace, meta, flag);
					return true;
				}
			}
		}

		return false;
	}

	public static ItemStack getDevilFruitItem(String fullName)
	{
		String model = "";
		String fullModel = "";

		for (String[] s : zoanModels)
		{
			if (fullName.equals(s[0]))
			{
				model = s[1];
				fullModel = "model" + model;
				break;
			}
		}

		if (fullName.equals("yamidummy"))
			fullName = "yamiyami";

		return new ItemStack(GameRegistry.findItem(ID.PROJECT_ID, fullName.replace(model, "") + "nomi" + fullModel));
	}

	public static boolean isEntityInRoom(EntityLivingBase entity)
	{
		for (int i = -20; i < 20; i++)
			for (int j = -20; j < 20; j++)
				for (int k = -20; k < 20; k++)
				{
					if (entity.worldObj.getBlock((int) entity.posX + i, (int) entity.posY + j, (int) entity.posZ + k) == ListMisc.OpeMid)
						return true;
				}

		return false;
	}

	public static int getRegenFromPoision(EntityLivingBase entity)
	{
		return entity.getActivePotionEffect(Potion.poison).getAmplifier() / 5;
	}

}
