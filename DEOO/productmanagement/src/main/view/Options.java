package view;

public enum Options{
    SAIR(0),
    ADICIONAR_PRODUTO(1),
    REMOVER_PRODUTO(2),
    ATUALIZAR_PRODUTO(3),
    LISTAR_PRODUTOS(4);
    private final int value;
    Options(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
