package GoF.Creational.AbstractFactory;

public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}
