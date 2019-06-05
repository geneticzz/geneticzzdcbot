package APIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FortniteStatsAPI {

	private JSONArray stats;
	private GetAPIS getAPIS = new GetAPIS();

	private void loadStats(String username, String plattform) throws IOException, JSONException {
				System.setProperty("http.agent", "Chrome");
				String url = "https://api.fortnitetracker.com/v1/profile/" + plattform + "/" + username;
				 URL obj = new URL(url);
		         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		         con.setRequestMethod("GET");
		         con.setRequestProperty("User-Agent", "Mozilla/5.0");
		         con.setRequestProperty("TRN-Api-Key", "2fe254f7-9852-4d31-9f63-f66460ebd96a");
		         BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		         String inputLine;
		         StringBuffer response = new StringBuffer();
		         while ((inputLine = in .readLine()) != null) {
		             response.append(inputLine);
		} in .close();
				JSONObject object = new JSONObject(response.toString());

				stats = object.getJSONArray("lifeTimeStats");
				
	}

	public String getKD(String username) throws IOException, JSONException {

		loadStats(username, "pc");

		int length = this.stats.length();

		String[] value = new String[length];

		for (int i = 0; i < length; i++) {
			JSONObject jObj = this.stats.getJSONObject(i);
			value[i] = jObj.getString("value").toString();
		}

		return value[11];
	}

	public String getWINRATIO(String username) throws IOException, JSONException {
		if (this.stats == null) {
			loadStats(username, "pc");
		}

		int length = this.stats.length();

		String[] value = new String[length];

		for (int i = 0; i < length; i++) {
			JSONObject jObj = this.stats.getJSONObject(i);
			value[i] = jObj.getString("value").toString();
		}

		return value[9];
	}

	public String getKILLS(String username) throws IOException, JSONException {
		if (this.stats == null) {
			loadStats(username, "pc");
		}

		int length = this.stats.length();

		String[] value = new String[length];

		for (int i = 0; i < length; i++) {
			JSONObject jObj = this.stats.getJSONObject(i);
			value[i] = jObj.getString("value").toString();
		}

		return value[10];
	}

	public String getMatches(String username) throws IOException, JSONException {
		if (this.stats == null) {
			loadStats(username, "pc");
		}

		int length = this.stats.length();

		String[] value = new String[length];

		for (int i = 0; i < length; i++) {
			JSONObject jObj = this.stats.getJSONObject(i);
			value[i] = jObj.getString("value").toString();
		}

		return value[7];
	}

	public String getWINS(String username) throws IOException, JSONException {
		if (stats == null) {
			loadStats(username, "pc");
		}

		int length = this.stats.length();

		String[] value = new String[length];

		for (int i = 0; i < length; i++) {
			JSONObject jObj = this.stats.getJSONObject(i);
			value[i] = jObj.getString("value").toString();
		}

		return value[8];
	}

}
