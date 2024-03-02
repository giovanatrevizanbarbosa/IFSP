package view;

import controller.ProductController;
import dto.ProductDto;

import static view.Options.ADICIONAR_PRODUTO;
import static view.Options.ATUALIZAR_PRODUTO;

public class Menu{
    private ProductController productController;

    public Menu(){
        productController = new ProductController();
    }

    public void run(){
        Options option;
        do{
            option = Utils.menu();

            switch (option){
                case ADICIONAR_PRODUTO:
                    ProductDto productDto = Utils.readProduct(ADICIONAR_PRODUTO);
                    if (productController.save(productDto))
                        Utils.showMessage("Produto salvo com sucesso.");
                    else
                        Utils.showMessage("Erro ao tentar salvar o produto.");
                    break;
                case REMOVER_PRODUTO:
                    int id = Utils.readInteger("ID:.............:");
                    if (productController.deleteById(id))
                        Utils.showMessage("Produto removido com sucesso.");
                    else
                        Utils.showMessage("Erro ao tentar remover produto.");
                    break;
                case ATUALIZAR_PRODUTO:
                    id = Utils.readInteger("ID:.............:");
                    ProductDto newProductDto = Utils.readProduct(ATUALIZAR_PRODUTO);
                    if(productController.updateById(id, newProductDto)){
                        Utils.showMessage("Produto atualizado com sucesso.");
                    }else{
                        Utils.showMessage("Erro ao atualizar produto");
                    }
                    break;
                case LISTAR_PRODUTOS:
                    System.out.println("\nPRODUTOS");
                    for (ProductDto p : productController.getAllProducts()){
                        Utils.showProduct(p);
                    }
                    break;
            }
        }while (option != Options.SAIR);
    }
}
