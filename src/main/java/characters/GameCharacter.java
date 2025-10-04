package characters;
import strategies.KickStrategy;

public abstract class GameCharacter {
    protected int power;
    protected int hp;
    protected KickStrategy kickStrategy;

    public GameCharacter(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }

    public void kick(GameCharacter c) {
        kickStrategy.kick(this, c);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public void setPower(int power) {
        this.power = Math.max(0, power);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (Power: " + power + ", HP: " + hp + ")";
    }
}