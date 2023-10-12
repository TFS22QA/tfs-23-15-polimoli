package person.models;

public class FullName extends Param{
    private final String firstName, lastName, middleName;
    public FullName(String firstName, String lastName, String middleName) {
        this.firstName =  firstName;
        this.lastName =  lastName;
        this.middleName =  middleName;
    }
}
