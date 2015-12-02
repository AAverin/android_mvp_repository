package anton.averin.pro.tests.sampleapp.views.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import anton.averin.pro.tests.sampleapp.BaseContext;
import anton.averin.pro.tests.sampleapp.di.ActivityComponent;
import anton.averin.pro.tests.sampleapp.di.ActivityModule;
import anton.averin.pro.tests.sampleapp.di.DaggerActivityComponent;
import anton.averin.pro.tests.sampleapp.di.HasComponent;

public class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    protected BaseContext baseContext;
    private ActivityComponent activityComponent;

    @Override
    public ActivityComponent getComponent() {
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseContext = (BaseContext) getApplicationContext();

        baseContext.getApplicationComponent().injectTo(this);


        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(baseContext.getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
}
