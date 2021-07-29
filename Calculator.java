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
public class Calculator /*extends JFrame*/ implements ActionListener{
	
	private CalculatorButtons buttons;
	private Panel panel;
	
	private JFrame window;
	
//	private JPanel panelButtons;
//	private JPanel panelOperator;
	
	
//	private JButton button[];
//	private JButton buttonDot;
//	private JButton buttonClear;
//	private JButton buttonKill;
//	private JButton buttonPlus;
//	private JButton buttonMinus;
//	private JButton buttonDivision;
//	private JButton buttonMultiplication;
//	private JButton buttonEqual;
	
	private ArrayList<String> operatorSequence = new ArrayList<String>();
	private ArrayList<Double> numberSequence = new ArrayList<Double>();
	
	private JTextField inputBox;
	private JTextField outputBox1;
	private JTextField outputBox2;
	
	private boolean dot = false;
	private boolean newOperation = false;
	
	
	Calculator(CalculatorButtons buttons){
		
		this.buttons = buttons;
		
		panel = new Panel(buttons);
		
		window = new JFrame("Calculator");
		window.setSize(400, 600+50*panel.getPanelOperatorSize(buttons));
		window.setLayout(null);
		window.setVisible(true);
		
		
//		panelButtons = new JPanel();
//		panelButtons.setBounds(50, 350, 300, 200);
//	    panelButtons.setLayout(new GridLayout(4,3));
//	    
//	    panelOperator = new JPanel();
//	    panelOperator.setBounds(50, 230, 300, 100);
//	    panelOperator.setLayout(new GridLayout(2,3));
		
//		button = new JButton[10];
//		for( int i = 0; i < 10 ; i++)
//			button[i]= new JButton(i+"");
		
//		buttonClear = new JButton("CE");
//		buttonKill = new JButton("C");
//		
//		buttonPlus = new JButton("+");
//		buttonMinus = new JButton("-");
//		buttonDivision = new JButton("/");
//		buttonMultiplication = new JButton("x");
//		buttonEqual = new JButton("=");
//		buttonDot = new JButton(".");
		
		
//		button[0].setBounds(150, 400, 100, 50);
//		button[1].setBounds(50, 350, 100, 50);
//		button[2].setBounds(150, 350, 100, 50);
//		button[3].setBounds(250, 350, 100, 50);
//		button[4].setBounds(50, 300, 100, 50);
//		button[5].setBounds(150, 300, 100, 50);
//		button[6].setBounds(250, 300, 100, 50);
//		button[7].setBounds(50, 250, 100, 50);
//		button[8].setBounds(150, 250, 100, 50);
//		button[9].setBounds(250, 250, 100, 50);
//		buttonDot.setBounds(50, 400, 100, 50);
//		buttonClear.setBounds(250, 400, 100, 50);	
//		buttonPlus.setBounds(50, 130, 100, 50);
//		buttonMinus.setBounds(150, 130, 100, 50);
//		buttonEqual.setBounds(250, 130, 100, 50);
//		buttonDivision.setBounds(50, 180, 100, 50);
//		buttonMultiplication.setBounds(150, 180, 100, 50);
//		buttonKill.setBounds(250, 180, 100, 50);

		
//		panelButtons.add(buttons.getNumber(7));
//		panelButtons.add(buttons.getNumber(8));
//		panelButtons.add(buttons.getNumber(9));
//		panelButtons.add(buttons.getNumber(4));
//		panelButtons.add(buttons.getNumber(5));
//		panelButtons.add(buttons.getNumber(6));
//		panelButtons.add(buttons.getNumber(1));
//		panelButtons.add(buttons.getNumber(2));
//		panelButtons.add(buttons.getNumber(3));
//		panelButtons.add(buttons.getDot());
//		panelButtons.add(buttons.getNumber(0));
//		panelButtons.add(buttons.getClear());
//		
//		panelOperator.add(buttons.getPlus());
//		panelOperator.add(buttons.getMinus());
//		panelOperator.add(buttons.getEqual());
//		panelOperator.add(buttons.getDivision());
//		panelOperator.add(buttons.getMultiplication());
//		panelOperator.add(buttons.getKill());
		
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
		
		for(int i=0; i< buttons.getSize(); i++)
			buttons.getButtons(i).addActionListener(this);
		
//		buttons.getDot().addActionListener(this);
//		buttons.getPlus().addActionListener(this);
//		buttons.getMinus().addActionListener(this);
//		buttons.getDivision().addActionListener(this);
//		buttons.getMultiplication().addActionListener(this);
//		buttons.getEqual().addActionListener(this);
//		buttons.getDot().addActionListener(this);
//		buttons.getKill().addActionListener(this);
//		buttons.getClear().addActionListener(this);
		
//		for(int i=0; i<10; i++)
//			button[i].addActionListener(this);
//		buttonPlus.addActionListener(this);
//		buttonMinus.addActionListener(this);
//		buttonDivision.addActionListener(this);
//		buttonMultiplication.addActionListener(this);
//		buttonEqual.addActionListener(this);
//		buttonDot.addActionListener(this);
//		buttonKill.addActionListener(this);
//		buttonClear.addActionListener(this);
		
	} // end constructor Calculator



	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton pressed = (JButton)event.getSource();
		
		Operation op = new Operation();
		
		/*
		 * 'CE' gedrückt:
		 * Löschen der Eingabe-Box, beider Ausgabe-Boxen sowie die Nummern- als auch die Operatoren-Folge
		 */
		if( pressed == buttons.getButtons(13) /*Kill*/){ 
			inputBox.setText(""); 
			outputBox1.setText("");
			outputBox2.setText("");
			operatorSequence.clear();
			numberSequence.clear();
			System.out.println("Nr-Seq = "+numberSequence);
			newOperation = false;	
		/*
		 * 'C' gedrückt:
		 * Löschen der Eingabe-Box
		 * beider Ausgabe-Boxen sowie die Nummern- als auch die Operatoren-Folge bleiben erhalten!
		 */
		}else if( pressed == buttons.getButtons(12) /*Clear*/ ) { 
			inputBox.setText("");
			dot = false;
		}// end else if
		
		/*
		 * '.' gedrückt:
		 * 
		 */
		if ( pressed == buttons.getButtons(10) /* Dot */ && dot == false) {
			inputBox.setText(inputBox.getText()+event.getActionCommand());
			dot = true;
		}else if( pressed != buttons.getButtons(10)  /* Dot */ 
				&& pressed != buttons.getButtons(13) /* Kill */
			&& pressed != buttons.getButtons(12)  /* Clear */	) {
		inputBox.setText(inputBox.getText()+event.getActionCommand());
		} // end else if
		
		
		if( pressed == buttons.getButtons(14) /* + */
				|| pressed == buttons.getButtons(15) /* - */
				|| pressed == buttons.getButtons(17) /* x */
				|| pressed == buttons.getButtons(16) /* / */
				|| pressed == buttons.getButtons(11) /* = */ )  {
			operatorSequence.add(event.getActionCommand());
			outputBox1.setText(outputBox1.getText()+inputBox.getText());
			dot = false;
			if(!newOperation) { 
				numberSequence.add(Double.parseDouble(inputBox.getText().substring(0,inputBox.getText().length()-1)));
				System.out.println("Nr-Seq = "+numberSequence);
			} // end if
			inputBox.setText("");
			newOperation = false;
		} // end if
		
		if( pressed == buttons.getButtons(11) /* = */ ) {
			
			for(int i=0; i<operatorSequence.size(); i++) {
				if( operatorSequence.get(i) == "+" ) {
					numberSequence.set(i+1, op.add(numberSequence.get(i),numberSequence.get(i+1)));
				}else if( operatorSequence.get(i) == "-" ) { 
					numberSequence.set(i+1, op.sub(numberSequence.get(i),numberSequence.get(i+1)));
				}else if( operatorSequence.get(i) == "x" ) { 
					numberSequence.set(i+1, op.mult(numberSequence.get(i),numberSequence.get(i+1)));
				}else if( operatorSequence.get(i) == "/" ) { 
					numberSequence.set(i+1, op.div(numberSequence.get(i),numberSequence.get(i+1)));
				}else if( operatorSequence.get(i) == "^2" ) { 
					numberSequence.set(i+1, op.pot(numberSequence.get(i)));
				}else if( operatorSequence.get(i) == "/" ) { 
					numberSequence.set(i+1, op.sqrt(numberSequence.get(i)));
				} // end else if
			} // end for
			
			double positionzero = numberSequence.get(numberSequence.size()-1);
			numberSequence.clear();
			operatorSequence.clear();
			numberSequence.add(positionzero);
			System.out.println("Nr-Seq = "+numberSequence);
			outputBox2.setText(outputBox1.getText());
			outputBox1.setText(""+numberSequence.get(0));
			newOperation = true;
			
		} // end if
		
		
		
	} // end method actionPerformed

	
} // end class
