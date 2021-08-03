import javax.swing.*;

public class SubButton extends JButton implements Operation2Numbers {

    public static final String displayName = "-";

    SubButton(){
        super(displayName);
    }

    @Override
    public double performOperation(double x, double y) {
        return (x-y);
    }

}
