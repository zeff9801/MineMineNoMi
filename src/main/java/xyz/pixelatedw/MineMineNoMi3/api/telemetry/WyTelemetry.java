package xyz.pixelatedw.MineMineNoMi3.api.telemetry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;

public class WyTelemetry
{	
	private static StatDataCompound structuresDataCompound = new StatDataCompound();
	private static StatDataCompound killsDataCompound = new StatDataCompound();
	private static StatDataCompound abilitiesDataCompound = new StatDataCompound();
	private static StatDataCompound miscDataCompound = new StatDataCompound();
	private static StatDataCompound devilFruitsDataCompound = new StatDataCompound();

	public static void addStructureStat(String id, String name, int value)
	{
		structuresDataCompound.put(id, name, value);
		//debugJSON(structuresDataCompound);
	}
	
	public static void addKillStat(String id, String name, int value)
	{
		killsDataCompound.put(id, name, value);
		//debugJSON(killsDataCompound);
	}
	
	public static void addAbilityStat(String id, String name, int value)
	{
		abilitiesDataCompound.put(id, name, value);
		//debugJSON(abilitiesDataCompound);
	}
	
	public static void addMiscStat(String id, String name, int value)
	{
		miscDataCompound.put(id, name, value);
		//debugJSON(miscDataCompound);
	}
	
	public static void addDevilFruitStat(String id, String name, int value)
	{
		devilFruitsDataCompound.put(id, name, value);
		//debugJSON(devilFruitsDataCompound);
	}
	
	public static void sendAllData()
	{
		Thread httpThread = new Thread()
		{
			@Override
			public void run()
			{	
				Object[][] paths = new Object[][] 
				{
					{"/stats/structure", structuresDataCompound},
					{"/stats/kill", killsDataCompound},
					{"/stats/ability", abilitiesDataCompound},
					{"/stats/misc", miscDataCompound},
					{"/stats/devil-fruit", devilFruitsDataCompound}
				};
							
				for (Object[] o : paths)
				{
					String apiURL = (String) o[0];
					StatDataCompound compound = (StatDataCompound) o[1];

					if (compound.data.isEmpty())
						continue;

					// Turning the coumpound data into a nice json format
					String json = Values.gson.toJson(compound);

					String result = sendPOST(apiURL, json);

					WyDebug.debug("Path: " + apiURL + "Result: " + (result.isEmpty() ? "Success" : result));

					compound.empty();
				}
			}
		};
		httpThread.setName("Mine Mine no Mi - Stats POST");
		httpThread.start();
	}
	
	public static void sendAllDataSync()
	{
		Object[][] paths = new Object[][] 
		{
			{"/stats/structure", structuresDataCompound},
			{"/stats/kill", killsDataCompound},
			{"/stats/ability", abilitiesDataCompound},
			{"/stats/misc", miscDataCompound},
			{"/stats/devil-fruit", devilFruitsDataCompound}
		};

		for (Object[] o : paths)
		{
			String apiURL = (String) o[0];
			StatDataCompound compound = (StatDataCompound) o[1];

			if (compound.data.isEmpty())
				continue;

			// Turning the coumpound data into a nice json format
			String json = Values.gson.toJson(compound);

			String result = sendPOST(apiURL, json);

			WyDebug.debug("Path: " + apiURL + "Result: " + (result.isEmpty() ? "Success" : result));

			compound.empty();
		}
	}

	public static String sendPOST(String sendUrl, String object)
	{
		BufferedReader reader = null;
		String result = "";
		
		try
		{
			String json = object;

			// Actual URL to the API
			URL url = new URL(Values.urlConnection + "" + sendUrl);

			// Opening a connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Setting the properties for this connection
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.connect();

			// Writing the JSON in the stream
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(json);
			writer.flush();

			// Read the output from the server
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder stringBuilder = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null)
			{
				stringBuilder.append(line);
			}

			result = stringBuilder.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reader != null)
					reader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static String sendGET(String sendUrl)
	{
		String result = "";
		
		try
		{
			// Actual URL to the API
			URL url = new URL(Values.urlConnection + "" + sendUrl);

			// Opening a connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Setting the properties
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK)
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null)
				{
					response.append(inputLine);
				}
				
				in.close();
				
				result = response.toString();
			}
			else
				WyDebug.error("GET Request failed!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static void debugJSON(StatDataCompound compound)
	{
		String json = Values.gson.toJson(compound);
		String size = WyHelper.formatBytes(json.getBytes().length);
		WyDebug.debug("\n JSON: " + json + "\n Size: " + size);
	}
	
	private static class StatDataCompound
	{
		private String mcVersion;
		private String modVersion;
		private int source;
		private HashMap<String, StatData> data = new HashMap<String, StatData>();
		
		public StatDataCompound()
		{
			this.mcVersion = ID.PROJECT_MCVERSION;
			this.modVersion = ID.PROJECT_VERSION;
			this.source = 0;
		}
		
		public void put(String id, String name, int value)
		{
			if(data.containsKey(id))
				data.get(id).value += value;
			else
			{
				StatData newData = new StatData(name, value);
				data.put(id, newData);
			}
		}
		
		public void empty()
		{
			data = new HashMap<String, StatData>(); 
		}
	}
	
	private static class StatData
	{
		private String name;
		private int value;
		
		public StatData(String name, int value)
		{
			this.name = name;
			this.value = value;
		}
	}
}
