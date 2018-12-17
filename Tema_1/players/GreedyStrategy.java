package players;

import main.GoodsType;

import java.util.ArrayList;
import java.util.List;

public class GreedyStrategy extends Strategy {
    private static final int MAXCARDS = 5;
    private static final int LEGALLIMIT = 9;

    private int nrRundaComerciant;
    public GreedyStrategy() {
        super();
        nrRundaComerciant = 1;
    }

    public final void declare() {

        //aplica strategia de baza
        super.declare();

        //daca e runda para adauga bun ilegal:
        if ((nrRundaComerciant % 2 == 0) && (this.getAssetsDeclared().size() < MAXCARDS)) {

            List<Integer> assetsInHand =  this.getAssetsInHand();
            List<Integer> assetsDeclared = this.getAssetsDeclared();
            GoodsType goodsType = new GoodsType();
            int type = -1;
            for (int i:assetsInHand) {
                if (i > LEGALLIMIT) {
                    if (type < 0) {
                        type = i;
                    } else if (goodsType.getProfit(i) > goodsType.getProfit(type)) {
                        type = i;
                    }
                }
            }
            if (type > 0) {
                assetsDeclared.add(type);
                assetsInHand.remove(assetsInHand.indexOf(type));
            }
            setAssetsDeclared(assetsDeclared);
            setAssetsInHand(assetsInHand);

        }
        nrRundaComerciant++;
    }

    public final void sheriff(final List<Strategy> players) {
        for (Strategy player:players) {
            if (player.equals(this)) {
                continue;
            } else {
                if (player.getBribe() > 0) {
                    this.setCoins(this.getCoins() + player.getBribe());
                    player.setBribe(0);
                } else {
                    List<Strategy> list = new ArrayList<>();
                    list.add(player);
                    super.sheriff(list);
                }
            }
        }
    }
}
