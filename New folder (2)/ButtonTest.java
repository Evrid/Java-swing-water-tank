import java.awt.FlowLayout;  
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;  
import javax.swing.JToggleButton;  
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.lang.Math;
import javax.swing.JTextField;
  
public class ButtonTest extends JFrame implements ItemListener {
	
	 static boolean buttonState;
	 static boolean WateroffState;
	static double mWaterLevelML;
	static double mWaterLevelCM;
	static JProgressBar progressBar = new JProgressBar(0, 2800);   //progress bar min 0 ml, max 2800 ml
	 static JLabel lblNewLabel_2 = new JLabel("New label");
	 static 	JLabel lblNewLabel_3 = new JLabel("New label");
	 
	 //we declare them static because we use them globally
		
    public static void main(String[] args) {  
        new ButtonTest();  
        buttonState=false;   //for initial the values, else will be null
        WateroffState=false;
        mWaterLevelML=0;
        mWaterLevelCM=0;
        
while (true) {    
	System.out.println(buttonState);   //display state of ON/OFF button
	System.out.println(WateroffState);  //display state of wateroff button

	 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
	 //need to use try catch for Thread.sleep(500) which delay 0.5s
	 
	 while (buttonState)   //if state is on
	 {
	 	//----------------------------------
		 
		 if (mWaterLevelML <= 150) {
			    // water tank is empty when "mWaterLevelML"=0, we have safety range

			while (mWaterLevelML <= 2100)  //if water is less than 150ml then to we fill until reach 2100ml
			{
			    progressBar.setValue((int) (mWaterLevelML + 4));  
			    //set value need to be int and we have a double for mWaterLevelML, add 4 because we will add later, display first
						System.out.println(mWaterLevelML);
						System.out.println(mWaterLevelCM);

						// delay the thread
						try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
						//need to use try catch for Thread.sleep(500) which delay 0.5s
						
						mWaterLevelCM += 4;
						//water level go up
						
						if (mWaterLevelCM<=8) {
							//when less than 8 then is in the cone, detail see
							//https://jonkopinguniversity-my.sharepoint.com/:w:/g/personal/liyu21ka_student_ju_se/ESifvKKjllRBudyUd_TDJQgBK51ubSfp3KJl70MGRA2Jnw?e=kdR0xA
							
						    mWaterLevelML=((11.5811+121.934+ Math.sqrt(11.5811*121.934))/3)*mWaterLevelCM;
						    //if the water level is less than or equal to 8, it is within the lower cone, the valume calculate like this
						    lblNewLabel_2.setText(String.valueOf((mWaterLevelCM))) ;
							lblNewLabel_3.setText(String.valueOf((mWaterLevelML))) ;
						}
						 
						if (mWaterLevelCM>8) {
							//above the cone, detail see
							//https://jonkopinguniversity-my.sharepoint.com/:w:/g/personal/liyu21ka_student_ju_se/ESifvKKjllRBudyUd_TDJQgBK51ubSfp3KJl70MGRA2Jnw?e=kdR0xA
						    mWaterLevelML= 121.934*(mWaterLevelCM-8)+456.2491;
						    //if the waterlevel is greater than 8, then volume we added more is on the upper cylinder
						}
						lblNewLabel_2.setText(String.valueOf((mWaterLevelCM))) ;
						lblNewLabel_3.setText(String.valueOf((mWaterLevelML))) ;
						
						
			}
			
			}

		//----------------
			while (WateroffState & mWaterLevelCM>0) {   //if water off button is pressed and water level greater than 0
				mWaterLevelCM -=3;
				System.out.println("wateroff");
				//calculation see https://jonkopinguniversity-my.sharepoint.com/:w:/g/personal/liyu21ka_student_ju_se/ESifvKKjllRBudyUd_TDJQgBK51ubSfp3KJl70MGRA2Jnw?e=kdR0xA
				if (mWaterLevelCM<=8) {
				    mWaterLevelML=((11.5811+121.934+ Math.sqrt(11.5811*121.934))/3)*mWaterLevelCM;
				    //if the water level is less than or equal to 8, it is within the lower cone, the valume calculate like this
				    lblNewLabel_2.setText(String.valueOf((mWaterLevelCM))) ;
					lblNewLabel_3.setText(String.valueOf((mWaterLevelML))) ;
				}
				 
				if (mWaterLevelCM>8) {
				    mWaterLevelML= 121.934*(mWaterLevelCM-8)+456.2491;
				    //if the waterlevel is greater than 8, then volume we added more is on the upper cylinder
				    lblNewLabel_2.setText(String.valueOf((mWaterLevelCM))) ;
					lblNewLabel_3.setText(String.valueOf((mWaterLevelML))) ;
				}
				
				 progressBar.setValue((int) (mWaterLevelML -3));
				 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
				}
			//----------------
		 //------------------------------
	 }
	 
	}


    }  
    
   
    private JToggleButton button;  
    private JToggleButton button2;
    private JLabel lblNewLabel;
    private final JLabel lblNewLabel_4 = new JLabel("Made by Yushuo (Kevin)");
    
    
    
    ButtonTest() {  
        setTitle("JToggleButton with ItemListener Example");
        setJToggleButton();  
        setAction();  
        setSize(528, 432);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
    
    private void setJToggleButton() {  
        getContentPane().setLayout(null);
        button = new JToggleButton("ON");  
        button.setBounds(52, 5, 145, 21);
        getContentPane().add(button); 
        
        button2 = new JToggleButton("water off");  
        button2.setBounds(232, 5, 139, 21);
        getContentPane().add(button2);
		Image img = new ImageIcon(this.getClass().getResource("/tank.jpg")).getImage();
		
		
		progressBar.setStringPainted(true);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(104, 57, 47, 227);
		getContentPane().add(progressBar);
		
		JLabel label = new JLabel ("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(35, 57, 162, 240);
		getContentPane().add(label);
		
		lblNewLabel = new JLabel("CM");
		lblNewLabel.setBounds(228, 96, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ML");
		lblNewLabel_1.setBounds(228, 139, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		
		lblNewLabel_2.setBounds(283, 96, 45, 13);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setText(String.valueOf((mWaterLevelML))) ;
		
	
		lblNewLabel_3.setBounds(283, 139, 45, 13);
		getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setText(String.valueOf((mWaterLevelCM))) ;
		lblNewLabel_4.setBounds(209, 244, 162, 29);
		
		getContentPane().add(lblNewLabel_4);
    }  
    private void setAction() {    //set the button's states
        button.addItemListener(this);  
        button2.addItemListener(this);  
    }  
    public void itemStateChanged(ItemEvent eve) { 
    	
        if (button.isSelected())  {  //on off button
            button.setText("OFF");  
        buttonState=true;}
        else  {
            button.setText("ON");  
        buttonState=false;}
        
        if (button2.isSelected())  {   //water off button
           
        	WateroffState=true;}
        else  {
            
        WateroffState=false;}
    }  
}  


