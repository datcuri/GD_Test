package TestPart;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GD_Dangnhap extends JFrame {
	DangnhapDao dao = new DangnhapDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfTaikhoan;
	private JPasswordField tfMatkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_Dangnhap frame = new GD_Dangnhap();
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
	
	public GD_Dangnhap() {
		setTitle("\u0110\u0103ng Nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LDangNhap = new JLabel("\u0110\u0102NG NH\u1EACP");
		LDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LDangNhap.setBounds(130, 11, 129, 28);
		contentPane.add(LDangNhap);
		
		JLabel LTaikhoan = new JLabel("T\u00E0i Kho\u1EA3n :");
		LTaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		LTaikhoan.setBounds(20, 52, 75, 28);
		contentPane.add(LTaikhoan);
		
		JLabel LMatkhau = new JLabel("M\u1EADt kh\u1EA9u :");
		LMatkhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		LMatkhau.setBounds(20, 98, 75, 28);	
		contentPane.add(LMatkhau);
		
		tfTaikhoan = new JTextField();
		tfTaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfTaikhoan.setBounds(101, 50, 251, 28);
		contentPane.add(tfTaikhoan);
		tfTaikhoan.setColumns(10);
		
		JButton BtDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		BtDangNhap.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (tfTaikhoan.getText().isEmpty() || tfMatkhau.getText().isEmpty()){
					JOptionPane.showConfirmDialog(null, "Tai khoan, mat khau thieu");
				} else {
					int check = dao.getAccount(tfTaikhoan.getText(), tfMatkhau.getText());
					
					try {
						if (check == 1) {
							JOptionPane.showConfirmDialog(null, "Dang nhap thanh cong");
							dispose();
							FrStudent k = new FrStudent();
							k.setVisible(true);
						} else { 
							if (check > 1) { 
							JOptionPane.showConfirmDialog(null, "Loi du lieu tai khoan");
							} else {
								JOptionPane.showConfirmDialog(null, "Nhap sai tai khoan");
							}
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			}
		});
		BtDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		BtDangNhap.setBounds(245, 146, 107, 28);
		contentPane.add(BtDangNhap);
		
		tfMatkhau = new JPasswordField();
		tfMatkhau.setBounds(101, 98, 251, 32);
		contentPane.add(tfMatkhau);
	}
}
