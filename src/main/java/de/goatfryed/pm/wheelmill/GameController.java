package de.goatfryed.pm.wheelmill;

import de.goatfryed.pm.wheelmill.model.*;

import java.util.Objects;

public class GameController {


    public boolean move(Stone stone, Place target)
    {
        Game game;
        Objects.requireNonNull(game = stone.getPlayer().getGame());
        Objects.requireNonNull(game.getCenter());
        Objects.requireNonNull(target);

        Player player = stone.getPlayer();

        if (target.getOccupiedBy() != null) {
            return false;
        } else if ( target == game.getCenter() ) {
            checkWinner(game, player);
            return true;

        } else if (
                stone.getOn() == null
                        || stone.getOn().getCW() == target
                        || stone.getOn().getCCW() == target
        ) {
            Objects.requireNonNull(target.getOnDiagonal());
            checkWinner(game, player, target.getOnDiagonal());
            return true;
        } else {
            return false;
        }
    }

    private boolean checkWinner(Game game, Player candidate) {
        if (game.getCenter().getOccupiedBy() != null) {

            for (Diagonal d : game.getDiagonals()) {
                if (checkWinner(game, candidate, d)) break;
            }
        }

        return game.getWinner() != null;
    }

    private boolean checkWinner(Game game, Player candidate, Diagonal diagonal) {
        Player owner = null;
        for (Place p : diagonal.getPlaces()) {
            if ( p.getOccupiedBy() == null || p.getOccupiedBy().getPlayer() == null) {
                owner = null;
                break;
            } else if (owner == null) {
                owner = p.getOccupiedBy().getPlayer();
            } else if (owner != p.getOccupiedBy().getPlayer()) {
                owner = null;
                break;
            }
        }

        if (owner != null && owner == candidate) {
            game.setWinner(owner);
            return true;
        }
        return false;
    }
}
