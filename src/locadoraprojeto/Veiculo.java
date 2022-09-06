package locadoraprojeto;
/**
Classe Abstrata de Veiculo
*/
public abstract class Veiculo {

    private String modelo;
    private String Marca;
    private String cor;
    private String placa;
    private Integer ano;

    /**
     * Constutor que realiza o cadastro do cliente
     *
     * @param modelo Modelo do carro
     * @param Marca Marca do carro
     * @param cor Cor do carro
     * @param ano Ano do carro
     * @param placa Placa do carro
     */
    public Veiculo(String modelo, String Marca, String cor, int ano, String placa) {

        this.modelo = modelo;
        this.Marca = Marca;
        this.cor = cor;
        this.ano = ano;
        this.placa = placa;

    }

    /**
     *Constutor Padrão 
     */
    public Veiculo() {
    }
    /*
    * Métodos getter e setters 
    */
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo que exibe os dados do cliente com 5 atributos
     */
    public void detalhes() {
        System.out.print("Placa : " + this.getPlaca());
        System.out.print("  Modelo: " + this.getModelo());
        System.out.print("  Cor: " + this.getCor());
        System.out.print("  Marca: " + this.getMarca());
        System.out.print("  Ano: " + this.getAno());
        System.out.println("");

    }

    /**
     * Metodo que exibe os dados do carro com 3 atributos de forma tabular
     */
    public void listaCarro() {     //  Lista os carros em tabulação

        System.out.println("---------------------------------------------");
        System.out.println(this.getMarca() + "    -     " + this.getModelo() + "   -   " + this.getPlaca());

    }

}
