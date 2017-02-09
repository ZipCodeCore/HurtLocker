import java.util.regex.*;

public class JerksonPattern {

    private String currentName;
    private String currentPrice;
    private String currentType;
    private String currentExpiration;

    public String[] splitRawData(String entireRawData) {
        String patternString = "##";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        String[] eachItemRawForm = pattern.split(entireRawData);
        return eachItemRawForm;
    }

    public String convertName (String itemInRawForm) {
        String patternString = "([N][A][M][E])+";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemInRawForm);
        boolean doesMatchExist = matcher.find();
        int locationOfMatch = matcher.end();

        String patternString2 = "([:@^*%])+";
        Pattern pattern2 = Pattern.compile(patternString2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(itemInRawForm);
        boolean doesMatchExist2 = matcher2.find();
        int locationOfMatch2 = matcher2.end();

        String patternString3 = "([;])+";
        Pattern pattern3 = Pattern.compile(patternString3, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(itemInRawForm);
        boolean doesMatchExist3 = matcher3.find();
        int locationOfMatch3 = matcher3.end();

        String name = itemInRawForm.substring(locationOfMatch2, locationOfMatch3 - 1);
        if (name.length() < 2) {
            name = "INVALID";
        }
        else {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
        name = fixSpelling(name);
        setCurrentName(name);
        return itemInRawForm.substring(locationOfMatch3);
    }

    public String convertPrice (String itemInRawForm) {
        String patternString = "([P][R][I][C][E])+";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemInRawForm);
        boolean doesMatchExist = matcher.find();
        int locationOfMatch = matcher.end();

        String patternString2 = "([:@^*%])+";
        Pattern pattern2 = Pattern.compile(patternString2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(itemInRawForm);
        boolean doesMatchExist2 = matcher2.find();
        int locationOfMatch2 = matcher2.end();

        String patternString3 = "([;])+";
        Pattern pattern3 = Pattern.compile(patternString3, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(itemInRawForm);
        boolean doesMatchExist3 = matcher3.find();
        int locationOfMatch3 = matcher3.end();

        String price = itemInRawForm.substring(locationOfMatch2, locationOfMatch3 - 1);
        if (price.length() < 2) {
            price = "INVALID";
        }
        setCurrentPrice(price);
        return itemInRawForm.substring(locationOfMatch3);
    }

    public String convertType (String itemInRawForm) {
        String patternString = "([T][Y][P][E])+";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemInRawForm);
        boolean doesMatchExist = matcher.find();
        int locationOfMatch = matcher.end();

        String patternString2 = "([:@^*%])+";
        Pattern pattern2 = Pattern.compile(patternString2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(itemInRawForm);
        boolean doesMatchExist2 = matcher2.find();
        int locationOfMatch2 = matcher2.end();

        String patternString3 = "([;])+";
        Pattern pattern3 = Pattern.compile(patternString3, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(itemInRawForm);
        boolean doesMatchExist3 = matcher3.find();
        int locationOfMatch3 = matcher3.end();

        String type = itemInRawForm.substring(locationOfMatch2, locationOfMatch3 - 1);
        setCurrentType(type);
        return itemInRawForm.substring(locationOfMatch3);
    }

    public void convertExpiration (String itemInRawForm) {
        String patternString = "([E][X][P][I][R][A][T][I][O][N])+";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemInRawForm);
        boolean doesMatchExist = matcher.find();
        int locationOfMatch = matcher.end();

        String patternString2 = "([:@^*%])+";
        Pattern pattern2 = Pattern.compile(patternString2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(itemInRawForm);
        boolean doesMatchExist2 = matcher2.find();
        int locationOfMatch2 = matcher2.end();

        String expiration = itemInRawForm.substring(locationOfMatch2);
        setCurrentExpiration(expiration);
    }

    public String fixSpelling (String word) {
        String patternString = "\\b[C]\\S*[K][I][E][S]\\b";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(word);
        boolean doesMatchExist = matcher.find();
        if (doesMatchExist) {
            word = "Cookies";
        }
        return word;
    }

    public void setCurrentName (String name) {
        currentName = name;
    }

    public String getCurrentName () {
        return currentName;
    }

    public void setCurrentPrice (String price) {
        currentPrice = price;
    }

    public String getCurrentPrice () {
        return currentPrice;
    }

    public void setCurrentType (String type) {
        currentType = type;
    }

    public String getCurrentType () {
        return currentType;
    }

    public void setCurrentExpiration (String expiration) {
        currentExpiration = expiration;
    }

    public String getCurrentExpiration () {
        return currentExpiration;
    }
}