public class Item {
    private final String name;
    private final String price;
    private final String type;
    private final String expiration;
    private boolean isError = false;

    public Item(ItemBuilder builder) {
        this.name = builder.getName();
        this.price = builder.getPrice();
        this.type = builder.getType();
        this.expiration = builder.getExpiration();
        this.isError = builder.getIsError();
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }
    public boolean isError(){
        return isError;
    }
    //equals method
    //toString method


    @Override
    public String toString() {
        if(!isError) {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price='" + price + '\'' +
                    ", type='" + type + '\'' +
                    ", expiration='" + expiration + '\'' +
                    "}\n";
        }
        return "Erroneous entry\n";
    }

    public static class ItemBuilder{
        private String name = "";
        private String price = "";
        private String type = "";
        private String expiration = "";
        private boolean isError = false;
        public ItemBuilder(){
        }
        public ItemBuilder setName(String name) {
            checkError(name);
            this.name = name;
            return this;
        }

        public ItemBuilder setPrice(String price) {
            checkError(price);
            this.price = price;
            return this;
        }

        public ItemBuilder setType(String type) {
            checkError(type);
            this.type = type;
            return this;
        }

        public ItemBuilder setExpiration(String expiration) {
            checkError(expiration);
            this.expiration = expiration;
            return this;
        }
        public ItemBuilder denoteError(){
            this.isError = true;
            return this;
        }
        public void checkError(String input){
            if(input == null){
                this.isError = true;
            }
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getType() {
            return type;
        }

        public String getExpiration() {
            return expiration;
        }

        public boolean getIsError(){
            return isError;
        }
        public Item build(){
            return new Item(this);
        }
    }
}
