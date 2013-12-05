/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Session;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.DataBaseManager;
import model.DataBaseManager.NutritionFacts;

/**
 *
 * @author ArcadeHitman
 */
public class usermain extends javax.swing.JFrame {
    private Session usession;
    private DataBaseManager db;
    private List< String > meals;
    private Date viewDate;
    private int currentMeal = 0;

    /**
     * Creates new form usermain
     */
    public usermain( String fn, String ln) {
        initComponents();
        displayName.setText("Hello " + fn + " " + ln +".");
        this.usession = Session.getSession();
        this.db = DataBaseManager.getDataBase();
        this.updateDate( new Date() );
        this.btnDietitionPanel.setVisible( this.usession.canPrescribe );
        
    }
    
    /**
     * Updates the date field and finds associated meals.
     * 
     * @param nDate The date to show.
     */
    private void updateDate( Date nDate ) {
      this.viewDate = nDate;
      this.lblDate.setText( this.viewDate.toString() );
      this.meals =
          this.db.getMealsForDate(this.usession.getUserName(), this.viewDate );
      System.out.println( this.meals.size() );
      System.out.println( this.meals );
      this.updateMeal( 0 );
    }
    
    /**
     * Updates the meal name field and lists out characteristics such as courses.
     * 
     * @param meal The meal index.
     */
    private void updateMeal( int meal ) {
      int mealCount = this.meals.size();
      if ( mealCount > 0 ) {
        this.currentMeal = ( mealCount + meal ) % mealCount;
        String mealName = this.meals.get( this.currentMeal );
        this.lblMealName.setText( mealName );
        this.lblCourseList.setText(
                this.db.getCoursesForMeal( mealName ).toString() );
        this.lblIngredientList.setText(
                this.db.getIngredientsForMeal( mealName ).toString() );
        NutritionFacts nf = this.db.getNutritionForMeal( mealName );
        String strNF =
                String.format( "Fat: %d, Calories: %d", nf.fat, nf.calories);
        this.lblNutrition.setText( strNF );
      }
      else {
        this.lblMealName.setText( "" );
      }
    }
    
    public usermain(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayName = new javax.swing.JLabel();
        btnViewDietaryRecommendation = new javax.swing.JButton();
        btnPreferences = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        btnDietitionPanel = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDateBack = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        btnDateForward = new javax.swing.JButton();
        btnMealForward = new javax.swing.JButton();
        lblMealName = new javax.swing.JLabel();
        btnMealBack = new javax.swing.JButton();
        lblNutrition = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblIngredientList = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCourseList = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(460, 460));

        displayName.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        displayName.setText("*First and last name here*");

        btnViewDietaryRecommendation.setText("View Dietary Restrictions");
        btnViewDietaryRecommendation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDietaryRecommendationActionPerformed(evt);
            }
        });

        btnPreferences.setText("View/Edit Preferences");
        btnPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreferencesActionPerformed(evt);
            }
        });

        btnDietitionPanel.setText("View Dietition Panel");
        btnDietitionPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDietitionPanelActionPerformed(evt);
            }
        });

        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(128, 128, 128));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Meal Plan");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jPanel1.setSize(new java.awt.Dimension(460, 100));

        btnDateBack.setText("<");
        btnDateBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateBackActionPerformed(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("*Date*");
        lblDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnDateForward.setText(">");
        btnDateForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateForwardActionPerformed(evt);
            }
        });

        btnMealForward.setText(">");
        btnMealForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMealForwardActionPerformed(evt);
            }
        });

        lblMealName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblMealName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMealName.setText("*Meal Name*");
        lblMealName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnMealBack.setText("<");
        btnMealBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMealBackActionPerformed(evt);
            }
        });

        lblNutrition.setText("*fat, caloris, sodium, etc.*");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Nutritional Facts:");

        lblIngredientList.setText("*List*");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Ingredients:");

        lblCourseList.setText("*List*");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Courses:");

        jButton1.setText("Prep Instructions");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDateBack)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMealBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMealName, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMealForward, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDateForward)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCourseList)
                                    .addComponent(lblIngredientList)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblNutrition)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel9))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDateForward, btnMealForward});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDateBack)
                    .addComponent(lblDate)
                    .addComponent(btnMealForward))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMealName)
                    .addComponent(btnMealBack)
                    .addComponent(btnDateForward))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCourseList)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIngredientList)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNutrition))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDietitionPanel)
                    .addComponent(btnPreferences))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewDietaryRecommendation, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSignOut, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(displayName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDietitionPanel, btnPreferences, btnSignOut, btnViewDietaryRecommendation});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDietaryRecommendation)
                    .addComponent(btnDietitionPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignOut)
                    .addComponent(btnPreferences))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDietaryRecommendationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDietaryRecommendationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewDietaryRecommendationActionPerformed

    private void btnPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreferencesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreferencesActionPerformed

  private void btnMealBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMealBackActionPerformed
    this.updateMeal( this.currentMeal - 1 );
  }//GEN-LAST:event_btnMealBackActionPerformed

  private void btnMealForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMealForwardActionPerformed
    this.updateMeal( this.currentMeal + 1 );
  }//GEN-LAST:event_btnMealForwardActionPerformed

  private void btnDateBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateBackActionPerformed
    Calendar cal = Calendar.getInstance();
    cal.setTime( this.viewDate );
    cal.add( cal.DATE, -1 );
    this.updateDate( cal.getTime() );
  }//GEN-LAST:event_btnDateBackActionPerformed

  private void btnDateForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateForwardActionPerformed
    Calendar cal = Calendar.getInstance();
    cal.setTime( this.viewDate );
    cal.add( cal.DATE, 1 );
    this.updateDate( cal.getTime() );
  }//GEN-LAST:event_btnDateForwardActionPerformed

    private void btnDietitionPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDietitionPanelActionPerformed
        if ( WorkFlows.viewDietitionPanel() ) {
            this.dispose();
        }
    }//GEN-LAST:event_btnDietitionPanelActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        WorkFlows.signOut();
        this.dispose();
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(usermain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usermain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usermain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usermain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usermain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDateBack;
    private javax.swing.JButton btnDateForward;
    private javax.swing.JButton btnDietitionPanel;
    private javax.swing.JButton btnMealBack;
    private javax.swing.JButton btnMealForward;
    private javax.swing.JButton btnPreferences;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnViewDietaryRecommendation;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel displayName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCourseList;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblIngredientList;
    private javax.swing.JLabel lblMealName;
    private javax.swing.JLabel lblNutrition;
    // End of variables declaration//GEN-END:variables
}
