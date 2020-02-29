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
import javax.swing.*;

public class Smoko extends JLabel {

	public Cell mHead = new Cell ();
	
	public Timer mTimer = null;
	
	@Override

	public void paint(Graphics g) {
		
		super.paint(g);
				
		Graphics2D g2= (Graphics2D)g;
		Rectangle2D rect = new Rectangle2D.Double(5, 5, getWidth()-10,getHeight()-10 );
		
		g2.setColor(Color.red);
		
		g2.setStroke(new BasicStroke(10));
		
		g2.draw(rect);
	}
	public Smoko() 
	{
		
		
		addKeyListener(new KeyboardControl() );
		setFocusable(true);
		
		mTimer = new Timer(100, new TimerControl());
		mTimer.start();
		add(mHead);
		
	}
	class KeyboardControl implements KeyListener
    {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
		}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		{
			mHead.mDirection = Router.LEFT;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		{
			mHead.mDirection = Router.RIGHT;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			mHead.mDirection = Router.UP;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		{
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
		
			mHead.Movement();
		}
		
	}
	
	
}
