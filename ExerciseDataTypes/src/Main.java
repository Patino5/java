
public class Main {
    public static void main(String[] args) {
        String playerName = "Lionel Messi";
        int jerseyNumber = 10;
        String position = "Forward";
        boolean isStarter = true;
        String teamName = "Inter Miami";

        String movieTitle = "Super Troopers";
        int releaseYear = 2002;
        String rating = "R";
        boolean isSequel = true;
        String leadActor = "Jay Chandrasekhar";

        String cityName = "Leander";
        int temperature = 87;
        boolean isRaining = false;
        String humidity = "55%";
        String weatherCondition = "Sunny";


        String flightNumber = "AA256";
        String departureCity = "New York";
        String arrivalCity = "Los Angeles";
        int gateNumber = 5;
        char terminal = 'B';
        boolean isDelayed = false;

        System.out.println("Soccer Player: " + playerName + " wears jersey number " +
                jerseyNumber + " and plays as a " + position + " for " + teamName + ".");
        System.out.println("The movie " + movieTitle + " was released in " +
                releaseYear + " and stars " + leadActor + ".");
        System.out.println("Weather Report: " + cityName + " has a temperature of " +
                temperature + "°F with " + weatherCondition + ".");
        System.out.printf("My flight number: %s, from %s to %s, leaving from terminal: %c Gate: %n is Delayed: %d", flightNumber, departureCity, arrivalCity,terminal,gateNumber,isDelayed);

        jerseyNumber = 5;
        isStarter = false;

        rating = "PG-13";
        isSequel = false;

        temperature = 75;
        weatherCondition = "Cloudy with a chance of meatballs";

        gateNumber = 4;
        isDelayed = true;

        System.out.printf("%s and %s", jerseyNumber, isStarter);
        System.out.println(rating + " " + isSequel);
        System.out.println("temp: " + temperature + " and  weather is " + weatherCondition );
        System.out.println("Gate Number: " + gateNumber + " and is Delayed: " + isDelayed);

        boolean hasHomework = true;
        boolean isWeekend = false;
        boolean attendedClass = true;

        // part 4
        System.out.println("Do I have homework? " + hasHomework);
        System.out.println("Is it the weekend? " + isWeekend);
        System.out.println("Did I attend class today? " + attendedClass);

        //part 5
        char firstInitial = 'R';
        char lastInitial = 'P';
        char favoriteGrade = 'A';

        System.out.printf("My first initial is %c and my last initial is %c. I always want to get an %c on my projects.", firstInitial, lastInitial, favoriteGrade);


    }
}