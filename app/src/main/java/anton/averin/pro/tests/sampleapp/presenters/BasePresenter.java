package anton.averin.pro.tests.sampleapp.presenters;

public interface BasePresenter<B extends BaseView> {

    void setView(B view);

    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
