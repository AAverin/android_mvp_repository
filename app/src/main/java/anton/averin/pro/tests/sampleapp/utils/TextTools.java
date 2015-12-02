package anton.averin.pro.tests.sampleapp.utils;

import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TextTools {

    @Inject
    public TextTools() {
    }

    public boolean isEmpty(String aString) {
        return TextUtils.isEmpty(aString);
    }

    public boolean isEmpty(CharSequence aString) {
        return TextUtils.isEmpty(aString);
    }

    public boolean isValidEmail(CharSequence target) {
        return !isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
