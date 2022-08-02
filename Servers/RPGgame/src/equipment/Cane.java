package equipment;

public class Cane extends Weapon {

    private int cost;

    public Cane(String name, int op, int mp, int rm, int cost) {
        super(name, op, mp, rm);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
