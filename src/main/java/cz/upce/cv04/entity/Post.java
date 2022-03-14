package cz.upce.cv04.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String heading;

    @Column(length = 255)
    private String content;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private Set<PostHasReactions> reactionsOfPost;

    @Column()
    private Date postedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Set<PostHasReactions> getReactionsOfPost() {
        return reactionsOfPost;
    }

    public void setReactionsOfPost(Set<PostHasReactions> reactionsOfPost) {
        this.reactionsOfPost = reactionsOfPost;
    }
}
