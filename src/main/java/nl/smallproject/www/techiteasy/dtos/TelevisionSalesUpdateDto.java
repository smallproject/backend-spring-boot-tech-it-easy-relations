package nl.smallproject.www.techiteasy.dtos;

import jakarta.validation.constraints.PositiveOrZero;

public class TelevisionSalesUpdateDto {

    @PositiveOrZero(message = "{television.price.positiveornotzero}")
    private double price;

    @PositiveOrZero(message = "{television.currentstock.positiveornotzero}")
    private int originalStock;

    @PositiveOrZero(message = "{television.sold.positiveornotzero}")
    private int sold;

    @PositiveOrZero
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero double price) {
        this.price = price;
    }

    @PositiveOrZero
    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(@PositiveOrZero int originalStock) {
        this.originalStock = originalStock;
    }

    @PositiveOrZero
    public int getSold() {
        return sold;
    }

    public void setSold(@PositiveOrZero int sold) {
        this.sold = sold;
    }
}
