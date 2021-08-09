import javax.swing.*;

public class MultButton extends JButton implements Operation2Numbers {

    public static final String displayName = "*";

    /**
     * Constructor
     */
    MultButton(){
        super(displayName);
    }

    /**
     * Multiplication
     * @param x
     * @param y
     * @return x*y
     */
    @Override
    public double performOperation(double x, double y) {

        return x*y;
    }

}
