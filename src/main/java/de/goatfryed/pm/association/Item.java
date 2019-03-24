package de.goatfryed.pm.association;

import java.util.HashSet;
import java.util.Set;

public class Item {
    private Thing thing;

    private Set<Token> tokens = new HashSet<>();

    public Thing getThing() {
        return thing;
    }

    public void setThing(final Thing thing) {
        if (thing == this.thing) {
            return;
        }
        if (this.thing != null) {
            this.thing.getItems().remove(this);
        }
        if (thing != null) {
            thing.getItems().add(this);
        }

        this.thing = thing;
    }

    public Set<Token> getTokens() {
        return tokens;
    }

    public void withTokens(final Token... tokens)
    {
        for (Token token : tokens) {
            if (token == null) {
                continue;
            }
            token.getItems().add(this);
            this.getTokens().add(token);
        }
    }

    public void withoutTokens(final Token... tokens)
    {
        for (Token token : tokens) {
            this.getTokens().remove(token);
            token.getItems().remove(this);
        }
    }
}
