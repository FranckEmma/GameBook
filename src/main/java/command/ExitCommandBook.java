package command;

import viewConsole.IUsersDialog;

public class ExitCommandBook extends CommandBook{

	public ExitCommandBook( IUsersDialog userDialog) {
		super(5, userDialog);  
		 
	}

	@Override
	public void execute() {
		userDialog.display("Au revoir !");
		userDialog.exit();
		
	}

}
