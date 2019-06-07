package commands;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.json.JSONException;

import APIs.CSGOAPI;
import APIs.FortniteStatsAPI;
import bot.DiscordBot;
import bot.getInput;

public class CsCommand implements Commands {
	
	CSGOAPI csapi;
	getInput gi;
	NumberFormat format = NumberFormat.getInstance();
	
	private String getKD(String name) throws JSONException, IOException {
		format.setMaximumFractionDigits(2);
		double kills = csapi.getCSGOKills(name);
		double deaths = csapi.getCSGODeaths(name);
		double kd = (kills/deaths);
		return String.valueOf(format.format(kd));
	}
	
	public CsCommand(CSGOAPI csapi, getInput gi) {
		this.csapi = csapi;
		this.gi = gi;
	}
	
	private String getStats(String name) throws JSONException, IOException {
		StringBuilder str = new StringBuilder();
		str.append("K/D: " + getKD(name) + "\n");
		str.append("Kills: "+ csapi.getCSGOKills(name) + "\n");
		str.append("Deaths: "+ csapi.getCSGODeaths(name) + "\n");
		str.append("Played Games: "+ csapi.getCSGORoundsPlayed(name) + "\n");
		str.append("Wins: " + csapi.getCSGOWins(name) + "\n");
		str.append("Headshot: " + csapi.getCSGOHeadshots(name) + "\n");
		return str.toString();
	}
	
	public String execute(String name) throws JSONException, IOException {
		try {
			return getStats(name);
		} catch (Exception e) {
			return "Couldn't find the SteamURL, make sure you've chosen the right one";
		}
	}
}
