import javax.swing.*;

public class SqrtButton extends JButton implements Operation1Number{

    public static final String displayName = "\u221A";

    SqrtButton(){
        super(displayName);
    }

    @Override
    public double performOperation(double x) {
        return Math.sqrt(x);
    }
}
