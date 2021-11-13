package com.sample.factory.repo.lookup;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ReadOnlyRepo<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

}
