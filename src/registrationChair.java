
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j.mcclure
 */
public class registrationChair extends javax.swing.JFrame {

    //global variables
    private String username; //private variables used in encapsulation to increase security of sensitve information
    private String password1;
    private String passwordAgain;
    
    public int committee;
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public registrationChair() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Username = new javax.swing.JTextField();
        jPasswordField_1 = new javax.swing.JPasswordField();
        jPasswordField_Again = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton_Disarmament = new javax.swing.JRadioButton();
        jRadioButton_EcoSoc = new javax.swing.JRadioButton();
        jRadioButton_Environment = new javax.swing.JRadioButton();
        jRadioButton_SecuirtyCouncil = new javax.swing.JRadioButton();
        jButton_Submit = new javax.swing.JButton();
        jButton_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password (must be at least 5 characters and include a digit or a special character)");

        jPasswordField_1.setText("jPasswordField1");

        jPasswordField_Again.setText("jPasswordField2");

        jLabel3.setText("Please ReEnter Password");

        jLabel4.setText("Committee");

        jRadioButton_Disarmament.setText("Disarmament");
        jRadioButton_Disarmament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_DisarmamentActionPerformed(evt);
            }
        });

        jRadioButton_EcoSoc.setText("EcoSoc");
        jRadioButton_EcoSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_EcoSocActionPerformed(evt);
            }
        });

        jRadioButton_Environment.setText("Environment");
        jRadioButton_Environment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_EnvironmentActionPerformed(evt);
            }
        });

        jRadioButton_SecuirtyCouncil.setText("Secuirty Council");
        jRadioButton_SecuirtyCouncil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SecuirtyCouncilActionPerformed(evt);
            }
        });

        jButton_Submit.setText("Submit Registration");
        jButton_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SubmitActionPerformed(evt);
            }
        });

        jButton_back.setText("Back ");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField_Again, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton_Disarmament)
                                    .addComponent(jRadioButton_EcoSoc))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton_SecuirtyCouncil)
                                    .addComponent(jRadioButton_Environment))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton_Submit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton_back)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField_Again, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Disarmament)
                    .addComponent(jRadioButton_Environment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_EcoSoc)
                    .addComponent(jRadioButton_SecuirtyCouncil))
                .addGap(49, 49, 49)
                .addComponent(jButton_Submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_DisarmamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_DisarmamentActionPerformed
        committee = 1;
        
        //if one clicked then the others can't be selected
        jRadioButton_EcoSoc.setSelected(false);
        jRadioButton_Environment.setSelected(false);
        jRadioButton_SecuirtyCouncil.setSelected(false);
    }//GEN-LAST:event_jRadioButton_DisarmamentActionPerformed

    private void jButton_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SubmitActionPerformed

         //connect to database
        connectToDatabase Test = new connectToDatabase();
        Test.connectToDatabase();
        //update connection variable
        connection = Test.getConnectionVariable(connection);
    
        
        String inputUsername = jTextField_Username.getText();
        String inputPassword = String.valueOf(jPasswordField_1.getPassword());
        String inputPassword2 = String.valueOf(jPasswordField_Again.getPassword());
        
        int num_Username = 1;
        try{
            String matchUsername = "SELECT COUNT(username) AS num_username FROM chair WHERE username = ?"; //sql statement to count the num ber of rows with the same username
            ps = connection.prepareStatement(matchUsername);
            ps.setString(1, inputUsername);
            rs = ps.executeQuery();
            
            while (rs.next())
            {
                num_Username = rs.getInt("num_username");
            }
        
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(num_Username == 0) //check to see if username is unique
        {
            if(inputPassword.equals(inputPassword2)) 
            {
               //looking for digits and special characters
               Pattern digit = Pattern.compile("[0-9]");
               Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

               Matcher hasDigit = digit.matcher(inputPassword);
               Matcher hasSpecial = special.matcher(inputPassword);

                if (hasDigit.find() == false && hasSpecial.find() == false)
               {
                   JOptionPane.showMessageDialog(null, "I am sorry the Password you entered doesn't include a digit or special character. Please re-enter a password");

               } else if(inputPassword.length() <= 4)
                {
                     JOptionPane.showMessageDialog(null, "I am sorry the Password you entered does not meet the required length of 5 characters. Please try again.");

                } else if(inputUsername.equals("null"))
                {
                     JOptionPane.showMessageDialog(null, "I am sorry you need to input a username.");
                } else if (inputPassword.equals("null"))
                {
                     JOptionPane.showMessageDialog(null, "I am sorry you need to input a password.");
                } else
                        try{
                            Statement state=(Statement)connection.createStatement();

                            String insert="INSERT INTO `chair`(`username`, `password`, `committeeID`) VALUES ('"+inputUsername+"','"+inputPassword +"','"+committee+ "')";
                            state.executeUpdate(insert);

                            JOptionPane.showMessageDialog(null, "New Chair Registered");

                            //defaulting all fields
                            jTextField_Username.setText("");
                            jPasswordField_1.setText("12345678");
                            jPasswordField_Again.setText("12345678");
                            jRadioButton_Disarmament.setSelected(false);
                            jRadioButton_Environment.setSelected(false);
                            jRadioButton_EcoSoc.setSelected(false);
                            jRadioButton_SecuirtyCouncil.setSelected(false);

                        } catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage() ,"Error", 1);
                } 

            } else {
                JOptionPane.showMessageDialog(null, "I am sorry the two passwords you entered to not match. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username not unique, please enter another username");
        }
        
    }//GEN-LAST:event_jButton_SubmitActionPerformed

    private void jRadioButton_EcoSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_EcoSocActionPerformed
        committee = 2;
        //if one clicked then the others can't be selected
        jRadioButton_Disarmament.setSelected(false);
        jRadioButton_Environment.setSelected(false);
        jRadioButton_SecuirtyCouncil.setSelected(false);
    }//GEN-LAST:event_jRadioButton_EcoSocActionPerformed

    private void jRadioButton_EnvironmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_EnvironmentActionPerformed
       committee = 3;
       //if one clicked then the others can't be selected
       jRadioButton_Disarmament.setSelected(false);
       jRadioButton_EcoSoc.setSelected(false);
       jRadioButton_SecuirtyCouncil.setSelected(false);
    }//GEN-LAST:event_jRadioButton_EnvironmentActionPerformed

    private void jRadioButton_SecuirtyCouncilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SecuirtyCouncilActionPerformed
        committee = 4;
        //if one clicked then the others can't be selected
        jRadioButton_Disarmament.setSelected(false);
        jRadioButton_Environment.setSelected(false);
        jRadioButton_EcoSoc.setSelected(false);
    }//GEN-LAST:event_jRadioButton_SecuirtyCouncilActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        this.setVisible(false);

        homePage form = new homePage();
        form.setVisible(true);
    }//GEN-LAST:event_jButton_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registrationChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrationChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrationChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrationChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrationChair().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_Submit;
    private javax.swing.JButton jButton_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField_1;
    private javax.swing.JPasswordField jPasswordField_Again;
    private javax.swing.JRadioButton jRadioButton_Disarmament;
    private javax.swing.JRadioButton jRadioButton_EcoSoc;
    private javax.swing.JRadioButton jRadioButton_Environment;
    private javax.swing.JRadioButton jRadioButton_SecuirtyCouncil;
    private javax.swing.JTextField jTextField_Username;
    // End of variables declaration//GEN-END:variables
}
