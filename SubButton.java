import javax.swing.*;

public class SubButton extends JButton implements Operation2Numbers {

    public static final String displayName = "-";

    /**
     * Constructor
     */
    SubButton(){
        super(displayName);
    }

    /**
     * Subtraction
     * @param x
     * @param y
     * @return x-y
     */
    @Override
    public double performOperation(double x, double y) {
        return (x-y);
    }

}
