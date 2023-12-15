package controller;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import impl.studentDaoImpl;
import model.student;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_chi;
	private JTextField textField_eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 1059);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 568, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		lblNewLabel.setBounds(185, 22, 168, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 117, 568, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 22, 64, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 55, 64, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文：");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 88, 64, 23);
		panel_1.add(lblNewLabel_1_2);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textField_name.setBounds(56, 22, 202, 26);
		panel_1.add(textField_name);
		textField_name.setColumns(10);
		
		textField_chi = new JTextField();
		textField_chi.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textField_chi.setColumns(10);
		textField_chi.setBounds(56, 55, 202, 26);
		panel_1.add(textField_chi);
		
		textField_eng = new JTextField();
		textField_eng.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textField_eng.setColumns(10);
		textField_eng.setBounds(56, 88, 202, 26);
		panel_1.add(textField_eng);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 320, 568, 354);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 67, 548, 277);
		panel_2.add(output);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 1. 取 name, chi, eng, getText()
				// 2. 轉型 chi eng 轉整數
				// 3. new student(name, chi, eng);
				// 4. new studentDaoImpl().add(s);
				
				String Name = textField_name.getText();  // 1.
				int Chi = Integer.parseInt(textField_chi.getText());  // 2.
				int Eng = Integer.parseInt(textField_eng.getText());  // 2.
				
				student s = new  student(Name, Chi, Eng);  // 3.
				
				new studentDaoImpl().add(s);  // 4.
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 132, 134, 51);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *  1. queryAll2() --> List
				 *  2. String show = "";
				 */
				
				output.setText(new studentDaoImpl().queryAll1());
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 10, 134, 51);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("查詢(List)");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<student> l=new studentDaoImpl().queryAll2();
				String show = "";
				int sum = 0;
				int i = 0;
				for(student o:l) {
					
					i++;
					sum = sum+(o.getChi()+o.getEng());
					show = show+"id:"+o.getId()+"\tname:"+o.getName()+"\tchi:"+o.getChi()+"\teng:"+o.getEng()+"\t總分:"+sum+"\n";
				}
				show = show+"\n總分合計:"+sum+"總分平均:"+(sum/i);
				
				output.setText(show);
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(174, 10, 134, 51);
		panel_2.add(btnNewButton_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 684, 568, 328);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
	}
}
