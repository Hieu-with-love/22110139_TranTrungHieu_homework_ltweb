package devzeus.com.webapp.models;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String image;
    private int status;

    public Category(int id, String name, String image, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
    }

    public Category(){

    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", image=" + image + ", status=" + status + "]";
    }
}
