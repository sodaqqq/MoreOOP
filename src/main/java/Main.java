import characters.GameCharacter;
import factory.CharacterFactory;
import game.GameManager;

public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        GameManager manager = new GameManager();

        GameCharacter c1 = factory.createCharacter();
        GameCharacter c2 = factory.createCharacter();

        manager.fight(c1, c2);
    }
}
