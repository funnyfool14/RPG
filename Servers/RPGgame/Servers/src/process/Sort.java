package process;

import java.util.ArrayList;

import character.Character;
import character.heros.Human;
import character.monster.Monster;


public class Sort {

    static ArrayList<Character> characters;
    static ArrayList<Character> attackables;
    static Human human;
    static ArrayList<Human> party;
    static Monster monster;
    static ArrayList<Monster> monsters;
    static ArrayList<Human> orderWeak = new ArrayList<>();
    static ArrayList<Human> tmp = new ArrayList<>();
    static ArrayList<Human> attackableHeros;


/*
 * 攻撃可能なキャラクターを抽出
 * 倒された後の攻撃可能なキャラクターの更新
 */
    public static ArrayList<Character> attackable(ArrayList<Character> characters,
                                    ArrayList<Character> attackables){  //null

        attackables.clear();

        //HPが残っているcharacterだけListに追加
        for(int i = 0; i < characters.size(); i++){
            if(characters.get(i).getHp() > 0){
                attackables.add(characters.get(i));
            }
        }
        return attackables;
    }
/**
 * Characterをagilityが高い順に並び替え
 * @param characters
 */
    public static void priority( ArrayList<Character> attackables){

        for(int i = 0; i < attackables.size()-1; i++){
            // agilityの高いキャラクターを仮設定
            int faster = i;
            for(int j = i+1; j < attackables.size(); j++){
                if(attackables.get(faster).getAgility() < attackables.get(j).getAgility()){
                    faster = j;
                }

                Character priority = attackables.get(faster);
                attackables.set(faster,attackables.get(i));
                attackables.set(i,priority);
            }
        }
    }

    public static ArrayList<Human> attackableHeros(ArrayList<Human> party,
                                                    ArrayList<Human> attackableHeros){

        if(attackableHeros != null){
            attackableHeros.clear();
        }

        for(int i = 0; i < party.size(); i++){
            if(party.get(i).getHp() > 0){
                attackableHeros.add(party.get(i));
            }
        }

        return attackableHeros;
    }



/**
 * HPの低いHumanを判別
 * @param party
 * @return
 */
    public static Human weakHuman(ArrayList<Human> attackableHeros){

        int weaker = 0;

        //戦闘可能なパーティが２名以上いるとき
        if(attackableHeros.size() > 1){
            for(int i = 0; i < attackableHeros.size()-1; i++){
                // HPの低いキャラクターを仮設定
                weaker = i;
                for(int j = i+1; j < attackableHeros.size(); j++){
                    if(attackableHeros.get(weaker).getHp() > attackableHeros.get(j).getHp()){
                        weaker = j;
                    }
                }
            }
            return attackableHeros.get(weaker);
        }


         //戦闘可能なパーティが１名なら
        if(attackableHeros.size() == 1){
            return attackableHeros.get(0);
        }
        return  null;
    }


/**
 * HPの低いMonsterを判別
 * @param monsters
 * @return
 */
    public static Monster weakMonster(ArrayList<Monster> monsters){
        for(int i = 0; i < monsters.size()-1; i++){
            // HPの低いキャラクターを仮設定
            int weaker = i;
            for(int j = i+1; j < monsters.size(); j++){
                if(monsters.get(weaker).getHp() > monsters.get(j).getHp()){
                    weaker = j;
                }
                Monster priority = monsters.get(weaker);
                monsters.set(weaker,monsters.get(i));
                monsters.set(i,priority);
            }
        }
        return monsters.get(0);
    }


}
