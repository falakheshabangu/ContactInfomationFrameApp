
package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ContactInformationFrame extends JFrame{
    
   private JPanel headingPnl;
   private JPanel contactInfoPnl;
   private JPanel residenceInfoPnl;
   private JPanel disabilityInfoPnl;
   private JPanel btnPnl;
   private JPanel mainPnl;
   
   private JLabel contactInfoLb;
   private JLabel cellPhoneNumberLb;
   private JLabel workTelNumberLb;
   private JLabel homeTelNumberLb;
   private JLabel emailLb;
   private JLabel verifyEmailLb;
   private JLabel residenceInfoLb;
   private JLabel applyResidencyLb;
   private JLabel disabilityInfoLb;
   
   private JComboBox<String> cellphoneNumberComboBox;
   private JComboBox<String> residencyComboBox;
   private JCheckBox disabilityCheckBox;
   
   private JTextField workTelNumberTxtFild;
   private JTextField homeTelNumberTxtFild;
   private JTextField emailTxtFild;
   private JTextField verifyEmailTxtFild;
   
   private JButton backBtn;
   private JButton nextBtn;

    public ContactInformationFrame() {
        
        setTitle("Information Request Form");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        contactInfoPnl = new JPanel(new GridLayout(6,2,5,5));
        contactInfoPnl.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "Contact Information",
        TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD,
                14), Color.BLUE));
        
        residenceInfoPnl = new JPanel(new GridLayout());
        residenceInfoPnl.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "Residence Information",
        TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.SANS_SERIF, Font.BOLD,14)
        , Color.BLUE));
        
        disabilityInfoPnl = new JPanel(new GridLayout());
        disabilityInfoPnl.setBorder(new TitledBorder(new LineBorder(Color.gray), "Disability Infomation",
        TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.MONOSPACED, Font.BOLD, 14),
                Color.BLUE));
        
        btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contactInfoLb = new JLabel("Please enter your contcat information");
        cellPhoneNumberLb = new JLabel("Do you have a SOuth African cell phone number? ");
        workTelNumberLb = new JLabel("Work Telepjone Number: ");
        homeTelNumberLb = new JLabel("Home Telephone Number: ");
        emailLb = new JLabel("Email: ");
        verifyEmailLb = new JLabel("Verify email: ");
        
        cellphoneNumberComboBox = new JComboBox<>(new String[]{"---Plrease Select---", "Yes", "No"});
        workTelNumberTxtFild = new JTextField();
        homeTelNumberTxtFild = new JTextField();
        emailTxtFild = new JTextField(20);
        verifyEmailTxtFild = new JTextField();
        
        residenceInfoLb = new JLabel("Please select whether you want to apply for residency");
        applyResidencyLb = new JLabel("Do you want to apply for residency?");
        residencyComboBox = new JComboBox<>(new String[]{"---Please Select---", "Yes", "No"});
        
        disabilityInfoLb = new JLabel("Please indicate whether you have any disabilities");
        disabilityCheckBox = new JCheckBox("Do you have any disability or impairment");
        
        backBtn = new JButton("Back");
        nextBtn = new JButton("Next");
        
        contactInfoPnl.add(contactInfoLb);
        contactInfoPnl.add(new JLabel(""));
        contactInfoPnl.add(cellPhoneNumberLb);
        contactInfoPnl.add(cellphoneNumberComboBox);
        contactInfoPnl.add(workTelNumberLb);
        contactInfoPnl.add(workTelNumberTxtFild);
        contactInfoPnl.add(homeTelNumberLb);
        contactInfoPnl.add(homeTelNumberTxtFild);
        contactInfoPnl.add(emailLb);
        contactInfoPnl.add(emailTxtFild);
        contactInfoPnl.add(verifyEmailLb);
        contactInfoPnl.add(verifyEmailTxtFild);
        
        residenceInfoPnl.add(residenceInfoLb);
        residenceInfoPnl.add(new JLabel(""));
        residenceInfoPnl.add(applyResidencyLb);
        residenceInfoPnl.add(residencyComboBox);
        
        disabilityInfoPnl.add(disabilityInfoLb);
        disabilityInfoPnl.add(disabilityCheckBox);
        
        btnPnl.add(backBtn);
        btnPnl.add(nextBtn);
        
        mainPnl = new JPanel(new FlowLayout());
        mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));
        mainPnl.add(contactInfoPnl);
        mainPnl.add(residenceInfoPnl);
        mainPnl.add(disabilityInfoPnl);
        mainPnl.add(btnPnl);
        
        addRequiredField(contactInfoPnl, cellPhoneNumberLb, cellphoneNumberComboBox);
        addRequiredField(contactInfoPnl, emailLb, emailTxtFild);
        addRequiredField(contactInfoPnl, verifyEmailLb, verifyEmailTxtFild);
        
        addRequiredField(residenceInfoPnl, applyResidencyLb, residencyComboBox);
        
        add(mainPnl, BorderLayout.CENTER);
        
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               validateForm();
            }
        });
        
        setVisible(true);
    }
   
    private void validateForm(){
        String selectedCellphoneOption = (String) cellphoneNumberComboBox.getSelectedItem();
        String selectedResidencyOption = (String) residencyComboBox.getSelectedItem();
        String emial = emailTxtFild.getText();
        String verifyEmail = verifyEmailTxtFild.getText();
        
        if("---Please Select---".equals(selectedCellphoneOption)){
            JOptionPane.showMessageDialog(this, "Please select an option for cellphone number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if("---Please Select---".equals(selectedResidencyOption)){
            JOptionPane.showMessageDialog(this, "Please select an option for residency", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!emailLb.equals(verifyEmail)){
            JOptionPane.showMessageDialog(this, "Email and verify email do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Form submited successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addRequiredField(JPanel panel, JLabel label, JComponent field) {
        JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subPanel.add(label);
        subPanel.add(field);
        JLabel asterikLebel = new JLabel("*");
        asterikLebel.setForeground(Color.red);
        subPanel.add(asterikLebel);
        panel.add(subPanel);
    }
    
}
