package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class ForwardMiddleChainElement extends ChainElement {
    public ForwardMiddleChainElement(final Rotor rotor) {
        super(rotor);
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        rotateNext();

        final AlphabeticSignal betweenChange = forwardBetweenRotorsChange(signal);
        final AlphabeticSignal afterRotor = rotor.exchange(betweenChange);
        return passNext(afterRotor);
    }
}
