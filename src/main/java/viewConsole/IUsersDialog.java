package viewConsole;

public interface IUsersDialog {

	void menuPrincipal();
	void sousMenu();
	public String readLine(String fmt, Object... args);
	public char readChar(String chaine, Object... args);
	void display(String message,Object... args);
	void displayLine(String message,Object... args);
	void displayBook(String message,String para,Object... args);
	public int displayInteger(String fmt, Object... args);
	void exit();
	

}