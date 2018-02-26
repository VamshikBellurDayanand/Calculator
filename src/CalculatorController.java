import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalculatorController {
	private CalculatorModel model;
	private CalculatorView view;

	/*
	 * This is the constructor of the calculator model. All the listeners are added
	 * here.
	 */
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		super();
		this.model = model;
		this.view = view;

		addListeners();
	}

	/*
	 * This function is used to register the event listeners for various buttons
	 * created in the view file.
	 */
	public void addListeners() {
		this.view.addListenerForNine(new InputListener("9")); // Register Action Listener for button 9.
		this.view.addListenerForEight(new InputListener("8")); // Register Action Listener for button 8.
		this.view.addListenerForSeven(new InputListener("7")); // Register Action Listener for button 7.
		this.view.addListenerForSix(new InputListener("6")); // Register Action Listener for button 6.
		this.view.addListenerForFive(new InputListener("5")); // Register Action Listener for button 5.
		this.view.addListenerForFour(new InputListener("4")); // Register Action Listener for button 4.
		this.view.addListenerForThree(new InputListener("3")); // Register Action Listener for button 3.
		this.view.addListenerForTwo(new InputListener("2")); // Register Action Listener for button 2.
		this.view.addListenerForOne(new InputListener("1")); // Register Action Listener for button 1.
		this.view.addListenerForZero(new InputListener("0")); // Register Action Listener for button 0.
		this.view.addListenerForDot(new InputListener(".")); // Register Action Listener for button Dot.
		this.view.addListenerForClear(new InputListener("")); // Register Action Listener for button Clear.
		this.view.addListenerForPlus(new InputListener("+")); // Register Action Listener for button Plus.
		this.view.addListenerForMinus(new InputListener("-")); // Register Action Listener for button Minus.
		this.view.addListenerForDivide(new InputListener("/")); // Register Action Listener for button Divide.
		this.view.addListenerForMultiply(new InputListener("*")); // Register Action Listener for button Multiply.
		this.view.addListenerForExp(new InputListener("^")); // Register Action Listener for button Exponent.
		this.view.addListenerForSquareRoot(new InputListener("\u221a")); // Register Action Listener for button Square Root.																	 
		this.view.addListenerForEuler(new InputListener("2.71828")); // Register Action Listener for button Euler.
		this.view.addListenerForPi(new InputListener("3.14159")); // Register Action Listener for button Pi.
		this.view.addListenerForSine(new InputListener("sin")); // Register Action Listener for button Sine.
		this.view.addListenerForCosine(new InputListener("cos")); // Register Action Listener for button Cosine.
		this.view.addListenerForTan(new InputListener("tan")); // Register Action Listener for button Tan.
		this.view.addListenerForLog(new InputListener("log")); // Register Action Listener for button ln.
		this.view.addListenerForAnswer(new InputListener("")); // Register Action Listener for button Answer.
		this.view.addListenerForEnter(new InputListener("")); // Register Action Listener for button Enter.
		this.view.addListenerForDelete(new InputListener("delete")); // Register Action Listener for button Delete.
		this.view.addListenerForAdd(new InputListener("add")); // Register Action Listener for button Add.
		this.view.addListenerForLoad(new InputListener("")); // Register Action Listener for button Load.
		this.view.addListenerForComboBox(new InputListener("")); // Register Action Listener for button Combo Box.
	}

	/*
	 * This is a helper class which implements the action listener for the above
	 * registered Jcomponents.
	 */
	class InputListener implements ActionListener {
		private String string;
		private final String INVALID_EXPRESSION = "Invalid Expression";
		private final String INVALID_RESULT = "Error or Inf";

		public InputListener(String number) {
			super();
			this.string = number;
		}

		/*
		 * This method overrides the action Performed. It contains what action to be
		 * performed when a particular component is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			if (event.getSource() == view.getButton_answer()) {
				setAnswerTextField("ANSWER");
			} else if (event.getSource() == view.getButton_enter()) {
				string = view.getTextField_answer();
				model.setAnswerEquation(string);
				view.setTextField_answer(evaluateExpression(string));
			} else if (event.getSource() == view.getComboBox()) {
				setEquationTextFieldColor();
			} else if (event.getSource() == view.getButton_add()) {
				addItemToHistoryList();
			} else if (event.getSource() == view.getButton_clear()) {
				model.setAnswerEquation("");
				view.setTextField_answer(model.getAnswerEquation());
			} else if (event.getSource() == view.getButton_sqr_root()) {
				model.setAnswerEquation(view.getTextField_answer());
				string = modifyInput(model.getAnswerEquation(), "\u221a");
				model.setAnswerEquation(string);
				view.setTextField_answer(model.getAnswerEquation());
			} else if (event.getSource() == view.getButton_sin()) {
				model.setAnswerEquation(view.getTextField_answer());
				string = modifyInput(model.getAnswerEquation(), "sin");
				model.setAnswerEquation(string);
				view.setTextField_answer(model.getAnswerEquation());
			} else if (event.getSource() == view.getButton_cos()) {
				model.setAnswerEquation(view.getTextField_answer());
				string = modifyInput(model.getAnswerEquation(), "cos");
				model.setAnswerEquation(string);
				view.setTextField_answer(model.getAnswerEquation());
			} else if (event.getSource() == view.getButton_tan()) {
				model.setAnswerEquation(view.getTextField_answer());
				string = modifyInput(model.getAnswerEquation(), "tan");
				model.setAnswerEquation(string);
				view.setTextField_answer(model.getAnswerEquation());
			} else if (event.getSource() == view.getButton_ln()) {
				model.setAnswerEquation(view.getTextField_answer());
				string = modifyInput(model.getAnswerEquation(), "ln");
				model.setAnswerEquation(string);
				view.setTextField_answer(model.getAnswerEquation());
			} else if (event.getSource() == view.getButton_load()) {
				loadItemToEquationField();
			} else if (event.getSource() == view.getButton_delete()) {
				deleteItemToEquationField();
			} else {
				model.setAnswerEquation(string);
				setAnswerTextField(model.getAnswerEquation());
			}
		}

		/*
		 * This helper function is used to modify the input for single operand. It
		 * attaches the bracket.
		 */
		private String modifyInput(String string, String symbol) {
			System.out.println("string in modifyInput is " + string);
			return string + symbol + "(" ;
		}

		/*
		 * This helper function is used to check whether an operator requires two
		 * operands or single operand.
		 */
		private Boolean isOperand(char inputChar) {
			if ((inputChar == '+') || (inputChar == '-') || (inputChar == '*') || (inputChar == '/')
					|| (inputChar == '^') || (inputChar == '\u221a')) {
				return true;
			}
			return false;
		}

		/*
		 * This function is used to evaluate the given input expression. It calls
		 * isFirstCharacterNumber() to verify the expression. It calls compute() to
		 * compute the answer if the given expression is correct.
		 */
		private String evaluateExpression(String inputExpression) {
			int lastOperatorIndex = -1;
			System.out.println("inputExpression in evaluateExpression is " + inputExpression);
			if (inputExpression.isEmpty()) {
				return INVALID_EXPRESSION;
			}
			if (isFirstCharacterValid(inputExpression.charAt(0))) {
				char[] charTokens = inputExpression.toCharArray();
				System.out.println("char tokens length is " + charTokens.length);
				Stack<Double> operands = new Stack<Double>();
				Stack<Character> operators = new Stack<Character>();

				for (int i = 0; i < charTokens.length; i++) {
					if (charTokens[i] == 'A') { // Check for ANSWER in the input Field
						if (isPreviousOperator(i, charTokens)) {
							System.out.println("ANSWER is " + model.getAnswer() + "and is pushed to operand stack");
							if (model.getAnswer() == null) {
								model.setAnswer("0");
							}
							operands.push(Double.parseDouble(model.getAnswer()));
							System.out.println("Top element in stack is " + operands.peek());
							i = i + 5;
						} else {
							return INVALID_EXPRESSION;
						}
					} else if ((charTokens[i] >= '0' && charTokens[i] <= '9') || (charTokens[i] == '.')) { 
						// Check for Numbers in the input Field
																											
						StringBuffer stringBuffer = new StringBuffer();
						int dotCount = 0;
						while (i < charTokens.length
								&& ((charTokens[i] >= '0' && charTokens[i] <= '9') || (charTokens[i] == '.'))) {
							if (charTokens[i] == '.') {
								dotCount++;
							}
							if (dotCount > 1) {
								return INVALID_EXPRESSION;
							}
							stringBuffer.append(charTokens[i++]);
							if ((i < charTokens.length)
									&& !((charTokens[i] >= '0' && charTokens[i] <= '9') || (charTokens[i] == '.'))) {
								System.out.println("char[i]: " + charTokens[i]);
								--i;
								break;
							}
						}
						operands.push(Double.parseDouble(stringBuffer.toString()));
						System.out.println("Operands top is " + operands.peek());
					} else if (charTokens[i] >= 'a' && charTokens[i] <= 't') { // Push sin, cos, tan and log
						operators.push(charTokens[i]);
					} else if (charTokens[i] == '(') {
						operators.push(charTokens[i]);
					} else if (charTokens[i] == '\u221a') { // Check for Square Root Symbol
						operators.push(charTokens[i]);
					} else if (charTokens[i] == ')') {
						while (operators.peek() != '(') {
							Character operator = operators.pop();
							if (!operands.isEmpty()) { // Check Operands stack is not empty before popping
								Double firstOperand = operands.pop();
								if (!operands.empty()) {
									String tempAnswer = compute(operator, firstOperand, operands.pop());
									if (tempAnswer.equals(INVALID_RESULT)) {
										return INVALID_EXPRESSION;
									} else {
										operands.push(Double.parseDouble(tempAnswer));
									}
								} else {
									return INVALID_EXPRESSION;
								}
							} else {
								return INVALID_EXPRESSION;
							}
						}
						operators.pop();
						if (!operators.empty() && isSingleOperandOperator(operators.peek())) {
							if (operators.peek() == '\u221a') { // Check for Square Root
								operators.pop();
								if (!operands.empty()) {
									operands.push(Math.sqrt(operands.pop()));
								} else {
									return INVALID_EXPRESSION;
								}
							} else if (operators.peek() == 'n') {
								operators.pop();
								if (operators.peek() == 'i') { // Check for sin
									operators.pop();
									if (!operators.empty()) {
										operators.pop();
										if (!operands.empty()) {
											operands.push(Math.sin(operands.pop()));
										} else {
											return INVALID_EXPRESSION;
										}

									} else {
										return INVALID_EXPRESSION;
									}
								} else if (operators.peek() == 'a') { // Check for tan
									operators.pop();
									if (!operators.empty()) {
										operators.pop();
										if (!operands.empty()) {
											operands.push(Math.tan(operands.pop()));
										} else {
											return INVALID_EXPRESSION;
										}
									} else {
										return INVALID_EXPRESSION;
									}
								} else if (operators.peek() == 'l') { // Check for log
									operators.pop();
									if (!operands.empty()) {
										operands.push(Math.log(operands.pop()));
									} else {
										return INVALID_EXPRESSION;
									}
								}
							} else if (operators.peek() == 's') { // Check for cos
								operators.pop();
								if (!operators.empty()) {
									operators.pop();
									if (!operators.empty()) {
										operators.pop();
										if (!operands.empty()) {
											operands.push(Math.cos(operands.pop()));
										} else {
											return INVALID_EXPRESSION;
										}
									} else {
										return INVALID_EXPRESSION;
									}
								} else {
									return INVALID_EXPRESSION;
								}
							} else {
								System.out.println("Operator peek is not equal to square root ");
							}
						}
					} else if ((charTokens[i] == '+') || (charTokens[i] == '-') || (charTokens[i] == '*')
							|| (charTokens[i] == '/') || (charTokens[i] == '^')) {
						if ((charTokens[i] == '-' || charTokens[i] == '+') && i == 0) {
							if ((charTokens[i + 1] >= '0' && charTokens[i + 1] <= '9')) { 
								// Check for Numbers in the	input Field
								
								StringBuffer stringBuffer = new StringBuffer();
								StringBuffer newStringBuffer = new StringBuffer();
								newStringBuffer.append(charTokens[i]);
								int dotCount = 0;
								i++;
								while (i < charTokens.length
										&& ((charTokens[i] >= '0' && charTokens[i] <= '9') || (charTokens[i] == '.'))) {
									if (charTokens[i] == '.') {
										dotCount++;
									}
									if (dotCount > 1) {
										return INVALID_EXPRESSION;
									}
									stringBuffer.append(charTokens[i++]);
									if ((i < charTokens.length) && !((charTokens[i] >= '0' && charTokens[i] <= '9')
											|| (charTokens[i] == '.'))) {
										System.out.println("char[i]: " + charTokens[i]);

										--i;
										break;
									}
								}

								newStringBuffer.append(stringBuffer.toString());
								System.out.println("newStringBuffer" + newStringBuffer.toString());

								operands.push(Double.parseDouble(newStringBuffer.toString()));
							} else {
								return INVALID_EXPRESSION;
							}
						} else if ((i - lastOperatorIndex) > 1) {
							if ((charTokens[i] == '-' || charTokens[i] == '+') && charTokens[i - 1] == '(') {
								if ((charTokens[i + 1] >= '0' && charTokens[i + 1] <= '9')) { // Check for Numbers in
																								// the input Field
									StringBuffer stringBuffer = new StringBuffer();
									int dotCount = 0;
									i++;
									while (i < charTokens.length && ((charTokens[i] >= '0' && charTokens[i] <= '9')
											|| (charTokens[i] == '.'))) {
										if (charTokens[i] == '.') {
											dotCount++;
										}
										if (dotCount > 1) {
											return INVALID_EXPRESSION;
										}
										stringBuffer.append(charTokens[i++]);
										if ((i < charTokens.length) && !((charTokens[i] >= '0' && charTokens[i] <= '9')
												|| (charTokens[i] == '.'))) {
											System.out.println("char[i]: " + charTokens[i]);

											--i;
											break;
										}
									}
									StringBuffer newStringBuffer = new StringBuffer();
									newStringBuffer.append('-');
									newStringBuffer.append(stringBuffer.toString());
									System.out.println("newStringBuffer" + newStringBuffer.toString());

									operands.push(Double.parseDouble(newStringBuffer.toString()));
									System.out.println("Operands top is " + operands.peek());
								} else {
									return INVALID_EXPRESSION;
								}
							} else {
								while (!operators.empty() && hasHigherPrecedence(charTokens[i], operators.peek())) {
									Character operator = operators.pop();
									Double firstOperand = operands.pop();
									if (!operands.empty()) {
										String tempAnswer = compute(operator, firstOperand, operands.pop());
										if (tempAnswer.equals("Error or INF")) {
											return INVALID_EXPRESSION;
										} else {
											operands.push(Double.parseDouble(tempAnswer));
										}
									} else {
										return INVALID_EXPRESSION;
									}
								}
								lastOperatorIndex = i;
								operators.push(charTokens[i]);
							}
						} else {
							return INVALID_EXPRESSION;
						}
					} else {
						return INVALID_EXPRESSION;
					}
				}

				while (!operators.empty()) { //Check for remaining operators in stack
					if(operators.peek() == '(') {
						return INVALID_EXPRESSION;
					} else if (!operands.empty()) {
						Double firstOperand = operands.pop();
						if (!operators.empty()) {
							if(!operands.empty()) {
								Double secondOperator = operands.pop();
								String tempAnswer = compute(operators.pop(), firstOperand, secondOperator);
								if (tempAnswer.equals("Error or INF")) {
									return INVALID_EXPRESSION;
								} else {
									operands.push(Double.parseDouble(tempAnswer));
								}
							} else {
								return INVALID_EXPRESSION;
							}
						} else {
							return INVALID_EXPRESSION;
						}
					} else {
						return INVALID_EXPRESSION;
					}
				}

				if (!operands.empty()) {
					model.setAnswer(operands.peek().toString());
					System.out.println("Output is " + operands.peek());
					return (operands.pop().toString());
				} else {
					return INVALID_EXPRESSION;
				}
			} else {
				System.out.println("First Character cannot be operator");
				return INVALID_EXPRESSION;
			}
		}

		/*
		 * This method checks whether two operators are consecutive.
		 */
		private boolean isPreviousOperator(int i, char charTokens[]) {
			if (i == 0) {
				return true;
			}

			if (charTokens[i - 1] == '+' || charTokens[i - 1] == '-' || charTokens[i - 1] == '*'
					|| charTokens[i - 1] == '/' || charTokens[i - 1] == '(' || charTokens[i - 1] == '^') {
				return true;
			}
			return false;
		}

		/*
		 * Check whether the given operator requires single operand or double operand.
		 */
		private boolean isSingleOperandOperator(Character operator) {
			System.out.println("isSingleOperandOperator: " + operator);
			if (operator == 'n' || operator == 's' || operator == 'g' || operator == '\u221a') {
				System.out.println("return true in isSingleOperandOperator");
				return true;
			}
			System.out.println("return false in isSingleOperandOperator");
			return false;
		}

		/*
		 * This function is used to for error checking. If user enters opertor first,
		 * then console will display the error message.
		 */
		private boolean isFirstCharacterValid(char firstChar) {
			System.out.println("isFirstCharacterNumber is " + firstChar);
			if (firstChar == '*' || firstChar == '/' || firstChar == '^' || firstChar == ')') {
				System.out.println("Return False in isFirstCharacterNumber");
				return false;
			}
			if (firstChar == '.') {
				System.out.println("Decimal number should atleast contain a digit before dot");
				return false;
			}
			System.out.println("Return True in isFirstCharacterNumber");
			return true;
		}

		/*
		 * This function is used to compute the answer for the given two operands and an
		 * operator.
		 */
		public String compute(char op, Double b, Double a) {
			System.out.println("a is " + a);
			System.out.println("b is " + b);
			Double ans;
			switch (op) {
			case '+':
				System.out.println("Operation is addition");
				ans = a + b;
				return ans.toString();
			case '-':
				System.out.println("Operation is Subtraction");
				ans = a - b;
				return ans.toString();
			case '*':
				System.out.println("Operation is Multiplication");
				ans = a * b;
				return ans.toString();
			case '/':
				System.out.println("Operation is Division");
				if (b == 0) {
					return "Error or INF";
				}
				ans = a / b;
				return ans.toString();
			case '^':
				System.out.println("Opertaion is exponent");
				ans = Math.pow(a, b);
				return ans.toString();
			}
			return "0.0";
		}

		/*
		 * This function is used to check the precedence of the operator in order to
		 * break the tie between two operators.
		 */
		public boolean hasHigherPrecedence(char op1, char op2) {
			System.out.println("Operator 1 is " + op1);
			System.out.println("Operator 2 is " + op2);
			if (op2 == '(' || op2 == ')')
				return false;
			if ((op1 == '^') && (op2 == '*' || op2 == '/' || op2 == '+' || op2 == '-'))
				return false;
			if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
				return false;
			else
				return true;
		}

		/*
		 * This function is used to set the answer field.
		 */
		private void setAnswerTextField(String string) {
			String presentExpression = view.getTextField_answer();
			System.out.println("Present expression is " + presentExpression);
			if (!string.isEmpty()) {
				String newExpression = presentExpression.concat(string);
				model.setAnswerEquation(newExpression);
				view.setTextField_answer(model.getAnswerEquation());
			} else if (!string.isEmpty()) {
				model.setAnswerEquation(string);
				view.setTextField_answer(model.getAnswerEquation());
			}
		}

		/*
		 * This function is used to delete the selected item from the history List.
		 */
		private void deleteItemToEquationField() {
			int index = view.getList_history().getSelectedIndex();
			if (index >= 0) {
				model.getHistoryList().removeElementAt(index);
				view.getList_history().setModel(model.getHistoryList());
			} else {
				System.out.println("No item in the history list to delete");
			}
		}

		/*
		 * This function is used to load the selected item from the history List to the
		 * equation field.
		 */
		private void loadItemToEquationField() {
			int index = view.getList_history().getSelectedIndex();
			if (index >= 0) {
				String equation = view.getList_history().getModel().getElementAt(index).toString();
				equation = equation.substring(4, equation.length());
				model.setInputEquation(equation);
				view.setTextField_equation(model.getInputEquation());
			} else {
				System.out.println("No item in the history list to load");
			}
		}

		/*
		 * This function is used to add an equation present in the equation field to the
		 * history List.
		 */
		private void addItemToHistoryList() {
			model.setInputEquation(view.getTextField_equation());
			if ((!model.getInputEquation().equals(view.getTextField_hint())) && (!model.getInputEquation().isEmpty())) {
				System.out.println("Setting to list " + model.getInputEquation());
				model.addItemHistoryList(model.getInputEquation());
				view.getList_history().setModel(model.getHistoryList());
				view.getList_history().setSelectedIndex(0);
			}
		}

		/*
		 * This function is used to check whether hint is present or not in the equation
		 * field.
		 */
		private boolean isHintPresent() {
			if (view.getTextField_equation().equals(view.getTextField_hint())) {
				return true;
			}
			return false;
		}

		/*
		 * This function is used to set the text color of the equation field.
		 */
		public void setEquationTextFieldColor() {
			int colorIndex = view.getComboBox().getSelectedIndex();
			switch (colorIndex) {
			case 0:
				view.getEquationTextField().setForeground(Color.BLACK);
				break;
			case 1:
				view.getEquationTextField().setForeground(Color.RED);
				break;
			case 2:
				view.getEquationTextField().setForeground(Color.GREEN);
				break;
			case 3:
				view.getEquationTextField().setForeground(Color.BLUE);
				break;
			case 4:
				view.getEquationTextField().setForeground(Color.PINK);
				break;
			}
		}
	}
}
