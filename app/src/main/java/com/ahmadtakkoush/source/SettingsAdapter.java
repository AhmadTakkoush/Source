package com.ahmadtakkoush.source;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;



public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {
    private ArrayList<SettingsItem> mSettingsItem;

    public SettingsAdapter(ArrayList<SettingsItem>SettingsList){

        mSettingsItem = SettingsList;
    }

    public static class SettingsViewHolder extends ViewHolder{


        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public SettingsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
            mTextView1 = itemView.findViewById(R.id.textview);
            mTextView2 = itemView.findViewById(R.id.textview2);
        }


    }

    @NonNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_item,parent,false);
        SettingsViewHolder svh = new SettingsViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsViewHolder holder, int position) {

        SettingsItem currentItem = mSettingsItem.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mSettingsItem.size();
    }


}
