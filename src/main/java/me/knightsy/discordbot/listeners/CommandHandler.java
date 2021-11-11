package me.knightsy.discordbot.listeners;

import me.knightsy.discordbot.command.Command;
import me.knightsy.discordbot.command.commands.HelpCommand;
import me.knightsy.discordbot.command.commands.PingCommand;
import me.knightsy.discordbot.command.commands.PongCommand;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.HashMap;
import java.util.logging.Logger;

public class CommandHandler implements MessageCreateListener {
    private final HashMap<String, Command> commands = new HashMap<>();
    private final Logger logger = Logger.getLogger("Log");

    public CommandHandler() {
        commands.put("ping", new PingCommand());
        commands.put("pong", new PongCommand());
        commands.put("help", new HelpCommand());
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        // make sure prefix starts message command
        String prefix = "!";
        if (event.getMessageContent().startsWith(prefix)) {
            // remove prefix from string and anything after
            logger.info(commands + "\n" + event);
            String command = event.getMessageContent().substring(1).split(" ")[0].toLowerCase();
            // check if original command name
            if (commands.containsKey(command)){
                commands.get(command).process(event);
            }

            logger.info(event.getMessageAuthor().getDiscriminatedName() + " invoked: " + command);
        }

    }
}
