package me.craft4ik.launcher;

import com.sun.awt.AWTUtilities;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class LauncherAuthFrame extends JFrame implements FocusListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	public static String[] settings = null;
	public static String[] config = null;
	public static String entry10 = "";
	public JButton entry100 = new JButton();
	public JButton entry1000 = new JButton();
	private int entry1020 = 0;
	private int entry1021 = 0;
	public static LauncherAuthFrame frame;
	public LauncherGuard guard = new LauncherGuard();
	public LauncherAuthPanel panel = new LauncherAuthPanel();
	public LauncherCombobox entry1004 = new LauncherCombobox((String[]) null, 324);
	public JTextPane newsPane = new JTextPane();
	public JScrollPane newsScroller;
	public JTextField login;
	public JPasswordField password;
	public JButton buttonLaunch;
	public JButton buttonExit;
	public JButton buttonRefresh;
	public JButton buttonLaunch2;
	public JButton buttonSettings;
	public JButton buttonCancel;
	public JButton buttonAccept;
	public JCheckBox savePassword;
	public JCheckBox redownloadClient;
	public JCheckBox fullscreen;
	public JCheckBox offline;
	public JTextField memory;
	
	public LauncherAuthFrame()
	{
		newsScroller = new JScrollPane(newsPane);
		login = new JTextField();
		password = new JPasswordField();
		buttonLaunch = new JButton("В игру");
		buttonExit = new JButton("Выход");
		buttonRefresh = new JButton("Обновить");
		buttonLaunch2 = new JButton("В игру");
		buttonSettings = new JButton("Настройки");
		buttonCancel = new JButton("Отмена");
		buttonAccept = new JButton("Принять");
		savePassword = new JCheckBox("Запомнить мои данные");
		redownloadClient = new JCheckBox("Перекачать клиент");
		fullscreen = new JCheckBox("Полноэкранный режим");
		offline = new JCheckBox("Режим оффлайн");
		memory = new JTextField("1024");
		if(LauncherUtils.getOS() != 0)
		{
			setUndecorated(true);
			AWTUtilities.setWindowOpaque(this, false);
		}
		setPreferredSize(new Dimension(346, 498));
		this.setSize(getPreferredSize());
		setTitle("qoobworld.ru :: v5.0");
		setResizable(false);
		setLocationRelativeTo((Component) null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(3);
		setIconImage(LauncherUtils.iconImage);
		this.entry1();
		try
		{
			class1019.entry1(this);
		} catch(Exception var2)
		{
		}
		login.setText("Логин");
		login.addActionListener((ActionListener) null);
		login.addFocusListener(this);
		password.setText("Пароль");
		password.addActionListener((ActionListener) null);
		password.addFocusListener(this);
		newsPane.setOpaque(false);
		newsPane.setBorder((Border) null);
		newsPane.setContentType("text/html");
		newsPane.setEditable(false);
		newsPane.setFocusable(false);
		newsPane.addHyperlinkListener(new class1028(this));
		newsScroller.setOpaque(false);
		newsScroller.getViewport().setOpaque(false);
		newsScroller.setBorder((Border) null);
		newsScroller.setBounds(371, 45, LauncherUtils.newsBackground.getWidth() - 50, 360);
		entry1004.addMouseListener(new class1026(this));
		panel.addKeyListener(this);
		login.addKeyListener(this);
		password.addKeyListener(this);
		this.entry1(false);
		entry10(false);
		setContentPane(panel);
	}
	
	public final void entry0(boolean var1)
	{
		entry1004.setEnabled(var1);
		login.setEnabled(var1);
		password.setEnabled(var1);
		buttonLaunch2.setEnabled(var1);
		buttonSettings.setEnabled(var1);
		buttonExit.setEnabled(var1);
		buttonRefresh.setEnabled(var1);
		buttonCancel.setEnabled(var1);
		buttonAccept.setEnabled(var1);
		savePassword.setEnabled(var1);
		redownloadClient.setEnabled(var1);
		fullscreen.setEnabled(var1);
		offline.setEnabled(var1);
		memory.setEnabled(var1);
		buttonLaunch.setEnabled(var1);
	}
	
	public final void entry0(int var1)
	{
		BufferedImage var2 = ImageUtils.screenshot(panel).getSubimage(0, 0, panel.getWidth(), panel.getHeight());
		panel.removeAll();
		LauncherAuthPanel.entry1.entry0(var2, var1);
		panel.entry1(true);
		this.entry1(false);
		this.repaint();
	}
	
	public final void entry0(int var1, boolean var2)
	{
		switch(var1)
		{
			case 1:
				entry10(var2);
				break;
			case 2:
				entry100(var2);
				break;
			case 3:
				entry1000(var2);
				break;
			default:
				break;
			case 5:
				entry1001(var2);
		}
	}
	
	public final void entry0(String var1, int var2, int var3)
	{
		panel.entry0(var1, var2, var3);
	}
	
	private void entry1()
	{
		addMouseMotionListener(new class1032(this));
		addMouseListener(new class1037(this));
	}
	
	protected final void entry1(boolean var1)
	{
		if(!var1)
		{
			panel.add(entry100);
			panel.add(entry1000);
		} else
		{
			panel.remove(entry100);
			panel.remove(entry1000);
		}
	}
	
	public final void entry1(int var1)
	{
		switch(var1)
		{
			case 1:
				panel.entry0();
				break;
			case 2:
				panel.entry1();
				break;
			case 3:
				panel.entry10();
				break;
			case 4:
				panel.entry1000();
				break;
			case 5:
				panel.entry100();
		}
	}
	
	protected final void entry10(boolean var1)
	{
		if(!var1)
		{
			panel.add(entry1004);
			panel.add(buttonLaunch2);
			panel.add(buttonSettings);
			panel.add(login);
			panel.add(password);
		} else
		{
			panel.remove(entry1004);
			panel.remove(buttonLaunch2);
			panel.remove(buttonSettings);
			panel.remove(login);
			panel.remove(password);
		}
	}
	
	protected final void entry100(boolean var1)
	{
		if(!var1)
		{
			panel.add(buttonCancel);
			panel.add(buttonAccept);
			panel.add(savePassword);
			panel.add(redownloadClient);
			panel.add(fullscreen);
			panel.add(offline);
			panel.add(memory);
		} else
		{
			panel.remove(buttonCancel);
			panel.remove(buttonAccept);
			panel.remove(savePassword);
			panel.remove(redownloadClient);
			panel.remove(fullscreen);
			panel.remove(offline);
			panel.remove(memory);
		}
	}
	
	protected final void entry1000(boolean var1)
	{
		if(!var1)
		{
			panel.add(buttonExit);
			panel.add(buttonRefresh);
		} else
		{
			panel.remove(buttonExit);
			panel.remove(buttonRefresh);
		}
	}
	
	protected final void entry1001(boolean var1)
	{
		if(!var1)
		{
			panel.add(buttonLaunch);
		} else
		{
			panel.remove(buttonLaunch);
		}
	}
	
	@Override public final void focusGained(FocusEvent var1)
	{
		if(var1.getSource() == login && login.getText().equals("Логин"))
		{
			login.setText("");
		}
		if(var1.getSource() == password && new String(password.getPassword()).equals("Пароль"))
		{
			password.setText("");
		}
	}
	
	@Override public final void focusLost(FocusEvent var1)
	{
		if(var1.getSource() == login && login.getText().equals(""))
		{
			login.setText("Логин");
		}
		if(var1.getSource() == password && new String(password.getPassword()).equals(""))
		{
			password.setText("Пароль");
		}
	}
	
	@Override public final void keyPressed(KeyEvent var1)
	{
	}
	
	@Override public final void keyReleased(KeyEvent var1)
	{
		if(KeyEvent.getKeyText(var1.getKeyCode()).equals("Enter"))
		{
			if(panel.entry10 == 0)
			{
				buttonLaunch2.doClick();
			} else if(panel.entry10 == 4)
			{
				buttonLaunch.doClick();
			}
		}
	}
	
	@Override public final void keyTyped(KeyEvent var1)
	{
	}
	
	public final void setState(String var1, int var2)
	{
		panel.entry0(var1, var2);
	}
	
	// $FF: synthetic method
	static final int entry0(LauncherAuthFrame var0)
	{
		return var0.entry1020;
	}
	
	// $FF: synthetic method
	static final int entry0(LauncherAuthFrame var0, int var1)
	{
		return var0.entry1020 = var1;
	}
	
	// $FF: synthetic method
	static final int entry1(LauncherAuthFrame var0)
	{
		return var0.entry1021;
	}
	
	// $FF: synthetic method
	static final int entry1(LauncherAuthFrame var0, int var1)
	{
		return var0.entry1021 = var1;
	}
	
	public static final void error(String var0)
	{
	}
	
	public static final void log(String var0)
	{
	}
	
	public static final void setLookAndFeel()
	{
		log("Запуск qoobworld launcher v5.0");
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			log("Установка системного LnF успешно завершена");
		} catch(Exception var1)
		{
			log("Не удалось установить системный LnF");
		}
		class1008.entry10();
		config = LauncherUtils.entry10();
		LauncherUtils.loadTheme();
	}
	
	public static final void showLauncherFrame(LauncherSplashFrame var0) throws UnsupportedEncodingException
	{
		frame = new LauncherAuthFrame();
		frame.panel.entry0();
		LauncherUtils.entry0(frame);
		frame.panel.entry0(true);
		class1008.entry1();
		SwingUtilities.invokeLater(new LauncherRunnableDisposer(var0));
		frame.setVisible(true);
	}
}
