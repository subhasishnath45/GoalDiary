package com.subhasishlive.goalDiary.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.util.AttributeSet;
import android.view.View;

import com.subhasishlive.goalDiary.extras.Util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by SubhasishNath on 6/4/2018.
 */

public class GoalRecyclerView extends RecyclerView {

    // Collections.emptyList() uses type-inference and therefore returns List<T>
    // Returns the empty list (immutable).immutable means fixed
    // we initialize List<View> to Collections.emptyList(); because otherwise it will
    // give me a null Pointer exception....
    // mNonEmptyViews will be displayed, when the adapter is non-empty
    private List<View> mNonEmptyViews = Collections.emptyList();
    // mEmptyViews will be displayed, when the adapter is empty
    private List<View> mEmptyViews = Collections.emptyList();
    // creting an instance of adapter data observer.
    private AdapterDataObserver mObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            toggleViews();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            toggleViews();
        }
    };

    private void toggleViews() {
        // So we are checking for these 3 things in this if statement:
        // 1) a person must set an adapter...
        // 2) mEmptyViews must not bt empty...
        // 3) mNonEmptyViews must not bt empty...
        if(getAdapter() != null && !mEmptyViews.isEmpty() && !mNonEmptyViews.isEmpty()){
            if(getAdapter().getItemCount() == 0){// if no items
                // show all the empty views.
                Util.showViews(mEmptyViews);
                // hide the recycler view.
                setVisibility(View.GONE);
                //hide all the views which are meant to be hidden
                Util.hideViews(mNonEmptyViews);
            }else{
                // show all the non empty views.
                Util.showViews(mNonEmptyViews);
                // show the recycler view.
                setVisibility(View.VISIBLE);
                // hide all the empty views.
                Util.hideViews(mEmptyViews);
            }
        }
    }

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
        if(adapter != null){ // If adapter is not null,
            // Register a new observer to listen for data changes
            adapter.registerAdapterDataObserver(mObserver);
        }
        mObserver.onChanged();
    }
    // to hide something, if empty
    public void hideIfEmpty(View... views) {
        mNonEmptyViews = Arrays.asList(views);
    }

    public void showIfEmpty(View... emptyViews) {
        mEmptyViews = Arrays.asList(emptyViews);
    }
}
