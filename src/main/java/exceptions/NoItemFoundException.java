package exceptions;

public class NoItemFoundException extends Exception{
    public NoItemFoundException(String errorMessage){
        super(errorMessage);
    }
}
