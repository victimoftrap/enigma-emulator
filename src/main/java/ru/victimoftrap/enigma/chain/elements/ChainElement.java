package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public abstract class ChainElement {
    protected ChainElement nextChain;
    protected ChainElement prevChain;
    protected final Rotor rotor;

    public ChainElement(final Rotor rotor) {
        this.rotor = rotor;
    }

    public ChainElement setNext(final ChainElement element) {
        if (nextChain == null) {
            nextChain = element;
        } else {
            nextChain.setNext(element);
        }
        return nextChain;
    }

    public ChainElement setPrev(final ChainElement element) {
        if (prevChain == null) {
            prevChain = element;
        } else {
            prevChain.setPrev(element);
        }
        return prevChain;
    }

    protected void rotateNext() {
        if (nextChain != null && rotor.getInitialPosition().getCharacter() == rotor.getTurnoverPosition()) {
            nextChain.rotor.rotate();
        }
    }

    protected AlphabeticSignal beforeAllRotorsChange(final AlphabeticSignal signal) {
        return signal.plus(rotor.getInitialPosition());
    }

    protected AlphabeticSignal afterAllRotorsChange(final AlphabeticSignal signal) {
        return signal.minus(rotor.getInitialPosition());
    }

    protected AlphabeticSignal forwardBetweenRotorsChange(final AlphabeticSignal signal) {
        final AlphabeticSignal currentRotorRing = new AlphabeticSignal(
                rotor.getInitialPosition().getCharacter()
        );
        final AlphabeticSignal rotorDifference = currentRotorRing
                .minus(prevChain.rotor.getInitialPosition());
        return signal.plus(rotorDifference);
    }

    protected AlphabeticSignal backwardBetweenRotorsChange(final AlphabeticSignal signal) {
        final AlphabeticSignal previousRotorRing = new AlphabeticSignal(
                prevChain.rotor.getInitialPosition().getCharacter()
        );
        final AlphabeticSignal rotorDifference = previousRotorRing
                .minus(rotor.getInitialPosition().getCharacter());
        return signal.minus(rotorDifference);
    }

    public abstract AlphabeticSignal pass(AlphabeticSignal signal);

    protected AlphabeticSignal passNext(final AlphabeticSignal signal) {
        if (nextChain == null) {
            return signal;
        } else {
            return nextChain.pass(signal);
        }
    }
}
