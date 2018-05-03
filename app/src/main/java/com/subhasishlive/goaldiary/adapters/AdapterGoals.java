package com.subhasishlive.goaldiary.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subhasishlive.goaldiary.R;

import java.util.ArrayList;

/**
 * Created by SubhasishNath on 5/3/2018.
 */

public class AdapterGoals extends RecyclerView.Adapter<AdapterGoals.GoalHolder>{
    private LayoutInflater mInflater;
    private ArrayList<String> mItems;
    public AdapterGoals(Context context){
        mInflater = LayoutInflater.from(context);
        mItems = generateValues();
    }
    public static ArrayList<String> generateValues(){
        ArrayList<String> dummyValues = new ArrayList<>();
        for (int i=1;i<101;i++){
            dummyValues.add("ITEM NO"+i);
        }
        return dummyValues;
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    // this method returns RecyclerView.ViewHolder
    @Override
    public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = mInflater.inflate(R.layout.row_goals,parent,false);
        GoalHolder holder = new GoalHolder(view);
        return holder;
    }
    // the returned RecyclerView.ViewHolder from onCreateViewHolder() method is
    // passed as parameter in onBindViewHolder() class...
    @Override
    public void onBindViewHolder(GoalHolder holder, int position) {
        holder.mTextWhat.setText(mItems.get(position));
    }

    // creating custom class
    public static class GoalHolder extends RecyclerView.ViewHolder{
        // parameterized constructor, that takes a View as argument...
        TextView mTextWhat;
        public GoalHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }

}
