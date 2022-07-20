package fr.kingdomsky.kingdomapi.player.events;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import fr.kingdomsky.kingdomapi.player.config.PlayerConfig;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    public JoinEvent() {
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException {
        Player p = event.getPlayer();
        if (((List) KingdomAPI.getListPlayers().stream().filter((kingdomPlayerx) -> {
            return kingdomPlayerx.getPlayer() == p;
        }).collect(Collectors.toList())).isEmpty()) {

            PlayerConfig.createLoadConfigPlayer(p);

            KingdomPlayer kingdomPlayer = new KingdomPlayer(p);
            KingdomAPI.getListPlayers().add(kingdomPlayer);
        }
    }

    private boolean checkConfig(Player p) {
        return false;
    }
}
