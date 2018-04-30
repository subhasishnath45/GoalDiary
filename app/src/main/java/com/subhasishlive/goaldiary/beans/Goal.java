package com.subhasishlive.goaldiary.beans;

/**
 * Created by SubhasishNath on 4/30/2018.
 */

public class Goal {
    private String what;
    private long added;
    private long when;
    private boolean completed;

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
