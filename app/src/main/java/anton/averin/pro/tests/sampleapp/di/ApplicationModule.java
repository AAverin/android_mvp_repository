package anton.averin.pro.tests.sampleapp.di;

import javax.inject.Singleton;

import anton.averin.pro.tests.sampleapp.BaseContext;
import anton.averin.pro.tests.sampleappdata.Repository;
import anton.averin.pro.tests.sampleappdata.RepositoryImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final BaseContext baseContext;

    public ApplicationModule(BaseContext baseContext) {
        this.baseContext = baseContext;
    }

    @Provides
    @Singleton
    BaseContext baseContext() {
        return this.baseContext;
    }

    @Provides
    @Singleton
    Repository repository(RepositoryImpl repository) {
        return repository;
    }
}
