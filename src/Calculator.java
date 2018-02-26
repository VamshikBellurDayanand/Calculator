import java.awt.EventQueue;

public class Calculator {
	/**
	 * Launch the application.
	 * Create the Model, View and Controller.
	 * Set the visibility of frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorModel model = new CalculatorModel();
					CalculatorView view = new CalculatorView();
					CalculatorController controller = new CalculatorController(model, view);
					
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
