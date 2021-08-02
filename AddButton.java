import javax.swing.*;

public class AddButton extends JButton {

    public static final String displayName = "+";

    AddButton(){
        new JButton(displayName);
    }

    public double performOperation(double x, double y) {
        return (x+y);
    }

}
