package listasLigadasSimples;

import javax.swing.JOptionPane;

public class ListasLigadasSimples {
    static No inicio = null;
    static No fim = null;
    static int topo = 0;
    
    public static void main(String[] args) {
        String op[] = {"Empilhar", "Desempilhar", "Exibir pilha e informações", "Enfileirar", "Desenfileirar", "Exibir fila e informações", "Sair"};
        int op1, x, tamanho;
        
        tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tamanho da lista", null));
        
        do {
            op1 = JOptionPane.showOptionDialog(null, "O que você deseja fazer?", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, 0);

            switch(op1) {
                case 0:
                    x = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor", null));
                    empilhar(x, tamanho);
                    break;

                case 1:
                    desempilhar();
                    break;

                case 2:
                    System.out.println("\n-------- Pilha gerada ---------");
                    exibeInverso(inicio);
                    System.out.println("---------------------------");
                    topo();

                    System.out.println("Pilha vazia: " + vazia());
                    System.out.println("Pilha cheia: " + cheia(tamanho));
                    System.out.println("Tamanho da pilha: " + tamanho());
                    break;

                case 3:
                    x = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor", null));
                    enfileirar(x);
                    break;
                    
                case 4:
                    desenfileirar();
                    break;

                case 5:
                    System.out.println("\n------ Fila gerada -------");
                    exibe();
                    System.out.println("---------------------------");

                    System.out.println("Cabeça da fila: " + cabeca());
                    System.out.println("Cauda da fila: " + cauda());
                    System.out.println("Fila vazia: " + filaVazia());
                    System.out.println("Fila cheia: " + filaCheia(tamanho));
                    System.out.println("Tamanho da fila: " + tamanhoFila());

                    break;
            }

        }while(op1 != 6);        
    }

    private static void insereInicio(int x) {
        No novo = new No(x);

        if(inicio == null) {
            inicio = novo;
        
        }else{
            novo.proximo = inicio;
            inicio = novo;
        }

        topo = inicio.valor;
    }
    
    private static void insereFim(int x) {
        No novo = new No(x);

        if(inicio == null) {
            inicio = novo;
        
        }else {
            No temp = inicio;

            while(temp.proximo != null) {
                temp = temp.proximo;
            }

            temp.proximo = novo;
        }

        topo = inicio.valor;
    }
    
    private static void removeInicio() {
        if(inicio == null) {
            System.out.println("Lista vazia!");
        
        }else if(inicio.proximo == null) {
            inicio = null;

        }else {
            inicio = inicio.proximo;
        }
    }
    
    private static void removeFim() {
        if(inicio == null) {
            System.out.println("Lista vazia!");
        
        }else if(inicio.proximo == null) {
            inicio = null;
        
        }else {
            No temp = inicio;

            while(temp.proximo.proximo != null) {
                temp = temp.proximo;
            }

            temp.proximo = null;
        }

        if(inicio != null) {
            topo = inicio.valor;
        
        }else {
            topo = 0;
        }
    }
    
    private static void exibe() {
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
    
    private static void exibeInverso(No temp) {
        if(inicio == null) {
            System.out.println("Lista vazia!");
        
        }else {
            if(temp != null) {
                exibeInverso(temp.proximo);
                System.out.println(temp.valor);
            }
        }
    }

    //----- PILHA -----
    public static void empilhar(int x, int tamanho) {
        if(!cheia(tamanho)) {
            insereFim(x);

        }else {
            System.out.println("Pilha cheia! Impossível empilhar!");
        }
    }

    public static void desempilhar() {
        if(!vazia()) {
            removeFim();
        }else {
            System.out.println("\nPilha vazia! Impossível desempilhar");
        }
    }

    public static void topo() {
        System.out.println("Topo: " + topo);
    }

    public static boolean vazia() {
        if(inicio == null) {
            return true;
        
        }else {
            return false;
        }
    }

    public static boolean cheia(int tamanho) {
        int ct = 0;
        No temp = inicio;

        while(temp != null) {
            ct++;
            temp = temp.proximo;
        }

        if(ct < tamanho) {
            return false;
        
        }else {
            return true;
        }
    }

    public static int tamanho() {
        int ct = 0;
        No temp = inicio;

        while(temp != null) {
            ct++;
            temp = temp.proximo;
        }

        return ct;
    }

    //----- FILA -----
    public static void enfileirar(int x) {
        insereInicio(x);
    }

    public static void desenfileirar() {
        if(!filaVazia()) {
            removeInicio();

        }else {
            System.out.println("Fila vazia! Impossível desenfileirar!");
        }
    }

    public static int cabeca() {
        if(!filaVazia()) {
            No temp = inicio;

            while(temp.proximo != null) {
                temp = temp.proximo;
            }
    
            return temp.valor;   
        
        }else {
            return 0;
        }
    }

    public static int cauda() {
        if(!filaVazia()) {
            return inicio.valor;

        }else {
            return 0;
        }
    }

    public static boolean filaVazia() {
        if(inicio == null) {
            return true;
        
        }else {
            return false;
        }
    }

    public static boolean filaCheia(int tamanho) {
        No temp = inicio;
        int ct = 0;

        while(temp != null) {
            ct++;
            temp = temp.proximo;
        }

        if(ct == tamanho) {
            return true;

        }else {
            return false;
        }
    }

    public static int tamanhoFila() {
        No temp = inicio;
        int ct = 0;

        while(temp != null) {
            ct++;
            temp = temp.proximo;
        }

        return ct;
    }
}