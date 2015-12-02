package anton.averin.pro.tests.sampleapp.di;

import javax.inject.Singleton;

import anton.averin.pro.tests.sampleapp.presenters.LoginPresenterImpl;
import anton.averin.pro.tests.sampleapp.utils.LLogger;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent extends ApplicationInjectsTo {

    LoginPresenterImpl loginPresenter();

    LLogger llogger();
}
