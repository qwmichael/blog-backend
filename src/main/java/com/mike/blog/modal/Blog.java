package com.mike.blog.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
/**
 * This is the entity for blog
 *
 * @author Michael Ng
 *
 */
@Entity
public class Blog {
    @Id
    @GeneratedValue //Auto generate primary key Id
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
    @NotBlank
    private Date date;
    @NotBlank
    private String creator;

    private String image;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Blog() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
