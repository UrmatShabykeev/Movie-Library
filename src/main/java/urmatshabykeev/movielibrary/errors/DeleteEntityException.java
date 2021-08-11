package urmatshabykeev.movielibrary.errors;

public class DeleteEntityException extends RuntimeException {
    public DeleteEntityException(String entity, Long id){
        super("Error when deleting " + entity + " with id = " + id);
    }
}
