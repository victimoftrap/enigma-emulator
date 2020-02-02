package ru.victimoftrap.enigma;

import ru.victimoftrap.enigma.configuration.EnigmaConfiguration;
import ru.victimoftrap.enigma.configuration.DefaultEnigmaConfiguration;
import ru.victimoftrap.enigma.configuration.file.FileEnigmaConfigurationConverter;
import ru.victimoftrap.enigma.configuration.file.FileEnigmaConfigurationConverterException;
import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;
import ru.victimoftrap.enigma.configuration.file.reader.ConfigurationReader;
import ru.victimoftrap.enigma.configuration.file.reader.JsonConfigurationReader;
import ru.victimoftrap.enigma.configuration.file.reader.YamlConfigurationReader;
import ru.victimoftrap.enigma.configuration.file.reader.ConfigurationNotFoundException;
import ru.victimoftrap.enigma.configuration.file.reader.UnsupportedConfigurationException;

import org.apache.commons.cli.*;

public class CommandLineEnigmaStarter {
    private ConfigurationReader jsonReader;
    private ConfigurationReader yamlReader;

    public CommandLineEnigmaStarter() {
        jsonReader = new JsonConfigurationReader();
        yamlReader = new YamlConfigurationReader();
    }

    public void buildAndStart(final String[] args) {
        final var configurationOption = new Option("c", "configuration");
        configurationOption.setArgs(1);
        configurationOption.setArgName("File with enigma configuration");

        final var messageOption = new Option("m", "message");
        messageOption.setArgs(1);
        messageOption.setArgName("Message for enigma");

        final var allOptions = new Options();
        allOptions.addOption(configurationOption);
        allOptions.addOption(messageOption);
        final var commandLineParser = new PosixParser();

        EnigmaConfiguration enigmaConfiguration = new DefaultEnigmaConfiguration();
        String sourceMessage = "";
        try {
            final CommandLine commandLine = commandLineParser.parse(allOptions, args);
            if (commandLine.hasOption(configurationOption.getOpt())) {
                final var fileName = commandLine.getOptionValue(configurationOption.getOpt());

                final FileEnigmaConfiguration fileEnigmaConfiguration;
                if (fileName.contains(".json")) {
                    fileEnigmaConfiguration = jsonReader.readConfiguration(fileName);
                } else if (fileName.contains(".yml")) {
                    fileEnigmaConfiguration = yamlReader.readConfiguration(fileName);
                } else {
                    throw new UnsupportedConfigurationException("Configuration file type not supported");
                }
                enigmaConfiguration = FileEnigmaConfigurationConverter.create(fileEnigmaConfiguration);
            }
            if (commandLine.hasOption(messageOption.getOpt())) {
                sourceMessage = commandLine.getOptionValue(messageOption.getOpt());
            }
        } catch (ParseException pe) {
            System.err.println("Invalid command line keys");
        } catch (ConfigurationNotFoundException | UnsupportedConfigurationException |
                FileEnigmaConfigurationConverterException e) {
            System.err.println(e.getMessage());
        }

        var enigma = new Enigma(enigmaConfiguration);
        var result = enigma.encode(sourceMessage);
        System.out.printf("Encrypted message: %s\n", result);
    }
}
