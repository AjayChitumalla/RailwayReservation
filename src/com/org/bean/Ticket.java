package com.org.bean;

public class Ticket {
	private int ticketNumber;
	private String username;
	private int trainNumber;
	private int numberOfSeats;
	private String ticketClass;
	private int price;
	public int getTicket_no() {
		return ticketNumber;
	}
	public void setTicket_no(int ticket_no) {
		this.ticketNumber = ticket_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTrain_no() {
		return trainNumber;
	}
	public void setTrain_no(int train_no) {
		this.trainNumber = train_no;
	}
	public int getNo_of_seats() {
		return numberOfSeats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.numberOfSeats = no_of_seats;
	}
	public String getclass() {
		return ticketClass;
	}
	public void setClass(String class1) {
		ticketClass = class1;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
