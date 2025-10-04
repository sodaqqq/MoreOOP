package strategies;

import characters.GameCharacter;

public class HobbitKickStrategy implements KickStrategy {
    private final CryStrategy cryStrategy;

    public HobbitKickStrategy(CryStrategy cryStrategy) {
        this.cryStrategy = cryStrategy;
    }

    @Override
    public void kick(GameCharacter attacker, GameCharacter target) {
        cryStrategy.cry();
    }
}