package anton.averin.pro.tests.sampleapp.presenters;

import javax.inject.Inject;
import javax.inject.Singleton;

import anton.averin.pro.tests.sampleapp.BaseContext;
import anton.averin.pro.tests.sampleapp.utils.LLogger;
import anton.averin.pro.tests.sampleapp.utils.TextTools;
import anton.averin.pro.tests.sampleappdata.Repository;


@Singleton
public class LoginPresenterImpl extends BasePresenterImpl<LoginView> {

    @Inject
    LLogger llogger;
    @Inject
    Repository repository;
    @Inject
    TextTools textTools;

    @Inject
    public LoginPresenterImpl(BaseContext baseContext) {
        super(baseContext);
    }

    private void login(String email, String password) {
        repository.login(email, password);
    }

    public void onLoginClicked() {
        llogger.log_e(this, "onLoginClicked");
        if (validate()) {
            String email = view.getEmailText();
            String password = view.getPasswordText();
            login(email, password);
        }
    }

    private boolean validate() {
        boolean validated = true;
        if (!textTools.isValidEmail(view.getEmailText())) {
            validated = false;
            view.onEmailValidationError();
        }
        if (validated && textTools.isEmpty(view.getPasswordText())) {
            validated = false;
            view.onPasswordValidationError();
        }
        return validated;
    }
}
