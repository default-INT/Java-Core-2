package by.gstu.models.dao;

import by.gstu.models.entities.Account;

import java.util.Collection;

public interface AccountDAO<T extends Account> {
    boolean create(T account);
    T read(int id);
    Collection<T> readAll();
    boolean update(T account);
    boolean delete(int id);
}
