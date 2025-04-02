package pilhajava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PilhaJava {

    static Scanner leia = new Scanner(System.in);
                
    private static int menu() {
        System.out.println("\n--- Menu Pilha ---");
        System.out.println("0. Sair;");
        System.out.println("1. Inserir elemento;");
        System.out.println("2. Remover elemento;");
        System.out.println("3. Mostrar topo;");
        System.out.println("4. Mostrar pilha.");
        System.out.printf("\nDigite a opção desejada:" );
    	return leia.nextInt();
	}

    // leiaRecorde
    public static void lerRecorde(record recorde) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Digite o nome do atleta: ");
          recorde.setNome(scanner.nextLine());
 
          System.out.println("Digite a data do recorde (dd/MM/yyyy): ");
          String dataStr = scanner.nextLine();
          LocalDate dataFormatada = LocalDate.parse(dataStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          recorde.setDataRecord(dataFormatada) ;
          System.out.println("Digite o tempo do recorde (em segundos): ");
          recorde.setTempo(scanner.nextDouble());
    }

    
    public static void main(String[] args) {
        
        int opcao, dado;
        System.out.println("Tamanho da pilha: ");
        int tamanho = leia.nextInt();
        Pilha <record> minhaPilha = new Pilha(tamanho);
        
        do {
            opcao = menu();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    if (!minhaPilha.isFull()){
                        record novoRecord = new record();
                        System.out.println("\nDado: ");
                        // ler dados do record
                        lerRecorde(novoRecord);
                        if (!minhaPilha.isEmpty()) {
                            if(novoRecord.getTempo() > minhaPilha.peek().getTempo()){
                                minhaPilha.push(novoRecord); 
                                System.out.println("Dado inserido com sucesso!"); 
                            }
                        }

                    }
                    else {
                        System.out.println("\nA pilha está cheia!\nNAO é possível inserir mais dados no momento, tente remover um dado primeiro.");
                    }
                    break;
                case 2:
                    if (!minhaPilha.isEmpty()){
                        System.out.println("Topo removido.");
                        minhaPilha.pop(); 
                    }
                    else {
                        System.out.println("\nPilha vazia, tente adicionar elementos antes de removê-los!");
                    }
                    break;
                case 3:
                    System.out.println(minhaPilha.peek());
                    break;
                case 4:
                    System.out.println(minhaPilha);
                    break;
            }//fim switch
            leia.nextLine(); //pause
        }while(opcao != 0);
               
    }
    
}
