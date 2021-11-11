package me.knightsy.discordbot.util;

import me.knightsy.discordbot.Constants;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;

public class EmbedMessage {

    public EmbedMessage(MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel channel){
        new MessageBuilder().setEmbed(new EmbedBuilder()
            .setAuthor(author)
            .setTitle(title)
            .setDescription(description)
            .setFooter(footer)
            .setThumbnail(thumbnail)
            .setColor(Constants.BOT_COLOR))
                .send(channel);
    }
}
