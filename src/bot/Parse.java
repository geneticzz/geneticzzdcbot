package bot;

import java.util.HashMap;

public class Parse {

	private getInput gi;
	private DiscordBot dc;
	private HashMap<String, String> output;

	public Parse(getInput gi, DiscordBot dc) {
		this.gi = gi;
		this.dc = dc;
		output = new HashMap<String, String>();
	}

	private String geneticzz() {
		return "A yung legend\n"
				+ "https://www.youtube.com/c/geneticzz\n"
				+ "https://www.facebook.com/Geneticzz/\n"
				+ "https://www.twitch.tv/geneticzztv/\n"
				+ "https://www.instagram.com/geneticzz_/?hl=de\n"
				+ "https://steamcommunity.com/id/geneticzz2k\n";
	}
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
	public String helpCommands() {
		return "Random commands: " + output.keySet().toString() + "\nGame commands: " + dc.getCommandsInput();
	}




	public String getCommand() {
		try {
			output.put("geneticzz", geneticzz());
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
			output.put("help", helpCommands());
			return output.get(gi.userInput());
		}
		catch (Exception e) {
			return "ERROR!";
		}
	}
}
