package anton.averin.pro.tests.sampleapp;

import android.app.Application;

import anton.averin.pro.tests.sampleapp.di.ApplicationComponent;
import anton.averin.pro.tests.sampleapp.di.ApplicationModule;
import anton.averin.pro.tests.sampleapp.di.DaggerApplicationComponent;

public class BaseContext extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
