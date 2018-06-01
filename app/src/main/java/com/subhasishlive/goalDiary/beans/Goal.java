package com.subhasishlive.goalDiary.beans;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SubhasishNath on 4/30/2018.
 */
// converted my class to realm database...
public class Goal extends RealmObject {
    private String what;
    @PrimaryKey
    private long added;
    private long when;
    private boolean completed;

    // default constructor...
    public Goal() {

    }

    // parameterized constructor...
    public Goal(String what, long added, long when, boolean completed) {
        this.what = what;
        this.added = added;
        this.when = when;
        this.completed = completed;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
