package com.akashgvalani;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> contactList;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList <Contacts>();
    }


    public ArrayList <Contacts> getContactList() {
        return contactList;
    }


    public boolean addContact(Contacts contact){//boolean to see if we successfully added the record
        if(findContact(contact.getContactName())>=0) {
            System.out.println("Contact is already on file");
        }
        this.contactList.add(contact);
        return true;
    }
    
    public void printContactList(){
        if(contactList.size()==0)
            System.out.println("No Contacts");
        else {
            System.out.println("You have " + contactList.size() + " contacts in your list ");
            for (int i = 0; i < contactList.size(); i++)
                System.out.println((i + 1) + ". "
                        + this.contactList.get(i).getContactName() + " -> "
                        + this.contactList.get(i).getContactNumber());
        }
    }

    
    public void updateContact(int position, Contacts newContact){
        contactList.set(position, newContact);
        System.out.println("Position "+(position+1)+" has been modified");
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int position = this.contactList.indexOf(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getContactName() + " was not found");
            return false;
        } else if (findContact(newContact.getContactName()) != -1) {
            System.out.println("Contact with name " + newContact.getContactName() + " already " +
                    "exists. Cannot Update Record");
            return false;
        }
        this.contactList.set(position, newContact);
        System.out.println(oldContact.getContactName() + " was replaced with " + newContact.getContactName());
        return true;
    }

    public boolean removeContact(Contacts contact){
     
     int position = findContact(contact);
     if(position<0) {
         System.out.println("Contact was not found");
         return false;
     }
        contactList.remove(position);
        System.out.println(contact.getContactName()+" was deleted");
        return true;
    }

    public int findContact(String name){
        for(int i =0;i<contactList.size();i++){
            Contacts contacts = this.contactList.get(i);
            if(contacts.getContactName().equals(name))
                return i;
        }
        return -1;
    }

    public int findContact(Contacts searchContact){
        return this.contactList.indexOf(searchContact);
    }


    public String queryContact(Contacts contact){
        if(findContact(contact)>=0){
            return contact.getContactName();
        }
        return null;
    }

    public Contacts queryContact(String nameContact){
        int position = findContact(nameContact);
        if(position>=0){
            return contactList.get(position);
        }
        return null;
    }

//    public String queryContact(Contact contact) {
//        if(findContact(contact) >=0) {
//            return contact.getName();
//        }
//        return null;
//    }
    
    public Contacts getContactInformation(int position){
        return getContactList().get(position);
    }
}
