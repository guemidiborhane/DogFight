package jpu2016.dogfight.model;

import java.io.IOException;

public class Missile extends Mobile {

	private static int SPEED = 4;
	private static int WIDTH = 30;
	private static int HEIGHT = 10;
	private static int MAX_DISTANCE_TRAVELED = 1400;
	private static String IMAGE = "missile";
	private int distanceTraveled = 0;

	public Missile(final Direction direction, final Position position) throws IOException {
		super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, IMAGE);
	}

	public static int getWidthWithADirection(final Direction direction) {
		switch (direction) {
		case UP:
		case DOWN:

			return HEIGHT;
		case LEFT:
		case RIGHT:

		default:
			return WIDTH;
		}
	}

	public static int getHeightWithADirection(final Direction direction) {
		switch (direction) {
		case UP:
		case DOWN:

			return WIDTH;

		case LEFT:
		case RIGHT:
		default:
			return HEIGHT;
		}
	}

	@Override
	public void move() {

		this.distanceTraveled = +SPEED;
		if (this.distanceTraveled >= MAX_DISTANCE_TRAVELED) {
			this.getIDogfightModel().removeMobile(this);

		}
	}

	@Override
	public boolean isWeapon() {

		return true;
	}

}
