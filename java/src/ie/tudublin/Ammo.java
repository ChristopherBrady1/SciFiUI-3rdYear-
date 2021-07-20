package ie.tudublin;

import processing.core.PConstants;
public class Ammo extends UiObject
{
    float h = 120;
    float w = 200;
    float g = 20;
    float gap = 40;
    float a = 75;
    
    
    

    public Ammo(UI ui, float x, float y, float speed)
    {
        super(ui, 0, x, y, 0, speed, 0);
    }

    int TotalAmmo = (int)speed;

    @Override
    public void render() {

        //rocket outline
        ui.stroke(255);
        ui.fill(255);
        ui.triangle(x+w/2, y + h/1.5f, x+w/4, y+h, x+w, y+h*1.45f);
        ui.triangle(x-w/2, y + h/1.5f, x-w/4, y+h, x-w, y+h*1.45f);
        //flame outside
        ui.beginShape();
        ui.stroke(255,140,0);
        ui.fill(255,140,0);
        ui.vertex(x, y+h);
        ui.bezierVertex(x, y+h, x + g*4, y + h*1.5f, x, y + h*1.85f);
        ui.bezierVertex(x, y + h*1.85f, x - g*4, y + h*1.5f, x, y+h);
        ui.endShape();
        //flame outside
        ui.beginShape();
        ui.stroke(255,190,0);
        ui.fill(255,190,0);
        ui.vertex(x, y+h);
        ui.bezierVertex(x, y+h, x + g*2.5f, y + h*1.5f, x, y + h*1.85f);
        ui.bezierVertex(x, y + h*1.85f, x - g*2.5f, y + h*1.5f, x, y+h);
        ui.endShape();
        //rocket base
        ui.beginShape();
        ui.fill(255);
        ui.vertex(x, y - h);
        ui.bezierVertex(x, y-h, x + w , y , x + w/2, y +h);
        ui.bezierVertex(x + w/2, y +h, x , y + h*1.5f, x - w/2, y +h);
        ui.bezierVertex(x - w/2, y +h, x - w , y , x, y-h);
        ui.endShape();

        //ammo type text
        ui.fill(0);
        ui.textSize(15);
        ui.text("Ammo Type:", x, y- gap *1.5f);
        ui.textSize(25);
        ui.text("Bullets", x , y-gap/1.5f);

        //ammo image (3 bullets)
        ui.fill(140,96,2);
        ui.stroke(140,96,2);
        if(TotalAmmo > 100){ 
            ui.beginShape();
            ui.vertex(x-g, y);
            ui.bezierVertex(x-g, y,x -g/4, y+g*2, x-g/2, y+g*3);
            ui.vertex(x-g*1.5f, y+g*3);
            ui.bezierVertex(x-g*1.5f, y+g*3, x -g*1.75f, y+g*2, x-g, y);
            ui.endShape();
        }
        // -gap
        if(TotalAmmo > 0){
            ui.beginShape();
            ui.vertex(x-g - gap, y);
            ui.bezierVertex(x-g- gap, y,x -g/4- gap, y+g*2, x-g/2- gap, y+g*3);
            ui.vertex(x-g*1.5f- gap, y+g*3);
            ui.bezierVertex(x-g*1.5f- gap, y+g*3, x -g*1.75f- gap, y+g*2, x-g- gap, y);
            ui.endShape();
        }
        // + gap
        if(TotalAmmo > 200){
            ui.beginShape();
            ui.vertex(x-g+gap, y);
            ui.bezierVertex(x-g+gap, y,x -g/4+gap, y+g*2, x-g/2+gap, y+g*3);
            ui.vertex(x-g*1.5f+gap, y+g*3);
            ui.bezierVertex(x-g*1.5f+gap, y+g*3, x -g*1.75f+gap, y+g*2, x-g+gap, y);
            ui.endShape();
        }

        //equals sign
        ui.rectMode(PConstants.CORNER);
        ui.fill(0);
        ui.stroke(0);
        ui.rect(x + gap *1.5f, y + gap/2, h/3, h/8);
        ui.rect(x + gap *1.5f, y + gap, h/3, h/8);

        
        //text bullets remaining
        ui.textSize(30);
        if(TotalAmmo>0){
            ui.text(TotalAmmo, x - g*2, y + gap*2.2f);
        }
        else{
            ui.text("0", x - g*2, y + gap*2.2f);
        }
        ui.textSize(15);
        ui.text("Bullets", x + g*1.5f, y +gap *2);
        ui.text("Remaining", x + g*1.5f, y + gap *2.5f);
        
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
	public void update() {
        //despawning health if 'e' pressed
        if(ui.checkKey('e')){
            ui.uiObjects.remove(this);
        }

        //if s pressed (shoot)
        if(ui.checkKey('s')&& TotalAmmo >0){
            TotalAmmo --;

        }
		
    }
}