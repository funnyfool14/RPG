package main;

import java.util.ArrayList;
import java.util.Scanner;

import character.Character;
import character.heros.Cleric;
import character.heros.Hero;
import character.heros.Human;
import character.heros.Wizard;
import character.monster.Monster;
import commands.C;
import description.D;
import equipment.Cane;
import equipment.Mace;
import equipment.Sword;
import process.V;

public class Main {


    static Human human;
    static Monster monster;
    static ArrayList<Character> characters = new ArrayList<>();
    static ArrayList<Human> party = new ArrayList<>();
    static ArrayList<Monster> monsters;
    static Hero h;
    static Wizard w;
    static Cleric c;


    public static void main(String[] args) {

        //new myFrame();

        D.gameStart();

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();


        Sword sword = new Sword("エクスカリバーのおもちゃ", 15, 0, 0);
        h = new Hero(V.toFullWidth(name), sword, characters, party);

        Cane cane = new Cane("魔法の杖", 0, 20, 5, 15);
        w = new Wizard("ハム太郎", cane, characters, party);

        Mace mace = new Mace("聖なる棍", 5, 0, 15, 10);
        c = new Cleric("牛衛門", mace, characters, party);

        System.out.println();
        System.out.println();
        System.out.println("勇者" + h.getName() + "は、いきり立って冒険にくり出した！");

        C.journey(characters, party);

        // agility順に攻撃順を変更
//        Battle.priority(characters);
//
//        Battle.fight(characters, party, monsters);

    }

}
