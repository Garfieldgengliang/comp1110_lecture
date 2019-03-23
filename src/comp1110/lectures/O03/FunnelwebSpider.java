package comp1110.lectures.O03;

public class FunnelwebSpider implements Toxic {
    String name;

    public FunnelwebSpider(String name) {
        this.name = name;
    }

    @Override
    public boolean isLethalToHumans() {
        return true;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
