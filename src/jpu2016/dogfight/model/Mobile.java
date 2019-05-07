package jpu2016.dogfight.model;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mobile implements IMobile {
	private IDogfightModel dogfightModel;
	private Direction direction;
	private Position position;
	private Dimension dimension;
	private Image[] images;
	private int speed;


	public Mobile(final Direction direction, final Position position, final Dimension dimension, final int speed,
			final String image) throws IOException {
		this.images = new Image[4];
		this.images[Direction.UP.ordinal()] = ImageIO.read(new File("images/Zero_UP.png"));
		this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("images/Zero_RIGHT.png"));
		this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("images/Zero_DOWN.png"));
		this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("images/Zero_LEFT.png"));
		this.buildAllImages(image);
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public void setDirection(final Direction direction) {
		this.direction = direction;

	}

	@Override
	public Point getPosition() {
		return new Point();
	}

	@Override
	public Dimension getDimension() {
		return this.dimension;
	}

	@Override
	public int getWidth() {
		return 1;

	}

	@Override
	public int getHeight() {
		return 1;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public void move() {
		switch (this.direction) {
		case UP:
			this.MoveUp();
			break;
		case DOWN:
			this.MoveDown();
			break;
		case LEFT:
			this.MoveLeft();
			break;
		case RIGHT:
			this.MoveRight();
		default:

			break;


		}

	}

	@Override
	public void placeInArea(final IArea area) {

	}

	@Override
	public boolean isPlayer(final int player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDogfightModel(final IDogfightModel dogfightModel) {
		this.dogfightModel = dogfightModel;
	}

	@Override
	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWeapon() {
		// TODO Auto-generated method stub
		return false;
	}

	private void MoveUp() {
		this.position.setY(this.position.getY() - this.speed);
	}

	private void MoveRight() {
		this.position.setX(this.position.getX() + this.speed);
	}

	private void MoveDown() {
		this.position.setY(this.position.getY() + this.speed);
	}

	private void MoveLeft() {
		this.position.setX(this.position.getX() + this.speed);
	}

	public Color getColor() {
		return null;
	}

	public IDogfightModel getIDogfightModel() {
		return this.dogfightModel;
	}

	public void buildAllImages(final String image) throws IOException {

		this.images = new Image[4];
		this.images[Direction.UP.ordinal()] = ImageIO.read(new File("images/" + image +"_UP.png"));
		this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("images/"+ image + "_RIGHT.png"));
		this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("images/ "+image+"_DOWN.png"));
		this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("images/"+ image + "_LEFT.png"));

	}
}
