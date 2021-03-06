package com.uploader;

import java.util.*;
import java.util.regex.*;
import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.net.*;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

import java.lang.Object;

// import java.awt.*;
import java.awt.Dimension;
// import javax.swing.*;

import java.awt.Component;
import java.awt.Event;
import java.awt.EventQueue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextField.*;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.Box;
import javax.swing.SwingUtilities;
import javax.swing.SpringLayout;
import javax.swing.text.BadLocationException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.alee.utils.*;

public class AppGui extends JFrame  {

    public static String nameData;
    public static String numPagesData;
    public static String delayData;

    private JTextArea textArea;
    private JTextPane textComponent;

    private JPanel textPanel;
    private JPanel checkBoxPanel;

    ImageIcon profileNameLabelIconSrc;
    ImageIcon delayFieldLabelIconSrc;
    ImageIcon referalFieldLabelIconSrc;
    ImageIcon oneLinkUploadFieldLabelIconSrc;

    ImageIcon profileNameLabelIcon;
    ImageIcon delayFieldLabelIcon;
    ImageIcon referalFieldLabelIcon;
    ImageIcon oneLinkUploadFieldLabelIcon;

    ImageIcon buttonYoutubeUploadIconSrc;
    ImageIcon buttonOneLinkUploadIconSrc;
    ImageIcon buttonSetPreferensesIconSrc;
    ImageIcon buttonReauthIconSrc;
    ImageIcon buttonStopIconSrc;
    ImageIcon buttonExitIconSrc;

    ImageIcon buttonYoutubeUploadIcon;
    ImageIcon buttonOneLinkUploadIcon;
    ImageIcon buttonSetPreferensesIcon;
    ImageIcon buttonReauthIcon;
    ImageIcon buttonStopIcon;
    ImageIcon buttonExitIcon;

    // buttonYoutubeUpload.setIcon(buttonYoutubeUploadIcon);

    private JTextField profileNameField = new JTextField(null);
    private JTextField delayField = new JTextField();
    private JTextField referalField = new JTextField();
    private JTextField oneLinkUploadField = new JTextField(null);

    // profileNameField.(new JLabel();

    // profileNameField.setHorizontalAlignment(JTextField.CENTER);

    // profileNameField.setText("");

    private JLabel statusLabel;

    private JCheckBox publicUpload = new JCheckBox("Upload as Public?");

    private PrintStream standardOut;

    GridBagLayout layout;

    Thread thread;
    private boolean trigger;
    private boolean preferensesVisibleTrigger;
    private boolean uploadAsPublic;

    public AppGui()    {

        super("YouTubeUploader");

        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");

        int font_count = 0;

        int buttonsFontSize = 15;
        int labelsFontSize = 15;
        int inputFieldsFontSize = 14;
        int textAreaFontSize = 14;
        
        Font ttfBaseButtons = null;
        Font ttfBaseLabels = null;
        Font ttfBaseInputs = null;
        Font ttfBaseText = null;

        Font buttonYoutubeUploadFont = null;
        Font buttonOneLinkUploadFont = null;
        Font buttonSetPreferensesFont = null;
        Font buttonReauthFont = null;
        Font buttonStopFont = null;
        Font buttonExitFont = null;

        Font profileNameLabelFont = null;
        Font delayFieldLabelFont = null;
        Font referalFieldLabelFont = null;
        Font oneLinkUploadFieldLabelFont = null;
        Font statusLabelFont = null;
        Font publicUploadFont= null;

        Font profileNameFieldFont = null;
        Font delayFieldFont = null;
        Font referalFieldFont = null;
        Font oneLinkUploadFieldFont = null;
        Font textAreaFont = null;

        preferensesVisibleTrigger = true;
        uploadAsPublic = false;

        Image imageSrc;
        Image imageResized;

        JButton buttonYoutubeUpload;
        JButton buttonOneLinkUpload;
        JButton buttonSetPreferenses;
        // private JButton buttonVimeoUpload = new JButton("VimeoUpload");
        JButton buttonReauth;
        JButton buttonStop;
        JButton buttonExit;

        JLabel profileNameLabel;
        JLabel delayFieldLabel;
        JLabel referalFieldLabel;
        JLabel oneLinkUploadFieldLabel;

        if(!uploadAsPublic)    {

            statusLabel = new JLabel(" (Now Upload As Private)");

        }   else    {

            statusLabel = new JLabel(" (Now Upload As Public)");

        }

        try {

            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");

        }   catch(Exception e) {

            e.printStackTrace();
            // System.out.println("Не удалось установить тему");

        }

        try {

            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            // UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");

        }   catch(Exception e) {

            // e.printStackTrace();
            // System.out.println("Не удалось установить тему");
            System.out.println("Font not found -> use default");

        }

        try {

            profileNameLabelIconSrc = new ImageIcon("icons/I_for.png");
            delayFieldLabelIconSrc = new ImageIcon("icons/I_for.png");
            referalFieldLabelIconSrc = new ImageIcon("icons/I_for.png");
            oneLinkUploadFieldLabelIconSrc = new ImageIcon("icons/I_for.png");

            buttonYoutubeUploadIconSrc = new ImageIcon("icons/I_Upload_64x64.png");
            buttonOneLinkUploadIconSrc = new ImageIcon("icons/I_Upload_64x64.png");
            buttonSetPreferensesIconSrc = new ImageIcon("icons/I_Preferens_64x64.png");
            buttonReauthIconSrc = new ImageIcon("icons/I_Remove_64x64.png");
            buttonStopIconSrc = new ImageIcon("icons/I_Stop_64x64.png");
            buttonExitIconSrc = new ImageIcon("icons/I_Exit_64x64.png");

            imageSrc = profileNameLabelIconSrc.getImage();
            imageResized = imageSrc.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            profileNameLabelIcon = new ImageIcon(imageResized);

            imageSrc = delayFieldLabelIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            delayFieldLabelIcon = new ImageIcon(imageResized);

            imageSrc = referalFieldLabelIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            referalFieldLabelIcon = new ImageIcon(imageResized);

            imageSrc = oneLinkUploadFieldLabelIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            oneLinkUploadFieldLabelIcon = new ImageIcon(imageResized);

            imageSrc = buttonYoutubeUploadIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            buttonYoutubeUploadIcon = new ImageIcon(imageResized);

            imageSrc = buttonOneLinkUploadIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            buttonOneLinkUploadIcon = new ImageIcon(imageResized);

            imageSrc = buttonSetPreferensesIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            buttonSetPreferensesIcon = new ImageIcon(imageResized);

            imageSrc = buttonReauthIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            buttonReauthIcon = new ImageIcon(imageResized);

            imageSrc = buttonStopIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            buttonStopIcon = new ImageIcon(imageResized);

            imageSrc = buttonExitIconSrc.getImage(); 
            imageResized = imageSrc.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
            buttonExitIcon = new ImageIcon(imageResized);

        }   catch(Exception e) {

            System.out.println("Cannot set icons!");

        }

        buttonYoutubeUpload = new JButton("UploadProfile", buttonYoutubeUploadIcon);
        buttonOneLinkUpload = new JButton("UploadLink", buttonYoutubeUploadIcon);
        buttonSetPreferenses = new JButton("Preferenses", buttonSetPreferensesIcon);
            // private JButton buttonVimeoUpload = new JButton("VimeoUpload");
        buttonReauth = new JButton("Remove Credentials", buttonReauthIcon);
        buttonStop = new JButton("Stop", buttonStopIcon);
        buttonExit = new JButton("Exit", buttonExitIcon);

        profileNameLabel = new JLabel("Profile Name ( at videohive.net ): ", profileNameLabelIcon, JLabel.CENTER);
        delayFieldLabel = new JLabel("Delay beetwen uploads ( of each parsed video, in minutes ): ", delayFieldLabelIcon, JLabel.CENTER);
        referalFieldLabel = new JLabel("Referal Profile ( only name of profile at videohive.net ): ", referalFieldLabelIcon, JLabel.CENTER);
        oneLinkUploadFieldLabel = new JLabel("Link from videohive.net: ", oneLinkUploadFieldLabelIcon, JLabel.CENTER);

        try {

            try {

                InputStream buttonsFontStream = new BufferedInputStream(new FileInputStream("fonts/Dosis-Bold.otf"));
                ttfBaseButtons = Font.createFont(Font.TRUETYPE_FONT, buttonsFontStream);

                InputStream labelsFontStream = new BufferedInputStream(new FileInputStream("fonts/Dosis-Bold.otf"));
                ttfBaseLabels = Font.createFont(Font.TRUETYPE_FONT, labelsFontStream);

                InputStream inputsFontStream = new BufferedInputStream(new FileInputStream("fonts/Dosis-Bold.otf"));
                ttfBaseInputs = Font.createFont(Font.TRUETYPE_FONT, inputsFontStream);

                InputStream textFontStream = new BufferedInputStream(new FileInputStream("fonts/Dosis-Medium.otf"));
                ttfBaseText = Font.createFont(Font.TRUETYPE_FONT, textFontStream);

                buttonYoutubeUploadFont = ttfBaseButtons.deriveFont(Font.BOLD, buttonsFontSize);
                buttonOneLinkUploadFont = ttfBaseButtons.deriveFont(Font.BOLD, buttonsFontSize);
                buttonSetPreferensesFont = ttfBaseButtons.deriveFont(Font.PLAIN, buttonsFontSize);
                buttonReauthFont = ttfBaseButtons.deriveFont(Font.PLAIN, buttonsFontSize);
                buttonStopFont = ttfBaseButtons.deriveFont(Font.PLAIN, buttonsFontSize);
                buttonExitFont = ttfBaseButtons.deriveFont(Font.PLAIN, buttonsFontSize);

                profileNameLabelFont = ttfBaseLabels.deriveFont(Font.PLAIN, labelsFontSize);
                delayFieldLabelFont = ttfBaseLabels.deriveFont(Font.PLAIN, labelsFontSize);
                referalFieldLabelFont = ttfBaseLabels.deriveFont(Font.PLAIN, labelsFontSize);
                oneLinkUploadFieldLabelFont = ttfBaseLabels.deriveFont(Font.PLAIN, labelsFontSize);
                statusLabelFont = ttfBaseLabels.deriveFont(Font.PLAIN, labelsFontSize);
                publicUploadFont = ttfBaseLabels.deriveFont(Font.PLAIN, labelsFontSize);

                profileNameFieldFont = ttfBaseInputs.deriveFont(Font.PLAIN, inputFieldsFontSize);
                delayFieldFont = ttfBaseInputs.deriveFont(Font.PLAIN, inputFieldsFontSize);
                referalFieldFont = ttfBaseInputs.deriveFont(Font.PLAIN, inputFieldsFontSize);
                oneLinkUploadFieldFont = ttfBaseInputs.deriveFont(Font.PLAIN, inputFieldsFontSize);

                textAreaFont = ttfBaseText.deriveFont(Font.PLAIN, textAreaFontSize);

                // File fontFile = new File("Amatic");
                // GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                // ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));

                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())   {

                    font_count++;
                    System.out.println(font_count + ":" + info);

                }

            }   catch(Exception e) {

                System.out.println("Font Set Error");

            }

            // InputStream is = MyClass.class.getResourceAsStream("fonts/OpenSans-Regular.ttf");
            // Font font = Font.createFont(Font.TRUETYPE_FONT, is);

            // buttonYoutubeUpload.setFont(new Font("Sans", Font.PLAIN,14));
            buttonYoutubeUpload.setFont(buttonYoutubeUploadFont);
            buttonOneLinkUpload.setFont(buttonOneLinkUploadFont);
            // buttonVimeoUpload.setFont(new Font("Sans",Font.PLAIN,12));
            buttonSetPreferenses.setFont(buttonSetPreferensesFont);
            buttonReauth.setFont(buttonReauthFont);
            buttonStop.setFont(buttonStopFont);
            buttonExit.setFont(buttonExitFont);

            profileNameLabel.setFont(profileNameLabelFont);
            delayFieldLabel.setFont(delayFieldLabelFont);
            referalFieldLabel.setFont(referalFieldLabelFont);
            oneLinkUploadFieldLabel.setFont(oneLinkUploadFieldLabelFont);
            publicUpload.setFont(statusLabelFont);
            statusLabel.setFont(publicUploadFont);

            profileNameField.setFont(profileNameFieldFont);
            delayField.setFont(delayFieldFont);
            referalField.setFont(referalFieldFont);
            oneLinkUploadField.setFont(oneLinkUploadFieldFont);

            Font font = UIManager.getFont("Button.font");

            System.out.println("Font: " + font);

            // UIManager.put("Button.font", new FontUIResource("DejaVu Serif"));

            // UIManager.put("Button.font", new Font("Serif",Font.BOLD,12));
            // UIManager.put("ToggleButton.font", new Font("Serif",Font.BOLD,12));
            // UIManager.put("RadioButton.font", new Font("Serif",Font.BOLD,12));
            // UIManager.put("CheckBox.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("ColorChooser.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("ComboBox.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("Label.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("List.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("MenuBar.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("MenuItem.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("RadioButtonMenuItem.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("CheckBoxMenuItem.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("Menu.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("PopupMenu.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("OptionPane.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("Panel.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("ProgressBar.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("ScrollPane.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("Viewport.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("TabbedPane.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("Table.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("TableHeader.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("TextField.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("PasswordField.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("TextArea.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("TextPane.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("EditorPane.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("TitledBorder.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("ToolBar.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("ToolTip.font", new Font("DejaVu Serif",Font.BOLD,12));
            // UIManager.put("Tree.font", new Font("DejaVu Serif",Font.BOLD,12));
            
        } catch(Exception e)    {

            System.out.println("Не удалось установить шрифты ");

        }

        // SwingUtilities.updateComponentTreeUI(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(100, 10);

        textArea.setFont(textAreaFont);
        textArea.setEditable(false);
        textArea.setForeground(Color.BLACK);
        // textArea.setText("Hello! We are wrote this app to get you clone all your profile videos \nat videohive.net to YouTube account or channel. Firstly, you can click on \n\"Preferenses\" button and set dirrefent parametres like your videohive \nprofile name or referal link. Secondly - click on \"YouTubeUpload\" button and \nprogram begin to parse all your public profile videos and upload \nit to YouTube. To reauthorize on YouTube click \"RemoveCredentials\".\nTo stop parse your page or uploading to YouTube - click \"Stop\" button.\n");
        // textArea.setText("-----------------------------------------------------------------------");
        // textArea.setForeground(Color.GRAY);
        // textArea.setContentType("text/html;charset=UTF-8");

        // textComponent = new JTextPane(50, 10);

        // textComponent = new JTextPane();
        // textComponent.setEditable(false);
        // textComponent.setContentType("text/html;charset=UTF-8");
        // textComponent.setFont(new java.awt.Font("Courier New", 0, 10));

        // textComponent.setPreferredSize(new Dimension(100,800));

        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setPreferredSize(new Dimension(200,200));

        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(null);

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        standardOut = System.out;

        System.setOut(printStream);
        System.setErr(printStream);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // constraints.gridx = 0;
        // constraints.gridy = 0;
        // constraints.insets = new Insets(5,5,5,5);
        constraints.anchor = GridBagConstraints.WEST;

        // add(buttonYoutubeUpload,constraints);

        // constraints.gridx = 1;
        // constraints.gridy = 0;

        // profileNameLabel.setFont(new Font("", Font.BOLD, 12));
        // profileNameField.setFont(new Font("", Font.BOLD, 12));
        // delayField.setFont(new Font("", Font.BOLD, 12));
        // delayFieldLabel.setFont(new Font("serif", Font.BOLD, 12));

        // Задаем размеры элементов
        profileNameLabel.setSize(new Dimension(450,20));
        delayFieldLabel.setSize(new Dimension(450,20));
        profileNameField.setPreferredSize(new Dimension(10,20));
        delayField.setPreferredSize(new Dimension(10,20));

        profileNameField.setBorder(new RoundedCornerBorder());
        delayField.setBorder(new RoundedCornerBorder());
        referalField.setBorder(new RoundedCornerBorder());
        oneLinkUploadField.setBorder(new RoundedCornerBorder());

        // profileNameField.setHorizontalAlignment(JTextField.CENTER);
        // delayField.setHorizontalAlignment(JTextField.CENTER);
        // referalField.setHorizontalAlignment(JTextField.CENTER);

        Box labelFieldBox1 = Box.createHorizontalBox();

        labelFieldBox1.add(profileNameLabel,constraints);
        labelFieldBox1.add(profileNameField,constraints);
        labelFieldBox1.setFont(new Font("DejaVu Serif",Font.BOLD,12));
        // labelFieldBox1.add(Box.createHorizontalGlue());

        // labelFieldBox1.setSize(new Dimension(1000,20));
        labelFieldBox1.setVisible(preferensesVisibleTrigger);
        // constraints.gridx = 2;
        // constraints.gridy = 0;

        Box labelFieldBox2 = Box.createHorizontalBox();

        labelFieldBox2.add(delayFieldLabel,constraints);
        labelFieldBox2.add(delayField,constraints);
        labelFieldBox2.add(Box.createHorizontalGlue());

        labelFieldBox2.setVisible(preferensesVisibleTrigger);

        Box labelFieldBox3 = Box.createHorizontalBox();

        labelFieldBox3.add(referalFieldLabel,constraints);
        labelFieldBox3.add(referalField,constraints);
        labelFieldBox3.add(Box.createHorizontalGlue());

        labelFieldBox3.setVisible(preferensesVisibleTrigger);

        Box labelFieldBox4 = Box.createHorizontalBox();

        labelFieldBox4.add(oneLinkUploadFieldLabel,constraints);
        labelFieldBox4.add(oneLinkUploadField,constraints);
        labelFieldBox4.add(Box.createHorizontalGlue());

        labelFieldBox4.setVisible(preferensesVisibleTrigger);

        // checkBoxPanel.add(publicUpload);

        Box checkBoxField4 = Box.createHorizontalBox();

        publicUpload.setSelected(false);

        checkBoxField4.add(publicUpload,constraints);
        checkBoxField4.add(statusLabel,constraints);
        checkBoxField4.add(Box.createHorizontalGlue());

        checkBoxField4.setVisible(preferensesVisibleTrigger);

        Box buttonsBox = Box.createHorizontalBox();

        buttonsBox.add(buttonYoutubeUpload);
        buttonsBox.add(buttonOneLinkUpload);
        // buttonsBox.add(buttonVimeoUpload);
        buttonsBox.add(buttonSetPreferenses);
        buttonsBox.add(buttonReauth);
        buttonsBox.add(buttonStop);
        buttonsBox.add(buttonExit);
        buttonsBox.add(Box.createHorizontalGlue());

        // constraints.gridx = 1;
        // constraints.gridy = 0;
        // add(profileNameLabel,constraints);

        // constraints.gridx = 2;
        // constraints.gridy = 0;
        // add(profileNameField,constraints);

        // constraints.gridx = 1;
        // constraints.gridy = 1;
        // add(delayFieldLabel,constraints);

        // constraints.gridx = 2;
        // constraints.gridy = 1;
        // add(delayField,constraints);

        // constraints.gridx = 0;
        // constraints.gridy = 3;

        // constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        Box textAreaBox = Box.createHorizontalBox();
        textAreaBox.add(textArea);
        // textAreaBox.createHorizontalStrut(100);
        // textAreaBox.createVerticalStrut(500);

        Box mainBox = Box.createVerticalBox();

        // mainBox.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));

        // constraints.insets = new Insets(5,5,5,5);

        // mainBox.add(Box.createHorizontalGlue());

        mainBox.add(buttonsBox,constraints);
        mainBox.add(Box.createHorizontalStrut(15));
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(Box.createHorizontalGlue());

        mainBox.add(labelFieldBox1,constraints);
        mainBox.add(Box.createHorizontalStrut(15));
        mainBox.add(Box.createVerticalStrut(10));
        
        mainBox.add(labelFieldBox2,constraints);
        mainBox.add(Box.createHorizontalStrut(15));
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(labelFieldBox3,constraints);
        mainBox.add(Box.createHorizontalStrut(15));
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(labelFieldBox4,constraints);
        mainBox.add(Box.createHorizontalStrut(15));
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(checkBoxField4,constraints);
        mainBox.add(Box.createHorizontalStrut(15));
        mainBox.add(Box.createVerticalStrut(10));

        // mainBox.add(textAreaBox);
        // mainBox.add(textComponent);
        // mainBox.add(Box.createHorizontalGlue());
        mainBox.add(new JScrollPane(textArea), constraints);

        // MessageConsole mc = new MessageConsole(textComponent);

        // mc.redirectOut();
        // mc.redirectErr(Color.RED, null);

        setContentPane(mainBox);

        mainBox.setBorder(new EmptyBorder(10, 10, 10, 10));

        pack();

        setResizable(true);

        buttonOneLinkUpload.addActionListener(new ActionListener()  {

            public void actionPerformed(ActionEvent evt)    {

                String textInNameField = "";
                String textInDelayField = "";
                String textInReferalField = "";
                String textInOneLinkUploadField = "";

                double textInDelayFieldInDouble = 0.0;

                textInNameField = "Test";

                textInDelayFieldInDouble = 0.0;

                if(oneLinkUploadField.getText() != null && !oneLinkUploadField.getText().isEmpty()) {

                    textInOneLinkUploadField = oneLinkUploadField.getText();

                }   else    {

                    textArea.append("Set videohive's URL to upload.\n");

                }

                if(referalField.getText() != null && !referalField.getText().isEmpty()) {

                    textInReferalField = referalField.getText();

                }   else    {

                    textArea.append("Referal is not set.\n");

                }

                if(textInOneLinkUploadField != null && !textInOneLinkUploadField.isEmpty())  {

                    upload_onelink_to_tube(textInOneLinkUploadField, textInDelayFieldInDouble, textInReferalField);

                }

            }
        });

        buttonYoutubeUpload.addActionListener(new ActionListener()  {

            public void actionPerformed(ActionEvent evt)    {

                String textInNameField = "";
                String textInDelayField = "";
                String textInReferalField = "";
                String textInOneLinkUploadField = "";

                double textInDelayFieldInDouble = 0.0;

                if(profileNameField.getText() != null && !profileNameField.getText().isEmpty()) {

                    textInNameField = profileNameField.getText();

                }   else    {

                    textArea.append("Set Profile Name Please.\n");

                }

                if(delayField.getText() != null && !delayField.getText().isEmpty()) {

                    textInDelayField = delayField.getText();
                    textInDelayFieldInDouble = Double.parseDouble(textInDelayField);


                }   else    {

                    textArea.append("Delay is set to default value.\n");

                }

                if(referalField.getText() != null && !referalField.getText().isEmpty()) {

                    textInReferalField = referalField.getText();

                }   else    {

                    textArea.append("Referal is not set.\n");

                }

                if(textInNameField != null && !textInNameField.isEmpty())  {

                    upload_hive_to_tube(textInNameField, textInDelayFieldInDouble, textInReferalField);

                }

            }
        });

        // buttonVimeoUpload.addActionListener(new ActionListener()  {

        //     public void actionPerformed(ActionEvent evt)    {

        //         String textInNameField = profileNameField.getText();
        //         String textInDelayField = delayField.getText();

        //         double textInDelayFieldInDouble = Double.parseDouble(textInDelayField);

        //         // while(trigger)  {
        //             upload_hive_to_vimeo(textInNameField, textInDelayFieldInDouble);
        //         // }
        //         // System.out.println("I like that!");

        //     }
        // });

        buttonSetPreferenses.addActionListener(new ActionListener()  {

            public void actionPerformed(ActionEvent evt)    {

                // String textInNameField = profileNameField.getText();
                // String textInDelayField = delayField.getText();

                // double textInDelayFieldInDouble = Double.parseDouble(textInDelayField);
                if(preferensesVisibleTrigger == false)  {

                    preferensesVisibleTrigger = true;

                    labelFieldBox1.setVisible(preferensesVisibleTrigger);
                    labelFieldBox2.setVisible(preferensesVisibleTrigger);
                    labelFieldBox3.setVisible(preferensesVisibleTrigger);
                    checkBoxField4.setVisible(preferensesVisibleTrigger);

                }   else    {

                    preferensesVisibleTrigger = false;

                    labelFieldBox1.setVisible(preferensesVisibleTrigger);
                    labelFieldBox2.setVisible(preferensesVisibleTrigger);
                    labelFieldBox3.setVisible(preferensesVisibleTrigger);
                    checkBoxField4.setVisible(preferensesVisibleTrigger);

                }

            }
        });

        buttonReauth.addActionListener(new ActionListener()  {

            public void actionPerformed(ActionEvent evt)    {
                try {

                    Runtime.getRuntime().exec("remove-credentials.exe");
                    // try {
                    //     Files.delete(path);
                    // } catch (NoSuchFileException x) {
                    //     System.err.format("%s: no such" + " file or directory%n", path);
                    // } catch (DirectoryNotEmptyException x) {
                    //     System.err.format("%s not empty%n", path);
                    // } catch (IOException x) {
                    //     // File permission problems are caught here.
                    //     System.err.println(x);
                    // }

                }   catch(Exception e)   {

                    e.printStackTrace();

                }
                // System.out.println("I like that!");
            }
        });

        buttonExit.addActionListener(new ActionListener()  {

            public void actionPerformed(ActionEvent evt)    {

                try {


                    HiveToResource.STOP = true;
                    thread.sleep(800);
                    System.gc();
                    System.exit(0);

                }   catch(Exception e)  {

                    e.printStackTrace();
                }
            }
        });

        buttonStop.addActionListener(new ActionListener()  {

            public void actionPerformed(ActionEvent evt)    {

                try {

                    // thread.interrupt();
                    // System.exit(0);
                    HiveToResource.STOP = true;

                }   catch(Exception e)  {

                    e.printStackTrace();
                }
            }
        });

        publicUpload.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {         
                statusLabel.setText((e.getStateChange()==1 ? " (Now Upload As Public)" : " (Now Upload As Private)"));

                if(e.getStateChange()==1)   {

                    uploadAsPublic = true;

                }   else    {

                    uploadAsPublic = false;

                }
            }         
        });
    }

    private void upload_hive_to_tube(String _name_of_profile, double _delay_in_min, String _referal_name)    {

        thread = new Thread(new Runnable()   {

            public void run()   {
                // System.out.println("I like that!");

                HiveToResource h2t = new HiveToResource(_name_of_profile, _delay_in_min, _referal_name, "youtube", uploadAsPublic);
                h2t.GrabAndLoad();
            }

        });
        thread.start();
    }

    private void upload_onelink_to_tube(String _link_to_project, double _delay_in_min, String _referal_name)    {

        thread = new Thread(new Runnable()   {

            public void run()   {
                // System.out.println("I like that!");

                OneLinkUpload h2t = new OneLinkUpload(_link_to_project, _referal_name, "youtube", uploadAsPublic);
                h2t.GrabAndLoad();
            }

        });
        thread.start();
   }

   private void upload_hive_to_vimeo(String _name_of_profile, double _delay_in_min, String _referal_name)    {

        thread = new Thread(new Runnable()   {

            public void run()   {
                // System.out.println("I like that!");

                HiveToResource h2t = new HiveToResource(_name_of_profile, _delay_in_min, _referal_name , "vimeo", uploadAsPublic);
                h2t.GrabAndLoad();
            }

        });
        thread.start();
    }
    
    public static void main(String[] args)  {

        SwingUtilities.invokeLater(new Runnable()   {

            public void run()   {

                try {

                    JFrame jfrm = new AppGui();
                    // jfrm.setPreferredSize(new Dimension(1200,1000));
                    jfrm.setSize(770,550);
                    jfrm.setVisible(true);
                    System.out.println(jfrm.getSize());

                }   catch(Exception e)  {


                    e.printStackTrace();
                    // System.out.println("-----------------------------------------------------");
                    // System.out.println("Stopping current thread!");
                    // System.out.println("-----------------------------------------------------");

                }

            }

        });

    }

}


