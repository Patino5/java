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

    public void setPinNumber(String newPin) {
        this.pinNumber = newPin;
    }

    public void resetPin(){
        this.pinNumber = null;
    }

}
