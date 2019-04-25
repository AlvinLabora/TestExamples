package Dao_Implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.Selection;
import Service.Database;
import Service.SourceUpdate;
import Utility.Player;

public class ImpDAO implements DAOP {

	public static String username = null;
	public Statement selectStatement = null;
	public ResultSet results = null;
	public Connection cn = null;
	Scanner sc = new Scanner(System.in);

	@Override
	public List<Player> getplayers() {

		List<Player> players = new ArrayList<>();

		Connection conn = Database.getConnection();

		String sql = "select * from player JOIN team ON player.UserName = team.UserName";
		try {
			selectStatement = conn.createStatement();
			results = selectStatement.executeQuery(sql);

			while (results.next()) {
				String username = results.getString("UserName");
				String name = results.getString("Name");
				String lastname = results.getString("LastName");
				String gender = results.getString("Gender");
				String id = results.getString("id");
				String active = results.getString("Active");
				String teamid = results.getString("TeamID");
				String teamname = results.getString("TeamName");

				Player player = new Player(username, name, lastname, gender, id, active, teamid, teamname);
				players.add(player);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return players;
	}

	@Override
	public List<Player> getSinglePlayer() {
		List<Player> players = new ArrayList<>();
		System.out.println("=============SEARCH FOR PLAYER=============");
		System.out.println("\n");

		System.out.println("Enter username: ");
		String username = sc.next();
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

				Player player = new Player(username, name, lastname, gender, id, active, teamid, teamname);
				players.add(player);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return players;
	}

	@Override
	public Player updatePlayer() {

		System.out.println("=============UPDATE PLAYER=============");
		System.out.println("\n");
		getSinglePlayer();
		SourceUpdate.line();

		do {

			Selection.selectionUpdate();
			int sel = sc.nextInt();

			if (sel == 1) {
				SourceUpdate.getNewName();
				SourceUpdate.ViewUpdate();
				SourceUpdate.line();
			} else if (sel == 2) {
				SourceUpdate.getNewLastName();
				SourceUpdate.ViewUpdate();
				SourceUpdate.line();
			} else if (sel == 3) {
				SourceUpdate.getNewGender();
				SourceUpdate.ViewUpdate();
				SourceUpdate.line();
			} else if (sel == 4) {
				SourceUpdate.getNewActive();
				SourceUpdate.ViewUpdate();
				SourceUpdate.line();
			} else if (sel == 5) {
				SourceUpdate.getNewTeam();
				SourceUpdate.ViewUpdate();
				SourceUpdate.line();
			} else if (sel == 0) {

				return null;
			} else {
				System.out.println("(>.<)");
				SourceUpdate.line();
			}
		} while (true);
	}

	@Override
	public List<Player> getAllYNPlayers() {
		List<Player> players = new ArrayList<>();
		
		try {Connection conn = Database.getConnection();
			System.out.println("=============SEARCH PLAYER ACTIVE/NOT ACTIVE=============");
			System.out.println("\n");
			System.out.println("[Y]- view active players");
			System.out.println("[N]- view not active players");
			System.out.println("");
			String YN = sc.next();

			
			String sql = "select * from player JOIN team ON player.UserName = team.UserName where player.Active = '"
					+ YN + "'";

			selectStatement = conn.createStatement();
			results = selectStatement.executeQuery(sql);

			while (results.next()) {
				String username = results.getString("UserName");
				String name = results.getString("Name");
				String lastname = results.getString("LastName");
				String gender = results.getString("Gender");
				String id = results.getString("id");
				String active = results.getString("Active");
				String teamid = results.getString("TeamID");
				String teamname = results.getString("TeamName");

				Player player = new Player(username, name, lastname, gender, id, active, teamid, teamname);
				players.add(player);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return players;

	}

	@Override
	public List<Player> deletePlayer() {

		System.out.println("=============DELETE PLAYER=============");
		System.out.println("\n");
		getSinglePlayer();

		System.out.println("[1]-YES ");
		System.out.println("[2]-NO");
		int comf = sc.nextInt();
		if (comf == 1) {
			SourceUpdate.delPlayer();

		} else if (comf == 2) {
			System.out.println("UserName: " + username + " failed deleting.. ");
		}
		System.out.println("=============DELETE MORE PLAYER?=============");
		System.out.println("[1]-Yes");
		System.out.println("[2]-No");
		int del = sc.nextInt();
		if (del == 1) {
			return deletePlayer();
		}
		if (del == 2) {
			return null;
		}
		return null;
	}

	@Override
	public List<Player> addPlayer() {

		Connection con = Database.getConnection();

		System.out.println("=============CreateAccount=============");
		System.out.println("\n");

		System.out.print("Enter UserName :");
		String username = sc.next();
		System.out.print("Enter Name :");
		String name = sc.next();
		System.out.print("Enter LastName :");
		String lastname = sc.next();
		System.out.print("Enter Gender :");
		String gender = sc.next();

		System.out.println("=============SELECT YOUR TEAM=============");
		System.out.println("[A] Team A");
		System.out.println("[B] Team B");
		System.out.println("[C] Team C");
		String teamid = sc.next();
		String teamname = null;

		switch (teamid) {
		case "A":
			teamname = "Team A";
			break;
		case "B":
			teamname = "Team B";
			break;
		case "C":
			teamname = "Team C";
		}
		String sql1 = "insert into player set UserName ='" + username + "', Name ='" + name + "', LastName = '"
				+ lastname + "', Gender = '" + gender + "'";
		String sql2 = "insert into team set UserName ='" + username + "', TeamID ='" + teamid + "', TeamName ='"
				+ teamname + "' ";
		try {
			selectStatement = con.createStatement();

			selectStatement.executeUpdate(sql1);
			selectStatement.executeUpdate(sql2);

			System.out.println("Username: " + username + "  Added.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("=============Create More Account?=============");
		System.out.println("[1]-Yes");
		System.out.println("[2]-No");
		int add = sc.nextInt();
		if (add == 1) {
			return addPlayer();
		} else if (add == 2) {
			return null;
		}
		return null;
	}

}