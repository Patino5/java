package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        SpellBook spellBook = new SpellBook();

        do {
            System.out.print("Recite a spell: ");
            String incantation = scanner.nextLine();
            spellBook.tryIncantation(incantation);

        } while(true);
    }
}
