package fr.kingdomsky.kingdomapi;

import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;
import fr.kingdomsky.kingdomapi.commands.TestCommand;
import fr.kingdomsky.kingdomapi.player.events.JoinEvent;
import fr.kingdomsky.kingdomapi.player.events.LeaveEvent;
import fr.kingdomsky.kingdomapi.utils.ecoUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class KingdomAPI extends JavaPlugin {

    private static KingdomAPI instance;
    public static String path = "plugins/KingdomAPI/";
    public static List<KingdomPlayer> listPlayers = new ArrayList<>();;

    @Override
    public void onEnable() {
        instance = this;

        // Event Player
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);
        getCommand("test").setExecutor(new TestCommand());


        // Economie
        if (!ecoUtil.setupEconomy() ) {
            Logger.getLogger("Minecraft").severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    public static KingdomAPI getInstance() {
        return instance;
    }
}


