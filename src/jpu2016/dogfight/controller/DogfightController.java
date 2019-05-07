package jpu2016.dogfight.controller;

import java.io.IOException;

import jpu2016.dogfight.model.Direction;
import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.dogfight.model.IMobile;
import jpu2016.dogfight.model.Missile;
import jpu2016.dogfight.model.Position;
import jpu2016.dogfight.view.IViewSystem;

public class DogfightController implements IOrderPerformer {

	private static int TIME_SLEEP = 30;
	private final IDogfightModel dogfightModel;
	private IViewSystem viewSystem;

	public DogfightController(final IDogfightModel dogfightModel) {
		this.dogfightModel = dogfightModel;
	}

	@Override
	public void orderPerform(final UserOrder userOrder) throws IOException {
		final int player = userOrder.getPlayer();
		final IMobile mobile = this.dogfightModel.getMobileByPlayer(player);
		switch (userOrder.getOrder()) {
		case UP:
			mobile.setDirection(Direction.UP);
			break;
		case RIGHT:
			mobile.setDirection(Direction.RIGHT);
			break;
		case DOWN:
			mobile.setDirection(Direction.DOWN);
			break;
		case LEFT:
			mobile.setDirection(Direction.LEFT);
			break;
		case SHOOT:
			this.launchMissile(player);
			break;
		case NOP:
		default:
			break;
		}
	}

	public void play() {
		this.gameLoop();
		this.viewSystem.displayMessage("Partie terminée !");
	}

	public void setViewSystem(final IViewSystem viewSystem) {
		this.viewSystem = viewSystem;
	}

	private void launchMissile(final int player) throws IOException {
		final IMobile mobile = this.dogfightModel.getMobileByPlayer(player);
		double x = 0, y = 0;
		switch (mobile.getDirection()) {
		case UP:
			x = mobile.getPosition().getX();
			y = mobile.getPosition().getY() - 5;
			break;
		case DOWN:
			x = mobile.getPosition().getX();
			y = mobile.getPosition().getY() + 5;
			break;
		case LEFT:
			x = mobile.getPosition().getX() - 5;
			y = mobile.getPosition().getY();
			break;
		case RIGHT:
			x = mobile.getPosition().getX() + 5;
			y = mobile.getPosition().getY();
			break;
		}
		final Position pos = new Position(x, y, this.dogfightModel.getArea().getDimension().getWidth(),
				this.dogfightModel.getArea().getDimension().getHeight());
		final Missile missile = new Missile(mobile.getDirection(), pos);
		this.dogfightModel.addMobile(missile);
	}

	private void gameLoop() {

	}

	private void manageCollision() {
		for (final IMobile weapon : this.dogfightModel.getMobiles()) {
			for (final IMobile mobile : this.dogfightModel.getMobiles()) {
				if (mobile != weapon) {
					if (weapon.isWeapon()) {
						if (this.isWeaponOnMobile(mobile, weapon)) {
							this.dogfightModel.getMobiles().remove(weapon);
							if (mobile.isWeapon()) {
								this.dogfightModel.getMobiles().remove(mobile);
							} else {
								mobile.hit();
							}
						}
					}
				}
			}
		}
	}

	private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
		if (((weapon.getPosition().getX() / weapon.getWidth()) >= (mobile.getPosition().getX() / weapon.getWidth()))
				&& ((weapon.getPosition().getX()
						/ weapon.getWidth()) <= ((mobile.getPosition().getX() + mobile.getWidth())
								/ weapon.getWidth()))) {
			if (((weapon.getPosition().getY() / weapon.getHeight()) >= (mobile.getPosition().getY()
					/ weapon.getHeight()))
					&& ((weapon.getPosition().getY()
							/ weapon.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight())
									/ weapon.getHeight()))) {
				return true;
			}
		}
		return false;
	}
}
