package game;

import characters.GameCharacter;

public class GameManager {

    private static final int MAX_ROUNDS = 500;

    public void fight(GameCharacter c1, GameCharacter c2) {
        if (c1 == null || c2 == null) throw new IllegalArgumentException("Characters must not be null");
        if (!c1.isAlive() || !c2.isAlive()) {
            System.out.println("One of the fighters is already dead. Aborting fight.");
            return;
        }

        System.out.println("LET THE BATTLE BEGIN!");
        System.out.println("Fighters: " + describe(c1) + "  VS  " + describe(c2));
        System.out.println("--------------------------------------------------");

        int round = 1;
        while (c1.isAlive() && c2.isAlive() && round <= MAX_ROUNDS) {
            System.out.println("Round " + round + ":");

            doAttack(c1, c2);

            if (!c2.isAlive()) {
                System.out.println("Result: " + c2.getClass().getSimpleName() + " is DEAD. Fight ends.");
                break;
            }

            doAttack(c2, c1);

            if (!c1.isAlive()) {
                System.out.println("Result: " + c1.getClass().getSimpleName() + " is DEAD. Fight ends.");
                break;
            }

            System.out.println("--------------------------------------------------");
            round++;
        }

        if (round > MAX_ROUNDS) {
            System.out.println("Looks like the fight is not any soon to end... Declaring a draw.");
        }

        System.out.println("BATTLE OVER!");
        if (c1.isAlive() && !c2.isAlive()) {
            System.out.println("Winner: " + c1.getClass().getSimpleName());
        } else if (!c1.isAlive() && c2.isAlive()) {
            System.out.println("Winner: " + c2.getClass().getSimpleName());
        } else if (c1.isAlive() && c2.isAlive()) {
            System.out.println("No winner — both alive (draw).");
        } else {
            System.out.println("Both fighters are dead. Mutual annihilation.");
        }
    }

    private void doAttack(GameCharacter attacker, GameCharacter defender) {

        int defHpBefore = defender.getHp();
        int defPowerBefore = defender.getPower();
        int attHpBefore = attacker.getHp();
        int attPowerBefore = attacker.getPower();

        System.out.println(" -> " + attacker.getClass().getSimpleName() +
                " (" + attPowerBefore + "P / " + attHpBefore + "HP) attacks " +
                defender.getClass().getSimpleName() +
                " (" + defPowerBefore + "P / " + defHpBefore + "HP)");

        attacker.kick(defender);

        int defHpAfter = defender.getHp();
        int defPowerAfter = defender.getPower();
        int attHpAfter = attacker.getHp();
        int attPowerAfter = attacker.getPower();

        int damageToDef = defHpBefore - defHpAfter;
        int powerLossToDef = defPowerBefore - defPowerAfter;
        int damageToAtt = attHpBefore - attHpAfter;
        int powerLossToAtt = attPowerBefore - attPowerAfter;

        if (damageToDef > 0) {
            System.out.println("    -> " + defender.getClass().getSimpleName() +
                    " took " + damageToDef + " damage (HP: " + defHpBefore + " -> " + defHpAfter + ")");
        }
        if (powerLossToDef > 0) {
            System.out.println("    -> " + defender.getClass().getSimpleName() +
                    " lost " + powerLossToDef + " power (Power: " + defPowerBefore + " -> " + defPowerAfter + ")");
        }
        if (damageToDef == 0 && powerLossToDef == 0) {
            System.out.println("    -> No visible effect on " + defender.getClass().getSimpleName());
        }

        if (damageToAtt > 0) {
            System.out.println("    -> " + attacker.getClass().getSimpleName() +
                    " received " + damageToAtt + " damage (HP: " + attHpBefore + " -> " + attHpAfter + ")");
        }
        if (powerLossToAtt > 0) {
            System.out.println("    -> " + attacker.getClass().getSimpleName() +
                    " lost " + powerLossToAtt + " power (Power: " + attPowerBefore + " -> " + attPowerAfter + ")");
        }

        if (!defender.isAlive()) {
            System.out.println("    => " + defender.getClass().getSimpleName() + " fell in battle.");
        }
        if (!attacker.isAlive()) {
            System.out.println("    => " + attacker.getClass().getSimpleName() + " died as a result of the action.");
        }
    }

    private String describe(GameCharacter c) {
        return c.getClass().getSimpleName() + " [Power=" + c.getPower() + ", HP=" + c.getHp() + "]";
    }
}
