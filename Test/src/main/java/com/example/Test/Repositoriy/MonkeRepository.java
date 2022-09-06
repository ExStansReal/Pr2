package com.example.Test.Repositoriy;

import com.example.Test.models.Bananas;
import com.example.Test.models.Monke;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonkeRepository extends CrudRepository<Monke,Long> {
    public List<Monke> findByName(String name);
    public List<Monke> findByNameContains(String name);
}