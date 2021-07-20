package ie.tudublin;
import processing.core.PConstants;

public class Health extends UiObject
{
    public Health(UI ui,float frequency, float x, float y, float radius, float speed, float distance)
    {
        super(ui, frequency, x, y, radius, speed, distance);
        
    }


    float a = 75;
    float b = 300;
    //changeable variables for rect 1
    float bChange1 =x;
    //changeable variables for rect 2
    float aChange2 = y; 
    //setting all health items 
    float body = frequency;
    float brain = radius;
    float fNw = speed;
    float lungs = distance;

    float x1 = ui.width/2;
    float y1 = ui.height/2 -100;
    


    public void render()
    {

        //everything inside large circle for design
        ui.fill(255);
        ui.stroke(0,0,255);
        ui.circle(x1, y1, b +a );

        //adding health cross shape (inside colour)
        ui.beginShape();
        ui.stroke(0,0,255);
        ui.fill(0,0,255);
        ui.rectMode(PConstants.CENTER);
        ui.rect(x1, y1, a, b);
        ui.rect(x1,y1,b,a);
        ui.endShape();
        //health shape (outside colour)
        ui.beginShape();
        ui.noStroke();
        ui.fill(255);
        ui.rectMode(PConstants.CORNER);
        ui.rect(x1 -a/2, y1 - b/2, a, bChange1);
        ui.rect(x1 - b/2 ,y1 - a/2 ,b, aChange2);
        ui.endShape();

        //adding text indicators
        ui.fill(0,0,255);
        ui.textSize(20);
        ui.text("BRAIN", x1 - b/3, y1 - b/3);
        ui.text(brain + "%", x1 - b/3, y1 - b/5);
        ui.text("BODY", x1 - b/3, y1 +b/5);
        ui.text(body + "%", x1 - b/3, y1 + b/3);
        ui.text("LUNGS", x1 + b/3, y1- b/3);
        ui.text(lungs + "%",x1 + b/3, y1 - b/5);
        ui.text("FOOD", x1 + b/3, y1 +b/5);
        ui.text("WATER", x1 + b/3, y1 +b/3.5f);
        ui.text(fNw + "%",x1 + b/3, y1 + b/2.7f);

        //exit button
        ui.stroke(255);
        ui.fill(20);
        ui.textSize(15);
        ui.rectMode(PConstants.CENTER);
        ui.rect(x1 + x1/3, y1 - y1/2, a, a/2);
        ui.fill(255);
        ui.text("E = exit",x1 + x1/3, y1 - y1/2);
        
    }

	public void update() {
        
        //despawning health if 'e' pressed
        if(ui.checkKey('e')){
            ui.uiObjects.remove(this);
        }
    }
}