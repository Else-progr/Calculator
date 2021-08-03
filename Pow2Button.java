import javax.swing.*;

public class Pow2Button extends JButton implements Operation1Number {

    public static final String displayName = "^2";

    Pow2Button(){
        super(displayName);
    }

    @Override
    public double performOperation(double x) {
        return Math.pow(x,2);
    }
}
