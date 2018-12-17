package gameplay;

import main.GoodsType;
import players.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCalculator {
    //lista de hashmap-uri pentru fiecare goods in parte
    //retine frecventa good-ului respectiv pentru fiecare jucator
    private List<HashMap<Strategy, Integer>> listHashMaps;


    public ScoreCalculator() {
        this.listHashMaps = new ArrayList<>();
        HashMap<Strategy, Integer> countApples = new HashMap<>();
        HashMap<Strategy, Integer> countCheese = new HashMap<>();
        HashMap<Strategy, Integer> countBread = new HashMap<>();
        HashMap<Strategy, Integer> countChicken = new HashMap<>();
        listHashMaps.add(countApples);
        listHashMaps.add(countCheese);
        listHashMaps.add(countBread);
        listHashMaps.add(countChicken);
    }

    public void profitOnGoods(final List<Strategy> players) {
        final int idSilk = 10;
        final int idPepper = 11;
        final int idBarrel = 12;
        final int idMaxLegal = 4;
        GoodsType goodsType = new GoodsType();

        for (Strategy player:players) {
            List<Integer> bonusAssets = new ArrayList<>();
            List<Integer> assetsOnStand = player.getAssetsOnStand();
            for (int id:assetsOnStand) {
                switch (id) {
                    case idSilk:
                        bonusAssets.addAll(Collections.nCopies(2 + 1, 1));
                        break;
                    case idPepper:
                        bonusAssets.addAll(Collections.nCopies(2, 2 + 1));
                        break;
                    case idBarrel:
                        bonusAssets.addAll(Collections.nCopies(2, 2));
                        break;
                    default:
                        break;
                }
            }
            assetsOnStand.addAll(bonusAssets);

            for (int i = 0; i < idMaxLegal; i++) {
                    listHashMaps.get(i).put(player, 0);
            }

            int scoreTmp = 0;
            for (int id:assetsOnStand) {
                scoreTmp += goodsType.getProfit(id);
                if (id < idMaxLegal) {
                    listHashMaps.get(id).put(player, (listHashMaps.get(id).get(player) + 1));
                }
            }
            scoreTmp += player.getCoins();
            player.setScore(scoreTmp);
        }

        //adaugam bonusurile
        for (int i = 0; i < idMaxLegal; i++) {
            HashMap<Strategy, Integer> hashMap = listHashMaps.get(i);
            //valoarea bonusurilor
            int bonusKing =  goodsType.getKingsBonus(i);
            int bonusQueen =  goodsType.getQueensBonus(i);

            List<Integer> values = new ArrayList<>(hashMap.values());
            int max = 0, second = 0;
            for (int value:values) {
                if (value > max) {
                    second = max;
                    max = value;
                } else if (value > second && value < max) {
                    second = value;
                }
            }

            Map<Strategy, Integer> map = hashMap;
            for (Map.Entry<Strategy, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    entry.getKey().setScore(entry.getKey().getScore() + bonusKing);
                }
                if ((max != 0) && (entry.getValue() == second)) {
                    entry.getKey().setScore(entry.getKey().getScore() + bonusQueen);

                }
            }
        }
    }
}
