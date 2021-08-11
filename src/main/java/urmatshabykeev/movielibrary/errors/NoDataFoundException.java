package urmatshabykeev.movielibrary.errors;

import org.omg.SendingContext.RunTime;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(){
        super("No data found");
    }
}
