package urmatshabykeev.movielibrary.errors;

public class CreateEntityException extends RuntimeException{
    public CreateEntityException(String entity){
        super("Error when creating " + entity);
    }
}
