import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        try {
            Pattern pattern = Pattern.compile("^(?=.{3,19}$)[а-яёА-ЯЁa-zA-Z]+\\s[а-яёА-ЯЁa-zA-Z-]+$");
            Matcher matcher = pattern.matcher(name);
            return matcher.find();
        } catch (NullPointerException exception) {
            return false;
        }

    }

}