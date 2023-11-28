public class Character {
    public static int count;
    public static int getCount() {
        return count;
    }
    private String name;
    private int level = 1;
    private int money = 500;
    private int hp = 100;
    private int maxHP = 100+10*level;
    private int mana = 10;
    private int maxMana = 50+2*level;
    private double runSpeed = 10;
    private double maxRunSpeed = runSpeed*(1+0.3*level);
    private double atk = 10;
    private double def = 5;
    private Sword sword = new Sword();
    private Shield shield = new Shield();
    private boolean hasSwordEquipped = false;
    private boolean hasShieldEquipped = false;
    public Character(String name){ // Constructor
        this.name = name;
        count++;
    }
    public void showInfo(){ // แสดงข้อมูลตต่าง ๆ ของตัวละคร
        System.out.println("--------------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Run speed: " + runSpeed);
        System.out.println("Equipped Items:");
        System.out.print("   Sword: ");
        if (hasSwordEquipped) System.out.println("Level " + sword.getLevel());
        else System.out.println("No sword equipped");
        System.out.print("   Shield: ");
        if (hasShieldEquipped) System.out.println("Level " + shield.getLevel());
        else System.out.println("No shield equipped");
        System.out.println("Money: $" + money);
        System.out.println("--------------------------------------------------------");
    }
    public void attack(Character opp){ // โจมตี: ถ้าโจมตีแล้วคู่ต่อสู้ตาย จะได้รับเงินและค่าพลังเพิ่มขึ้น
        if(opp.isDead()) return;
        opp.beAttacked(atk);
        if(mana < maxMana) mana++;
        if(runSpeed < maxRunSpeed) runSpeed += 0.1;
        if(opp.isDead()){
            money += opp.getMoney()*opp.getLevel();
            level++;
            runSpeed = maxRunSpeed;
            hp = maxHP;
            mana = maxMana;
        }
    }
    public void beAttacked(double oppAtk){ // โดนโจมตี: hp จะลดลงตาม dmg ในครั้งนั้น ๆ
        double dmg = 0;
        if(oppAtk > def) dmg = oppAtk-def;
        hp -= (int) dmg;
        if(hp <= 0){
            hp = 0;
            count--;
        }
    }
    public void upgradeSword(){ // อัพเกรดดาบ
        if(money >= sword.getUpgradePrice()){
            money -= sword.getUpgradePrice();
            sword.upgrade();
            atk += sword.getDamage();
            runSpeed -= sword.getWeight();
        }else System.out.println("There is not enough money to upgrade the sword.");
    }
    public void upgradeShield(){ // อัพเกรดโล่
        if(money >= shield.getUpgradePrice()){
            money -= shield.getUpgradePrice();
            shield.upgrade();
            def += shield.getDefense();
            runSpeed -= shield.getWeight();
        }else System.out.println("There is not enough money to upgrade the shield.");
    }
    public boolean isDead(){ // เช็คว่าตายแล้วหรือยัง
        if(hp <= 0) return true;
        return false;
    }
    public void equipSword() { // ใช้ดาบ: atk เพิ่มขึ้น
        if (!hasSwordEquipped) {
            atk += sword.getDamage();
            runSpeed -= sword.getWeight();
            hasSwordEquipped = true;
            System.out.println(name + " has equipped the sword.");
        } else System.out.println(name + " already has a sword equipped.");
    }
    public void unEquipSword() { // ถอดดาบ
        if (hasSwordEquipped) {
            atk -= sword.getDamage();
            runSpeed += sword.getWeight();
            hasSwordEquipped = false;
            System.out.println(name + " has unequipped the sword.");
        } else System.out.println(name + " does not have a sword equipped.");
    }
    public void equipShield() { // ใช้โล่: def เพิ่มขึ้น
        if (!hasShieldEquipped) {
            def += shield.getDefense();
            runSpeed -= shield.getWeight();
            hasShieldEquipped = true;
            System.out.println(name + " has equipped the shield.");
        } else System.out.println(name + " already has a shield equipped.");
    }
    public void unEquipShield() { // ถอดโล่
        if (hasShieldEquipped) {
            def -= shield.getDefense();
            runSpeed += shield.getWeight();
            hasShieldEquipped = false;
            System.out.println(name + " has unequipped the shield.");
        } else System.out.println(name + " does not have a shield equipped.");
    }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public double getAtk() { return atk; }
    public double getDef() { return def; }
    public int getHp() { return hp; }
    public int getMana() { return mana; }
    public double getRunSpeed() { return runSpeed; }
    public int getMoney() { return money; }
    public boolean getSwordEquipped() { return hasSwordEquipped; }
    public boolean getShieldEquipped() { return hasShieldEquipped; }
    public int getSwordLV(){ return sword.getLevel(); }
    public int getShieldLV(){ return shield.getLevel(); }
}
