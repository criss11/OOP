package players;

import main.GoodsType;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Strategy {
    private static final int COINS = 50;
    private static final int MAXVECT = 4;

    private List<Integer> assetsInHand;        //cartile pe care le are in mana
    private List<Integer> assetsDeclared;      //ce declara la fiecare runda
    private List<Integer> assetsOnStand;       //ce trece de inspectia serifului
    private int declaredType;
    private int coins;
    private int bribe;
    private int score;

    public Strategy() {
        this.assetsInHand = new ArrayList<>();
        this.assetsDeclared = new ArrayList<>();
        this.assetsOnStand = new ArrayList<>();
        this.coins = COINS;
        this.bribe = 0;
        this.score = 0;
    }

    public void declare() {
        List<Integer> assetsInHand =  this.getAssetsInHand();
        List<Integer> assetsDeclared = this.getAssetsDeclared();
        GoodsType goodsType = new GoodsType();
        int[] v = new int[MAXVECT];

        //vector de frecventa pentru bunurile legale
        for (int id:assetsInHand) {
            if (id <= 2 + 1) {
                v[id]++;
            }
        }

        int max = -1;
        for (int i = 0; i < MAXVECT; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }

        //daca exista elemente legale in vector
        int type = -1;
        if (max > 0) {
            //verificam daca exista doua elemente cu aceeasi frecventa maxima
            for (int i:assetsInHand) {
                if (i <= 2 + 1) {
                    if (v[i] == max) {
                        if (type < 0) {
                            type = i;
                        } else if (goodsType.getProfit(i) > goodsType.getProfit(type)) {
                            type = i;
                        }
                    }
                }
            }
            this.declaredType = type;
        } else {
            //daca exista numai elemente ilegale
            max = 1;
            for (int i:assetsInHand) {
                if (type < 0) {
                    type = i;
                } else if (goodsType.getProfit(i) > goodsType.getProfit(type)) {
                    type = i;
                }
            }
            this.declaredType = 0;
        }

        //mutam max elementele de tip type din Hand in Declared
        ListIterator<Integer> iter = assetsInHand.listIterator();
        while (iter.hasNext()) {
            if (iter.next() == type) {
                assetsDeclared.add(type);
                iter.remove();
                max--;
            }
            if (max == 0) {
                break;
            }
        }

        this.setAssetsDeclared(assetsDeclared);
        this.setAssetsInHand(assetsInHand);
    }

    public void sheriff(final List<Strategy> players) {

        for (Strategy player:players) {
            if (player.equals(this)) {
                continue;
            }

            //verifica daca jucatorul a dat mita, pentru a o respinge
            if (player.getBribe() > 0) {
                player.setCoins(player.getCoins() + player.getBribe());
                player.setBribe(0);
            }

            int declaredType = player.getDeclaredType();
            List<Integer> assetsDeclared = player.getAssetsDeclared();
            List<Integer> illegalGoods = new ArrayList<>();
            GoodsType goodsType = new GoodsType();

            for (int id : assetsDeclared) {
                if (id != declaredType) {
                    this.setCoins(this.getCoins() + goodsType.getPenalty(id));
                    player.setCoins(player.getCoins() - goodsType.getPenalty(id));
                    illegalGoods.add(id);
                }
            }

            if (illegalGoods.size() == 0) {                 //jucatorul a fost HONEST
                int tmp = assetsDeclared.size() * goodsType.getPenalty(declaredType);
                this.setCoins(this.getCoins() - tmp);
                player.setCoins(player.getCoins() + tmp);

            } else {
                assetsDeclared.removeAll(illegalGoods);      //jucatorul a fost LIAR
            }

            player.setAssetsDeclared(assetsDeclared);
        }
    }


    public final void putOnStand() {
        List<Integer> assetsDeclared = this.getAssetsDeclared();
        List<Integer> assetsOnStand = this.getAssetsOnStand();
        assetsOnStand.addAll(assetsDeclared);
        assetsDeclared.clear();
        setAssetsDeclared(assetsDeclared);
        setAssetsOnStand(assetsOnStand);
    }

    public final void setAssetsInHand(final List<Integer> assetsInHand) {
        this.assetsInHand = assetsInHand;
    }

    public final List<Integer> getAssetsInHand() {
        return assetsInHand;
    }

    public final void setAssetsDeclared(final List<Integer> assetsDeclared) {
        this.assetsDeclared = assetsDeclared;
    }

    public final List<Integer> getAssetsDeclared() {
        return assetsDeclared;
    }

    public final void setAssetsOnStand(final List<Integer> assetsOnStand) {
        this.assetsOnStand = assetsOnStand;
    }

    public final List<Integer> getAssetsOnStand() {
        return assetsOnStand;
    }

    public final void setDeclaredType(final int type) {
        this.declaredType = type;
    }

    public final int getDeclaredType() {
        return declaredType;
    }

    public final int getCoins() {
        return coins;
    }

    public final void setCoins(final int coins) {
        this.coins = coins;
    }

    public final int getBribe() {
        return bribe;
    }

    public final void setBribe(final int bribe) {
        this.bribe = bribe;
    }

    public final int getScore() {
        return score;
    }

    public final void setScore(final int score) {
        this.score = score;
    }
}
