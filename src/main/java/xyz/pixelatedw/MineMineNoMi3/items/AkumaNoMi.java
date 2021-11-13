package xyz.pixelatedw.MineMineNoMi3.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.EnumFruitType;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.FishKarateAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListCreativeTabs;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class AkumaNoMi extends ItemFood
{

	public EnumFruitType type;
	public Item ability1, ability2, ability3, ability4;
	public Ability[] abilities;

	public AkumaNoMi(EnumFruitType type, Ability... abilitiesArray)
	{
		super(0, false);
		this.maxStackSize = 1;
		this.type = type;
		this.abilities = abilitiesArray;
		this.setCreativeTab(ListCreativeTabs.tabDevilFruits);
		this.setAlwaysEdible();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		player.setItemInUse(itemStack, itemUseDuration);
		return itemStack;
	}

    @Override
	public boolean onEntityItemUpdate(EntityItem entityItem)
    {
    	ExtendedWorldData worldProps = ExtendedWorldData.get(entityItem.worldObj);

    	if( entityItem.isBurning())
    		worldProps.removeDevilFruitFromWorld(this);
    	
        return false;
    }
	
	@Override
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);
		ExtendedWorldData worldProps = ExtendedWorldData.get(world);

		String eatenFruit = this.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", "");

		boolean flag1 = !props.getUsedFruit().equalsIgnoreCase("n/a") && !props.hasYamiPower() && !eatenFruit.equalsIgnoreCase("yamiyami");
		boolean flag2 = props.hasYamiPower() && !eatenFruit.equalsIgnoreCase(props.getUsedFruit()) && !props.getUsedFruit().equalsIgnoreCase("yamidummy");
		boolean flag3 = !MainConfig.enableYamiSpecialPower && !props.getUsedFruit().equalsIgnoreCase("n/a") && (eatenFruit.equalsIgnoreCase("yamiyami") || !eatenFruit.equalsIgnoreCase(props.getUsedFruit()));

		if (flag1 || flag2 || flag3)
		{
			player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);
			return;
		}

		if (!eatenFruit.equalsIgnoreCase("yamiyami"))
			props.setUsedFruit(eatenFruit);

		if (this.type == EnumFruitType.LOGIA)
			props.setIsLogia(true);

		if (eatenFruit.equalsIgnoreCase("yamiyami"))
		{
			props.setIsLogia(false);
			
			props.setYamiPower(true);
			
			if (props.getUsedFruit().equalsIgnoreCase("n/a"))
				props.setUsedFruit("yamidummy");
		}

		if (eatenFruit.equalsIgnoreCase("hitohito") && !player.worldObj.isRemote)
		{
			WyHelper.sendMsgToPlayer(player, "You've gained some enlightenment");
			if (props.isFishman())
			{
				props.setRace(ID.RACE_HUMAN);
				
				for (int i = 0; i < 8; i++)
				{
					Ability abl = abilityProps.getAbilityFromSlot(i);
					for (Ability fshAbl : FishKarateAbilities.abilitiesArray)
					{
						if (abl != null && abl.getAttribute().getAttributeName().equalsIgnoreCase(fshAbl.getAttribute().getAttributeName()))
							abilityProps.setAbilityInSlot(i, null);
					}
				}
				
				DevilFruitsHelper.validateStyleMoves(player);
				DevilFruitsHelper.validateRacialMoves(player);
				WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);
			}
		}

		if(MainConfig.enableOneFruitPerWorld && !worldProps.isDevilFruitInWorld(eatenFruit))
			worldProps.addDevilFruitInWorld(eatenFruit);
		
		if(!props.getUsedFruit().equalsIgnoreCase("yomiyomi"))
			for(Ability a : abilities)
				if(!DevilFruitsHelper.verifyIfAbilityIsBanned(a) && !abilityProps.hasDevilFruitAbility(a))
					abilityProps.addDevilFruitAbility(a);
		
		if(!world.isRemote)
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		if(!world.isRemote && !player.capabilities.isCreativeMode)
			WyTelemetry.addDevilFruitStat(props.getUsedFruit(), (String) WyRegistry.getItemsMap().get(this), 1);
		
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		for (int i = 0; i < this.abilities.length; i++)
			if (!DevilFruitsHelper.verifyIfAbilityIsBanned(this.abilities[i]) && this.abilities[i] != null)
				list.add(I18n.format("ability." + WyHelper.getFancyName(this.abilities[i].getAttribute().getAttributeName()) + ".name"));

		list.add("");
		list.add(type.getColor() + type.getName());
	}

	public EnumFruitType getType()
	{
		return type;
	}

}
