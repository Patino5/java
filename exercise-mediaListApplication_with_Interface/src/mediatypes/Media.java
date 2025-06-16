package mediatypes;

public abstract class Media implements Describable, Playable {
    protected String name;

    public Media(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
