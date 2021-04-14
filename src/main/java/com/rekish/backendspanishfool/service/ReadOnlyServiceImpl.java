package com.rekish.backendspanishfool.service;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public abstract class ReadOnlyServiceImpl<K extends Serializable, T> implements ReadOnlyService<K, T> {

    protected final CrudRepository<T, K> crudRepository;

    @Override
    public Optional<T> getByKey(K id) {
        return crudRepository.findById(id);
    }

    @Override
    public Iterable<T> getAll() {
        return crudRepository.findAll();
    }

    @Override
    public boolean isExistById(K id) {
        return crudRepository.existsById(id);
    }

    @Override
    public boolean isExistAllByIds(K[] ids) {
        return Arrays.stream(ids).allMatch(crudRepository::existsById);
    }

    @Override
    public Iterable<T> getAllByIds(Iterable<K> ids) {
        return crudRepository.findAllById(ids);
    }
}
