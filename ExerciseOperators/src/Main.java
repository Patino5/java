//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double loanAmount = 25_000.00; // in dollars
        double annualIntrestRate = 5.5; // as a percentage
        int loanTermYears = 5;
        double monthlyPayments;

        // calculate monthly payments
        monthlyPayments = (loanAmount * (annualIntrestRate/100) / 12);

        // assignment operators
        loanAmount += 5000;
        annualIntrestRate -= 1;
        loanTermYears ++;

        // comparison operators
        System.out.println(loanAmount > 30_000);
        System.out.println(monthlyPayments > 500);

        // logical operators
        boolean affordable = (monthlyPayments < 500 && loanTermYears > 3);
        boolean expensive = (monthlyPayments > 700 || annualIntrestRate > 6);


        System.out.println("Loan amount: " + loanAmount);
        System.out.println("Annual Interest Rate: " + annualIntrestRate);
        System.out.println("Loan Terms in Years: " + loanTermYears);
        System.out.println("Monthly Payments: " + monthlyPayments);
        System.out.println("Affordable: " + affordable);
        System.out.println("Expensive: " + expensive);

        // Weather - Temperature Conversion & Forecast Analysis
        double temperatureCelsius = 25.0; // Current temperature in Celsius
        boolean isRaining = false; // Indicates if it's raining
        int windSpeedKmh = 10; // Wind speed in km/h

        // Convert Celsius to Fahrenheit
        double temperatureFahrenheit = (temperatureCelsius * 9/5) + 32;

        // Assignment Operators
        temperatureCelsius += 5;
        windSpeedKmh += 5;

        // comparison operators
        System.out.println("Temp in Fahrenheit exceeds 85F: " + (temperatureFahrenheit > 85));
        System.out.println("Wind speed is greater than 20 km/h: " + (windSpeedKmh > 20));
        // Logical operators
        System.out.println("It a good day to go outside: " + (isRaining == false &&  (60 < temperatureFahrenheit )&& (temperatureFahrenheit < 85)));
        System.out.println("Weather warning: " + (windSpeedKmh > 30 || temperatureCelsius < 0));


        // Gaming - Player Score and Level Up System
        int currentXP = 1200; // experience points
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

        // Arithmetic Operators
        int completeQuest = 300;
        xpToNextLevel -= currentXP;
        boolean doubleXP = false; // completeQuest *= 2

        if (doubleXP == true) {
            completeQuest *= 2;
        }
        currentXP += completeQuest;

        if (currentXP >= xpToNextLevel){
            levelUp = true;
            xpToNextLevel += 1500;
        } else {
            levelUp = false;
        }

        currentXP += completeQuest;


        // comparison operators
        System.out.println("Current XP greater than XP to next level: " + (currentXP > xpToNextLevel));
        System.out.println("Player has reached level 10: " + (level == 10));

        // Logical Operators
        System.out.println("Can level up: " + ((level < 10) && (xpToNextLevel <= 0)));
        System.out.println("Player is a pro: " + ((level > 7) && (currentXP > 5000)));

        System.out.println("Current XP: " + currentXP);
        System.out.println("levelUp: " + levelUp);
    }
}