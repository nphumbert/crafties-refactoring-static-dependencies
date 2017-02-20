package com.crafties.refactoring.model;

import com.crafties.refactoring.infrastructure.PetRepositoryImpl;

public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    /**
     * @deprecated Use constructor with dependency injection instead.
     */
    @Deprecated
    public PetServiceImpl() {
        this(PetRepositoryImpl.getInstance());
    }

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Pet create(String name, PetType type) {
        petRepository.findByName(name).ifPresent(pet -> {
            throw new IllegalStateException(String.format("A pet named %s already exists.", name));
        });

        Pet pet = new Pet(name, type);
        petRepository.create(pet);
        return pet;
    }

}
