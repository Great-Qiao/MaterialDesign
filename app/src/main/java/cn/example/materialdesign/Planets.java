package cn.example.materialdesign;


public class Planets {
    private String name;
    private int imgId;

    public Planets(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public Planets() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
