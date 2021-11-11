package me.knightsy.discordbot.command;

import org.javacord.api.event.message.MessageCreateEvent;

public interface Command {
    void process(MessageCreateEvent event);
}
