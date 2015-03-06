package com.kuehlschrankapp.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by laj on 16.02.2015.
 * AbstractDao
 * Stellt Standardmethoden der DAOs bereit
 */
public abstract class AbstractDao<T> extends AbstractDatabaseOpenHelper implements  IDao<T> {

    private final Class<T> clazz;

    public AbstractDao(Context context, Class<T> clazz) {
        super(context);
        this.clazz = clazz;
    }

    public final T findById(int id) {
        final RuntimeExceptionDao<T, Integer> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        final T entity = runtimeExceptionDao.queryForId(id);
        return entity;
    }


    @Override
    public int insert(T table2Insert) {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        return runtimeExceptionDao.create(table2Insert);
    }

    @Override
    public int update(T table2Update) {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        return runtimeExceptionDao.update(table2Update);
    }

    @Override
    public int delete(T table2Delete) {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        return runtimeExceptionDao.delete(table2Delete);
    }

    @Override
    public void update(List<T> list2Update) {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        for (T entry : list2Update) {
            runtimeExceptionDao.update(entry);
        }
    }

    @Override
    public List<T> getAllEntriesAsList() {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        return runtimeExceptionDao.queryForAll();
    }

    @Override
    public List<T> getListForPreparedQuery(PreparedQuery<T> preparedQuery) {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        return runtimeExceptionDao.query(preparedQuery);
    }

    public final QueryBuilder<T, ?> getQueryBuilder() {
        try {
            return DaoManager.createDao(getConnectionSource(), clazz).queryBuilder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected final List<T> getAllEntriesAsListWhereEq(String fieldName, Object value) {
        final RuntimeExceptionDao<T, ?> runtimeExceptionDao = getRuntimeExceptionDao(clazz);
        return runtimeExceptionDao.queryForEq(fieldName, value);
    }
}
