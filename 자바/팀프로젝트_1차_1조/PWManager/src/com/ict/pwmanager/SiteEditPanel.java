package com.ict.pwmanager;

import java.awt.*;
import javax.swing.*;

public class SiteEditPanel extends JPanel {
	SiteEditHandler siteEH;
	SiteViewPanel siteVP;
	SiteVO listVO;
	PWManager main;
	Algorithm myAlgo;
	
    public SiteEditPanel(PWManager main, SiteViewPanel siteVP) {
    	SingletonData singletonData = SingletonData.getSingletonSiteData();
    	myAlgo = new Algorithm();
    	this.main = main;
    	this.siteVP=siteVP;
    	listVO=singletonData.siteVO;   //this.siteVP.listVO;
    	
        initComponents();
        
        //�ڵ鷯 ����
        siteEH = new SiteEditHandler(this, siteVP);
        //������ ����
        BackButton.addActionListener(siteEH);
        resetBtn.addActionListener(siteEH);
        saveBtn.addActionListener(siteEH);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	//��ü ����
        headerP = new JPanel();
        BackButton = new JButton();
        TopBarText = new JLabel();
        sNameLabel = new JLabel();
        guideAddLabel = new JLabel();
        sIDLabel = new JLabel();
        sPWLable = new JLabel();
        sURLLable = new JLabel();
        securityLabel = new JLabel();
        categoryLabel = new JLabel();
        EditSiteName = new JTextField(listVO.getSiteName());
        EditIDText = new JTextField(listVO.getSiteID());
        EditPassword = new JTextField(myAlgo.DecryptAlgorithm(listVO, listVO.getGuardLevel()));
        EditURL = new JTextField(listVO.getURL());
        EditSelectSecurity = new JComboBox<>();
        EditSelectCategory = new javax.swing.JComboBox<>();
        resetBtn = new JButton();
        saveBtn = new JButton();

        setMaximumSize(new Dimension(432, 768));
        setPreferredSize(new Dimension(432, 768));
        
        //����κ� �г� ���ð�
        headerP.setBackground(new Color(35, 55, 77));
        headerP.setPreferredSize(new Dimension(400, 60));
        
        //�ڷΰ��� ��ư ���ð�
        BackButton.setIcon(new ImageIcon(getClass().getResource("/images/BackButton.png"))); // NOI18N
        BackButton.setBorderPainted(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setMargin(new Insets(0, 0, 0, 0));
        BackButton.setPreferredSize(new Dimension(40, 40));
        BackButton.setFocusPainted(false);

        //�ش������� ǥ�� �� ���ð�
        TopBarText.setFont(new Font("���� ���", 1, 15)); // NOI18N
        TopBarText.setForeground(new Color(238, 238, 238));
        TopBarText.setText("����Ʈ ���� ����");
        
        //���̵� �� ���ð�
        guideAddLabel.setFont(new Font("���� ���", 0, 12)); // NOI18N
        guideAddLabel.setText("�� ������ ����Ʈ�� ���� �� �� �ֽ��ϴ�.");
        
        //����Ʈ ���� �� ���ð�
        sNameLabel.setFont(new Font("���� ���", 0, 14)); // NOI18N
        sNameLabel.setText("����Ʈ�� : ");
        
        sIDLabel.setFont(new Font("���� ���", 0, 14)); // NOI18N
        sIDLabel.setText("���̵� :  ");
        
        sPWLable.setFont(new Font("���� ���", 0, 14)); // NOI18N
        sPWLable.setText("��й�ȣ");
        
        
        sURLLable.setFont(new Font("���� ���", 0, 14)); // NOI18N
        sURLLable.setText("URL : ");
        
        securityLabel.setFont(new Font("���� ���", 0, 14)); // NOI18N
        securityLabel.setText("���ȹ�� : ");
        
        categoryLabel.setFont(new Font("���� ���", 0, 14)); // NOI18N
        categoryLabel.setText("ī�װ� : ");
        //--------------------
        
        //�ʱ�ȭ ��ư ���ð�
        resetBtn.setFont(new Font("���� ���", 0, 14)); // NOI18N
        resetBtn.setText("�ʱ�ȭ");
        
        //���� ��ư ���ð�
        saveBtn.setFont(new Font("���� ���", 0, 14)); // NOI18N
        saveBtn.setText("����");
        
        //���� ���� �Է¶� ���ð�
        EditSiteName.setFont(new Font("���� ���", 0, 12)); // NOI18N
        EditIDText.setFont(new Font("���� ���", 0, 12)); // NOI18N
        EditPassword.setFont(new Font("���� ���", 0, 12)); // NOI18N
        EditURL.setFont(new Font("���� ���", 0, 12)); // NOI18N
        
        //���Ȱ��� ���� ���ð�
        EditSelectSecurity.setFont(new Font("���� ���", 0, 11)); // NOI18N
        EditSelectSecurity.setModel(new DefaultComboBoxModel<>(new String[] { "�⺻", "AES", "����(�̱���)" }));
        
        EditSelectCategory.setFont(new java.awt.Font("���� ���", 0, 11)); // NOI18N
        EditSelectCategory.setModel(new javax.swing.DefaultComboBoxModel<>(main.lginP.lginH.ListP.Categorylist));
        EditSelectCategory.setSelectedIndex(listVO.getCategory());
        
        
        GroupLayout TopBarLayout = new GroupLayout(headerP);
        headerP.setLayout(TopBarLayout);
        TopBarLayout.setHorizontalGroup(
            TopBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TopBarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BackButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(TopBarText)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TopBarLayout.setVerticalGroup(
            TopBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TopBarLayout.createSequentialGroup()
                .addGroup(TopBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(TopBarLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(BackButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(TopBarLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(TopBarText)))
                .addContainerGap(15, Short.MAX_VALUE))
        );



        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(headerP, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(sURLLable)
                                    .addComponent(sPWLable)
                                    .addComponent(sIDLabel)
                                    .addComponent(sNameLabel)
                                    .addComponent(securityLabel)
                                    .addComponent(categoryLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EditSelectSecurity, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EditSelectCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EditSiteName, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(EditIDText)
                                    .addComponent(EditPassword)
                                    .addComponent(EditURL)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(guideAddLabel)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guideAddLabel)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sNameLabel)
                    .addComponent(EditSiteName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sIDLabel)
                    .addComponent(EditIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sPWLable)
                    .addComponent(EditPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sURLLable)
                    .addComponent(EditURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(securityLabel)
                    .addComponent(EditSelectSecurity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(categoryLabel)
                    .addComponent(EditSelectCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 80, Short.MAX_VALUE))
        );
    }                       
    
    private JPanel headerP;
    JButton BackButton;
    JLabel TopBarText;
    JLabel guideAddLabel;
    private JLabel sNameLabel;
    private JLabel sIDLabel;
    private JLabel sPWLable;
    private JLabel sURLLable;
    private JLabel securityLabel;
    private JLabel categoryLabel;
    JTextField EditSiteName;
    JTextField EditIDText;
    JTextField EditPassword;
    JTextField EditURL;
    JComboBox<String> EditSelectSecurity;
    JComboBox<String> EditSelectCategory;
    JButton resetBtn;
    JButton saveBtn;
    
}
