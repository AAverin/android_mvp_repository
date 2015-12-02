package anton.averin.pro.tests.sampleapp.di;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent extends ActivityInjectsTo {
}
