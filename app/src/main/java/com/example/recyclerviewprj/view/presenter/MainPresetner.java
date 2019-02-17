package com.example.recyclerviewprj.view.presenter;

import android.util.Log;

import com.example.recyclerviewprj.dto.Item;
import com.example.recyclerviewprj.view.main.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainPresetner {

    MainView mainView;
    List<Item> items;
    String TAG = MainPresetner.class.getName();

    public MainPresetner(MainView mainView) {
        this.mainView = mainView;
        items = new ArrayList<>();
    }

    public void getListFromServer(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("hello","item1111"));
        items.add(new Item("hello","item2222"));
        items.add(new Item("hello","item3333"));
        items.add(new Item("hello","item4444"));
        this.items = items;
        mainView.updateList(items);
    }

    public void updateOneItem(int index){
        Item item = items.get(index);
        item.setItemDescription(item.getItemDescription()+"replaced");
        items.set(index,item);
        mainView.updateList(items);
    }
    public void removeOneItem(int index){
        items.remove(index);
        mainView.updateList(items);
    }

    public void toggleItemState(int index){

        Item item = items.get(index);
        Log.d(TAG, "toggleItemState: "+item.getItemDescription());
        item.setCurrentState(!item.isCurrentState());
        items.set(index,item);
        mainView.updateList(items);
    }


}

