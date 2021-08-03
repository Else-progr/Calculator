import javax.swing.*;

public class AddButton extends JButton implements Operation2Numbers {

    public static final String displayName = "+";

    AddButton(){
        super(displayName);
    }

    @Override
    public double performOperation(double x, double y) {
        return (x+y);
    }

}
