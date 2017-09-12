package spring.exception;

public class AgendaException extends Exception{
	private static final long serialVersionUID = 7371143829202906345L;
	private String page;
	private String message;
	public AgendaException(String page, String message) {
		this.page = page;
		this.message = message;
	}
	public AgendaException() {
	
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
