import java.awt.GridLayout;
import javax.swing.JPanel;

public class Panel {
	
	private JPanel panelNumber;
	private JPanel panelOperator;
	private JPanel panelEqualKill;
//	private JPanel panel;
	
	Panel( CalculatorButtons buttons ){
		
		panelNumber = new JPanel();
		panelNumber.setBounds(50, 350, 300, 200);
	    panelNumber.setLayout(new GridLayout(4,3));
	    
	    panelOperator = new JPanel();
	    panelOperator.setBounds(50, 230, 250, 100);
	    panelOperator.setLayout(new GridLayout());
	    
	    panelEqualKill = new JPanel();
	    panelEqualKill.setBounds(300, 230, 50, 100);
	    panelEqualKill.setLayout(new GridLayout(2,1));
	    
	    
	    panelNumber.add(buttons.getButtons(7));
		panelNumber.add(buttons.getButtons(8));
		panelNumber.add(buttons.getButtons(9));
		panelNumber.add(buttons.getButtons(4));
		panelNumber.add(buttons.getButtons(5));
		panelNumber.add(buttons.getButtons(6));
		panelNumber.add(buttons.getButtons(1));
		panelNumber.add(buttons.getButtons(2));
		panelNumber.add(buttons.getButtons(3));
		panelNumber.add(buttons.getButtons(10));
		panelNumber.add(buttons.getButtons(0));
		panelNumber.add(buttons.getButtons(11));
		
		panelEqualKill.add(buttons.getButtons(13));
		panelEqualKill.add(buttons.getButtons(12));
		
		for(int i=14; i< buttons.getSize(); i++) {
			panelOperator.add(buttons.getButtons(i));
		}
		
	}
	
	
	JPanel getPanelNumbers() {
		return panelNumber;
	}
	
	JPanel getPanelEqualKill() {
		return panelEqualKill;
	}
	
	JPanel getPanelOperators() {
		return panelOperator;
	}

}
