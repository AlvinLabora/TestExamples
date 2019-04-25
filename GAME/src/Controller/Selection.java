package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao_Implement.DAOP;
import Dao_Implement.ImpDAO;
import Service.SourceUpdate;
import Utility.Player;

public class Selection {
	static List<Player> getAll = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void selectionF() {
		DAOP ccDao = new ImpDAO();

		System.out.println("==================================");
		System.out.println("[1]-View All Players");
		System.out.println("[2]-Search Player");
		System.out.println("[3]-View Active/NonActive Players");
		System.out.println("[4]-Add Player");
		System.out.println("[5]-Update Player");
		System.out.println("[6]-Delete Player");
		System.out.println("[0]-Exit");
		SourceUpdate.line();
		System.out.print("Select your action: ");
		int sel = sc.nextInt();
		SourceUpdate.line();
		while (true) {
			if (sel == 1) {
				getAll =ccDao.getplayers();
				for (Player player : getAll) {
					System.out.println(player.toString());

				}
				SourceUpdate.line();
				break;
			} else if (sel == 2) {
				getAll=ccDao.getSinglePlayer();
				for (Player player : getAll) {
					System.out.println(player.toString());
				}
				SourceUpdate.line();
				break;
			} else if (sel == 3) {
				getAll=ccDao.getAllYNPlayers();
				for (Player player : getAll) {
					System.out.println(player.toString());
				}
				SourceUpdate.line();
				break;
			} else if (sel == 4) {
				ccDao.addPlayer();
				SourceUpdate.line();
				break;
			} else if (sel == 5) {
				ccDao.updatePlayer();
				SourceUpdate.line();
				break;
			} else if (sel == 6) {
				ccDao.deletePlayer();
				SourceUpdate.line();
				break;
			} else if (sel == 0) {
				System.exit(0);
			} else {
				System.out.println("Action not recognize");
				SourceUpdate.line();
				break;
			}

		}
		selectionF();
		sc.close();

	}

	public static void selectionUpdate() {

		System.out.println("[1]-Edit Name");
		System.out.println("[2]-Edit LastName");
		System.out.println("[3]-Edit Gender");
		System.out.println("[4]-Edit Active(Y/N)");
		System.out.println("[5]-Edit Team");
		System.out.println("[0]-Back to Menu");

	}

	public static void main(String[] args) {
		selectionF();

	}

}