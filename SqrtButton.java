import javax.swing.*;

public class SqrtButton extends JButton implements Operation1Number{

    public static final String displayName = "\u221A";

    /**
     * Constructor
     */
    SqrtButton(){
        super(displayName);
    }

    /**
     * Square Root
     * @param x
     * @return \u221A(x)
     */
    @Override
    public double performOperation(double x) {
        return Math.sqrt(x);
    }
}
