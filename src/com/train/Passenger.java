package com.train;

public class Passenger {

    private int pnrID;
    private String pName;
   private int age;
   private BankAccount bankAccount;

    public Passenger() {
        super();
    }

    public Passenger(int pnrID, String pName, int age, BankAccount bankAccount) {
        this.pnrID = pnrID;
        this.pName = pName;
        this.age = age;
        this.bankAccount = bankAccount;
    }

    public int getPnrID() {
        return pnrID;
    }

    public void setPnrID(int pnrID) {
        this.pnrID = pnrID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
