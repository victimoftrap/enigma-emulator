package ru.victimoftrap.enigma.configuration.file.reader;

import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlConfigurationReader implements ConfigurationReader {
    @Override
    public FileEnigmaConfiguration readConfiguration(final String path) throws ConfigurationNotFoundException {
        final var yaml = new Yaml(new Constructor(FileEnigmaConfiguration.class));
        final var inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(path);
        if (inputStream == null) {
            throw new ConfigurationNotFoundException("Configuration file not found");
        }
        return yaml.load(inputStream);
    }
}
