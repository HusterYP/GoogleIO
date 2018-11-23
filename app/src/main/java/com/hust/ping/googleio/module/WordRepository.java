package com.hust.ping.googleio.module;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.hust.ping.googleio.db.Word;
import com.hust.ping.googleio.db.WordDao;
import com.hust.ping.googleio.db.WordRoomDatabase;

import java.util.List;

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(android.app.Application application) {
        WordRoomDatabase helper = WordRoomDatabase.getDb();
        mWordDao = helper.wordDao();
        mAllWords = mWordDao.getWords();
    }

    public void insert(Word word) {
        new InsertAsync(mWordDao).execute(word);
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    private class InsertAsync extends AsyncTask<Word, Void, Void> {

        private WordDao mDao;

        public InsertAsync(WordDao dao) {
            mDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mDao.insert(words[0]);
            return null;
        }
    }
}
