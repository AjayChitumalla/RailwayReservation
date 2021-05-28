package com.org.bean;

import java.util.Date;

public class Train {
	private int trainNumber;
	private String trainName;
	private String sourcePoint;
	private String destinationPoint;
	private String startTime;
	private String reachTime;
	private int availableSeats;
	private Date date;
	private int fare;
	public int getTrain_no() {
		return trainNumber;
	}
	public void setTrain_no(int train_no) {
		this.trainNumber = train_no;
	}
	public String getTrain_name() {
		return trainName;
	}
	public void setTrain_name(String train_name) {
		this.trainName = train_name;
	}
	public String getSource_point() {
		return sourcePoint;
	}
	public void setSource_point(String source_point) {
		this.sourcePoint = source_point;
	}
	public String getDestination_point() {
		return destinationPoint;
	}
	public void setDestination_point(String destination_point) {
		this.destinationPoint = destination_point;
	}
	public String getStart_time() {
		return startTime;
	}
	public void setStart_time(String start_time) {
		this.startTime = start_time;
	}
	public String getReach_time() {
		return reachTime;
	}
	public void setReach_time(String reach_time) {
		this.reachTime = reach_time;
	}
	public int getAvailable_seats() {
		return availableSeats;
	}
	public void setAvailable_seats(int available_seats) {
		this.availableSeats = available_seats;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
}
