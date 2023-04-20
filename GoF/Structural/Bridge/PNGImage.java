package GoF.Structural.Bridge;

public class PNGImage extends Image {
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        imp.doPaint(matrix);
        System.out.println(fileName + " 格式为 PNG");
    }
}
