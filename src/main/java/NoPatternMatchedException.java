import java.io.IOException;

/**
 * Created by aurorabanuelos on 5/31/17.
 */
public class NoPatternMatchedException  extends IOException{

    public NoPatternMatchedException(){
    }
    public NoPatternMatchedException(String gripe){
        super(gripe);
    }
}
