package com.subhasishlive.goalDiary.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by SubhasishNath on 6/4/2018.
 */

public class GoalRecyclerView extends RecyclerView {

    // creting an instance of adapter data observer.
    private AdapterDataObserver mObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {

        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {

        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {

        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {

        }
    };

    // this constructor is used to initialize recyclerview from code.
    public GoalRecyclerView(Context context) {
        super(context);
    }
    // this constructor is used to initialize recyclerview from xml.
    public GoalRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    // this constructor is used to initialize recyclerview from xml.
    // int defStyle lets me to define custom style, based on which, the constructor works.
    public GoalRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter != null){
            adapter.registerAdapterDataObserver(mObserver);
        }
        mObserver.onChanged();
    }
}
