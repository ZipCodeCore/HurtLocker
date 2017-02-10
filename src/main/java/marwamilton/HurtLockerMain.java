package marwamilton;

import java.util.List;

/**
 * Created by mkulima on 2/8/17.
 */
public class HurtLockerMain {

    public static void main(String[] args) {
        MakeString mk = new MakeString();
        HurtLocker ht = new HurtLocker();
        String[] ds = (mk.dumb).split("[(##)]");
        GroceryRegexEngine regexEngine = new GroceryRegexEngine();

        List<String[]> baggedGroceries = ht.bagGroceries(ds);
        List<List<String[]>> labelledAndBaggedGroceries = ht.labelTheGroceries(baggedGroceries);
        List<List<String[]>> milks = ht.groupGroceries(regexEngine.Milk, labelledAndBaggedGroceries);

        /*
        for(String s2 : ds){
            System.out.println(s2);
        }
        /**/

        /*
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        for(int i=0; i<baggedGroceries.size(); i+=2){
            System.out.print(Arrays.toString(baggedGroceries.get(i)) + "      " + baggedGroceries.get(i).length + " "+ baggedGroceries.size() + "\n");

        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        /* */

        /*
        for (int j=0; j<labelledAndBaggedGroceries.size(); j+=2){
            List<String[]> lstr = labelledAndBaggedGroceries.get(j);

            System.out.println(lstr.size());
            System.out.println(ht.makePrintable(lstr));
        }
        /* */

        /*
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println(milks.size());
        for (int k=0; k<milks.size(); k++){
            List<String[]> lstr = milks.get(k);

            System.out.println(k);
            System.out.println(ht.makePrintable(lstr));
            //System.out.println(Arrays.toString(ht.mergedPrices(lstr)));
        }
        /* */
        //System.out.println(Arrays.toString(ht.mergedPrices(milks)));

        /*
        for (List<String[]> ls : labelledAndBaggedGroceries) {
            System.out.println(" ----------------------- ");
            for (String[] sarr : ls) {
                System.out.print(Arrays.toString(sarr) + " ");
            }
            System.out.println(" ");
        }
        /**/

        /*
        for(String[] sarr : ht.finalizeGroceries())
            System.out.println(Arrays.toString(sarr));

        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        /* */

        List<String[]> removedBadPrices = ht.removeBadPrices(ht.finalizeGroceries());
        List<String[]> withBadPrices = ht.finalizeGroceries();
        for(int x=0; x<removedBadPrices.size(); x++){
            System.out.println(ht.makePrintable(removedBadPrices.get(x), withBadPrices.get(x)));
            System.out.println();
        }
        System.out.println("Errors                    seen: " + ht.countNullElements(ht.finalizeGroceries()) + " times");
    }
}
