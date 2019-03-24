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
}
