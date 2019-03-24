package de.goatfryed.pm.association;

public class Subject {
    private Thing thing;

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        if (this.thing == thing) {
            return;
        }

        Thing oldThing = this.thing;
        this.thing = thing;

        if (this.thing != null) {
            this.thing.setSubject(this);
        }
        if (oldThing != null) {
            oldThing.setSubject(null);
        }
    }
}
