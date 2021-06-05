package com.example.laxmirefinary;

public class Metals {

    Long goldSolapur;

    Long silverSolapur;
    Long silverMumbai;
    Long silverHydrabad;
    Long silverKolhapur;

    Long goldSolapurOperator;

    Long silverSolapurOperator;
    Long silverMumbaiOperator;
    Long silverHydrabadOperator;
    Long silverKolhapurOperator;


    public Metals() {
    }

    public Metals(Long goldSolapur, Long silverSolapur, Long silverMumbai, Long silverHydrabad, Long silverKolhapur, Long goldSolapurOperator, Long silverSolapurOperator, Long silverMumbaiOperator, Long silverHydrabadOperator, Long silverKolhapurOperator) {
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

    public Long getGoldSolapurOperator() {
        return goldSolapurOperator;
    }

    public void setGoldSolapurOperator(Long goldSolapurOperator) {
        this.goldSolapurOperator = goldSolapurOperator;
    }

    public Long getSilverSolapurOperator() {
        return silverSolapurOperator;
    }

    public void setSilverSolapurOperator(Long silverSolapurOperator) {
        this.silverSolapurOperator = silverSolapurOperator;
    }

    public Long getSilverMumbaiOperator() {
        return silverMumbaiOperator;
    }

    public void setSilverMumbaiOperator(Long silverMumbaiOperator) {
        this.silverMumbaiOperator = silverMumbaiOperator;
    }

    public Long getSilverHydrabadOperator() {
        return silverHydrabadOperator;
    }

    public void setSilverHydrabadOperator(Long silverHydrabadOperator) {
        this.silverHydrabadOperator = silverHydrabadOperator;
    }

    public Long getSilverKolhapurOperator() {
        return silverKolhapurOperator;
    }

    public void setSilverKolhapurOperator(Long silverKolhapurOperator) {
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
