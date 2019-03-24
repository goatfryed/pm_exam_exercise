package de.goatfryed.pm.highernumber;

import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.junit.Test;

public class ModelGenHigherNumber {

    @Test
    public void generateModel() {
        ClassModelBuilder mb = new ClassModelBuilder("de.goatfryed.pm.highernumber.model");
        ClassBuilder game = mb.buildClass("Game");

        ClassBuilder player = mb.buildClass("Player");
        player.buildAttribute("name", mb.STRING);

        ClassBuilder number = mb.buildClass("Number");
        number.buildAttribute("value", mb.DOUBLE);

        ClassBuilder comment = mb.buildClass("Comment");
        comment.buildAttribute("text", mb.STRING);
        comment.buildAttribute("date", mb.STRING);

        game.buildAssociation(player, "players", mb.MANY, "game", mb.ONE);
        game.buildAssociation(player, "winner", mb.ONE, "gameWon", mb.ONE);
        game.buildAssociation(player, "currentPlayer", mb.ONE, "activeIn", mb.ONE);

        player.buildAssociation(number, "picked", mb.ONE, "pickedBy", mb.ONE);

        comment.buildAssociation(player, "author", mb.ONE, "comments", mb.MANY);
        comment.buildAssociation(player, "recipients", mb.MANY, "received", mb.MANY);

        Fulib.generator().generate(mb.getClassModel());
    }

}
