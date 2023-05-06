package listaLigada;

import javax.swing.JOptionPane;

public class ListaLigada{
    static No inicio = null;
    public static void main(String[] args) {
        int op, x;
        String op1[] = {"Inserir valor", "Inserir valor ordenado","Remover último valor", "Exibir lista", "Sair"};
        
        do {
            op = JOptionPane.showOptionDialog(null, "O que você deseja fazer?", "Selecione uma opção", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, op1, 0);

            switch(op) {
                case 0:
                    x = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor", null, JOptionPane.INFORMATION_MESSAGE));
                    inserir(x);
                    break;

                case 1:
                    x = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor", null, JOptionPane.INFORMATION_MESSAGE));
                    insereOrdenado(x);
                    break;

                case 2:
                    removerUltimo();
                    break;

                case 3:
                    System.out.println("---------------------------------------------------");
                    exibir();
                    break;
            }
        }while(op != 4);
    }

    public static void inserir(int x) {
        No novo = new No(x);

        if(inicio == null) {
            inicio = novo;
        
        }else if(inicio.proximo == null){
            inicio.proximo = novo;
        
        }else {
            No temp = inicio;

            while(temp.proximo != null) {
                temp = temp.proximo;
            }

            temp.proximo = novo;
        }
    }

    public static void insereOrdenado(int x) {
        No novo = new No(x);

        if(inicio == null) {
            inicio = novo;
        
        }else {
            if(inicio.valor > novo.valor) {
                novo.proximo = inicio;
                inicio = novo;
            
            }else {
                No temp = inicio;

                while((temp.proximo != null) && (temp.proximo.valor < x)) {
                    temp = temp.proximo;
                }

                if(temp.proximo == null) {
                    temp.proximo = novo;
                
                }else {
                    novo.proximo = temp.proximo;
                    temp.proximo = novo;
                }
            }
        }
    }

    public static void exibir(){
        No temp = inicio;

        if(inicio == null) {
            System.out.println("Lista vazia!");
        
        }else {
            while(temp.proximo != null) {
                System.out.println(temp.valor);
                temp = temp.proximo;
            }
    
            System.out.println(temp.valor);
        }
    }

    public static void removerUltimo() {
        No temp = inicio;

        if(inicio == null) {
            System.out.println("Lista vazia!");
        
        }else if(inicio.proximo == null) {
            inicio = null;
        
        }else {
            while(temp.proximo.proximo != null) {
                temp = temp.proximo;
            }
    
            System.out.println("--------- Removendo o " + temp.proximo.valor + " ------------");
            temp.proximo = temp.proximo.proximo;
        }
       
    }
}