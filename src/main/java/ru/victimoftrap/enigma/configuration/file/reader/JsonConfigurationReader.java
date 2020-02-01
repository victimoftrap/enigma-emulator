package ru.victimoftrap.enigma.configuration.file.reader;

import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileNotFoundException;

public class JsonConfigurationReader implements ConfigurationReader {
    private final Gson gson = new Gson();

    @Override
    public FileEnigmaConfiguration readConfiguration(final String path) throws ConfigurationNotFoundException {
        try {
            return gson.fromJson(new FileReader(path), FileEnigmaConfiguration.class);
        } catch (FileNotFoundException e) {
            throw new ConfigurationNotFoundException("Configuration not found", e);
        }
    }
}
