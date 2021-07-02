package com.example.laxmirefinary;

public class Metals {

    Long goldSolapur;

    Long silverSolapur;
    Long silverMumbai;
    Long silverHydrabad;
    Long silverKolhapur;

    String goldSolapurOperator;

    String silverSolapurOperator;
    String silverMumbaiOperator;
    String silverHydrabadOperator;
    String silverKolhapurOperator;


    public Metals() {
    }

    public Metals(Long goldSolapur, Long silverSolapur, Long silverMumbai, Long silverHydrabad, Long silverKolhapur, String goldSolapurOperator, String silverSolapurOperator, String silverMumbaiOperator, String silverHydrabadOperator, String silverKolhapurOperator) {
        this.goldSolapur = goldSolapur;
        this.silverSolapur = silverSolapur;
        this.silverMumbai = silverMumbai;
        this.silverHydrabad = silverHydrabad;
        this.silverKolhapur = silverKolhapur;
        this.goldSolapurOperator = goldSolapurOperator;
        this.silverSolapurOperator = silverSolapurOperator;
        this.silverMumbaiOperator = silverMumbaiOperator;
        this.silverHydrabadOperator = silverHydrabadOperator;
        this.silverKolhapurOperator = silverKolhapurOperator;
    }

    public Long getGoldSolapur() {
        return goldSolapur;
    }

    public void setGoldSolapur(Long goldSolapur) {
        this.goldSolapur = goldSolapur;
    }

    public Long getSilverSolapur() {
        return silverSolapur;
    }

    public void setSilverSolapur(Long silverSolapur) {
        this.silverSolapur = silverSolapur;
    }

    public Long getSilverMumbai() {
        return silverMumbai;
    }

    public void setSilverMumbai(Long silverMumbai) {
        this.silverMumbai = silverMumbai;
    }

    public Long getSilverHydrabad() {
        return silverHydrabad;
    }

    public void setSilverHydrabad(Long silverHydrabad) {
        this.silverHydrabad = silverHydrabad;
    }

    public Long getSilverKolhapur() {
        return silverKolhapur;
    }

    public void setSilverKolhapur(Long silverKolhapur) {
        this.silverKolhapur = silverKolhapur;
    }

    public String getGoldSolapurOperator() {
        return goldSolapurOperator;
    }

    public void setGoldSolapurOperator(String goldSolapurOperator) {
        this.goldSolapurOperator = goldSolapurOperator;
    }

    public String getSilverSolapurOperator() {
        return silverSolapurOperator;
    }

    public void setSilverSolapurOperator(String silverSolapurOperator) {
        this.silverSolapurOperator = silverSolapurOperator;
    }

    public String getSilverMumbaiOperator() {
        return silverMumbaiOperator;
    }

    public void setSilverMumbaiOperator(String silverMumbaiOperator) {
        this.silverMumbaiOperator = silverMumbaiOperator;
    }

    public String getSilverHydrabadOperator() {
        return silverHydrabadOperator;
    }

    public void setSilverHydrabadOperator(String silverHydrabadOperator) {
        this.silverHydrabadOperator = silverHydrabadOperator;
    }

    public String getSilverKolhapurOperator() {
        return silverKolhapurOperator;
    }

    public void setSilverKolhapurOperator(String silverKolhapurOperator) {
        this.silverKolhapurOperator = silverKolhapurOperator;
    }

    @Override
    public String toString() {
        return "Metals{" +
                "goldSolapur=" + goldSolapur +
                ", silverSolapur=" + silverSolapur +
                ", silverMumbai=" + silverMumbai +
                ", silverHydrabad=" + silverHydrabad +
                ", silverKolhapur=" + silverKolhapur +
                ", goldSolapurOperator=" + goldSolapurOperator +
                ", silverSolapurOperator=" + silverSolapurOperator +
                ", silverMumbaiOperator=" + silverMumbaiOperator +
                ", silverHydrabadOperator=" + silverHydrabadOperator +
                ", silverKolhapurOperator=" + silverKolhapurOperator +
                '}';
    }
}
