package anton.averin.pro.tests.sampleapp.presenters;

public interface LoginView extends BaseView {
    String getEmailText();

    String getPasswordText();

    void onEmailValidationError();

    void onPasswordValidationError();
}
