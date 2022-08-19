package fr.kingdomsky.kingdomapi.objects;

public class Jobs {
    /** Qu'est-ce qu'un job ?
     * Un métier est un event qui permet de gagné de l'argent ou d'avoir des atouts.
     * Qu'elle est le but d'un métier ?
     * Les atouts, l'argent
     * Objets:
     * Nom du métier
     * Expérience requise
     * Level actuelle
     * Boost actuelle (ex: x2.5)*/

    private String name;
    // XP/Level actuelle du job
    private Double xp;
    private int level;
    // XP requis
    private Double xpRequired;
    private Double boost;

    public Jobs(String name, Double xp, int level, Double xpRequired, Double boost) {
        this.name = name;
        this.xp = xp;
        this.level = level;
        this.xpRequired = xpRequired;
        this.boost = boost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getXp() {
        return xp;
    }

    public void setXp(Double xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Double getXpRequired() {
        return xpRequired;
    }

    public void setXpRequired(Double xpRequired) {
        this.xpRequired = xpRequired;
    }

    public Double getBoost() {
        return boost;
    }

    public void setBoost(Double boost) {
        this.boost = boost;
    }
}
