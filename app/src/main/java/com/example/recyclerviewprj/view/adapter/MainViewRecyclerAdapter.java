package com.example.recyclerviewprj.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewprj.R;
import com.example.recyclerviewprj.dto.Item;
import com.example.recyclerviewprj.view.presenter.MainPresetner;

import java.util.List;

public class MainViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    String TAG = MainViewRecyclerAdapter.class.getName();
    private List<Item> mItems;


    private onItemBtnClicked listner;


    public void setLists(List<Item> lists){
        this.mItems = lists;
        notifyDataSetChanged();
    }


    public MainViewRecyclerAdapter(onItemBtnClicked listner) {

        this.listner = listner;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cardview,parent,false);

        return new MainViewHolder(v,listner);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+mItems.get(position).getItemDescription());
        Log.d(TAG, "onBindViewHolder: "+mItems.get(position).isCurrentState());
        MainViewHolder mainViewHolder = (MainViewHolder) holder;
        mainViewHolder.mImageView.setImageResource(R.drawable.ic_launcher_foreground);
        mainViewHolder.mTextView.setText(mItems.get(position).getItemDescription());
        mainViewHolder.index = position;
        mainViewHolder.state = mItems.get(position).isCurrentState();
        mainViewHolder.drawView(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


}
