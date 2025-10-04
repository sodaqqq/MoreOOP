package characters;
import java.util.Random;

import strategies.KnightKickStrategy;

public class Knight extends GameCharacter {
    private static final Random random = new Random();

    public Knight() {
        super(2 + random.nextInt(11), 2 + random.nextInt(11));
        this.kickStrategy = new KnightKickStrategy();
    }
}