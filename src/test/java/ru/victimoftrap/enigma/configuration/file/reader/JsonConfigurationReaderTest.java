package ru.victimoftrap.enigma.configuration.file.reader;

import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;
import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaRotor;
import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaReflector;
import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaPlugboardConnection;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JsonConfigurationReaderTest {
    private ConfigurationReader reader = new JsonConfigurationReader();

    @Test
    void testReadConfiguration() throws ConfigurationNotFoundException {
        final List<FileEnigmaRotor> expectedRotors = Arrays.asList(
                new FileEnigmaRotor("RotorI", "A"),
                new FileEnigmaRotor("RotorII", "A"),
                new FileEnigmaRotor("RotorIII", "A")
        );
        final FileEnigmaConfiguration expectedConfiguration = new FileEnigmaConfiguration(
                expectedRotors,
                new FileEnigmaReflector("ReflectorB"),
                Arrays.asList(new FileEnigmaPlugboardConnection("A", "A"))
        );

        final FileEnigmaConfiguration actualConfiguration = reader.readConfiguration(
                "./src/test/resources/def-config.json"
        );

        assertNotNull(actualConfiguration);
        assertEquals(expectedConfiguration, actualConfiguration);
    }

    @Test
    void testReadConfiguration_fileNotFound_shouldThrowException() {
        try {
            reader.readConfiguration("./src/test/resources/no-config.json");
        } catch (ConfigurationNotFoundException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
        }
    }
}