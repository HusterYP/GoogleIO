package com.hust.ping.googleio.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hust.ping.googleio.R;
import com.hust.ping.googleio.db.Word;

import java.util.List;

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Word> mWords;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (mWords != null) {
            viewHolder.mTextView.setText(mWords.get(i).getWord());
        } else {
            viewHolder.mTextView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        return mWords == null ? 0 : mWords.size();
    }

    public void setWords(List<Word> words) {
        this.mWords = words;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_text);
        }
    }
}
