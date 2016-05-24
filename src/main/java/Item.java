import java.util.regex.*;

public class Item {
    public String name;
    public String price;
    public String type;
    public String expiration;

    public Item(String[] string){
        this.name = parseName(string[1]);
        this.price = string[3];
        this.type = string[5];
        this.expiration = string[7];
    }

    public boolean findMilk(String raw){
        Pattern p = Pattern.compile("(?i)milk");
        Matcher m = p.matcher(raw);
        return m.find();
    }
    public boolean findCookies(String raw){
        Pattern p =Pattern.compile("(?i)cookies|co0kies");
        Matcher m = p.matcher(raw);
        return m.find();
    }
    public boolean findBread(String raw){
        Pattern p =Pattern.compile("(?i)bread");
        Matcher m = p.matcher(raw);
        return m.find();
    }
    public boolean findApples(String raw){
        Pattern p =Pattern.compile("(?i)apples");
        Matcher m = p.matcher(raw);
        return m.find();
    }
    public String parseName(String rawForm){
    String fixedName = "";
        while(true) {
            if (findMilk(rawForm)) {
                fixedName = "milk";
                break;
            }
            if (findCookies(rawForm)) {
                fixedName = "cookies";
                break;
            }
            if (findApples(rawForm)) {
                fixedName = "apples";
                break;
            }
            if (findBread(rawForm)) {
                fixedName = "bread";
                break;
            }
            break;
        }
    return fixedName;
    }
}
