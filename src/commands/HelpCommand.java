package commands;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

import org.json.JSONException;

import APIs.CSGOAPI;
import APIs.FortniteStatsAPI;
import bot.DiscordBot;
import bot.getInput;

public class HelpCommand implements Commands {
	
	private getInput gi;
	private DiscordBot dc;
	private HashMap<String, String> output;
	private String geneticzz 
		= "A yung legend\n"
				+ "https://www.youtube.com/c/geneticzz\n"
				+ "https://www.facebook.com/Geneticzz/\n"
				+ "https://www.twitch.tv/geneticzztv/\n"
				+ "https://www.instagram.com/geneticzz_/?hl=de\n"
				+ "https://steamcommunity.com/id/geneticzz2k\n";
	
	private String juifar = "i dont know the distonce";
	private String flowz = "my mouse dc help me";
	private String turturz = "WTF MY SCREEN OFFLINE?!";
	private String keroplay = "I think that Y2J is using anti hedshot";
	private String volishq = "sell account 100€ no scam now can";
	private String sixeena = "LEAVE MY HOUSE";
	private String nirassa = "kebap maker dönerman";
	private String mysta = "spielt solos immer allein";
	private String gosu = "super cup champion 2019 only good clans keroplay hype & put in title";
	private String jhaymaster = "iam best newz player I trashtalk all but lose all 1v1";
	private String tetsu = "ginger ale";
	
	public HelpCommand(getInput gi, DiscordBot dc) {
		output = new HashMap<>();
		this.dc = dc;
		this.gi = gi;
		output.put("geneticzz", geneticzz);
		output.put("juifar", juifar);
		output.put("flowz", flowz);
		output.put("turturz", turturz);
		output.put("keroplay", keroplay);
		output.put("volishq", volishq);
		output.put("sixeena", sixeena);
		output.put("nirassa", nirassa);
		output.put("mysta", mysta);
		output.put("gosu", gosu);
		output.put("tetsu", tetsu);
		output.put("jhaymaster", jhaymaster);
	}
		
	private String helpCommands() {
		System.out.println(output.keySet().toString());
		System.out.println( dc.getCommandsInput());
		return "Random commands: " + output.keySet().toString() + "\n\nGame commands: " + dc.getCommandsInput();
	}
	
	public String execute(String name) throws JSONException, IOException {
		return name;
	}

	@Override
	public String executeOneStringCommands() {
		return helpCommands();
	}
}
