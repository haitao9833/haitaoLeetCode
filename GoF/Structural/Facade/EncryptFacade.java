package GoF.Structural.Facade;

public class EncryptFacade extends AbstractionEncryptFacade {
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    public void fileEncrypt(String src , String desc) {
        String plainText = reader.read(src);
        String encryptText = cipher.encrypt(plainText);
        writer.write(encryptText , desc);
    }
}
