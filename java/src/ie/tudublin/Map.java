package ie.tudublin;
import processing.core.PApplet;
import processing.core.PConstants;

import java.util.Random;

public class Map extends UiObject
{
    float h = 250;
    float w = 10;
    float a = 75;
    float gap = 5;

    Random rand = new Random();
    public Map(UI ui, float x, float y)
    {
        super(ui, 0, x, y, 0, 0, 0);
    }

    //generating random numbers for size and location of planets on map
    int RSize1 = rand.nextInt(15);
    int RSize2 = rand.nextInt(15);
    int RSize3 = rand.nextInt(15);
    int RSize4 = rand.nextInt(15);

    int P1x = rand.nextInt(100);
    int P1y = rand.nextInt(100);

    int P2x = rand.nextInt(100);
    int P2y = rand.nextInt(100);

    int P3x = rand.nextInt(100);
    int P3y = rand.nextInt(100);
    
    int P4x = rand.nextInt(100);
    int P4y = rand.nextInt(100);

    //generating random x and ys for the route taken
    int X1 = rand.nextInt(100);
    int X2 = rand.nextInt(100);
    int X3 = rand.nextInt(100);
    int X4 = rand.nextInt(100);


    @Override
    public void render() {

        ui.stroke(255);
        ui.noFill();
        //outline of map
        ui.rectMode(PConstants.CENTER);
        ui.rect(x, y, h+w, h+w);
        ui.rect(x, y, h, h);
        ui.fill(150);
        ui.rect(x, y, h-w, h-w);

        //random planets
        ui.stroke(0, 0, 255);
        ui.fill(0, 0, 255);
        //mapping random planet one
        float x1 = PApplet.map(P1x, 0, 100, x- h/2 + gap, x+h/2 - gap);
        float y1 = PApplet.map(P1y, 0, 100, y- h/2 + gap, y + h/2 - gap);
        ui.circle(x1, y1, RSize1);

        //mapping random planet two
        float x2 = PApplet.map(P2x, 0, 100, x- h/2 + gap, x+h/2 - gap);
        float y2 = PApplet.map(P2y, 0, 100, y- h/2 + gap, y + h/2 - gap);
        ui.circle(x2, y2, RSize2);

        //mapping random planet three
        float x3 = PApplet.map(P3x, 0, 100, x- h/2 + gap, x+h/2 - gap);
        float y3 = PApplet.map(P3y, 0, 100, y- h/2 + gap, y + h/2 - gap);
        ui.circle(x3, y3, RSize3);

        //mapping random planet four
        float x4 = PApplet.map(P4x, 0, 100, x-h/2 + gap, x+h/2 - gap);
        float y4 = PApplet.map(P4y, 0, 100, y- h/2 + gap, y + h/2 - gap);
        ui.circle(x4, y4, RSize4);


        //route taking 
        ui.stroke(255,255,0);
        float coX1 = PApplet.map(X1, 0, 100, x-h/2 + gap, x+h/2 - gap);
        float coX2 = PApplet.map(X2, 0, 100, x-h/2 + gap, x+h/2 - gap);
        float coX3 = PApplet.map(X3, 0, 100, x-h/2 + gap, x+h/2 - gap);
        float coX4 = PApplet.map(X4, 0, 100, x-h/2 + gap, x+h/2 - gap);

        ui.strokeWeight(4);
        ui.line(x, y + h/2 -w, coX1, y+ h/4 -w);
        ui.line(coX1, y+ h/4 -w, coX2, y -w);
        ui.line(coX2, y -w, coX3, y -h/4 + w);
        ui.line(coX3, y -h/4 + w, coX4, y - h/2 + w);

        //exit button
        ui.strokeWeight(1);
        ui.stroke(255);
        ui.fill(20);
        ui.rectMode(PConstants.CENTER);
        ui.rect(x + x/3, y - y/2, a, a/2);
        ui.fill(255);
        ui.textSize(15);
        ui.text("E = exit",x + x/3, y - y/2);

    }

       

    @Override
	public void update() {

        //despawning health if 'e' pressed
        if(ui.checkKey('e')){
            ui.uiObjects.remove(this);
        }
		
    }
}