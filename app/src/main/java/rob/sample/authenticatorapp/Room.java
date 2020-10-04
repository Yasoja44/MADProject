package rob.sample.authenticatorapp;

public class Room {

    int image;
    String f1;
    String f2;
    String f3;
    String f4;
    String price;
    String rType;
    String rno;
    String uid;

    public Room() {

    }

    public Room(int image, String f1, String f2, String f3, String f4, String price, String rType, String rno,String uid) {
        this.image = image;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.price = price;
        this.rType = rType;
        this.rno = rno;
        this.uid = uid;
    }

    public int getImage() {
        return image;
    }

    public String getF1() {
        return f1;
    }

    public String getF2() {
        return f2;
    }

    public String getF3() {
        return f3;
    }

    public String getF4() {
        return f4;
    }

    public String getPrice() {
        return price;
    }

    public String getrType() {
        return rType;
    }

    public String getRno() {
        return rno;
    }

    public String getUid() {
        return uid;
    }
}
