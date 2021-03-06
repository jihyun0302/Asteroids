package Projectiles;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.Random;

import Game.SpaceObject;

/**
 * The Class Bullet.
 */
public class Bullet extends SpaceObject {

	/**
	 * Gets the draw color.
	 *
	 * @return the draw color
	 */
	public Color getDrawColor() {
		return drawColor;
	}

	/** The draw color. */
	private Color drawColor = Color.YELLOW;
	
	/** The reload time ms. */
	static public int RELOAD_TIME_MS = 200;
	
	/** The rand. */
	private Random rand = new Random();
	
	/** The sound files. */
	private String[] soundFiles = {"pew","pewb","pewe","pewr","pewj","pewt","pew_word"};
	
	/**
	 * Instantiates a new bullet.
	 *
	 * @param pose the pose
	 * @param speed the speed
	 * @param lateralSpeed the lateral speed
	 */
	public Bullet(Point.Double pose, int speed, double lateralSpeed) {
		super(pose);
		
		// create ship shape
		Path2D.Double bulletShape = new Path2D.Double();
		bulletShape.moveTo(0, 0);
		bulletShape.lineTo(0, 20);
		bulletShape.lineTo(5, 20);
		bulletShape.lineTo(5, 0);
		bulletShape.lineTo(0, 0);
		setShape(bulletShape);

		dy = speed;
		dx = lateralSpeed;
		width = 5;
		
		setSound("assets/bullet/"+soundFiles[rand.nextInt(7)]+".wav", 1);
	}
}
