package factory;
import java.util.Random;

import characters.Elf;
import characters.GameCharacter;
import characters.Hobbit;
import characters.King;
import characters.Knight;

public class CharacterFactory {

    private static final Random random = new Random();

    public GameCharacter createCharacter() { 
        int choice = random.nextInt(4);

    switch (choice) {
        case 0:
            return new Elf();
        case 1:
            return new King();
        case 2:
            return new Knight();
        default:
            return new Hobbit();
    }
}
}