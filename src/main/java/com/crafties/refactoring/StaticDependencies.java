package com.crafties.refactoring;

import com.crafties.refactoring.model.Pet;
import com.crafties.refactoring.model.PetServiceImpl;
import com.crafties.refactoring.model.PetType;

public class StaticDependencies {

    public static void main(String[] args) {
        PetServiceImpl petService = new PetServiceImpl();
        Pet pet = petService.create("Berlioz", PetType.CAT);
        System.out.println(pet);
        // this should throw an exception
        petService.create("Berlioz", PetType.CAT);
    }
}
