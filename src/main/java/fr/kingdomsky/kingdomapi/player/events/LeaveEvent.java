package fr.kingdomsky.kingdomapi.player.events;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.stream.Collectors;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        Player p = event.getPlayer();

        if(!KingdomAPI.listPlayers.stream().filter(kingdomPlayer -> kingdomPlayer.getPlayerUUID().equals(p.getUniqueId())).collect(Collectors.toList()).isEmpty()) {

            KingdomPlayer kingdomPlayer = KingdomAPI.listPlayers.stream().filter(kPlayer -> kPlayer.getPlayerUUID().equals(p.getUniqueId())).collect(Collectors.toList()).get(0);
            KingdomAPI.listPlayers.remove(kingdomPlayer);
        }

    }
}
