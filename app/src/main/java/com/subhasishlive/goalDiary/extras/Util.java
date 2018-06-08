package com.subhasishlive.goalDiary.extras;

import android.view.View;
import java.util.List;
/**
 * Created by SubhasishNath on 6/8/2018.
 */

public class Util {
    public static void showViews(List<View> views){
        for (View view : views){
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views){
        for(View view : views){
            view.setVisibility(View.GONE);
        }

    }

}
