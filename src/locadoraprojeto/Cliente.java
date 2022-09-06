package locadoraprojeto;

/**
 * Classe Cliente 
 */
public class Cliente {
    /**
     * Atributos da Classe Cliente
     */
    private String nome;
    private String sexo;
    private Integer idade;
    private String cpf;
    private String cnh;

    /**
     * Constutor que realiza o cadastro do cliente com parametros definidos
     *
     * @param cpf cpf do Cliente
     * @param cnh cnh do Cliente
     * @param nome nome do Cliente
     * @param idade idade do Cliente
     * @param sexo sexo do Cliente
     */
    public Cliente(String cpf, String cnh, String nome, Integer idade, String sexo) {
        this.cpf = cpf;
        this.cnh = cnh;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;

    }

    /**
     * Constutor padrão default
     */

    public Cliente() {
    }

    /**
     * Metodo que exibe os dados do cliente com 5 atributos
     */
    public void statuscliente() {

        System.out.print("Nome: " + this.getNome());
        System.out.print("  Idade: " + this.getIdade());
        System.out.print("  Cpf: " + this.getCpf());
        System.out.print("  CNH: " + this.getCnh());
        System.out.print("  Sexo: " + this.getSexo());
        System.out.println("");

    }

    /**
     * Metodo que exibe os dados do cliente com 3 atributos de forma tabular
     */
    public void listaCliente() {

        System.out.printf("   " + this.getCpf() + "         " + this.getNome() + "                 "
                + this.getIdade() + "     ");

        System.out.println(" ");

    }

    // métodos Getters e Setters 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

}
