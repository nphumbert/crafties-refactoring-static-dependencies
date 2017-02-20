package com.crafties.refactoring.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class PetServiceImplTest {

    @Test
    public void should_create_pet_when_not_already_existing() {
        // given
        PetRepository petRepository = Mockito.mock(PetRepository.class);
        when(petRepository.findByName("Berlioz")).thenReturn(Optional.empty());
        PetService petService = new TestablePetServiceImpl(petRepository);

        // when
        Pet berlioz = petService.create("Berlioz", PetType.CAT);

        // then
        assertThat(berlioz.getName()).isEqualTo("Berlioz");
    }

    @Test(expected = IllegalStateException.class)
    public void should_not_allow_creation_of_pet_when_pet_with_same_name_already_exists() {
        // given
        PetRepository petRepository = Mockito.mock(PetRepository.class);
        when(petRepository.findByName("Berlioz")).thenReturn(Optional.of(new Pet("Berlioz", PetType.CAT)));
        PetService petService = new TestablePetServiceImpl(petRepository);

        // when
        petService.create("Berlioz", PetType.CAT);
    }

    private class TestablePetServiceImpl extends PetServiceImpl {

        private TestablePetServiceImpl(PetRepository petRepository) {
            super(petRepository);
        }
    }
}