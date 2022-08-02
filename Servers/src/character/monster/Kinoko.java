package character.monster;

public class Kinoko extends Monster{

    public Kinoko(char ch){
        super.setName("お化けキノコ");
        super.setCh(ch);
        super.setType("plant");
        super.setHp(60);
        super.setMaxHp(60);
        super.setMp(30);
        super.setMaxMp(30);
        super.setOffence(25);
        super.setDefence(20);
        super.setAgility(15);
        super.setExp(5);

        super.setLevel(1);

    }
}
