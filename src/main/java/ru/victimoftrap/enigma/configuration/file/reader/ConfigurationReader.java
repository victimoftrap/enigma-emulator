package ru.victimoftrap.enigma.configuration.file.reader;

import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;

public interface ConfigurationReader {
    FileEnigmaConfiguration readConfiguration(String path) throws ConfigurationNotFoundException;
}
