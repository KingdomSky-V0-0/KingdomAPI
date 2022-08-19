package fr.kingdomsky.kingdomapi.commands;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static org.bukkit.Bukkit.broadcast;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            KingdomAPI.getListPlayers().forEach(kingdomPlayer ->Bukkit.broadcast(Component.text(kingdomPlayer.toString())));
        }
        return false;
    }
}
