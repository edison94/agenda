package spring.exception;

public class AgendaException extends Exception{
	private static final long serialVersionUID = 7371143829202906345L;
	private String message;
	public AgendaException(String message) {
		this.message = message;
	}
	public AgendaException() {
	
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
