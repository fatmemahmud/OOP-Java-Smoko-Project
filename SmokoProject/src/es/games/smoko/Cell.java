package es.games.smoko;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

public class Cell extends JLabel{
	
	public int mWidth 		= 20;
	public int mDirection 	= Router.RIGHT;
	private Cell Cell;

	Cell() 
    {
		
		
    	setBounds(100, 100, mWidth, mWidth);
    	
    }
    
    @Override
       public void paint(Graphics g) 
       {
    	   
    	Graphics2D g2= (Graphics2D)g;
		Rectangle2D rect = new Rectangle2D.Double(1, 1, getWidth()-2,getHeight()-2 );
		
		g2.setColor(Color.black);
		
		g2.setStroke(new BasicStroke(2));
		
		g2.draw(rect);
		
		g2.setColor(Color.green);
		
		g2.fill(rect);
       }
  
 public void LeftGo() {
	 int PosX = getX();
	 int PosY = getY();
	 
	 PosX-=mWidth;
	 setBounds(PosX, PosY, mWidth, mWidth);
}
 public void RightGo() {
	 int PosX = getX(); 
	 int PosY = getY();
	 
	 PosX+=mWidth;
	 setBounds(PosX, PosY, mWidth, mWidth);
	
 }
 public void UpGo() {
	 int PosX = getX();
	 int PosY = getY();
	 
	 PosY-=mWidth;
	 setBounds(PosX, PosY, mWidth, mWidth);
	 
 }
 public void DownGo() {
	 int PosX = getX();
	 int PosY = getY();
	 
	 PosY+=mWidth;
	 setBounds(PosX, PosY, mWidth, mWidth);
 }
 public Cell CellCreate() 
 {
	 Cell C = new Cell();
	 
	 int X = getX();
	 int Y = getY();
	 
	 C.setBounds(X,Y,mWidth,mWidth);
	 
	 C.mDirection = - mDirection;
	 
	 C.Movement();
	 
	 C.mDirection = mDirection;
	 
	return C;
	 
 }
 
 public void  Movement() { // funkciq za opredelqne na posokata 
	 
	  if(mDirection == Router.LEFT)
		  LeftGo();
	  else 
		  if(mDirection ==Router.RIGHT)
		  RightGo();
	  else
		  if(mDirection == Router.UP)
		UpGo();
	  else
		  if(mDirection == Router.DOWN)
			DownGo();
 }
 
 
}
