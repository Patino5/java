public class Main {
    public static void main(String[] args) {
        TerminalUtils utils = new TerminalUtils();

        utils.print("Hello");
        utils.pressEnterToContinue();


        String artifactName = utils.getString("Enter Artifact Name: ");
        int yearOfDiscovery = Integer.parseInt(utils.getString("Enter year of Discovery: "));

        String discovererFirstName = utils.getString("Enter discoverer's first name: ");
        String discovererLastName = utils.getString("Enter discoverer's last name: ");
        String discoverersPrimarySpecialty = utils.getString("Enter discoverer's primary specialty: ");
        Person discoverer = new Person(discovererFirstName,discovererLastName, discoverersPrimarySpecialty);

        String discovererIsCurator = utils.getString("Is the discoverer also the curator? (y/n): ").trim();

        Person curator;

        if (discovererIsCurator.equalsIgnoreCase("y")) {
            curator = new Person(discovererFirstName, discovererLastName, discoverersPrimarySpecialty);
        } else {
            String curatorFirstName = utils.getString("Enter discoverer's first name: ");
            String curatorLastName = utils.getString("Enter discoverer's last name: ");
            String curatorPrimarySpecialty = utils.getString("Enter discoverer's primary specialty: ");
            curator = new Person(curatorFirstName, curatorLastName, curatorPrimarySpecialty);
        }


        Artifact arkOfTheCovenant = new Artifact(artifactName, yearOfDiscovery, discoverer, curator);

        utils.print(arkOfTheCovenant.toString());
        utils.print(discoverer.toString());
        utils.print(curator.toString());
    }
}
