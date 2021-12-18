package TestPart;


import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.spatialdatatypes.Point;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrStudent extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//bien
	String ID_ST;

	
	studentDao dao = new studentDao();
	
	// jframe
	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfage;
	private JTextField tfPhone;
	private JTextField tfAddress;
	
	private final JTable Table = new JTable();
	
	//
	private void resetForm(){
		tfID.setText("");
		tfName.setText("");
		tfage.setText("");
		tfPhone.setText("");
		tfAddress.setText("")	;
	}
	private Boolean ValidateForm(){
		if (tfID.getText().isEmpty() || tfName.getText().isEmpty())
			return false;
		return true;
	}
	public void setmodel(student st){
		tfID.setText(String.valueOf(st.getID()));
		tfName.setText(st.getName());
		tfage.setText(String.valueOf(st.getAge()));
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
	public boolean ExitFr(){
		return true;
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrStudent frame = new FrStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//new FrStudent();
	}

	/**
	 * Create the frame.
	 */

	public FrStudent() {
		setTitle("ThongkeSV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 64, 463, 372);
		contentPane.add(scrollPane);
		Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int id = Table.rowAtPoint(e.getPoint());
				 ID_ST = Table.getValueAt(id, 0).toString();
				student st = dao.getStudentbyID(Integer.parseInt(ID_ST));
				setmodel(st);
			}
		});
		scrollPane.setViewportView(Table);
		Table.setColumnSelectionAllowed(true);
		Table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Table.setSurrendersFocusOnKeystroke(true);
		Table.setFillsViewportHeight(true);
		Table.setCellSelectionEnabled(true);
		Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Age", "Phone", "Address"
			}
		));
		Table.getColumnModel().getColumn(0).setPreferredWidth(40);
		Table.getColumnModel().getColumn(0).setMinWidth(40);
		Table.getColumnModel().getColumn(0).setMaxWidth(40);
		Table.getColumnModel().getColumn(1).setPreferredWidth(205);
		Table.getColumnModel().getColumn(1).setMaxWidth(205);
		Table.getColumnModel().getColumn(2).setPreferredWidth(61);
		Table.getColumnModel().getColumn(2).setMaxWidth(61);
		Table.getColumnModel().getColumn(3).setPreferredWidth(117);
		Table.getColumnModel().getColumn(3).setMaxWidth(117);
		Table.getColumnModel().getColumn(4).setPreferredWidth(212);
		Table.getColumnModel().getColumn(4).setMaxWidth(212);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(22, 67, 46, 14);
		contentPane.add(lbID);
		
		JLabel label = new JLabel("");
		label.setBounds(33, 75, 46, 14);
		contentPane.add(label);
		
		tfID = new JTextField();
		tfID.setBounds(78, 64, 215, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(22, 97, 46, 14);
		contentPane.add(lbName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(78, 94, 215, 20);
		contentPane.add(tfName);
		
		JLabel lbAge = new JLabel("Age");
		lbAge.setBounds(22, 128, 46, 14);
		contentPane.add(lbAge);
		
		tfage = new JTextField();
		tfage.setColumns(10);
		tfage.setBounds(78, 125, 215, 20);
		contentPane.add(tfage);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setBounds(22, 162, 46, 14);
		contentPane.add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(78, 159, 215, 20);
		contentPane.add(tfPhone);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setBounds(22, 193, 46, 14);
		contentPane.add(lbAddress);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(78, 190, 215, 20);
		contentPane.add(tfAddress);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfID.getText().isEmpty() || ID_ST.length() == 0) {
					JOptionPane.showConfirmDialog(null, "muc id dang de trong");
				} else {
					student st = dao.getStudentbyID(Integer.parseInt(ID_ST));
					setmodel(st);
				}
			}
		});
		btnFind.setBounds(6, 221, 89, 23);
		contentPane.add(btnFind);
		
		JButton btnNew = new JButton("ADD NEW");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		btnNew.setBounds(6, 255, 89, 23);
		contentPane.add(btnNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfID.getText().isEmpty() || ID_ST.length() == 0) {
					JOptionPane.showConfirmDialog(null, "muc id dang de trong");
				} else {
					try {
						if (ID_ST.length() > 0) {
							dao.delete(Integer.parseInt(ID_ST));
						} else {
							dao.delete(Integer.parseInt(tfID.getText()));
						}
						fillDataTable();
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showConfirmDialog(null, "Loi" +e.toString());
					}
				}
			}
		});
		btnDelete.setBounds(204, 221, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(204, 255, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ValidateForm()){
					try {
						student st =  getModel();
						if (dao.update(st) > 0) {
							fillDataTable();
							JOptionPane.showConfirmDialog(null, "Sua thanh cong");
						}
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showConfirmDialog(null, "Loi"+ e.toString());
					}
				}
			}
		});
		btnEdit.setBounds(105, 255, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student st = getModel();
				try {
					if (ValidateForm()){	
						if (dao.insert(st) > 0){
							fillDataTable();
							JOptionPane.showConfirmDialog(null, "luu thanh cong");
						} else {
							JOptionPane.showConfirmDialog(null, "Error"+ st.toString());
						}
					} else {
						JOptionPane.showMessageDialog(null, "nhap day day du thong tin");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}		
		});
		btnSave.setBounds(105, 221, 89, 23);
		contentPane.add(btnSave);
		
		fillDataTable();

	}
}
