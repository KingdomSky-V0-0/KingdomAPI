package fr.kingdomsky.kingdomapi.player.events;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import fr.kingdomsky.kingdomapi.objects.KingdomPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.stream.Collectors;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();

        if (KingdomAPI.getListPlayers().stream().filter(kingdomPlayer -> kingdomPlayer.getPlayer() == p).collect(Collectors.toList()).isEmpty()){

            if(checkConfig(p)){

            }
            KingdomPlayer kingdomPlayer = new KingdomPlayer(p);
            KingdomAPI.getListPlayers().add(kingdomPlayer);
        }
    }

    private boolean checkConfig(Player p) {


        return false;
    }

}
