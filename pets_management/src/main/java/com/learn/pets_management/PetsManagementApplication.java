package com.learn.pets_management;

import com.learn.pets_management.data.PetRepository;
import com.learn.pets_management.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class PetsManagementApplication implements CommandLineRunner {
	@Autowired
	private PetRepository petRepo;
	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(PetsManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getAll();
		//add();
		//update();
		//getAll();
		//delete();

	}

	private void getAll() {
		List<Pet> pets = petRepo.getAll();

		pets.stream().forEach(p -> {
			System.out.printf("ID: %d%n", p.getPetID());
			System.out.printf("Name: %s%n", p.getName());
			System.out.printf("Type: %s%n%n", p.getType());
		});
	}

	private void add() {
		Pet pet = new Pet();

		System.out.print("Enter pet's name: ");
		pet.setName(scanner.nextLine());

		System.out.print("Enter pet type: ");
		pet.setType(scanner.nextLine());

		pet = petRepo.add(pet);
		System.out.printf("Pet with id: %d was created.%n", pet.getPetID());
	}

	private void update() {
		Pet updated = new Pet();
		String input;
		System.out.print("Enter Pet ID: ");
		updated.setPetID(Integer.parseInt(scanner.nextLine()));

		Optional<Pet> existing = petRepo.getById(updated.getPetID());

		if (existing.isPresent()){
			System.out.println("Leave blank if unchanged!");

			System.out.printf("Enter Name (%s): ", existing.get().getName());
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				updated.setName(input);
			} else {
				updated.setName(existing.get().getName());
			}

			System.out.printf("Enter type (%s): ", existing.get().getType());
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				updated.setType(input);
			} else {
				updated.setType(existing.get().getType());
			}

			if(petRepo.update(updated)) System.out.printf("Pet with id: %d was updated!%n", updated.getPetID());

		}
	}

	private void delete() {
		System.out.print("Enter Pet ID: ");
		int id = Integer.parseInt(scanner.nextLine());

		if (petRepo.deleteById(id)) {
			System.out.println("Pet deleted.");
		} else {
			System.out.println("Pet not found.");
		}
	}
}
