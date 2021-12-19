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
        
        //핸들러 연결
        siteEH = new SiteEditHandler(this, siteVP);
        //리스너 부착
        BackButton.addActionListener(siteEH);
        resetBtn.addActionListener(siteEH);
        saveBtn.addActionListener(siteEH);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	//객체 생성
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
        
        //헤더부분 패널 세팅값
        headerP.setBackground(new Color(35, 55, 77));
        headerP.setPreferredSize(new Dimension(400, 60));
        
        //뒤로가기 버튼 세팅값
        BackButton.setIcon(new ImageIcon(getClass().getResource("/images/BackButton.png"))); // NOI18N
        BackButton.setBorderPainted(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setMargin(new Insets(0, 0, 0, 0));
        BackButton.setPreferredSize(new Dimension(40, 40));
        BackButton.setFocusPainted(false);

        //해당페이지 표시 라벨 세팅값
        TopBarText.setFont(new Font("맑은 고딕", 1, 15)); // NOI18N
        TopBarText.setForeground(new Color(238, 238, 238));
        TopBarText.setText("사이트 정보 수정");
        
        //가이드 라벨 세팅값
        guideAddLabel.setFont(new Font("맑은 고딕", 0, 12)); // NOI18N
        guideAddLabel.setText("이 곳에서 사이트를 수정 할 수 있습니다.");
        
        //사이트 관련 라벨 세팅값
        sNameLabel.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        sNameLabel.setText("사이트명 : ");
        
        sIDLabel.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        sIDLabel.setText("아이디 :  ");
        
        sPWLable.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        sPWLable.setText("비밀번호");
        
        
        sURLLable.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        sURLLable.setText("URL : ");
        
        securityLabel.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        securityLabel.setText("보안방식 : ");
        
        categoryLabel.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        categoryLabel.setText("카테고리 : ");
        //--------------------
        
        //초기화 버튼 세팅값
        resetBtn.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        resetBtn.setText("초기화");
        
        //저장 버튼 세팅값
        saveBtn.setFont(new Font("맑은 고딕", 0, 14)); // NOI18N
        saveBtn.setText("수정");
        
        //수정 정보 입력란 세팅값
        EditSiteName.setFont(new Font("맑은 고딕", 0, 12)); // NOI18N
        EditIDText.setFont(new Font("맑은 고딕", 0, 12)); // NOI18N
        EditPassword.setFont(new Font("맑은 고딕", 0, 12)); // NOI18N
        EditURL.setFont(new Font("맑은 고딕", 0, 12)); // NOI18N
        
        //보안강도 선택 세팅값
        EditSelectSecurity.setFont(new Font("맑은 고딕", 0, 11)); // NOI18N
        EditSelectSecurity.setModel(new DefaultComboBoxModel<>(new String[] { "기본", "AES", "랜덤(미구현)" }));
        
        EditSelectCategory.setFont(new java.awt.Font("맑은 고딕", 0, 11)); // NOI18N
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
