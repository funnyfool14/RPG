package commands;

import java.util.ArrayList;
import java.util.Scanner;

import character.Character;
import character.heros.Human;
import character.monster.Monster;
import description.D;
import main.Main;
import process.Action;
import process.Sort;

public class C {

    static ArrayList<Character> characters;
    static ArrayList<Character> attackables = new ArrayList<>();
    static ArrayList<Human> party;
    static ArrayList<Human> attackableHeros = new ArrayList<>();
    static ArrayList<Monster> monsters = new ArrayList<>();
    static ArrayList<Monster> monstersExp = new ArrayList<>();

    public static void journey(ArrayList<Character> characters,
                                ArrayList<Human> party){

        Human.status(party,monsters);
        D.journeyS();

        Scanner sc = new Scanner(System.in);

        while(true){
            try {
                int input = Integer.parseInt(sc.nextLine());

                // 1.旅に出る
                if(input == 1){

                    // モンスターのインスタンス作成
                    Monster.createMonsters(characters,monsters);
                    monstersExp.addAll(monsters);

                    // モンスター出現
                    Monster.appears(monsters);

                    //戦う・逃げる・会話する

                    action(characters, attackables, party, attackableHeros, monsters, monstersExp);


                }if(input == 2){
                    // 街コマンド表示
                    D.townS();
                }if(input == 3){
                    System.out.println("快楽に浸るため金を使い果たし");
                    System.out.println("やる気がなくなった。");
                    System.out.println("Game Over・・・orz");
                    break;

                }else{
                    System.out.println("正しいコマンドを入力してください");
                }
            } catch (NumberFormatException e) {
                System.out.println("正しいコマンドを入力してください");
            }
        }

    }

    public static void action(ArrayList<Character> characters,
                                ArrayList<Character> attackables,   //null
                                ArrayList<Human> party,
                                ArrayList<Human> attackableHeros,   //null
                                ArrayList<Monster> monsters,
                                ArrayList<Monster> monstersExp
                                                                ){


        Human.status(party, monsters);
        D.actionS();


        Scanner sc = new Scanner(System.in);

        while(true){
            int input = Integer.parseInt(sc.nextLine());

            if(input == 1){
                //戦う
                //攻撃可能なキャラクターを設定
                Sort.attackable(characters,attackables);
                //攻撃順を設定
                Sort.priority(attackables);

                Action.action(characters, attackables, party, attackableHeros, monsters, monstersExp);

                action(characters, attackables, party, attackableHeros, monsters, monstersExp);

            }if(input == 2){
                //逃げる
                Human.runAway(characters, monsters);
                journey(characters, party);
                break;

            }if(input == 3){
                //会話する
                System.out.println("会話をしようとモンスターに近づいたが");
                System.out.println("話にならず攻撃された。");
                System.out.println("Game Over・・・orz");
                break;

            }else{
                System.out.println("戦うか逃げるか会話するかを選択してください");
            }
        }

    }



    public static void battle(ArrayList<Character> characters,
                                ArrayList<Character> attackables,
                                ArrayList<Human> party,
                                ArrayList<Human> attackableHeros,
                                ArrayList<Monster> monsters,
                                Human h){

        Human.cancelDefend(h);
        Scanner sc = new Scanner(System.in);
        D.battleS(h);

        while(true){
            int input = Integer.parseInt(sc.nextLine());

            if(input == 1){
                //攻撃

                //ＨＰの低いモンスターを攻撃
                h.attack(Sort.weakMonster(monsters), characters, attackables, party, monsters);

                break;

            }if(input == 2){
                //特技
                h.skill(characters, attackables, party, attackableHeros, monsters, h);

                break;

            }if(input == 3){
                //防御
                h.defend();
                break;

            }else{
                System.out.println("正しいコマンドを入力してくださいyo");
            }
        }
    }


    public static void gameOver(ArrayList<Character> characters, ArrayList<Human> party, ArrayList<Monster> monsters){

        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());

        while(true){

            if(input == 1){

                characters.clear();
                party.clear();
                monsters.clear();

            Main.main(null);

            }

            if(input == 2){

                System.exit(0);

            }if(input == 3){

                System.out.println("ご自由にどうぞ");
                System.exit(0);

            }else{
                System.out.println("正しいコマンドを入力してください");
            }
        }
    }


}

