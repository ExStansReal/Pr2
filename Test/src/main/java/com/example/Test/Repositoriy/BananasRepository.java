package com.example.Test.Repositoriy;

import com.example.Test.models.Bananas;
import com.example.Test.models.Nuwes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BananasRepository extends CrudRepository<Bananas,Long> {
    public List<Bananas> findByName(String name);
    public List<Bananas> findByNameContains(String name);
}