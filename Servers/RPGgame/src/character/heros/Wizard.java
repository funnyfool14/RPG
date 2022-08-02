package character.heros;

import java.util.ArrayList;

import character.Character;
import character.monster.Monster;
import commands.C;
import equipment.Cane;

public class Wizard extends Human{

    private Cane cane;
    int damage = 0;

    public Wizard(String name,  Cane cane, ArrayList<Character> character, ArrayList<Human> party){
        super(name, cane, character, party);
        super.setHp(60);
        super.setMaxHp(60);
        super.setMp(70);
        super.setMaxMp(70);
        super.setOffence(5);
        super.setDefence(100);//10
        super.setAgility(10);
        this.cane = cane;

    }


    @Override
    public void attack(Monster m,
            ArrayList<Character> characters,
            ArrayList<Character> attackables,
            ArrayList<Human> party,
            ArrayList<Monster> monsters) {


         damage = this.cane.getMp();

         if(super.getMp() >= this.cane.getCost()){
             super.setMp(super.getMp() - this.cane.getCost());

             System.out.println();
             System.out.println();
             System.out.println(super.getName() + "の攻撃！");
             System.out.println(super.getName() + " は " + m.individualName() + " に魔法で " + damage + " のダメージを与えた！");

             if(m.getHp() <= 0){
                 m.knockedDown(characters, attackables, monsters);
             }
         }else{
             System.out.println("ＭＰが足りない・・・");
             C.battle(characters, attackables, party, attackableHeros, monsters, this);
         }
         System.out.println();
    }


    @Override
    public void skill(ArrayList<Character> characters,
                        ArrayList<Character> attackables,
                        ArrayList<Human> party,
                        ArrayList<Human> attackableHeros,
                        ArrayList<Monster> monsters,
                        Human h){

        int mpUp = (int)(Math.min(super.getMaxMp() - super.getMp(), 30));
        super.setMp(super.getMp() + mpUp);

        System.out.println();
        System.out.println();
        System.out.println(super.getName() + "はエロいことを考えた");
        System.out.println("ＭＰが" + mpUp + "回復した");
    }


    @Override
    public void statusUp() {

        super.setMaxHp(getMaxHp() * 1.2);
        super.setMaxMp(super.getMaxMp() * 1.3);
        super.setOffence(super.getOffence() * 1.1);
        super.setDefence(super.getDefence() * 1.2);
        super.setAgility(super.getAgility() * 1.1);


    }


}
