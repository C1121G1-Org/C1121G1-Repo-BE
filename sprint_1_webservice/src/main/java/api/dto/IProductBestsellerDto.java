package api.dto;

//Create by chienLV
//Time: 18h00 31/05/2022
//Function: get list product bestseller from database
public interface IProductBestsellerDto {
    Long getId();
    String getName();
    Double getPrice();
    String getImage();
    String getQrScan();
    String getScreenSize();
    String getCamera();
    String getSelfie();
    String getCpu();
    String getMemory();
    String getOtherDescription();
    String getDiscount();
    String getPromotions();
    String getFiveStarRating();
    String getDateCreate();
    String getCategory();
    Integer getProductQuantity();
}
