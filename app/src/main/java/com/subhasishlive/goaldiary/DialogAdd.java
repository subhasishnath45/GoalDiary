package com.subhasishlive.goaldiary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.subhasishlive.goaldiary.beans.Goal;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by SubhasishNath on 4/24/2018.
 */

public class DialogAdd extends DialogFragment {

    private ImageButton mBtnClose;
    private EditText mInputWhat;
    private DatePicker mInputWhen;
    private Button mBtnAdd;

    public DialogAdd() {

    }
    private View.OnClickListener mBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.btn_add_it:
                    addAction();//udf is called...
                    break;
            }
            dismiss(); // Dismiss the fragment and its dialog.
        }
    };
    // TODO process date
    private void addAction() {

        // getting the input given in the edittext and convert the input to string...
        String what = mInputWhat.getText().toString();
        long now = System.currentTimeMillis();// current time in milliseconds
        // creating configuration object...
        Realm.init(this.getContext());
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        // setting the configuration object as default configuration object...
        Realm.setDefaultConfiguration(realmConfig);
        Realm realm = Realm.getDefaultInstance();// Returns the default configuration for getDefaultInstance().
        Goal goal = new Goal(what,now,0,false);// creating new Goal object
        // with parameterized constructor.
        realm.beginTransaction();
        realm.copyToRealm(goal);// Copies a RealmObject to the Realm instance and returns the copy.
        realm.commitTransaction();// When the event is received, the other Realms will update their
        // objects and RealmResults to reflect the changes from this commit.
        realm.close();// Closes the Realm instance and all its resources.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.dialog_add, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInputWhat = (EditText) view.findViewById(R.id.et_goal);
        mBtnClose = (ImageButton) view.findViewById(R.id.btn_close);
        mInputWhen = (DatePicker) view.findViewById(R.id.dpv_date);
        mBtnAdd = (Button) view.findViewById(R.id.btn_add_it);

        mBtnClose.setOnClickListener(mBtnListener);
        mBtnAdd.setOnClickListener(mBtnListener);
    }
}
