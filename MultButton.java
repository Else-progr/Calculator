import javax.swing.*;

public class MultButton extends JButton implements Operation2Numbers {

    public static final String displayName = "*";

    MultButton(){
        super(displayName);
    }

    @Override
    public double performOperation(double x, double y) {

        return x*y;
    }

}
