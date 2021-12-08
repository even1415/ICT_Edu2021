package com.ict.pwmanager;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

public class EachDataHandler implements ActionListener {
	EachDataPanel edp;
	SiteVO siteVO;
	SiteDAO siteDao;
	private String urlString; //url 저장할 문자열
	private String clipString; //클립보드에 저장할 문자열
	PWManager main;
	SiteViewPanel siteVP;
	Algorithm myAlgo;
	
	public EachDataHandler(EachDataPanel edp, PWManager main) {
		this.edp=edp;
		this.main = main;
		myAlgo = new Algorithm();
	}
	
	public void SendData() {
		SingletonData singleData = SingletonData.getSingletonSiteData();
		singleData.setSiteData(siteVO);
	}
	
	public void ClipBoardLink(String clipString) { //클립보드에 텍스트 저장하는 메소드
		this.clipString = clipString;

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection strSel = new StringSelection(clipString);
		clipboard.setContents(strSel, null);
	}
	
	public void GotoWebpage(String urlString) { //웹페이지 이동하는 메소드
		this.urlString = urlString;
		
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				URI uri = new URI(urlString); //이동할 URL
				desktop.browse(uri);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void DeletePopup() {
		// TODO Auto-generated method stub
		int yn = JOptionPane.showConfirmDialog
				(edp, "삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_OPTION);
		
		if(yn==JOptionPane.YES_OPTION) {
			siteVO = edp.siteVO;
			siteDao.deleteData(siteVO.getSitekey());
			main.lginP.lginH.ListP.insertEachPanel();
		}
		else {
			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		//System.out.println(e.getActionCommand()+"<<<"); //test code
		
		siteDao = new SiteDAO();
		if(obj==edp.GoWebSite) {
			siteVO = edp.siteVO;
			
			GotoWebpage(siteVO.getURL());
			ClipBoardLink(myAlgo.DecryptAlgorithm(siteVO, siteVO.getGuardLevel()));
		}
		if(obj==edp.DeleteData) {
			DeletePopup();
			
		}
		if(obj==edp.DataBox) {
			siteVO = edp.siteVO;
			SendData();
			
			siteVP = new SiteViewPanel(main);
			main.p.add(siteVP, "ViewP");
			main.card.show(main.p, "ViewP");
			
			//test code
//			SingletonData singleData = SingletonData.getSingletonSiteData();
//			System.out.println(singleData.getSiteName());
		}

	}

}

class RolloverListener implements MouseListener {
	EachDataPanel edp;
	PWManager main;
	
	public RolloverListener(EachDataPanel edp, PWManager main) {
		this.edp=edp;
		this.main = main;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == edp.GoWebSite) {
			edp.GoWebSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GoWebMouseOnButton.png")));
		}
		if(obj == edp.DeleteData) {
			edp.DeleteData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeleteMouseOnButton.png")));
		}
		if(obj == edp.DataBox) {
			edp.DataBox.setBackground(new java.awt.Color(229, 229, 229));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == edp.GoWebSite) {
			edp.GoWebSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GoWebButton.png")));
		}
		if(obj == edp.DeleteData) {
			edp.DeleteData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeleteButton.png")));
		}
		if(obj == edp.DataBox) {
			edp.DataBox.setBackground(new java.awt.Color(238, 238, 238));
		}
	}
	
}
