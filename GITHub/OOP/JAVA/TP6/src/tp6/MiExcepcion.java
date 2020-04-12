package tp6;


public class MiExcepcion extends Exception{
    String message;

    public MiExcepcion(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    
}
