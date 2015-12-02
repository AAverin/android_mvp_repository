package anton.averin.pro.tests.sampleapp.views.base;

import anton.averin.pro.tests.sampleapp.presenters.BasePresenterImpl;
import anton.averin.pro.tests.sampleapp.presenters.BaseView;

public class BaseViewPresenterActivity<P extends BasePresenterImpl> extends BaseActivity implements BaseView {

    private P presenter;

    protected void initializePresenter(P presenter, BaseView baseView) {
        this.presenter = presenter;
        presenter.setView(baseView);
        presenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
