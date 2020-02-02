# Enigma Emulator
### About this emulator
You can read [wiki page](https://en.wikipedia.org/wiki/Enigma_machine), [history of Enigma](https://www.cryptomuseum.com/crypto/enigma/hist.htm), [how it works](http://enigma.louisedade.co.uk/howitworks.html).

### Available rotors:
- Rotor I;
- Rotor II;
- Rotor III;
- Rotor IV;
- Rotor V;
- Rotor VI.
### Available reflectors:
- Reflector A;
- Reflector B;
- Reflector C.
### Default Enigma configuration:
- rotors: `ROTOR_I, ROTOR_II, ROTOR_III`;
   * initial positions: `A` for all rotors;
- reflector: `REFLECTOR_B`;
- plugboard: not used.

### Getting started
Install software that used in this application.
#### Prerequisites
To run this application you need to install: 
- [OpenJDK](https://openjdk.java.net/install/) or [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html), version 1.11 or later;
- [Apache Maven](https://maven.apache.org/download.cgi).

#### Installation
Now you can install this emulator.
- Firstly, clone this repository.
```bash
$ git clone https://github.com/victimoftrap/enigma-emulator.git
```
- Move to project package and run this command for build project.
```bash
$ mvn package
```
- Run project.
```bash
cd ./target/
java -jar enigma-emulator.jar -m AAAA
```

### Used keys
You can use this keys to run Enigma:
- `-c configuration` - path to Enigma configuration. Available `.json` and `.yml` configs.
If this key not used, Enigma would apply default configuration.
- `-m message` - message that would be encrypted.
