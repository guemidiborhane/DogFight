package jpu2016.dogfight.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class DogfightModel extends Observable implements IDogfightModel {
	private Sky sky;
	private final ArrayList<IMobile> mobiles;

	public DogfightModel() {
		this.mobiles = new ArrayList<IMobile>();
	}

	@Override
	public IArea getArea() {
		return this.sky;
	}

	@Override
	public void buildArea(Dimension dimension) throws IOException {
		this.sky = new Sky(dimension);
	}

	@Override
	public void addMobile(IMobile mobile) {
		this.mobiles.add(mobile);
	}

	@Override
	public void removeMobile(IMobile mobile) {
		this.mobiles.remove(mobile);
	}

	@Override
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}

	@Override
	public IMobile getMobileByPlayer(int player) {
		for (final IMobile mobile : this.mobiles) {
			if (mobile.isPlayer(player)) {
				return mobile;
			}
		}
		return null;
	}

	@Override
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}
