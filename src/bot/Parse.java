package bot;

public class Parse {

	private getInput gi;

	public Parse(getInput gi) {
		this.gi = gi;
	}

	private String geneticzz() {
		return "A yung legend";
	}

	private String juifar() {
		return "i dont know the distonce";
	}

	private String flowz() {
		return "my mouse dc help me";
	}
	private String turturz() {
		return "WTF MY SCREEN OFFLINE?!";
	}
	private String keroplay() {
		return "I think that Y2J is using anti hedshot";
	}
	private String volishq() {
		return "sell account 100€ no scam now can";
	}
	private String sixeena() {
		return "LEAVE MY HOUSE";
	}
	private String nirassa() {
		return "kebap maker dönerman";
	}
	private String mysta() {
		return "spielt solos immer allein";
	}
	private String gosu() {
		return "super cup champion 2019 only good clans keroplay hype & put in title";
	}
	private String tetsu() {
		return "ginger ale";
	}
	private String jhaymaster() {
		return "iam best newz player I trashtalk all but lose all 1v1";
	}
	
	
	public String helpCommands() {
		return "[geneticzz, juifar, flowz, turturz, keroplay, volishq, sixeena, nirassa, mysta, fn *name*, cs *steamID*, gosu, mysta, tetsu, jhaymaster]";
	}

	public String getCommand() {
		try {
			if (gi.userInput().equalsIgnoreCase("geneticzz")) {
				return geneticzz();
			}
			if (gi.userInput().equalsIgnoreCase("juifar")) {
				return juifar();
			}
			if (gi.userInput().equalsIgnoreCase("flowz")) {
				return flowz();
			}
			if (gi.userInput().equalsIgnoreCase("turturz")) {
				return turturz();
			}
			if (gi.userInput().equalsIgnoreCase("keroplay")) {
				return keroplay();
			}
			if (gi.userInput().equalsIgnoreCase("volishq")) {
				return volishq();
			}
			if (gi.userInput().equalsIgnoreCase("sixeena")) {
				return sixeena();
			}
			if (gi.userInput().equalsIgnoreCase("nirassa")) {
				return nirassa();
			}
			if (gi.userInput().equalsIgnoreCase("mysta")) {
				return mysta();
			}
			if (gi.userInput().equalsIgnoreCase("gosu")) {
				return gosu();
			}
			if (gi.userInput().equalsIgnoreCase("tetsu")) {
				return tetsu();
			}
			if (gi.userInput().equalsIgnoreCase("jhaymaster")) {
				return jhaymaster();
			}
			return null;
		} catch (Exception e) {
			return "ERROR!";
		}
	}
}
