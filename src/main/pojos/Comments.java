package main.pojos;

public class Comments {
    private Long id;
    private Long ownerId;
    private String explanation;

    public Comments(Long id, Long ownerId, String explanation) {
        this.id = id;
        this.ownerId = ownerId;
        this.explanation = explanation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
