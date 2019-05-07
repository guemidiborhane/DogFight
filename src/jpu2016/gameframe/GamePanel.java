package jpu2016.gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private Observable observable;
	@SuppressWarnings("unused")
	private IGraphicsBuilder graphicsBuilder;

	public GamePanel (IGraphicsBuilder graphicsBuilder) {
		
	}
	@Override
	public void update(Observable o, Object arg) {
		
	}
	public Observable getObservable() {
		return observable;
	}
	public void setObservable(Observable observable) {
		this.observable = observable;
	}
	public void update (Observable observable){
		
	}
	public void paintComponent (Graphics graphic) {
		
	}

}
