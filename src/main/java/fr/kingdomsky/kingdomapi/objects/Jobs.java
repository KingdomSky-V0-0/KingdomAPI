package fr.kingdomsky.kingdomapi.objects;

public class Jobs {
    private String name;
    private Double xp;
    private int level;
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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getXp() {
        return this.xp;
    }

    public void setXp(Double xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Double getXpRequired() {
        return this.xpRequired;
    }

    public void setXpRequired(Double xpRequired) {
        this.xpRequired = xpRequired;
    }

    public Double getBoost() {
        return this.boost;
    }

    public void setBoost(Double boost) {
        this.boost = boost;
    }
}
