package applicationConsole;

import command.*;
import viewConsole.IUsersDialog;

/**
 * 
 * @author tamko
 *
 */
public class Controller {

	private final IUsersDialog userDialog;
	private final CommandMap map;
	//private final GameBooKCommandMapSousMain gameSous;final GameBooKCommandMapSousMain gameSous	this.gameSous= gameSous;
	private boolean verify;
	public Controller(final IUsersDialog userDialog, final CommandMap command) {
		this.userDialog = userDialog;
		this.map=command;
	
	}
	public void start() {
		userDialog.displayLine("Bienvenue !");
		while(true) {
			userDialog.menuPrincipal();
				tryToExecute(userDialog.displayInteger("Encodez une Option : "));
		}
	}
	private void tryToExecute(final int numCmd ) {
		doExecute(map.getCommand(numCmd));
//		if(verify)	
//			sousMain();	 
		
			
	}
//		private void sousMain() {
//			int choix=0;
//			do {
//				userDialog.sousMenu();
//				choix= userDialog.displayInteger("Choisi une modification ? ");
//				if(choix!=5)
//					tryToExecuteSousMain(choix);
//			
//			} while (choix!=5);
//		}
//		
//	private void tryToExecuteSousMain(final int cmd) {
//		doExecute(gameSous.get(cmd));
//		
//	}
	private void doExecute(final CommandBook command) {
		if(command != null) {
			command.execute();
			//verify= command.isVerify();
		} else {
			userDialog.displayLine("Option non valide !");
		}
	}


}
//exerci page 34;