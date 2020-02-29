package es.games.smoko;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {
	//razmer na prozoreca
	private int mWidth = 600; 
	private int mHeight = 600;
	
	private static ApplicationWindow mWindow = null;
	
	private ApplicationWindow()
  	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		SetDimension( mWidth,  mHeight);
		setResizable(false);
		setVisible(true);		
	
		Smoko Y = new Smoko ();
		
		add(Y);
		
	}
	
	 //statichna funkciq(za da se otvori samo edin prozorec)
	public static ApplicationWindow BringWindow() 
	{
		
		if(mWindow==null)
			mWindow = new ApplicationWindow();
		
		return mWindow;
	}
	
	//za centrirane na prozoreca
	public void  SetDimension(int Width, int Height)
	{
		Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		//ot kade shte pochne da se  pozicionira
		int PosX = 0;
		int PosY = 0;
	
	//izvajdame 100 ot obshtiq razmer na ekrana na pc(samo kogato e po-golqm ot 100)
	if(mWidth+100> Dim.width)
			mWidth = Dim.width-100;
	if(mHeight+100> Dim.height);
			mHeight = Dim.height-100;
			
			//namirane na poziciq(ot razmera na ekrana izvajdame razmera na prozoreca,polucheniq rezultat razdelqame na 2 i namirame  X poziciqta )
			PosX = (Dim.width-mWidth)/2;
			PosY = (Dim.height-mHeight)/2;
			
			//aktivirane sas setBounds.
			setBounds(PosX, PosY, mWidth,mHeight);
	}
	
	private void restart() {
		// TODO Auto-generated method stub
		
	}

	private void start() {
		// TODO Auto-generated method stub
		
	}
}
