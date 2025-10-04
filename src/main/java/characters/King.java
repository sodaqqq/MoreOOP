package characters;
import java.util.Random;

import strategies.KingKickStrategy;

public class King extends GameCharacter {
    private static final Random random = new Random();

    public King() {
        super(5 + random.nextInt(11), 5 + random.nextInt(11));
        this.kickStrategy = new KingKickStrategy();
    }
}