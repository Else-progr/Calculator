import java.util.ArrayList;
import javax.swing.JButton;

public class CalculatorButtons {
	
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
//	private JButton button[];
	
//	private JButton buttonDot;
//	private JButton buttonClear;
//	private JButton buttonKill;
//	private JButton buttonPlus;
//	private JButton buttonMinus;
//	private JButton buttonDivision;
//	private JButton buttonMultiplication;
//	private JButton buttonEqual;
	
	
	CalculatorButtons(){
		
//		button = new JButton[10];
		for( int i = 0; i < 10 ; i++)
			buttons.add(new JButton(i+""));
		
		buttons.add(new JButton(".")); //10

		buttons.add(new JButton("=")); //11
		
		buttons.add(new JButton("C")); //12
		buttons.add(new JButton("CE"));//13
		
		buttons.add(new JButton("+")); //14
		buttons.add(new JButton("-")); //15
		buttons.add(new JButton("/")); //16
		buttons.add(new JButton("x")); //17
		buttons.add(new JButton("^2")); //18
		buttons.add(new JButton("srqt")); //19
//		buttons.add(new JButton()); //20
//		buttons.add(new JButton()); //21
//		buttons.add(new JButton()); //22
//		buttons.add(new JButton()); //23
//		buttons.add(new JButton()); //24
		
	}
	
	public int getSize() {
		
		return buttons.size();
	}
	
	JButton getButtons(int i) {
		return buttons.get(i);
	}
	
	
//	JButton getNumber(int i) {
//		return buttons.get(i);
//	}
//	
//	JButton getDot() {
//		return buttons.get(10);
//	}
//	
//	JButton getClear() {
//		return buttons.get(11);
//	}
//	
//	JButton getKill() {
//		return buttons.get(12);
//	}
//	
//	JButton getEqual() {
//		return buttons.get(13);
//	}
//	
//	JButton getPlus() {
//		return buttons.get(14);
//	}
//	
//	JButton getMinus() {
//		return buttons.get(15);
//	}
//	
//	JButton getDivision() {
//		return buttons.get(16);
//	}
//	
//	JButton getMultiplication() {
//		return buttons.get(17);
//	}

	
	
	
}



