/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatlinks;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 *
 * @author James M. Curran <j.curran@auckland.ac.nz>
 */
public class FormatLinksGUI extends javax.swing.JFrame {

  public class PopupListener extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
      maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
      maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
      if (e.isPopupTrigger()) {
        jPopupMenuEdit.show(e.getComponent(),
          e.getX(), e.getY());
      }
    }
  }

  /**
   * Creates new form FormatLinksGUI
   */
  public FormatLinksGUI() {
    initComponents();

    jPopupMenuEdit = new javax.swing.JPopupMenu();
    jPMIClear = new javax.swing.JMenuItem("Clear");
    jPMICopy = new javax.swing.JMenuItem("Copy");
    jPMIPaste = new javax.swing.JMenuItem("Paste");

    jPMIClear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        jPMIClearActionPerformed(evt);
      }
    });

    jPMIClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.META_MASK));

    jPMICopy.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        jPMICopyActionPerformed(evt);
      }
    });

    jPMICopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));

    jPMIPaste.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        jPMIPasteActionPerformed(evt);
      }
    });

    jPMIPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.META_MASK));

    jPopupMenuEdit.add(jPMIClear);
    jPopupMenuEdit.add(jPMICopy);
    jPopupMenuEdit.add(jPMIPaste);

    MouseListener popupListener = new PopupListener();
    jTPInput.addMouseListener(popupListener);
    jTPOutput.addMouseListener(popupListener);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jButtonFormat = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTPInput = new javax.swing.JTextPane();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTPOutput = new javax.swing.JTextPane();
    jcbMonth = new javax.swing.JComboBox<>();
    jLabelMonth = new javax.swing.JLabel();
    jLabelDay = new javax.swing.JLabel();
    jspinDay = new javax.swing.JSpinner();
    jLabel3 = new javax.swing.JLabel();
    jcbLecture = new javax.swing.JComboBox<>();
    jCheckBoxDateFromEmail = new javax.swing.JCheckBox();
    jMenuBar = new javax.swing.JMenuBar();
    jMenuQuit = new javax.swing.JMenu();
    jMenuItemQuit = new javax.swing.JMenuItem();
    jMenuEdit = new javax.swing.JMenu();
    jMenuItemCopy = new javax.swing.JMenuItem();
    jMenuItemPaste = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jButtonFormat.setText("Format");
    jButtonFormat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonFormatActionPerformed(evt);
      }
    });

    jTPInput.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTPInputMouseClicked(evt);
      }
    });
    jTPInput.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        jTPInputKeyTyped(evt);
      }
    });
    jScrollPane2.setViewportView(jTPInput);

    jScrollPane3.setViewportView(jTPOutput);

    jcbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
    jcbMonth.setSelectedIndex(2);
    jcbMonth.setEnabled(false);

    jLabelMonth.setText("Month:");
    jLabelMonth.setEnabled(false);

    jLabelDay.setText("Day:");
    jLabelDay.setEnabled(false);

    jspinDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
    jspinDay.setEnabled(false);

    jLabel3.setText("Lecture:");

    jcbLecture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36" }));
    jcbLecture.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbLectureActionPerformed(evt);
      }
    });

    jCheckBoxDateFromEmail.setSelected(true);
    jCheckBoxDateFromEmail.setText("Date from e-mail");
    jCheckBoxDateFromEmail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBoxDateFromEmailActionPerformed(evt);
      }
    });

    jMenuQuit.setText("Quit");

    jMenuItemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
    jMenuItemQuit.setText("Quit");
    jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemQuitActionPerformed(evt);
      }
    });
    jMenuQuit.add(jMenuItemQuit);

    jMenuBar.add(jMenuQuit);

    jMenuEdit.setText("Edit");

    jMenuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));
    jMenuItemCopy.setText("Copy");
    jMenuItemCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemCopyActionPerformed(evt);
      }
    });
    jMenuEdit.add(jMenuItemCopy);

    jMenuItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.META_MASK));
    jMenuItemPaste.setText("Paste");
    jMenuItemPaste.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemPasteActionPerformed(evt);
      }
    });
    jMenuEdit.add(jMenuItemPaste);

    jMenuBar.add(jMenuEdit);

    setJMenuBar(jMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jCheckBoxDateFromEmail)
              .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jcbLecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelDay)
              .addComponent(jLabelMonth))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jspinDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcbMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonFormat)
            .addGap(412, 412, 412))))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap(476, Short.MAX_VALUE)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(16, 16, 16)))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButtonFormat)
          .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabelMonth)
          .addComponent(jCheckBoxDateFromEmail))
        .addGap(11, 11, 11)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelDay)
          .addComponent(jspinDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3)
          .addComponent(jcbLecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(16, 16, 16)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap(82, Short.MAX_VALUE)))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButtonFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormatActionPerformed
    String strSource = jTPInput.getText();
    String[] Lines = strSource.split("\n");
    String strMonth = (String)jcbMonth.getSelectedItem();
    
    int[] dim = {31,28,31,30,31,30,31,31,30,31,30,31};
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    
    boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

    if(isLeapYear)
      dim[1] = 29;
    
    Integer nDay = (Integer)jspinDay.getValue();
    if(nDay > dim[month - 1])
      nDay = dim[month - 1];
    
    String strDay = nDay.toString();
    StringBuilder sbOutput = new StringBuilder();
    
    sbOutput.append("<tr style=\"text-align: left;\">\n");
    sbOutput.append("<td valign = \"top\">" + jcbLecture.getSelectedItem() + "</td>\n");
    sbOutput.append("<td valign = \"top\">" + strMonth + " "  + strDay + "</td>\n");
    
    Pattern pat = Pattern.compile("https");

    for (String line : Lines) {
      Matcher m = pat.matcher(line);

      if (m.find()) {
        Pattern regDownload = Pattern.compile("^- +(HD|SD|Low Quality|Audio) *Download: *(https:.*$)");
        Matcher m2 = regDownload.matcher(line);

        if (m2.find()) {
          sbOutput.append("<li><a href = \"");
          sbOutput.append(m2.group(2));
          sbOutput.append("\">");
          sbOutput.append(m2.group(1));
          sbOutput.append(" Download Link</a></li>\n");
        } else {
          sbOutput.append("<td valign = \"top\" style=\"text-align: left;\">\n<ol>\n<li><a href=\"").append(line).append("\">Streaming Link</a></li>\n");
        }
      }
    }

    sbOutput.append("</ol>\n</td>\n</tr>\n");

    jTPOutput.setText(sbOutput.toString());

    strSource = "";
  }//GEN-LAST:event_jButtonFormatActionPerformed

  private void jTPInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPInputKeyTyped

  }//GEN-LAST:event_jTPInputKeyTyped

  private void PasteAction(){
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable contents = clipboard.getContents(null);
    boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);

    if (hasTransferableText) {
      try {
        String strContents = (String) contents.getTransferData(DataFlavor.stringFlavor);
        jTPInput.setText(strContents);
        
        Pattern patDate = Pattern.compile("(20[0-9]{2})-(0[1-9]|1[0-2])-((0|1|2)[1-9]|3[0-1])");
        Matcher m = patDate.matcher(strContents);
        
        bDateFromEmail = m.find();
        
        if(bDateFromEmail){
          strYear = m.group(1);
          strMonth = m.group(2);
          strDay = m.group(3);
          
          jcbMonth.setSelectedIndex(Integer.parseInt(strMonth) - 1);
          jspinDay.setValue(Integer.parseInt(strDay));
        }
        
        jLabelMonth.setEnabled(!bDateFromEmail);
        jLabelDay.setEnabled(!bDateFromEmail);
        jcbMonth.setEnabled(!bDateFromEmail);
        jspinDay.setEnabled(!bDateFromEmail);
        
      } catch (UnsupportedFlavorException | IOException ex) {
        System.out.println(ex);
        ex.printStackTrace();
      }
    }
  }

  private void jMenuItemPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPasteActionPerformed
    PasteAction();
  }//GEN-LAST:event_jMenuItemPasteActionPerformed

  private void jMenuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopyActionPerformed
    String strFormatted = jTPOutput.getText();
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(new StringSelection(strFormatted), null);
  }//GEN-LAST:event_jMenuItemCopyActionPerformed

  private void jPMIClearActionPerformed(ActionEvent evt) {
    jTPInput.setText("");
  }

  private void jPMICopyActionPerformed(ActionEvent evt) {
    String strFormatted = jTPOutput.getText();
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(new StringSelection(strFormatted), null);
  }

  private void jPMIPasteActionPerformed(java.awt.event.ActionEvent evt) {
    PasteAction();
  }


  private void jcbLectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLectureActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jcbLectureActionPerformed

  private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemQuitActionPerformed
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.dispose();
    System.exit(0);
  }//GEN-LAST:event_jMenuItemQuitActionPerformed

  private void jTPInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPInputMouseClicked
    if (isRightMouseButton(evt)) {
      jPMICopy.setEnabled(false);
    }
  }//GEN-LAST:event_jTPInputMouseClicked

  private void jCheckBoxDateFromEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDateFromEmailActionPerformed
    bDateFromEmail = jCheckBoxDateFromEmail.isSelected();
    
    jLabelMonth.setEnabled(!bDateFromEmail);
    jLabelDay.setEnabled(!bDateFromEmail);
    jcbMonth.setEnabled(!bDateFromEmail);
    jspinDay.setEnabled(!bDateFromEmail);  
  }//GEN-LAST:event_jCheckBoxDateFromEmailActionPerformed

  /**
   * @param args the command line arguments P
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
      java.util.logging.Logger.getLogger(FormatLinksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FormatLinksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FormatLinksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FormatLinksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FormatLinksGUI().setVisible(true);
      }
    });
  }
  
  private boolean bDateFromEmail;
  private String strYear, strMonth, strDay;

  private javax.swing.JPopupMenu jPopupMenuEdit;
  private javax.swing.JMenuItem jPMIClear;
  private javax.swing.JMenuItem jPMICopy;
  private javax.swing.JMenuItem jPMIPaste;


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonFormat;
  private javax.swing.JCheckBox jCheckBoxDateFromEmail;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabelDay;
  private javax.swing.JLabel jLabelMonth;
  private javax.swing.JMenuBar jMenuBar;
  private javax.swing.JMenu jMenuEdit;
  private javax.swing.JMenuItem jMenuItemCopy;
  private javax.swing.JMenuItem jMenuItemPaste;
  private javax.swing.JMenuItem jMenuItemQuit;
  private javax.swing.JMenu jMenuQuit;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextPane jTPInput;
  private javax.swing.JTextPane jTPOutput;
  private javax.swing.JComboBox<String> jcbLecture;
  private javax.swing.JComboBox<String> jcbMonth;
  private javax.swing.JSpinner jspinDay;
  // End of variables declaration//GEN-END:variables
}
