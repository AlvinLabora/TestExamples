package Dao_Implement;

import java.util.List;

import Utility.Player;

public interface DAOP {
	List<Player> getplayers();

	List<Player> getAllYNPlayers();

	List<Player> getSinglePlayer();

	Player updatePlayer();

	List<Player> deletePlayer();

	List<Player> addPlayer();

}
