package locadoraprojeto;

/**
 *
 * Classe Carro e herdeira da Classe Veiculos
 */
public class Carro extends Veiculo {

    /**
     * Atributos da Classe Carro
     */
    private Integer tipo;
    private Integer dias;
    private Integer pagamento;

    /**
     * Constutor que realiza o cadastro de um carro com parametros definidos
     *
     * @param modelo Modelo do Carro
     * @param Marca Marca do carro
     * @param cor Cor do Carro
     * @param ano Ano do Carro
     * @param placa Placa do Carro
     */
    public Carro(String modelo, String Marca, String cor, int ano, String placa) {
        super(modelo, Marca, cor, ano, placa);
    }

    /**
     * Constutor padrão default
     */
    public Carro() {
    }

   // Métodos Getteres e Setters 
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * Metodo que Calcula o pagamento do Carro
     * @return  o valor a ser pago 
     */
    public int getPagamento() {
        if (this.tipo == 1) {
            this.pagamento = this.dias * 90;
        } else if (this.tipo == 2) {
            this.pagamento = this.dias * 120;
        }
        return pagamento;
    }

    /**
     * Metodo que Exibira o pagamento do Carro
     */
    public void pagamento() {
        System.out.println("Valor a pagar R$: ");
        System.out.print(this.getPagamento());
    }

}
