package character.heros;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.Character;
import character.monster.Monster;
import commands.C;
import equipment.Mace;


public class Cleric extends Human {

    private Mace mace;

    public Cleric(String name, Mace mace, ArrayList<Character> characters, ArrayList<Human> party){
        super(name, mace, characters, party);
        super.setHp(70);
        super.setMaxHp(70);
        super.setMp(50);
        super.setMaxMp(70);
        super.setOffence(1000);//10
        super.setDefence(15);
        super.setAgility(5);
        this.mace = mace;

    }

    @Override
    public void skill(ArrayList<Character> characters,
                        ArrayList<Character> attackables,
                        ArrayList<Human> party,
                        ArrayList<Human> attackableHeros,
                        ArrayList<Monster> monsters,
                        Human h){

        int mp = (int) super.getMp();

        if(mp >= this.mace.getCost()){

            System.out.println();
            System.out.println();
            System.out.println("誰を回復しますか？");
            System.out.println();

            for(int i = 0; i < attackableHeros.size(); i++){
                System.out.println((i+1) + ". " + attackableHeros.get(i).getName());
            }

            Scanner sc = new Scanner(System.in);

            int num = Integer.parseInt(sc.nextLine());


            super.setMp(super.getMp() - this.mace.getCost());
            attackableHeros.get(num - 1).setHp(attackableHeros.get(num - 1).getHp() + this.mace.getRm());

            System.out.println();
            System.out.println(attackableHeros.get(num - 1).getName() + "は、魔法でＨＰが" + this.mace.getRm() + "回復した！");

        }else{
            System.out.println("ＭＰが足りない・・・");
            C.battle(characters, attackables, party, attackableHeros, monsters, this);
            }
    }

    public void pray(int sec){
        System.out.println(super.getName() + "は" + sec + "秒間天に祈った！");
        int recover = new Random().nextInt(3) + sec;

        int mpUp = (int)(Math.min(super.getMaxMp() - super.getMp(), recover)); //Math.min(a,b) aとbを比較して小さい方を返す
        super.setMp(super.getMp() + mpUp);

        System.out.println("MPが" + mpUp + "回復した");

    }

    @Override
    public void statusUp() {

        super.setMaxHp(getMaxHp() * 1.3);
        super.setMaxMp(super.getMaxMp() * 1.2);
        super.setOffence(super.getOffence() * 1.2);
        super.setDefence(super.getDefence() * 1.1);
        super.setAgility(super.getAgility() * 1.1);


    }

}
