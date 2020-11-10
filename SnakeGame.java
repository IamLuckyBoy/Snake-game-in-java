import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DDemo extends JFrame
{
	FDemo obj;
	DDemo()
	{
		setTitle("Snake Game By LUCKY");
		obj = new FDemo();
		add(obj);
	}
}

class FDemo extends JPanel implements ActionListener,KeyListener
{
	ImageIcon img1,img2,img3;
	Image dot,head,food;
	int dots = 5;
	int[] x = new int[1000];
	int[] y = new int[1000];
	int r1=0,r2=0;
	Timer t;
	int F_height = 700;
	int F_width = 1000;
	
	boolean Start = false;
	boolean left=false,right=true,up=false,down=false;
	Font f = new Font("arial",Font.BOLD,30);
	Font f1 = new Font("arial",Font.BOLD,20);
	
	
	
	FDemo()
	{
		x[0] = 120;
		y[0] = 120;
		x[1] = 100;
		y[1] = 120;
		x[2] = 80;
		y[2] = 120;
		x[3] = 60;
		y[3] = 120;
		x[4] = 40;
		y[4] = 120;
		
		setBackground(Color.black);
		img1 = new ImageIcon("dot.png");
		img2 = new ImageIcon("head.png");
		img3 = new ImageIcon("food.png");
		dot = img1.getImage();
		head = img2.getImage();
		food = img3.getImage();
		
		t = new Timer(100,this);
	    t.start();
	    addKeyListener(this);
		setFocusable(true);
		random();
	
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	
		g.drawImage(food,r1,r2,this);
		
		for(int i=0;i<dots;i++)
		{
		  if(i==0)
		  {
		    g.drawImage(head,x[i],y[i],this);			
		  }
		    else
		  {
		    g.drawImage(dot,x[i],y[i],this);
		  }			
	    }
		for(int i=1;i<x.length;i++)
		{
			if(x[0]==x[i] && y[0]==y[i] || x[0]>F_width || x[0]<0 ||y[0]<0 || y[0]>F_height)
			{
				t.stop();
				right=false;
				left=false;
				up=false;
				down=false;
				
				g.setColor(Color.white);
				g.setFont(f);
				g.drawString("Game Over",500,250);
				
				g.setFont(f1);
				// g.drawString("Press SPACE To Restart",500,300);
				g.drawString("Press Q To QUIT",500,350);
			}
		}
		
		
	}
	void random()
	{
		r1 = (int)Math.round(Math.random()*30+1);
		r1*=20;
		r2 = (int)Math.round(Math.random()*30+1);
		r2*=20;
	}
	
	public void actionPerformed(ActionEvent e)
    {
		if(x[0] == r1 && y[0] == r2)
		{
			dots++;
			random();
		}
		
		
			
	    if(Start)
		{
		 for(int i=dots;i>0;i--)
		 {
			x[i] = x[i-1];
			y[i] = y[i-1];
		 } 
		   if(right)
		   {
		    x[0]=x[0]+20;  
		   }
		   if(down)
		   {
			y[0]=y[0]+20;
		   }
	       if(left)
		   {
			x[0]=x[0]-20;   
		   }
	       if(up)
		   {
			y[0]=y[0]-20;
		   }
			
		}
		
	
		
		repaint();
		
	}
	public void keyReleased(KeyEvent k)
	{}
	public void keyPressed(KeyEvent k)
	{
	 if(k.getKeyCode()==KeyEvent.VK_ENTER)
	 {
	 Start = true;
	 }
	 
	  // if(k.getKeyCode()==KeyEvent.VK_SPACE)
	 // {
		 // dots=5;
		 // repaint();
	 // }
	 
	  if(k.getKeyCode()==KeyEvent.VK_Q)
	 {
		 System.exit(0);
	 }
	 
	 if(k.getKeyCode()==KeyEvent.VK_RIGHT)
	 {
		 right=true;
		 left=false;
		 up=false;
		 down=false;
	 }
	 if(k.getKeyCode()==KeyEvent.VK_DOWN)
	 {
		 right=false;
		 left=false;
		 up=false;
		 down=true;
	 }
	 if(k.getKeyCode()==KeyEvent.VK_LEFT)
	 {
		 right=false;
		 left=true;
		 up=false;
		 down=false;
	 }
	 if(k.getKeyCode()==KeyEvent.VK_UP)
	 {
		 right=false;
		 left=false;
		 up=true;
		 down=false;
	 }
	
	
	}
	public void keyTyped(KeyEvent k)
	{}
	
	
}

class SnakeGame
{
	public static void main(String []a)
	{
		DDemo ob = new DDemo();
		ob.setVisible(true);
		ob.setSize(1000,700);
		ob.setLocation(200,30);
		ob.setDefaultCloseOperation(ob.EXIT_ON_CLOSE);
		
	}
}
