package character.monster;


import java.util.ArrayList;

import character.Character;
import character.heros.Human;

public abstract class Monster extends Character{

    static ArrayList<Monster> monsters = new ArrayList<>();
    static ArrayList<Character> attackables;
    static ArrayList<Human> praty;
    static ArrayList<Human> attackableHeros;
    static ArrayList<Character> characters;
    static int damage = 0;
    static int sumExp = 0;
    static ArrayList<Monster> monstersExp;

    public Monster(){

    }

   public static void createMonsters(ArrayList<Character> characters, ArrayList<Monster> monsters){

       java.util.Random  r = new java.util.Random();
       int p = r.nextInt(5) + 1;
       char[] ch = {'A','B','C','D','E'};


       for(int q = 1; q <= p; q++){
           Monster m = new Kinoko(ch[q-1]);
           characters.add(m);
           monsters.add(m);
       }
   }

   public static void appears(ArrayList<Monster> monsters){

       System.out.println();
       System.out.println();
       for(int i = 0; i < monsters.size(); i++){
           System.out.println(monsters.get(i).individualName() + "が現れた！");
       }
   }


   public String individualName(){
       return super.getName() + super.getCh();
   }



    public void attack(Human h,ArrayList<Character> characters,  ArrayList<Character> attackables, ArrayList<Human> attackableHeros){

        System.out.println();
        System.out.println();
        System.out.println(this.individualName() + "の攻撃");

        //防御コマンドを選択していないとき
        if(h.getBuffDefence() == 0){
            damage = (int)(this.getOffence() - (int)h.getDefence());
        }else{
        //防御コマンド選択時
            damage = (int)(this.getOffence() - (int)h.getBuffDefence());
        }

        if(damage > 0) {
          h.setHp(h.getHp() - damage);
         System.out.println(h.getName() + " は " + this.individualName() + " から " + damage + " のダメージを受けた！");

          } else {
         System.out.println("ミス！ " + h.getName() + " は " + this.individualName() + "からダメージを受けなかった！");

          }
        if(h.getHp() <= 0){
            h.knockedDown(attackables, attackableHeros);
        }
        System.out.println();
    }

    public void knockedDown(ArrayList<Character> characters,
                                ArrayList<Character> attackables,
                                ArrayList<Monster> monsters){

        System.out.println(this.individualName() + "をやっつけた！");

        //戦線離脱
        attackables.remove(this); // 後でclear()しているが念のため
        monsters.remove(this);
        characters.remove(this);

    }

    public void runAway(){
        System.out.println(this.individualName() + "は逃げ出した！");
    }


}
