package jpu2016.dogfight.view;
import java.util.Observable;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.gameframe.GameFrame;

public class DogfightView implements Runnable, IViewSystem{

	@SuppressWarnings("unused")
	private EventPerformer eventPerformer;
	@SuppressWarnings("unused")
	private GameFrame gameFrame;
	@SuppressWarnings("unused")
	private GraphicsBuilder graphicsBuilder;

	public DogfightView (IOrderPerformer OrderPerformer, IDogfightModel dogfightmodel, Observable observable) {
		
	}
	
	public void run() { 
		
	}
	public void displayMessage (String message) {
		
	}
	public void closeAll() {
		
	}
	
}