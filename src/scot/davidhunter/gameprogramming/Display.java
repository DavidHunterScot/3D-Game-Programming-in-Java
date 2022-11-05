package scot.davidhunter.gameprogramming;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import scot.davidhunter.gameprogramming.graphics.Screen;

public class Display extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "3D Game Programming in Java";
	
	private Thread thread;
	private boolean running = false;
	private Screen screen;
	private BufferedImage img;
	private int[] pixels;
	
	public Display()
	{
		screen = new Screen( WIDTH, HEIGHT );
		img = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB );
		pixels = ( (DataBufferInt) img.getRaster().getDataBuffer() ).getData();
	}
	
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
			tick();
			render();
		}
	}
	
	private void tick()
	{
		
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if ( bs == null )
		{
			createBufferStrategy( 3 );
			return;
		}
		
		screen.render();
		
		for ( int i = 0; i < WIDTH * HEIGHT; i++ )
		{
			pixels[ i ] = screen.pixels[ i ];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage( img, 0, 0, WIDTH, HEIGHT, null );
		g.dispose();
		bs.show();
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
