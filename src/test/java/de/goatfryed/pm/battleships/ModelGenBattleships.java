package de.goatfryed.pm.battleships;

import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.junit.Test;

public class ModelGenBattleships {

    @Test
    public void createModel() {
        ClassModelBuilder mb = new ClassModelBuilder("de.goatfryed.pm.battleships.model");
        ClassBuilder game = mb.buildClass("Game")
                ;
        ClassBuilder player = mb.buildClass("Player")
                .buildAttribute("name", mb.STRING)
                ;
        ClassBuilder boat = mb.buildClass("Boat")
                .buildAttribute("type", mb.STRING)
                ;
        ClassBuilder section = mb.buildClass("Section")
                .buildAttribute("column", mb.INT)
                .buildAttribute("row", mb.STRING)
                ;
        ClassBuilder shot = mb.buildClass("Shot")
                .buildAttribute("column", mb.INT)
                .buildAttribute("row", mb.STRING)
                ;

        game.buildAssociation(player, "players", mb.MANY, "game", mb.ONE);
        game.buildAssociation(player, "currentPlayer", mb.ONE, "active", mb.ONE);
        game.buildAssociation(player, "winner", mb.ONE, "gameWon", mb.ONE);
        player.buildAssociation(boat, "boats", mb.MANY, "player", mb.ONE);
        player.buildAssociation(shot, "shots", mb.MANY, "player", mb.ONE);

        section.buildAssociation(boat, "boat", mb.ONE, "sections", mb.MANY);
        section.buildAssociation(player, "player", mb.ONE, "sections", mb.MANY);
        section.buildAssociation(shot, "shotBy", mb.ONE, "hit", mb.ONE);

        Fulib.generator().generate(mb.getClassModel());

        Fulib.tablesGenerator().generate(mb.getClassModel());
    }
}
