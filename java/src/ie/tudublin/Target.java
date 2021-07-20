package ie.tudublin;

import processing.core.PConstants;

public class Target extends UiObject
{
    int size = 50;

    public int fireRate;


    public Target(UI ui, float x, float y)
    {
        super(ui, x, y, 0, 0, 0, 0);
        
        

    }

    public void render()
    {
        ui.pushMatrix();
        
        
        ui.stroke(0, 255, 0);
        ui.noFill();
        ui.rectMode(PConstants.CENTER);

        float circleSize = size / 9;
        
        ui.rect(ui.mouseX, ui.mouseY, size, size);

        ui.fill(0,255,0);
        ui.circle(ui.mouseX, ui.mouseY, circleSize);
        ui.line(ui.mouseX - size/1.5f , ui.mouseY , ui.mouseX - size/3, ui.mouseY);
        ui.line(ui.mouseX + size/1.5f , ui.mouseY , ui.mouseX + size/3, ui.mouseY);
        ui.line(ui.mouseX , ui.mouseY + size/1.5f  , ui.mouseX , ui.mouseY + size/3);
        ui.line(ui.mouseX  , ui.mouseY - size/1.5f, ui.mouseX , ui.mouseY - size/3);

        
        
        ui.popMatrix();
    }

    public void update()
    {
        
        
        
    }

    
}