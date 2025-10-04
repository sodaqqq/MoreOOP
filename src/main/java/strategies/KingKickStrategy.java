package strategies;
import java.util.Random;

import characters.GameCharacter;

public class KingKickStrategy implements KickStrategy {
    private static final Random random = new Random();

    @Override
    public void kick(GameCharacter attacker, GameCharacter target) {
        int damage = random.nextInt(attacker.getPower() + 1);
        System.out.println("King deals " + damage + " damage!");
        target.setHp(target.getHp() - damage);
    }
}