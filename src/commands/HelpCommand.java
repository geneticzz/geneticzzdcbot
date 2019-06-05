package commands;

import java.io.IOException;

import org.json.JSONException;

import bot.Parse;
import bot.getInput;

public class HelpCommand implements Commands{
	getInput gi;
	
	public HelpCommand(getInput gi) {
		this.gi = gi;
	}

	private String getCommands() {
		return Parse.helpCommands();
	}
	
	public String execute(String name) throws JSONException, IOException {
		return name + ": " + getCommands();
	}
}
