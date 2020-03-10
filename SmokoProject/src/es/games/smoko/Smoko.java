 package es.games.smoko;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Smoko extends JLabel {

	public Cell 	mHead 		= new Cell ();	 //
	public Timer	mTimer 		= null; 		//promenliva za vreme (timer pirnadleji na swing)
	public Food 	mFood 		= new Food (); 		
	public Random  	mRandom		= null;
	public ArrayList<Cell> List = new ArrayList<Cell>();
	
	
	@Override

	public void paint(Graphics g) {
		
		super.paint(g);
				
		Graphics2D g2= (Graphics2D)g;
		Rectangle2D rect = new Rectangle2D.Double(5, 5, getWidth()-10,getHeight()-10 );
		
		g2.setColor(Color.red);
		
		g2.setStroke(new BasicStroke(10));
		
		g2.draw(rect);
	}
	 Smoko() 
	{
		
		mRandom = new Random(System.currentTimeMillis());
		addKeyListener(new KeyboardControl() );
		setFocusable(true);
		
		mTimer = new Timer(100, new TimerControl());
		mTimer.start();
		
		List.add(mHead);
		
		for(int i = 1; i < 1; i++ ) //daljina na zmiqta
		{
			
			LineAdd();
		}
		add(mFood);
		add(mHead);
		
	}
	 public void LineAdd() 
	 { //dobavqne na opashka
		 
		 Cell C = List.get(List.size()-1).CellCreate(); 
			
		 List.add(C);
		 add(C);
	 }
	 
	 
	 public void FoodAdd()
	 {
		 int Width = getWidth()-30-mFood.mWidth;
		 int Height =getHeight()-30-mFood.mWidth;
		 
		 int PosX = 10+Math.abs(mRandom.nextInt())%Width;
		 int PosY = 10+Math.abs(mRandom.nextInt())%Height;
		 
		 
		 
		 PosX = PosX - PosX%20;
		 PosY = PosY - PosY%20;
		 
		 for (int i=0; i<List.size(); i++) 
		 {
			 if((PosX==List.get(i).getX())&&(PosY==List.get(i).getY()))
					 {
					 	 FoodAdd();
					 	 return;
					 }
		 }
		 
		 
		 mFood.setPosition(PosX, PosY);
		 
		 
		 
	 }
	 
	 
	 public void MovementAll()
	 {
		 for(int i =List.size()-1; i>0 ; i--)
		 	{
			 	Cell Previos = List.get(i-1);
			 	Cell Next = List.get(i);
			 
			 	
			 	List.get(i).Movement();
			 	
			 	Next.mDirection = Previos.mDirection;
		 	}
		 mHead.Movement();
		}
	 
	 public boolean IsThereCollision()
	 {
		 
		 int Pen = 10;
		 
		 int Width	=  getWidth();
		 int Height = getHeight();
		 
		 if(mHead.getX() <= 10)
			 return true;
		 if(mHead.getX() + mHead.mWidth>= Width - Pen)
			 return true;
		 
		 if(mHead.getY() <= 10)
			 return true;
	     if(mHead.getY() + mHead.mWidth>= Height - Pen)
	    	 return true;
	     
		 for(int i=1; i<List.size(); i++)
		 {
			 int X = List.get(i).getX();
			 int Y  = List.get(i).getY();
			 
			 if((X==mHead.getX())&&(Y==mHead.getY()))
				 return true;
		 }
	     
		 
		 if((mFood.getX()==mHead.getX())&&(mFood.getY()==mHead.getY()))
		 {
			 LineAdd();
			 FoodAdd();
		 }
	     
		return false;
	 }
	 
	class KeyboardControl implements KeyListener
    {

	public void keyTyped(KeyEvent e) {
		
		}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		{
			if(mHead.mDirection!= Router.RIGHT)
				mHead.mDirection = Router.LEFT;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		{
			if(mHead.mDirection!= Router.LEFT)
				mHead.mDirection = Router.RIGHT;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(mHead.mDirection!= Router.DOWN)
				mHead.mDirection = Router.UP;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		{
			if(mHead.mDirection!= Router.UP)
				mHead.mDirection = Router.DOWN;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
    }

	class TimerControl implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
		
				
			MovementAll();
			if(IsThereCollision())
				mTimer.stop();		
		}
		
	}
	
	
}
