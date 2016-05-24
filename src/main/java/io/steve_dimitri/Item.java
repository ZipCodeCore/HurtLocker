package io.steve_dimitri;

import java.util.Date;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class Item {
    private String name;
    private String price;
    private String type;
    private String expiration;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
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
}
