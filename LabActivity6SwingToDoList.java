package Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;

public class LabActivity6SwingToDoList {
		
	public static String TaskStatus = "OnGoing";
	public static String ErrorFrameLabel;
	
	public static String[] Column =  {"Task Name","Task Description","Status"};
	public static Object[][] Data= {};
		
	public static DefaultTableModel tableModel = new DefaultTableModel(null,Column);
	public static JTable table = new JTable(tableModel);
	public static JFrame ErrorFrame = new JFrame();
	public static JFrame NewTaskFrame;
	
	public static JLabel ErrLabel = new JLabel();
	
	
	public static String DynamicErrorMessage(String DynamicTaskNameError,String DynamicTaskDescError) {
		//Shorthand for TaskName TaskDescription and Status
		String TN = "";
		String TD = "";
		//String ST = ""; Status is set to "Not Started" by default which is not null.
		String ErrorMessage = "Please Fill in ";
		
		int ErrorsCounted = 0;
		if (DynamicTaskNameError.length()==0) {
			
			TN = "Task Name";
			ErrorsCounted ++;
		}
		if (DynamicTaskDescError.length()==0) {
			if (ErrorsCounted!=0) {
				TD = " and Task Description";
			}
			else {
				TD = "Task Description";
			}
		}
		/*                             The status is a combo box, it has a value by default.
	           						   Removing this comment and comment of Line 34 will add Status to be displayed on error message as well.
		if (DynamicStatError.length()==0) {
			
			if (ErrorsCounted!=0) {
				ST = " and Status";
			}
			else {
				ST = " Status";
			}
		}
		*/
		
		return (ErrorMessage+TN+TD);
	}
	
	public static Object[][] ARowOfData(Object[][] Original_Datas ,String TaskName,String TaskDescription,String Status){
		
		Object[] Datas = {TaskName,TaskDescription,Status};
		//System.out.println(Original_Datas.length);
		Object[][] FreshArray = new Object[Original_Datas.length+1][3];	
		//FreshArray is a 2D array placeholder to be used with JTable
		
		for (int i = 0; i<(FreshArray.length);i++) {
			//System.out.print(Arrays.toString(FreshArray[i])+" , ");
			
			if (i<Original_Datas.length) {
				FreshArray[i]=Original_Datas[i];
				//System.out.println(Arrays.toString(FreshArray[i]));
			}
			else {
				FreshArray[i]=Datas;
			}
			for (int n = 0;n<3;n++) {
				//System.out.println(FreshArray[i][n]);
			}
		}
			return 	FreshArray;
	}
	
	public static void init_MainFrame(){
		
		JFrame Mainframe = new JFrame();
		Mainframe.setTitle("To-Do List Viewer");
		Mainframe.setLayout(null);
		Mainframe.setSize(600,400);
		Mainframe.setResizable(false);
		
		JButton button = new JButton("Add Task");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				NewTaskFrame.setVisible(true);
			}
		});

		button.setBounds((Mainframe.getWidth()/2)-50 ,12,100,30);
		
		table.setVisible(false);
		table.getTableHeader().setBounds(0,58,600,50);
		table.setDefaultEditor(Object.class, null);

		/*
		table.getColumn(Column[0]).setWidth(233);
		table.getColumn(Column[1]).setWidth(233);
		table.getColumn(Column[2]).setWidth(233);
		
		table.getColumn(Column[0]).setResizable(false);
		table.getColumn(Column[1]).setResizable(false);
		table.getColumn(Column[2]).setResizable(false);
		*/
		
		table.setBounds(0,87,600,16*Data.length);
		
		Mainframe.add(table.getTableHeader());
		
		
		Mainframe.add(button);
		Mainframe.setVisible(true);
		
		
		Mainframe.add(table);
		table.getTableHeader().setBounds(0,66,580,22);
		
		button.setHorizontalAlignment(SwingConstants.CENTER);
		
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void _ErrorFrame() {
	
		ErrorFrame.setSize(375,155);
		ErrorFrame.setTitle("Input Error");
		ErrorFrame.setLayout(null);
		ErrorFrame.setResizable(false);
		
		ErrLabel.setHorizontalAlignment(JLabel.CENTER);
		ErrLabel.setVerticalAlignment(JLabel.CENTER);
		ErrLabel.setSize(375,80);
		
		ErrLabel.setText(ErrorFrameLabel);
		ImageIcon Image = new ImageIcon("ErrorImage.png");
		
		ErrLabel.setIcon(Image);
		
		JButton Button = new JButton("Ok");
		Button.setBounds(145,65,50,30);
		Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ErrorFrame.setVisible(false);
			}
					
		});
		
		
		ErrorFrame.add(ErrLabel);
		ErrorFrame.add(Button);
		
	}
	
	public static void init_NewTaskFrame(){
		

		NewTaskFrame = new JFrame();
		NewTaskFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		NewTaskFrame.setSize(450,350);
		NewTaskFrame.setResizable(false);
		NewTaskFrame.setTitle("Add New Task");
		NewTaskFrame.setLayout(null);

		JLabel TaskNameLabel = new JLabel();
		TaskNameLabel.setText("Task Name:");
		TaskNameLabel.setBounds(20,25,400,23);

		JTextField TaskNameField = new JTextField();
		TaskNameField.setBounds(20,50,400,23);

		JLabel TaskDescriptionLabel = new JLabel();
		TaskDescriptionLabel.setText("Task Description:");
		TaskDescriptionLabel.setBounds(20,80,400,23);

		JTextField TaskDescriptionField = new JTextField();
		TaskDescriptionField.setBounds(20,105,400,23);
		
		JLabel TaskStatusLabel = new JLabel();
		TaskStatusLabel.setText("Status: ");
		TaskStatusLabel.setBounds(20,135,400,23);

		String[] StatusSelection = {"Not Started","Ongoing","Completed"};
		JComboBox StatusDropdown = new JComboBox(StatusSelection);
		StatusDropdown.setSelectedIndex(0);
		StatusDropdown.setBounds(20,160,400,23);

		JButton SaveTask = new JButton("Save Task");
		SaveTask.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String TaskName = TaskNameField.getText();
				String TaskDescription = TaskDescriptionField.getText();
				String Status = StatusSelection[StatusDropdown.getSelectedIndex()];

				if (TaskName.length()==0||TaskDescription.length()==0) {
					
					ErrorFrameLabel = (DynamicErrorMessage(TaskName,TaskDescription));
					_ErrorFrame();
					ErrorFrame.setVisible(true);

				}
				
				
				else {
					Object[] NewRow = {TaskName,TaskDescription,Status};
					Data=ARowOfData(Data,TaskName,TaskDescription,Status);

					tableModel.insertRow(0,NewRow);
					table.setModel(tableModel);
					table.setBounds(0,87,600,16*Data.length);
					table.setVisible(true);
					NewTaskFrame.setVisible(false);
					
					TaskNameField.setText("");
					TaskDescriptionField.setText("");
					
				}
			}
		});		
		SaveTask.setBounds(175,260,100,30);
		NewTaskFrame.add(TaskStatusLabel);
		NewTaskFrame.add(StatusDropdown);
		NewTaskFrame.add(TaskDescriptionField);
		NewTaskFrame.add(TaskNameLabel);
		NewTaskFrame.add(TaskNameField);
		NewTaskFrame.add(TaskDescriptionLabel);
		NewTaskFrame.add(SaveTask);
		}
	public static void main(String[] args) {
		init_NewTaskFrame();
		init_MainFrame();
		_ErrorFrame();
		
		
		//TO PREVENT CELL EDITING
		/*
		do {
			 System.out.println(table.getCellEditor());
			if (table.getCellEditor()!=null) {
				table.getCellEditor().cancelCellEditing();
			}
		}while(true);
		*/
	}

}
