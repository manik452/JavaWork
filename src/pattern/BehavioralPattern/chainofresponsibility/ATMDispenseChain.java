package pattern.BehavioralPattern.chainofresponsibility;

/**
 * Created by Manik on 8/16/2018.
 */
public class ATMDispenseChain {

    public DispenseChain chain1;

    public ATMDispenseChain(){
        this.chain1 = new Dollar50Dispenser();
        DispenseChain chain2 = new Dollar20Dispenser();
        DispenseChain chain3 = new Dollar10Dispenser();
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }
}
