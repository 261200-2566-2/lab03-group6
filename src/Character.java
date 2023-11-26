public class Character {
    private String name;
    private int level = 1;
    private int money = 500;
    private int hp = 100;
    private int maxHP = 100+10*level;
    private int mana = 10;
    private int maxMana = 50+2*level;
    private double runSpeed = 10;
    private double maxRunSpeed = runSpeed*(0.1+0.03*level);
    private double atk = 10;
    private double def = 5;
    private Sword sword = new Sword();
    private Shield shield = new Shield();
    public Character(String name){
        this.name = name;
    }
    public void showInfo(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Run speed: " + runSpeed);
        System.out.println("Sword LV: " + sword.getLevel());
        System.out.println("Shield LV: " + shield.getLevel());
        System.out.println("Money: $" + money);
        System.out.println("--------------------------------------------------------");
    }
    public void attack(Character opp){
        opp.beAttacked(atk);
        mana++;
        if(opp.isDead()){
            money += opp.getMoney()*opp.getLevel();
            level++;
            runSpeed++;
            hp = maxHP;
            mana = maxMana;
        }
    }
    public void beAttacked(double oppAtk){
        double dmg = 0;
        if(oppAtk > def){
            dmg = oppAtk-def;
        }
        hp -= (int) dmg;
        if(hp <= 0) hp = 0;
    }
    public void upgradeSword(){
        if(money >= sword.getUpgradePrice()){
            money -= sword.getUpgradePrice();
            sword.upgrade();
            atk += sword.getDamage();
            runSpeed -= sword.getWeight();
        }else System.out.println("There is not enough money to upgrade the sword.");
    }
    public void upgradeShield(){
        if(money >= shield.getUpgradePrice()){
            money -= shield.getUpgradePrice();
            shield.upgrade();
            def += shield.getDefense();
            runSpeed -= shield.getWeight();
        }else System.out.println("There is not enough money to upgrade the shield.");
    }
    public boolean isDead(){
        if(hp <= 0) return true;
        return false;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }

    public double getAtk() {
        return atk;
    }

    public double getDef() {
        return def;
    }
    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }
    public double getRunSpeed() {
        return runSpeed;
    }
    public int getSwordLV(){
        return sword.getLevel();
    }
    public int getShieldLV(){
        return shield.getLevel();
    }
    public int getMoney() {
        return money;
    }



}
