package ie.tudublin;

public class Helmet extends UiObject
{

    public Helmet(UI ui, float x, float y)
    {
        super(ui, 0, x, y, 0, 0, 0);
    }

    float gap1 = x / 10f;
    float gap2 = x / 8f;
    float halfW = x/2;
    float halfH = y/2;
    float design = 10;
    public void render()
    {
        ui.beginShape();
        ui.strokeWeight(4);
        ui.noStroke();
        ui.fill(255);
        //ui.noFill();
        
        //outside shape
        ui.vertex(0, 0);
        ui.vertex(0,y);
        ui.vertex(x, y);
        ui.vertex(x, 0);
        //inside shape
        ui.beginContour();
        ui.stroke(255, 0, 0);
        ui.vertex(gap2, gap1);
        ui.vertex(halfW, gap1/2);
        ui.vertex(x- gap2, gap1);
        ui.vertex(x- gap2, y - gap1*2);
        ui.vertex(x- gap2*2,  y- (gap1 + gap1/2));
        ui.vertex(halfW + gap2, y- (gap1 + gap1/2));
        ui.vertex(halfW + gap2/2, y- gap1*2);
        ui.vertex(halfW - gap2/2, y- gap1*2);
        ui.vertex(halfW - gap2 , y- (gap1 + gap1/2));
        ui.vertex(gap2*2, y- (gap1 + gap1/2));
        ui.vertex(gap2, y - gap1*2);
        ui.vertex(gap2, gap1);
        ui.endContour();
        ui.endShape();

        //design shapes
        ui.stroke(255,0,0);
        
        ui.line(gap2 -design, gap1 -design, halfW, gap1/2-design);
        ui.line(halfW , gap1/2 -design,x- gap2+design, gap1 -design);
        ui.line(x- gap2+design, gap1 -design, x- gap2 + design, y - gap1*2 +design);
        ui.line(x- gap2 + design, y - gap1*2 +design, x- gap2*2 + design,  y- (gap1 + gap1/2) +design);
        ui.line(x- gap2*2 + design,  y- (gap1 + gap1/2) +design,halfW + gap2 - design, y- (gap1 + gap1/2)+design);
        //bottom 3 lines
        ui.line(halfW + gap2 - design, y- (gap1 + gap1/2)+design,halfW + gap2/2 - design, y- gap1*2 + design);
        ui.line(halfW + gap2/2 - design, y- gap1*2 + design,halfW - gap2/2 +design , y- gap1*2 +design);
        ui.line(halfW - gap2/2 +design , y- gap1*2 +design,halfW - gap2 +design , y- (gap1 + gap1/2) + design);
        //left side
        ui.line(halfW - gap2 +design , y- (gap1 + gap1/2) + design,gap2*2 -design, y- (gap1 + gap1/2)+design);
        ui.line(gap2*2 -design, y- (gap1 + gap1/2)+design,gap2 -design, y - gap1*2 +design);
        ui.line(gap2 -design, y - gap1*2 +design,gap2 -design, gap1 -design);
       
        ui.strokeWeight(1);
    }

    

    public void update()
    {
        
    }

}