import java.awt.*;
import java.net.URL;

import javax.swing.*;


public class Loader extends JWindow 
{
	private static final long serialVersionUID = 1L;
	JProgressBar barra;
	URL fond;
	JLabel loading, img, yellow;
	
	public Loader()
	{
		try {
	    	  JFrame.setDefaultLookAndFeelDecorated(true);
	  	    JDialog.setDefaultLookAndFeelDecorated(true);
	    	UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
	    	} catch (Exception e){}
		this.setLayout(null);
		this.setSize(640, 400);
		this.setBounds(358,185,640,400);
		
		fond = getClass().getResource("/Resources/fondoloader.jpg");
		img = new JLabel();
			img.setIcon(new ImageIcon(fond));
			img.setBounds(0,0,640,400);
		barra = new JProgressBar(0,150);
			barra.setBounds(10, 325, 625, 10);
		loading = new JLabel();
			loading.setForeground(Color.white);
			loading.setFont(new Font("Calibri",Font.PLAIN,12));
			loading.setBounds(10, 155, 300, 50);
		
		add(loading);add(barra);add(img);	
		this.setVisible(true);
		Barra();
	}
	
	public void Barra() 
	{
		for (int i = 0; i < 150; i++) 
		{
			if(i==0)
			{
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
				loading.setText("Cargando recursos...");
			}
			if(i==50)
			{
				loading.setText("Cargando espacio de trabajo...");
			}
			if(i==75)
			{
				loading.setText("Iniciando espacio de trabajo...");
			}
			if(i==100)
			{
				try {Thread.sleep(2000);} catch (InterruptedException e) {}
				loading.setText("Iniciando...");
			}
			barra.setValue(i);
			try {Thread.sleep(50);} catch (InterruptedException e) {}
		}
		this.setVisible(false);
	}
}
