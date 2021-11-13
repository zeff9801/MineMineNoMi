package xyz.pixelatedw.MineMineNoMi3.api.math;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class WyMathHelper
{
	public static List shuffle(List ar)
	{
		Random rnd = new Random();

		for (int i = ar.size() - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Object a = ar.get(index);
			ar.set(index, ar.get(i));
			ar.set(i, a);
		}

		return ar;
	}

	public static String shuffleArray(String str)
	{
		char[] array = str.toCharArray();
		Random rnd = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);

			char a = array[index];
			array[index] = array[i];
			array[i] = (char) (a + randomWithRange(1, 5));
		}
		
		return String.valueOf(array);
	}

	public static float degToRad(double degrees)
	{
		return (float) (degrees * Math.PI / 180);
	}
	
	public static double percentage(double i, double j)
	{
		return (i / 100) * j;
	}

	public static double randomWithRange(int min, int max)
	{
		return new Random().nextInt(max + 1 - min) + min;
	}

	public static double randomDouble()
	{
		return new Random().nextDouble() * 2 - 1;
	}

	public static float clampf(float val, float min, float max)
	{
		return Math.max(min, Math.min(max, val));
	}

	public static double clampd(double val, double min, double max)
	{
		return Math.max(min, Math.min(max, val));
	}

	public static int clampi(int val, int min, int max)
	{
		return Math.max(min, Math.min(max, val));
	}

	public static double lerp(double a, double b, double f)
	{
		return a + (b - a) * f;
	}

	public static int[] moveAway(EntityPlayer player, int[] current)
	{
		WyHelper.Direction dir = WyHelper.get8Directions(player);
		if (dir == WyHelper.Direction.NORTH)
		{
			current[2] -= 1;
		}
		else if (dir == WyHelper.Direction.NORTH_EAST)
		{
			current[0] += 1;
			current[2] -= 1;
		}
		else if (dir == WyHelper.Direction.EAST)
		{
			current[0] += 1;
		}
		else if (dir == WyHelper.Direction.SOUTH_EAST)
		{
			current[0] += 1;
			current[2] += 1;
		}
		else if (dir == WyHelper.Direction.SOUTH)
		{
			current[2] += 1;
		}
		else if (dir == WyHelper.Direction.SOUTH_WEST)
		{
			current[0] -= 1;
			current[2] += 1;
		}
		else if (dir == WyHelper.Direction.WEST)
		{
			current[0] -= 1;
		}
		else if (dir == WyHelper.Direction.NORTH_WEST)
		{
			current[0] -= 1;
			current[2] -= 1;
		}
		return current;
	}
}
