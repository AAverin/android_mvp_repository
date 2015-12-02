package anton.averin.pro.tests.sampleapp.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import anton.averin.pro.tests.sampleapp.BaseContext;
import anton.averin.pro.tests.sampleapp.utils.LLogger;
import anton.averin.pro.tests.sampleapp.utils.TextTools;
import anton.averin.pro.tests.sampleappdata.Repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterImplTest {

    private static final String EMAIL = "test@email.com";
    private static final String PASSWORD = "testpassword";

    @Mock
    BaseContext baseContext;

    @Mock
    LLogger llogger;
    @Mock
    Repository repository;
    @Mock
    TextTools textTools;

    @Mock
    LoginView view;

    //SUT
    LoginPresenterImpl presenter;

    @Before
    public void setup() {
        when(view.getEmailText()).thenReturn(EMAIL);
        when(view.getPasswordText()).thenReturn(PASSWORD);

        presenter = new LoginPresenterImpl(baseContext);
        presenter.setView(view);
        presenter.llogger = llogger;
        presenter.repository = repository;
        presenter.textTools = textTools;

    }

    @Test
    public void onLoginClickValidatesEmail() {
        presenter.onLoginClicked();
        verify(textTools).isValidEmail(EMAIL);
    }

    @Test
    public void onLoginClickValidatesPassword() {
        when(textTools.isValidEmail(EMAIL)).thenReturn(true);
        when(textTools.isEmpty(EMAIL)).thenReturn(false);
        presenter.onLoginClicked();
        verify(textTools).isEmpty(PASSWORD);
    }

    @Test
    public void onLoginClickGetsEmailText() {
        when(textTools.isValidEmail(EMAIL)).thenReturn(false);
        presenter.onLoginClicked();
        verify(view).getEmailText();
    }

    @Test
    public void onLoginClickGetsPasswordText() {
        when(textTools.isValidEmail(EMAIL)).thenReturn(true);
        when(textTools.isEmpty(EMAIL)).thenReturn(false);
        when(textTools.isEmpty(PASSWORD)).thenReturn(true);
        presenter.onLoginClicked();
        verify(view).getPasswordText();
    }

    @Test
    public void onLoginClickNotifiesViewOnInvalidEmail() {
        when(textTools.isValidEmail(EMAIL)).thenReturn(false);
        presenter.onLoginClicked();
        verify(view).onEmailValidationError();
    }

    @Test
    public void onLoginClickNotifiesViewOnInvalidPassword() {
        when(textTools.isValidEmail(EMAIL)).thenReturn(true);
        when(textTools.isEmpty(PASSWORD)).thenReturn(true);
        presenter.onLoginClicked();
        verify(view).onPasswordValidationError();
    }

    @Test
    public void onLoginClickLoginsWhenAllValid() {
        when(textTools.isValidEmail(EMAIL)).thenReturn(true);
        when(textTools.isEmpty(EMAIL)).thenReturn(false);
        when(textTools.isEmpty(PASSWORD)).thenReturn(false);
        presenter.onLoginClicked();
        verify(repository).login(EMAIL, PASSWORD);
    }
}