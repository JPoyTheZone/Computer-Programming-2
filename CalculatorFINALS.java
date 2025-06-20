package Package;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.util.Arrays;
import java.util.List;

public class CalculatorFINALS {
	
	public static class MainFrame extends JFrame implements ActionListener{
		
		static JTextField DisplayField = new JTextField();
		static JLabel NumberStorage = new JLabel();
		static boolean IsOperating=false;
		static boolean HasAnswer=false;
		
		static long Result;
		static long CachedAnswer=0;
		static int IterationNumber=0;
		static boolean DISPLAY = false;
		static String ConsecutiveOperation = "";
		static String PrevOperation ="Addition";
		
		
		
		static String Operation (String Mode,long Number) {
			
			DISPLAY = true;
			if ((IterationNumber !=0 && ConsecutiveOperation !=Mode) && DisplayField.getForeground()!=(new Color(217,249,217))){
				if (Mode=="Percentage") {
					CachedAnswer = Long.parseLong(DisplayField.getText())/CachedAnswer;
					System.out.println((Long.parseLong(DisplayField.getText())+"/"+CachedAnswer+" = "+Long.toString(Long.parseLong(DisplayField.getText())/CachedAnswer)));
				}
				IterationNumber = 0;
				ConsecutiveOperation ="";
				CachedAnswer=Long.parseLong(DisplayField.getText());
				PrevOperation=Mode;
				DisplayField.setForeground(new Color(217,249,217));
				return "";
			}
			else {

				if (PrevOperation=="Addition") {
					CachedAnswer += Number ;
				}
				else if (PrevOperation=="Subtraction") {
					CachedAnswer -= Number ;
				}
				else if (PrevOperation=="Multiplication") {
					NumberStorage.setText(Long.toString(Number));
					CachedAnswer *= Number ;
					}
				else if (PrevOperation=="Division") {
					NumberStorage.setText(Long.toString(CachedAnswer/Number))  ;
				}

				else if (PrevOperation=="Equals") {
					CachedAnswer = Number;
					if (DisplayField.getText().length()==0) {
						CachedAnswer =0;
					}
	
				}
			}
			//NumberStorage.setText(Long.toString(Number));
			
			if (PrevOperation==Mode) {
			ConsecutiveOperation = Mode;
			}
			PrevOperation = Mode;
			DisplayField.setText(Long.toString(CachedAnswer));
			DisplayField.setForeground(new Color(217,249,217));
			IterationNumber +=1;
			return "";
		}
		
		static void Display() {
			
		}
		
		MainFrame(){
			
			NumberStorage.setForeground(Color.green);

			
			DisplayField.setForeground(Color.green);
			DisplayField.setFont(new Font("Arial",Font.PLAIN,20));
			this.setSize(456,510);
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			JPanel CompleteOperationPanel = new JPanel();
			CompleteOperationPanel.setBounds(320,0,120,510);
			CompleteOperationPanel.setBackground(Color.black);
			
			CompleteOperationPanel.add(NumberStorage);

			JPanel DisplayPanel = new JPanel();
			DisplayPanel.setBackground(Color.black);
			DisplayPanel.setLayout(new BorderLayout());
			DisplayPanel.setBounds(0,0,320,125);
			
			DisplayField.setSize(300,100);
			DisplayField.setHorizontalAlignment(JTextField.CENTER);
			DisplayField.setEditable(false);
			DisplayPanel.add(DisplayField);
			DisplayField.setBackground(Color.black);
			DisplayField.setCaretColor(Color.green);

			JPanel SpecialOperationPanel = new JPanel();
			SpecialOperationPanel.setLayout(new GridLayout(1,6));
			SpecialOperationPanel.setBackground(Color.black);
			SpecialOperationPanel.setBounds(0,125,320,70);
			
			JButton miscButton1 = new JButton(" + ");
			JButton miscButton2 = new JButton(" - ");
			JButton miscButton3 = new JButton(" / ");
			JButton miscButton4 = new JButton(" * ");
			JButton miscButton5 = new JButton(" % ");
			JButton miscButton6 = new JButton(" < ");
			
			JPanel NumberPanel = new JPanel();
			NumberPanel.setLayout(new GridLayout(3,4));
			NumberPanel.setBackground(Color.black);
			NumberPanel.setBounds(0,195,320,230);
			
			JButton button0 = new JButton("0");
			
			JButton button1 = new JButton("1");
			JButton button2 = new JButton("2");
			JButton button3 = new JButton("3");

			JButton button4 = new JButton("4");
			JButton button5 = new JButton("5");
			JButton button6 = new JButton("6");
			
			JButton button7 = new JButton("7");
			JButton button8 = new JButton("8");
			JButton button9 = new JButton("9");
			
			JPanel FooterPanel = new JPanel();
			FooterPanel.setBounds(0,425,320,45);
			FooterPanel.setBackground(Color.black);
			FooterPanel.setLayout(new GridLayout(1,1));
			
			JButton Equals = new JButton(" E ");
			
			FooterPanel.add(Equals);
			Equals.setContentAreaFilled(false);
			Equals.setForeground(Color.green);
			Equals.addActionListener(this);
			
			for (int i = 0 ; i<NumberPanel.getComponentCount();i++) {
				
			}
			
			SpecialOperationPanel.add(miscButton1);
			SpecialOperationPanel.add(miscButton2);
			SpecialOperationPanel.add(miscButton3);
			SpecialOperationPanel.add(miscButton4);
			SpecialOperationPanel.add(miscButton5);
			SpecialOperationPanel.add(miscButton6);
					
			 JPanel EmptCell1= new JPanel();
			 JPanel EmptCell2= new JPanel();
			 EmptCell1.setBackground(Color.black);
			 EmptCell2.setBackground(Color.black);
			 
			NumberPanel.add(button0);
			NumberPanel.add(button1);
			NumberPanel.add(button2);
			NumberPanel.add(button3);
			NumberPanel.add(EmptCell1);
			NumberPanel.add(button4);
			NumberPanel.add(button5);
			NumberPanel.add(button6);
			NumberPanel.add(EmptCell2);
			NumberPanel.add(button7);
			NumberPanel.add(button8);
			NumberPanel.add(button9);

			
			
			DisplayPanel.setBackground(Color.blue);
			
			
			for (int i = 0 ; i<SpecialOperationPanel.getComponentCount();i++) {
				;
				
				Object CurButton = SpecialOperationPanel.getComponent(i);
				((JButton)SpecialOperationPanel.getComponent(i)).setContentAreaFilled(false);
				((JButton)SpecialOperationPanel.getComponent(i)).setForeground(Color.green);
				((JButton)CurButton).setActionCommand(((JButton)CurButton).getText());
				((JButton)CurButton).addActionListener(this);
				
			}
			
			for (int i = 0 ; i<NumberPanel.getComponentCount();i++) {
				;

				
				Object CurButton = NumberPanel.getComponent(i);
				try {
					((JButton)NumberPanel.getComponent(i)).setContentAreaFilled(false);
					((JButton)NumberPanel.getComponent(i)).setForeground(Color.green);
					((JButton)CurButton).setActionCommand(((JButton)CurButton).getText());
					((JButton)CurButton).addActionListener(this);
				}	
				catch (Exception e) {
					
				}

			}
			NumberStorage.setBackground(Color.red);
			NumberStorage.setFont(new Font("Arial",Font.PLAIN,11));
			NumberStorage.setBounds(200,10,300,25);
			
			String[] SpecialOperation = {" = "," - "};
			
			this.add(DisplayPanel);
			this.add(NumberPanel);
			this.add(SpecialOperationPanel);
			this.add(FooterPanel);
			this.add(CompleteOperationPanel);
				
			this.setVisible(true);
	

			
		}

		static long CurNumber = 0;
		static long digits = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String Entered = ((JButton)e.getSource()).getText();
			
			try {
			//I can try to parse Entered to a number
			if (Entered==" / ") {
				Operation("Division",Integer.parseInt(DisplayField.getText()));
				PrevOperation = "Division";
			}
			else if (Entered==" + ") {
				Operation("Addition",Integer.parseInt(DisplayField.getText()));
				PrevOperation = "Addition";
			}
			else if (Entered==" - ") {
				Operation("Subtraction",Integer.parseInt(DisplayField.getText()));
				PrevOperation = "Subtraction";
			}
			else if (Entered==" * ") {
				Operation("Multiplication",Integer.parseInt(DisplayField.getText()));
				PrevOperation = "Multiplication";

			}
			else if (Entered==" % ") {
				Operation("Percentage",Integer.parseInt(DisplayField.getText()));
				PrevOperation = "Percentage";
			}
			else if (Entered==" < ") {
				if (DISPLAY) {
					DisplayField.setText(null);
					CachedAnswer=0;
				}
				
				if (DisplayField.getText().equals("Target Number Out of Range.")) {
					DisplayField.setText(null);
				}
				String Atext = DisplayField.getText();
				if (Atext.length()<=1){
					PrevOperation = "Addition";
					IterationNumber = 0;
					//CachedAnswer =0;
					DISPLAY = false;
					NumberStorage.setText(null);
					DisplayField.setText(null);
					DisplayField.setForeground(Color.green);
					
					
				}
				else {
					DisplayField.setText(Atext.substring(0, DisplayField.getText().length()-1));

				}
			}
			else if (Entered==" E ") {
				Operation(PrevOperation,Long.parseLong(DisplayField.getText()));
			}
			else {
				if (ConsecutiveOperation!=PrevOperation) {
					ConsecutiveOperation="";
				}
				if (DISPLAY) {
					//AutoErase the Display Screen after an answer if any number is pressed.
					DisplayField.setText(null);
					DISPLAY = false;
					DisplayField.setForeground(Color.green);
				}
				DisplayField.setText(DisplayField.getText()+Entered);
			}
			}
			catch(Exception E) {
				System.out.print(E);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame MainF = new MainFrame();
		MainF.repaint();
		
		while (true) {

		}

	}

}
