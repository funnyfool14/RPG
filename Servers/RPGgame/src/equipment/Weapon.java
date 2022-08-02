package equipment;

public abstract class Weapon {

    private String name;
    private int op;
    private int mp;
    private int rm;

    public Weapon(String name, int op, int mp, int rm) {
        this.name = name;
        this.op = op;
        this.mp = mp;
        this.rm = rm;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

}
