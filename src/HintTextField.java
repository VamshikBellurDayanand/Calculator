import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/*
 	This is the support class required to display the hint in the input equation field.
 	This class is used in CalculatorView.
 */
public class HintTextField extends JTextField implements FocusListener {
	private final String hint;
	
	/*
	 	This is a constructor and is used to set the hint to the input equation field.
	*/
	public HintTextField(String hint) {
		super.addFocusListener(this);
		this.hint = hint;
	}
	
	/*
	 	This method is overridden and empties the text if focus is present in the input text field.
	*/
	@Override
	public void focusGained(FocusEvent e) {
		if(this.getText().isEmpty() || this.getText().equals(hint)) {
			super.setText("");
		} 
	}
	
	/*
	 	This method is overridden and sets the text of input text field to hint if there is no focus on this and the if text is empty.
	*/
	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) {
			super.setText(hint);
		}
	}
}
