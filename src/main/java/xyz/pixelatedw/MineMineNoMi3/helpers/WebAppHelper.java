package xyz.pixelatedw.MineMineNoMi3.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.CyborgAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.FishKarateAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SniperAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SwordsmanAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeatherAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class WebAppHelper
{
	
	public static void generateWebAppJSONs()
	{
		WebAppHelper.writeFancyAbilitiesList();

		File folder = new File(Values.RESOURCES_FOLDER + "/assets/" + ID.PROJECT_ID + "/EXTRA_BOT_FILES/");
		folder.mkdirs();

		if (folder.exists())
		{
			WebAppHelper.writeDevilFruitsJSON();

			WebAppHelper.writeSpecialAbilitiesJSON();
		}
	}

	private static void writeDevilFruitsJSON()
	{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + ID.PROJECT_ID + "/EXTRA_BOT_FILES/devilfruits.json"), "UTF-8")))
		{
			writer.write("{\n");
			writer.write("\"devilfruits\" : [");

			for (Item f : Values.devilfruits)
			{
				AkumaNoMi fruit = (AkumaNoMi) f;
				ItemStack itemStack = new ItemStack(GameRegistry.findItem(ID.PROJECT_ID, fruit.getUnlocalizedName().substring(5)));
				Map<String, Object> devilFruitElements = new LinkedHashMap<String, Object>();

				devilFruitElements.put("name", "\"" + itemStack.getDisplayName() + "\"");
				devilFruitElements.put("type", "\"" + fruit.getType().getName() + "\"");
				devilFruitElements.put("abilities", "[ " + WebAppHelper.generateAbilitiesString(fruit.abilities) + " ]");

				writer.write("{ ");
				for (String devilFruitKey : devilFruitElements.keySet())
				{
					Object key = devilFruitElements.get(devilFruitKey);
					if (key instanceof String)
						writer.write("\"" + devilFruitKey + "\": " + key + ", ");

				}
				writer.write("},\n");
			}

			writer.write("]}");

			writer.close();
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}

	private static void writeSpecialAbilitiesJSON()
	{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + ID.PROJECT_ID + "/EXTRA_BOT_FILES/specialabilities.json"), "UTF-8")))
		{

			writer.write("{\n");
			writer.write("\"specialabilities\" : [");

			// Human Collection
			Ability[] humanAbilities = Stream.of(RokushikiAbilities.abilitiesArray, HakiAbilities.abilitiesArray).flatMap(Stream::of).toArray(Ability[]::new);
			writer.write("{ \"name\": \"Human\", \"type\": \"n/a\", \"abilities\": [ " + WebAppHelper.generateAbilitiesString(humanAbilities) + " ]},\n");

			// Fishman Collection
			Ability[] fishmanAbilities = Stream.of(FishKarateAbilities.abilitiesArray, HakiAbilities.abilitiesArray).flatMap(Stream::of).toArray(Ability[]::new);
			writer.write("{ \"name\": \"Fishman\", \"type\": \"n/a\", \"abilities\": [ " + WebAppHelper.generateAbilitiesString(fishmanAbilities) + " ]},\n");

			// Cybord Collection
			Ability[] cyborgAbilities = Stream.of(CyborgAbilities.abilitiesArray, HakiAbilities.abilitiesArray).flatMap(Stream::of).toArray(Ability[]::new);
			writer.write("{ \"name\": \"Cyborg\", \"type\": \"n/a\", \"abilities\": [ " + WebAppHelper.generateAbilitiesString(cyborgAbilities) + " ]},\n");

			// Swordsman Collection
			writer.write("{ \"name\": \"Swordsman\", \"type\": \"n/a\", \"abilities\": [ " + WebAppHelper.generateAbilitiesString(SwordsmanAbilities.abilitiesArray) + " ]},\n");

			// Sniper Collection
			writer.write("{ \"name\": \"Sniper\", \"type\": \"n/a\", \"abilities\": [ " + WebAppHelper.generateAbilitiesString(SniperAbilities.abilitiesArray) + " ]},\n");

			// Art of Weather Collection
			writer.write("{ \"name\": \"Art of Weather\", \"type\": \"n/a\", \"abilities\": [ " + WebAppHelper.generateAbilitiesString(WeatherAbilities.abilitiesArray) + " ]},\n");
		
			writer.write("]}");

			writer.close();
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}

	private static void writeFancyAbilitiesList()
	{
		File folder = new File(Values.RESOURCES_FOLDER + "/assets/" + ID.PROJECT_ID + "/EXTRA_BOT_FILES/");
		folder.mkdirs();

		if (folder.exists())
		{
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + ID.PROJECT_ID + "/EXTRA_BOT_FILES/fancylist.txt"), "UTF-8")))
			{
				for (AkumaNoMi devilFruit : Values.devilfruits)
				{
					writer.write(devilFruit.getItemStackDisplayName(new ItemStack(devilFruit)) + "\n");
					for (Ability ability : devilFruit.abilities)
					{
						writer.write("> " + ability.getAttribute().getAbilityDisplayName() + "\n");
					}
					writer.write("\n");
				}
			}
			catch (Exception e)
			{
				e.getStackTrace();
			}
		}
	}

	private static String generateAbilitiesString(Ability[] abilities)
	{
		StringBuilder abilitiesString = new StringBuilder();

		for (Ability ability : abilities)
		{
			boolean hasDescription = false;
			StringBuilder abilityString = new StringBuilder();
			abilityString.append("{ ");

			Map<String, Object> loadedParams = new LinkedHashMap<String, Object>();
			AbilityAttribute abilityAttribute = ability.getAttribute();

			
			loadedParams.put("name", abilityAttribute.getAbilityDisplayName());
			loadedParams.put("texture", WyHelper.getFancyName(abilityAttribute.getAbilityTexture()));

			if (abilityAttribute.getAbilityCooldown() > 0)
				loadedParams.put("cooldown", abilityAttribute.getAbilityCooldown() / 20);
			if (abilityAttribute.getAbilityCharges() > 0)
				loadedParams.put("chargeTime", abilityAttribute.getAbilityCharges() / 20);
			if (abilityAttribute.getProjectileDamage() > 1)
				loadedParams.put("projectileDamage", abilityAttribute.getProjectileDamage());
			if (abilityAttribute.hasProjectile() && abilityAttribute.isRepeater())
				loadedParams.put("projectileNumber", (abilityAttribute.getAbilityCooldown() / abilityAttribute.getAbilityRepeaterTime()) / abilityAttribute.getAbilityRepeaterTime());
			if (abilityAttribute.getProjectileExplosionPower() > 0)
				loadedParams.put("projectileExplosion", abilityAttribute.getProjectileExplosionPower());

			if (abilityAttribute.getPotionEffectsForAoE() != null && abilityAttribute.getPotionEffectsForAoE().length > 0)
				loadedParams.put("aoeEffects", "[" + WebAppHelper.getPotionEffectsFor(abilityAttribute.getPotionEffectsForAoE()) + "]");
			if (abilityAttribute.getPotionEffectsForProjectile() != null && abilityAttribute.getPotionEffectsForProjectile().length > 0)
				loadedParams.put("onHitEffects", "[" + WebAppHelper.getPotionEffectsFor(abilityAttribute.getPotionEffectsForProjectile()) + "]");
			if (abilityAttribute.getPotionEffectsForUser() != null && abilityAttribute.getPotionEffectsForUser().length > 0)
				loadedParams.put("selfEffects", "[" + WebAppHelper.getPotionEffectsFor(abilityAttribute.getPotionEffectsForUser()) + "]");

			for (String manualParamKey : Values.abilityWebAppExtraParams.keySet())
			{
				if (WyHelper.getFancyName(abilityAttribute.getAttributeName()).equalsIgnoreCase(manualParamKey))
				{
					String[] params = Values.abilityWebAppExtraParams.get(manualParamKey);

					for (int j = 0; j < params.length; j++)
					{
						String param = params[j];
						Object paramValue = params[++j];

						if(param.equalsIgnoreCase("desc"))
							hasDescription = true;
						
						try
						{
							paramValue = Integer.parseInt((String) paramValue);
						}
						catch (Exception e)
						{
						}

						if (loadedParams.containsKey(param))
							loadedParams.replace(param, paramValue);
						else
							loadedParams.put(param, paramValue);
					}
				}
			}

			for (String loadedParamKey : loadedParams.keySet())
			{
				Object key = loadedParams.get(loadedParamKey);
				if ((key instanceof Integer || key instanceof Double || key instanceof Float) || (loadedParamKey.equalsIgnoreCase("aoeEffects") || loadedParamKey.equalsIgnoreCase("onHitEffects") || loadedParamKey.equalsIgnoreCase("selfEffects")))
					abilityString.append("\"" + loadedParamKey + "\": " + key + ",");
				else if (loadedParams.get(loadedParamKey) instanceof String)
					abilityString.append("\"" + loadedParamKey + "\": \"" + key + "\",");
			}

			abilityString.append("},");
			abilitiesString.append(abilityString.toString());
			
			if(!hasDescription)
				System.out.println("Ability without description : " + ability.getAttribute().getAbilityDisplayName());
		}

		return abilitiesString.toString();
	}

	private static String getPotionEffectsFor(PotionEffect[] pe)
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < pe.length; i++)
		{
			double d = Math.ceil(((double) pe[i].getDuration() / 24));

			if (i < pe.length - 1)
				builder.append("\"" + I18n.format(pe[i].getEffectName()) + " " + String.format("%.0f", d) + " " + (d == 1 ? "second" : "seconds") + " (" + (pe[i].getAmplifier() > 0 ? "+" : "-") + ")\", ");
			else
				builder.append("\"" + I18n.format(pe[i].getEffectName()) + " " + String.format("%.0f", d) + " " + (d == 1 ? "second" : "seconds") + " (" + (pe[i].getAmplifier() > 0 ? "+" : "-") + ")\"");
		}
		String potionList = builder.toString();

		return potionList;
	}

}
