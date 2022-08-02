package character.heros;


import java.util.ArrayList;

import character.Character;
import character.monster.Monster;
import description.D;
import equipment.Weapon;
import process.V;

public abstract class Human extends Character {


    private String name;
    private Weapon weapon;

    static ArrayList<Character> attackables;
    static ArrayList<Character> characters;
    static ArrayList<Human> attackableHeros;
    static ArrayList<Monster> monsters;
    static int damage;


    public Human(String name, Weapon weapon, ArrayList<Character> characters, ArrayList<Human> party){
        super(name, characters);
        super.setLevel(1);
        super.setType("human");
        this.weapon = weapon;
        super.setExp(0);

        party.add(this);

    }

    public abstract void skill(ArrayList<Character> characters,
                                    ArrayList<Character> attackables,
                                    ArrayList<Human> party,
                                    ArrayList<Human> attackableHeros,
                                    ArrayList<Monster> monsters,
                                    Human h);

    public abstract void statusUp();

    public void defend(){
        super.setBuffDefence((double)super.getDefence() * 1.5);
    }

    public static void cancelDefend(Human h){
            h.setBuffDefence(0);
    }

    public static void cancelDefend(ArrayList<Human> party){
        for(int i = 0; i < party.size(); i++){
            party.get(i).setBuffDefence(0);
        }
    }

    public void attack(Monster m,
                        ArrayList<Character> characters,
                        ArrayList<Character> attackables,
                        ArrayList<Human> party,
                        ArrayList<Monster> monsters){

        System.out.println();
        System.out.println();
        System.out.println(super.getName() + "の攻撃");

        if(super.getBuffOffence() == 0){
            damage = (int)(super.getOffence() + this.weapon.getOp() - m.getDefence());
        }else{
            damage = (int)(super.getBuffOffence() + this.weapon.getOp() - m.getDefence());
        }

        if(damage > 0) {
          m.setHp(m.getHp() - damage);
         System.out.println(this.getName() + " は " + m.individualName() + " に " + damage + " のダメージを与えた！");

        } else {
         System.out.println("ミス！ " + this.getName() + " は " + m.individualName() + " にダメージを与えられない！");

        }

        if(m.getHp() <= 0){
            m.knockedDown(characters , attackables, monsters);

        }

        System.out.println();
    }

    public void knockedDown(ArrayList<Character> attackables,
                                ArrayList<Human> attackableHeros){

            System.out.println(super.getName() + "は倒されてしまった！");

            //戦線離脱
            attackables.remove(this);
            attackableHeros.remove(this);

    }

    public static void runAway(ArrayList<Character> characters, ArrayList<Monster> monsters){
        System.out.println("モンスター達から逃げた。");
        for(int j = 0; j < monsters.size(); j++){
            characters.remove(monsters.get(j));
        }
            monsters.clear();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public static void status(ArrayList<Human> party, ArrayList<Monster> monsters){

        // ステータスの表示
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");

        for(int i = 0; i < party.size(); i++){
            System.out.printf("%14s"," " +  party.get(i).getName() + ": Lv" +   V.toFullWidth(Integer.toString(party.get(i).getLevel())));
        }

        System.out.println();

        for(int i = 0; i < party.size(); i++){
            if(party.get(i).getHp() >= 0){
                System.out.printf("%14s","　ＨＰ:" + (int)(party.get(i).getHp()));
            }else{
                System.out.printf("%14s","ＨＰ:　０");
            }
        }
        System.out.println();

        for(int i = 0; i < party.size(); i++){
            System.out.printf("%14s","　ＭＰ:" + ((int)party.get(i).getMp()));
        }
        System.out.println();

        for(int i = 0; i < party.size(); i++){
            System.out.printf("%14s","ＥＸＰ:" + (int)(party.get(i).getExp()));
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
        D.monsters(monsters);
        System.out.println();
    }

    public void levelUp(){

        if(super.getExp() >= (20 + super.getLevel() * 50)){
            super.setLevel(super.getLevel() + 1);
            System.out.println();
            System.out.println(super.getName() + "はレベルが" + super.getLevel() + "にあがった！！");
            System.out.println();
        }
    }





}
