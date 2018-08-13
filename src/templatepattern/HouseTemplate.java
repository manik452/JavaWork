package templatepattern;

/**
 * Created by Manik on 8/9/2018.
 */
public abstract class HouseTemplate {

    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is Built.");
    }

    private void buildFoundation() {
        System.out.println("Build Foundation");
    }

    public void buildPillars() {
    }

    public void buildWalls() {
    }
    private void buildWindows() {
        System.out.println("Build Windows");
    }

}
