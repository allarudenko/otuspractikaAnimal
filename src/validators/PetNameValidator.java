package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PetNameValidator {
public boolean isPetName (String petName , Pattern pattern) {

    Matcher matcher = pattern.matcher(petName);
    return matcher.find();
    }

}

