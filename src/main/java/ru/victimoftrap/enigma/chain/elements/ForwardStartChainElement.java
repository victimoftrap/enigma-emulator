package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class ForwardStartChainElement extends ChainElement {
    public ForwardStartChainElement(final Rotor rotor) {
        super(rotor);
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        rotor.rotate();
        rotateNext();

        final AlphabeticSignal beforeRotor = beforeAllRotorsChange(signal);
        final AlphabeticSignal afterRotor = rotor.exchange(beforeRotor);
        return passNext(afterRotor);
    }
}
