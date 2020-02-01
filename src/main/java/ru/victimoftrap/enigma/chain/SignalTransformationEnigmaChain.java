package ru.victimoftrap.enigma.chain;

import ru.victimoftrap.enigma.chain.elements.*;
import ru.victimoftrap.enigma.plugboard.Plugboard;
import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.reflectors.Reflector;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import java.util.List;

public class SignalTransformationEnigmaChain implements EnigmaChain {
    private Plugboard plugboard;
    private List<Rotor> rotors;
    private Reflector reflector;
    private ChainElement chain;

    private ChainElement buildChain(
            final Plugboard plugboard,
            final Rotor rotor1,
            final Rotor rotor2,
            final Rotor rotor3,
            final Reflector reflector
    ) {
        final var forwardPlugboardElement = new ForwardPlugboardChainElement(plugboard, rotor1);
        final var forwardStartElement = new ForwardStartChainElement(rotor1);
        final var forwardMiddleElement = new ForwardMiddleChainElement(rotor2);
        final var beforeReflectorElement = new ForwardMiddleChainElement(rotor3);

        final var reflectorElement = new ReflectorChainElement(reflector, rotor3);

        final var backwardStartElement = new BackwardStartChainElement(rotor3);
        final var backwardMiddleElement = new BackwardMiddleChainElement(rotor2);
        final var endElement = new EndChainElement(rotor1);
        final var backwardPlugboardElement = new BackwardPlugboardChainElement(plugboard, rotor1);

        forwardPlugboardElement.setNext(forwardStartElement);

        forwardStartElement.setNext(forwardMiddleElement);
        forwardMiddleElement.setPrev(forwardPlugboardElement);

        forwardMiddleElement.setNext(beforeReflectorElement);
        forwardMiddleElement.setPrev(forwardStartElement);

        beforeReflectorElement.setNext(reflectorElement);
        beforeReflectorElement.setPrev(forwardMiddleElement);

        reflectorElement.setNext(backwardStartElement);
        reflectorElement.setPrev(beforeReflectorElement);

        backwardStartElement.setNext(backwardMiddleElement);
        backwardStartElement.setPrev(reflectorElement);

        backwardMiddleElement.setNext(endElement);
        backwardMiddleElement.setPrev(backwardStartElement);

        endElement.setNext(backwardPlugboardElement);
        endElement.setPrev(backwardMiddleElement);

        backwardPlugboardElement.setPrev(endElement);
        return forwardPlugboardElement;
    }

    public SignalTransformationEnigmaChain(
            final Plugboard plugboard,
            final List<Rotor> rotors,
            final Reflector reflector
    ) {
        this.plugboard = plugboard;
        this.rotors = rotors;
        this.reflector = reflector;

        this.chain = buildChain(
                plugboard, rotors.get(0), rotors.get(1), rotors.get(2), reflector
        );
    }

    @Override
    public AlphabeticSignal passTrough(final AlphabeticSignal signal) {
        return chain.pass(signal);
    }
}
