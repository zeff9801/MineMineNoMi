package xyz.pixelatedw.MineMineNoMi3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class Values 
{
	public static List<AkumaNoMi> devilfruits = new ArrayList<AkumaNoMi>();
	public static List<AkumaNoMi> logias = new ArrayList<AkumaNoMi>();
	public static List<Item> miscItems = new ArrayList<Item>();
	public static List<Block> miscBlocks = new ArrayList<Block>();
	public static List<Object[]> customDFs = new ArrayList<Object[]>();
	
	public static final int MAX_HAKI_EXP = 1000;
	public static final int MAX_DORIKI = 10000;
	public static final int MAX_ULTRACOLA = 10;
	public static final int MAX_GENERAL = 999999999;
	public static final long MAX_BOUNTY = 100000000000L;
	public static final int MAX_CREW = 50;
	public static final int MAX_ACTIVITIES = 4;
	
	// Network related stuff
	public static String urlConnection = "http://pixelatedw.xyz/api";
	public static Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();

	public static String RESOURCES_FOLDER;
	
	public static Item[] KAIROSEKI_ITEMS = new Item[] {ListMisc.Kairoseki, ListMisc.KairosekiBullets, ListMisc.DenseKairoseki};
	
	public static HashMap<String, String[]> abilityWebAppExtraParams = new HashMap<String, String[]>();

}
