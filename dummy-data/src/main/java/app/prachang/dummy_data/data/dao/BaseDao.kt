package app.prachang.dummy_data.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

abstract class BaseDao<T> {
    @Insert(onConflict = REPLACE)
    abstract suspend fun insert(value: T)

    @Insert(onConflict = REPLACE)
    abstract suspend fun insert(values: List<T>)

    @Update(onConflict = REPLACE)
    abstract suspend fun update(value: T)

    @Delete
    abstract suspend fun delete(value: T)
}