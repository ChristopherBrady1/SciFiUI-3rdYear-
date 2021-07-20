package ie.tudublin;

import processing.core.PApplet;

public class Buttons extends UiObject
{
    float h = 50;
    float w = 230;
    float desGap = 10;
    public Buttons(UI ui, float x, float y)
    {
        super(ui, 0, x, y, 0, 0, 0);
    }

    public void render()
    {
        
        //outside design of button 1
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.rectMode(PApplet.CORNER);
        ui.fill(200);
        ui.rect(x-h - desGap, y-h/2 -desGap, w + desGap*2 ,h + desGap*2 );
        
        //button 1 design
        ui.stroke(0);
        ui.strokeWeight(3);
        if(ui.mouseX >= x- h && ui.mouseX <= x-h + w ){
            if(ui.mouseY >= y-h/2 && ui.mouseY <= y+h/2){
                ui.fill(121,144,220);
            }
            else{
                ui.fill(233,58,58);
            }   
        }
        else{
            ui.fill(233,58,58);
        }
        ui.rect(x-h, y-h/2, w, h);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(h/2);
        ui.text("Health", x + h + 10, y -h/6 );

        
        //outside design of button 2
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.fill(200);
        ui.rect((x*2 + x/2) - desGap, y-h/2 -desGap, w + desGap*2 ,h + desGap*2 );
        
        //button 2 design
        ui.stroke(0);
        ui.strokeWeight(3);
        if(ui.mouseX >= (x*2 + x/2) && ui.mouseX <= (x*2 + x/2) + w ){
            if(ui.mouseY >= y-h/2 && ui.mouseY <= y+ h/2){
                ui.fill(121,144,220);
            }
            else{
                ui.fill(233,58,58);
            }
        }
        else{
            ui.fill(233,58,58);
        }
        ui.rect((x*2 + x/2), y-h/2, w, h);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(h/2);
        ui.text("Map", (x*2 + x/2) + h*2, y -h/6 );

        //outside design of button 3
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.fill(200);
        ui.rect(x-h-desGap, y+h -desGap, w + desGap*2 ,h + desGap*2 );

        //button 3 design
        ui.stroke(0);
        ui.strokeWeight(3);
        if(ui.mouseX >= x-h && ui.mouseX <= (x-h) + w ){
            if(ui.mouseY >= y+h && ui.mouseY <= y+h*2){
                ui.fill(121,144,220);
            }
            else{
                ui.fill(233,58,58);
            }
        }
        else{
            ui.fill(233,58,58);
        }
        ui.rect(x-h, y+h, w, h);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(h/2);
        ui.text("Ammo", x + h + 10, y+h+20 );

        //outside design of button 4
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.fill(200);
        ui.rect((x*2 + x/2)-desGap, y+h -desGap, w + desGap*2 ,h + desGap*2 );

        //button 4 design
        if(ui.mouseX >= (x*2 + x/2) && ui.mouseX <= (x*2 + x/2) + w ){
            if(ui.mouseY >= y+h && ui.mouseY <= y + h*2){
                ui.fill(121,144,220);
            }
            else{
                ui.fill(233,58,58);
            }
        }
        else{
            ui.fill(233,58,58);
        }
        ui.rect((x*2 + x/2), y+h, w, h);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(h/2);
        ui.text("Distance", (x*2 + x/2) + h*2 +10, y+h+20 );
    }

    public void update(){
        
    }
    
}