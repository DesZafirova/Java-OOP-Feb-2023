package exceptionsAndErrorHandling;

public class NegativeSQRTInputException extends RuntimeException{

    public NegativeSQRTInputException(String message){
        super(message);
    }
    public NegativeSQRTInputException(String message, Exception cause){
        super(message, cause);
    }

}
