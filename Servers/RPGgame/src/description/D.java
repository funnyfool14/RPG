package description;

import java.util.ArrayList;

import character.Character;
import character.heros.Human;
import character.monster.Monster;
import commands.C;

public class D {



    public static void journeyS(){
        System.out.println();
        System.out.println();
        System.out.println("1. 旅に出る");
        System.out.println("2. 街へ行く");
        System.out.println("3. 酒と女に溺れる");
    }

    public static void townS(){
        System.out.println();
        System.out.println();
        System.out.println("何をしますか？");
        System.out.println();
        System.out.println("1. 武器を買う");
        System.out.println("2. 防具を買う");
        System.out.println("3. 仲間を雇う");
    }

    public static void actionS(){
        System.out.println();
        System.out.println("1. 戦う");
        System.out.println("2. 逃げる");
        System.out.println("3. 会話する");
    }

    public static void monsters(ArrayList<Monster> monsters){
        String monster =" (ﾟДﾟ)";
        System.out.println();

        for(int i = 0; i < monsters.size(); i++){
            System.out.print(monster);
        }

        System.out.println();
    }

    public static void battleS(Human h){
        System.out.println();
        System.out.println();
        System.out.println(h.getName());
        System.out.println();
        System.out.println("1. 攻撃");
        System.out.println("2. 特技");
        System.out.println("3. 防御");
    }

    public static void gameStart(){
        System.out.println("Ｇａｍｅ Ｓｔａｒｔ！！");
        System.out.println();
        System.out.println();
        System.out.println("勇者の名前を決めてください。");
    }

    public static void gameOver(ArrayList<Character> characters, ArrayList<Human> party, ArrayList<Monster> monsters){
        System.out.println("全滅！！！！");
        System.out.println("Ｇａｍｅ Ｏｖｅｒ・・・orz");
        System.out.println();
        System.out.println();
        System.out.println("ゲームを続けますか？");
        System.out.println("1. はい");
        System.out.println("2. いいえ");
        System.out.println("3. 酒に逃げる");

        C.gameOver(characters, party, monsters);
    }
}
