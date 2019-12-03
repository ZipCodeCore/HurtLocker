import java.util.regex.Pattern;

public class CleanTheJerk {

    public String[] splitToItems() {
        Pattern pattern = Pattern.compile("##");
        String[] itemsArray = pattern.split(HurtLocker.loadFile());
        for (int i = 0; i < itemsArray.length; i++) {
            String s = itemsArray[i];
            System.out.println(s);
        }
        return itemsArray;
    }

    public void replaceMilk (){

    }
}
