package com.hust.ping.googleio.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.hust.ping.googleio.Application;

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static RoomDatabase.Callback sCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(WordRoomDatabase.db).execute();
        }
    };

    private static WordRoomDatabase db = Room.databaseBuilder(Application.context,
            WordRoomDatabase.class, "word_database")
            .fallbackToDestructiveMigration()
            .addCallback(WordRoomDatabase.sCallback) // 提前添加几行新数据
            .build();

    public abstract WordDao wordDao();

    public static WordRoomDatabase getDb() {
        return db;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Word word = new Word("Hello");
            mDao.insert(word);
            word = new Word("World");
            mDao.insert(word);
            return null;
        }
    }
}
