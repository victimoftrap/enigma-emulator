package ru.victimoftrap.enigma.rotors;

public interface BiDirectionConnection {
    Character getFront(Character frontCharacter);

    Character getBack(Character backCharacter);
}
