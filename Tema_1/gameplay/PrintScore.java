package gameplay;

import players.BasicStrategy;
import players.BribedStrategy;
import players.Strategy;

import java.util.Collections;
import java.util.List;

public class PrintScore {

    public final void print(final List<Strategy> players) {

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        scoreCalculator.profitOnGoods(players);

        ScoreComparator scoreComparator = new ScoreComparator();
        Collections.sort(players, scoreComparator);

        for (Strategy player:players) {
            if (player instanceof BasicStrategy) {
                System.out.println("BASIC: " + player.getScore());
            } else if (player instanceof BribedStrategy) {
                System.out.println("BRIBED: " + player.getScore());
            } else {
                System.out.println("GREEDY: " + player.getScore());
            }
        }
    }
}
