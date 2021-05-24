package com.org.bean;

import java.util.Date;

public class Train {
	private int train_no;
	private String train_name;
	private String source_point;
	private String destination_point;
	@Override
	public String toString() {
		return "Train [train_no=" + train_no + ", train_name=" + train_name + ", source_point=" + source_point
				+ ", destination_point=" + destination_point  + ", start_time="
				+ start_time + ", reach_time=" + reach_time + ", available_seats=" + available_seats + ", date=" + date
				+ ", fare=" + fare + "]";
	}
	private String start_time;
	private String reach_time;
	private int available_seats;
	private Date date;
	private int fare;
	public int getTrain_no() {
		return train_no;
	}
	public void setTrain_no(int train_no) {
		this.train_no = train_no;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getSource_point() {
		return source_point;
	}
	public void setSource_point(String source_point) {
		this.source_point = source_point;
	}
	public String getDestination_point() {
		return destination_point;
	}
	public void setDestination_point(String destination_point) {
		this.destination_point = destination_point;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getReach_time() {
		return reach_time;
	}
	public void setReach_time(String reach_time) {
		this.reach_time = reach_time;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
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
