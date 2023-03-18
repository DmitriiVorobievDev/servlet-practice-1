package com.dvdev.http.mvc.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, T> { //K-key(id), T-entity

    List<T> findAll();

    Optional<T> findById(K id);

    boolean delete(K id); //узнать, удалена ли сущность или нет

    void update(T entity); //передаем сущность и полностью обновляем ее

    T save(T entity); //возвращает сущность, к-ю сохранили
}
