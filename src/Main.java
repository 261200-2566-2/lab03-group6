// Design
// แบ่งเป็น 3 class ได้แก่ Character, Sword และ Shield
//
// 1.Character
// 1.1 instance variables
//    String: name
//    int: money, hp, maxHP, mana, maxMana
//    double: runSpeed, maxRunSpeed, atk, def
//    boolean: hasSwordEquipped, hasShieldEquipped
//    Sword: sword
//    Shield: shield
// 1.2 instance methods
//    void: showInfo, attack, beAttacked, upgradeSword, upgradeShield, equipSword, unEquipSword, equipShield, unEquipShield,
//    String: getName
//    int: getLevel, getHp, getMana, getMoney, getSwordLV, getShieldLV
//    double: getAtk, getDef, getRunSpeed
//    boolean: isDead, getSwordEquipped, getShieldEquipped
// 1.3 class variable
//    int: count
// 1.4 class method
//    int: getCount
//
// 2.Sword
// 2.1 instance variables
//    int: level, upgradePrice
//    double: damage, weight
// 2.2 instance methods
//    void: upgrade
//    int: getLevel, getUpgradePrice
//    double: getDamage, getWeight
//
// 3.Shield
// 3.1 instance variables
//    int: level, upgradePrice
//    double: defense, weight
// 3.2 instance methods
//    void: upgrade
//    int: getLevel, getUpgradePrice
//    double: getDefense, getWeight
public class Main {
    public static void main(String[] args) {
        Character a = new Character("A");
        Character b = new Character("B");
        System.out.println(Character.getCount());
        a.showInfo();
        b.showInfo();
        a.equipSword();
        a.equipShield();
        a.showInfo();
        for(int i = 0; i < 20; i++)  a.attack(b);
        a.showInfo();
        b.showInfo();
        System.out.println(b.isDead());
        System.out.println(Character.getCount());
        a.attack(b);
        a.showInfo();
        a.upgradeSword();
        a.upgradeShield();
        a.showInfo();
    }
}