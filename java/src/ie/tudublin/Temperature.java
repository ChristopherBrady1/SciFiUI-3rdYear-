package ie.tudublin;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PConstants;

public class Temperature extends UiObject
{
    public Temperature(UI ui, float x, float y)
    {
        super(ui, 0, x, y, 0, 0, 0);
    }

    //arc variable
    float arc_1 = PApplet.PI + PApplet.HALF_PI;
    float size1 = 120;
    float size2 = 100;
    float deg = 0;
    float design = 10;
    Random rand = new Random();

    public void render()
    {
        //design around temperature object
        
        ui.fill(200);
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.rectMode(PConstants.CENTER);
        ui.rect(x , y- size1/4, size1 + design*2, size1 + design);
        ui.fill(0);
        ui.textSize(20);
        ui.text("Temperature", x, y- size1/1.5f);

        //temperature design
        ui.beginShape();
        ui.strokeWeight(1);
        ui.fill(0,0,255);
        ui.arc(x, y, size1, size1, PApplet.PI, PApplet.TWO_PI, PApplet.CHORD);
        ui.fill(255, 0, 0);
        ui.arc(x, y, size1, size1, PApplet.PI, arc_1);
        ui.fill(0);
        ui.arc(x, y, size2, size2, PApplet.PI, PApplet.TWO_PI, PApplet.CHORD);
        
        //allowing only 1 decimal place for temperature
        String Degrees = ui.nf(deg, 2, 1);
        ui.fill(255);
        ui.textSize(15);
        ui.text(Degrees+"°C", x, y -20);
        
        ui.endShape();
        
    }
    float time; 
    
	public void update() {
        time += ui.timeDelta;
        //randomising temperature every 0.2 seconds
        if(time > 0.2){
            arc_1 = PApplet.PI + rand.nextFloat()*(PApplet.TWO_PI - PApplet.PI);
            deg = PApplet.map(arc_1, PApplet.PI, PApplet.TWO_PI,-40, 40);
            time =0;
            
        }
        
       
    }
}