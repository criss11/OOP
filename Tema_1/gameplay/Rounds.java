package gameplay;

import players.PlayersData;
import players.Strategy;

import java.util.List;

public class Rounds {
    private int nrRunda;
    private int nrCarti;
    private static final int MAXCARTI = 6;

    public Rounds() {
        this.nrRunda = 1;
        this.nrCarti = MAXCARTI;
    }

    public void play(final PlayersData playersData) {
        List<Integer> assetsPile = playersData.getAssetsPile();
        List<Strategy> players = playersData.getPlayers();

        List<Integer> assetsInHand;

        for (Strategy player:players) {
            assetsInHand = player.getAssetsInHand();

            //pas 1: ne asiguram ca fiecare jucator are 6 carti in mana;
            int j = assetsInHand.size();
            for (int i = 0; i < nrCarti - j; i++) {
                assetsInHand.add(assetsPile.remove(0));
            }

            player.setAssetsInHand(assetsInHand);

            //pas 2: jucatorii comercianti isi declara bunurile;
            if ((nrRunda - 1) % players.size() != players.indexOf(player)) {
                player.declare();
            }
        }

        //pas 3: jucatorul sheriff isi joaca runda;
        players.get((nrRunda - 1) % players.size()).sheriff(players);

        //pas4: punem bunurile pe taraba;
        for (Strategy player:players) {
            player.putOnStand();
        }


        playersData.setAssetsPile(assetsPile);
        playersData.setPlayers(players);
        nrRunda++;

    }
}
