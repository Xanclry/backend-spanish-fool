package com.rekish.backendspanishfool.service;

import java.io.Serializable;
import java.util.Collection;

public interface ReadWriteService<K extends Serializable, T> extends ReadOnlyService<K, T> {
    void persist(T entity);

    void persistAll(T... entities);

    void persistAll(Collection<T> entities);

    T update(T e);

    void delete(K id);

    void delete(T entity);

    void deleteAll(Collection<T> entities);
}
