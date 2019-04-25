
package Utility;

public class Player {
	private String username;
	private String name;
	private String lastname;
	private String gender;
	private String id;
	private String active;
	private String teamid;
	private String teamname;
	
	
	
	
	public Player() {
	
		// TODO Auto-generated constructor stub
	}
	public Player(String username, String name, String lastname, String gender, String id, String active, String teamid,
			String teamname) {
		super();
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.id = id;
		this.active = active;
		this.teamid = teamid;
		this.teamname = teamname;
		
		
	}
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getGender() {
		return gender;
	}
	public String getId() {
		return id;
	}
	public String getActive() {
		return active;
	}
	public String getTeamid() {
		return teamid;
	}
	public String getTeamname() {
		return teamname;
	}
	@Override
	public String toString() {
		return "Player username: =" + username + ", name: =" + name + ", lastname: =" + lastname + ", gender: =" + gender
				+ ", id: =" + id + ", active: =" + active + ", teamid: =" + teamid + ", teamname: =" + teamname + "";
	}
	
	
	
}
