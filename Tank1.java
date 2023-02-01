import java.awt.EventQueue;
import java.awt.Image;
//import java.awt.image.*;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

import java.lang.Math;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;

public class Tank1 {

	private JFrame frame;
	static JProgressBar progressBar = new JProgressBar();
	static double mWaterLevelML;
	static double mWaterLevelCM;
	static boolean wateroff=false;
	static JLabel lblNewLabel_1 = new JLabel();
	static JLabel lblNewLabel11 = new JLabel();
	static boolean mRun=false;
	static JButton btnWaterOff = new JButton("Water Off");
	static JButton btnStop = new JButton("Stop");
	
	 static boolean buttonState;
	 
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tank1 window = new Tank1();
					window.frame.setVisible(true);
					
					 buttonState=false;   //for initial

					 while (true) {
					 	System.out.println(buttonState);

					 	 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
					 	 
					 	}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		fill();
		System.out.println("aaaaa");
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Tank1() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		progressBar.setStringPainted(true);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(373, 85, 53, 227);
		frame.getContentPane().add(progressBar);
		

	
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mRun=true;
			}
		});
		
		btnStart.setBounds(20, 125, 147, 60);
		frame.getContentPane().add(btnStart);
		
		
		
		btnStop.setBounds(20, 229, 147, 60);
		frame.getContentPane().add(btnStop);
		
		btnWaterOff.setBounds(20, 332, 147, 68);
		
		frame.getContentPane().add(btnWaterOff);
		

		//BufferedImage myPicture = ImageIO.read(new File("/tank.jpg"));
	

		
		JLabel label = new JLabel ("");
		Image img = new ImageIcon(this.getClass().getResource("/tank.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(306, 85, 162, 240);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Volume in ML");
		lblNewLabel.setBounds(234, 393, 90, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblVolumnInCm = new JLabel("Volumn in CM");
		lblVolumnInCm.setBounds(463, 393, 103, 24);
		frame.getContentPane().add(lblVolumnInCm);
		
		
		lblNewLabel_1.setBounds(360, 393, 90, 24);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setText(String.valueOf((mWaterLevelML))) ;
		
		
		lblNewLabel11.setBounds(580, 393, 147, 24);
		frame.getContentPane().add(lblNewLabel11);
		lblNewLabel_1.setText(String.valueOf((mWaterLevelCM))) ;
		
		
		
	}
	
	public static void fill()
    {
		
		mRun=true;
		wateroff=false;
		btnWaterOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wateroff=true;
			}
		});
		
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mRun=false;
			}
		});
		


	try {
		
		
		while (mRun = true) 
		{


 

/*
if (wateroff=true) {
	mWaterLevelCM -=3;
	
	if (mWaterLevelCM<=8) {
	    mWaterLevelML=((11.5811+121.934+ Math.sqrt(11.5811*121.934))/3)*mWaterLevelCM;
	    //if the water level is less than or equal to 8, it is within the lower cone, the valume calculate like this
	}
	 
	if (mWaterLevelCM>8) {
	    mWaterLevelML= 121.934*(mWaterLevelCM-8)+456.2491;
	    //if the waterlevel is greater than 8, then volume we added more is on the upper cylinder
	}
	Thread.sleep(1000);
	}
*/

		}
		
	}
	catch (Exception e) {
	}

    }
}
