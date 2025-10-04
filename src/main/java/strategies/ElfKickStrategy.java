package strategies;
import characters.GameCharacter;

public class ElfKickStrategy implements KickStrategy {
    @Override
    public void kick(GameCharacter attacker, GameCharacter target) {
        if (target.getPower() < attacker.getPower()) {
            System.out.println("Elf kills the weaker character!");
            target.setHp(0);
        } else {
            System.out.println("Elf weakens the enemy!");
            target.setPower(target.getPower() - 1);
        }
    }
}