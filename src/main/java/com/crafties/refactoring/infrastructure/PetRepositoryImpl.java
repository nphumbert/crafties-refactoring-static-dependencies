package com.crafties.refactoring.infrastructure;

import com.crafties.refactoring.model.Pet;
import com.crafties.refactoring.model.PetRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PetRepositoryImpl implements PetRepository {

    private static PetRepository instance;

    public static PetRepository getInstance() {
        if (instance == null) {
            instance = new PetRepositoryImpl();
        }
        return instance;
    }

    private final Map<String, Pet> pets = new HashMap<>();

    @Override
    public Optional<Pet> findByName(String name) {
        return Optional.ofNullable(pets.get(name));
    }

    @Override
    public void create(Pet pet) {
        pets.put(pet.getName(), pet);
    }
}
