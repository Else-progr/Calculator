import java.awt.GridLayout;
import javax.swing.JPanel;

public class Panel {
	
	private JPanel panelNumber;
	private JPanel panelOperator;
	private JPanel panelClear;
//	private JPanel panel;
	
	Panel( CalculatorButtons buttons ){
		
	    panelClear = new JPanel();
	    panelClear.setBounds(50, 230, 300, 50);
	    panelClear.setLayout(new GridLayout());
		
	    panelOperator = new JPanel();
	    panelOperator.setBounds(50, 300, 300, 50*getPanelOperatorSize(buttons));
	    panelOperator.setLayout(new GridLayout(getPanelOperatorSize(buttons),4));
	    
		panelNumber = new JPanel();
		panelNumber.setBounds(50, 350+50*getPanelOperatorSize(buttons), 300, 200);
	    panelNumber.setLayout(new GridLayout(4,3));
	   
	    
	    panelNumber.add(buttons.getButtons(7));
		panelNumber.add(buttons.getButtons(8));
		panelNumber.add(buttons.getButtons(9));
		panelNumber.add(buttons.getButtons(4));
		panelNumber.add(buttons.getButtons(5));
		panelNumber.add(buttons.getButtons(6));
		panelNumber.add(buttons.getButtons(1));
		panelNumber.add(buttons.getButtons(2));
		panelNumber.add(buttons.getButtons(3));
		panelNumber.add(buttons.getButtons(10)); // '.'
		panelNumber.add(buttons.getButtons(0));
		panelNumber.add(buttons.getButtons(11)); // '='
		
		panelClear.add(buttons.getButtons(13));
		panelClear.add(buttons.getButtons(12));
		
		for(int i=14; i< buttons.getSize(); i++) {
			panelOperator.add(buttons.getButtons(i));
		}
		
	}
	
	
	JPanel getPanelNumbers() {
		return panelNumber;
	}
	
	JPanel getPanelClear() {
		return panelClear;
	}
	
	JPanel getPanelOperators() {
		return panelOperator;
	}
	
	int getPanelOperatorSize( CalculatorButtons buttons ) {
		return (int)(((buttons.getSize()-13)/4)+1);
	}

}
