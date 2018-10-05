package startover03oct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//1st QUERY - FIND BASIC PATIENT INFO
		System.out.print("REQUETE 1. Informations Basiques sur un patient \n=> Saisir un numéro de patient (ie. 101614) : ");
		Scanner sc1 = new Scanner(System.in);

		
		while (!sc1.hasNextInt()) sc1.next();  //accept int only
		int userNumPat1 = sc1.nextInt();  //store it as an int
		
		System.out.println(" \n \n \t====== INFORMATIONS PATIENT NUM : " + userNumPat1 + " =======\n");
		
		DAO<Patient> ptdao = new PatientDAO(null);
		Patient pt1 = ptdao.findByNum(userNumPat1);
		System.out.println("\t" + pt1.toString());
		
		
		// 2ND QUERY PATIENT INFO AND PATIENT HOSPITALISATIONS
		System.out.println("\n \t********************************\n");
		
		System.out.print("REQUETE 2. Hospitalisations et actes d'un patient \n=> Saisir un numéro de patient (ie. 227832) : ");
		Scanner sc2 = new Scanner(System.in);

		
		while (!sc2.hasNextInt()) sc2.next();  //accept int only
		int userNumPat2 = sc2.nextInt();  //store it as an int
		
		Patient pt2 = ptdao.findByNum(userNumPat2);
		
		System.out.println("\n\t======PATIENT======");
		System.out.println("\t" + pt2.toString());
		
		System.out.println("\n\t====HOSPITALISATION(S)=====");
		System.out.println(pt2.listHospi.toString());   // print out hospitalisations list
		
		System.out.println("\n\t=====ACTES======");
		for (int i=0; i<pt2.listHospi.size(); i++) {  //print out list of actes of each hospitalisation here. 
			System.out.println("\n \n \t ----- \n \t Actes de Hospitalisation Num " + pt2.listHospi.get(i).numHospi + " : ");
			for(Acte a : pt2.listHospi.get(i).listActe)  {
				
				 System.out.println("\t * " + a.toString());
				 
				 if (pt2.listHospi.get(i).listActe.isEmpty()) {
						System.out.println("\tAucun acte pour hospitalisation Num " + pt2.listHospi.get(i).numHospi  + ".");
					}
				 
			}
			
			
		};
		
		
		//System.out.println(pt2.listHospi.get(0).listActe.toString());
		
		
		//3RD QUERY. FIND ACTES
		System.out.println("\n\t********************************\n");
		
		System.out.print("REQUETE 3 \n(Exercice pour les Getter/Setter) \n\n => Pour récupérer la date d'acte, saisir un numero d'acte (ie. 9215665) : ");
		Scanner sc3 = new Scanner(System.in);

		
		while (!sc3.hasNextInt()) sc3.next();  //accept int only
		int userNumActe = sc3.nextInt();  //store it as an int
		

		DAO<Acte> actedao = new ActeDAO(null);
		Acte acte = actedao.findByNum(userNumActe);
		System.out.println("\n \n \n \tDate de l'acte num " + userNumActe + " : " + acte.getDateActe().toString());

		
		System.out.println("\n\t********************************\n");
		
		
		
	}
}
