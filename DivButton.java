import javax.swing.*;

public class DivButton extends JButton implements Operation2Numbers {

    public static final String displayName = "/";

    DivButton(){
        super(displayName);
    }

    @Override
    public double performOperation(double x, double y) {
        return x/y;
    }
}
