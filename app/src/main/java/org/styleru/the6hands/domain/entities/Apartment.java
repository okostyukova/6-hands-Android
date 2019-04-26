package org.styleru.the6hands.domain.entities;

public class Apartment {

    private int apartmentId, numberOfRooms, numberOfMeters, livingSpace, kitchen,
            ceilingHeight, floor, price, numberOfWatches, numberOfNewWatches, idUser, idFacility;

    private String address, metroStation;

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public int getNumberOfNewWatches() {
        return numberOfNewWatches;
    }

    public void setNumberOfNewWatches(int numberOfNewWatches) {
        this.numberOfNewWatches = numberOfNewWatches;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfMeters() {
        return numberOfMeters;
    }

    public void setNumberOfMeters(int numberOfMeters) {
        this.numberOfMeters = numberOfMeters;
    }

    public int getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(int livingSpace) {
        this.livingSpace = livingSpace;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getCeilingHeight() {
        return ceilingHeight;
    }

    public void setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfWatches() {
        return numberOfWatches;
    }

    public void setNumberOfWatches(int numberOfWatches) {
        this.numberOfWatches = numberOfWatches;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(int idFacility) {
        this.idFacility = idFacility;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
