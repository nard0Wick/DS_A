package main.pojos;

public class Dimensions {
    private float width;
    private float height;
    private float length;
    private float weight;
    private String unit;
    private String weightUnit;

    public Dimensions(float width, float height, float length, float weight, String unit, String weightUnit) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.unit = unit;
        this.weightUnit = weightUnit;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
}
