package com.akashgvalani;

public class Contacts {
    private String contactName;
    private String contactNumber;

    public Contacts(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public static Contacts createContact(String name,String number){
        return new Contacts(name,number);
    }

}
