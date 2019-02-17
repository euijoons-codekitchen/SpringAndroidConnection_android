package com.example.recyclerviewprj.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewprj.GlobalApplication;
import com.example.recyclerviewprj.R;
import com.example.recyclerviewprj.dto.Item;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.img_cardView)
    ImageView mImageView;
    @BindView(R.id.tv_cardView)
    TextView mTextView;
    @BindView(R.id.btn_cardView)
    Button removeButton;
    @BindView(R.id.btn_update)
    Button mUpdateBtn;
    @BindView(R.id.btn_toggle)
    Button mToggleButton;

    String TAG = MainViewHolder.class.getName();
    int index;
    boolean state;
    public MainViewHolder(View itemView, onItemBtnClicked listner) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        Log.d(TAG, "MainViewHolder: " + state);

        if(state)
            mTextView.setBackgroundColor(GlobalApplication.getGlobalApplicationContext().getResources().getColor(android.R.color.holo_blue_light));
        else
            mTextView.setBackgroundColor(GlobalApplication.getGlobalApplicationContext().getResources().getColor(android.R.color.holo_red_light));

        removeButton.setOnClickListener((v) ->{
            listner.btnRemove(index);
        });
        mUpdateBtn.setOnClickListener((v)->{
            listner.updateItem(index);

        });
        mToggleButton.setOnClickListener((v)->{
            listner.toggleItem(index);
        });

    }

    public void drawView(Item item){
        if(item.isCurrentState())
            mTextView.setBackgroundColor(GlobalApplication.getGlobalApplicationContext().getResources().getColor(android.R.color.holo_blue_light));
        else
            mTextView.setBackgroundColor(GlobalApplication.getGlobalApplicationContext().getResources().getColor(android.R.color.holo_red_light));

    }

}
