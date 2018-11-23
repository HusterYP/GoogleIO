package com.hust.ping.googleio.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
@Dao
public interface WordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>>getWords();

    @Insert
    void insert(Word word);

    @Query("DELETE from word_table")
    void deleteAll();
}
