package me.knightsy.discordbot;

import me.knightsy.discordbot.listeners.CommandHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Log");

    public static void main(String[] args) throws IOException {

        DiscordApi api = new DiscordApiBuilder().setToken(System.getenv("TOKEN"))
                .setAllNonPrivilegedIntents()
                .login()
                .join();

        api.addMessageCreateListener(new CommandHandler());

    }

}
