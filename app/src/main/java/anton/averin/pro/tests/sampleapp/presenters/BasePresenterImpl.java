package anton.averin.pro.tests.sampleapp.presenters;

import javax.inject.Inject;

import anton.averin.pro.tests.sampleapp.BaseContext;

public class BasePresenterImpl<B extends BaseView> implements BasePresenter<B> {

    protected final BaseContext baseContext;
    protected B view = null;
    protected boolean isVisible;

    @Inject
    public BasePresenterImpl(BaseContext baseContext) {
        this.baseContext = baseContext;
    }

    @Override
    public void setView(B view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        isVisible = false;
        //to add behaviour on onCreate, override this method
    }

    @Override
    public void onResume() {
        //to add behaviour on onResume, override this method
    }

    @Override
    public void onPause() {
        //to add behaviour on onPause, override this method
    }

    @Override
    public void onDestroy() {
        //to add behaviour on onDestroy, override this method
    }
}
