package de.goatfryed.pm.association;

import java.util.HashSet;
import java.util.Set;

public class Thing {

    private Set<Item> items = new HashSet<>();

    private Subject subject = new Subject();

    public void withItems(final Item... items)
    {
        for (Item item : items) {
            if(item == null) {
                continue;
            }

            item.setThing(this);
        }
    }

    public void withoutItems(final Item... items)
    {
        for (Item item : items) {
            if (this.items.contains(item)) {
                item.setThing(null);
            }
        }
    }

    public Set<Item> getItems() {
        return items;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(final Subject subject) {
        if (this.subject == subject) {
            return;
        }

        Subject oldSubject = this.subject;
        this.subject = subject;

        if (this.subject != null) {
            this.subject.setThing(this);
        }
        if (oldSubject != null) {
            oldSubject.setThing(null);
        }
    }
}
