package br.com.travel.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TravelPackage implements Serializable {

    private final String local;
    private final String image;
    private final Integer days;
    private final BigDecimal price;

    public TravelPackage(String local, String image, Integer days, BigDecimal price) {
        this.local = local;
        this.image = image;
        this.days = days;
        this.price = price;
    }

    public String getLocal() {
        return local;
    }

    public String getImage() {
        return image;
    }

    public Integer getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
