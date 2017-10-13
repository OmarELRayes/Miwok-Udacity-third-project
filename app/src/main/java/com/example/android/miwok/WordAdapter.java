package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LeGenÐ on 9/29/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> words ,int colorResourceId ) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord = getItem(position);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        RelativeLayout container = (RelativeLayout) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        container.setBackgroundColor(color);
        TextView defaultText = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultText.setText(currentWord.getDefaultTranslation());
        TextView miwokText = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokText.setText(currentWord.getMiwokTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageRecourseID());
            image.setVisibility(View.VISIBLE);
        }
        else
            image.setVisibility(View.GONE);
        return listItemView;
    }
}
