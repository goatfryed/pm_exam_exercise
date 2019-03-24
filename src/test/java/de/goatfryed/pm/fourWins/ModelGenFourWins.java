package de.goatfryed.pm.fourWins;

import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.junit.Test;

public class ModelGenFourWins {
    @Test
    public void generateModel()
    {
        ClassModelBuilder mb = new ClassModelBuilder("pm.examples.fourWins");
        ClassBuilder game = mb.buildClass("Game");

        ClassBuilder player = mb.buildClass("Player");
        player.buildAttribute("name", mb.STRING);
        player.buildAttribute("color", mb.STRING);

        ClassBuilder column = mb.buildClass("Column");
        column.buildAttribute("id", mb.INT);
        column.buildAttribute( "maxHeight", mb.INT);

        ClassBuilder token = mb.buildClass("Token");
        token.buildAttribute("height", mb.INT);

        game.buildAssociation(player, "players", mb.MANY, "game", mb.ONE);
        game.buildAssociation(player, "currentPlayer", mb.ONE, "active", mb.ONE);
        game.buildAssociation(player, "winner", mb.ONE, "gameWon", mb.ONE);
        game.buildAssociation(column, "columns", mb.MANY, "game", mb.ONE);

        player.buildAssociation(token, "tokens", mb.MANY, "player", mb.ONE);

        column.buildAssociation(token, "tokens", mb.MANY, "column", mb.ONE);
        column.buildAssociation(column, "left", mb.ONE, "right", mb.ONE);

        Fulib.generator().generate(mb.getClassModel());
    }
}
