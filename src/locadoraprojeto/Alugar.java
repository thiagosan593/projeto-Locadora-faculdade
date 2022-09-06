
package locadoraprojeto;

/**
Classe de Relacionamento entre Cliente e Carro
*/
public class Alugar  {  
    private Cliente cliente;
    private Carro carro;

   
    
    
   /**
    * Constutor 
    * @param cliente
    * @param carro 
    */
    public Alugar(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
    }

 
    /**
     * Metodo que exibe as informações de veiculo e cliente que  alugou e o valor a pagar
     */
    public void status(){    //informações de veiculo e cliente que  alugou 
        System.out.println("Carro Alugado para ");
        System.out.println("-------------------------------------------------------------");
        this.cliente.statuscliente();
        System.out.println("");
        this.carro.detalhes();  //solicita a classe carro infomações do veiculo Alugado
        System.out.println("Valor a pagar R$: " + this.carro.getPagamento());
        System.out.println("-------------------------------------------------------------");
       
       
        
       
        
        
       
                
    }
   /*
    *Métodos getters e setters 
    */
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }


    
    
    
}
