package info.smartkit.redolent_moo.domains;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by yangboz on 10/19/15.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long longId = 100;

    public User(String id) {
        this.setId(id);
    }

    public User() {

    }

    private String id;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String name;

    @NotEmpty
    private String publisher;

    //    @JsonSubTypes.Type(value = org.jadira.usertype.dateandtime.joda.PersistentDateTime.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime dateOfPublication;

    private String description;

    private String photo;

    public static String generateNextId() {
        return String.valueOf(longId++);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public DateTime getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(DateTime dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Constructors

    // Getters & Setters
}
