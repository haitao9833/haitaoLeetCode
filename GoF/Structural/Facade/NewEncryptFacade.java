package GoF.Structural.Facade;

public class NewEncryptFacade extends AbstractionEncryptFacade {
    private FileReader reader;
    private NewCipherMachine cipher;
    private FileWriter writer;
    public NewEncryptFacade() {
        reader = new FileReader();
        cipher = new NewCipherMachine();
        writer = new FileWriter();
    }
    @Override
    public void fileEncrypt(String src, String desc) {
        String plainText = reader.read(src);
        String encryptText = cipher.encrypt(plainText);
        writer.write(encryptText , desc);
    }
}
