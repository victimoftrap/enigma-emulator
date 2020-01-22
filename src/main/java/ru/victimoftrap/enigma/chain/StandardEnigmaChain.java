package ru.victimoftrap.enigma.chain;

import ru.victimoftrap.enigma.chain.elements.*;
import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.reflectors.Reflector;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import java.util.Arrays;
import java.util.List;

public class StandardEnigmaChain implements EnigmaChain {
    private List<Rotor> rotors;
    private Reflector reflector;
    private ChainElement chain;

    private ChainElement buildChain(
            final Rotor rotor1,
            final Rotor rotor2,
            final Rotor rotor3,
            final Reflector reflector) {
        final ChainElement forwardStartElement = new ForwardStartChainElement(rotor1);
        final ChainElement forwardMiddleElement = new ForwardMiddleChainElement(rotor2);
        final ChainElement beforeReflectorElement = new ForwardMiddleChainElement(rotor3);

        final ChainElement reflectorElement = new ReflectorChainElement(reflector, rotor3);

        final ChainElement backwardStartElement = new BackwardStartChainElement(rotor3);
        final ChainElement backwardMiddleElement = new BackwardMiddleChainElement(rotor2);
        final ChainElement endElement = new EndChainElement(rotor1);

        forwardStartElement.setNext(forwardMiddleElement);

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

        endElement.setPrev(backwardMiddleElement);
        return forwardStartElement;
    }

    public StandardEnigmaChain(
            final Rotor rotor1,
            final Rotor rotor2,
            final Rotor rotor3,
            final Reflector reflector
    ) {
        this.rotors = Arrays.asList(rotor1, rotor2, rotor3);
        this.reflector = reflector;

        this.chain = buildChain(rotor1, rotor2, rotor3, reflector);
    }

    public StandardEnigmaChain withRotorInitialPosition(final int rotorNumber, final char position) {
        rotors.get(rotorNumber).getInitialPosition().setCharacter(position);
        return this;
    }

    @Override
    public AlphabeticSignal passTrough(final AlphabeticSignal signal) {
        return chain.pass(signal);
    }
}
