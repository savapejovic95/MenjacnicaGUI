package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import menjacnica.Kurs;

public class GUIKontroler {
	private static MenjacnicaGUI glavniProzor;
	private static DodajKursGUI dodajKursProzor;
	private static LinkedList<Kurs> kursevi;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
					dodajKursProzor = new DodajKursGUI();
					kursevi = new LinkedList<Kurs>();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void ucitavanjeFajla(){
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(null);
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			if(glavniProzor.getTextAreaStatus().getText().isEmpty())
				glavniProzor.getTextAreaStatus().setText("Ucitan fajl: " + fc.getSelectedFile().getAbsolutePath());
			else
				glavniProzor.getTextAreaStatus().setText(glavniProzor.getTextAreaStatus().getText() +'\n' + "Ucitan fajl: " + fc.getSelectedFile().getAbsolutePath());
		}
	}
	public static void sacuvavanjeFajla() {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showSaveDialog(null);
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			if(glavniProzor.getTextAreaStatus().getText().isEmpty()) 
				glavniProzor.getTextAreaStatus().setText("Sacuvan fajl: " + fc.getSelectedFile().getAbsolutePath());
			else
				glavniProzor.getTextAreaStatus().setText(glavniProzor.getTextAreaStatus().getText() +'\n' + "Sacuvan fajl: " + fc.getSelectedFile().getAbsolutePath());
		}
	}
	
	public static void zatvoriGlavniProzor() {
		int izbor = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete iz programa?");
		if(izbor == JOptionPane.YES_OPTION){
			glavniProzor.dispose();
		}
	}
	
	public static void prikaziDodajKursProzor(){
		dodajKursProzor.setVisible(true);
		dodajKursProzor.setLocationRelativeTo(null);
	}
	public static void unosKursa() {
		Kurs k = new Kurs();
		String sifra = dodajKursProzor.getTxtSifra().getText();
		String naziv = dodajKursProzor.getTxtNaziv().getText();
		String prodajni  = dodajKursProzor.getTxtProdajniKurs().getText();
		String kupovni = dodajKursProzor.getTxtKupovniKurs().getText();
		String srednji = dodajKursProzor.getTxtSrednjiKurs().getText();
		String skraceniNaziv = dodajKursProzor.getTxtSkraceniNaziv().getText();
		k.setKupovni(Integer.parseInt(kupovni));
		k.setNaziv(naziv);
		k.setProdajni(Integer.parseInt(prodajni));
		k.setSrednji(Integer.parseInt(srednji));
		k.setSkraceniNaziv(skraceniNaziv);
		k.setSifra(sifra);
		kursevi.add(k);
		String kurs = "Sifra: " +sifra + " Naziv: " +naziv + " Prodajni kurs: " +prodajni
		+ " Kupovni kurs: " +kupovni + " Srednji kurs: " +srednji + " Skraceni naziv: " +skraceniNaziv;
		if(glavniProzor.getTextAreaStatus().getText().equals(""))
			glavniProzor.getTextAreaStatus().setText(kurs);
		else
			glavniProzor.getTextAreaStatus().setText(glavniProzor.getTextAreaStatus().getText()+'\n'+kurs);
		glavniProzor.osveziTabelu();
	}
	public static TableModel postaviModelZaTabelu() {
		TableModelMenjacnica model = new TableModelMenjacnica(kursevi);
		return model;
	}
	public static List<Kurs> vratiSveKurseve() {
		return kursevi;
	}
	
}
