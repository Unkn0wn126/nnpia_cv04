package cz.upce.cv04.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Profile {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id")
    private Set<ProfileHasPosts> profilePosts;

    @Column()
    private String name;

    @Column()
    private String quote;

    @Column()
    private Date dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<ProfileHasPosts> getProfilePosts() {
        return profilePosts;
    }

    public void setProfilePosts(Set<ProfileHasPosts> profilePosts) {
        this.profilePosts = profilePosts;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
