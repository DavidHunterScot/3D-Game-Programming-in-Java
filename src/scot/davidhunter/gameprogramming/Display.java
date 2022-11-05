package scot.davidhunter.gameprogramming;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "3D Game Programming in Java";
	
	private Thread thread;
	private boolean running = false;
	
	private void start()
	{
		if ( running )
			return;
		
		running = true;
		thread = new Thread( this );
		thread.start();
	}
	
	public void stop()
	{
		if ( ! running )
			return;
		
		running = false;
		
		try
		{
			thread.join();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			System.exit( 0 );
		}
	}
	
	public void run()
	{
		while ( running )
		{
			
		}
	}
	
	public static void main( String[] args )
	{
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add( game );
		frame.pack();
		frame.setTitle( TITLE );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( WIDTH, HEIGHT );
		frame.setLocationRelativeTo( null );
		frame.setResizable( false );
		frame.setVisible( true );
		
		game.start();
	}
}
