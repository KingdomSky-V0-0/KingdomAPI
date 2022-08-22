package fr.kingdomsky.kingdomapi.objects;

import fr.kingdomsky.kingdomapi.KingdomAPI;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class KingdomPlayer {
    private UUID playerUUID;
    private Player player;
    private Date saveDate;
    private double money;
    private double life;
    private double defense;
    private double speed;
    private double damage;
    private double damageCritical;
    private Jobs minerJob;
    private Jobs lumberJob;
    private Jobs hunterJob;
    private Jobs farmerJob;

    public KingdomPlayer(Player player) throws ParseException {
        this.player = player;
        this.playerUUID = player.getUniqueId();

        File playerFile = new File(KingdomAPI.path + "players/" + player.getUniqueId() + "/info.yml");

        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);

        this.saveDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(playerConfig.getString("Date-Save"));
        this.money = playerConfig.getDouble("statistiques.money");
        this.life = playerConfig.getDouble("statistiques.life");
        this.defense = playerConfig.getDouble("statistiques.defense");
        this.speed = playerConfig.getDouble("statistiques.speed");
        this.damage = playerConfig.getDouble("statistiques.damage");
        this.damageCritical = playerConfig.getDouble("statistiques.damageCritical");
        this.minerJob = new Jobs(playerConfig.getString("jobs.miner.name"),
                playerConfig.getDouble("jobs.miner.xp"),
                playerConfig.getInt("jobs.miner.level"),
                playerConfig.getDouble("jobs.miner.xpRequired"),
                playerConfig.getDouble("jobs.miner.boost"));
        this.lumberJob = new Jobs(playerConfig.getString("jobs.lumber.name"),
                playerConfig.getDouble("jobs.lumber.xp"),
                playerConfig.getInt("jobs.lumber.level"),
                playerConfig.getDouble("jobs.lumber.xpRequired"),
                playerConfig.getDouble("jobs.lumber.boost"));
        this.hunterJob = new Jobs(playerConfig.getString("jobs.hunter.name"),
                playerConfig.getDouble("jobs.hunter.xp"),
                playerConfig.getInt("jobs.hunter.level"),
                playerConfig.getDouble("jobs.hunter.xpRequired"),
                playerConfig.getDouble("jobs.hunter.boost"));
        this.farmerJob = new Jobs(playerConfig.getString("jobs.farmer.name"),
                playerConfig.getDouble("jobs.farmer.xp"),
                playerConfig.getInt("jobs.farmer.level"),
                playerConfig.getDouble("jobs.farmer.xpRequired"),
                playerConfig.getDouble("jobs.farmer.boost"));
    }

    public KingdomPlayer(UUID playerUUID, Player player, Date saveDate, double money, double life, double defense, double speed, double damage, double damageCritical, Jobs minerJob, Jobs lumberJob, Jobs hunterJob, Jobs farmerJob) {
        this.playerUUID = playerUUID;
        this.player = player;
        this.saveDate = saveDate;
        this.money = money;
        this.life = life;
        this.defense = defense;
        this.speed = speed;
        this.damage = damage;
        this.damageCritical = damageCritical;
        this.minerJob = minerJob;
        this.lumberJob = lumberJob;
        this.hunterJob = hunterJob;
        this.farmerJob = farmerJob;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamageCritical() {
        return damageCritical;
    }

    public void setDamageCritical(double damageCritical) {
        this.damageCritical = damageCritical;
    }

    public Jobs getMinerJob() {
        return minerJob;
    }

    public void setMinerJob(Jobs minerJob) {
        this.minerJob = minerJob;
    }

    public Jobs getLumberJob() {
        return lumberJob;
    }

    public void setLumberJob(Jobs lumberJob) {
        this.lumberJob = lumberJob;
    }

    public Jobs getHunterJob() {
        return hunterJob;
    }

    public void setHunterJob(Jobs hunterJob) {
        this.hunterJob = hunterJob;
    }

    public Jobs getFarmerJob() {
        return farmerJob;
    }

    public void setFarmerJob(Jobs farmerJob) {
        this.farmerJob = farmerJob;
    }

    public static KingdomPlayer getPlayerInList(UUID uuid) {
        Bukkit.broadcast(Component.text(uuid.toString()));
        Bukkit.broadcast(Component.text(KingdomAPI.getListPlayers().toString()));
        return KingdomAPI.getListPlayers().stream().filter((kingdomPlayer) -> kingdomPlayer.getPlayerUUID().equals(uuid)).collect(Collectors.toList()).get(0);
    }

    public String toString() {
        return "KingdomPlayer{playerUUID=" + this.playerUUID + ", player=" + this.player + ", saveDate=" + this.saveDate + ", money=" + this.money + ", life=" + this.life + ", defense=" + this.defense + ", speed=" + this.speed + ", damage=" + this.damage + ", damageCritical=" + this.damageCritical + ", minerJob=" + this.minerJob + ", lumberJob=" + this.lumberJob + ", hunterJob=" + this.hunterJob + ", farmerJob=" + this.farmerJob + '}';
    }
}
