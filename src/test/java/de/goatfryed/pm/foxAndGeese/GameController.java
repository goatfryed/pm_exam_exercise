package de.goatfryed.pm.foxAndGeese;

import java.util.Objects;

public class GameController {

    public static enum Direction {
        NORTHWEST,
        NORTH,
        NORTHEAST,
        EAST,
        SOUTHEAST,
        SOUTH,
        SOUTHWEST,
        WEST
    }

    private Game game;

    public Game init(Player fox, Player geese) {

        game = new Game();

        game.setFox(fox);
        game.setGeese(geese);

        Field[][] fields = new Field[7][7];

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if (
                    (y < 2 || y > 4)
                    && (x < 2 || x > 4)
                ) {
                    continue;
                }
                fields[y][x] = new Field();

                if (x > 0) {
                    fields[y][x].setWest(fields[y][x-1]);
                }
                if (y > 0) {
                    fields[y][x].setSouth(fields[y-1][x]);
                }
            }
        }

        for (int y = 1; y < 7; y += 2) {
            for (int x = 1; x < 7; x += 2) {
                Field field = fields[y][x];
                if (field == null) {
                    continue;
                }
                field.setSoutheast(fields[y-1][x+1]);
                field.setSouthwest(fields[y-1][x-1]);
                field.setNortheast(fields[y+1][x+1]);
                field.setNorthwest(fields[y+1][x-1]);
            }
        }

        fox.withMeeples((new Meeple()).setField(fields[3][2]));

        for (int y = 3; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if (y == 3 && x > 1 && x < 5) {
                    continue;
                }
                Field field = fields[x][y];
                if (field != null) {
                    geese.withMeeples((new Meeple()).setField(field));
                }
            }
        }

        game.setCurrentPlayer(geese);

        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean move(Meeple meeple, Field target) {
        Objects.requireNonNull(meeple.getPlayer());
        Objects.requireNonNull(meeple.getField());
        Objects.requireNonNull(target);

        if (target.getMeeple() != null) {
            return false;
        }

        if (canMove(meeple, target)) {
            target.setMeeple(meeple);
            checkWinner();
            nextPlayer();
            return true;
        }

        if (meeple.getPlayer().getFoxOf() != null) {
            Direction direction = canJump(meeple, target);

            if (direction != null) {
                getNeighbor(meeple.getField(), direction).getMeeple().removeYou();
                meeple.setField(target);
                checkWinner();
                nextPlayer();
                return true;
            }
        }

        return false;
    }

    private boolean canMove(Meeple meeple, Field target) {
        Field current = meeple.getField();

        for (Direction direction : Direction.values()) {
            if (getNeighbor(current, direction) == target) {
                return true;
            }
        }
        return false;
    }

    private Direction canJump(Meeple fox, Field target) {
        for (Direction direction : Direction.values()) {
            if (target == canJump(fox, direction)) {
                return direction;
            }
        }

        return null;
    }

    private Field canJump(Meeple fox, Direction direction)
    {
        Field neighbor = getNeighbor(fox.getField(), direction);

        if (neighbor == null) {
            return null;
        }
        Field next = getNeighbor(neighbor, direction);

        if (next == null || next.getMeeple() != null) {
            return null;
        }

        if (
                neighbor.getMeeple() != null
                && neighbor.getMeeple().getPlayer().getGeeseOf() != null
        ) {
            return next;
        }

        return null;
    }

    private void nextPlayer() {
        if (game.getCurrentPlayer() == game.getGeese()) {
            game.setCurrentPlayer(game.getFox());
        } else {
            game.setCurrentPlayer(game.getGeese());
        }
    }

    private Field getNeighbor(Field field, Direction direction) {
        if (field == null) {
            return null;
        }

        switch (direction) {
            case NORTHWEST:
                return field.getNorthwest();
            case NORTH:
                return field.getNorth();
            case NORTHEAST:
                return field.getNortheast();
            case EAST:
                return field.getEast();
            case SOUTHEAST:
                return field.getSoutheast();
            case SOUTH:
                return field.getSouth();
            case SOUTHWEST:
                return field.getSouthwest();
            case WEST:
                return field.getWest();
            default:
                return null;
        }
    }

    public boolean checkWinner()
    {
        if ( checkGeeseWon()) {
            game.setWinner(game.getGeese());
            return true;
        } else if (checkFoxWon()) {
            game.setWinner(game.getFox());
            return true;
        }
        return false;
    }

    private boolean checkGeeseWon() {
        Meeple fox = game.getFox().getMeeples().stream().findFirst().orElseThrow(NullPointerException::new);
        Field foxLocation = fox.getField();

        for (Direction direction : Direction.values()) {
            Field field = getNeighbor(foxLocation, direction);

            if (field == null) {
                continue;
            }
            if (field.getMeeple() == null) {
                return false;
            }
            if (canJump(fox, direction) != null) {
                return false;
            }
        }

        return true;
    }

    private boolean checkFoxWon()
    {
        return game.getGeese().getMeeples()
                .stream()
                .filter(m -> m.getField() != null)
                .count() < 6;
    }
}
