package de.goatfryed.pm.foxAndGeese;

import org.junit.Assert;
import org.junit.Test;

public class FoxAndGeeseTest {

    @Test
    public void testInit()
    {
        GameController gc = new GameController();

        Player karli = (new Player()).setName("Karli");
        Player bob = (new Player()).setName("Bob");

        Game game = gc.init(karli, bob);

        Assert.assertNotNull(game.getFox());
        Assert.assertNotNull(game.getGeese());
        Assert.assertEquals(1, game.getFox().getMeeples().size());
        Assert.assertEquals(1, game.getGeese().getMeeples().size());
        Assert.assertEquals(bob, game.getCurrentPlayer());
        Assert.assertNull(game.getWinner());
    }

    @Test
    public void testMove()
    {
        GameController gc = new GameController();

        Player foxPlayer = (new Player()).setName("Fox");
        Player geesePlayer = (new Player()).setName("Geese");

        Game game = new Game();
        game.setFox(foxPlayer);
        Meeple fox = (new Meeple()).setPlayer(foxPlayer);
        game.setGeese(geesePlayer);

        Field start = new Field();
        start.setNorth((new Field()).setMeeple((new Meeple()).setPlayer(geesePlayer)));
        start.getNorth().setNorth(new Field());
        start.setEast(new Field());
        start.getEast().setEast(new Field());
        start.setWest((new Field()).setMeeple((new Meeple().setPlayer(geesePlayer))));
        start.getWest().setWest((new Field()).setMeeple((new Meeple().setPlayer(geesePlayer))));
        start.getWest().getWest().setWest(new Field());
        start.setSouth((new Field()).setMeeple((new Meeple()).setPlayer(geesePlayer)));

        gc.setGame(game);

        game.setCurrentPlayer(foxPlayer);
        start.setMeeple(fox);
        try {
            gc.move(fox, null);
            assert false;
        } catch (NullPointerException e) {
        }

        // fox can't move two steps
        Assert.assertFalse(gc.move(fox, start.getEast().getEast()));
        Assert.assertEquals(start, fox.getField());
        Assert.assertEquals(foxPlayer, game.getCurrentPlayer());

        // fox can't jump over sheep at the border
        Assert.assertFalse(gc.move(fox, start.getSouth()));
        Assert.assertEquals(start, fox.getField());
        Assert.assertEquals(foxPlayer, game.getCurrentPlayer());

        // fox can't jump at occupied place
        Assert.assertFalse(gc.move(fox, start.getWest().getWest()));
        Assert.assertEquals(start, fox.getField());
        Assert.assertEquals(foxPlayer, game.getCurrentPlayer());

        // sheep can't jump over fox
        Assert.assertFalse(gc.move(start.getWest().getMeeple(), start.getEast()));
        Assert.assertEquals(start, fox.getField());
        Assert.assertEquals(foxPlayer, game.getCurrentPlayer());


        // fox can move on empty neihbor space
        Assert.assertTrue(gc.move(fox, start.getEast()));
        Assert.assertEquals(start.getEast(), fox.getField());
        Assert.assertEquals(geesePlayer, game.getCurrentPlayer());

        // fox can jump over sheep space
        game.setCurrentPlayer(foxPlayer);
        start.setMeeple(fox);
        Assert.assertTrue(gc.move(fox, start.getNorth().getNorth()));
        Assert.assertEquals(start.getNorth().getNorth(), fox.getField());
        Assert.assertEquals(geesePlayer, game.getCurrentPlayer());
        Assert.assertNull(start.getNorth().getMeeple());

        // sheep can move
        Assert.assertTrue(gc.move(start.getWest().getMeeple(), start));
        Assert.assertEquals(start.getNorth().getNorth(), fox.getField());
        Assert.assertEquals(foxPlayer, game.getCurrentPlayer());

    }

    @Test
    public void testWinner()
    {
        GameController gc = new GameController();

        Player foxPlayer = (new Player()).setName("Fox");
        Player geesePlayer = (new Player()).setName("Geese");

        Game game = new Game();
        game.setFox(foxPlayer);
        Meeple fox = (new Meeple()).setPlayer(foxPlayer);
        game.setGeese(geesePlayer);

        Meeple g1 = new Meeple().setPlayer(geesePlayer);
        Meeple g2 = new Meeple().setPlayer(geesePlayer);
        Meeple g3 = new Meeple().setPlayer(geesePlayer);

        Field start = new Field();
        start.setNorth(new Field().setMeeple(g1));
        start.getNorth().setNorth(new Field().setMeeple(g2));
        start.setEast(new Field().setMeeple(g3));

        fox.setField(start);

        gc.setGame(game);

        Assert.assertTrue(gc.checkWinner());
        Assert.assertEquals(geesePlayer, game.getWinner());

        g2.removeYou();
        game.setWinner(null);
        Assert.assertTrue(gc.checkWinner());
        Assert.assertEquals(foxPlayer, game.getWinner());

        game.setWinner(null);

        Field placeholder = start;
        while( geesePlayer.getMeeples().size() < 7) {
            placeholder.setSouth(new Field());
            placeholder = placeholder.getSouth();
            geesePlayer.withMeeples(new Meeple().setField(placeholder));
        }

        Assert.assertFalse(gc.checkWinner());
        Assert.assertNull(game.getWinner());
    }
}