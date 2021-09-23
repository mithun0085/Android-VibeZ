package com.example.androidvibez;

public class Guest {

    private String guest_family;
    private String no_of_adults;
    private String  no_of_kids;

    public Guest(){}


    public Guest(String guest_family, String no_of_adults, String no_of_kids)
    {
        this.guest_family = guest_family;
        this.no_of_adults = no_of_adults;
        this.no_of_kids = no_of_kids;
    }


    public String getGuest_family() {
        return guest_family;
    }

    public void setGuest_family(String guest_family) {
        this.guest_family = guest_family;
    }

    public String getNo_of_adults() {
        return no_of_adults;
    }

    public void setNo_of_adults(String no_of_adults) {
        this.no_of_adults = no_of_adults;
    }

    public String getNo_of_kids() {
        return no_of_kids;
    }

    public void setNo_of_kids(String no_of_kids) {
        this.no_of_kids = no_of_kids;
    }
}
