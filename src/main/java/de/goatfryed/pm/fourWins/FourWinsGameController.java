package de.goatfryed.pm.fourWins;

public class FourWinsGameController {

    public boolean insert(Token token, Column column)
    {
        int height = column.getTokens().stream().mapToInt(Token::getHeight).max().orElse(-1) + 1;

        if (height > column.getMaxHeight()) {
            return false;
        }

        token.setHeight(height);
        token.setColumn(column);

        if (checkWinner(token)) {
            column.getGame().setWinner(token.getPlayer());
        } else {
            // next Player
        }

        return true;
    }

    public boolean checkWinner(Token trigger)
    {
        return checkColumn(trigger)
            || hasSeries(trigger, 0)
            || hasSeries(trigger, 1)
            || hasSeries(trigger, -1)
        ;
    }

    private boolean checkColumn(Token trigger) {
        return trigger.getColumn().getTokens().stream()
                .filter(t -> t.getPlayer() == trigger.getPlayer())
                .filter(t -> t.getHeight() > trigger.getHeight() - 4)
                .count() > 4;
    }

    private boolean hasSeries(Token trigger, int increment)
    {
        return 4 < 1 + countSeries(trigger, true, increment) + countSeries(trigger, false, -increment);
    }

    private int countSeries(Token trigger, boolean goLeft, int increment) {
        int i = 0;
        Column other = trigger.getColumn();
        int height = trigger.getHeight();
        while (true) {
            other = goLeft ? other.getLeft() : other.getRight();
            int expectedHeight = height + increment;

            if (other == null || height < 0) {
                break;
            }
            boolean match = other.getTokens().stream()
                    .filter(t -> t.getPlayer() == trigger.getPlayer())
                    .anyMatch(t -> t.getHeight() == expectedHeight);

            if (match) {
                i++;
                height = expectedHeight;
            } else {
                break;
            }
        }
        return i;
    }
}
