package com.HaneiIslim.CareSoft.ClinicApp;

public class User {
	protected Integer id;
    protected int pin;
     // Constructor
	 public User(int ID) {
		 this.id=ID;
	 }
	 // Getters and Setters
	 public int getId() {
		 return this.id;
	 }
	 public void setId(Integer id) {
		 this.id=id;
	 }
	 
	 public int getPin() {
		 return this.pin;
	 }
	 public void setPin(int pin) {
		 this.pin=pin;
	 }

}
