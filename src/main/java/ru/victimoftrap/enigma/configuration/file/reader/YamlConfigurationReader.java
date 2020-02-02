package ru.victimoftrap.enigma.configuration.file.reader;

import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class YamlConfigurationReader implements ConfigurationReader {
    @Override
    public FileEnigmaConfiguration readConfiguration(final String path) throws ConfigurationNotFoundException {
        final var yaml = new Yaml(new Constructor(FileEnigmaConfiguration.class));

        try {
            final var inputStream = new FileInputStream(new File(path));
            return yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new ConfigurationNotFoundException("Configuration file not found");
        }
    }
}
