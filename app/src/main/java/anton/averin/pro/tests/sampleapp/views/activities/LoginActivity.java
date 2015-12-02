package anton.averin.pro.tests.sampleapp.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import anton.averin.pro.tests.sampleapp.R;
import anton.averin.pro.tests.sampleapp.presenters.LoginPresenterImpl;
import anton.averin.pro.tests.sampleapp.presenters.LoginView;
import anton.averin.pro.tests.sampleapp.views.base.BaseViewPresenterActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseViewPresenterActivity<LoginPresenterImpl> implements LoginView {

    @Inject
    LoginPresenterImpl presenter;

    @Bind(R.id.login_button)
    Button loginButton;
    @Bind(R.id.login_email)
    EditText loginEmail;
    @Bind(R.id.login_password)
    EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().injectTo(this);
        initializePresenter(presenter, this);

        setContentView(R.layout.login);
        ButterKnife.bind(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLoginClicked();
            }
        });
    }

    @Override
    public String getEmailText() {
        return loginEmail.getText().toString();
    }

    @Override
    public String getPasswordText() {
        return loginPassword.getText().toString();
    }

    @Override
    public void onEmailValidationError() {
        loginEmail.requestFocus();
        loginEmail.setError(getString(R.string.error_login_email));
    }

    @Override
    public void onPasswordValidationError() {
        loginPassword.requestFocus();
        loginPassword.setError(getString(R.string.error_login_password));
    }
}
