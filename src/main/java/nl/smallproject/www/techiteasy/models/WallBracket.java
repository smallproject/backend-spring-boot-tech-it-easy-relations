package nl.smallproject.www.techiteasy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "wallbracket")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "size")
    private String size;

    @Column(name = "adjustable")
    private boolean adjustable;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
