package com.ict.pwmanager;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SiteViewPanel extends JPanel {
	
	private static final long serialVersionUID = -5448050715388091104L;
	SiteViewHandler siteVH;
	SiteVO listVO;
	PWManager main;
	
    public SiteViewPanel(PWManager main) {
    	this.main = main;
    	//핸들러 연결
    	siteVH=new SiteViewHandler(this, main);
    	siteVH.setsiteVOData();
    	//listVO=siteVH.listVO;
    	listVO = new SiteVO();
    	SingletonData singletonData = SingletonData.getSingletonSiteData();
    	listVO=singletonData.siteVO;    	
        initComponents();
        //System.out.println(listVO.getSitekey()+"<<<<");
        this.editBtn.setActionCommand(listVO.getSitekey()+"");
        
        //리스너 부착
        backBtn.addActionListener(siteVH);
        editBtn.addActionListener(siteVH);
        pwBtn.addActionListener(siteVH);
        pwTf.addKeyListener(siteVH);
    }

    @SuppressWarnings("unchecked")
    void initComponents() {
    	
    	//객체 생성
    	headerP = new JPanel();
    	backBtn = new JButton();
    	pageTitle = new JLabel();
        sNameLabel = new JLabel();
        sURLLable = new JLabel();
        sPWLable = new JLabel();
        editBtn = new JButton();
        pwTf = new JPasswordField();
        pwBtn = new JButton();
        jScrollPane = new JScrollPane();
        sPWTa = new JTextArea();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        Dimension d = new Dimension(432, 768);
        setPreferredSize(new Dimension(d));
        
        //헤더부분 패널 세팅값-------------------------------------------------------------------------------------------------------
        headerP.setBackground(new Color(35, 55, 77));
        headerP.setPreferredSize(new Dimension(232, 60));
        headerP.setRequestFocusEnabled(false);
        
        //뒤로가기 버튼 세팅값-------------------------------------------------------------------------------------------------------------
        backBtn.setIcon(new ImageIcon(getClass().getResource("/images/BackButton.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setMargin(new Insets(0, 0, 0, 0));
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.setFocusPainted(false);
        
        //해당페이지 표시 라벨 세팅값----------------------------------------------------------------------------------------------------
        pageTitle.setFont(new java.awt.Font("맑은 고딕", 1, 15)); // NOI18N
        pageTitle.setForeground(new java.awt.Color(238, 238, 238));
        pageTitle.setText("사이트 정보 조회");
        pageTitle.setVerticalTextPosition(SwingConstants.TOP);
        
        //사이트명 라벨 세팅값----------------------------------------------------------------------------------------------------------
        sNameLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        sNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        sNameLabel.setText("사이트명: "+listVO.getSiteName());
        
        sNameLabel.setVerticalTextPosition(SwingConstants.TOP);
        
        //URL 라벨 세팅값-----------------------------------------------------------------------------------------------------------
        sURLLable.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        sURLLable.setHorizontalAlignment(SwingConstants.LEFT);
        sURLLable.setText("URL: "+listVO.getURL());
        sURLLable.setVerticalTextPosition(SwingConstants.TOP);
        
        //암호화 된 비밀번호 라벨 세팅값--------------------------------------------------------------------------------------------------
        sPWLable.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        sPWLable.setHorizontalAlignment(SwingConstants.LEFT);
        sPWLable.setText("암호화 된 비밀번호: "+listVO.getSitePW());
        sPWLable.setVerticalTextPosition(SwingConstants.TOP);

        //수정 버튼 세팅값-----------------------------------------------------------------------------------------------------------
        editBtn.setBackground(new java.awt.Color(128, 177, 229));
        editBtn.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        editBtn.setText("수정");
        editBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editBtn.setBorderPainted(false);
        editBtn.setFocusPainted(false);
        editBtn.setEnabled(false);
        
        //비밀번호 입력란 세팅값--------------------------------------------------------------------------------------------------------
        pwTf.setHorizontalAlignment(JTextField.LEFT);
        pwTf.setBackground(new Color(245, 245, 245));
        pwTf.setText("");
        pwTf.setFont(new java.awt.Font("맑은 고딕", 0, 20));
        pwTf.setAutoscrolls(false);
        
        //비밀번호 입력버튼 세팅값------------------------------------------------------------------------------------------------------
        pwBtn.setBackground(new java.awt.Color(128, 177, 229));
        pwBtn.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        pwBtn.setText("나의 비밀번호 확인");
        pwBtn.setBorderPainted(false);
        pwBtn.setFocusPainted(false);
        
        //비밀번호 표시란 세팅값-------------------------------------------------------------------------------------------------------
        sPWTa.setBackground(new java.awt.Color(238, 238, 238));
        sPWTa.setColumns(20);
        sPWTa.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        sPWTa.setRows(5);
        sPWTa.setText("");
        
        jScrollPane.setViewportView(sPWTa);
        

        GroupLayout headerPLayout = new GroupLayout(headerP);
        headerP.setLayout(headerPLayout);
        headerPLayout.setHorizontalGroup(
            headerPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pageTitle)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPLayout.setVerticalGroup(
            headerPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(pageTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(14,14,14))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(pwBtn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sPWLable, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(sURLLable, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(sNameLabel, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(editBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(pwTf, GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(headerP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {sNameLabel, sPWLable, sURLLable});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(sNameLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sURLLable)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sPWLable)
                        .addGap(40,40,40))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(47,47,47)))
                .addComponent(pwTf, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwBtn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>                                                          

    private JPanel headerP;
    private JLabel pageTitle;
    JButton backBtn;
    JButton editBtn;
    JButton pwBtn;
    JLabel sNameLabel;
    JLabel sPWLable;
    JLabel sURLLable;
    JPasswordField pwTf;
    JTextArea sPWTa;
    JScrollPane jScrollPane;
    
}

