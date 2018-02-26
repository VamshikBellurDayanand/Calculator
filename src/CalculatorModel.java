import javax.swing.DefaultListModel;

public class CalculatorModel {
	private String inputEquation;
	private String answerEquation;
	private  DefaultListModel<String> historyList;
	private String answer;
	
	/*
	 	This is the constructor of Calculator Model class and it instantiates the history list;
	*/
	public CalculatorModel() {
		super();
		this.historyList =  new DefaultListModel<>();
	}

	/*
	 	This is the getter method to get the input Equation.
	*/
	public String getInputEquation() {
		return inputEquation;
	}
	
	/*
	 	This is the setter method to set the input Equation.
	*/
	public void setInputEquation(String inputEquation) {
		this.inputEquation = inputEquation;
	}
	
	/*
	 	This is the getter method to get the history list.
	*/
	public DefaultListModel<String> getHistoryList() {
		return historyList;
	}

	/*
	 	This is the setter method to set the history list.
	*/
	public void setHistoryList(DefaultListModel<String> historyList) {
		this.historyList = historyList;
	}
	
	/*
	 	This is the getter method to get the answer.
	*/
	public String getAnswer() {
		return answer;
	}
	
	/*
	 	This is the setter method to set the answer.
	*/
	public void setAnswer(String answer) {
		this.answer = answer;
	}	
	
	/*
	 	This is the getter method to get the answer equation.
	*/
	public String getAnswerEquation() {
		return answerEquation;
	}

	/*
	 	This is the setter method to set the answer equation.
	*/
	public void setAnswerEquation(String answerEquation) {
		this.answerEquation = answerEquation;
	}

	/*
	 	This method is used to add an item to the history list.
	*/
	public void addItemHistoryList(String item) {		
		System.out.println("Added item in the list: " + item);
		this.historyList.addElement("y = " + item);
	}
	
	/*
	 	This method is used to remove an item from the history list.
	*/
	public void removeItemHistoryList(int index) {
		this.historyList.remove(index);
	}
}
