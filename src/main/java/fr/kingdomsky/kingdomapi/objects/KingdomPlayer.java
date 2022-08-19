package fr.kingdomsky.kingdomapi.objects;

import fr.kingdomsky.kingdomapi.KingdomAPI;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

public class KingdomPlayer {

    // Player
    private UUID playerUUID;
    private Player player;
    private Date saveDate;
    private double money;

    // Stat
    private double life;
    private double defense;
    private double speed;
    private double damage;
    private double damageCritical;

    // Jobs
    private Jobs minerJob;
    private Jobs lumberJob;
    private Jobs hunterJob;
    private Jobs fisherJob;


    // Constructeur
    public KingdomPlayer(Player player) {
        this.player = player;
        this.playerUUID = player.getUniqueId();
    }

    public KingdomPlayer(Player player, Date saveDate, double money, double life, double defense, double speed, double damage, double damageCritical, Jobs minerJob, Jobs lumberJob, Jobs hunterJob, Jobs fisherJob) {
        this.playerUUID = player.getUniqueId();
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
        this.fisherJob = fisherJob;
    }


    // Getter and Setter
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

    public Jobs getFisherJob() {
        return fisherJob;
    }

    public void setFisherJob(Jobs fisherJob) {
        this.fisherJob = fisherJob;
    }

    public static KingdomPlayer getPlayerInList(UUID uuid){
        return KingdomAPI.getListPlayers().stream().filter(kingdomPlayer -> kingdomPlayer.getPlayerUUID().equals(uuid)).collect(Collectors.toList()).get(0);
    }

    @Override
    public String toString() {
        return "KingdomPlayer{" +
                "playerUUID=" + playerUUID +
                ", player=" + player +
                ", saveDate=" + saveDate +
                ", money=" + money +
                ", life=" + life +
                ", defense=" + defense +
                ", speed=" + speed +
                ", damage=" + damage +
                ", damageCritical=" + damageCritical +
                ", minerJob=" + minerJob +
                ", lumberJob=" + lumberJob +
                ", hunterJob=" + hunterJob +
                ", fisherJob=" + fisherJob +
                '}';
    }
}
