import java.util.Scanner;
import java.io.IOException;

class Console {

    public static void clear(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}

class ContaBancaria {
    
  static double saldo;  
  
  public static void topo() throws IOException, InterruptedException{
	  Console console = new Console();
	  
	  console.clear();
	  
	  System.out.println("+--------------------------------------------------------+");
	  System.out.println("|--------------------------------------------------------|");
	  System.out.println("|--------------------- Banco JGP ------------------------|");
	  System.out.println("|--------------------------------------------------------|");
	  System.out.println("+--------------------------------------------------------+");
  }
  
  public static void pressioneParaMenu() throws IOException, InterruptedException{
	  System.out.print("\nPressione ENTER para voltar ao menu principal.");
	  System.in.read();
  }
  
  public static boolean validarSangria(double valor){    
   
    if(valor > saldo){
      return false;
    }
    
    return true;
  }
  
  public static void reforcoSaldo(double valor){
    saldo = saldo + valor;
  }
    
  public static void depositar()throws IOException, InterruptedException {
    
      Scanner teclado = new Scanner(System.in);   
	  
	  topo();
	  
      double valor;
      
      System.out.print("\nQual valor voce deseja depositar?\n\n");
      
      valor = teclado.nextDouble();
      
      reforcoSaldo(valor);  

     pressioneParaMenu();   
	 
	 menu();
   
  }
  
   public static double sacar() throws IOException, InterruptedException{
	   
       Scanner teclado = new Scanner(System.in);  
	
	   topo();
	
       double valor;
  
       System.out.print("\nQual valor voce deseja sacar?\n\n");
	 
      valor = teclado.nextDouble();
	  
	       
	  
	        if(validarSangria(valor) == false){
        System.out.print("\nSaldo insuficiente!\n");
			pressioneParaMenu();
			menu();
			}
	  
      saldo = saldo - valor;
		
		
		pressioneParaMenu();
		menu();
		
    return saldo;
  } 
  
  public static double exibirSaldo() throws IOException, InterruptedException{
      	  
		  topo();
		  
    System.out.printf("\nSaldo: R$%f \n",saldo);

pressioneParaMenu();
menu();

    return saldo;
  }
  
  public static void menu()throws IOException, InterruptedException {
    Scanner teclado = new Scanner(System.in);   
    Console console = new Console();

    console.clear();
	  
	     int opcao;
 	  
  topo();
  
    System.out.print("|------------ Por favor selecione uma opcao: ------------|\n");
    System.out.println("|--------------------------------------------------------|");
    System.out.print("|[1] Depositar | [2] Sacar | [3] Exibir saldo | [4] Sair!|\n");
	System.out.println("+--------------------------------------------------------+\n");
    
    opcao = teclado.nextInt();       
    
    switch (opcao) {
      case 1:
      depositar();
      break;

      case 2:
      sacar();
      break;

      case 3:
      exibirSaldo();
      menu();
      break;

      case 4:
      System.exit(0);
      break;

    default:
      System.out.printf("Insira uma opção válida");
      main(null);
    }
    
  }
  

	public static void main(String args[]) throws IOException, InterruptedException {  

    saldo = 0;

    menu();    
      
    System.exit(0);
		
	}

}