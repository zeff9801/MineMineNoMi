package xyz.pixelatedw.MineMineNoMi3.api.debug;

import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;

public class WyDebug
{
	public static boolean isDebug()
	{
		return ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
	}

	public static void info(Object msg)
	{
		Logger.getGlobal().info("[WYPI] [" + ID.PROJECT_ID.toUpperCase() + "] " + String.valueOf(msg));
	}

	public static void warn(Object msg)
	{
		Logger.getGlobal().warning("[WYPI] [" + ID.PROJECT_ID.toUpperCase() + "] " + String.valueOf(msg));
	}

	public static void error(Object msg)
	{
		Logger.getGlobal().log(Level.SEVERE, "[WYPI] [" + ID.PROJECT_ID.toUpperCase() + "] " + String.valueOf(msg));
	}
	
	public static void debug(Object msg)
	{
		if(isDebug())
			Logger.getGlobal().log(Level.INFO, "[DEBUG] [WYPI] [" + ID.PROJECT_ID.toUpperCase() + "] " + String.valueOf(msg));
	}
}
