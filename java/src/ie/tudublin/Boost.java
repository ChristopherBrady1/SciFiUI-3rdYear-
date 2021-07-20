package ie.tudublin;

import processing.core.PConstants;
public class Boost extends UiObject
{
    public Boost(UI ui, float x, float y )
    {
        super(ui, 0, x, y, 0, 0, 0);
    }

    float size1 = 120;
    float size2 = 90;
    float booster = PConstants.PI + 0.01f;
    float design = 10;
    
    
    

    public void render()
    {
        
        //outside design for boost object
        ui.fill(200);
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.rect(x - size1/2 - design, y- size1/1.25f, size1+design*2, size1+design*4);
        ui.fill(0);
        ui.textSize(20);
        ui.text("Boost Level", x, y- size1/1.5f);

        ui.stroke(0);
        ui.strokeWeight(1);

        //back ellispse
        ui.ellipse(x, y, size1, size1);

        ui.beginShape();
        //boost going up 
        ui.fill(255,255,0);
        ui.arc(x, y, size1, size1, PConstants.PI, booster);
        ui.endShape();

        //checking if booster is full

        if(booster > PConstants.PI + PConstants.TWO_PI){
            ui.fill(255,255,0);
        }
        //inner ellipse
        else{
            ui.fill(255,0,0);
        }
        ui.ellipse(x, y, size2, size2);

        ui.textSize(15);
        if(booster > PConstants.PI + PConstants.TWO_PI){
            ui.fill(0);
            ui.text("BOOST FULL", x, y);
        }
        

    }
	public void update() {
        //booster goes up slowly
        if(booster < PConstants.PI + 0.01f + PConstants.TWO_PI && ! ui.checkKey(' ')){
            booster += 0.006f;
        }

        //booster goes down once space pressed
        
        if(ui.checkKey(' ')){
            booster -= 0.006f ;
            
        }
        
    }
    
    
    
    
    
    
}