package io.github.demony.forestparktextgame.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> {
    T get(Long id) throws SQLException;
    List<T> getAll() throws SQLException;
    T update(Long id);
    T create(T element) throws SQLException;
    T delete(Long id);
}
