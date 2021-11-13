package xyz.pixelatedw.MineMineNoMi3.items.weapons;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class KujaBow extends Item
{
	public String[] pullArray;
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private boolean isPulled;
	private String variation;

	public KujaBow(String variation)
	{
		this.variation = variation;
		this.pullArray = new String[] {	this.variation + "kujabow_0", this.variation + "kujabow_1", this.variation + "kujabow_2" };
		this.setMaxDamage(400);
		this.bFull3D = true;		
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int time)
	{
		int j = this.getMaxItemUseDuration(itemStack) - time;

		ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			return;
		j = event.charge;

		boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

		if (flag || player.inventory.hasItem(ListMisc.KujaArrow))
		{
			float f = j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if (f < 0.1D)
				return;

			if (f > 1.0F)
				f = 1.0F;

			if(f > 0.85)
			{
				AbilityProjectile entityarrow = new ExtraProjectiles.KujaArrow(world, player, ListExtraAttributes.KUJA_ARROW);
	
				world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	
				player.inventory.consumeInventoryItem(ListMisc.KujaArrow);
	
				if (!world.isRemote)
				{
					world.spawnEntityInWorld(entityarrow);
					WyTelemetry.addMiscStat("kujaArrowsShot", "Kuja Arrows Shot", 1);
				}
			}
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			return event.result;

		if (itemStack.getTagCompound().getBoolean("canUse") && (player.capabilities.isCreativeMode || player.inventory.hasItem(ListMisc.KujaArrow)))
		{
			player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		}

		return itemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
	{
		return EnumAction.bow;
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setBoolean("canUse", true);
			itemStack.getTagCompound().setInteger("cooldown", 10);
		}

		if (!itemStack.getTagCompound().getBoolean("canUse"))
		{
			int cd = itemStack.getTagCompound().getInteger("cooldown");
			if (cd > 0)
			{
				cd--;
				itemStack.getTagCompound().setInteger("cooldown", cd);
			} else
			{
				itemStack.getTagCompound().setInteger("cooldown", 10);
				itemStack.getTagCompound().setBoolean("canUse", true);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ID.PROJECT_ID + ":" + this.variation + "kujabow");
		this.iconArray = new IIcon[pullArray.length];
		for(int i = 0; i < this.iconArray.length; i++)
			this.iconArray[i] = par1IconRegister.registerIcon(ID.PROJECT_ID + ":" + pullArray[i]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (player.getItemInUse() == null)
			return this.itemIcon;

		int isPulling = stack.getMaxItemUseDuration() - useRemaining;
		if (isPulling >= 18)
		{
			if (this.isPulled)
				return this.iconArray[5];
			return this.iconArray[2];
		}
		if (isPulling > 13)
		{
			if (this.isPulled)
				return this.iconArray[4];
			return this.iconArray[1];
		}
		if (isPulling > 0)
		{
			if (this.isPulled)
				return this.iconArray[3];
			return this.iconArray[0];
		}
		return this.itemIcon;
	}
}
