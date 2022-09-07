package demo15Exception;

public class RegisterRuntimeException extends RuntimeException{

  public RegisterRuntimeException() {
    super();
  }

  public RegisterRuntimeException(String message) {
    super(message);
  }

}
