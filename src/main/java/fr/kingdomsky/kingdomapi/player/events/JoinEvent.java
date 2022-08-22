package fr.kingdomsky.kingdomapi.player.events;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import fr.kingdomsky.kingdomapi.player.config.PlayerConfig;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    public JoinEvent() {
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException, ParseException {
        Player p = event.getPlayer();
        if (((List) KingdomAPI.getListPlayers()
                .stream()
                .filter((kingdomPlayerx) -> kingdomPlayerx.getPlayer() == p)
                .collect(Collectors.toList())).isEmpty()) {
            Bukkit.broadcast(Component.text("je suis passé"));

            PlayerConfig.createLoadConfigPlayer(p);

            KingdomPlayer kingdomPlayer = new KingdomPlayer(p);
            KingdomAPI.getListPlayers().add(kingdomPlayer);
            Bukkit.broadcast(Component.text(KingdomAPI.getListPlayers().toString()));
        }
    }

    private boolean checkConfig(Player p) {
        return false;
    }
}
