package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import controllers.MorphiaObject;


@Entity(value = "person", noClassnameStored=true )
public class Person extends BaseEntity {

    @Id
    private String password;
    private String firstName;
    private String lastName;
    private String location;

    public Person() {

    }

    public Person(String password, String firstName, String lastName, String location) {
        super();
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public void save() {
        System.out.println(this.firstName);
        MorphiaObject.datastore.save(this);
    }



}