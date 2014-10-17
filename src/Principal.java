/** Dani Vega's 3D Ultimate Studio **/

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Principal extends JPanel implements ChangeListener, MouseListener, MouseMotionListener
{	
	private static final long serialVersionUID = 1L;
	JFrame ventana;
	Container cont;
	BufferedImage buf;
	JToolBar barra;
	JTabbedPane centro;
	Color color=Color.white;
	URL diburl,trasurl,rotxurl,rotyurl,rotzurl,helpurl,studiourl,colorurl;
	
	double fig3D[][]={/*A(0)*/{-170,60,50},/*B(1)*/{-150,60,50},/*C(2)*/{-120,50,50},/*D(3)*/{-110,40,50},/*E(4)*/{-100,20,50},
									/*F(5)*/{-100,70,50},/*G(6)*/{-60,70,50},/*H(7)*/{-60,55,50},/*I(8)*/{-80,55,50},/*J(9)*/{-80,40,50},
									/*K(10)*/{-60,40,50},/*L(11)*/{-60,50,50},/*M(12)*/{-40,50,50},/*N(13)*/{-40,20,50},/*O(14)*/{-20,20,50},
									/*P(15)*/{-20,70,50},/*Q(16)*/{0,70,50},/*R(17)*/{0,50,50},/*S(18)*/{40,50,50},
									/*T(19)*/{40,30,50},/*U(20)*/{20,30,50},/*V(21)*/{20,20,50},/*W(22)*/{40,20,50},
									/*X(23)*/{65,50,50},/*Y(24)*/{100,0,50},/*Z(25)*/{130,40,50},/*A1(26)*/{150,40,50},
									/*B1(27)*/{170,20,50},/*C1(28)*/{190,50,50},/*D1(29)*/{210,50,50},/*E1(30)*/{180,0,50},
									/*F1(31)*/{180,-40,50},/*G1(32)*/{160,-40,50},/*H1(33)*/{160,0,50},/*I1(34)*/{140,20,50},
									/*J1(35)*/{100,-40,50},/*K1(36)*/{65,15,50},/*L1(37)*/{50,0,50},/*M1(38)*/{20,0,50},
									/*N1(39)*/{20,-20,50},/*O1(40)*/{40,-20,50},/*P1(41)*/{40,-40,50},/*Q1(42)*/{0,-40,50},
									/*R1(43)*/{0,-60,50},/*S1(44)*/{-20,-60,50},/*T1(45)*/{-20,-10,50},/*U1(46)*/{-40,-10,50},
									/*V1(47)*/{-40,-40,50},/*W1(48)*/{-60,-40,50},/*X1(49)*/{-60,-20,50},/*Y1(50)*/{-100,-20,50},
									/*Z1(51)*/{-100,10,50},/*A2(52)*/{-110,-10,50},/*B2(53)*/{-120,-20,50},/*C2(54)*/{-150,-30,50},
									/*D2(55)*/{-170,-30,50},/*E2(56)*/{-150,40,50},/*F2(57)*/{-130,30,50},/*G2(58)*/{-125,20,50},
									/*H2(59)*/{-125,10,50},/*I2(60)*/{-130,0,50},/*J2(61)*/{-150,-10,50},/*K2(62)*/{-80,20,50},
									/*L2(63)*/{-60,20,50},/*M2(64)*/{-60,0,50},/*N2(65)*/{-80,0,50},
									
									/*A(66)*/{-170,60,-50},/*B(67)*/{-150,60,-50},/*C(68)*/{-120,50,-50},/*D(69)*/{-110,40,-50},/*E(70)*/{-100,20,-50},
									/*F(71)*/{-100,70,-50},/*G(72)*/{-60,70,-50},/*H(73)*/{-60,55,-50},/*I(74)*/{-80,55,-50},/*J(75)*/{-80,40,-50},
									/*K(76)*/{-60,40,-50},/*L(77)*/{-60,50,-50},/*M(78)*/{-40,50,-50},/*N(79)*/{-40,20,-50},/*O(80)*/{-20,20,-50},
									/*P(81)*/{-20,70,-50},/*Q(82)*/{0,70,-50},/*R(83)*/{0,50,-50},/*S(84)*/{40,50,-50},
									/*T(85)*/{40,30,-50},/*U(86)*/{20,30,-50},/*V(87)*/{20,20,-50},/*W(88)*/{40,20,-50},
									/*X(89)*/{65,50,-50},/*Y(90)*/{100,0,-50},/*Z(91)*/{130,40,-50},/*A1(92)*/{150,40,-50},
									/*B1(93)*/{170,20,-50},/*C1(94)*/{190,50,-50},/*D1(95)*/{210,50,-50},/*E1(96)*/{180,0,-50},
									/*F1(97)*/{180,-40,-50},/*G1(98)*/{160,-40,-50},/*H1(99)*/{160,0,-50},/*I1(100)*/{140,20,-50},
									/*J1(101)*/{100,-40,-50},/*K1(102)*/{65,15,-50},/*L1(103)*/{50,0,-50},/*M1(104)*/{20,0,-50},
									/*N1(105)*/{20,-20,-50},/*O1(106)*/{40,-20,-50},/*P1(107)*/{40,-40,-50},/*Q1(108)*/{0,-40,-50},
									/*R1(109)*/{0,-60,-50},/*S1(110)*/{-20,-60,-50},/*T1(111)*/{-20,-10,-50},/*U1(112)*/{-40,-10,-50},
									/*V1(113)*/{-40,-40,-50},/*W1(114)*/{-60,-40,-50},/*X1(115)*/{-60,-20,-50},/*Y1(116)*/{-100,-20,-50},
									/*Z1(117)*/{-100,10,-50},/*A2(118)*/{-110,-10,-50},/*B2(119)*/{-120,-20,-50},/*C2(120)*/{-150,-30,-50},
									/*D2(121)*/{-170,-30,-50},/*E2(122)*/{-150,40,-50},/*F2(123)*/{-130,30,-50},/*G2(124)*/{-125,20,-50},
									/*H2(125)*/{-125,10,-50},/*I2(126)*/{-130,0,-50},/*J2(127)*/{-150,-10,-50},/*K2(128)*/{-80,20,-50},
									/*L2(129)*/{-60,20,-50},/*M2(130)*/{-60,0,-50},/*N2(131)*/{-80,0,-50}};
	
	double grid[][]={{-200,0,100},{-190,0,100},{-180,0,100},{-170,0,100},{-160,0,100},{-150,0,100},{-140,0,100},{-130,0,100},{-120,0,100},
								{-110,0,100},{-100,0,100},{-90,0,100},{-80,0,100},{-70,0,100},{-60,0,100},{-50,0,100},{-40,0,100},{-30,0,100},{-20,0,100},{-10,0,100},
								{0,0,100},{10,0,100},{20,0,100},{30,0,100},{40,0,100},{50,0,100},{60,0,100},{70,0,100},{80,0,100},{90,0,100},{100,0,100},{110,0,100},
								{120,0,100},{130,0,100},{140,0,100},{150,0,100},{160,0,100},{170,0,100},{180,0,100},{190,0,100},{200,0,100}};
	
	double respaldo[][],copia[][];
   
   int secuencia[]={/*Anterior*/0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,
		   											    20,20,21,21,22,22,23,23,24,24,25,25,26,26,27,27,28,28,29,29,30,30,31,31,32,32,33,33,34,34,35,35,
		   											    36,36,37,37,38,38,39,39,40,40,41,41,42,42,43,43,44,44,45,45,46,46,47,47,48,48,49,49,50,50,51,51,
		   											    52,52,53,53,54,54,55,55,0,
		   						 /* Agujero */56,57,57,58,58,59,59,60,60,61,61,56,
		   						 /* E */62,63,63,64,64,65,65,62,
		   						 /*Posterior*/66,67,67,68,68,69,69,70,70,71,71,72,72,73,73,74,74,75,75,76,76,77,77,78,78,79,79,80,80,81,81,
		   						 					     82,82,83,83,84,84,85,85,86,86,87,87,88,88,89,89,90,90,91,91,92,92,93,93,94,94,95,95,96,96,97,97,
		   						 					     98,98,99,99,100,100,101,101,102,102,103,103,104,104,105,105,106,106,107,107,108,108,109,109,
		   						 					     110,110,111,111,112,112,113,113,114,114,115,115,116,116,117,117,118,118,119,119,120,120,121,121,66,
		   						 /* Agujero */122,123,123,124,124,125,125,126,126,127,127,122,
		   					   	 /* E */128,129,129,130,130,131,131,128,
		   						 /*Uni�n*/0,66,1,67,2,68,3,69,4,70,5,71,6,72,7,73,8,74,9,75,10,76,11,77,12,78,13,79,14,80,15,81,16,82,17,83,18,84,19,85,
		   						 				   20,86,21,87,22,88,23,89,24,90,25,91,26,92,27,93,28,94,29,95,30,96,31,97,32,98,33,99,34,100,35,101,36,102,37,103,
		   						 				   38,104,39,105,40,106,41,107,42,108,43,109,44,110,45,111,46,112,47,113,48,114,49,115,50,116,51,117,52,118,
		   						 				   53,119,54,120,55,121,56,122,57,123,58,124,59,125,60,126,61,127,62,128,63,129,64,130,65,131};
   
   int secuenciagrid[]={0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,
		   								25,25,26,26,27,27,28,28,29,29,30,30,31,31,32,32,33,33,34,34,35,35,36,36,37,37,38,38,39,39,40,40,41,41,0};
   
   JSlider rotx,roty,rotz,zoom;
   JLabel lrotx, lroty, lrotz,studio;
   boolean mover = false;
   
   int fig2D[][],grados,minx,maxx,miny,maxy;
   int mz=-350,posx,posy;
   int distancia=500;
   
   public Principal(String tit)
   {
	   JFrame.setDefaultLookAndFeelDecorated(true);
	   try 
	   {
	     UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	   } 
	   catch (Exception e) 
	   {
	     e.printStackTrace();
	   }
	   
	    ventana = new JFrame(tit);
		cont = ventana.getContentPane();
		cont.setLayout(new BorderLayout());
		cont.setBackground(Color.black);
		ventana.setSize(1000, 700);
		ventana.setBounds(0, 35, 1366, 730);
		buf = loadImage("/Resources/fondo.jpg");
		studiourl=getClass().getResource("/Resources/3dstudio.png");
		studio = new JLabel();
		studio.setIcon(new ImageIcon(studiourl));
		centro = new JTabbedPane();
		JPanel pan = new JPanel();
		pan.setBackground(Color.black);
		   pan.setLayout(new FlowLayout());
		   rotx = new JSlider(JSlider.HORIZONTAL,0,360,0);
		   	rotx.setMajorTickSpacing(90);
		   	rotx.setPaintTicks(true);
		   	rotx.setPaintLabels(true);
		   	rotx.setBackground(Color.black);
		   	rotx.setForeground(new Color(75,148,255));
		   	rotx.setFont(new Font("Calibri",Font.PLAIN,9));
		   	lrotx = new JLabel("Rotar en X:");
		   	lrotx.setForeground(new Color(19,115,255));
		   	lrotx.setFont(new Font("Calibri",Font.PLAIN,12));
		   roty = new JSlider(JSlider.HORIZONTAL,0,360,180);
		   	roty.setMajorTickSpacing(90);
		   	roty.setPaintTicks(true);
		   	roty.setPaintLabels(true);
		   	roty.setForeground(new Color(75,148,255));
		   	roty.setBackground(Color.black);
		   	roty.setFont(new Font("Calibri",Font.PLAIN,9));
		   	lroty = new JLabel("Rotar en Y:");
		   	lroty.setForeground(new Color(19,115,255));
		   	lroty.setFont(new Font("Calibri",Font.PLAIN,12));
		   rotz = new JSlider(JSlider.HORIZONTAL,0,360,0);
		   	rotz.setMajorTickSpacing(90);
		   	rotz.setPaintTicks(true);
		   	rotz.setPaintLabels(true);
		   	rotz.setForeground(new Color(75,148,255));
		   	rotz.setBackground(Color.black);
		   	rotz.setFont(new Font("Calibri",Font.PLAIN,9));
		   	lrotz = new JLabel("Rotar en Z:");
		   	lrotz.setForeground(new Color(19,115,255));
		   	lrotz.setFont(new Font("Calibri",Font.PLAIN,12));
		    zoom = new JSlider(JSlider.VERTICAL,100,1500,500);
		   	zoom.setMajorTickSpacing(50);
		   	zoom.setPaintTicks(true);
		   	zoom.setPaintLabels(true);
		   	zoom.setBackground(Color.black);
		   	zoom.setForeground(new Color(75,148,255));
		   	zoom.setFont(new Font("Calibri",Font.PLAIN,9));
		   pan.add(lrotx); pan.add(rotx); pan.add(lroty);pan.add(roty); pan.add(lrotz);pan.add(rotz);
		   
		   centro.addTab("Deheny", this);
		   centro.setTitleAt(0, "Deheny.3dus");
		   centro.setFont(new Font("Calibri",Font.PLAIN,12));
		   cont.add(zoom,BorderLayout.WEST);
		   cont.add(centro);
		   cont.add(pan,BorderLayout.SOUTH);
		zoom.addChangeListener(this);
		   rotx.addChangeListener(this);
		   roty.addChangeListener(this);
		   rotz.addChangeListener(this);
		   this.addMouseListener(this);
		   this.addMouseMotionListener(this);
		   this.addMouseWheelListener(new MouseWheelListener() 
		   	{
		   		@Override
		   		public void mouseWheelMoved(MouseWheelEvent arg0) 
		   		{
		   			int rot=arg0.getWheelRotation();
		   			if(rot<0)//Arriba
		   			{
		   				Escalar(1.1,1.1,1.1);
		   			}
		   			else//Abajo
		   			{
		   				Escalar(0.9,0.9,0.9);
		   			}
		   		}
		   	});
		
		barra = new JToolBar("Transformaciones rápidas",JToolBar.HORIZONTAL);
		cont.add(barra,BorderLayout.NORTH);
		/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
		diburl = getClass().getResource("/Resources/original.png");
		Action a1 = new AbstractAction("Original",new ImageIcon(diburl))
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ap)
			{
				fig3D=copia;
				rotx.setValue(0);
				roty.setValue(180);
				rotz.setValue(0);
				color = Color.white;
				conva2D();
				repaint();
			}
		};
		a1.putValue(Action.SHORT_DESCRIPTION, "Genera el modelo original DEHENY");
		a1.putValue(Action.MNEMONIC_KEY, new Integer('O'));
		a1.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
		trasurl = getClass().getResource("/Resources/trasladar.png");
		Action a2 = new AbstractAction("Trasladar",new ImageIcon(trasurl))
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ap)
			{
				Dialog_Trasladar obt = new Dialog_Trasladar(ventana,true);
				int vec[] = obt.Mostrar();
				Trasladar(vec[0], vec[1]);
				repaint();
			}
		};
		a2.putValue(Action.SHORT_DESCRIPTION, "Traslada el modelo a un punto en el espacio");
		a2.putValue(Action.MNEMONIC_KEY, new Integer('T'));
		a2.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK));
		/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
		helpurl = getClass().getResource("/Resources/ayuda.png");
		Action a6 = new AbstractAction("Rotar en contra del sentido de las manecillas del reloj",new ImageIcon(helpurl))
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ap)
			{
				new Ayuda();
			}
		};
		a6.putValue(Action.SHORT_DESCRIPTION, "Abre el cuadro de ayuda de 3D Ultimate Studio");
		a6.putValue(Action.MNEMONIC_KEY, new Integer('H'));
		a6.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
		/* --------------------------------------------------------------------------------------------------------------------------------------------------- */
		colorurl = getClass().getResource("/Resources/color.png");
		Action a7 = new AbstractAction("Rotar en contra del sentido de las manecillas del reloj",new ImageIcon(colorurl))
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ap)
			{
				color = JColorChooser.showDialog(Principal.this, "Selecciona el color a aplicar", Color.black);
				
			}
		};
		a7.putValue(Action.SHORT_DESCRIPTION, "Selecciona un color para el modelo");
		a7.putValue(Action.MNEMONIC_KEY, new Integer('C'));
		a7.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		
		barra.add(studio);barra.add(a1);barra.add(a2);barra.add(a7);barra.add(a6);
		barra.setBackground(Color.black);
	   
	   fig2D=new int[fig3D.length][fig3D[0].length];
	   
   // Respaldamos la figura:
	   respaldo = new double[fig3D.length][fig3D[0].length];
	   for (int i = 0; i < fig3D.length; i++) 
	   {
		   respaldo[i][0] = fig3D[i][0];
		   respaldo[i][1] = fig3D[i][1];
		   respaldo[i][2] = fig3D[i][2];
	   }
	   RotacionXYZ(0,180,0);
	   
	   copia = new double[fig3D.length][fig3D[0].length];
	   for (int i = 0; i < respaldo.length; i++) 
	   {
		   copia[i][0] = fig3D[i][0];
		   copia[i][1] = fig3D[i][1];
		   copia[i][2] = fig3D[i][2];
	   }
	   conva2D();
	   ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public void conva2D()
   {   
	   for(int i=0;i<fig3D.length;i++)
	   	{   //sx= d*x/(z+mz)
	   		   fig2D[i][0]=(int)((distancia*fig3D[i][0])/(fig3D[i][2]+mz));
	   		   //sy= d*y/(z+mz)
	   		   fig2D[i][1]=(int)((distancia*fig3D[i][1])/(fig3D[i][2]+mz));
	   		   //trasladar
	   		   fig2D[i][0]+=500;
	   		   fig2D[i][1]+=300;
	   	}
   }
   public void Dibujar2(Graphics g)
   {
	   Graphics2D g2 = (Graphics2D)g;
	   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	   g2.setColor(color);
	   for(int i=0;i<secuencia.length;i+=2)
	   {
			   g2.drawLine(fig2D[secuencia[i]][0], fig2D[secuencia[i]][1],fig2D[secuencia[i+1]][0],fig2D[secuencia[i+1]][1]);
	   }
	   if(mover == true)
		{
			g2.setStroke(new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0, new float[]{5}, 0));
			Encuentra_MinMax();
			Rectangle2D contorno = new Rectangle2D.Double(minx, miny, maxx-minx, maxy-miny);
			g2.setColor(Color.DARK_GRAY);
			g2.draw(contorno);
			g2.setStroke(new BasicStroke(1f));
		}
   }
   public void Dibujar(Graphics g)
   {
	   g.setColor(Color.white);
		  int i=0;
		  for(i=0;i<=2;i++)
		  {
			g.drawLine(fig2D[i][0],fig2D[i][1],fig2D[i+1][0],fig2D[i+1][1]);  
		  }
		  g.drawLine(fig2D[i][0],fig2D[i][1],fig2D[0][0],fig2D[0][1]);
		  for(i=0;i<=3;i++)
		  {
			g.drawLine(fig2D[i][0],fig2D[i][1],fig2D[4][0],fig2D[4][1]);  
		  } 
   }
   
   public void paint(Graphics g)
   { 
	  super.paint(g);
	  Graphics2D g2 = (Graphics2D)g;
	  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	  g2.drawImage(buf, 0, 0, this);
	  g2.setColor(Color.WHITE);
	  g2.setFont(new Font("Calibri",Font.ITALIC,20));
	  g2.drawString("Vistas:", 1050, 40);
	  g2.setFont(new Font("Calibri",Font.PLAIN,14));
	  g2.drawString("Superior:", 1050, 90);
	  g2.drawRoundRect(1050, 100, 220, 100, 10, 10);
	  g2.drawString("Frontal:", 1050, 245);
	  g2.drawRoundRect(1050, 255, 220, 100, 10, 10);
	  g2.drawString("Lateral:", 1050, 400);
	  g2.drawRoundRect(1050, 410, 220, 100, 10, 10);
	  int ex=0,ye=0;
	  for (int i = 0; i < 21; i++) 
	  {
		  g2.setStroke(new BasicStroke(2f));
		  g2.setColor(new Color(222,222,222,10));
		  g2.drawLine(ex, 0, ex, 700);
		  g2.drawLine(0, ye, 1000, ye);
		  ex+=50;
		  ye+=50;
	  }
	  ex=-25;ye=-25;
	  for (int i = 0; i < 21; i++) 
	  {
		  g2.setColor(new Color(222,222,222,9));
		  g2.setStroke(new BasicStroke(1f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0, new float[]{5}, 0));
		  g2.drawLine(ex, 0, ex, 700);
		  g2.drawLine(0, ye, 1000, ye);
		  ex+=50;
		  ye+=50;
	  }
	  g2.setStroke(new BasicStroke(1f));
	  Dibujar2(g); 
	  Vistas(g);
   }
   
   public void Encuentra_MinMax()
	{
		minx = fig2D[0][0];
		miny = fig2D[0][1];
		
		for (int i = 0; i < fig2D.length; i++) 
			{
			if(fig2D[i][0]<minx)
				minx = fig2D[i][0];
			if(fig2D[i][1]<miny)
				miny = fig2D[i][1];
			}
		maxx = 0;maxy = 0;
		for (int i = 0; i < fig2D.length; i++) 
			{
			if(fig2D[i][0]>maxx)
				maxx = fig2D[i][0];
			if(fig2D[i][1]>maxy)
				maxy = fig2D[i][1];
			}
	}
   
   public void RotacionXYZ(double gx, double gy, double gz)
   {
	   double radx = Math.toRadians(gx);
	   double rady = Math.toRadians(gy);
	   double radz = Math.toRadians(gz);
	   
	   double senox = Math.sin(radx);
	   double cosenox = Math.cos(radx);

	   double senoy = Math.sin(rady);
	   double cosenoy = Math.cos(rady);

	   double senoz = Math.sin(radz);
	   double cosenoz = Math.cos(radz);
	   
	   for (int i = 0; i < fig3D.length; i++) 
	   {
		   double x = respaldo[i][0];
		   double y = respaldo[i][1];
		   double z = respaldo[i][2];
		   
		   fig3D[i][0] = x*(cosenoy*cosenoz)+y*((-senox*senoy)*cosenoz+(cosenox*senoz))+z*((cosenox*senoy)*cosenoz+(senox*senoz));
		   fig3D[i][1] = x*(cosenoy*-senoz)+y*((-senox*senoy)*-senoz+(cosenox*cosenoz))+z*((cosenox*senoy)*-senoz+(senox*cosenoz));
		   fig3D[i][2] = x*-senoy+y*(-senox*cosenoy)+z*(cosenox*cosenoy);
	   }
	   conva2D();
	   repaint();
   }

   public double[][] RotacionX(int grad)
	{
		double rad=Math.toRadians(grad);
	   	double sen=Math.sin(rad);
	   	double cos=Math.cos(rad);
	   	double temp[][]=new double [fig3D.length][3];// Para que queden fijas a partir de la figura Original
	   		   
	   	for (int i = 0; i < fig3D.length; i++)
	   	{
	   		double y=respaldo[i][1];
	   		double z=respaldo[i][2];
	   			   
	   		temp[i][1]=(y*cos-z*sen)/2;
	   		temp[i][2]=(y*sen+z*cos)/2;
	   		temp[i][0]=(fig3D[i][0])/2;
	   	}
	   	return temp;
	}
	   	   
	public double [][] RotacionY(int grad)
	{
		double rad=Math.toRadians(grad);
	   	double sen=Math.sin(rad);
	   	double cos=Math.cos(rad);
	   	double temp[][]=new double[fig3D.length][3]; 
	   	for (int i = 0; i < temp.length; i++)
	   	{
	   		double x=respaldo[i][0];
	   		double z=respaldo[i][2];
	   				   
	   		temp[i][0]=(x*cos-z*sen)/2;
	   		temp[i][2]=(x*sen+z*cos)/2;
	   		temp[i][1]=(fig3D[i][1])/2;
	   	}
	   	return temp;
	}
   
   public void Vistas(Graphics g)
	{
		// Superior
	   	double temp[][]=RotacionX(90);
	   	for (int i = 0; i < temp.length; i++) 
	   	{
	   		temp[i][0]=temp[i][0]*-1+1150;
	   		temp[i][2]=0;
	   		temp[i][1]+=150;
	   	}
	   	Dibujar3(g,temp);//obtener objeto grafico
	   		   
	   	// Frontal
	   	double temp1[][]=RotacionX(0);
	   	for (int i = 0; i < temp1.length; i++) 
	   	{
	   		temp1[i][2]=0;
	   		temp1[i][0]=temp1[i][0]*-1+1150;
	   		temp1[i][1]=temp1[i][1]*-1+310;
	   	}
	   	Dibujar3(g,temp1);//obtener objeto grafico
	   		   
	   	// Lateral
	   	double temp2[][]=RotacionY(90);
	   	for (int i = 0; i < temp2.length; i++) 
	   	{
	   		temp2[i][2]=0;
	   		temp2[i][0]+=1160;
	   		temp2[i][1]=temp2[i][1]*-1+463;
	   	}
	   	Dibujar3(g,temp2);
	   	repaint();
	}
   
   public void Dibujar3(Graphics g,double temp[][])
   {
	   Graphics2D g2 = (Graphics2D)g;
	   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	   g2.setColor(new Color(75,172,198));
	   for(int i=0;i<secuencia.length;i+=2)
	   {
		   g.drawLine((int) temp[secuencia[i]][0], (int) temp[secuencia[i]][1], (int) temp[secuencia[i+1]][0], (int) temp[secuencia[i+1]][1]);
	   }
   }
   
public void stateChanged(ChangeEvent che) 
{
	if(che.getSource() == zoom)
	{
		distancia = zoom.getValue();
		conva2D();
		repaint();
	}
	if(che.getSource() == rotx)
	{
		double gradosx = rotx.getValue();
		double gradosy = roty.getValue();
		double gradosz = rotz.getValue();
		RotacionXYZ(gradosx,gradosy,gradosz);
	}
	
	if(che.getSource() == roty)
	{
		double gradosx = rotx.getValue();
		double gradosy = roty.getValue();
		double gradosz = rotz.getValue();
		RotacionXYZ(gradosx,gradosy,gradosz);
	}	
	
	if(che.getSource() == rotz)
	{
		double gradosx = rotx.getValue();
		double gradosy = roty.getValue();
		double gradosz = rotz.getValue();
		RotacionXYZ(gradosx,gradosy,gradosz);
	}	
}

public void Trasladar(double tx, double ty)
{
	for (int i = 0; i < fig2D.length; i++) 
		{
		fig2D[i][0] += tx; // En X
		fig2D[i][1] += ty; // En Y
		}
		repaint();
}

public void Escalar(double sx, double sy, double sz)
{
	for (int i = 0; i < fig3D.length; i++)
   	{
		fig3D[i][0]=fig3D[i][0]*sx;
   		fig3D[i][1]=fig3D[i][1]*sy;
   		fig3D[i][2]=fig3D[i][2]*sz;
   	}
	conva2D();
   	repaint();
}

public void mouseDragged(MouseEvent me) 
{	
	if(mover)
	{
		int rx = me.getX();
		int ry = me.getY();
		double dx = rx-posx;
		double dy = ry-posy;
		posx = rx;
		posy = ry;
		Trasladar(dx, dy);
		repaint();
	}
}

public void mouseMoved(MouseEvent me) {}

public void mouseClicked(MouseEvent me) {}

public void mouseEntered(MouseEvent me) {}

public void mouseExited(MouseEvent me) {}

public void mousePressed(MouseEvent me) 
{
	Encuentra_MinMax();
	posx = me.getX();
	posy = me.getY();
	if(posx>minx && posx<maxx && posy>miny && posy<maxy)
	{
		mover = true;
	}
	else
	{
		mover =  false;
	}
	repaint();		
}

public void mouseReleased(MouseEvent me) {}

public BufferedImage loadImage(String nombre) 
{
    URL url = null;
    try 
    {
    	url = getClass().getResource(nombre);
    	return ImageIO.read(url);

    } 
    catch (Exception e) 
    {
    	System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
    	System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
    	return null; 
    }
 }
}
