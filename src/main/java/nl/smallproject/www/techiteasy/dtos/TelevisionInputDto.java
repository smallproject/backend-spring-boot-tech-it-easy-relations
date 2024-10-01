package nl.smallproject.www.techiteasy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class TelevisionInputDto {

    @NotBlank(message = "{television.name.notblank}")
    @Size(min = 3, max = 255, message = "{television.name.size}")
    private String name;

    @NotBlank(message = "{television.brand.notblank}")
    @Size(min = 3, max = 255, message = "{television.brand.size}")
    private String brand;

    @PositiveOrZero(message = "{television.price.positiveornotzero}")
    private double price;

    @PositiveOrZero(message = "{television.currentstock.positiveornotzero}")
    private int currentStock;

    @PositiveOrZero(message = "{television.height.positiveornotzero}")
    private double height;

    @PositiveOrZero(message = "{television.width.positiveornotzero}")
    private double width;

    @NotBlank(message = "{television.screenquality.notblank}")
    @Size(min = 3, max = 255, message = "{television.screenquality.size}")
    private String screenQuality;

    @NotBlank(message = "{television.screentype.notblank}")
    @Size(min = 3, max = 255, message = "{television.screentype.size}")
    private String screenType;

    @NotNull(message = "{television.wifi.notnull}")
    private Boolean wifi;

    @NotNull(message = "{television.smarttv.notnull}")
    private Boolean smartTv;

    @NotNull(message = "{television.voicecontrol.notnull}")
    private Boolean voiceControl;

    @NotNull(message = "{television.hdr.notnull}")
    private Boolean hdr;

    public @NotBlank(message = "{television.name.notblank}") @Size(min = 3, max = 255, message = "{television.name.size}") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "{television.name.notblank}") @Size(min = 3, max = 255, message = "{television.name.size}") String name) {
        this.name = name;
    }

    public @NotBlank(message = "{television.brand.notblank}") @Size(min = 3, max = 255, message = "{television.brand.size}") String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank(message = "{television.brand.notblank}") @Size(min = 3, max = 255, message = "{television.brand.size}") String brand) {
        this.brand = brand;
    }

    @PositiveOrZero(message = "{television.price.positiveornotzero}")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "{television.price.positiveornotzero}") double price) {
        this.price = price;
    }

    @PositiveOrZero(message = "{television.currentstock.positiveornotzero}")
    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(@PositiveOrZero(message = "{television.currentstock.positiveornotzero}") int currentStock) {
        this.currentStock = currentStock;
    }

    @PositiveOrZero(message = "{television.height.positiveornotzero}")
    public double getHeight() {
        return height;
    }

    public void setHeight(@PositiveOrZero(message = "{television.height.positiveornotzero}") double height) {
        this.height = height;
    }

    @PositiveOrZero(message = "{television.width.positiveornotzero}")
    public double getWidth() {
        return width;
    }

    public void setWidth(@PositiveOrZero(message = "{television.width.positiveornotzero}") double width) {
        this.width = width;
    }

    public @NotBlank(message = "{television.screenquality.notblank}") @Size(min = 3, max = 255, message = "{television.screenquality.size}") String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(@NotBlank(message = "{television.screenquality.notblank}") @Size(min = 3, max = 255, message = "{television.screenquality.size}") String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public @NotBlank(message = "{television.screentype.notblank}") @Size(min = 3, max = 255, message = "{television.screentype.size}") String getScreenType() {
        return screenType;
    }

    public void setScreenType(@NotBlank(message = "{television.screentype.notblank}") @Size(min = 3, max = 255, message = "{television.screentype.size}") String screenType) {
        this.screenType = screenType;
    }

    public @NotNull(message = "{television.wifi.notnull}") Boolean getWifi() {
        return wifi;
    }

    public void setWifi(@NotNull(message = "{television.wifi.notnull}") Boolean wifi) {
        this.wifi = wifi;
    }

    public @NotNull(message = "{television.smarttv.notnull}") Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(@NotNull(message = "{television.smarttv.notnull}") Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public @NotNull(message = "{television.voicecontrol.notnull}") Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(@NotNull(message = "{television.voicecontrol.notnull}") Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public @NotNull(message = "{television.hdr.notnull}") Boolean getHdr() {
        return hdr;
    }

    public void setHdr(@NotNull(message = "{television.hdr.notnull}") Boolean hdr) {
        this.hdr = hdr;
    }
}
