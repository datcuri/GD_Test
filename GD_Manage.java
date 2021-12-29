package Employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendarBeanInfo;
import com.toedter.calendar.JDateChooser;



public class GD_Manage extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfRate;
	
	private void resetForm(){
		tfID.setText("");
		tfName.setText("");
		tfRate.setText("");
	}
	private Boolean ValidateForm(){
		if (tfID.getText().isEmpty() || tfName.getText().isEmpty())
			return false;
		return true;
	}
	public void setmodel(Employee st){
		tfID.setText(String.valueOf(st.getID()));
		tfName.setText(st.getName());
		dateBirthday.
		tfRate.setText(String.valueOf(st.getAge()));
		tfPhone.setText(st.getPhone());
		tfAddress.setText(st.getAddress());
		
	}
	public student getModel(){
		student st = new student();
		st.setID(Integer.parseInt(tfID.getText()));
		st.setName(tfName.getText());
		st.setAge(Integer.parseInt(tfage.getText()));
		st.setPhone(tfPhone.getText());
		st.setAddress(tfAddress.getText());
		
		return st;
	}
	public void fillDataTable(){
		DefaultTableModel model = (DefaultTableModel) Table.getModel();
		model.setRowCount(0);
		for (student st : dao.getAllStudent()){
			Object DataRow[] = new Object[5];
			DataRow[0] = st.getID();
			DataRow[1] = st.getName();
			DataRow[2] = st.getAge();
			DataRow[3] = st.getPhone();
			DataRow[4] = st.getAddress();
			model.addRow(DataRow);
		}
	}
	public void Selectstudent(String text){
		DefaultTableModel model = (DefaultTableModel) Table.getModel();
		model.setRowCount(0);
			student st = dao.getStudentbyID(Integer.parseInt(text));
			
			Object DataRow[] = new Object[5];
			DataRow[0] = st.getID();
			DataRow[1] = st.getName();
			DataRow[2] = st.getAge();
			DataRow[3] = st.getPhone();
			DataRow[4] = st.getAddress();
			model.addRow(DataRow);
		
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_Manage frame = new GD_Manage();
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
	public GD_Manage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 564, 149);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Birthday", "Rate", "Deparment"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Employee Manage");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(210, 11, 155, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lbID = new JLabel("ID :");
		lbID.setBounds(25, 212, 46, 14);
		contentPane.add(lbID);
		
		tfID = new JTextField();
		tfID.setBounds(102, 209, 155, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(25, 240, 46, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(102, 237, 155, 20);
		contentPane.add(tfName);
		
		JLabel lblBrithday = new JLabel("Brithday :");
		lblBrithday.setBounds(25, 270, 62, 14);
		contentPane.add(lblBrithday);
		
		JLabel lbRate = new JLabel("Rate :");
		lbRate.setBounds(25, 298, 46, 14);
		contentPane.add(lbRate);
		
		tfRate = new JTextField();
		tfRate.setColumns(10);
		tfRate.setBounds(102, 295, 155, 20);
		contentPane.add(tfRate);
		
		JLabel lbDeparment = new JLabel("Deparment :");
		lbDeparment.setBounds(25, 326, 62, 14);
		contentPane.add(lbDeparment);
		
		JButton btnAdd = new JButton("ADD Employee");
		btnAdd.setBounds(278, 211, 139, 23);
		contentPane.add(btnAdd);
		
		JComboBox cbDeparment = new JComboBox();
		cbDeparment.setModel(new DefaultComboBoxModel(new String[] {"VKU", "UDT", "KAK"}));
		cbDeparment.setBounds(102, 326, 155, 20);
		contentPane.add(cbDeparment);
		
		JDateChooser dateBirthday = new JDateChooser();
		dateBirthday.setBounds(102, 268, 155, 20);
		contentPane.add(dateBirthday);
		
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(45);
		table_1.getColumnModel().getColumn(0).setMinWidth(1);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(226);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(118);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(177);
	}
}
