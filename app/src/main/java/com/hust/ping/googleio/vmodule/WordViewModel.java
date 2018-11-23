package com.hust.ping.googleio.vmodule;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.hust.ping.googleio.db.Word;
import com.hust.ping.googleio.module.WordRepository;

import java.util.List;

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRespository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRespository = new WordRepository(application);
        mAllWords = mWordRespository.getAllWords();
    }

    public void insert(Word word) {
        mWordRespository.insert(word);
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

}
