package ru.victimoftrap.enigma.rotors;

public interface Rotor {
    Character getFront(Character frontCharacter);

    Character getBack(Character backCharacter);

    int getNextRotorTriggeredStep();
}
