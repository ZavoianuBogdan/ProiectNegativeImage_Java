package main;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import A.Imagine;
import B.Imagine2;


public class MainClass {
	
	public static void main(String[] args) {
	
		//definirea variabilelor auxiliare
		Scanner s = new Scanner(System.in);
		boolean exists=false;
		String numePoza=new String();
		String formatIn=new String();
		String pathIn=new String();
		String metoda = new String();
		
		//incepe citirea pozei
		while(!exists) {
			System.out.println("Introduceti PATH-ul catre Folder-ul ce contine poza de intrare");
			pathIn = s.nextLine();
			System.out.println("Introduceti numele pozei asupra careia se va face prelucrarea: ");
			numePoza = s.nextLine();
			System.out.println("Introduceti formatul pozei de intrare : ");
			formatIn = s.nextLine();
			//odata ce am aflat toate detaliile despre poza pe care se doreste sa se efectueze prelucrarea
			//	incercam sa o deschidem, pentru a vedea daca exista si informam despre reusita acestei operatii
			try {
				File tempFile = new File(pathIn+"\\"+numePoza+"."+formatIn);
				exists = tempFile.exists();
				if(!exists)
					System.out.println("Fisier inexistent! Va rog, incercati din nou!");
				else
					System.out.println("Fisier citit cu succes");
			}catch(Exception e) {
	        	System.out.println(e);
				
			}
		}

		//incepe setarea pozei rezultate
		System.out.println("Introduceti denumirea dorita pentru poza rezultata: ");
		String rezultat = s.nextLine();
		System.out.println("Introduceti PATH-ul catre Folder-ul in care se doreste salvarea rezultatului:");
		pathIn = s.nextLine();
		
		//setarea metodei de lucru
		System.out.println("Pentru Metoda 1 tastati \"1\" , sau pentru Metoda 2 tastati \"2\"");
		metoda = s.nextLine();
		

		if(metoda.equals("1")) {
			//s-a ales metoda 1 si vom incerca sa prelucram cu ea
			try {
				//abordarea metodei 1
				final long start = System.currentTimeMillis();
				//temporizarea fiecarei actiuni e facuta folosind System.currentTimeMillis()
				
				//citirea pozei
				long startTime1 = System.currentTimeMillis();
				Imagine poza=new Imagine(numePoza+"."+formatIn);
				long endTime1 = System.currentTimeMillis();
				
				//calculam timpul de executie pentru fiecare dintre aceste cerinte
				System.out.println("\nPentru citirea pozei, timpul de executie a fost : " + (endTime1 - startTime1)+" ms\n");
	
				//prelucrarea pozei
				startTime1 = System.currentTimeMillis();
				poza.prelucrare(rezultat+"."+formatIn,pathIn);
				endTime1 = System.currentTimeMillis();
				System.out.println("\nPentru prelucrarea pozei & scriere, timpul de executie a fost : " + (endTime1 - startTime1)+" ms\n");
				
				//calculul timpului total de executie
				final long end = System.currentTimeMillis();
				System.out.println("\nTimpul TOTAL de executie a fost : " + (end - start)+" ms\n");
				
				//setarea preferintei legate de statistica intensitatii culorii din poza folosind metoda procentCulori()
				System.out.println("Doriti procentajul de intensitate al tuturor culorilor din poza? (D = DA, orice altceva = NU) :");
				String da = s.nextLine();
				
				//extinderea setarilor si optiunilor posibile legate de statistica intensitatii culorii din poza
				if(da.equals("D"))
				{
					poza.procentCulori("R","G","B");
					System.out.println("Acesta a fost finalul programului!");
				}
				else {
					System.out.println("Doriti procentajul de intensitate al culorii Rosu din poza? (D = DA, orice altceva = NU) :");
					da = s.nextLine();
					if(da.equals("D"))
					{
						poza.procentCulori("R");
						System.out.println("Acesta a fost finalul programului!");
					}
					else {
						System.out.println("Doriti procentajul de intensitate al tuturor culorii Verde din poza? (D = DA, orice altceva = NU) :");
						da = s.nextLine();
						if(da.equals("D"))
						{
							poza.procentCulori("G");
							System.out.println("Acesta a fost finalul programului!");
						}
						else {
							System.out.println("Doriti procentajul de intensitate al tuturor culorii Albastru din poza? (D = DA, orice altceva = NU) :");
							da = s.nextLine();
							if(da.equals("D"))
							{
								poza.procentCulori("B");
								System.out.println("Acesta a fost finalul programului!");
							}
							else {
								System.out.println("Acesta a fost finalul programului!");
							}
						}
					}
				}
				
				s.close();
			//in cazul in care au fost intalnite exceptii pe parcursul executiei, notificam utilizatorul sa reincerce
			}catch(Exception E) {
				System.out.println("Metoda a esuat, va rugam incercati din nou!");
			}
		}
		else{
			try {
				//abordarea este identica cu prima metoda, singura diferenta fiind clasele folosite
				//vezi comentariile de mai sus
				final long start = System.currentTimeMillis();
				
				//citirea pozei
				long startTime2 = System.currentTimeMillis();
				Imagine2 poza1=new Imagine2(numePoza+"."+formatIn);
				long endTime2 = System.currentTimeMillis();
				System.out.println("\nPentru citirea pozei, timpul de executie a fost : " + (endTime2 - startTime2)+" ms\n");
				
				//prelucrarea pozei
				startTime2 = System.currentTimeMillis();
				poza1.prelucrare(rezultat+"."+formatIn,pathIn);
				endTime2 = System.currentTimeMillis();
				System.out.println("\nPentru prelucrarea pozei, timpul de executie a fost : " + (endTime2 - startTime2)+" ms\n");
				
				//calculul timpului total de executie
				final long end = System.currentTimeMillis();
				System.out.println("\nTimpul TOTAL de executie a fost : " + (end - start)+" ms\n");
				
				System.out.println("Doriti procentajul de intensitate al culorilor din poza? (D = DA, orice altceva = NU) :");
				String da = s.nextLine();
				
				if(da.equals("D"))
				{
					poza1.procentCulori();
				}
				else
					System.out.println("Acesta a fost finalul programului!");
				
				s.close();
			}catch(Exception E) {
				System.out.println("Metoda a esuat, va rugam incercati din nou!");
			}
		}

		
	}
}
