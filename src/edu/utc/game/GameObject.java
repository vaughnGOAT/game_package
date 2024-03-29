package edu.utc.game;

import org.lwjgl.opengl.GL11;
import java.awt.Rectangle;

public  class GameObject
{
	private boolean active = true;

	protected float r;
	protected float g;
	protected float b;

	protected Rectangle hitbox = new Rectangle();

	protected void setColor(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}// end method

	public void bound(int minX, int maxX, int minY, int maxY)
	{
		int x = (int)this.hitbox.getX();
		int y = (int)this.hitbox.getY();

		if (y < minY)
		{
			hitbox.setLocation(x, minY);
			y = minY;
		}
		else if (y > maxY)
		{
			hitbox.setLocation(x, maxY);
			y = maxY;
		}
		if (x > maxX)
		{
			hitbox.setLocation(maxX, y);
			x = maxX;
		}
		else if (x < minX) {
			hitbox.setLocation(minX, y);
			x = minX;
		}

	}// end method

	public boolean isActive() { return active; }// end method

	public void deactivate() { active = false; }// end method

	public Rectangle getHitbox() { return hitbox; }// end method
	
	public boolean intersects(GameObject other)
	{
		return hitbox.intersects(other.hitbox);

	}// end method

	public Rectangle intersection(GameObject other)
	{
		return hitbox.intersection(other.hitbox);
	}// end method
	
    public void update(int delta) { }// end method

    public void draw()
	{
    	GL11.glColor3f(r, g, b);

    	float x=(float) hitbox.getX();
    	float y=(float) hitbox.getY();
    	float width=(float) hitbox.getWidth();
    	float height=(float) hitbox.getHeight();

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x+width, y);
        GL11.glVertex2f(x+width, y+height);
        GL11.glVertex2f(x, y+height);
        GL11.glEnd();
    }// end method
}// end class
