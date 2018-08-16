package pattern.templatepattern;

/**
 * Created by Manik on 8/9/2018.
 */
public class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls(){
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars(){
        System.out.println("Building buildPillars ");
    }
}
