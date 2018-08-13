package pattern.StructuralAdapterDesignPattern;

/**
 * Created by Manik on 7/24/2018.
 */
public class Socket {

    public Volt getVolt(){
        return new Volt(120);
    }
}
