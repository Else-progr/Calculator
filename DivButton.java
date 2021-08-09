import javax.swing.*;

public class DivButton extends JButton implements Operation2Numbers {

    public static final String displayName = "/";

    /**
     * Constructor
     */
    DivButton(){
        super(displayName);
    }

    /**
     * Division
     * @param x
     * @param y
     * @return x/y
     */
    @Override
    public double performOperation(double x, double y) {
        return x/y;
    }
}
