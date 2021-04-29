package tribble.model;

public class Tribble {
    private int id;
    private String color;
    private int lab_id;

    public Tribble() {
    }

    public Tribble(int id, String color, int lab_id) {
        this.id = id;
        this.color = color;
        this.lab_id = lab_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLab_id() {
        return lab_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }
}
