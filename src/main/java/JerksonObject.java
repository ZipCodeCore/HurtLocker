import java.util.LinkedHashMap;
import java.util.Map;

public class JerksonObject {
    Map<String, String> obj;

    public JerksonObject(){
        obj = new LinkedHashMap<String, String>();
    }

    public Map<String, String> getObj(){
        return obj;
    }

    public Boolean containsValue(String value){
        return obj.containsValue(value);
    }
}
