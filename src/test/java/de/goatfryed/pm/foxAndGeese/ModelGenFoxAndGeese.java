package de.goatfryed.pm.foxAndGeese;

import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.fulib.classmodel.ClassModel;
import org.junit.Test;

public class ModelGenFoxAndGeese {
    @Test
    public void generateModel()
    {
        ClassModelBuilder mb = new ClassModelBuilder("de.goatfryed.pm.foxAndGeese");
        ClassBuilder game = mb.buildClass("Game");
        ClassBuilder player = mb.buildClass("Player");
        player.buildAttribute("name", mb.STRING);
        ClassBuilder meeple = mb.buildClass("Meeple");
        ClassBuilder field = mb.buildClass("Field");


        game.buildAssociation(player, "fox", mb.ONE, "foxOf", mb.ONE);
        game.buildAssociation(player, "geese", mb.ONE, "geeseOf", mb.ONE);
        game.buildAssociation(player, "currentPlayer", mb.ONE, "currentPlayerOf", mb.ONE);
        game.buildAssociation(player, "winner", mb.ONE, "winnerOf", mb.ONE);

        meeple.buildAssociation(player, "player", mb.ONE, "meeples", mb.MANY);
        meeple.buildAssociation(field, "field", mb.ONE, "meeple", mb.ONE);

        field.buildAssociation(field, "south", mb.ONE, "north", mb.ONE);
        field.buildAssociation(field, "west", mb.ONE, "east", mb.ONE);
        field.buildAssociation(field, "northeast", mb.ONE, "southwest", mb.ONE);
        field.buildAssociation(field, "northwest", mb.ONE, "southeast", mb.ONE);

        ClassModel model = mb.getClassModel();
        Fulib.generator().generate(model);
        Fulib.tablesGenerator().generate(model);
    }
}
