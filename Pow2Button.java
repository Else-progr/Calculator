import javax.swing.*;

public class Pow2Button extends JButton implements Operation1Number {

    public static final String displayName = "^2";

    /**
     * Constructor
     */
    Pow2Button(){
        super(displayName);
    }

    /**
     * Power with component 2
     * @param x
     * @return x^2
     */
    @Override
    public double performOperation(double x) {
        return Math.pow(x,2);
    }
}
