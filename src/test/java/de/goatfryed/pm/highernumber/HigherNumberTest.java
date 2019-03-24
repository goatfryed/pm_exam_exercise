package de.goatfryed.pm.highernumber;

import de.goatfryed.pm.highernumber.model.Comment;
import de.goatfryed.pm.highernumber.model.Game;
import de.goatfryed.pm.highernumber.model.Player;
import de.goatfryed.pm.highernumber.model.Number;
import org.junit.Test;

public class HigherNumberTest {
    public HigherNumberTest() {
    }

    @Test
    public void someState() {
        Game game = new Game();
        Player stan = (new Player()).setName("stan");
        Player roger = (new Player()).setName("roger");

        game.withPlayers(stan, roger);

        Comment pickIt = new Comment();
        pickIt.setText("Okay, okay. Perhaps you should name your Game. But I must warn you! I never lose");
        pickIt.setAuthor(roger);
        pickIt.setDate("not to long ago");
        stan.withReceived(pickIt);

        game.setCurrentPlayer(roger);
        Number rogersNumber = (new Number()).setValue(6000).setPickedBy(roger);
        game.setCurrentPlayer(stan);
        Number stansNumber = (new Number()).setValue(17000).setPickedBy(stan);
        game.setWinner(stan);

        Comment wellPlayer = (new Comment())
                .setText("Huh! ... well played.")
                .setAuthor(roger)
                .withRecipients(stan)
                .setDate("shortly after");
    }
}