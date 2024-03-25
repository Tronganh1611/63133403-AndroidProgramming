package ntu.Anh_63133403;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cau1_AppBMI extends JFrame {

	private JPanel contentPane;
	private JTextField txtW;
	private JTextField txtH;
	private JTextField txtBMI;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtNX;
	private JLabel lbNX;
	public Cau1_AppBMI() {
		setTitle("App BMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.gray);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập Cân Nặng :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 55, 172, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNhpChiuCao = new JLabel("Nhập Chiều Cao :");
		lblNhpChiuCao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhpChiuCao.setBounds(34, 121, 172, 41);
		contentPane.add(lblNhpChiuCao);
		
		txtW = new JTextField();
		txtW.setBounds(255, 55, 344, 41);
		contentPane.add(txtW);
		txtW.setColumns(10);
		
		txtH = new JTextField();
		txtH.setColumns(10);
		txtH.setBounds(255, 123, 344, 41);
		contentPane.add(txtH);
		
		txtBMI = new JTextField();
		txtBMI.setEditable(false);
		txtBMI.setBounds(255, 240, 344, 41);
		txtBMI.setBorder(null);
		contentPane.add(txtBMI);
		txtBMI.setColumns(10);
		
		JLabel lblChSBmi = new JLabel("Chỉ số BMI :");
		lblChSBmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChSBmi.setBounds(34, 240, 172, 41);
		contentPane.add(lblChSBmi);
		
		JButton btnBMI = new JButton("Tính BMI");
		btnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuliBMI();
			}
		});
		btnBMI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBMI.setBounds(255, 185, 102, 40);
		contentPane.add(btnBMI);
		
		lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(609, 55, 45, 41);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("m");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(609, 121, 45, 41);
		contentPane.add(lblNewLabel_2);
		
        
        txtNX = new JTextField();
        txtNX.setEditable(false);
        txtNX.setColumns(10);
        txtNX.setBounds(255, 314, 344, 41);
        txtNX.setBorder(null);
        contentPane.add(txtNX);
        
        lbNX = new JLabel("Nhận xét:");
        lbNX.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbNX.setBounds(34, 312, 172, 41);
        contentPane.add(lbNX);
	}
	void xuliBMI() {
		//Lay du lieu
		if((txtH.getText().isEmpty())||(txtW.getText().isEmpty()))
		{
		    JOptionPane TB = new JOptionPane();
		    TB.showMessageDialog(this, "Vui Lòng Nhập thêm Thông tin");
		}

		String str_w = txtW.getText();
		String str_h = txtH.getText();
		//chuyen doi du lieu
		Double W = Double.parseDouble(str_w);
		Double H = Double.parseDouble(str_h);
		
		Double BMI = W/(H*H);
		
		txtBMI.setText(String.valueOf(BMI));
		
		// Them nhan xet ve chi so BMI
	    String nhanXet;
	    if (BMI < 18.5) {
	        nhanXet = "Bạn đang ở trong tình trạng thiếu cân.";
	    } else if (BMI >= 18.5 && BMI < 24.9) {
	        nhanXet = "Bạn có một cơ thể khỏe mạnh!";
	    } else if (BMI >= 25 && BMI < 29.9) {
	        nhanXet = "Bạn đang ở trong tình trạng thừa cân.";
	    } else {
	        nhanXet = "Bạn đang ở trong tình trạng béo phì.";
	    }

	 // Hien thi nhan xet
        txtNX.setText(nhanXet);
	}
}
