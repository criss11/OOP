package players;

import gameplay.ProfitComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BribedStrategy extends Strategy {
    private static final int ILLEGALMIN = 9;
    private static final int COINSMIN = 10;

    public BribedStrategy() {
        super();
    }

    public final void declare() {


        List<Integer> assetsInHand = this.getAssetsInHand();
        List<Integer> assetsDeclared = this.getAssetsDeclared();

        List<Integer> illegalCards = new ArrayList<>();
        for (int i : assetsInHand) {
            if (i > ILLEGALMIN) {
                illegalCards.add(i);
            }
        }
        if (illegalCards.size() == 0) {
            super.declare();
        } else if ((illegalCards.size() > 2) && (this.getCoins() >= COINSMIN) || ((illegalCards).size() <= 2) && this.getCoins() >= COINSMIN / 2) {        //////daca are mai mult de 5 coins atat
            ProfitComparator profitComparator = new ProfitComparator();
            Collections.sort(illegalCards, profitComparator);

            //declaram elementele ilegale
            for (int i = 0; i < illegalCards.size() && i < COINSMIN / 2; i++) {
                assetsDeclared.add(illegalCards.get(i));
            }
            assetsInHand.removeAll(assetsDeclared);

            this.setDeclaredType(0);
            if (illegalCards.size() > 2) {
                this.setBribe(COINSMIN);
                this.setCoins(this.getCoins() - COINSMIN);
            } else {
                this.setBribe(COINSMIN / 2);
                this.setCoins(this.getCoins() - (COINSMIN / 2));
            }

            setAssetsDeclared(assetsDeclared);
            setAssetsInHand(assetsInHand);

        } else {
            super.declare();
        }
    }

    public final void sheriff(final List<Strategy> players) {
        super.sheriff(players);
    }


}
