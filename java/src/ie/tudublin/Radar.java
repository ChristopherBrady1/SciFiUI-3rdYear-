package ie.tudublin;


import processing.core.PVector;
import processing.core.PApplet;

public class Radar extends UiObject
{
    
    private float theta = 0;

    public Radar(UI ui, float frequency, float x, float y, float radius)
    {
        super(ui, frequency, x, y, radius, 0, 0);
    }

    public void render()
    {

        ui.fill(233,161,161);
        ui.stroke(255,0,0);
        ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        ui.ellipse(pos.x, pos.y, radius *1.5f, radius * 1.5f);
        ui.ellipse(pos.x, pos.y, radius, radius);
        ui.ellipse(pos.x, pos.y, radius /2, radius / 2);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y - (float) Math.cos(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
    }

    float timeDelta = 1.0f / 60.0f;

    public void update()
    {
        theta += PApplet.TWO_PI * timeDelta * frequency;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    
}