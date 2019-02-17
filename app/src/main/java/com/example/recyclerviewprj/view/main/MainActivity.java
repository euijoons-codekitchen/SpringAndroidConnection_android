package com.example.recyclerviewprj.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.recyclerviewprj.view.adapter.MainViewRecyclerAdapter;
import com.example.recyclerviewprj.R;
import com.example.recyclerviewprj.dto.Item;
import com.example.recyclerviewprj.view.adapter.onItemBtnClicked;
import com.example.recyclerviewprj.view.presenter.MainPresetner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{


    @BindView(R.id.recycler_main)
    RecyclerView mRecyclerView;
    @BindView(R.id.btn_mainView)
    Button mUpdateButton;

    MainViewRecyclerAdapter adapter;
    MainPresetner mainPresetner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresetner = new MainPresetner(this);



        adapter = new MainViewRecyclerAdapter(new onItemBtnClicked() {
            @Override
            public void btnRemove(int index) {
                mainPresetner.removeOneItem(index);
            }

            @Override
            public void updateItem(int index) {
                mainPresetner.updateOneItem(index);
            }

            @Override
            public void toggleItem(int index) {
                mainPresetner.toggleItemState(index);
            }
        });
        mainPresetner.getListFromServer();
        mRecyclerView.setAdapter(adapter);
        mUpdateButton.setOnClickListener((v)->{
            mainPresetner.getListFromServer();

        });

    }

    @Override
    public void updateList(List<Item> list) {
        adapter.setLists(list);
    }

}
