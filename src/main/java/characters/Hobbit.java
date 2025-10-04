package characters;
import strategies.CryStrategy;
import strategies.HobbitKickStrategy;

public class Hobbit extends GameCharacter implements CryStrategy {
    public Hobbit() {
        super(0, 3);
        this.kickStrategy = new HobbitKickStrategy(this);
    }
    
    @Override
    public void cry() {
        System.out.println("Hobbit cries loudly!");
    }
}