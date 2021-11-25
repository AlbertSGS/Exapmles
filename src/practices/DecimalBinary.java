package practices;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DecimalBinary extends Application {

	public static final int WIDTH = 200;

	private static final int GAP = 10;
	private static final int MARGIN = 20;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage pPrimaryStage) throws Exception {
		Model model = new Model();

		GridPane root = createPane(); // The root of the GUI component graph

		root.add(new DecimalObserver(model), 0, 0, 1, 1);
		root.add(new BinaryObserver(model), 0, 1, 1, 1);

		pPrimaryStage.setTitle("Decimal <-> Binary");
		pPrimaryStage.setResizable(false);
		pPrimaryStage.setScene(new Scene(root));
		pPrimaryStage.show();
	}

	private static GridPane createPane() {
		GridPane root = new GridPane();
		root.setHgap(GAP);
		root.setVgap(GAP);
		root.setPadding(new Insets(MARGIN));
		return root;
	}

}

class Model {

	private static final int DEFAULT = 0;
	private static final int MIN = 0;
	private static final int MAX = 1500;

	private List<Observer> aObservers = new ArrayList<>();
	private int aNumber = DEFAULT;

	public void addObserver(Observer pObserver) {
		this.aObservers.add(pObserver);
	}

	public int getNumber() {
		return this.aNumber;
	}

	public void setNumber(int pNumber) {
		if (pNumber < MIN) {
			this.aNumber = MIN;
		} else if (pNumber > MAX) {
			this.aNumber = MAX;
		} else {
			this.aNumber = pNumber;
		}
		notifyObservers();
	}

	private void notifyObservers() {
		for (Observer obs : this.aObservers) {
			obs.numberChanged(getNumber());
		}
	}
}

class DecimalObserver extends Parent implements Observer {
	private TextField aTextField = new TextField();
	private Text aText = new Text("Decimal");
	private Model aModel;

	DecimalObserver(Model pModel) {
		this.aModel = pModel;
		aModel.addObserver(this);
		aTextField.setMinWidth(DecimalBinary.WIDTH);
		aTextField.setPromptText("Enter a Decimal");
		aText.setTextAlignment(TextAlignment.CENTER);
		getChildren().add(aTextField);
		getChildren().add(aText);

		aTextField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent pEvent) {
				int lInteger = 0;
				try {
					lInteger = Integer.parseInt(aTextField.getText());
				} catch (NumberFormatException pException) {
					// Just ignore. We'll use 0 instead.
				}
				aModel.setNumber(lInteger);
			}
		});
	}

	@Override
	public void numberChanged(int pNumber) {
		aTextField.setText(Integer.valueOf(pNumber).toString());
	}

}

class BinaryObserver extends Parent implements Observer {

	private TextField aTextField = new TextField();
	private Text aText = new Text("Binary");
	private Model aModel;

	BinaryObserver(Model pModel) {
		this.aModel = pModel;
		aModel.addObserver(this);
		aTextField.setMinWidth(DecimalBinary.WIDTH);
		aTextField.setPromptText("Enter a Binary");
		aText.setTextAlignment(TextAlignment.CENTER);
		getChildren().add(aTextField);
		getChildren().add(aText);

		aTextField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent pEvent) {
				int lInteger = 0;
				try {
					lInteger = Integer.parseInt(aTextField.getText());
					if (testBinary(lInteger) == false) {
						lInteger = 0;
					}
				} catch (NumberFormatException pException) {
					// Just ignore. We'll use 0 instead.
				}
				aModel.setNumber(binaryToDecimal(lInteger));
			}
		});
	}

	@Override
	public void numberChanged(int pNumber) {
		aTextField.setText(Integer.toBinaryString(pNumber));
	}

	private static boolean testBinary(int pNumber) {
		String[] TEST_SUBJECT = { "2", "3", "4", "5", "6", "7", "8", "9" };

		String s = Integer.toString(pNumber);

		for (int i = 0; i < TEST_SUBJECT.length; i++) {
			if (s.contains(TEST_SUBJECT[i])) {
				return false;
			}
		}

		return true;

	}

	private static int binaryToDecimal(int pBinary) {
		String s = Integer.toString(pBinary);
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			result += Math.pow(2, i) * (s.charAt(s.length() - i - 1) - '0');
		}

		return result;
	}

}

interface Observer {
	public void numberChanged(int pNumber);
}
