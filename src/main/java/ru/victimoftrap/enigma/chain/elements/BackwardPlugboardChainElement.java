package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.plugboard.Plugboard;
import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class BackwardPlugboardChainElement extends ChainElement {
    private final Plugboard plugboard;

    public BackwardPlugboardChainElement(final Plugboard plugboard, final Rotor rotor) {
        super(rotor);
        this.plugboard = plugboard;
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        final AlphabeticSignal afterPlugboard = plugboard.backwardExchange(signal);
        return passNext(afterPlugboard);
    }
}
