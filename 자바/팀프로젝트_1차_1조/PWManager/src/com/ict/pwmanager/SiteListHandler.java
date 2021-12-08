package com.ict.pwmanager;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import javax.swing.JOptionPane;

public class SiteListHandler implements ActionListener {
	private SiteListPanel siteLP; //View
	private SiteAddPanel siteAP;
	SiteDAO siteDao; //Model
	SiteVO siteVO;
	List<SiteVO> arr;
	
	public SiteListHandler(SiteListPanel siteLP) {
		this.siteLP = siteLP;
		this.siteDao = new SiteDAO();
		showList();
	}
	
	public void addSiteContent() {
		siteLP.AddDataButton.addActionListener(this);
	}
	
	public void showList() {
		arr = siteDao.siteList(); 
		
		Iterator<SiteVO> it = arr.iterator();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object obj = e.getSource();
		
		if(obj==siteLP.AddDataButton) {
			siteLP.main.card.show(siteLP.main.p, "AddEdit");
		}
		if(obj==siteLP.BackButton) {
			int yn = JOptionPane.showConfirmDialog(siteLP, 
					"로그아웃하시겠습니까?", "나가기 전에...", 
					JOptionPane.YES_NO_OPTION);
			if(yn==JOptionPane.YES_OPTION) {
				siteLP.main.card.show(siteLP.main.p, "login");
			}
		}
		if(obj==siteLP.SelectCategory) {
			siteLP.insertEachPanel();
		}
	}
}
