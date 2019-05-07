package jpu2016.dogfight.model;
//final plane

import java.io.IOException;

public class Plane extends Mobile {
	private static int SPEED = 2;
	private static int WIDTH = 100;
	private static int HEIGHT = 30;
	private final int player;



	public Plane(final Direction direction, final Position position, final Dimension dimension, final int speed, final String image, final int player)
			throws IOException {
		super(direction, position, dimension, speed, image);

		this.player = player;
	}



	@Override
	public boolean isPlayer(final int player) {
		return this.player == player;


	}


	@Override
	public boolean hit() {
		this.getIDogfightModel().removeMobile(this);
		return true;
	}
}