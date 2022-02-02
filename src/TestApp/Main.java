package TestApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import Document.DAOCommande;
import Document.DocumentManager;
import Domaine.Commande;
import Domaine.LigneComm;
import GererProjet.GererCommande;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, ParseException {
		DocumentManager xmlManager = new DocumentManager();
		List <LigneComm> listLigne = new ArrayList<>();
		LigneComm l = new LigneComm("aa","aa","aa","aa");
		listLigne.add(l);
  		//Commande c=  new Commande(44,"20/01/2021","kais",listLigne);
        System.out.println("veuillez saisir une date de debut : ");
          Document doc = xmlManager.getDocumentXML("Commandes.xml");
        DAOCommande _dbCommande  = new DAOCommande(xmlManager);
          Scanner scandate=new Scanner(System.in);
          String entree=scandate.next();
          SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy") ; 
          Date DateD=sdf.parse(entree); 
          System.out.println("veuillez saisir une date de fin : ");
          Date DateF=sdf.parse(entree); 
          GererCommande gerer = new GererCommande(_dbCommande,doc);
          System.out.println("la recette "+gerer.CalculerRecette(DateD, DateF));
	}

}
