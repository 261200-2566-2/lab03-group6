public class Character {
    private String name;
    private int level = 1;
    private int hp = 100;
    private int money = 100;
    private int maxHP = 200;
    private int mana;
    private double runSpeed = 1;
    private double maxRunSpeed = 10;
    private int atk;
    private int def;
    private Sword sword = new Sword();
    private Shield shield = new Shield();
    public Character(String name){
        this.name = name;
    }
    public void showInfo(){
        System.out.println("Name: " + name);
        System.out.println("HP: " + hp);

    }
    public int attack(){
        return hp;
    }
    public int beAttacked(){
        return hp;
    }
    public void upgradeSword(){
        if(money >= sword.getUpgradePrice()){

        }else System.out.println("There is not enough money to upgrade the sword.");
    }
    public void upgradeShield(){
        if(money >= shield.getUpgradePrice()){

        }else System.out.println("There is not enough money to upgrade the shield.");
    }
    public boolean isDead(){
        if(hp <= 0) return true;
        return false;
    }

}
