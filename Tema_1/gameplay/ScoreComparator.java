package gameplay;

import players.Strategy;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Strategy> {
    @Override
    public int compare(final Strategy player1, final Strategy player2) {
        return player2.getScore() - player1.getScore();
    }

}
