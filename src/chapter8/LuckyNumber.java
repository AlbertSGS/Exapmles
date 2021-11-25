/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Class to demonstrate the Observer design pattern 
 * in Java. Note that there are many ways to implement an
 * Observer design pattern, and that this is just one of them.
 * This code requires JavaFX to run.
 */
public class LuckyNumber extends Application
{
	public static final int WIDTH = 200;
	
	private static final int GAP = 10;
	private static final int MARGIN = 20;
	
	/**
	 * Launches the application.
	 * @param pArgs This program takes no argument.
	 */
	public static void main(String[] pArgs) 
	{
        launch(pArgs);
    }
    
    @Override
    public void start(Stage pPrimaryStage) 
    {
    	Model model = new Model();
    	
    	// model.addObserver(new FrequencyObserver(model));
    	
    	GridPane root = createPane(); // The root of the GUI component graph
    	root.add(new SliderPanel(model), 0, 0, 1, 1);
    	root.add(new IntegerPanel(model), 0, 1, 1, 1);
    	root.add(new TextPanel(model), 0, 2, 1, 1);
    	root.add(new RomanTextPanel(model), 0, 3, 1, 1);
    	
    	pPrimaryStage.setTitle("Lucky Number");
    	pPrimaryStage.setResizable(false);
        pPrimaryStage.setScene(new Scene(root));
        pPrimaryStage.show();
    }
    
    /*
     * Helper method to hid the details of creating
     * a nice looking grid.
     */
    private static GridPane createPane()
    {
    	GridPane root = new GridPane();
    	root.setHgap(GAP);
    	root.setVgap(GAP);
    	root.setPadding(new Insets(MARGIN));
    	return root;
    }
}

/**
 * The observable object.
 */
class Model implements Iterable<Integer>
{
	private static final int DEFAULT = 5;
	private static final int MIN = 1;
	private static final int MAX = 10;
	
	private ArrayList<Observer> aObservers = new ArrayList<Observer>();
	private List<Integer> aNumbers = new ArrayList<>();
	
	public Model() {
		aNumbers.add(DEFAULT);
	}
	
	public void addObserver(Observer pObserver)
	{
		aObservers.add(pObserver);
	}
	
	private void notifyObservers()
	{
		for(Observer observer : aObservers)
		{
			observer.newNumber(getNumber());
		}
	}
	
	public void setNumber(int pNumber)
	{
		if( pNumber < MIN )
		{
			aNumbers.add(MIN);
		}
		else if( pNumber > MAX )
		{
			aNumbers.add(MAX);
		}
		else
		{
			aNumbers.add(pNumber);
		}
		notifyObservers();
	}
	
	public int getNumber()
	{
		return aNumbers.get(aNumbers.size() - 1);
	}

	@Override
	public Iterator<Integer> iterator() {
		return aNumbers.iterator();
	}
}

/**
 * Concrete observer that displays the model
 * data in a slider.
 */
class SliderPanel extends Parent implements Observer
{
	private Slider aSlider = createSlider();
	private Model aModel;

	/**
	 * @param pModel The model observed by this panel.
	 */
	SliderPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aSlider.setValue(aModel.getNumber());
		getChildren().add(aSlider);

		aSlider.valueProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(ObservableValue<? extends Number> pValue, Number pOld, Number pNew) 
			{
				aModel.setNumber(pNew.intValue());				
			}
		});
	}

	@Override
	public void newNumber(int pNumber)
	{
		aSlider.setValue(pNumber);
	}
	
	private static Slider createSlider()
	{
		// CSOFF:
		Slider slider = new Slider(1, 10, 5);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMinWidth(LuckyNumber.WIDTH);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(1);
		slider.setMinorTickCount(0);
		slider.setSnapToTicks(true); 
		// CSON:
		return slider;
	}
}

/**
 * Concrete observer that displays the model data
 * as a integer in a text field.
 */
class IntegerPanel extends Parent implements Observer, EventHandler<ActionEvent>
{
	private TextField aText = new TextField();
	private Model aModel;
	
	/**
	 * @param pModel The model observed by this panel.
	 */
	IntegerPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aText.setMinWidth(LuckyNumber.WIDTH); 
		aText.setText(Integer.valueOf(aModel.getNumber()).toString());
		getChildren().add(aText);
		
		aText.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent pEvent)
			{
				int lInteger = 1;
				try
				{
					lInteger = Integer.parseInt(aText.getText());
				}
				catch(NumberFormatException pException )
				{
					// Just ignore. We'll use 1 instead.
				}
				aModel.setNumber(lInteger);	
			}
		});
	}	
	
	@Override
	public void handle(ActionEvent pEvent)
	{
		int lInteger = 1;
		try
		{
			lInteger = Integer.parseInt(aText.getText());
		}
		catch(NumberFormatException pException )
		{
			// Just ignore. We'll use 1 instead.
		}
		aModel.setNumber(lInteger);	
	}

	@Override
	public void newNumber(int pNumber)
	{
		aText.setText(Integer.valueOf(pNumber).toString());
	}
}

/**
 * Concrete observer that displays the model data
 * as a written-out number in a text field.
 */
class TextPanel extends HBox implements Observer
{
	private static final String[] LABELS = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	
	private TextField aText = new TextField();
	private Model aModel;
	
	/**
	 * @param pModel The model observed by this panel.
	 */
	TextPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aText.setMinWidth(LuckyNumber.WIDTH);
		aText.setText(LABELS[aModel.getNumber() - 1]);
		getChildren().add(aText);
		
		
		aText.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent pEvent)
			{
				int lIndex = 0;
				for( int i = 0; i < LABELS.length; i++)
				{
					if(aText.getText().equalsIgnoreCase(LABELS[i]))
					{
						lIndex = i;
						break;
					}
				}
				aModel.setNumber(lIndex + 1);
			}
		});
	}

	@Override
	public void newNumber(int pNumber)
	{
		aText.setText(LABELS[pNumber - 1]);
		
	}
}

/**
 * Concrete observer that displays the model data
 * as a written-out number in a text field.
 */
class RomanTextPanel extends HBox implements Observer
{
	private static final String[] LABELS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
	
	private TextField aText = new TextField();
	private Model aModel;
	
	/**
	 * @param pModel The model observed by this panel.
	 */
	RomanTextPanel(Model pModel)
	{
		aModel = pModel;
		aModel.addObserver(this);
		aText.setMinWidth(LuckyNumber.WIDTH);
		aText.setText(LABELS[aModel.getNumber() - 1]);
		getChildren().add(aText);
		
		
		aText.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent pEvent)
			{
				int lIndex = 0;
				for( int i = 0; i < LABELS.length; i++)
				{
					if(aText.getText().equalsIgnoreCase(LABELS[i]))
					{
						lIndex = i + 1;
						break;
					}
				}
				aModel.setNumber(lIndex);
			}
		});
	}

	@Override
	public void newNumber(int pNumber)
	{
		aText.setText(LABELS[pNumber - 1]);
		
	}
}

class FrequencyObserver implements Observer
{
	private Model aModel;
	
	public FrequencyObserver(Model pModel) {
		aModel = pModel;
	}
	
	@Override
	public void newNumber(int pNumber)
	{
		int freq = 0;
		for(int number : aModel) {
			if(number == pNumber) freq++;
		}
		System.out.println("Number " + pNumber + " seen " + freq + " time(s).");
		
	}
}

/**
 * Abstract observer role for the model.
 */
interface Observer {
	void newNumber(int pNumber);
}