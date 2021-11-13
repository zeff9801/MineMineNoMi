package xyz.pixelatedw.MineMineNoMi3;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketUseAbility;

public class MainKeys 
{

	public static KeyBinding guiPlayer, enterCombatMode, combatSlot1, combatSlot2, combatSlot3, combatSlot4, combatSlot5, combatSlot6, combatSlot7, combatSlot8;
	
	private static KeyBinding[] keyBindsCombatbar;
	
	public static void init() 
	{		
		guiPlayer = new KeyBinding(ID.LANG_KEY_PLAYER, Keyboard.KEY_R, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(guiPlayer);
		
		enterCombatMode = new KeyBinding(ID.LANG_KEY_COMBATMODE, Keyboard.KEY_LMENU, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(enterCombatMode);
		
		combatSlot1 = new KeyBinding(ID.LANG_KEY_COMBATSLOT1, Keyboard.KEY_1, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot1);	
		combatSlot2 = new KeyBinding(ID.LANG_KEY_COMBATSLOT2, Keyboard.KEY_2, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot2);	
		combatSlot3 = new KeyBinding(ID.LANG_KEY_COMBATSLOT3, Keyboard.KEY_3, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot3);		
		combatSlot4 = new KeyBinding(ID.LANG_KEY_COMBATSLOT4, Keyboard.KEY_4, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot4);
		combatSlot5 = new KeyBinding(ID.LANG_KEY_COMBATSLOT5, Keyboard.KEY_5, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot5);
		combatSlot6 = new KeyBinding(ID.LANG_KEY_COMBATSLOT6, Keyboard.KEY_6, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot6);
		combatSlot7 = new KeyBinding(ID.LANG_KEY_COMBATSLOT7, Keyboard.KEY_7, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot7);
		combatSlot8 = new KeyBinding(ID.LANG_KEY_COMBATSLOT8, Keyboard.KEY_8, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(combatSlot8);
		
		keyBindsCombatbar = new KeyBinding[] {combatSlot1, combatSlot2, combatSlot3, combatSlot4, combatSlot5, combatSlot6, combatSlot7, combatSlot8};
	}
	    
	public static boolean isShiftKeyDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);		
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) 
	{		
    	Minecraft minecraft = Minecraft.getMinecraft();
    	EntityPlayer player = minecraft.thePlayer; 
    	WorldClient world = minecraft.theWorld;  
    	ExtendedEntityData props = ExtendedEntityData.get(player);
    	
		if(guiPlayer.isPressed())
		{
        	WyNetworkHelper.sendToServer(new PacketPlayer("forcesync"));

        	if(!props.hasRace() || !props.hasFaction() || !props.hasFightingStyle())
        		player.openGui(MainMod.getMineMineNoMi(), 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        	else
        		player.openGui(MainMod.getMineMineNoMi(), 1, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        }
		
		if(enterCombatMode.isPressed()) 
		{
			props.setCombatMode(!props.isInCombatMode());
			if(props.isInCombatMode())
			{
				for(KeyBinding kb : Minecraft.getMinecraft().gameSettings.keyBindsHotbar)
				{
					kb.setKeyCode(0);
				}

				int keyId = 2;
				for(KeyBinding kb : MainKeys.keyBindsCombatbar)
				{
					if(kb.getKeyCode() < 9)
						kb.setKeyCode(keyId);
					keyId++;
				}
				
				KeyBinding.resetKeyBindingArrayAndHash();
			}
			else
			{
				for(KeyBinding kb : MainKeys.keyBindsCombatbar)
				{
					if(kb.getKeyCode() < 9)
						kb.setKeyCode(0);
				}
				
				int keyId = 2;
				for(KeyBinding kb : Minecraft.getMinecraft().gameSettings.keyBindsHotbar)
				{			
					kb.setKeyCode(keyId);
					keyId++;
				}
				
				KeyBinding.resetKeyBindingArrayAndHash();
			}
        	WyNetworkHelper.sendToServer(new PacketPlayer("enterCombatMode"));
		}
		
		int j = keyBindsCombatbar.length;
		
		for(int i = 0; i < j; i++)
		{
			if(keyBindsCombatbar[i].isPressed())
			{
	        	if(props.isInCombatMode())
	        		WyNetworkHelper.sendToServer(new PacketUseAbility(i));
	        	else
	        		player.inventory.currentItem = i;
			}
		}
	}	
}
