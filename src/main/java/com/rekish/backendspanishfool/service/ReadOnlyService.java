package com.rekish.backendspanishfool.service;

import java.io.Serializable;
import java.util.Optional;

public interface ReadOnlyService<K extends Serializable, T> {

    Optional<T> getByKey(K id);

    Iterable<T> getAll();

    boolean isExistById(K id);

    boolean isExistAllByIds(K[] ids);

    Iterable<T> getAllByIds(Iterable<K> ids);
}