package com.kuehlschrankapp.db.dao;

import com.j256.ormlite.stmt.PreparedQuery;

import java.util.List;

/**
 * Created by laj on 16.02.2015.
 * Interface für die DAOs
 */
public interface IDao<T> {

    int insert(T table2Insert);

    int update(T table2Update);

    int delete(T table2Delete);

    void update(List<T> list2Update);

    List<T> getAllEntrysAsList();

    List<T> getListForPreparedQuery(PreparedQuery<T> preparedQuery);
}
