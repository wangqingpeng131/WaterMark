package com.getwatermark.photomaker.plugin.ccnicegreate.dd;

/**
 * @author Afra55
 * @date 2018/6/28
 * A smile is the best business card.
 */
public class DD extends CBaseBean {

    /**
     * ip : 1.80.37.203
     * city : Xian
     * region : Shaanxi
     * country : CN
     * loc : 34.2583,108.9290
     * org : AS4134 CHINANET-BACKBONE
     */

    private String ip;
    private String city;
    private String region;
    private String country;
    private String org;
    private String latitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private String longitude;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
