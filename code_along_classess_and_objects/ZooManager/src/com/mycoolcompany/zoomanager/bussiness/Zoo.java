package com.mycoolcompany.zoomanager.bussiness;

public class Zoo {
    private String name;
    private Animal[] population;

    public Zoo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getPopulation() {
        return population;
    }

    public void setPopulation(Animal[] population) {
        this.population = population;
    }

    public void printPopulationReport(){
        System.out.println("Population Report: " + name  + "\n======================\n");

        for (int i = 0; i < population.length; i++){
            Animal a = population[i];
            System.out.println(a.getName() + " : " +
                    a.getPopulationCount());
        }
        System.out.println("======================");
    }

    public void printAnimalSounds() {
        System.out.println("The Sounds of: " + name + "\n======================\n");

        for (int i = 0; i < population.length; i++){
            Animal a = population[i];
            System.out.println(a.getSound());
        }
        System.out.println("======================");
    }
}
