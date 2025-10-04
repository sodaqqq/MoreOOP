package strategies;

import characters.GameCharacter;

public interface KickStrategy {
    void kick(GameCharacter attacker, GameCharacter target);
}