package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class BackwardStartChainElement extends ChainElement {
    public BackwardStartChainElement(final Rotor rotor) {
        super(rotor);
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        final AlphabeticSignal beforeRotor = beforeAllRotorsChange(signal);
        final AlphabeticSignal afterRotor = rotor.backwardExchange(beforeRotor);
        return passNext(afterRotor);
    }
}
