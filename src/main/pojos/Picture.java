package main.pojos;

public class Picture {
    private Long id;
    private String description;
    private String path;

    public Picture(Long id, String description, String path) {
        this.id = id;
        this.description = description;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
