package com.bw.movie.green.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bw.movie.green.bean.FenLei1;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FEN_LEI1".
*/
public class FenLei1Dao extends AbstractDao<FenLei1, Long> {

    public static final String TABLENAME = "FEN_LEI1";

    /**
     * Properties of entity FenLei1.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property RegionId = new Property(1, int.class, "regionId", false, "REGION_ID");
        public final static Property RegionName = new Property(2, String.class, "regionName", false, "REGION_NAME");
    }


    public FenLei1Dao(DaoConfig config) {
        super(config);
    }
    
    public FenLei1Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FEN_LEI1\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"REGION_ID\" INTEGER NOT NULL ," + // 1: regionId
                "\"REGION_NAME\" TEXT);"); // 2: regionName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FEN_LEI1\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, FenLei1 entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getRegionId());
 
        String regionName = entity.getRegionName();
        if (regionName != null) {
            stmt.bindString(3, regionName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, FenLei1 entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getRegionId());
 
        String regionName = entity.getRegionName();
        if (regionName != null) {
            stmt.bindString(3, regionName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public FenLei1 readEntity(Cursor cursor, int offset) {
        FenLei1 entity = new FenLei1( //
            cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // regionId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // regionName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, FenLei1 entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setRegionId(cursor.getInt(offset + 1));
        entity.setRegionName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(FenLei1 entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(FenLei1 entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(FenLei1 entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
