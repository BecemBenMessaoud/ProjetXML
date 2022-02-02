package GererProjet;

import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import Domaine.Commande;
import Domaine.LigneComm;
import IDAO.IDAOCommande;

public class GererCommande {
IDAOCommande _dbCommande; 
Document doc ;
public GererCommande(IDAOCommande dbCommande,Document doc )
{
	_dbCommande=dbCommande;
}
public Double CalculerRecette(Date date_d, Date date_f) throws ParserConfigurationException {
	Double total = null; 
	List<Commande >commandes=_dbCommande.Get_Commande(doc);
	for (Commande cmd : commandes)
	{
		if (cmd.getDate().after(date_d) && cmd.getDate().before(date_f))
		{
			total+=calculerRecttCmd((List<LigneComm>) cmd.getLigCom());
			
		}
		
	}
	
	return total;
}
public Double calculerRecttCmd(List<LigneComm> LigCom) {
	Double somme=null;
	for (LigneComm lg : LigCom) {
	 somme += Integer.parseInt(lg.getQteComm())*Integer.parseInt(lg.getPrix());	
	}
	return somme;
}
  
 public Commande GetCommande (int idCommande) throws ParserConfigurationException {
		List<Commande >commandes=_dbCommande.Get_Commande(doc);
		for (Commande c : commandes)
		{
			if (c.getId()==idCommande)
				
				 return c;

		}
		return null ;
 }
  }

