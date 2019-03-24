package de.goatfryed.pm.wheelmill;

import org.fulib.Fulib;
import org.fulib.FulibTools;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.junit.Test;

import java.util.Objects;

public class ModelGenWheelMill {

    @Test
    public void generateModel()
    {
        ClassModelBuilder mb = new ClassModelBuilder("de.goatfryed.pm.wheelmill.model");
        ClassBuilder game = mb.buildClass("Game");
        ClassBuilder player = mb.buildClass("Player");
        player.buildAttribute("name", mb.STRING)
                .buildAttribute("color", mb.STRING)
        ;
        ClassBuilder diagonal = mb.buildClass("Diagonal");

        ClassBuilder place = mb.buildClass("Place");

        ClassBuilder stone = mb.buildClass("Stone");

        game.buildAssociation(player, "players", mb.MANY, "game", mb.ONE);
        game.buildAssociation(player, "currentPlayer", mb.ONE, "active", mb.ONE);
        game.buildAssociation(player, "winner", mb.ONE, "gameWon", mb.ONE);
        game.buildAssociation(diagonal, "diagonals", mb.MANY, "game", mb.ONE);
        game.buildAssociation(place, "center", mb.ONE, "centerOf", mb.ONE);

        stone.buildAssociation(player, "player", mb.ONE, "stones", mb.MANY);
        stone.buildAssociation(place, "on", mb.ONE, "occupiedBy", mb.ONE);

        place.buildAssociation(place, "CW", mb.ONE, "CCW", mb.ONE);
        place.buildAssociation(diagonal, "onDiagonal", mb.ONE, "places", mb.MANY);

        Fulib.generator().generate(mb.getClassModel());
        Fulib.tablesGenerator().generate(mb.getClassModel());
    }

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
