package com.org.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.bean.Ticket;
import com.org.bean.Train;
import com.org.bean.User;

public class ApplicationDao {
	public int registerUser(User user){

		int rowsAffected = 0;
		try {
			Connection connection = DbConnection.getDbconnection();
			String insertQuery = "insert into users values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1,user.getName());
			statement.setString(2,user.getEmail());
			statement.setDate(3, new Date(user.getDob().getTime()));
			statement.setString(4,user.getGender());
			statement.setString(5,user.getAddress());
			statement.setString(6,user.getPassword());
			rowsAffected = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public boolean loginUser(String username, String password) {
		boolean isValid = false;
		Connection connection = DbConnection.getDbconnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from users where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if(result.next())
				isValid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isValid;
	}
	
	public List<String> getSourceDestination() {
		List<String> places = new ArrayList<>();
		Connection connection = DbConnection.getDbconnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select source_point,destination_point from train");
			while(result.next()) {
				places.add(result.getString("source_point"));
				places.add(result.getString("destination_point"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return places;
	}
	
	public List<Train> searchTrains(String source, String destination){
		List<Train> trains = new ArrayList<>();
		Train train = null;
		Connection connection = DbConnection.getDbconnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from train where source_point=? and destination_point=?");
			statement.setString(1, source);
			statement.setString(2, destination);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				train = new Train();
				train.setTrain_no(result.getInt("train_no"));
				train.setTrain_name(result.getString("train_name"));
				train.setSource_point(result.getString("source_point"));
				train.setDestination_point(result.getString("destination_point"));
				train.setStart_time(result.getString("start_time"));
				train.setReach_time(result.getString("reach_time"));
				train.setAvailable_seats(result.getInt("available_seats"));
				train.setDate(result.getDate("date"));
				train.setFare(result.getInt("fare"));
				trains.add(train);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trains;
	}
	
	public Train getTrainById(String id) {
		Train train = new Train();
		Connection connection = DbConnection.getDbconnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from train where train_no=?");
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				train = new Train();
				train.setTrain_no(result.getInt("train_no"));
				train.setTrain_name(result.getString("train_name"));
				train.setSource_point(result.getString("source_point"));
				train.setDestination_point(result.getString("destination_point"));
				train.setStart_time(result.getString("start_time"));
				train.setReach_time(result.getString("reach_time"));
				train.setAvailable_seats(result.getInt("available_seats"));
				train.setDate(result.getDate("date"));
				train.setFare(result.getInt("fare"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return train;
	}
	
	public int generateTicket(String username, int train_no, int no_of_seats, String selectedClass,int fare) {
		int rowsAffected=0;
		Connection connection = DbConnection.getDbconnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into ticket(username,train_no,no_of_seats,class,price) values(?,?,?,?,?)");
			statement.setString(1,username);
			statement.setInt(2,train_no);
			statement.setInt(3, no_of_seats);
			statement.setString(4, selectedClass);
			statement.setInt(5, fare*no_of_seats);
			rowsAffected = statement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	public List<Ticket> getTickets(String username){
		List<Ticket> tickets = new ArrayList<>();
		Connection connection = DbConnection.getDbconnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from ticket where username=?");
			statement.setString(1,username);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Ticket ticket = new Ticket();
				ticket.setTicket_no(result.getInt("ticket_no"));
				ticket.setUsername(result.getString("username"));
				ticket.setTrain_no(result.getInt("train_no"));
				ticket.setNo_of_seats(result.getInt("no_of_seats"));
				ticket.setClass(result.getString("class"));
				ticket.setPrice(result.getInt("price"));
				tickets.add(ticket);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}
	
	public int removeTicket(int ticket_no) {
		int result = 0;
		Connection connection = DbConnection.getDbconnection();
		try {
			PreparedStatement statement = connection.prepareStatement("delete from ticket where ticket_no=?");
			statement.setInt(1,ticket_no);
			result = statement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
