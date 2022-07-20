package fr.kingdomsky.kingdomapi;

import fr.kingdomsky.kingdomapi.commands.TestCommand;
import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;
import fr.kingdomsky.kingdomapi.player.events.JoinEvent;
import fr.kingdomsky.kingdomapi.player.events.LeaveEvent;
import fr.kingdomsky.kingdomapi.utils.ecoUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KingdomAPI extends JavaPlugin {
    private static KingdomAPI instance;
    public static String path = "plugins/KingdomAPI/";
    private static List<KingdomPlayer> listPlayers;

    public KingdomAPI() {
    }

    public void onEnable() {
        instance = this;
        listPlayers = new ArrayList();
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);
        this.getCommand("test").setExecutor(new TestCommand());
        if (!ecoUtil.setupEconomy()) {
            Logger.getLogger("Minecraft").severe(String.format("[%s] - Disabled due to no Vault dependency found!", this.getDescription().getName()));
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    public static KingdomAPI getInstance() {
        return instance;
    }

    public static List<KingdomPlayer> getListPlayers() {
        return listPlayers;
    }
}