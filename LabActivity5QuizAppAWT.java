package Package;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LabActivity5QuizAppAWT {

	static int score = 0;
	static int question = 1;

	
	static class QuestionFrame extends JFrame{
		
		QuestionFrame(String Question,String CorrectAnswer,String LetterA,String LetterB,String LetterC,String LetterD){
			
			this.setTitle("Quiz App");
			this.setSize(500,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
			//this.setResizable(false);
			
			JLabel Questionlabel = new JLabel();
			Questionlabel.setText(Question);
			Questionlabel.setSize(500,30);
			Questionlabel.setFont(new Font("Arial",Font.BOLD,16));
			Questionlabel.setHorizontalAlignment(JLabel.CENTER);
			
			JRadioButton AnswerA = new JRadioButton(LetterA);
			AnswerA.setBounds(0,73,250,30);

			AnswerA.setFont(new Font("Arial",Font.PLAIN,16));
			AnswerA.setForeground(Color.blue);
			
			JRadioButton AnswerB = new JRadioButton(LetterB);
			AnswerB.setBounds(250,73,250,30);

			AnswerB.setFont(new Font("Arial",Font.PLAIN,16));
			AnswerB.setForeground(Color.blue);
			
			JRadioButton AnswerC = new JRadioButton(LetterC);
			AnswerC.setBounds(0,180,250,30);

			AnswerC.setFont(new Font("Arial",Font.PLAIN,16));
			AnswerC.setForeground(Color.blue);

			JRadioButton AnswerD = new JRadioButton(LetterD);
			AnswerD.setBounds(250,180,250,30);

			AnswerD.setFont(new Font("Arial",Font.PLAIN,16));
			AnswerD.setForeground(Color.blue);
			
			this.setLayout(null);
			
			ButtonGroup group = new ButtonGroup();
			group.add(AnswerA);
			group.add(AnswerB);
			group.add(AnswerC);
			group.add(AnswerD);
			
			JButton nextButton = new JButton("Next");
			nextButton.setBounds(0,235,500,27);
			//nextButton.setBorderPainted(false);
			nextButton.setContentAreaFilled(false);
			nextButton.setFont(new Font("Arial",Font.BOLD,22));
			
			JLabel ErrorLabel = new JLabel();
			ErrorLabel.setBounds(0,208,500,30);
			ErrorLabel.setHorizontalAlignment(JLabel.CENTER);
			ErrorLabel.setText("Please select an answer");
			ErrorLabel.setVisible(false);
			
			this.add(ErrorLabel);
			this.add(Questionlabel);
			this.add(AnswerA);
			this.add(AnswerB);
			this.add(AnswerC);
			this.add(AnswerD);
			this.add(nextButton);
			
			AnswerA.setActionCommand("A");
			AnswerB.setActionCommand("B");
			AnswerC.setActionCommand("C");
			AnswerD.setActionCommand("D");
			
			nextButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if (CorrectAnswer==group.getSelection().getActionCommand()) {
							score++;
		
							System.out.println(score);
						}
						question++;
					}
					catch (Exception E) {

						System.out.println("works!");
						ErrorLabel.setVisible(true);
					}

					if (question==4) {
						AnswerA.setEnabled(false);
						AnswerB.setEnabled(false);
						AnswerC.setEnabled(false);
						AnswerD.setEnabled(false);
						nextButton.setEnabled(false);
						
						Questionlabel.setText("Quiz Completed! Your Score: "+ score+" out of 3");
						
						
					}
				}
			});

			//this.setVisible(true);
			this.repaint();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionFrame Question1 = new QuestionFrame("What is the Capital of France?","A","Paris","Rome","Berlin","Madrid");
		QuestionFrame Question2 = new QuestionFrame("Which language is used for android development?","B","Swift","Java","Python","Kotlin");
		QuestionFrame Question3 = new QuestionFrame("What is the result of 2+2*2 ?","A","6","8","4","10");
		
		while (true) {
			if (question==1) {
				Question1.setVisible(true);
			}
			if (question==2) {
				Question1.setVisible(false);
				Question2.setVisible(true);
			}
			if (question==3) {
				Question2.setVisible(false);
				Question3.setVisible(true);
			}
			if (question==4) {
			}

		}

	}

}
