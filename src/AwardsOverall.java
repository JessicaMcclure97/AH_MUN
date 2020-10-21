
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
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
public class AwardsOverall extends javax.swing.JFrame {

    //global variables
    Connection connection;
    ResultSet rs;
    PreparedStatement ps;
  
    
    int count;
    int committeeID;
    int chairID;
    //array of object 
    Delegation[] delegations;
    
    public AwardsOverall() {
        
        initComponents();
        
        //connect to database
        connectToDatabase Test = new connectToDatabase();
        Test.connectToDatabase();
        //update connection variable
        connection = Test.getConnectionVariable(connection); 
    }
    
    public void ranking() //this is what displays in the listbox needs to be seperate from main class section so committeeID can be set
    {
        setDelegateArray(); //private since shouldn't be accessed by general 
     
        Sorting sortObjects = new Sorting();
        sortObjects.bubbleSortDelegations(delegations, count);
        displayResults();
        
        awards();
    }
    
    public void setCommitteeID(int committee)
    {
        this.committeeID = committee;
        
        if (committeeID == 0)
        {
            jButton_Voting.setVisible(false);
        }else{
            jButton_Voting.setVisible(true);
        }    
    }
    
     public void setChairID(int chairID){
         this.chairID = chairID;
    }
    
    private void setDelegateArray()
    {
        //get number of countries as well 
        NumberCountries numCount = new NumberCountries();
        count = numCount.NumberCountries(1);
        
        //local variables
        String countryName;
        int countryID;
        int totalScore;
        //initialise delegate object size.
        delegations = new Delegation[count]; 
         
        // create array placeholder variable
        int i = 0;
        
        try{
                //alias used since a union needed to be made 
                String valuesNeeded = "SELECT c.countryName, d.`countryID`, SUM(d.`totalScore`) AS countryTotalScore FROM `delegate` AS d, `country` AS c WHERE d.`countryID` = c.`countryID` GROUP BY `countryID` "; //creating alis of table name 
                ps = connection.prepareStatement(valuesNeeded);
                rs = ps.executeQuery();
           
           while (rs.next()) { //conditional loop
                countryID = rs.getInt("countryID");
                countryName = rs.getString("countryName");
                totalScore = rs.getInt("countryTotalScore");
                
                delegations[i] = new Delegation() ;
                delegations[i].setCountryName(countryName);
                delegations[i].setTotalScore(totalScore);
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
           listModel.addElement(""+ (i + 1) +". " + delegations[i].displayMessage());
            
        }
        //actually displaying the results into the ranking listbox
        jListRanking.setModel(listModel);
    }
    
    public void awards()
    {
        
        jTextFieldBest.setText(delegations[0].getcountryName()); //best delegate award
        jTextFieldHighlyCommend.setText(delegations[1].getcountryName()); //highly commmended
        jTextFieldCommend.setText(delegations[2].getcountryName()); //commended

        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonCommittee = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCommend = new javax.swing.JTextField();
        jTextFieldHighlyCommend = new javax.swing.JTextField();
        jTextFieldBest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRanking = new javax.swing.JList<>();
        jButton_Voting = new javax.swing.JButton();
        jButton_logOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCommittee.setText("Committee");
        jButtonCommittee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCommitteeActionPerformed(evt);
            }
        });

        jLabel1.setText("Overall Results");

        jLabel3.setText("Best Delegate:");

        jLabel4.setText("Commended:");

        jLabel5.setText("Highly Commended:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCommittee)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCommend)
                                    .addComponent(jTextFieldBest, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(jTextFieldHighlyCommend)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_Voting)
                                .addGap(34, 34, 34)
                                .addComponent(jButton_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCommittee)
                            .addComponent(jButton_Voting)
                            .addComponent(jButton_logOut))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCommend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHighlyCommend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

    private void jButtonCommitteeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCommitteeActionPerformed
        this.setVisible(false);
        AwardsCommittee form = new AwardsCommittee();
   
        //a choice for the delegates to choose which ocmmittee they want to view the committee will already be preset for chair logins and therefore they won't be able to access the other committees results
        if(committeeID == 0)
        {
            chairID = 0;
            committeeID = chooseCommittee();
        }
        
        form.setCommitteeID(committeeID);
        form.setChairID(chairID);
        form.ranking(); 
        form.setVisible(true);
    }//GEN-LAST:event_jButtonCommitteeActionPerformed

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
                new AwardsOverall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCommittee;
    private javax.swing.JButton jButton_Voting;
    private javax.swing.JButton jButton_logOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListRanking;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBest;
    private javax.swing.JTextField jTextFieldCommend;
    private javax.swing.JTextField jTextFieldHighlyCommend;
    // End of variables declaration//GEN-END:variables
}
