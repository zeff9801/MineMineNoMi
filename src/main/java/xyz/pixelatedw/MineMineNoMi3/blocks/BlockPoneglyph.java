package xyz.pixelatedw.MineMineNoMi3.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestManager;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityPoneglyph;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;
import xyz.pixelatedw.MineMineNoMi3.helpers.QuestLogicHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;

public class BlockPoneglyph extends BlockContainer
{
	public BlockPoneglyph()
	{
		super(Material.iron);
	}

	@Override
	public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int i1, float f1, float f2, float f3)
	{
		TileEntityPoneglyph tileEntity = (TileEntityPoneglyph) world.getTileEntity(posX, posY, posZ);
		HistoryProperties historyProps = HistoryProperties.get(player);
		QuestProperties questProps = QuestProperties.get(player);

		if (tileEntity.getEntryType().equalsIgnoreCase(ID.HISTORY_ENTRY_TYPE_CHALLENGE))
		{
			Quest quest = ListQuests.poneglyphChallengeCrocodile;			

			ItemStack note = QuestLogicHelper.getQuestItemStack(player.inventory, quest.getQuestID());

			if (!historyProps.hasUnlockedChallenge(tileEntity.getEntryName()) && note == null)
			{		
				note = new ItemStack(ListMisc.Note);
				note.setStackDisplayName("Copied Poneglyph Content");
				if (!note.hasTagCompound())
					note.setTagCompound(new NBTTagCompound());
				note.getTagCompound().setString("history_entry", tileEntity.getEntryName());
				note.getTagCompound().setString("ForQuest", quest.getQuestID());
				
				player.inventory.addItemStackToInventory(note);

				QuestManager.instance().startQuest(player, quest);
				
				return true;
			}
		}

		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityPoneglyph();
	}

}
