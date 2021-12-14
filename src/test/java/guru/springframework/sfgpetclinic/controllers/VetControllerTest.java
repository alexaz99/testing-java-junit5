package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VetControllerTest {

    VetService vetService;

    @BeforeEach
    void setUp() {
        vetService = new VetMapService();
        //vetService = new VetMapService();
    }

    @Test
    void listVets() {
        Set<Vet> vets =  vetService.findAll();

        assertNotNull(vets);
        assertEquals(2, vets.size());

        Vet vet1 =  vetService.findById(1L);
        assertEquals("Bob", vet1.getFirstName());

    }
}