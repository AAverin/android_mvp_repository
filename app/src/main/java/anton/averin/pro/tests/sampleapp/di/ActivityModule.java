package anton.averin.pro.tests.sampleapp.di;

import anton.averin.pro.tests.sampleapp.views.base.BaseActivity;
import dagger.Module;

@Module
public class ActivityModule {

    private final BaseActivity baseActivity;

    public ActivityModule(BaseActivity activity) {
        this.baseActivity = activity;
    }
}
