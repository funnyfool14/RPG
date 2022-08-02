package character.heros;

import java.util.ArrayList;

import character.Character;
import character.monster.Monster;
import commands.C;
import equipment.Sword;


public class Hero extends Human {

    private Sword sword;

    int mp;

    public Hero(String name, Sword sword,ArrayList<Character> characters, ArrayList<Human> party){
        super(name, sword, characters, party);
        super.setHp(100);
        super.setMaxHp(100);
        super.setMp(30);
        super.setMaxMp(30);
        super.setOffence(200);//20
        super.setDefence(20);
        super.setAgility(20);
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public static void createHero( ArrayList<Character> characters, ArrayList<Human> party){



    }

    @Override
    public void skill(ArrayList<Character> characters,
                        ArrayList<Character> attackables,
                        ArrayList<Human> party,
                        ArrayList<Human> attackableHeros,
                        ArrayList<Monster> monsters,
                        Human h){

        mp = (int) super.getMp();
        if(mp >= 8){
            super.setMp(mp -= 8);

            //攻撃力を上げてない状態
            if(super.getBuffOffence() == 0){

                super.setBuffOffence((double)super.getOffence() * 2.5);
                System.out.println();
                System.out.println();
                System.out.println(super.getName() + "はドーピングをうったので");
                System.out.println("次の攻撃の威力が上がった！");

                //攻撃力がすでに上がっている状態
            }else{

                super.setBuffOffence(super.getBuffOffence() * 2.5);
                System.out.println();
                System.out.println();
                System.out.println(super.getName() + "はドーピングをうったので");
                System.out.println("次の攻撃の威力が更に上がった！");

            }
        }else{
        System.out.println("ＭＰが足りない・・・");
        C.battle(characters, attackables, party, attackableHeros, monsters, this);
        }
    }

    @Override
    public void statusUp() {

        super.setMaxHp(getMaxHp() * 1.2);
        super.setMaxMp(super.getMaxMp() * 1.1);
        super.setOffence(super.getOffence() * 1.3);
        super.setDefence(super.getDefence() * 1.2);
        super.setAgility(super.getAgility() * 1.1);

    }


}
