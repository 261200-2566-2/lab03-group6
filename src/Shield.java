public class Shield {
    private int level = 1;
    private double defense = 1;
    private double weight = 1;
    private int upgradePrice = 100;
    public Shield(){}
    public void upgrade(){
        level++;
        defense  *= 1+0.1*level;
        weight *= 0.1+0.08*level;
        upgradePrice *= 3;
    }
    public int getLevel() {
        return level;
    }
    public double getDefense(){
        return defense;
    }
    public double getWeight() {
        return weight;
    }

    public int getUpgradePrice() {
        return upgradePrice;
    }
}
