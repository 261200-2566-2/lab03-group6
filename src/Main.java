public class Main {
    public static void main(String[] args) {
        Character a = new Character("A");
        Character b = new Character("B");
        a.showInfo();
        b.showInfo();
        for(int i = 0; i < 20; i++){
            a.attack(b);
        }
        a.showInfo();
        b.showInfo();
        System.out.println(b.isDead());
        a.upgradeSword();
        a.upgradeShield();
        a.showInfo();
    }
}