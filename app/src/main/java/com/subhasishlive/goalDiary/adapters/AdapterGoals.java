package com.subhasishlive.goalDiary.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subhasishlive.goalDiary.R;
import com.subhasishlive.goalDiary.beans.Goal;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by SubhasishNath on 5/3/2018.
 */

public class AdapterGoals extends RecyclerView.Adapter<AdapterGoals.GoalHolder>{
    private LayoutInflater mInflater;
    // creating RealmResult array type instance variable,
    // that can hold Goal type RealmObjects...
    private RealmResults<Goal> mReasults;
    public static final String TAG = "SUBHASISH";
    public AdapterGoals(Context context,RealmResults<Goal> results){// Inside parameterized constructor,
        mInflater = LayoutInflater.from(context);
        //mReasults = results;
        update(results);
    }

    @Override
    public int getItemCount() {
        return mReasults.size();
    }

    // this method returns RecyclerView.ViewHolder
    @Override
    public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = mInflater.inflate(R.layout.row_goals,parent,false);
        GoalHolder holder = new GoalHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        return holder;
    }
    // the returned RecyclerView.ViewHolder from onCreateViewHolder() method is
    // passed as parameter in onBindViewHolder() class...
    @Override
    public void onBindViewHolder(GoalHolder holder, int position) {
        Goal goal = mReasults.get(position);
        holder.mTextWhat.setText(goal.getWhat());
        Log.d(TAG, "onBindViewHolder: "+ position);
    }
    // created the public method update,which takes a RealmResults type array...
    public void update(RealmResults<Goal> results) {
        mReasults = results;
        // TODO not updating the list after adding new goal...from video (067 show data inside adapter...)
        this.notifyDataSetChanged();
    }


    // creating custom class
    public static class GoalHolder extends RecyclerView.ViewHolder{
        TextView mTextWhat;
        // parameterized constructor, that takes a View as argument...
        public GoalHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }



}
