package nl.smallproject.www.techiteasy.dtos.WallBracket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class WallBracketInputDto {


    @NotBlank(message = "{wallBracket.size.notblank}")
    @Size(min = 3, max = 255, message = "{wallBracket.size.size}")
    private String size;

    @NotNull(message = "{wallBracket.adjustable.notnull}")
    private boolean adjustable;

    @NotBlank(message = "{wallBracket.name.notblank}")
    @Size(min = 3, max = 255, message = "{wallBracket.name.size}")
    private String name;

    @PositiveOrZero(message = "{wallBracket.price.positiveornotzero}")
    private double price;

    public @NotBlank(message = "{wallBracket.size.notblank}") @Size(min = 3, max = 255, message = "{wallBracket.size.size}") String getSize() {
        return size;
    }

    public void setSize(@NotBlank(message = "{wallBracket.size.notblank}") @Size(min = 3, max = 255, message = "{wallBracket.size.size}") String size) {
        this.size = size;
    }

    @NotNull(message = "{wallBracket.adjustable.notnull}")
    public boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(@NotNull(message = "{wallBracket.adjustable.notnull}") boolean adjustable) {
        this.adjustable = adjustable;
    }

    public @NotBlank(message = "{wallBracket.name.notblank}") @Size(min = 3, max = 255, message = "{wallBracket.name.size}") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "{wallBracket.name.notblank}") @Size(min = 3, max = 255, message = "{wallBracket.name.size}") String name) {
        this.name = name;
    }

    @PositiveOrZero(message = "{wallBracket.price.positiveornotzero}")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "{wallBracket.price.positiveornotzero}") double price) {
        this.price = price;
    }
}
