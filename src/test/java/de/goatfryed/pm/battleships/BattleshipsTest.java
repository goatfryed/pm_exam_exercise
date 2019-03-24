package de.goatfryed.pm.battleships;

import de.goatfryed.pm.battleships.model.Boat;
import de.goatfryed.pm.battleships.model.Game;
import de.goatfryed.pm.battleships.model.Player;
import de.goatfryed.pm.battleships.model.Section;
import org.junit.Test;

public class BattleshipsTest {
    @Test
    public void init() {
        Game game = new Game();

        Player ruben = new Player();
        ruben.setName("Ruben").setGame(game);

        Boat patrolBoat = new Boat();
        patrolBoat.setType("Patrol Boat").setPlayer(ruben);

        Section a1 = (new Section()).setColumn(1).setRow("a").setPlayer(ruben);
        Section a2 = (new Section()).setColumn(2).setRow("a").setPlayer(ruben);
        patrolBoat.withSections(a1,a2);

        Section c6 = (new Section()).setColumn(6).setRow("c").setPlayer(ruben);
        Section d6 = (new Section()).setRow("d").setColumn(6).setPlayer(ruben);
        Section e6 = (new Section()).setRow("e").setColumn(6).setPlayer(ruben);
        Boat submarine = (new Boat())
                .setType("Submarine")
                .withSections(c6,d6,e6);

        Section c4 = (new Section()).setRow("c").setColumn(4).setPlayer(ruben);
        Section d4 = (new Section()).setRow("d").setColumn(4).setPlayer(ruben);
        Section e4 = (new Section()).setRow("e").setColumn(4).setPlayer(ruben);
        Boat destroyer = (new Boat())
                .setType("Destroyer")
                .withSections(c4, d4, e4);

        Section i3 = (new Section()).setColumn(3).setRow("i").setPlayer(ruben);
        Section i4 = (new Section()).setRow("i").setColumn(4).setPlayer(ruben);
        Section i5 = (new Section()).setRow("i").setColumn(5).setPlayer(ruben);
        Section i6 = (new Section()).setRow("i").setColumn(6).setPlayer(ruben);
        Boat battleship = (new Boat()).setType("battleship").withSections(i3,i4,i5,i6);

        Section f10 = (new Section()).setRow("f").setColumn(10).setPlayer(ruben);
        Section g10 = (new Section()).setRow("g").setColumn(10).setPlayer(ruben);
        Section h10 = (new Section()).setRow("h").setColumn(10).setPlayer(ruben);
        Section i10 = (new Section()).setRow("i").setColumn(10).setPlayer(ruben);
        Section j10 = (new Section()).setRow("j").setColumn(10).setPlayer(ruben);
        Boat carrier = (new Boat()).setType("carrier").withSections(f10,g10,h10,i10,j10);

        ruben.withBoats(submarine, destroyer, battleship, carrier);
    }

    @Test
    public void initCustom() {

        Game game = new Game();

        Player ruben = new Player();
        ruben.setName("Ruben").setGame(game);

        Player karli = (new Player()).setName("Karli");

        game.withPlayers(karli);

        Boat b1 = new Boat();
        b1.setType("Patrol Boat").setPlayer(ruben);
        Section s1 = (new Section()).setColumn(2).setRow("a");
        Section s2 = (new Section()).setColumn(3).setRow("a");
        b1.withSections(s1,s2);

        Section s3 = (new Section()).setColumn(7).setRow("b");
        Section s4 = (new Section()).setRow("c").setColumn(7);
        Section s5 = (new Section()).setRow("d").setColumn(7);
        Boat b2 = (new Boat())
                .setType("Submarine")
                .setPlayer(karli)
                .withSections(s3,s4,s5);

        Section s6 = (new Section()).setRow("a").setColumn(3);
        Section s7 = (new Section()).setRow("b").setColumn(3);
        Section s8 = (new Section()).setRow("c").setColumn(3);
        Boat b3 = (new Boat())
                .setType("Destroyer")
                .withSections(s6, s7, s8);

        Section s9 = (new Section()).setRow("i").setColumn(5);
        Section s10 = (new Section()).setRow("i").setColumn(6);
        Section s11 = (new Section()).setRow("i").setColumn(7);
        Section s12 = (new Section()).setRow("i").setColumn(8);
        Boat b4 = (new Boat())
                .setType("Battleship")
                .setPlayer(karli)
                .withSections(s9,s10,s11,s12);

        Boat b5 = new Boat();
        b5.setPlayer(karli);
        b5.setType("Carrier");
        Section s13 = (new Section()).setRow("f").setColumn(10).setBoat(b5);
        Section s14 = (new Section()).setRow("g").setColumn(10).setBoat(b5);
        Section s15 = (new Section()).setRow("h").setColumn(10).setBoat(b5);
        Section s16 = (new Section()).setRow("i").setColumn(10).setBoat(b5);
        Section s17 = (new Section()).setRow("j").setColumn(10).setBoat(b5);

        Section s18 = (new Section()).setRow("j").setColumn(8);
        Section s19 = (new Section()).setRow("j").setColumn(9);
        Boat b6 = (new Boat())
                .setType("Patrol Boat")
                .withSections(s17,s18,s19);

        karli.withBoats(b6);
        ruben.withBoats(b1,b3,b4);

        for (Player player : game.getPlayers()) {
            player.getBoats().stream()
                .flatMap(b -> b.getSections().stream())
                .forEach(s -> s.setPlayer(player));
        }
    }
}
