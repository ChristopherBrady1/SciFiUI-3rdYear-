package ie.tudublin;

import java.util.Random;


public class Stars extends UiObject {
    

    Random rand = new Random();
    //star size    
    float S_Size1 = -10;
    float S_Size2 = -10;
    
    

    public Stars(UI ui, float x, float y, float speed)
    {
        super(ui, 0, x, y, 0, speed, 0);
        
    }

    //stars spawn points
    float S1x = x;
    float S1y = rand.nextInt(800);
    float S2x = x;
    float S2y = rand.nextInt(800);




    
    public void render()
    {
        ui.pushMatrix();

        
        //DRAWING Stars
        if(S_Size1>0){
            ui.stroke(218,165,32);
            ui.fill(218,165,32);
            ui.circle(S1x, S1y, S_Size1);
        }
        if(S_Size2>0){
            ui.stroke(218,165,32);
            ui.fill(218,165,32);
            ui.circle(S2x, S2y, S_Size2);
        }
        
        ui.popMatrix();
    }
    
    float speedY = .2f;
    
    public void update()
    {
        
        //sizing each star
        if(S_Size1 > 10){
            S_Size1 += .01f;
        }
        else{
            S_Size1 += .1f;
        }
        if(S_Size2 > 10){
            S_Size2 += .01f;
        }
        else{
            S_Size2 += .1f;
        }
        
        
        //star movement
        if(S_Size1>=0){
            
            if(S1y == y) {
                S1x += speed;
            }
            if (S1y > y) {
                S1x += speed;
                S1y += speedY;

            }
            if (S1y < y) {
                S1x += speed;
                S1y -= speedY;

            }
        }
        //using boost
        if(S_Size1>=0 && ui.checkKey(' ') ){
            
            if(S1y == y) {
                S1x += speed*2;
            }
            if (S1y > y) {
                S1x += speed*2;
                S1y += speedY;

            }
            if (S1y < y) {
                S1x += speed*2;
                S1y -= speedY;

            }
        }
        
        if(S_Size2>=0){
            
            if(S2y == y) {
                S2x -= speed;
            }
            if (S2y > y) {
                S2x -= speed;
                S2y += speedY;

            }
            if (S2y < y) {
                S2x -= speed;
                S2y -= speedY;

            }
        }
        //using boost
        if(S_Size2>=0 && ui.checkKey(' ') ){
            
            if(S2y == y) {
                S2x -= speed*2;
            }
            if (S2y > y) {
                S2x -= speed*2;
                S2y += speedY;

            }
            if (S2y < y) {
                S2x -= speed*2;
                S2y -= speedY;

            }
        }
        

        spawned += ui.timeDelta;
        if(spawned >= 16.0){
            ui.uiObjects.remove(this);
        }
    }
    float spawned;
    float booster;
        
}

    
