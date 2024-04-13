package ntu.anh_63133403.recycleview;

public class LandScape {
    String landImageFilename;
    String landCation;

    public LandScape(String landImageFilename, String landCation) {
        this.landImageFilename = landImageFilename;
        this.landCation = landCation;
    }

    public String getLandImageFilename() {
        return landImageFilename;
    }

    public void setLandImageFilename(String landImageFilename) {
        this.landImageFilename = landImageFilename;
    }

    public String getLandCation() {
        return landCation;
    }

    public void setLandCation(String landCation) {
        this.landCation = landCation;
    }
}
