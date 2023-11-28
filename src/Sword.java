public class Sword {
    private int level = 1;
    private double damage = 1;
    private double weight = 1; // มีผลต่อ runSpeed
    private int upgradePrice = 100;

    public Sword(){}
    public void upgrade(){
        level++;
        damage  *= 1+0.1*level;
        weight *= 0.1+0.04*level;
        upgradePrice *= 2;
    }
    public int getLevel(){
        return level;
    }

    public double getDamage() {
        return damage;
    }
    public double getWeight() {
        return weight;
    }
    public int getUpgradePrice() {
        return upgradePrice;
    }
}
