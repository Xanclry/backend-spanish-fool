package com.rekish.backendspanishfool.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public abstract class ReadWriteServiceImpl<K extends Serializable, T> extends ReadOnlyServiceImpl<K, T> implements ReadWriteService<K, T> {
    protected ReadWriteServiceImpl(CrudRepository<T, K> crudRepository) {
        super(crudRepository);
    }

    @Override
    public void persist(T entity) {
        crudRepository.save(entity);
    }

    @SafeVarargs
    @Override
    public final void persistAll(T... entities) {
        Arrays.stream(entities).forEach(crudRepository::save);
    }

    @Override
    public void persistAll(Collection<T> entities) {
        crudRepository.saveAll(entities);
    }

    @Override
    public T update(T e) {
        return crudRepository.save(e);
    }

    @Override
    public void delete(K id) {
        crudRepository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        crudRepository.delete(entity);
    }

    @Override
    public void deleteAll(Collection<T> entities) {
        crudRepository.deleteAll(entities);
    }
}
