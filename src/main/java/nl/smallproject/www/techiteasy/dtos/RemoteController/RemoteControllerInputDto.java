package nl.smallproject.www.techiteasy.dtos.RemoteController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class RemoteControllerInputDto {

    @NotBlank(message = "{remoteController.compatibleWith.notblank}")
    @Size(min = 3, max = 255, message = "{remoteController.compatibleWith.size}")
    private String compatibleWith;

    @NotBlank(message = "{remoteController.batteryType.notblank}")
    @Size(min = 1, max = 255, message = "{remoteController.batteryType.size}")
    private String batteryType;

    @NotBlank(message = "{remoteController.name.notblank}")
    @Size(min = 3, max = 255, message = "{remoteController.name.size}")
    private String name;

    @NotBlank(message = "{remoteController.brand.notblank}")
    @Size(min = 3, max = 255, message = "{remoteController.brand.size}")
    private String brand;

    @PositiveOrZero(message = "{remoteController.price.positiveornotzero}")
    private double price;

    @PositiveOrZero(message = "{remoteController.originalStock.positiveornotzero}")
    private int originalStock;

    public @NotBlank(message = "{remoteController.compatibleWith.notblank}") @Size(min = 3, max = 255, message = "{remoteController.compatibleWith.size}") String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(@NotBlank(message = "{remoteController.compatibleWith.notblank}") @Size(min = 3, max = 255, message = "{remoteController.compatibleWith.size}") String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public @NotBlank(message = "{remoteController.batteryType.notblank}") @Size(min = 1, max = 255, message = "{remoteController.batteryType.size}") String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(@NotBlank(message = "{remoteController.batteryType.notblank}") @Size(min = 3, max = 255, message = "{remoteController.batteryType.size}") String batteryType) {
        this.batteryType = batteryType;
    }

    public @NotBlank(message = "{remoteController.name.notblank}") @Size(min = 3, max = 255, message = "{remoteController.name.size}") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "{remoteController.name.notblank}") @Size(min = 3, max = 255, message = "{remoteController.name.size}") String name) {
        this.name = name;
    }

    public @NotBlank(message = "{remoteController.brand.notblank}") @Size(min = 3, max = 255, message = "{remoteController.brand.size}") String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank(message = "{remoteController.brand.notblank}") @Size(min = 3, max = 255, message = "{remoteController.brand.size}") String brand) {
        this.brand = brand;
    }

    @PositiveOrZero(message = "{remoteController.price.positiveornotzero}")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "{remoteController.price.positiveornotzero}") double price) {
        this.price = price;
    }

    @PositiveOrZero(message = "{remoteController.originalStock.positiveornotzero}")
    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(@PositiveOrZero(message = "{remoteController.originalStock.positiveornotzero}") int originalStock) {
        this.originalStock = originalStock;
    }
}
