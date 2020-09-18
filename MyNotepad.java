import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class MyNotepad extends JFrame implements ActionListener
    {
	JMenuBar mbar;
	JMenu mnuFile,mnuEdit,mnuFormat,mnuView,mnuHelp;
	JMenuItem mitNew,mitOpen,mitSave,mitSaveAs,mitExit,mitCut,mitCopy,mitPaste,mitDelete,
			mitFind ,mitFindNext,mitReplace,mitSelectAll,mitTimeDate,mitWordWrap,mitFont,
			mitStatusBar,mitViewHelp,mitAboutNotepad;
	JTextArea jtaText;
	JPopupMenu popMenu;
	
	
	
     MyNotepad()
     {
    	setTitle("Untitle -Notepad");
    	jtaText=new JTextArea();
    	mitNew=new JMenuItem("NEW");
    	mitNew.setMnemonic(KeyEvent.VK_N);
    	mitNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    	
    	mitOpen=new JMenuItem("Open");
    	mitNew.setMnemonic(KeyEvent.VK_O);
    	mitNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
         
    	mitSave=new JMenuItem("SAVE");
    	mitSave.setMnemonic(KeyEvent.VK_S);
    	mitSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
    	mitSaveAs=new JMenuItem("SAVE AS");
    	mitSaveAs.setMnemonic(KeyEvent.VK_E);
    	//mitNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    	
    	mitExit=new JMenuItem("Exit");
    	mitExit.setMnemonic(KeyEvent.VK_X);
    	mitExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    	
    	mitNew.addActionListener(this);
    	mitOpen.addActionListener(this);
    	mitSave.addActionListener(this);
    	mitSaveAs.addActionListener(this);
    	mitExit.addActionListener(this); 
    	
    	mnuFile= new JMenu("File");
    	mnuFile.setMnemonic(KeyEvent.VK_F);
    	mnuFile.add(mitNew);
    	mnuFile.add(mitOpen);
    	mnuFile.add(mitSave);
    	mnuFile.add(mitSaveAs);
    	mnuFile.add(mitExit);
    	
    	mitCut = new JMenuItem("Cut");
		mitCut.setMnemonic(KeyEvent.VK_T);
		mitCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		mitCopy = new JMenuItem("Copy");
		mitCopy.setMnemonic(KeyEvent.VK_C);
		mitCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
		mitPaste = new JMenuItem("Paste");
		mitPaste.setMnemonic(KeyEvent.VK_P);
		mitPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK));
		mitDelete= new JMenuItem("Delete");
		mitDelete.setMnemonic(KeyEvent.VK_L);
		mitDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		mitFind = new JMenuItem("Find...");
		mitFind.setMnemonic(KeyEvent.VK_F);
		mitFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_MASK));
		mitFindNext = new JMenuItem("Find Next");
		mitFindNext.setMnemonic(KeyEvent.VK_N);
		mitFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
		mitReplace = new JMenuItem("Replace...");
		mitReplace.setMnemonic(KeyEvent.VK_R);
		mitReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		mitSelectAll = new JMenuItem("Select All");
		mitSelectAll.setMnemonic(KeyEvent.VK_A);
		mitSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		mitTimeDate = new JMenuItem("Time/Date");
		mitTimeDate.setMnemonic(KeyEvent.VK_D);
		mitTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
				
		mitCut.addActionListener(this);
		mitCopy.addActionListener(this);
		mitPaste.addActionListener(this);
		mitDelete.addActionListener(this);
		mitFind.addActionListener(this);
		mitFindNext.addActionListener(this);
		mitReplace.addActionListener(this);
		mitSelectAll.addActionListener(this);
		mitTimeDate.addActionListener(this);
				
		mnuEdit = new JMenu("Edit");
		mnuEdit.setMnemonic(KeyEvent.VK_E);		
		mnuEdit.add(mitCut);
		mnuEdit.add(mitCopy);
		mnuEdit.add(mitPaste);
		mnuEdit.add(mitDelete);
		mnuEdit.addSeparator();
		mnuEdit.add(mitFind);
		mnuEdit.add(mitFindNext);
		mnuEdit.add(mitReplace);
		mnuEdit.addSeparator();
		mnuEdit.add(mitSelectAll);
		mnuEdit.add(mitTimeDate);
				
		mitWordWrap= new  JMenuItem("Word Wrap");
		mitWordWrap.setMnemonic(KeyEvent.VK_W);
		mitFont = new JMenuItem("Font...");
		mitFont.setMnemonic(KeyEvent.VK_F);
				
		mitWordWrap.addActionListener(this);
		mitFont.addActionListener(this);
				
		mnuFormat = new JMenu("Format");
		mnuFormat.setMnemonic(KeyEvent.VK_O);
		mnuFormat.add(mitWordWrap);
		mnuFormat.add(mitFont);
				
		mitStatusBar = new JMenuItem("Status Bar");
		mitStatusBar.setMnemonic(KeyEvent.VK_S);
		mitStatusBar.addActionListener(this);
				
		mnuView = new JMenu("View");
		mnuView.setMnemonic(KeyEvent.VK_V);
		mnuView.add(mitStatusBar);
				
		mitViewHelp = new JMenuItem("View Help");
		mitViewHelp.setMnemonic(KeyEvent.VK_H);
		mitAboutNotepad = new JMenuItem("About Notepad");
		mitAboutNotepad.setMnemonic(KeyEvent.VK_A);
				
		mitViewHelp.addActionListener(this);
		mitAboutNotepad.addActionListener(this);
				
		mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic(KeyEvent.VK_H);
		mnuHelp.add(mitViewHelp);
		mnuHelp.addSeparator();
		mnuHelp.add(mitAboutNotepad);
				
		mbar = new JMenuBar();
		mbar.add(mnuFile);
		mbar.add(mnuEdit);
		mbar.add(mnuFormat);
		mbar.add(mnuView);
		mbar.add(mnuHelp);
    	
		setVisible(true);
    	
    	
    	
    	
    	

    	
     }

	public static void main(String[] args) {
		new MyNotepad();

	}

}
