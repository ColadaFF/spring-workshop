package co.ias.bootcamp.springworkshop.domain;

public class Key {
    private final String id;
    private final String name;
    private final String value;

    public Key(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
