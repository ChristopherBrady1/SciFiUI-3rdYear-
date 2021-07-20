package ie.tudublin;

import java.util.Random;

import processing.core.PConstants;


public class Distance extends UiObject
{
    float h = 260;
    float w = 600;
    float gap = 20;
    float a = 75;
    Random rand = new Random();
    public Distance(UI ui, float x, float y, float distance)
    {
        super(ui, 0, x, y, 0, 0, distance);
    }
    float distanceTravelled= 0;
    //average speed  km/s of a spaceship in orbit is 7.77
    float speedTravelled = 7.77f;
    float distTime =0;


    float time;
    float startPointX = x  - w/2 + gap;
    float startPointY = y + h/2 - gap;
    float endPointX = x + w/2 -gap;
    float endPointY = y - h/2 + gap;

    //values for line graph
    float prevX = startPointX;
    float prevY = startPointY;
    float currentX = prevX;
    float currentY =prevY;
   
    @Override
	public void update() {
        
        ui.stroke(255);
        ui.fill(30);
        ui.rect(x, y, w, h);

        //y axis ( distance )
        ui.line(startPointX, startPointY, startPointX, endPointY);
        ui.fill(255);
        ui.textSize(15);
        ui.text("Distance", x -gap*4 , startPointY + gap*2 );
        ui.text( distanceTravelled + "km" ,  x + gap, startPointY + gap*2);
        //x axis ( time )
        ui.line(startPointX, startPointY, endPointX, startPointY);
        ui.fill(255);
        ui.text("Time " , startPointX - gap*2, y);
        ui.text(time + "seconds", startPointX - gap*2, y + gap*2);


        
        //distance graph
        if((distanceTravelled*2 + startPointX) <= endPointX &&  startPointY- time*3 >= endPointY){
            ui.line(prevX, prevY, distanceTravelled*2 + startPointX, startPointY- time*3);
        }
        else{
            distanceTravelled = 0;
            time = 0                       ;
        }
        
        

        //exit button
        ui.stroke(255);
        ui.fill(20);
        ui.rectMode(PConstants.CENTER);
        ui.rect(x + x/3, y - y/2, a, a/2);
        ui.fill(255);
        ui.textSize(15);
        ui.text("E = exit",x + x/3, y - y/2);
		
    }

    @Override
    public void render() {

        

            
        //despawning health if 'e' pressed
        if(ui.checkKey('e')){
            ui.uiObjects.remove(this);
        }
    
        time += ui.timeDelta;

        distTime += ui.timeDelta;
        if(distTime > 0.001){
            if(ui.checkKey(' ')){
                distanceTravelled += speedTravelled/30;
            }
            else{
                distanceTravelled += speedTravelled/60;
            }
            distTime = 0;
        }

    
        
    }
    
}
    