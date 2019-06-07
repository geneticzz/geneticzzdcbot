package commands;

import java.io.IOException;

import org.json.JSONException;

import APIs.FortniteStatsAPI;
import bot.DiscordBot;
import bot.getInput;

public class FortniteCommand implements Commands {
	
	FortniteStatsAPI fnapi;
	getInput gi;
	

	public FortniteCommand(FortniteStatsAPI fnapi, getInput gi) {
		this.gi = gi;
		this.fnapi = fnapi;
	}
	
	private String getStats(String name) throws JSONException, IOException {
		StringBuilder str = new StringBuilder();
		str.append("K/D: " + fnapi.getKD(name) + "\n");
		str.append("Played Games: "+ fnapi.getMatches(name) + "\n");
		str.append("Wins: " + fnapi.getWINS(name) + "\n");
		str.append("Winrate: " + fnapi.getWINRATIO(name) + "\n");
		return str.toString();
	}
	
	public String execute(String name) throws JSONException, IOException {
		try {
			return getStats(name);
		} catch (Exception e) {
			return "Error, name doesn't exist.";
		}
	}

	@Override
	public String executeOneStringCommands() {
		// TODO Auto-generated method stub
		return null;
	}
}
