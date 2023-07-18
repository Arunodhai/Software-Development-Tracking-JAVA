package DeveloperAndSoftwareDetails;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDeveloper extends JFrame {
    static AddDeveloper frame;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AddDeveloper();
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
    public AddDeveloper() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblAddDeveloper = new JLabel("Add Developer");
        lblAddDeveloper.setForeground(Color.DARK_GRAY);
        lblAddDeveloper.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lblName = new JLabel("Name:");

        JLabel lblId = new JLabel("Id:");

        JLabel lblCurrentlyWorkingSoftware = new JLabel("Currently Working Software");

        JLabel lblFinishedSoftwares = new JLabel("Finished Softwares");

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setColumns(10);

        JButton btnAddDeveloper = new JButton("Add Developer");
        btnAddDeveloper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=textField.getText();
                String id=textField_1.getText();
                String currentlyworkingsoftware=textField_2.getText();
                String finishedsoftware=textField_3.getText();

                Developer a=new Developer(name,id,currentlyworkingsoftware,finishedsoftware);
                int status=DeveloperDao.save(a);

                if(status>0){
                    JOptionPane.showMessageDialog(AddDeveloper.this,"Developer added successfully!");
                    textField.setText("");textField_1.setText("");textField_2.setText("");
                    textField_3.setText("");

                }else{
                    JOptionPane.showMessageDialog(AddDeveloper.this,"Sorry, Unable to add Developer!");
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeveloperAndRespectiveSoftwareDetails.main(new String[]{});
                frame.dispose();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);

        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblId, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCurrentlyWorkingSoftware, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFinishedSoftwares, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                                .addGap(44)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(textField, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                                .addContainerGap(101, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(155)
                                .addComponent(btnAddDeveloper, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(18))
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(163, Short.MAX_VALUE)
                                .addComponent(lblAddDeveloper)
                                .addGap(122))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAddDeveloper)
                                .addGap(11)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblId)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCurrentlyWorkingSoftware)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblFinishedSoftwares)
                                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnAddDeveloper, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(btnBack))
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}

