import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class MainForm {
    private JFrame frame;
    private JTable table;
    private JTextField textField;


    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	static class PlaceholderTextPane extends JTextPane {
        private String placeholder;

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
            setForeground(Color.GRAY);
            setText(placeholder);

            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeholder)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setText(placeholder);
                        setForeground(Color.GRAY);
                    }
                }
            });
        }
    }


	public MainForm() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 297, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frame.getContentPane());
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("이름");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 76, SpringLayout.NORTH, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("나이");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 104, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -154, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -236, SpringLayout.EAST, panel);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("휴대전화");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -126, SpringLayout.SOUTH, panel);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -97, SpringLayout.SOUTH, panel);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이메일");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -69, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_2);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("가입일");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -40, SpringLayout.SOUTH, panel);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		JTextPane textPane = new JTextPane();
		sl_panel.putConstraint(SpringLayout.WEST, textPane, 556, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textPane, -30, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -26, SpringLayout.WEST, textPane);
		
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane, -5, SpringLayout.NORTH, textPane_1);
		sl_panel.putConstraint(SpringLayout.NORTH, textPane_1, 104, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textPane_1, 0, SpringLayout.WEST, textPane);
		sl_panel.putConstraint(SpringLayout.EAST, textPane_1, -30, SpringLayout.EAST, panel);
		panel.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, -18, SpringLayout.WEST, textPane_2);
		sl_panel.putConstraint(SpringLayout.NORTH, textPane_2, 133, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane_1, -6, SpringLayout.NORTH, textPane_2);
		sl_panel.putConstraint(SpringLayout.WEST, textPane_2, 0, SpringLayout.WEST, textPane);
		sl_panel.putConstraint(SpringLayout.EAST, textPane_2, -30, SpringLayout.EAST, panel);
		panel.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		sl_panel.putConstraint(SpringLayout.NORTH, textPane_3, 161, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane_2, -5, SpringLayout.NORTH, textPane_3);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -23, SpringLayout.WEST, textPane_3);
		sl_panel.putConstraint(SpringLayout.WEST, textPane_3, 0, SpringLayout.WEST, textPane);
		sl_panel.putConstraint(SpringLayout.EAST, textPane_3, -30, SpringLayout.EAST, panel);
		panel.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		sl_panel.putConstraint(SpringLayout.NORTH, textPane_4, 190, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane_3, -6, SpringLayout.NORTH, textPane_4);
		sl_panel.putConstraint(SpringLayout.WEST, textPane_4, 0, SpringLayout.WEST, textPane);
		sl_panel.putConstraint(SpringLayout.EAST, textPane_4, -30, SpringLayout.EAST, panel);
		panel.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane_4, -5, SpringLayout.NORTH, textPane_5);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_5, -18, SpringLayout.WEST, textPane_5);
		sl_panel.putConstraint(SpringLayout.NORTH, textPane_5, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, textPane_5, 556, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane_5, -40, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textPane_5, 0, SpringLayout.EAST, textPane);
		panel.add(textPane_5);
		
		table = new JTable();
		sl_panel.putConstraint(SpringLayout.NORTH, table, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, table, -323, SpringLayout.EAST, panel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC774\uB984", "\uB098\uC774", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C", "\uC774\uBA54\uC77C", "\uAC00\uC785\uC77C"
			}
		));
		sl_panel.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, panel);
		panel.add(table);
		
		//열 선택시 textpane에 데이터 띄워줌
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (event.getValueIsAdjusting())
		            return;

		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            String[] rowData = new String[table.getColumnCount()];
		            for (int i = 0; i < table.getColumnCount(); i++) {
		                Object value = table.getValueAt(selectedRow, i);
		                rowData[i] = (value != null) ? value.toString() : "";
		            }

		            if (rowData.length >= 6) {
		                textPane.setText(rowData[0]);
		                textPane_1.setText(rowData[1]);
		                textPane_2.setText(rowData[2]);
		                textPane_3.setText(rowData[3]);
		                textPane_4.setText(rowData[4]);
		                textPane_5.setText(rowData[5]);
		            }
		        }
		    }
		});


		/*table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            String[] rowData = new String[6];
		            for (int i = 0; i < table.getColumnCount(); i++) {
		                Object value = table.getValueAt(selectedRow, i);
		                rowData[i] = value.toString();
		            }

		            textPane.setText(rowData[0]);
		            textPane_1.setText(rowData[1]);
		            textPane_2.setText(rowData[2]);
		            textPane_3.setText(rowData[3]);
		            textPane_4.setText(rowData[4]);
		            textPane_5.setText(rowData[5]);
		        }
		    }
		});*/
		
		JButton btnNewButton = new JButton("조회");
		 btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                	  Connection connection = DBConnection.getConnection();
	                      Statement statement = connection.createStatement();
	                      ResultSet resultSet = statement.executeQuery("SELECT * FROM member");

	                      // 결과를 테이블에 표시
	                      DefaultTableModel model = (DefaultTableModel) table.getModel();
	                      model.setRowCount(0); // 기존 데이터 초기화

	                      while (resultSet.next()) {
	                          String[] rowData = new String[6];
	                          rowData[0] = resultSet.getString("name");
	                          rowData[1] = resultSet.getString("age");
	                          rowData[2] = resultSet.getString("tel");
	                          rowData[3] = resultSet.getString("addr");
	                          rowData[4] = resultSet.getString("email");
	                          rowData[5] = resultSet.getString("regist_day");
	                          model.addRow(rowData);
	                      }

	                      resultSet.close();
	                      statement.close();
	                      connection.close();
	                  } catch (SQLException ex) {
	                      ex.printStackTrace();
	                  }
	            }
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("입력");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -6, SpringLayout.WEST, btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String name = textPane.getText().trim();
                    String age = textPane_1.getText().trim();
                    String tel = textPane_2.getText().trim();
                    String addr = textPane_3.getText().trim();
                    String email = textPane_4.getText().trim();
                    String regist_day = textPane_5.getText().trim();
                    
                    Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO member (name, age, tel, addr, email, regist_day) VALUES (?, ?, ?, ?, ?, ?)");
                    statement.setString(1, name);
                    statement.setString(2, age);
                    statement.setString(3, tel);
                    statement.setString(4, addr);
                    statement.setString(5, email);
                    statement.setString(6, regist_day);
                    statement.executeUpdate();

                    statement.close();
                    connection.close();
                    
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    Object[] rowData = {name, age, tel, addr, email, regist_day};
                    model.insertRow(0, rowData);
                    
                    // 입력 후 필드 초기화
                    textPane.setText("");
                    textPane_1.setText("");
                    textPane_2.setText("");
                    textPane_3.setText("");
                    textPane_4.setText("");
                    textPane_5.setText("");
                    
                    textField.setText("입력되었습니다");

                    Timer timer = new Timer(3000, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            textField.setText("");
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
			}
		});
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("수정");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.NORTH, textPane, 43, SpringLayout.SOUTH, btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
	                    String name = textPane.getText().trim();
	                    int age = Integer.parseInt(textPane_1.getText().trim());
	                    String tel = textPane_2.getText().trim();
	                    String addr = textPane_3.getText().trim();
	                    String email = textPane_4.getText().trim();
	                    String regist_day = textPane_5.getText().trim();
	                    
	                    Connection connection = DBConnection.getConnection();
	                    PreparedStatement statement = connection.prepareStatement(
	                            "UPDATE member SET name = ?, age = ?, addr = ?, email = ?, regist_day = ? WHERE tel = ?");
	                    statement.setString(1, name);
	                    statement.setInt(2, age);
	                    statement.setString(3, addr);
	                    statement.setString(4, email);
	                    statement.setString(5, regist_day);
	                    statement.setString(6, tel);
	                    int rowsAffected = statement.executeUpdate();

	                    statement.close();
	                    connection.close();
	                    
	                    if (rowsAffected > 0) {
	                        // 수정 성공적으로 완료되었을 경우 처리
	                        textField.setText("수정 되었습니다");
	                        
	                        DefaultTableModel model = (DefaultTableModel) table.getModel();
	                        int selectedRow = table.getSelectedRow();
	                        
	                        // 업데이트할 값 설정
	                        String updatedAge = String.valueOf(age); // 수정된 age 값
	                        String updatedTel = tel; // 수정된 tel 값
	                        String updatedAddr = addr; // 수정된 addr 값
	                        String updatedEmail = email; // 수정된 email 값
	                        String updatedRegist_day = regist_day;
	                        
	                        // 업데이트할 셀 위치 설정
	                        int ageColumnIndex = 1; // age 열의 인덱스
	                        int telColumnIndex = 2; // tel 열의 인덱스
	                        int addrColumnIndex = 3; // addr 열의 인덱스
	                        int emailColumnIndex = 4; // email 열의 인덱스
	                        int registdayColumnIndex = 5;
	                        
	                        // 테이블 모델의 값을 업데이트
	                        model.setValueAt(updatedAge, selectedRow, ageColumnIndex);
	                        model.setValueAt(updatedTel, selectedRow, telColumnIndex);
	                        model.setValueAt(updatedAddr, selectedRow, addrColumnIndex);
	                        model.setValueAt(updatedEmail, selectedRow, emailColumnIndex);
	                        model.setValueAt(updatedRegist_day, selectedRow, registdayColumnIndex);
	                        
	                        // 이름 컬럼을 업데이트하기 위해 다음 코드를 추가
	                        int nameColumnIndex = 0; // name 열의 인덱스
	                        model.setValueAt(name, selectedRow, nameColumnIndex);
	                        
	                        Timer timer = new Timer(3000, new ActionListener() {
	                            public void actionPerformed(ActionEvent e) {
	                                textField.setText("");
	                            }
	                        });
	                        timer.setRepeats(false);
	                        timer.start();
	                    }
	                    else {
	                    	 textField.setText("입력값을 확인해주세요");
	                    	    frame.toFront(); // JFrame을 최상위로 가져옴
	                    	    frame.requestFocus(); // JFrame에 포커스 설정
	                    	    JOptionPane.showMessageDialog(frame, "입력값을 확인해주세요", "알림", JOptionPane.WARNING_MESSAGE);
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
			}
		});
		panel.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_3 = new JButton("삭제");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -6, SpringLayout.WEST, btnNewButton_3);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, textPane);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    String name = textPane.getText().trim();

	                    Connection connection = DBConnection.getConnection();
	                    PreparedStatement statement = connection.prepareStatement("DELETE FROM member WHERE name = ?");
	                    statement.setString(1, name);
	                    int rowsAffected = statement.executeUpdate();

	                    statement.close();
	                    connection.close();

	                    if (rowsAffected > 0) {
	                        // 삭제 성공적으로 완료되었을 경우 처리
	                    	textField.setText("삭제 되었습니다");
	                    	 textPane.setText("");
	                            textPane_1.setText("");
	                            textPane_2.setText("");
	                            textPane_3.setText("");
	                            textPane_4.setText("");
	                            textPane_5.setText("");
	                            
	                         // 테이블 업데이트
	                         DefaultTableModel model = (DefaultTableModel) table.getModel();
	                         int selectedRow = table.getSelectedRow();
	                         model.removeRow(selectedRow);
	                            
	                    	Timer timer = new Timer(3000, new ActionListener() {
		                        public void actionPerformed(ActionEvent e) {
		                            textField.setText("");
		                        }
		                    });
		                    timer.setRepeats(false);
		                    timer.start();
	                    } //검색 조건 추가한다고 하는경우 여기에 else로 추가
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("↺");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, textPane);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 텍스트 박스 초기화
		        textPane.setText("");
		        textPane_1.setText("");
		        textPane_2.setText("");
		        textPane_3.setText("");
		        textPane_4.setText("");
		        textPane_5.setText("");
			}
		});
		panel.add(btnNewButton_4);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane(table);
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 51, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, -308, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, table, -51, SpringLayout.NORTH, scrollPane);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 0, SpringLayout.SOUTH, scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 32, SpringLayout.EAST, scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 32, SpringLayout.EAST, scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 23, SpringLayout.EAST, scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 32, SpringLayout.EAST, scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 32, SpringLayout.EAST, scrollPane);
		panel.add(scrollPane);
	
		
		JButton btnNewButton_5 = new JButton("검색");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_5, 0, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_5, -96, SpringLayout.WEST, btnNewButton);
		panel.add(btnNewButton_5);
		
		final PlaceholderTextPane textPane_6 = new PlaceholderTextPane();
		textPane_6.setPlaceholder("찾을 회원의 이름을 입력해 주세요");
		sl_panel.putConstraint(SpringLayout.WEST, textPane_6, 54, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textPane_6, 0, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, textPane_6, -6, SpringLayout.WEST, btnNewButton_5);
		panel.add(textPane_6);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String searchText = textPane_6.getText().trim(); // 검색할 값 가져오기

			        Connection connection = null;
			        Statement statement = null;
			        ResultSet resultSet = null;

			        try {
			            connection = DBConnection.getConnection();
			            statement = connection.createStatement();

			            // SQL 문 실행
			            String sql = "SELECT * FROM member WHERE name = '" + searchText + "'";
			            resultSet = statement.executeQuery(sql);

			            if (resultSet.next()) {
			                // 해당 값 찾았을 때 처리
			                String name = resultSet.getString("name");

			                DefaultTableModel model = (DefaultTableModel) table.getModel();
			                model.setRowCount(0); // 테이블 초기화

			                // 검색된 결과 테이블에 추가
			                Object[] row = new Object[5]; // 테이블의 열 개수에 맞게 배열 크기 조정
			                row[0] = resultSet.getString("name");
			                row[1] = resultSet.getInt("age");
			                row[2] = resultSet.getString("tel");
			                row[3] = resultSet.getString("addr");
			                row[4] = resultSet.getString("email");
			                model.addRow(row);
			            } else {
			                // 값이 테이블에 없을 경우 처리
			                JOptionPane.showMessageDialog(frame, "값을 찾을 수 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        } finally {
			            // 리소스 해제
			            if (resultSet != null) {
			                try {
			                    resultSet.close();
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			            }
			            if (statement != null) {
			                try {
			                    statement.close();
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			            }
			            if (connection != null) {
			                try {
			                    connection.close();
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			            }
			        }
			 }
		});
		
		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField, -5, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, panel_1);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("메세지");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 13, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_6, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_6, 64, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_6);
	}
}
