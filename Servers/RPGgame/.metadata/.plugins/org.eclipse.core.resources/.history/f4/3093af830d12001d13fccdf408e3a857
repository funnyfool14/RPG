package process;

import java.util.ArrayList;

import character.Character;
import character.heros.Human;
import character.monster.Monster;
import commands.C;
import description.D;

public class Action {

    static ArrayList<Character> characters;
    static ArrayList<Character> attackables;
    static ArrayList<Human> attackableHeros;
    static Human human;
    static ArrayList<Human> party;
    static Monster monster;
    static ArrayList<Monster> monsters;
    static ArrayList<Monster> monstersExp;


    public static void action(ArrayList<Character> characters,
                                ArrayList<Character> attackables,
                                ArrayList<Human> party,
                                ArrayList<Human> attackableHeros,   //null
                                ArrayList<Monster> monsters,
                                ArrayList<Monster> monstersExp
                                ){


    /**
     * "戦う"を選択した後の処理
     * HumanかMonsterで処理の分岐
     * @param characters
     */

        for(int i = 0; i < attackables.size(); i++){

            //キャラクターが勇者のパーティの時
            if(attackables.get(i).getType().equals("human")){
                human = (Human)attackables.get(i);
                human.setBuffDefence(0);

                Human.status(party, monsters);

                //各キャラの行動選択
                C.battle(characters, attackables, party, attackableHeros, monsters, human);

                //モンスターが全滅したら

                if(monsters.size() == 0){
                    int exp = 0;

                    //経験値の計算
                    for(int j = 0; j < monstersExp.size(); j++){
                        exp += monstersExp.get(j).getExp();
                    }

                    //経験値の分配
                    for(int j = 0; j < attackableHeros.size(); j++){
                        attackableHeros.get(j).setExp(attackableHeros.get(j).getExp() + exp);
                    }

                    //経験値獲得対象のMonsterをリセット
                    monstersExp.clear();

                    //経験値獲得コメント
                    System.out.println(attackableHeros.get(0).getName() + "達は" + exp + "の経験値をかくとくした！");

                    //経験値が規定に達したらレベルアップ
                    for(int j = 0; j < attackableHeros.size(); j++){
                        (attackableHeros.get(j)).levelUp();;
                    }

                    //防御をリセット
                    Human.cancelDefend(party);
                    //旅コマンドへ
                    C.journey(characters, party);
                }
            }else{

                //キャラクターがモンスターの時
                attackableHeros = Sort.attackableHeros(party, attackableHeros);
                monster = (Monster)attackables.get(i);

                //ＨＰの低いパティーメンバーを攻撃
                monster.attack(Sort.weakHuman(attackableHeros), characters, attackables, attackableHeros);

                if(attackableHeros.size() == 0){
                    D.gameOver(characters, party, monsters);
                }
            }
        }
    }


}
