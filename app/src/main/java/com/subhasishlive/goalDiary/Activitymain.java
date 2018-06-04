package com.subhasishlive.goalDiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.subhasishlive.goalDiary.adapters.AdapterGoals;
import com.subhasishlive.goalDiary.beans.Goal;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class Activitymain extends AppCompatActivity {

    private static final String TAG = "Subhasish" ;
    Toolbar mToolbar;
    Button mBtnAdd;
    RecyclerView mRecycler;// variable of type recyclerview...
    Realm mRealm;
    RealmResults<Goal> mResults;
    AdapterGoals mAdapter;
    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.dialog_add, null);
            showDialogAdd();
            //Toast.makeText(Activitymain.this, "Button was clicked", Toast.LENGTH_SHORT).show();
        }
    };

    private RealmChangeListener mChangeListener = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {
            Log.d(TAG, "onChange: was called");
            mAdapter.update(mResults);
        }
    };

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();
        dialog.show(getSupportFragmentManager(),"Add");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getDefaultInstance();
        /**
         * RealmResults is a special typer of array list.
         * which is capable of managing data from realm database...
         */
        RealmResults<Goal> results = mRealm.where(Goal.class).findAllAsync();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mRecycler = (RecyclerView) findViewById(R.id.rv_goals);
        // setting up layout manager for mRecycler RecyclerView....
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);
        // now I have set adapter on recycler view...
        // by calling setAdapter method.
        // passing new instance of my adapter class as argument.
        // and while instanciating the adapter class, passing this present context
        // as argument....
        mRecycler.setAdapter(new AdapterGoals(this,results));
        mBtnAdd.setOnClickListener(mBtnAddListener);
        setSupportActionBar(mToolbar);
        initBackgroundImage();
    }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this).load(R.drawable.background_app).into(background);
    }

}

