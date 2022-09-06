package com.example.Test.Repositoriy;

import com.example.Test.models.Nuwes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NuwesRepositoriy extends CrudRepository<Nuwes,Long> {
    public List<Nuwes> findByTitle(String title);
    public List<Nuwes> findByTitleContains(String title);
}
