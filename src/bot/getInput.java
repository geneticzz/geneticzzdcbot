package bot;

public class getInput {

	DiscordBot dc;
	
	public getInput(DiscordBot dc) {
		this.dc = dc;
	}
	
	public String userInput() {
		return dc.getContent();
	}
	
	public String[] getCommands() {
		String command = userInput().substring(1, userInput().length());
		String[] split = command.split(" ");
		return split;
	}
	
	
}
