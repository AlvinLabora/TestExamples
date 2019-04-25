package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import Dao_Implement.ImpDAO;

public class SourceUpdate extends ImpDAO {
	public static Statement selectStatement = null;
	public static ResultSet results = null;
	public static Connection cn = null;
	public static String username = null;
	public static Scanner sc = new Scanner(System.in);

	
	public static void delPlayer() {
		try {

			Connection con = Database.getConnection();
			selectStatement = con.createStatement();
			String sqlplayer = " delete from player  where UserName ='" + username + "';";
			String sqlteam = " delete from team  where UserName ='" + username + "';";

			selectStatement.executeUpdate(sqlplayer);
			selectStatement.executeUpdate(sqlteam);

			System.out.println("Player with username: " + username + " Deleted ");
		} catch (Exception e) {
			System.out.println("Error!" + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	public static void ViewUpdate() {
		Connection conn = Database.getConnection();
		String sql = "select * from player JOIN team ON player.UserName = team.UserName where player.UserName = '"
				+ username + "' ";
		try {
			selectStatement = conn.createStatement();
			results = selectStatement.executeQuery(sql);
			while (results.next()) {
				username = results.getString("UserName");
				String name = results.getString("Name");
				String lastname = results.getString("LastName");
				String gender = results.getString("Gender");
				String id = results.getString("id");
				String active = results.getString("Active");
				String teamid = results.getString("TeamID");
				String teamname = results.getString("TeamName");
				System.out.println("UserName: " + username + " Name: " + name + " LastName: " + lastname + " Gender: "
						+ gender + " ID: " + id + " Active: " + active + " TeamID: " + teamid + " TeamName: "
						+ teamname);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	public static void line() {
		System.out.println("---------------------------------------------------------------------------------------------");
	}

	public static void getNewName() {
	
		try {
			Connection con =  Database.getConnection();
			System.out.print("Enter new Name:");
			String name = sc.next();

			selectStatement = con.createStatement();
			String sql = "Update player set Name = '" + name + "' " + " " + " where UserName = '" + username + "';";
			selectStatement.executeUpdate(sql);
			SourceUpdate.line();
			System.out.println("User: " + username + " Changed Name to: " + name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void getNewLastName() {
		
		try {
			
			Connection con =  Database.getConnection();
			System.out.print("Enter new LastName:");
			String lastname = sc.next();
			selectStatement = con.createStatement();
			String sql = "Update player set LastName = '" + lastname + "' " + " " + " where UserName = '" + username
					+ "';";
			SourceUpdate.line();
			System.out.println("User: " + username + " Changed LastName to: " + lastname);
			selectStatement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void getNewGender() {
		
		try {
			Connection con =  Database.getConnection();
			System.out.print("Enter new GenderName:");
			String gender = sc.next();
			selectStatement = con.createStatement();
			String sql = "Update player set Gender = '" + gender + "' " + " " + " where UserName = '" + username + "';";
			SourceUpdate.line();
			System.out.println("User: " + username + " Changed Gender to: " + gender);
			selectStatement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void getNewActive() {
		
		try {
			Connection con =  Database.getConnection();
			System.out.println("[Y]-move to Active");
			System.out.println("[N]-move to Non Active");
			String YN = sc.next();
			selectStatement = con.createStatement();
			String sql = "Update player set Active = '" + YN + "' " + " " + " where UserName = '" + username + "';";
			SourceUpdate.line();
			System.out.println("User: " + username + " Changed Gender to: " + YN);
			selectStatement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void getNewTeam() {
		
		try {
			System.out.println("Enter new TeamID:");
			System.out.println("[A]-Team A");
			System.out.println("[B]-Team B");
			System.out.println("[C]-Team C");
			SourceUpdate.line();
			
			System.out.print("\nSelect your action: ");
			String teamid = sc.next();
			String teamname;
			switch (teamid.toUpperCase()) {
			case "A":
				teamname = "Team A";
				break;
			case "B":
				teamname = "Team B";
				break;
			case "C":
				teamname = "Team C";
				break;

			default:
				teamname = "No Team";
				break;
			}
			Connection con =  Database.getConnection();
			selectStatement = con.createStatement();
			String sql = "Update team set TeamID = '" + teamid + "', TeamName = '" + teamname + "' " + " " + " where UserName = '" + username + "';";
			SourceUpdate.line();
			selectStatement.executeUpdate(sql);
			System.out.println("User: " + username + " Changed Team to: " + teamname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}

	

}
