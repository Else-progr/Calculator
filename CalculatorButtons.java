import java.util.ArrayList;
import javax.swing.JButton;

public class CalculatorButtons {
	
	private ArrayList<JButton> buttons = new ArrayList<>();
	
	
	CalculatorButtons(){
		
		for( int i = 0; i < 10 ; i++)
			buttons.add(new JButton(i+""));
		
		buttons.add(new JButton(".")); //10

		buttons.add(new JButton("=")); //11
		
		buttons.add(new JButton("C")); //12
		buttons.add(new JButton("CE"));//13
		
		buttons.add(new AddButton()); //14
		buttons.add(new SubButton()); //15
		buttons.add(new MultButton()); //16
		buttons.add(new DivButton()); //17
		buttons.add(new Pow2Button()); //18
		buttons.add(new SqrtButton()); //19
//		buttons.add(new PowerButton()); //20
//		buttons.add(new FacButton()); //21
//		buttons.add(new JButton()); //22
//		buttons.add(new JButton()); //23
//		buttons.add(new JButton()); //24
		
	} // end constructor CalculatorButtons
	
	public int getSize() {
		return buttons.size();
	}//end method getSize
	
	JButton getButtons(int i) {
		return buttons.get(i);
	} //end method getButtons
	

} // end class CalculatorButtons