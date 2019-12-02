public class ItemCounter {

    public String itemCounter(String[] array, String p, String item) throws Exception {
        ContainsRegex regex = new ContainsRegex();
        String pattern = p;
        Integer count = 0;
        for (String s : array) {
            if (regex.containsRegex(s, pattern)) {
                count++;
            }
        }
        return String.format("%-15s %15s", "Name: " + item, "Seen: ") + count;
    }
}
