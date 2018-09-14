package com.akashgvalani;

import java.util.Scanner;

public class Main {

    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("");

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        System.out.println("Phone Starting...");
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice - 6 to shutdown");
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
            }
        }

    }
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the Contact List.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To update an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact(){
       // Contacts newContact = new Contacts(scanner.nextLine(),scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter Contact Number");
        String number = scanner.next();

        Contacts newContact = Contacts.createContact(name,number);
        if (mobilePhone.addContact(newContact)){
            System.out.println("New contact added, name = "+newContact.getContactName()+" , phone = "+newContact.getContactNumber());
        }else
            System.out.println("Cannot add "+newContact.getContactName()+" , already on file");

    }

    public static void updateContact(){
        System.out.println("Enter name of contact to update");
        //int position = scanner.nextInt();
        String nameContact = scanner.next();
        Contacts existingContact = mobilePhone.queryContact(nameContact);
       if(existingContact == null) {
           System.out.println("No existing contact found");
           return;
       }
        System.out.println("Enter new contact name");
        String name = scanner.next();
        System.out.println("Enter new contact number");
        String updateNumber = scanner.next();
        if(mobilePhone.updateContact(existingContact,new Contacts(name,updateNumber))){
            System.out.println("Successfully updated record");
        }else System.out.println("Error updating record");

    }

    public static void removeContact(){
        System.out.println("Enter Name of Contact to be removed");
        String removeName = scanner.next();
        Contacts existingContact = mobilePhone.queryContact(removeName);
        if(existingContact == null)
            System.out.println("No such contact found");

        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully Deleted record");
        }else System.out.println("Error Deleting record");
//        mobilePhone.removeContact();
    }

    public static void findContact() {
        System.out.println("Enter Name of Contact to be found");
        String findName = scanner.next();
        Contacts existingContact = mobilePhone.queryContact(findName);
        if (existingContact == null) {
            System.out.println("No such contact found");
            return;
        }
        System.out.println(existingContact.getContactName() +" with phone number "+existingContact.getContactNumber()+" found");
    }

//    private static void queryContact() {
//        System.out.println("Enter existing contact name: ");
//        String name = scanner.nextLine();
//        Contacts existingContactRecord = mobilePhone.queryContact(name);
//        if (existingContactRecord == null) {
//            System.out.println("Contact not found.");
//            return;
//        }
//
//        System.out.println("Name: " + existingContactRecord.getContactName() + " phone number is " + existingContactRecord.getContactNumber());
//    }
}
