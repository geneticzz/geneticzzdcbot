package commands;

import java.io.IOException;

import org.json.JSONException;

public interface Commands {
	
	String execute(String name) throws JSONException, IOException;
	String executeOneStringCommands();
}
