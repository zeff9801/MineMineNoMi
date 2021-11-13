package xyz.pixelatedw.MineMineNoMi3.api.abilities.extra;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;

public class AbilityProperties implements IExtendedEntityProperties 
{

	public final static String EXT_ABILITYPROP_NAME = ID.PROJECT_ID + "_AbilityIEEP";
	private final EntityPlayer thePlayer;
	
	private Ability[] hotbarAbilities = new Ability[8];
	private Ability[] devilFruitAbilities = new Ability[32];
	private Ability[] racialAbilities = new Ability[32];
	private Ability[] styleAbilities = new Ability[32];
	private Ability[] hakiAbilities = new Ability[16];
	
	public AbilityProperties(EntityPlayer entity) 
	{
		this.thePlayer = entity;	
	}
	
	public static final void register(EntityPlayer entity) 
	{
		entity.registerExtendedProperties(AbilityProperties.EXT_ABILITYPROP_NAME, new AbilityProperties(entity));
	}

	public static final AbilityProperties get(EntityPlayer entity) 
	{
		return (AbilityProperties) entity.getExtendedProperties(EXT_ABILITYPROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound props = new NBTTagCompound();

		for(int i = 0; i < hotbarAbilities.length; i++)
			if(this.hotbarAbilities[i] != null)
				props.setTag("hotbar_ability_" + i, saveNLOBData(this.hotbarAbilities[i]));
		
		for(int i = 0; i < devilFruitAbilities.length; i++)
			if(this.devilFruitAbilities[i] != null)
				props.setTag("devilfruits_ability_" + i, saveNLOBData(this.devilFruitAbilities[i]));
	
		for(int i = 0; i < racialAbilities.length; i++)
			if(this.racialAbilities[i] != null)
				props.setTag("racial_ability_" + i, saveNLOBData(this.racialAbilities[i]));

		for(int i = 0; i < styleAbilities.length; i++)
			if(this.styleAbilities[i] != null)
				props.setTag("style_ability_" + i, saveNLOBData(this.styleAbilities[i]));
		
		for(int i = 0; i < hakiAbilities.length; i++)
			if(this.hakiAbilities[i] != null)
				props.setTag("haki_ability_" + i, saveNLOBData(this.hakiAbilities[i]));
		
		compound.setTag(EXT_ABILITYPROP_NAME, props);
	}

	private NBTTagCompound saveNLOBData(Ability abl)
	{
		NBTTagCompound data = new NBTTagCompound();
		
		data.setString("name", abl.getAttribute().getAttributeName());
		data.setBoolean("isOnCooldown", abl.isOnCooldown());
		data.setBoolean("isCharging", abl.isCharging());
		data.setBoolean("isPassiveActive", abl.isPassiveActive());
		//data.setBoolean("isDisabled", abl.isDisabled());
		
		return data;
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound props = (NBTTagCompound) compound.getTag(EXT_ABILITYPROP_NAME);

		try
		{
			for(int i = 0; i < hotbarAbilities.length; i++)
				this.hotbarAbilities[i] = this.loadAbilityFromNLOB((NBTTagCompound) props.getTag("hotbar_ability_" + i));

			for(int i = 0; i < devilFruitAbilities.length; i++)
				this.devilFruitAbilities[i] = this.loadAbilityFromNLOB((NBTTagCompound) props.getTag("devilfruits_ability_" + i));
			
			for(int i = 0; i < racialAbilities.length; i++)
				this.racialAbilities[i] = this.loadAbilityFromNLOB((NBTTagCompound) props.getTag("racial_ability_" + i));
			
			for(int i = 0; i < styleAbilities.length; i++)
				this.styleAbilities[i] = this.loadAbilityFromNLOB((NBTTagCompound) props.getTag("style_ability_" + i));
			
			for(int i = 0; i < hakiAbilities.length; i++)
				this.hakiAbilities[i] = this.loadAbilityFromNLOB((NBTTagCompound) props.getTag("haki_ability_" + i));
		}
		catch (Exception e)
		{
			Logger.getGlobal().log(Level.SEVERE, "Ability is not registered correctly or could not be found in the master list !");
			e.printStackTrace();
		}
	}
	
	private Ability loadAbilityFromNLOB(NBTTagCompound props)
	{
		if(props == null) return null;
		
		String ablName = props.getString("name");
		
		Ability ability = null;
		try
		{
			if(AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(ablName)) != null)
			{
				ability = AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(ablName)).getClass().newInstance();
				ability.setCooldownActive(props.getBoolean("isOnCooldown"));
				ability.setChargeActive(props.getBoolean("isCharging"));			
				ability.setPassiveActive(props.getBoolean("isPassiveActive"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ability;
	}
	
	@Override
	public void init(Entity entity, World world) {}

	
	//Devil Fruits
	public boolean addDevilFruitAbility(Ability abl)
	{
		for(int i = 0; i < devilFruitAbilities.length; i++)
		{
			if(this.devilFruitAbilities[i] == null && !this.hasDevilFruitAbility(abl))
			{
				this.devilFruitAbilities[i] = abl;
				return true;
			}
		}
		
		return false;
	}
	
	public void removeDevilFruitAbility(Ability ablTemplate)
	{
		for(int i = 0; i < devilFruitAbilities.length; i++)
		{
			if(this.devilFruitAbilities[i] != null && this.devilFruitAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
			{
				this.devilFruitAbilities[i] = null;
				break;
			}
		}
	}
	
	public boolean hasDevilFruitAbility(Ability ablTemplate)
	{
		for(int i = 0; i < devilFruitAbilities.length; i++)
		{
			if(this.devilFruitAbilities[i] != null && this.devilFruitAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public Ability[] getDevilFruitAbilities()
	{ 
		return this.devilFruitAbilities; 
	}
	
	public void clearDevilFruitAbilities()
	{
		for(int i = 0; i < this.devilFruitAbilities.length; i++)
			if(this.devilFruitAbilities[i] != null)
				this.devilFruitAbilities[i] = null;
	}
		
	//Racial
	public boolean addRacialAbility(Ability abl)
	{
		for(int i = 0; i < racialAbilities.length; i++)
		{
			if(this.racialAbilities[i] == null && !this.hasRacialAbility(abl))
			{
				this.racialAbilities[i] = abl;
				return true;
			}
		}
		
		return false;
	}
	
	public void removeRacialAbility(Ability ablTemplate)
	{
		for(int i = 0; i < racialAbilities.length; i++)
		{
			if(this.racialAbilities[i] != null && this.racialAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
			{
				this.racialAbilities[i] = null;
				break;
			}
		}
	}
	
	public boolean hasRacialAbility(Ability ablTemplate)
	{
		if(ablTemplate != null)
		{
			for(int i = 0; i < racialAbilities.length; i++)
			{
				if(this.racialAbilities[i] != null && this.racialAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Ability[] getRacialAbilities()
	{ 
		return this.racialAbilities; 
	}
	
	public void clearRacialAbilities()
	{
		for(int i = 0; i < this.racialAbilities.length; i++)
			if(this.racialAbilities[i] != null)
				this.racialAbilities[i] = null;
	}
		
	//Haki
	public boolean addHakiAbility(Ability abl)
	{
		for(int i = 0; i < hakiAbilities.length; i++)
		{
			if(this.hakiAbilities[i] == null && !this.hasHakiAbility(abl))
			{
				this.hakiAbilities[i] = abl;
				return true;
			}
		}
		
		return false;
	}
	
	public void removeHakiAbility(Ability ablTemplate)
	{
		for(int i = 0; i < hakiAbilities.length; i++)
		{
			if(this.hakiAbilities[i] != null && this.hakiAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
			{
				this.hakiAbilities[i] = null;
				break;
			}
		}
	}
	
	public boolean hasHakiAbility(Ability ablTemplate)
	{
		return Arrays.stream(this.hakiAbilities).filter(x -> x != null && x.getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName())).findFirst().orElse(null) != null;
	}
	
	public Ability[] getHakiAbilities()
	{ 
		return this.hakiAbilities; 
	}
	
	public void clearHakiAbilities()
	{
		for(int i = 0; i < this.hakiAbilities.length; i++)
			if(this.hakiAbilities[i] != null)
				this.hakiAbilities[i] = null;
	}
	
	
	//Hotbar
	public Ability[] getAbilitiesInHotbar()
	{
		return this.hotbarAbilities;
	}
	
	public boolean hasAbilityInHotbar(Ability ability)
	{
		return this.hasAbilityInHotbar(ability.getAttribute().getAttributeName());
	}
	
	public boolean hasAbilityInHotbar(String abilityName)
	{
		return Arrays.stream(this.hotbarAbilities).filter(x -> x != null && x.getAttribute().getAttributeName().equalsIgnoreCase(abilityName)).findFirst().orElse(null) != null;
	}
	
	public void setAbilityInSlot(int slot, Ability abl)
	{
		this.hotbarAbilities[slot] = abl;
	}
	
	public Ability getAbilityFromSlot(int slot)
	{
		return this.hotbarAbilities[slot];
	}
	
	public Ability getAbilityFromName(String name)
	{
		return Arrays.stream(this.getAbilitiesInHotbar()).filter(x -> 
		{
			return x != null && x.getAttribute() != null && x.getAttribute().getAttributeName().equalsIgnoreCase(name);
		}).findFirst().orElse(null);     
	}
	
	public int countAbilitiesInHotbar()
	{
		return this.hotbarAbilities.length;
	}
	
	public void clearHotbar()
	{
		for(int i = 0; i < this.hotbarAbilities.length; i++)
			if(this.hotbarAbilities[i] != null)
			{
				if(this.hotbarAbilities[i].isPassiveActive())
					this.hotbarAbilities[i].endPassive(thePlayer);
				
				this.hotbarAbilities[i] = null;
			}
	}
}
