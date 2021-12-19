package com.ict.pwmanager;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JTextField;  

public class HintTextField extends JTextField {


	public HintTextField(final String hint) {

		setHintText(hint);

	}
	
	public void setHintText(final String hint) {
		setText(hint);
		setFont(new java.awt.Font("¸¼Àº °íµñ", 0, 12));
		setForeground(Color.GRAY);

		this.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {

				if (getText().equals(hint)) {
					setText("");
				} else {
					setText(getText());
				}
				setFont(new java.awt.Font("¸¼Àº °íµñ", 0, 12));
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (getText().equals(hint) || getText().length() == 0) {
					setText(hint);
					setForeground(Color.GRAY);
				} else {
					setText(getText());
					setForeground(Color.BLACK);
				}
				setFont(new java.awt.Font("¸¼Àº °íµñ", 0, 12));
			}
		});
	}

}