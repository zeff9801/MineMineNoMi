package xyz.pixelatedw.MineMineNoMi3.items.weapons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class ItemAbilityWeapon extends ItemCoreWeapon
{
	private double damage = 1;
	private PotionEffect[] effects;
	
	public ItemAbilityWeapon(int damage)
	{
		super(damage);
		this.damage = damage;
		this.maxStackSize = 1;
		this.setFull3D();
	}

	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) 
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer owner = (EntityPlayer) entity;		
			ExtendedEntityData props = ExtendedEntityData.get(owner);
			AbilityProperties abilityProps = AbilityProperties.get(owner);

			if(props.getUsedFruit().equals("hiehie") || props.getUsedFruit().equals("pikapika") || props.getUsedFruit().equals("noronoro") || props.getUsedFruit().equals("dorudoru")
					|| props.getUsedFruit().equals("gasugasu") || props.getUsedFruit().equals("yukiyuki"))
			{
				for(int i = 0; i < abilityProps.countAbilitiesInHotbar(); i++)
				{
					if(abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).getAttribute().isPassive())
					{
						if(!abilityProps.getAbilityFromSlot(i).isPassiveActive())
						{
							String ablName = WyHelper.getFancyName(abilityProps.getAbilityFromSlot(i).getAttribute().getAttributeName());
							if(ablName.equals(WyHelper.getFancyName(ListAttributes.ICE_SABER.getAttributeName())))
								owner.inventory.clearInventory(this, -1);
							else if(ablName.equals(WyHelper.getFancyName(ListAttributes.AMA_NO_MURAKUMO.getAttributeName())))
								owner.inventory.clearInventory(this, -1);
							else if(ablName.equals(WyHelper.getFancyName(ListAttributes.NORO_NORO_BEAM_SWORD.getAttributeName())))
								owner.inventory.clearInventory(this, -1);
							else if(ablName.equals(WyHelper.getFancyName(ListAttributes.DORU_DORU_ARTS_KEN.getAttributeName())))
								owner.inventory.clearInventory(this, -1);
							else if(ablName.equals(WyHelper.getFancyName(ListAttributes.BLUE_SWORD.getAttributeName())))
								owner.inventory.clearInventory(this, -1);
							else if(ablName.equals(WyHelper.getFancyName(ListAttributes.TABIRA_YUKI.getAttributeName())))
								owner.inventory.clearInventory(this, -1);
						}
					}
				}
			}
			else
				owner.inventory.clearInventory(this, -1);
			
		}	
	}

    public int getItemEnchantability()
    {
        return 0;
    }
	
	public ItemAbilityWeapon setIsPoisonous()
	{
		this.isPoisonous = true;
		this.poisonTimer = 100;
		return this;
	}
	
	public ItemAbilityWeapon setIsPoisonous(int timer)
	{
		this.isPoisonous = true;
		this.poisonTimer = timer;
		return this;
	}
	
	public ItemAbilityWeapon setIsFireAspect()
	{
		this.isFireAspect = true;
		return this;
	}
	
	public ItemAbilityWeapon setIsFireAspect(int timer)
	{
		this.isFireAspect = true;
		this.fireAspectTimer = timer;
		return this;
	}
	
	public ItemAbilityWeapon setIsSlownessInducing()
	{
		this.isSlownessInducing = true;
		return this;
	}
	
	public ItemAbilityWeapon setIsSlownessInducing(int timer)
	{
		this.isSlownessInducing = true;
		this.slownessTimer = timer;
		return this;
	}
	
	public ItemAbilityWeapon setIsSlownessInducing(int timer, boolean isStackable)
	{
		this.isSlownessInducing = true;
		this.slownessTimer = timer;
		this.isStackable = isStackable;
		return this;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		return itemStack;		
	}

}
