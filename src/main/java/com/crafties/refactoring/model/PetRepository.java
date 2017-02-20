package com.crafties.refactoring.model;

import com.crafties.refactoring.model.Pet;

import java.util.Optional;

public interface PetRepository {

    Optional<Pet> findByName(String name);

    void create(Pet pet);
}
