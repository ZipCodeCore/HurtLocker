public class Item {
    private final String name;
    private final String price;
    private final String type;
    private final String expiration;

    public Item(ItemBuilder builder) {
        this.name = builder.getName();
        this.price = builder.getPrice();
        this.type = builder.getType();
        this.expiration = builder.getExpiration();
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

    public static class ItemBuilder{
        private String name;
        private String price;
        private String type;
        private String expiration;
        public ItemBuilder(){
        }
        public ItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        public ItemBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ItemBuilder setExpiration(String expiration) {
            this.expiration = expiration;
            return this;
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
        public Item build(){
            return new Item(this);
        }
    }
}
