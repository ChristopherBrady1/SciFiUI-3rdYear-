package ie.tudublin;


public class Speedometer extends UiObject
{
    
    
    public Speedometer(UI ui, float x, float y, float speed)
    {
        super(ui, 0, x, y, 0, speed, 0);
    }

    float size = 200;
    float DesSize = 275;
    float desGap = 20;
    //twelfth 
    float twth = 1/12f;
    //1 and 1 twelfth
    float oNot = 1 + twth;
    public float theta =0;


   

    @Override
    public void render() {

        //oustide design of speedometer
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.beginShape();
        ui.fill(200);
        ui.vertex(x-size*.7f, y + desGap);
        ui.vertex(x +size*.7f , y + desGap);
        ui.vertex(x +size*.7f , y - size/2.5f);
        ui.vertex(x + size * .3f , y - size/1.35f);
        ui.vertex(x - size * .3f , y - size/1.35f);
        ui.vertex(x -size*.7f , y - size/2.5f);
        ui.vertex(x-size*.7f, y + desGap);
        ui.endShape();
        

        //drawing the design of speedometer
        ui.beginShape();
        ui.strokeWeight(1);
        ui.stroke(0);
        ui.fill(0,0,255);
        ui.arc(x, y, size*1.25f, size*1.25f, speed, speed*2 );
        ui.fill(21,0,234);
        ui.arc(x, y, size*1.25f, size*1.25f, speed *oNot , speed*2);
        ui.fill(43,0,212);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth) , speed*2 );
        ui.fill(64,0,191);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*2), speed*2 );
        ui.fill(85,0,170);
        ui.arc(x, y, size*1.25f, size*1.25f, speed *(oNot + twth*3f), speed*2 );
        ui.fill(106,0,149);
        ui.arc(x, y, size*1.25f, size*1.25f, speed *(oNot + twth*4f), speed*2 );
        ui.fill(128,0,128);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*5f), speed*2 );
        ui.fill(149,0,106);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*6f), speed*2 );
        ui.fill(170,0,85);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*7f), speed*2 );
        ui.fill(191,0,64);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*8f), speed*2 );
        ui.fill(212,0,43);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*9f), speed*2 );
        ui.fill(234,0,21);
        ui.arc(x, y, size*1.25f, size*1.25f, speed * (oNot + twth*10f), speed*2 );
        ui.fill(255);
        ui.arc(x, y, size, size, speed, speed*2 );
        
        ui.endShape();

        //drawing arrow

        float x2 = pos.x + (float) Math.sin(theta) * size/2;
        float y2 = pos.y - (float) Math.cos(theta) * size/2;
        
        ui.line(pos.x, pos.y, x2, y2);
        ui.fill(0);
        ui.circle(x2, y2, 10);

        ui.arc(x, y, size * .75f, size * .75f, speed, speed*2 );
        ui.fill(255);
        ui.textSize(20);
        if(!ui.checkKey(' ')){
            ui.text("28000 Km/h", x, y - 15);
        }
        else{
            ui.text("42000 Km/h", x, y - 15);
        }
        
        
    }

    @Override
	public void update() {

        theta = 2 * speed;
        if(ui.checkKey(' ')){
            
            theta += speed/4;
            
        }
        
    }
}