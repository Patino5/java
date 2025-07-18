package com.learn.pets_management.data;

import com.learn.pets_management.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    List<Pet> getAll();
    Optional<Pet> getById(int pet_id);
    Pet add(Pet pet);
    boolean update(Pet pet);
    boolean deleteById(int petID);
}
