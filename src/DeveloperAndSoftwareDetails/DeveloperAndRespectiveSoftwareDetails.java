package DeveloperAndSoftwareDetails;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DeveloperAndRespectiveSoftwareDetails extends JFrame {
    static DeveloperAndRespectiveSoftwareDetails frame;
    private JPanel contentPane;
    JScrollPane sp;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new DeveloperAndRespectiveSoftwareDetails();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public DeveloperAndRespectiveSoftwareDetails() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920,1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblDeveloperAndRespectiveSoftwareDetails = new JLabel("Developer And Respective Software Details");
        lblDeveloperAndRespectiveSoftwareDetails.setForeground(Color.DARK_GRAY);
        lblDeveloperAndRespectiveSoftwareDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton btnAddStudent = new JButton("Add Developer");
        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddDeveloper.main(new String[]{});
                frame.dispose();
            }
        });

        JButton btnViewStudents = new JButton("View Details");
        btnViewStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewDetails.main(new String[]{});
            }
        });


        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(161)
                                                .addComponent(lblDeveloperAndRespectiveSoftwareDetails))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(149)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(btnViewStudents, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                )))));
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblDeveloperAndRespectiveSoftwareDetails)
                                .addGap(29)
                                .addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnViewStudents, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}