package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtKupovniKurs;
	private JTextField txtProdajniKurs;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JTextField txtIznos;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JSlider slider;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.zatvoriZamenaProzor();
			}
		});
		setTitle("Izvrsi zamenu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getComboBox());
		contentPane.add(getLblIznos());
		contentPane.add(getTxtIznos());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(299, 29, 78, 14);
		}
		return lblProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(42, 29, 78, 14);
		}
		return lblKupovniKurs;
	}
	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setBounds(42, 54, 104, 20);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}
	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setColumns(10);
			txtProdajniKurs.setBounds(299, 54, 104, 20);
		}
		return txtProdajniKurs;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(187, 54, 61, 20);
			comboBox.addItem("EUR");
			comboBox.addItem("USD");
			comboBox.addItem("CHF");
		}
		return comboBox;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(42, 98, 46, 14);
		}
		return lblIznos;
	}
	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setText("50");
			txtIznos.setBounds(42, 123, 147, 20);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(299, 98, 104, 14);
		}
		return lblVrstaTransakcije;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(299, 122, 109, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(299, 148, 109, 23);
		}
		return rdbtnProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int iznos = slider.getValue();
					txtIznos.setText(iznos+"");
				}
			});
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(5);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setBounds(42, 211, 361, 45);
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String valuta = (String) comboBox.getSelectedItem();
						double iznos = Double.parseDouble(txtIznos.getText());
						String transakcija;
						if(rdbtnKupovina.isSelected())
							transakcija = "kupovina";
						else
							if(rdbtnProdaja.isSelected())
								transakcija = "prodaja";
							else{
								JOptionPane.showMessageDialog(null, "Niste izabrali vrstu transakcije!", "Greska!", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						
						GUIKontroler.dodajZamenuUStatus(valuta, iznos, transakcija);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(getContentPane(), "Iznos ne sme sadrzati znakovne vrednosti i mora biti popunjen.", "Greska pri unosu."
								,JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btnIzvrsiZamenu.setBounds(42, 279, 147, 26);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriZamenaProzor();
				}
			});
			btnOdustani.setBounds(256, 279, 147, 26);
		}
		return btnOdustani;
	}
}
