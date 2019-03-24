package de.goatfryed.pm.association;

import java.util.HashSet;
import java.util.Set;

public class Token {
    private Set<Item> items = new HashSet<>();

    public Set<Item> getItems() {
        return items;
    }

    public void withItems(final Item... items)
    {
        for (Item item : items) {
            if (item == null) {
                continue;
            }
            item.withTokens(this);
        }
    }

    public void withoutItems(final Item... items)
    {
        for (Item item : items) {
            if (item == null) {
                continue;
            }
            item.withoutTokens(this);
        }
    }
}
