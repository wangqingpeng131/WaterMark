package com.getwatermark.photomaker.plugin.ccnicegreate.dd;

/**
 * @author Afra55
 * @date 2018/6/28
 * A smile is the best business card.
 */
public class KK extends CBaseBean {

    /**
     * ip : 127.0.0.1
     * productId : com.test
     * version : 1.0.0
     * gsid :
     */

    private String ip;
    private String productId;
    private String version;
    private String gsid;
    private String platform;
    private String userId;
    private String country;
    private String countryCode;
    private String city;
    private Double latitude;

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    private Double longitude;
    private String postCode;
    private boolean isPromotionEnabled;

    private String operatorCode;
    private int vpnType;

    public int getVpnType() {
        return vpnType;
    }

    public void setVpnType(int vpnType) {
        this.vpnType = vpnType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isIsPromotionEnabled() {
        return isPromotionEnabled;
    }

    public void setIsPromotionEnabled(boolean promotionEnabled) {
        isPromotionEnabled = promotionEnabled;
    }

    public boolean isPromotionEnabled() {
        return isPromotionEnabled;
    }

    public void setPromotionEnabled(boolean promotionEnabled) {
        isPromotionEnabled = promotionEnabled;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }
}
