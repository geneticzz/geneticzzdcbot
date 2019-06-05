package APIs;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CSGOAPI {
	
	//Steam Games Details
	//https://store.steampowered.com/api/appdetails?appids=57690&cc=de&l=de
	private GetAPIS getAPIS = new GetAPIS();
	private JSONArray csgo;
	
	private void loadCSGO(String steamID)  throws JSONException, IOException{
		String url = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=F4095D3305932401E1A227E2EB976F74&steamid=" +steamID +"&format=json";
        StringBuffer response = getAPIS.getAPIs(url);
  
        JSONObject object = new JSONObject(response.toString());
        
        JSONObject object2 = object.getJSONObject("playerstats");
        this.csgo = object2.getJSONArray("stats");
	}
	
	
	//Abfrage um den API-Call auszuführen und die Anzahl der Kills für eine bestimmte Steam-ID bekommen
	public int getCSGOKills(String steamID) throws JSONException, IOException {
		
		loadCSGO(steamID);
        
        int length = this.csgo.length(); 
        
        String[] name = new String[length];
        int[] value = new int[length];
        
        for(int i=0; i<length; i++) 
        {
            JSONObject jObj = this.csgo.getJSONObject(i);
            value[i] = jObj.getInt("value");
        }
        
        return value[0];
	}

	//Abfrage um den API-Call auszuführen und die Anzahl der Tode für eine bestimmte Steam-ID bekommen
	public int getCSGODeaths(String steamID) throws JSONException, IOException {
		if(this.csgo==null) {
			loadCSGO(steamID);
		}
        
        int length = this.csgo.length(); 
        
        String[] name = new String[length];
        int[] value = new int[length];
        
        for(int i=0; i<length; i++) 
        {
            JSONObject jObj = this.csgo.getJSONObject(i);
            value[i] = jObj.getInt("value");
        }
              
        return value[1];
	}
	
	//Abfrage um den API-Call auszuführen und die Anzahl der Wins für eine bestimmte Steam-ID bekommen
	public int getCSGOWins(String steamID) throws JSONException, IOException {
		if(this.csgo==null) {
			loadCSGO(steamID);
		}
        
        int length = this.csgo.length(); 
        
        String[] name = new String[length];
        int[] value = new int[length];
        
        for(int i=0; i<length; i++) 
        {
            JSONObject jObj = this.csgo.getJSONObject(i);
            value[i] = jObj.getInt("value");
        }
        
        return value[5];
	}
	
	//Abfrage um den API-Call auszuführen und die Anzahl der gespielten Runden für eine bestimmte Steam-ID bekommen
	public int getCSGORoundsPlayed(String steamID) throws JSONException, IOException {
		if(this.csgo==null) {
			loadCSGO(steamID);
		}
        
        int length = this.csgo.length(); 
        
        String[] name = new String[length];
        int[] value = new int[length];
        
        for(int i=0; i<length; i++) 
        {
            JSONObject jObj = this.csgo.getJSONObject(i);
            value[i] = jObj.getInt("value");
        }
        
        return value[48];
	}
	
	//Abfrage um den API-Call auszuführen und die Anzahl der Kopftreffer für eine bestimmte Steam-ID bekommen
	public int getCSGOHeadshots(String steamID) throws JSONException, IOException {
		if(this.csgo==null) {
			loadCSGO(steamID);
		}
        
        int length = this.csgo.length(); 
        
        String[] name = new String[length];
        int[] value = new int[length];
        
        for(int i=0; i<length; i++) 
        {
            JSONObject jObj = this.csgo.getJSONObject(i);
            value[i] = jObj.getInt("value");
        }
        
        return value[25];
	}
}