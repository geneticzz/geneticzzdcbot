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
import commands.FunCommand;
import commands.HelpCommand;
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
	private String contentToSub;
	String content;
	FortniteCommand fncomm;
	CsCommand cscomm;
	static JDA jda;
	private HashMap<String, Commands> commands;

	public DiscordBot() {
		fnapi = new FortniteStatsAPI();
		csapi = new CSGOAPI();
		gi = new getInput(this);
		commands = new HashMap<>();
		commands.put("fn", new FortniteCommand(fnapi, gi));
		commands.put("cs", new CsCommand(csapi, gi));
		commands.put("help", new HelpCommand(gi, this));
		commands.put("fun", new FunCommand());
	}
	
	public String getCommandsInput() {
		return commands.keySet().toString();
	}

	public String getContent() {
		return contentToSub;
	}

	public static void main(String[] args)
			throws LoginException, InterruptedException {
		jda = new JDABuilder(AccountType.BOT)
				.setToken("NTgxNDI1MTgxNjU0OTA4OTM4.XOfEiQ.mz7s3INZR2m0jRS5nn3fQRXSuok")
				.addEventListener(new DiscordBot())
				.build()
				.awaitReady();
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) return;
		if (event.isFromType(ChannelType.TEXT)) {
			System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
					event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
		}
		else {
			System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
		}
		
		Message message = event.getMessage();
		content = message.getContentRaw();
		contentToSub = content.substring(1, content.length());
		String[] commandsString = contentToSub.split(" ", 2);
		MessageChannel channel = event.getChannel();

		try {
			if (content.startsWith("!") && commandsString.length == 2) {
				channel.sendMessage(commands.get(commandsString[0]).execute(commandsString[1])).queue();
			} else if (content.startsWith("!") && commandsString.length == 1) {
				channel.sendMessage(commands.get(commandsString[0]).executeOneStringCommands()).queue();
			}

		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}