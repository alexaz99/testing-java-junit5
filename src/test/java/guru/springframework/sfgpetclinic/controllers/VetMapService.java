package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VetMapService implements VetService {

    private Map<Long, Vet> vets = new HashMap();

    public VetMapService() {
        //Set<Vet> set = new HashSet();

        // Long id, String firstName, String lastName, Set<Speciality> specialities
        Vet vet1 = new Vet(1L, "Bob", "Doctor", null);
        vets.put(vet1.getId(), vet1);

        Vet vet2 = new Vet(2L, "Nick", "Nurse", null);
        vets.put(vet2.getId(), vet2);
    }

    @Override
    public Set<Vet> findAll() {
        return vets.values().stream().collect(Collectors.toSet());
    }

    @Override
    public Vet findById(Long aLong) {
        return vets.get(aLong);
    }

    @Override
    public Vet save(Vet object) {
        //Vet vet2 = new Vet(2L, "Nick", "Nurse", null);
        //set.add(vet2);

        vets.put(object.getId(), object);
        return object;
    }

    @Override
    public void delete(Vet object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
