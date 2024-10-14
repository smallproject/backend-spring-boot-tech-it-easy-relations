package nl.smallproject.www.techiteasy.dtos.CiModule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class CiModuleInputDto {

    @NotBlank(message = "{cimodule.name.notblank}")
    @Size(min = 3, max = 255, message = "{cimodule.name.size}")
    private String name;

    @NotBlank(message = "{cimodule.type.notblank}")
    @Size(min = 3, max = 255, message = "{cimodule.type.size}")
    private String type;

    @PositiveOrZero(message = "{cimodule.price.positiveornotzero}")
    private double price;

    public @NotBlank(message = "{cimodule.name.notblank}") @Size(min = 3, max = 255, message = "{cimodule.name.size}") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "{cimodule.name.notblank}") @Size(min = 3, max = 255, message = "{cimodule.name.size}") String name) {
        this.name = name;
    }

    public @NotBlank(message = "{cimodule.type.notblank}") @Size(min = 3, max = 255, message = "{cimodule.type.size}") String getType() {
        return type;
    }

    public void setType(@NotBlank(message = "{cimodule.type.notblank}") @Size(min = 3, max = 255, message = "{cimodule.type.size}") String type) {
        this.type = type;
    }

    @PositiveOrZero(message = "{cimodule.price.positiveornotzero}")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "{cimodule.price.positiveornotzero}") double price) {
        this.price = price;
    }
}
