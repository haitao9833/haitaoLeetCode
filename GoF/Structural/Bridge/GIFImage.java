package GoF.Structural.Bridge;

public class GIFImage extends Image {
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        imp.doPaint(matrix);
        System.out.println(fileName + " 格式为 GIF");
    }
}
