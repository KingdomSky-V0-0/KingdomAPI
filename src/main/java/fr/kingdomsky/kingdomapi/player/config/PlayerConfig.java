package fr.kingdomsky.kingdomapi.player.config;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlayerConfig {

    public static void createLoadConfigPlayer(Player player) throws IOException {

        File playerFile = new File(KingdomAPI.path + "players/" + player.getUniqueId() + "/info.yml");
        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);

        if (!playerFile.exists()) {
            Files.createDirectory(Path.of(KingdomAPI.path + "players/" + player.getUniqueId() + "/"));
            playerFile.createNewFile();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            playerConfig.set("Date-Save", dtf.format(LocalDateTime.now()).toString());
            playerConfig.set("UUID", player.getUniqueId().toString());

            playerConfig.set("statistiques.money", 0);
            playerConfig.set("statistiques.life", 20);
            playerConfig.set("statistiques.defense", 0);
            playerConfig.set("statistiques.speed", 0);
            playerConfig.set("statistiques.damage", 0);
            playerConfig.set("statistiques.damageCritical", 0);


            playerConfig.set("jobs.miner.name", "Mineur");
            playerConfig.set("jobs.miner.xp", 0);
            playerConfig.set("jobs.miner.level", 0);
            playerConfig.set("jobs.miner.xpRequired", 250);
            playerConfig.set("jobs.miner.boost", 1);

            playerConfig.set("jobs.lumber.name", "Bûcheron");
            playerConfig.set("jobs.lumber.xp", 0);
            playerConfig.set("jobs.lumber.level", 0);
            playerConfig.set("jobs.lumber.xpRequired", 250);
            playerConfig.set("jobs.lumber.boost", 1);

            playerConfig.set("jobs.hunter.name", "Chasseur");
            playerConfig.set("jobs.hunter.xp", 0);
            playerConfig.set("jobs.hunter.level", 0);
            playerConfig.set("jobs.hunter.xpRequired", 250);
            playerConfig.set("jobs.hunter.boost", 1);

            playerConfig.set("jobs.farmer.name", "Fermier");
            playerConfig.set("jobs.farmer.xp", 0);
            playerConfig.set("jobs.farmer.level", 0);
            playerConfig.set("jobs.farmer.xpRequired", 250);
            playerConfig.set("jobs.farmer.boost", 1);

            playerConfig.save(playerFile);
        }
    }

}
