package jpu2016.gameframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;

public class GameFrame implements KeyListener {
	@SuppressWarnings("unused")
	private final IEventPerformer eventPerformer;

	public GameFrame(String title, IEventPerformer performer, IGraphicsBuilder graphicsBuilder, Observable observable) {
		this.eventPerformer = performer;
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {

	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		try {
			this.eventPerformer.eventPerform(keyEvent);
		} catch (final IOException e) {
			System.exit(-1);
		}
	}
}
