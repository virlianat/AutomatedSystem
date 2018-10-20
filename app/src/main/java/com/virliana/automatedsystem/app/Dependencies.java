package com.virliana.automatedsystem.app;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

public final class Dependencies {

    public static AppComponent fromApplication(Context context) {
        return ((AutomatedSystem) context.getApplicationContext()).getAppComponent();
    }

    @NonNull
    public static <C, A extends Activity & HasDependencies<C>> C fromAttachedActivity(Fragment f, Class<A> type) {
        A activity = type.cast(f.getActivity());
        if (activity == null) {
            throw new RuntimeException("fragment's activity isn't " + type.toString());
        }
        return activity.getDependencies();
    }

}


