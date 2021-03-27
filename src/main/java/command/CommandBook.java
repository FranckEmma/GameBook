package command;

import viewConsole.IUsersDialog;

public abstract class  CommandBook {

	private int numCommand;
	protected IUsersDialog userDialog;
	
	
	public CommandBook(final int numCommand, IUsersDialog userDialog) {
		this.numCommand= numCommand;
		this.userDialog= userDialog;
		
	}
	public int getNumCommand() {
		return numCommand;
	}
	
	public boolean hasNumber(final int numCommand) {
		return this.numCommand==numCommand;
	}
	public abstract void execute();
}
