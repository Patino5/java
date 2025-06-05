import java.util.Random;

public class Locker {
    private final int  number;
    private String pinNumber;

    public Locker(int number){
        this.number = number;
        this.pinNumber = null;
    }

    public String getPin() {
        return pinNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setPinNumber() {
        this.pinNumber = generatePin();
    }

    public void resetPin(){
        this.pinNumber = null;
    }

    public boolean isRented(){
        return this.pinNumber != null;
    }

    public String generatePin() {
        Random random = new Random();
        int pin = random.nextInt(10000);
        return String.format("%04d", pin);
    }
}
