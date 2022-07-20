package fr.kingdomsky.kingdomapi.utils;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class ecoUtil {
    public static Economy econ = null;

    public ecoUtil() {
    }

    public static boolean setupEconomy() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        } else {
            RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp == null) {
                return false;
            } else {
                econ = (Economy)rsp.getProvider();
                return econ != null;
            }
        }
    }

    public static Double getPlayerMoney(Player p) {
        return econ.getBalance(p);
    }

    public static EconomyResponse removePlayerMoney(Player p, Double amount) {
        return econ.withdrawPlayer(p, amount);
    }

    public static EconomyResponse addPlayerMoney(Player p, Double amount) {
        return econ.depositPlayer(p, amount);
    }

    public static EconomyResponse setPlayerMoney(Player p, Double amount) {
        econ.withdrawPlayer(p, getPlayerMoney(p));
        return econ.depositPlayer(p, amount);
    }
}
