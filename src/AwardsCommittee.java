
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
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
public final class AwardsCommittee extends javax.swing.JFrame {
    
    //global variables
    Connection connection;
    ResultSet rs;
    PreparedStatement ps;
    
    int delegateID;
    String countryname;
    int age;
    int chairID;
    int committeeID;
    int count;
    //array of object 
    Delegate[] delegates;
        
    public AwardsCommittee() {
        initComponents();
        
        //connect to database
        connectToDatabase Test = new connectToDatabase();
        Test.connectToDatabase();
        //update connection variable
        connection = Test.getConnectionVariable(connection); 
        
    }
    
    //use total
    public void ranking() //this is what displays in the listbox needs to be seperate from main class section so committeeID can be set
    {
        String committeeName = "";
        
        if(committeeID == 1)
        {
            committeeName = "Disarmerment";
        }else if(committeeID == 2){
            committeeName = "EcoSoc";
        }else if(committeeID == 3){
            committeeName = "Environment";
        } else if (committeeID == 4) {
            committeeName = "Secuirty Council";
        }
        //set display for what committee it is
        jLabel1.setText("Results for the " + committeeName +" Committee");
        
        setDelegateArray(); //private since shouldn't be accessed by general 

        //create an object so this can access the sorting algorithm
        Sorting sortObjects = new Sorting();
        sortObjects.bubbleSortDelegates(delegates, count);
        displayResults();
        awards();
    }
    
    public void setCommitteeID(int committee)
    {
        this.committeeID = committee;
        
        
    }
    
     public void setChairID(int chairID){
         this.chairID = chairID;
        
        //whether or not a button appears since only chairs should have access to button
        //didn't put in setCommitteeID like in AwardsOverall because the committeeID has been changed to view the committee results
        if (chairID == 0)
        {
            jButton_Voting.setVisible(false);
            jButton_selectCommittee.setVisible(true);
           
        }else{
            jButton_Voting.setVisible(true);
            jButton_selectCommittee.setVisible(false);
        
        } 
    }
    
    private void setDelegateArray()
    {
        //get number of countries as well 
        NumberCountries numCount = new NumberCountries();
        count = numCount.NumberCountries(committeeID);
        
        //initialise delegate object size.
        delegates = new Delegate[count]; 
         
        // create array placeholder variable
        int i = 0;
        
        //assign delegate values to array of objects              
            //retrieve needed values from databsase
        try{
                //alias used since a union needed to be made 
                String valuesNeeded = "SELECT d.`delegateID`, c.`countryName`, d.`age`, d.`countryID` FROM `delegate` AS d, `country` AS c WHERE d.`countryID` = c.`countryID` AND `committeeID` = "+ committeeID + ""; //creating alis of table name 
                ps = connection.prepareStatement(valuesNeeded);
                rs = ps.executeQuery();
           
           while (rs.next()) { //conditional loop
                delegateID = rs.getInt("delegateID");
                countryname = rs.getString("countryName");
                age = rs.getInt("age");
                delegates[i] = new Delegate() ;
                delegates[i].setCountryName(countryname);
                delegates[i].setAge(age);
                delegates[i].setTotalScore(delegateID);
                i = i + 1; //running total

            }   
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }   
        
    }
    
    public void displayResults()//add results to listbox
    {
        
        
        DefaultListModel listModel = new DefaultListModel();
        
        //to neaten and clean display by giving a title and space 
        listModel.addElement("Ranking of Countries According To Total Score ");
        listModel.addElement("");
        
        for(int i = 0; i < count ; i++)
        {
           listModel.addElement(""+ (i + 1) +". " + delegates[i].displayMessage());
            
        }
        //actually displaying the results into the ranking listbox
        jListRanking.setModel(listModel);
    }
    
    public void awards()
    {
        
        juniorDelegateAward();
        
        jTextFieldBest.setText(delegates[0].getcountryName()); //best delegate award
        jTextFieldHighlyCommend.setText(delegates[1].getcountryName()); //highly commmended
        jTextFieldCommend.setText(delegates[2].getcountryName()); //commended
        
    }
    
    public void juniorDelegateAward()
    {
        //local variables
        boolean found = false; 
        int counter = 0;
        
        while(found == false && counter == count)
        {
            if (delegates[counter].getAge() < 16)
            {
                jTextFieldBestJunior.setText(delegates[counter].getcountryName());//setting best junior award 
                counter = counter + 1; //running total
                found = true;
            }        
        }
        if (found == false)
        {
            jTextFieldBestJunior.setText("No Juniors In Committee");
        }
    }
            
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonOverall = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCommend = new javax.swing.JTextField();
        jTextFieldHighlyCommend = new javax.swing.JTextField();
        jTextFieldBestJunior = new javax.swing.JTextField();
        jTextFieldBest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRanking = new javax.swing.JList<>();
        jButton_Voting = new javax.swing.JButton();
        jButton_logOut = new javax.swing.JButton();
        jButton_selectCommittee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonOverall.setText("Overall");
        jButtonOverall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOverallActionPerformed(evt);
            }
        });

        jLabel1.setText("Committee Results: ");

        jLabel3.setText("Best Delegate:");

        jLabel4.setText("Commended:");

        jLabel5.setText("Highly Commended:");

        jLabel6.setText("Best Junior Delegate:");

        jTextFieldHighlyCommend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHighlyCommendActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListRanking);

        jButton_Voting.setText("Voting Form");
        jButton_Voting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VotingActionPerformed(evt);
            }
        });

        jButton_logOut.setText("Sign Out");
        jButton_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logOutActionPerformed(evt);
            }
        });

        jButton_selectCommittee.setText("Choose New Committee");
        jButton_selectCommittee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_selectCommitteeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonOverall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Voting)
                                .addGap(29, 29, 29)
                                .addComponent(jButton_selectCommittee))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCommend)
                                    .addComponent(jTextFieldBestJunior)
                                    .addComponent(jTextFieldBest, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(jTextFieldHighlyCommend))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton_logOut))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOverall)
                            .addComponent(jButton_Voting)
                            .addComponent(jButton_selectCommittee))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCommend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldHighlyCommend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldBestJunior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldHighlyCommendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHighlyCommendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHighlyCommendActionPerformed

    private void jButtonOverallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOverallActionPerformed
        this.setVisible(false);
        AwardsOverall form = new AwardsOverall();

        form.setCommitteeID(committeeID);
        form.setChairID(chairID);
        form.ranking(); 
        form.setVisible(true);
    }//GEN-LAST:event_jButtonOverallActionPerformed

    private void jButton_VotingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VotingActionPerformed
        this.setVisible(false);
        votingPage1 form = new votingPage1();

        form.setCommitteeID(committeeID);
        form.setChairID(chairID);
        form.setCombobox();
        form.setVisible(true);
    }//GEN-LAST:event_jButton_VotingActionPerformed

    private void jButton_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logOutActionPerformed
       this.setVisible(false);
        
        homePage form = new homePage();
        form.setVisible(true);
    }//GEN-LAST:event_jButton_logOutActionPerformed

    private void jButton_selectCommitteeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_selectCommitteeActionPerformed
        this.setVisible(false);
        this.setCommitteeID(chooseCommittee());
        this.ranking();
        this.setVisible(true);
    }//GEN-LAST:event_jButton_selectCommitteeActionPerformed

     public int chooseCommittee()
    {
        String[] choices = { "Disarmrment", "Ecosoc","Envrionment" , "Security Council" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose which Committee", "Committee Awards you would like to review:", JOptionPane.QUESTION_MESSAGE, null,                                                        choices, // Array of choices
            choices[0]); // Initial choice
        
        if (input == choices[0])
        {
            return 1;
        }else if (input == choices[1]){
            return 2;
        }else if (input == choices[2]){
            return 3;
        }else{
            return 4;
        }
    }
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
            java.util.logging.Logger.getLogger(AwardsOverall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AwardsOverall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AwardsOverall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AwardsOverall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 //new AwardsCommittee().setVisible(true);
           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOverall;
    private javax.swing.JButton jButton_Voting;
    private javax.swing.JButton jButton_logOut;
    private javax.swing.JButton jButton_selectCommittee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListRanking;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBest;
    private javax.swing.JTextField jTextFieldBestJunior;
    private javax.swing.JTextField jTextFieldCommend;
    private javax.swing.JTextField jTextFieldHighlyCommend;
    // End of variables declaration//GEN-END:variables
}
