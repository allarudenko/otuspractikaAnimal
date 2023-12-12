package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class NumberValidator {

    public boolean isNumber(String numberSrt, Pattern pattern) {
        Matcher matcher = pattern.matcher(numberSrt);
        return matcher.find();
    }
}
