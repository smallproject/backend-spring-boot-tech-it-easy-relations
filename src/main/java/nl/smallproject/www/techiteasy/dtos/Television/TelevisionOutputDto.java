package nl.smallproject.www.techiteasy.dtos.Television;

import nl.smallproject.www.techiteasy.dtos.CiModule.CiModuleOutputDto;
import nl.smallproject.www.techiteasy.dtos.RemoteController.RemoteControllerOutputDto;
import nl.smallproject.www.techiteasy.dtos.WallBracket.WallBracketOutputDto;
import nl.smallproject.www.techiteasy.models.WallBracket;

import java.util.List;

public class TelevisionOutputDto {

    private Long id;

    private String name;

    private String brand;

    private double price;

    private int currentStock;

    private double height;

    private double width;

    private String screenQuality;

    private String screenType;

    private Boolean wifi;

    private Boolean smartTv;

    private Boolean voiceControl;

    private Boolean hdr;

    private RemoteControllerOutputDto remoteControllerOutputDto;

    private List<CiModuleOutputDto> ciModuleOutputDtos;

    public List<WallBracketOutputDto> getWallBracketOutputDtos() {
        return wallBracketOutputDtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public RemoteControllerOutputDto getRemoteControllerOutputDto() {
        return remoteControllerOutputDto;
    }

    public void setRemoteControllerOutputDto(RemoteControllerOutputDto remoteControllerOutputDto) {
        this.remoteControllerOutputDto = remoteControllerOutputDto;
    }

    public List<CiModuleOutputDto> getCiModuleOutputDtos() {
        return ciModuleOutputDtos;
    }

    public void setCiModuleOutputDtos(List<CiModuleOutputDto> ciModuleOutputDtos) {
        this.ciModuleOutputDtos = ciModuleOutputDtos;
    }


    public void setWallBracketOutputDtos(List<WallBracketOutputDto> wallBracketOutputDtos) {
        this.wallBracketOutputDtos = wallBracketOutputDtos;
    }

    private List<WallBracketOutputDto> wallBracketOutputDtos;

}