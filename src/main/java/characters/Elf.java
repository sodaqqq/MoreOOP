package characters;
import strategies.ElfKickStrategy;

public class Elf extends GameCharacter {
    public Elf() {
        super(10, 10);
        this.kickStrategy = new ElfKickStrategy();
    }
}