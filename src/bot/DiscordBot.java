package bot;

import java.io.IOException;
import java.util.HashMap;

import javax.security.auth.login.LoginException;

import org.json.JSONException;

import APIs.CSGOAPI;
import APIs.FortniteStatsAPI;
import commands.Commands;
import commands.CsCommand;
import commands.FortniteCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.DisconnectEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class DiscordBot extends ListenerAdapter {
	private getInput gi;
	private FortniteStatsAPI fnapi;
	private CSGOAPI csapi;
	private Parse parse;
	private String contentToSub;
	String content;
	FortniteCommand fncomm;
	CsCommand cscomm;
	private HashMap<String, Commands> commands = new HashMap<>();

	public DiscordBot() {
		fnapi = new FortniteStatsAPI();
		csapi = new CSGOAPI();
		gi = new getInput(this);
		parse = new Parse(gi);
		commands.put("fn", new FortniteCommand(fnapi, gi));
		commands.put("cs", new CsCommand(csapi, gi));
	}

	public String getContent() {
		return contentToSub;
	}
	
	public static void main(String[] args)
			throws LoginException, InterruptedException
	{
		JDA jda = new JDABuilder(AccountType.BOT)
				.setToken("NTgxNDI1MTgxNjU0OTA4OTM4.XOfEiQ.mz7s3INZR2m0jRS5nn3fQRXSuok")
				.addEventListener(new DiscordBot())
				.build()
				.awaitReady();
	}
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if (event.getAuthor().isBot()) return;
		if (event.isFromType(ChannelType.TEXT))
		{
			System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
					event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
		}
		else
		{
			System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
		}
		Message message = event.getMessage();
		content = message.getContentRaw();
		contentToSub = content.substring(1, content.length());
		String[] commandsString = contentToSub.split(" ", 2);
		MessageChannel channel = event.getChannel();
		
		if (parse.getCommand() != null) {
			channel.sendMessage(parse.getCommand()).queue();
		}
		if (contentToSub.equalsIgnoreCase("help")) {
			channel.sendMessage(parse.helpCommands()).queue();
		}
		
		try {
			 if (content.startsWith("!") && commandsString.length == 2) {
				channel.sendMessage(commands.get(commandsString[0]).execute(commandsString[1])).queue();
			}
			
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}