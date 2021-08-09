import java.awt.*;
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

	private Panel panel;
	private JFrame window;

	private CalculatorButtons buttons;
	private ArrayList<JButton> operatorSeq = new ArrayList<>();
	private ArrayList<Double> numberSeq = new ArrayList<>();
	
	private JTextField inputBox;
	private JTextField outputBox1;
	private JTextField outputBox2;
	
	private boolean dot = false;
	private boolean newOperation = false;


	/**
	 *
	 * @param buttons
	 */
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
		
	} // end constructor


	/**
	 *
	 * @param event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton pressed = (JButton) event.getSource();

		/* 'CE' gedrückt:
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

		/* 'C' gedrückt:
		 * Löschen der Eingabe-Box
		 * beide Ausgabe-Boxen sowie die Nummern- als auch die Operatoren-Folge bleiben erhalten!
		 */
		if( pressed == buttons.getButtons(12) /*Clear*/ ) {
			inputBox.setText("");
			dot = false;
		} // end if
		
		/* '.' gedrückt
		 * Falls '.' noch nicht gedrückt wurde zuvor (dot=false), wird '.' gesetzt und dot auf TRUE gesetzt
		 */
		if ( pressed == buttons.getButtons(10) /* Dot */ && !dot ) {
			inputBox.setText(inputBox.getText()+event.getActionCommand());
			dot = true;
		} // end if

		/* 'Zahl' gedrückt
		 *
		 */
		for( int i = 0 ; i < 10 ; i++) {
			if ( pressed.equals(buttons.getButtons(i)) ) {
				inputBox.setText(inputBox.getText() + event.getActionCommand());
				newOperation = false;
			} // end if
		}

		for (int i = 14; i < buttons.getSize(); i++) {

			if ( ( pressed.equals(buttons.getButtons(i)) /* Operators */ && newOperation==false )
					|| pressed.equals(buttons.getButtons(11)) /* = */) {

				operatorSeq.add((JButton) event.getSource());

				outputBox1.setText(outputBox1.getText() + inputBox.getText() + event.getActionCommand());
				try {
					if ( !((inputBox.getText()).equals("")) )
						numberSeq.add( Double.parseDouble(inputBox.getText()) );
				}catch (NumberFormatException e){
					System.out.println("Format stimmt nicht");
				}catch(IndexOutOfBoundsException e){
					System.out.println("Index stimmt nicht");
				}
				inputBox.setText("");
				newOperation = true;
				dot = false;

				break;

			} // end if
		} // end for


		/* '=' gedrückt:
		 * Rechnung wird gelöst
		 */
		if( pressed == buttons.getButtons(11) /* = */ ) {
			
			for(int i = 0; i < operatorSeq.size() ; i++ ) {
				var op = operatorSeq.get(i);
				if (op instanceof Operation2Numbers) {
					numberSeq.set(i + 1, ((Operation2Numbers) op).performOperation(numberSeq.get(i), numberSeq.get(i + 1)));
				} else if (op instanceof Operation1Number) {
					numberSeq.set(i, ((Operation1Number) op).performOperation(numberSeq.get(i)));
				} // end else if
			} // end for

			double positionZero = numberSeq.get(numberSeq.size()-1);
			numberSeq.clear();
			operatorSeq.clear();
			numberSeq.add(positionZero);
			outputBox2.setText(outputBox1.getText());
			outputBox1.setText(""+ numberSeq.get(0));
			newOperation = false;
			
		} // end if


	} // end method actionPerformed

} // end class Calculator
