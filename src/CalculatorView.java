import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class CalculatorView extends JFrame {

	private final Font textPlainFont = new Font("Times New Roman", Font.PLAIN, 18);
	private final Font textBoldFont = new Font("Times New Roman", Font.BOLD, 18);
	private final String[] colorList = {"BLACK", "RED", "GREEN", "BLUE", "PINK"};
	private final String FRAME_TITLE = "Calculator";
	private final String EQUATION_LABEL = "Equation :-";
	private final String EQUATION_LHS = "y = f(x) = ";
	private final String TEXT_FIELD_HINT = "Enter f(x) here";
	private final String SELECT_COLOR_LABEL = "Select Color :-";
	private final String HISTORY_LABEL = "History :-";
	
	private JPanel contentPane;
	
	private JTextField textField_equation;
	private JTextField textField_answer;
	
	private JButton button_nine;
	private JButton button_eight;
	private JButton button_seven;
	private JButton button_six;
	private JButton button_five;
	private JButton button_four;
	private JButton button_three;
	private JButton button_two;
	private JButton button_one;
	private JButton button_zero;
	private JButton button_dot;
	private JButton button_clear;
	private JButton button_plus;
	private JButton button_minus;
	private JButton button_divide;
	private JButton button_multiply;
	private JButton button_exp;
	private JButton button_sqr_root;
	private JButton button_euler;
	private JButton button_pi;
	private JButton button_sin;
	private JButton button_cos;
	private JButton button_tan;
	private JButton button_ln;
	private JButton button_answer;
	private JButton button_enter;
	private JButton button_add;
	private JButton button_load;
	private JButton button_delete;
	
	private JLabel label_equation;
	private JLabel label_equation_lhs;
	private JLabel label_select_color;
	private JLabel label_history;
	
	private JPanel panel_buttons;
	private JPanel panel_history;
	
	private JComboBox<?> comboBox_colors;
	private JList list_history;

	/**
	 	This is the constructor of Calculator View where all the JComponents are created.
	 */
	public CalculatorView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		setTitle(FRAME_TITLE); //Set the Frame Title
		
		contentPane = new JPanel();  //Create the Content Pane
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_buttons = new JPanel(); //Create the first Panel to display the buttons.
		panel_buttons.setBounds(39, 13, 606, 627);
		contentPane.add(panel_buttons);
		
		label_equation = new JLabel(EQUATION_LABEL); //Create the Label of the input Equation.
		label_equation.requestFocusInWindow();
		label_equation.setBounds(167, 13, 168, 36);
		label_equation.setFont(textBoldFont);
		
		label_equation_lhs = new JLabel(EQUATION_LHS); //Create the label of the LHS of the equation
		label_equation_lhs.setBounds(69, 56, 75, 44);
		label_equation_lhs.setFont(textPlainFont);
		
		textField_equation = new HintTextField(TEXT_FIELD_HINT); //Create the text field for the input equation
		textField_equation.setBounds(167, 56, 414, 44);		
		textField_equation.setColumns(10);
		textField_equation.setFont(textPlainFont);
			
		panel_buttons.add(label_equation); //Add the created components to the panel.
		panel_buttons.add(label_equation_lhs);
		panel_buttons.add(textField_equation);
		panel_buttons.setLayout(null);
		
		textField_answer = new HintTextField(""); //Create the text field for the calculator input and output.
		textField_answer.setFont(textPlainFont);
		textField_answer.setColumns(10);
		textField_answer.setBounds(34, 142, 547, 45);
		panel_buttons.add(textField_answer);
		
		button_nine = new JButton("9"); //Create the button 9 and add it to the button panel.
		button_nine.setBounds(34, 226, 81, 52);
		panel_buttons.add(button_nine);
		
		button_eight = new JButton("8"); //Create the button 8 and add it to the button panel.
		button_eight.setBounds(127, 226, 81, 52);
		panel_buttons.add(button_eight);
		
		button_seven = new JButton("7"); //Create the button 7 and add it to the button panel.
		button_seven.setBounds(220, 226, 81, 52);
		panel_buttons.add(button_seven);
		
		button_plus = new JButton("+"); //Create the button + and add it to the button panel.
		button_plus.setBounds(314, 226, 81, 52);
		panel_buttons.add(button_plus);
		
		button_exp = new JButton("^"); //Create the button ^ and add it to the button panel.
		button_exp.setBounds(407, 226, 81, 52);
		panel_buttons.add(button_exp);
		
		button_sin = new JButton("sin"); //Create the button sin and add it to the button panel.
		button_sin.setBounds(500, 226, 81, 52);
		panel_buttons.add(button_sin);
		
		button_six = new JButton("6"); //Create the button 6 and add it to the button panel.
		button_six.setBounds(34, 291, 81, 52);
		panel_buttons.add(button_six);
		
		button_five = new JButton("5"); //Create the button 5 and add it to the button panel.
		button_five.setBounds(127, 291, 81, 52);
		panel_buttons.add(button_five);
		
		button_four = new JButton("4"); //Create the button 4 and add it to the button panel.
		button_four.setBounds(220, 291, 81, 52);
		panel_buttons.add(button_four);
		
		button_minus = new JButton("-"); //Create the button - and add it to the button panel.
		button_minus.setBounds(314, 291, 81, 52);
		panel_buttons.add(button_minus);
		
		button_sqr_root = new JButton("\u221a"); //Create the button for square root and add it to the button panel.
		button_sqr_root.setBounds(407, 291, 81, 52);
		panel_buttons.add(button_sqr_root);
		
		button_cos = new JButton("cos"); //Create the button cosine and add it to the button panel.
		button_cos.setBounds(500, 291, 81, 52);
		panel_buttons.add(button_cos);
		
		button_three = new JButton("3"); //Create the button 3 and add it to the button panel.
		button_three.setBounds(34, 356, 81, 52);
		panel_buttons.add(button_three);
		
		button_two = new JButton("2"); //Create the button 2 and add it to the button panel.
		button_two.setBounds(127, 356, 81, 52);
		panel_buttons.add(button_two);
		
		button_one = new JButton("1"); //Create the button 1 and add it to the button panel.
		button_one.setBounds(220, 356, 81, 52);
		panel_buttons.add(button_one);
		
		button_divide = new JButton("/"); //Create the button divide and add it to the button panel.
		button_divide.setBounds(314, 356, 81, 52);
		panel_buttons.add(button_divide);
		
		button_euler = new JButton("e"); //Create the button for euler symbol and add it to the button panel.
		button_euler.setBounds(407, 356, 81, 52);
		panel_buttons.add(button_euler);
		
		button_tan = new JButton("tan"); //Create the button tan and add it to the button panel.
		button_tan.setBounds(500, 356, 81, 52);
		panel_buttons.add(button_tan);
		
		button_dot = new JButton("."); //Create the button dot and add it to the button panel.
		button_dot.setBounds(34, 421, 81, 52);
		panel_buttons.add(button_dot);
		
		button_zero = new JButton("0"); //Create the button 0 and add it to the button panel.
		button_zero.setBounds(127, 421, 81, 52);
		panel_buttons.add(button_zero);
		
		button_clear = new JButton("C"); //Create the button clear and add it to the button panel.
		button_clear.setBounds(220, 421, 81, 52);
		panel_buttons.add(button_clear);
		
		button_multiply = new JButton("*"); //Create the button Multiply and add it to the button panel.
		button_multiply.setBounds(314, 421, 81, 52);
		panel_buttons.add(button_multiply);
		
		button_pi = new JButton("\u03c0"); //Create the button Pi and add it to the button panel.
		button_pi.setBounds(407, 421, 81, 52);
		panel_buttons.add(button_pi);
		
		button_ln = new JButton("ln"); //Create the button natural log and add it to the button panel.
		button_ln.setBounds(500, 421, 81, 52);
		panel_buttons.add(button_ln);
		
		button_answer = new JButton("ANSWER"); //Create the button answer and add it to the button panel.
		button_answer.setBounds(34, 532, 267, 52);
		panel_buttons.add(button_answer);
		
		button_enter = new JButton("ENTER"); //Create the button enter and add it to the button panel.
		button_enter.setBounds(314, 532, 267, 52);
		panel_buttons.add(button_enter);
				
		panel_history = new JPanel(); //Create the new panel for storing, deleting and loading history and also to 									
		panel_history.setLayout(null); //accomodate the combo box.
		panel_history.setBounds(705, 13, 476, 627);
		contentPane.add(panel_history);
		
		button_add = new JButton("ADD"); //Create the button add and add it to the history panel.
		button_add.setBounds(37, 534, 119, 47);
		panel_history.add(button_add);
		
		button_delete = new JButton("DELETE"); //Create the button delete and add it to the history panel.
		button_delete.setBounds(296, 534, 130, 47);
		panel_history.add(button_delete);
		
		label_select_color = new JLabel(SELECT_COLOR_LABEL); //Create the label select color and add it to the history panel.
		label_select_color.setBounds(172, 13, 153, 33);
		panel_history.add(label_select_color);
		label_select_color.setFont(textBoldFont);
		
		comboBox_colors = new JComboBox<Object>(colorList); //Create the combo box and add it to the history panel.
		comboBox_colors.setBounds(37, 51, 389, 52); // to display the colors in a list
		panel_history.add(comboBox_colors);		
		
		label_history = new JLabel(HISTORY_LABEL); //Create the button add and add it to the history panel.
		label_history.setBounds(176, 132, 168, 33);
		panel_history.add(label_history);
		label_history.setFont(textBoldFont);
		
		button_load = new JButton("LOAD"); //Create the button load and add it to the history panel.
		button_load.setBounds(157, 534, 137, 47);
		panel_history.add(button_load);		
		
		list_history = new JList(); //Create the list and add it to the history panel to show the history of the equations.
		list_history.setBounds(37, 166, 389, 336);
		list_history.setFont(textPlainFont);
		panel_history.add(list_history);
				
	}

	/*
	 	This is a getter method to get the clear button;
	*/
	public JButton getButton_clear(){
		return button_clear;
	}

	/*
	 	This is a getter method to get the hint;
	*/
	public String getTextField_hint() {
		return TEXT_FIELD_HINT;
	}	

	/*
	 	This is a getter method to get the text field equation;
	*/
	public String getTextField_equation() {
		return textField_equation.getText();
	}
	
	/*
	 	This is a setter method to set the equation to the equation field;
	*/
	public void setTextField_equation(String inputString) {
		textField_equation.setText(inputString);
		textField_equation.setEditable(true);
	}
	
	/*
	 	This is a getter method to get the answer from the input field of the calculator
	*/
	public String getTextField_answer() {
		return this.textField_answer.getText();
	}
	
	/*
	 	This is a setter method to set the answer to the input field of the calculator
	*/
	public void setTextField_answer(String answer) {
		this.textField_answer.setText(answer);
	}
	
	/*
	 	This is a getter method to get the sin button.
	*/
	public JButton getButton_sin() {
		return button_sin;
	}

	/*
	 	This is a setter method to set the sin button.
	*/
	public void setButton_sin(JButton button_sin) {
		this.button_sin = button_sin;
	}

	/*
	 	This is a getter method to get the cos button.
	*/
	public JButton getButton_cos() {
		return button_cos;
	}

	/*
	 	This is a setter method to set the cos button.
	*/
	public void setButton_cos(JButton button_cos) {
		this.button_cos = button_cos;
	}
	
	/*
	 	This is a getter method to get the tan button.
	*/
	public JButton getButton_tan() {
		return button_tan;
	}

	/*
	 	This is a setter method to set the tan button.
	*/
	public void setButton_tan(JButton button_tan) {
		this.button_tan = button_tan;
	}
	
	/*
	 	This is a getter method to get the natural log button.
	*/
	public JButton getButton_ln() {
		return button_ln;
	}

	/*
	 	This is a setter method to set the natural log button.
	*/
	public void setButton_ln(JButton button_ln) {
		this.button_ln = button_ln;
	}

	/*
	 	This is a getter method to get the load button.
	*/
	public JButton getButton_load() {
		return button_load;
	}

	/*
	 	This is a setter method to set the load button.
	*/
	public void setButton_load(JButton button_load) {
		this.button_load = button_load;
	}

	/*
	 	This is a getter method to get the delete button.
	*/
	public JButton getButton_delete() {
		return button_delete;
	}

	/*
	 	This is a setter method to set the delete button.
	*/
	public void setButton_delete(JButton button_delete) {
		this.button_delete = button_delete;
	}

	/*
	 	This is a setter method to set the text field of input and output for calculator.
	*/
	public void setTextField_answer(JTextField textField_answer) {
		this.textField_answer = textField_answer;
	}

	/*
	 	This method is used to Add the listeners for button 9.
	*/
	void addListenerForNine(ActionListener listenForNine) {
		button_nine.addActionListener(listenForNine);
	}
	
	/*
	 	This method is used to Add the listeners for button 8.
	*/
	void addListenerForEight(ActionListener listenForEight) {
		button_eight.addActionListener(listenForEight);
	}

	/*
	 	This method is used to Add the listeners for button 7.
	*/
	void addListenerForSeven(ActionListener listenForSeven) {
		button_seven.addActionListener(listenForSeven);
	}
	
	/*
	 	This method is used to Add the listeners for button 6.
	*/
	void addListenerForSix(ActionListener listenForSix) {
		button_six.addActionListener(listenForSix);
	}
	
	/*
	 	This method is used to Add the listeners for button 5.
	*/
	void addListenerForFive(ActionListener listenForFive) {
		button_five.addActionListener(listenForFive);
	}
	
	/*
	 	This is the getter method to get the square root button.
	*/
	public JButton getButton_sqr_root() {
		return button_sqr_root;
	}

	/*
	 	This is the getter method to get the pi button.
	*/
	public JButton getButton_pi() {
		return button_pi;
	}

	/*
	 	This is the getter method to get the combo box.
	*/
	public JComboBox<?> getComboBox() {
		return comboBox_colors;
	}
	
	/*
	 	This is the getter method to get the text field for the equation.
	*/
	public JTextField getEquationTextField() {
		return textField_equation;
	}

	/*
	 	This is the getter method to get the text field for the answer.
	*/
	public JTextField getAnswerTextField() {
		return textField_answer;
	}
	
	/*
	 	This is the getter method to get the answer button.
	*/
	public JButton getButton_answer() {
		return button_answer;
	}
	
	/*
	 	This is the getter method to get the enter button.
	*/
	public JButton getButton_enter() {
		return button_enter;
	}

	/*
	 	This is the getter method to get the add button.
	*/
	public JButton getButton_add() {
		return button_add;
	}

	/*
	 	This is the getter method to get the history list.
	*/
	public JList getList_history() {
		return list_history;
	}

	/*
	 	This is the setter method to set the history list.
	*/
	public void setList_history(JList list_history) {
		this.list_history = list_history;
	}
	
	/*
	 	This method is used to add the listener for button 4.
	*/
	void addListenerForFour(ActionListener listenForFour) {
		button_four.addActionListener(listenForFour);
	}
	
	/*
	 	This method is used to add the listener for button 3.
	*/
	void addListenerForThree(ActionListener listenForThree) {
		button_three.addActionListener(listenForThree);
	}
	
	/*
	 	This method is used to add the listener for button 5.
	*/
	void addListenerForTwo(ActionListener listenForTwo) {
		button_two.addActionListener(listenForTwo);
	}
	
	/*
	 	This method is used to add the listener for button 1.
	*/
	void addListenerForOne(ActionListener listenForOne) {
		button_one.addActionListener(listenForOne);
	}
	
	/*
	 	This method is used to add the listener for button 0.
	*/
	void addListenerForZero(ActionListener listenForZero) {
		button_zero.addActionListener(listenForZero);
	}
	
	/*
	 	This method is used to add the listener for button Dot.
	*/
	void addListenerForDot(ActionListener listenForDot) {
		button_dot.addActionListener(listenForDot);
	}
	
	/*
	 	This method is used to add the listener for button Clear.
	*/
	void addListenerForClear(ActionListener listenForClear) {
		button_clear.addActionListener(listenForClear);
	}
	
	/*
	 	This method is used to add the listener for button Plus.
	*/
	void addListenerForPlus(ActionListener listenForPlus) {
		button_plus.addActionListener(listenForPlus);
	}
	
	/*
	 	This method is used to add the listener for button Minus.
	*/
	void addListenerForMinus(ActionListener listenForMinus) {
		button_minus.addActionListener(listenForMinus);
	}
	
	/*
	 	This method is used to add the listener for button Divide.
	*/
	void addListenerForDivide(ActionListener listenForDivide) {
		button_divide.addActionListener(listenForDivide);
	}
	
	/*
	 	This method is used to add the listener for button Multiply.
	*/
	void addListenerForMultiply(ActionListener listenForMultiply) {
		button_multiply.addActionListener(listenForMultiply);
	}
	
	/*
	 	This method is used to add the listener for button Exp.
	*/
	void addListenerForExp(ActionListener listenForExp) {
		button_exp.addActionListener(listenForExp);
	}
	
	/*
	 	This method is used to add the listener for button Euler.
	*/
	void addListenerForEuler(ActionListener listenForEuler) {
		button_euler.addActionListener(listenForEuler);
	}
	
	/*
	 	This method is used to add the listener for button Square Root Symbol.
	*/
	void addListenerForSquareRoot(ActionListener listenForSquareRoot) {
		button_sqr_root.addActionListener(listenForSquareRoot);
	}
	
	/*
	 	This method is used to add the listener for button Pi.
	*/
	void addListenerForPi(ActionListener listenForPi) {
		button_pi.addActionListener(listenForPi);
	}
	
	/*
	 	This method is used to add the listener for button Sine.
	*/
	void addListenerForSine(ActionListener listenForSine) {
		button_sin.addActionListener(listenForSine);
	}
	
	/*
	 	This method is used to add the listener for button Cosine.
	*/
	void addListenerForCosine(ActionListener listenForCosine) {
		button_cos.addActionListener(listenForCosine);
	}
	
	/*
	 	This method is used to add the listener for button Tan.
	*/
	void addListenerForTan(ActionListener listenForTan) {
		button_tan.addActionListener(listenForTan);
	}
	
	/*
	 	This method is used to add the listener for button Natural Log.
	*/
	void addListenerForLog(ActionListener listenForLog) {
		button_ln.addActionListener(listenForLog);
	}
	
	/*
	 	This method is used to add the listener for button Answer.
	*/
	void addListenerForAnswer(ActionListener listenForAnswer) {
		button_answer.addActionListener(listenForAnswer);
	}
	
	/*
	 	This method is used to add the listener for button Enter.
	*/
	void addListenerForEnter(ActionListener listenForEnter) {
		button_enter.addActionListener(listenForEnter);
	}
	
	/*
	 	This method is used to add the listener for button Add.
	*/
	void addListenerForAdd(ActionListener listenForAdd) {
		button_add.addActionListener(listenForAdd);
	}
	
	/*
	 	This method is used to add the listener for button Delete.
	*/
	void addListenerForDelete(ActionListener listenForDelete) {
		button_delete.addActionListener(listenForDelete);
	}
	
	/*
	 	This method is used to add the listener for button Load.
	*/
	void addListenerForLoad(ActionListener listenForLoad) {
		button_load.addActionListener(listenForLoad);
	}
	
	/*
	 	This method is used to add the listener for Color list combo box.
	*/
	void addListenerForComboBox(ActionListener listenForComboBox) {
		comboBox_colors.addActionListener(listenForComboBox);
	}

}
