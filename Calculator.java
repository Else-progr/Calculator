//import java.awt.*;
//import java.awt.GridLayout;
//import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author hanna
 *
 */
public class Calculator implements ActionListener{
	
	private CalculatorButtons buttons;
	private Panel panel;
	
	private JFrame window;
	
	
	private ArrayList<JButton> operatorSeq = new ArrayList<>();
	private ArrayList<Double> numberSeq = new ArrayList<>();
	
	private JTextField inputBox;
	private JTextField outputBox1;
	private JTextField outputBox2;
	
	private boolean dot = false;
//	private boolean newOperation = false;
	
	
	Calculator(CalculatorButtons buttons){
		
		this.buttons = buttons;
		
		panel = new Panel(buttons);
		
		
		window = new JFrame("Calculator");
		window.setSize(400, 600+50*panel.getPanelOperatorSize(buttons));
		window.setLayout(null);
		window.setVisible(true);
		
		window.add(panel.getPanelNumbers());
		window.add(panel.getPanelOperators());
		window.add(panel.getPanelClear());
		

		inputBox = new JTextField();
		inputBox.setBounds(50, 160, 300, 50);
		inputBox.setVisible(true);
		window.add(inputBox);
		
		outputBox1 = new JTextField();
		outputBox1.setBounds(50, 90, 300, 50);
		outputBox1.setVisible(true);
		outputBox1.setEditable(false);
		window.add(outputBox1);
		
		outputBox2 = new JTextField();
		outputBox2.setBounds(50, 40, 300, 40);
		outputBox2.setVisible(true);
		outputBox2.setEditable(false);
		window.add(outputBox2);
		
		
		for(int i=0; i< buttons.getSize(); i++) {
			buttons.getButtons(i).addActionListener(this);
		} // end for
		
	} // end constructor Calculator



	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton pressed = (JButton) event.getSource();

		/*
		 * 'CE' gedrückt:
		 * Löschen der Eingabe-Box, beider Ausgabe-Boxen sowie die Nummern- als auch die Operatoren-Folge
		 */
		if( pressed == buttons.getButtons(13) /*Kill*/) {
			inputBox.setText("");
			outputBox1.setText("");
			outputBox2.setText("");
			operatorSeq.clear();
			numberSeq.clear();
//			newOperation = false;
		} // end if

		/*
		 * 'C' gedrückt:
		 * Löschen der Eingabe-Box
		 * beider Ausgabe-Boxen sowie die Nummern- als auch die Operatoren-Folge bleiben erhalten!
		 */
		if( pressed == buttons.getButtons(12) /*Clear*/ ) {
			inputBox.setText("");
			dot = false;
		} // end if
		
		/*
		 * '.' gedrückt:
		 * 
		 */
		if ( pressed == buttons.getButtons(10) /* Dot */ && !dot ) {
			inputBox.setText(inputBox.getText()+event.getActionCommand());
			dot = true;
		}else if( pressed != buttons.getButtons(10)  /* Dot */ 
				&& pressed != buttons.getButtons(13) /* Kill */
				&& pressed != buttons.getButtons(12)  /* Clear */	) {

			if (event.getActionCommand().equals("^y")) {
				inputBox.setText(inputBox.getText() + "^");
			}else {
				inputBox.setText(inputBox.getText() + event.getActionCommand());
//				newOperation = false;
			}
		} // end else if
		
//		if( !newOperation ) {
			for (int i = 14; i < buttons.getSize(); i++) {

				if (pressed == buttons.getButtons(i) /* Operators */
						|| pressed == buttons.getButtons(11) /* = */) {

//					if (event.getActionCommand().equals("^y")) {
//						operatorSequence.add("^");
//					} else {
						operatorSeq.add((JButton) event.getSource());
//					}// end else

					outputBox1.setText(outputBox1.getText() + inputBox.getText());
					dot = false;

					if (!event.getActionCommand().equals("\u221A")) {
//						if (!newOperation) {
							numberSeq.add(Double.parseDouble(inputBox.getText().substring(0, inputBox.getText().length() - 1)));
//						}
					}

					inputBox.setText("");
//					newOperation = false;

					break;
				} // end if

			} // end for
//		}


		if( pressed == buttons.getButtons(11) /* = */ ) {
			
			for(int i = 0; i < operatorSeq.size() ; i++ ) {
				var op = operatorSeq.get(i);
				if (op instanceof Operation2Numbers) {
					numberSeq.set(i + 1, ((Operation2Numbers) op).performOperation(numberSeq.get(i), numberSeq.get(i + 1)));
				} else if (op instanceof Operation1Number) {
					numberSeq.set(i, ((Operation1Number) op).performOperation(numberSeq.get(i)));
				} // end else if
			} // end for

			double positionzero = numberSeq.get(numberSeq.size()-1);
			numberSeq.clear();
			operatorSeq.clear();
			numberSeq.add(positionzero);
			outputBox2.setText(outputBox1.getText());
			outputBox1.setText(""+ numberSeq.get(0));
//			newOperation = true;
			
		} // end if
		
		
		
	} // end method actionPerformed

	
} // end class Calculator
