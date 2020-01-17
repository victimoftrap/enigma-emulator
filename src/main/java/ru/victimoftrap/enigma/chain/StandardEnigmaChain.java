package ru.victimoftrap.enigma.chain;

import ru.victimoftrap.enigma.chain.elements.*;
import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.reflectors.Reflector;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class StandardEnigmaChain implements EnigmaChain {
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Reflector reflector;
    private ChainElement chain;

    private ChainElement buildChain() {
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

    public StandardEnigmaChain(final Rotor rotor1,
                               final Rotor rotor2,
                               final Rotor rotor3,
                               final Reflector reflector) {
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;
        this.reflector = reflector;
        chain = buildChain();
    }

    public StandardEnigmaChain withFirstRotorInitialPosition(final char position) {
        rotor1.getInitialPosition().setCharacter(position);
        return this;
    }

    public StandardEnigmaChain withSecondRotorInitialPosition(final char position) {
        rotor2.getInitialPosition().setCharacter(position);
        return this;
    }

    public StandardEnigmaChain withThirdRotorInitialPosition(final char position) {
        rotor3.getInitialPosition().setCharacter(position);
        return this;
    }

    @Override
    public AlphabeticSignal passTrough(final AlphabeticSignal signal) {
        return chain.pass(signal);
    }
}
