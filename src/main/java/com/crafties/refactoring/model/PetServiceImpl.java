package com.crafties.refactoring.model;

import com.crafties.refactoring.infrastructure.PetRepositoryImpl;

public class PetServiceImpl implements PetService {

    @Override
    public Pet create(String name, PetType type) {
        PetRepositoryImpl.getInstance().findByName(name).ifPresent(pet -> {
            throw new IllegalStateException(String.format("A pet named %s already exists.", name));
        });

        Pet pet = new Pet(name, type);
        PetRepositoryImpl.getInstance().create(pet);
        return pet;
    }
}
