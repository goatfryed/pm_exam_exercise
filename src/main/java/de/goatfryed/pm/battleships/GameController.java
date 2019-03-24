package de.goatfryed.pm.battleships;

import de.goatfryed.pm.battleships.model.Game;
import de.goatfryed.pm.battleships.model.Player;
import de.goatfryed.pm.battleships.model.Section;
import de.goatfryed.pm.battleships.model.Shot;
import de.goatfryed.pm.battleships.model.tables.GameTable;

import java.util.Objects;
import java.util.Set;

public class GameController {

    private Game game;

    public boolean shootStream(int column, String row)
    {
        Player currentPlayer = game.getCurrentPlayer();

        Objects.nonNull(currentPlayer);

        Shot shot = new Shot();
        shot.setColumn(column)
                .setRow(row)
                .setPlayer(currentPlayer)
        ;

        Section hit = game.getPlayers().stream()
                .filter(p -> p != currentPlayer)
                .flatMap(p -> p.getSections().stream())
                .filter(section -> section.getColumn() == shot.getColumn() && section.getRow().equals(shot.getRow()))
                .findFirst().orElse(null)
                ;

        if (hit == null) {
            nextPlayer();
            return false;
        }

        shot.setHit(hit);
        boolean survived = hit.getPlayer()
                .getSections().stream()
                .anyMatch(s -> s.getShotBy() != null)
                ;

        if (!survived) {
            game.setWinner(currentPlayer);
        } else {
            nextPlayer();
        }

        return true;
    }

    public void nextPlayer() {
        Player next = (new GameTable(game))
            .expandPlayers()
            .filter(p -> p != game.getCurrentPlayer())
            .toSet()
            .iterator()
            .next()
        ;
        game.setCurrentPlayer(next);
    }

    public boolean shootTables(int column, String row)
    {
        Player currentPlayer = game.getCurrentPlayer();

        Objects.nonNull(currentPlayer);

        Shot shot = new Shot();
        shot.setColumn(column)
                .setRow(row)
                .setPlayer(currentPlayer)
        ;


        Set<Section> candidates = new GameTable(game)
                .expandPlayers()
                .expandSections()
                .filter(section -> section.getColumn() == shot.getColumn() && section.getRow().equals(shot.getRow()))
                .toSet()
                ;

        if (candidates.isEmpty()) {
            nextPlayer();
            return false;
        }

        Section hit = candidates.iterator().next();

        shot.setHit(hit);
        boolean survived = (new GameTable(game))
                .expandPlayers()
                .expandSections()
                .expandShotBy()
                .toSet()
                .size() > 0
                ;

        if (!survived) {
            game.setWinner(currentPlayer);
        } else {
            nextPlayer();
        }

        return true;
    }
}