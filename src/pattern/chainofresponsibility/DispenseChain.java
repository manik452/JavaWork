package pattern.chainofresponsibility;

/**
 * Created by Manik on 8/16/2018.
 */
public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}
