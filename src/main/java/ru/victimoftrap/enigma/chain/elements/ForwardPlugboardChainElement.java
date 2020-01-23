package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.plugboard.Plugboard;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class ForwardPlugboardChainElement extends ChainElement {
    private final Plugboard plugboard;

    public ForwardPlugboardChainElement(final Plugboard plugboard, final Rotor rotor) {
        super(rotor);
        this.plugboard = plugboard;
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        final AlphabeticSignal afterPlugboard = plugboard.exchange(signal);
        return passNext(afterPlugboard);
    }
}
