package jpu2016.dogfight.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sky implements IArea {
	private final Image image;
	private final Dimension dimension;

	public Sky(Dimension dimension) throws IOException {
		this.dimension = dimension;
		this.image = ImageIO.read(new File("images/sky.jpg"));
	}

	@Override
	public Dimension getDimension() {
		return this.dimension;
	}

	@Override
	public Image getImage() {
		return this.image;
	}
}
