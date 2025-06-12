import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private Random rng;

    RandomNumberGenerator() {
        rng = new Random();
    }

    @Override
    public int generateNumber(int max) {
        return rng.nextInt(max) + 1;
    }
}
