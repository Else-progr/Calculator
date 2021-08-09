import javax.swing.*;

public class AddButton extends JButton implements Operation2Numbers {

    public static final String displayName = "+";

    /**
     * Constructor
     */
    AddButton(){
        super(displayName);
    }

    /**
     * Addition
     * @param x
     * @param y
     * @return x+y
     */
    @Override
    public double performOperation(double x, double y) {
        return (x+y);
    }

}
