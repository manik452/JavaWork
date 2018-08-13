package pattern.StructuralAdapterDesignPattern;

/**
 * Created by Manik on 7/24/2018.
 */
public interface SocketAdapter {

    public Volt get120Volt();
    public Volt get12Volt();
    public Volt get3Volt();
}
