package ie.tudublin;

import java.util.Random;



public class Planet extends UiObject {
    int size = 50;
    int[][] planetcolours = {{255,0,0},{0,255,0},{0,0,255},{255,0,127},
    {102,0,204},{0,255,128},{51,255,255},{102,0,0}};
    
    

    
    Random rand = new Random();
    //PLANETS
    //picking a colour
    int Pnum1 = rand.nextInt(7);
    int Pnum2 = rand.nextInt(7);
    //planet size    
    float PSize1 = -20;
    float PSize2 = 0;

    public Planet(UI ui, float x, float y, float speed)
    {
        super(ui, 0, x, y, 0, speed, 0);
        
    }

    //planets spawn points
    float P1x = x;
    float P2x = x;
    float P1y = y - rand.nextInt(300);
    float P2y = y - rand.nextInt(300);
    



    
    public void render()
    {
        ui.pushMatrix();
        
        //DRAWING PLANETS
         //planet left side
        if(PSize1>0){
        ui.stroke(planetcolours[Pnum1][0], planetcolours[Pnum1][1], planetcolours[Pnum1][2]);
        ui.fill(planetcolours[Pnum1][0], planetcolours[Pnum1][1], planetcolours[Pnum1][2]);           
        ui.circle(P1x,P1y,PSize1);
        }
        //planet right side
        if(PSize2>0){
        ui.stroke(planetcolours[Pnum2][0], planetcolours[Pnum2][1], planetcolours[Pnum2][2]);
        ui.fill(planetcolours[Pnum2][0], planetcolours[Pnum2][1], planetcolours[Pnum2][2]);
        ui.circle(P2x,P2y,PSize2);
        }
          
            
        ui.popMatrix();
    }
    
    public void update()
    {
        //planet movement
        PSize1 += rand.nextFloat();
        PSize2 += rand.nextFloat();

        //planet1
        //booster
        if(ui.checkKey(' ') && PSize1>=0){
            if(P1y == y){
                P1x -= speed*2;
            }
            if(P1y > y){
                P1x -= speed*2;
                P1y += .5;

            }
            if(P1y < y){
                P1x -= speed*2;
                P1y -= .5;

            }
        }
        else if(PSize1>=0 ){
            if(P1y == y){
                P1x -= speed;
            }
            if(P1y > y){
                P1x -= speed;
                P1y += .5;

            }
            if(P1y < y){
                P1x -= speed;
                P1y -= .5;

            }
        }


        //booster
        if(ui.checkKey(' ') && PSize2>=0 ){
            if(P2y == y){
                P2x += speed*2;
            }
            if(P2y > y){
                P2x += speed*2;
                P2y += .5;

            }
            if(P2y < y){
                P2x += speed*2;
                P2y -= .5;

            }
        }
        else if(PSize2>=0){
            if(P2y == y){
                P2x += speed;
            }
            if(P2y > y){
                P2x += speed;
                P2y += .5;

            }
            if(P2y < y){
                P2x += speed;
                P2y -= .5;

            }
        }

        //if a planet is shot
        if(ui.checkKey('s')){
            if(ui.mouseX < P1x +PSize1/2 && ui.mouseX > P1x- PSize1/2){
                if(ui.mouseY < P1y + PSize1/2 && ui.mouseY > P1y -PSize1/2){
                    //making planet dissapear
                    PSize1 = -400;
                }
            }
            if(ui.mouseX < P2x +PSize2/2 && ui.mouseX > P2x-PSize2/2){
                if(ui.mouseY < P2y + PSize2/2 && ui.mouseY > P2y -PSize2/2){
                    //making planet dissapear
                    PSize2 = -400;
                }
            }
        }
        
        spawned += ui.timeDelta;
        if(spawned >= 16.0){
            ui.uiObjects.remove(this);
        }
    
    
        
    }
    float spawned;

        
}

    
