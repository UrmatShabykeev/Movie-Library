package urmatshabykeev.movielibrary.errors;

public class UpdateEntityException extends RuntimeException {
    public UpdateEntityException(String entity, Long id){
        super("Error when updating entity " + entity + " with id = " + id);
    }
}
