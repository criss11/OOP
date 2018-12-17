package players;

import main.GameInput;

import java.util.ArrayList;
import java.util.List;

public class PlayersData {

    private List<Strategy> players;
    private List<Integer> assetsPile;

    public PlayersData(GameInput gameInput) {

        List<Integer> assetsPile = gameInput.getAssetIds();
        List<Strategy> players = new ArrayList<>();

        for (String str:gameInput.getPlayerNames()) {
            switch (str) {
                case "basic" :
                    Strategy basic = new BasicStrategy();
                    players.add(basic);
                    break;
                case "greedy" :
                    Strategy greedy = new GreedyStrategy();
                    players.add(greedy);
                    break;
                case "bribed" :
                    Strategy bribed = new BribedStrategy();
                    players.add(bribed);
                    break;
                default:
                    break;
            }
        }

        this.assetsPile = assetsPile;
        this.players = players;
    }

    public final List<Strategy> getPlayers() {
        return players;
    }

    public final List<Integer> getAssetsPile() {
        return assetsPile;
    }

    public final void setPlayers(final List<Strategy> players) {
        this.players = players;
    }

    public final void setAssetsPile(final List<Integer> assetsPile) {
        this.assetsPile = assetsPile;
    }
}
