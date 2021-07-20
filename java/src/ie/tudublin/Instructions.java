package ie.tudublin;


public class Instructions extends UiObject
{
    float h = 50;
    float w = 200;
    
    public Instructions(UI ui, float x, float y)
    {
        super(ui, 0, x, y, 0, 0, 0);
    }


    @Override
    public void render() {
        //drawing instruction buttons
        ui.strokeWeight(4);
        ui.stroke(255,0,0);
        ui.fill(200);
        ui.rect(x, y, w, h);
        ui.fill(0);
        ui.textSize(25);
        ui.text(" S = Shoot ", x, y);
        ui.fill(200);
        ui.rect(ui.width - x, y, w, h);
        ui.fill(0);
        ui.textSize(25);
        ui.text(" Space = Boost ", ui.width - x, y);
        ui.strokeWeight(1);
    }

    @Override
    public void update() {

    }

}
