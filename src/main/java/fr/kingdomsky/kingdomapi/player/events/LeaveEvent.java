package fr.kingdomsky.kingdomapi.player.events;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    public LeaveEvent() {
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        if (!((List)KingdomAPI.getListPlayers().stream().filter((kingdomPlayerx) -> {
            return kingdomPlayerx.getPlayerUUID().equals(p.getUniqueId());
        }).collect(Collectors.toList())).isEmpty()) {
            KingdomPlayer kingdomPlayer = (KingdomPlayer)((List)KingdomAPI.getListPlayers().stream().filter((kPlayer) -> {
                return kPlayer.getPlayerUUID().equals(p.getUniqueId());
            }).collect(Collectors.toList())).get(0);
            KingdomAPI.getListPlayers().remove(kingdomPlayer);
        }

    }
}
