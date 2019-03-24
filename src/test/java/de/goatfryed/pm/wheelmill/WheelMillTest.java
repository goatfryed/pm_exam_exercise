package de.goatfryed.pm.wheelmill;

import org.fulib.FulibTools;
import org.junit.Test;

public class WheelMillTest {
    public WheelMillTest() {
    }

    @Test
    public void init() {
        Game game = new Game();
        Player bob = (new Player()).setName("Bob").setColor("black");
        Player alice = (new Player()).setName("Alice").setColor("white");
        game.withPlayers(bob, alice);

        Place center = new Place();
        game.setCenter(center);

        Place p1 = new Place();
        Place p2 = (new Place()).setCCW(p1);
        Place p3 = (new Place()).setCCW(p2);
        Place p4 = (new Place()).setCCW(p3);
        Place p5 = (new Place()).setCCW(p4);
        Place p6 = (new Place()).setCCW(p5);
        Place p7 = (new Place()).setCCW(p6);
        Place p8 = (new Place()).setCCW(p7).setCW(p1);

        (new Diagonal()).withPlaces(p1, p5).setGame(game);
        (new Diagonal()).withPlaces(p2, p6).setGame(game);
        (new Diagonal()).withPlaces(p3, p7).setGame(game);
        (new Diagonal()).withPlaces(p4, p8).setGame(game);

        (new Stone()).setPlayer(bob).setOn(p1);
        (new Stone()).setPlayer(bob).setOn(center);
        (new Stone()).setPlayer(bob).setOn(p2);
        (new Stone()).setPlayer(bob).setOn(p4);

        (new Stone()).setPlayer(alice).setOn(p5);
        (new Stone()).setPlayer(alice).setOn(p6);
        (new Stone()).setPlayer(alice).setOn(p3);

        FulibTools.objectDiagrams().dumpPng(game);
    }
}