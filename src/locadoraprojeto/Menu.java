package locadoraprojeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * .
 * Classe Menu
 *
 */
public class Menu {

    Scanner tec = new Scanner(System.in);  // Somente String
    Scanner opc = new Scanner(System.in); // Somente Números
    List<Cliente> cadCliente = new ArrayList<>(); // ArrayList Cliente
    List<Carro> cadCarro = new ArrayList<>();  //ArrayList de carros 
    List<Alugar> cadAlugar = new ArrayList<>();  // ArrayList de carros Alugados.
    boolean localizado = false;
    int opcao;
    boolean resposta = false;

    /**
     * Menu com as Funções de Cadastro , Atualização ,Listagem , Remoção e
     * Aluguel  de Carros
     */
    public void exibirMenu() {

        /**
         * ArrayList com 7 Clientes Cadastrados para fins de realizar testes
         */
        cadCliente.add(new Cliente("854.256.255-05", "17550986266", "Elizabeth", 25, "F"));
        cadCliente.add(new Cliente("475.245.265-70", "39448524493", "Pedro", 35, "M"));
        cadCliente.add(new Cliente("256.282.235-15", "67960375327", "Marcio", 35, "M"));
        cadCliente.add(new Cliente("555.412.145-20", "00543168800", "Maria", 18, "F"));
        cadCliente.add(new Cliente("674.446.154-09", "17533927576", "Aldan", 45, "M"));
        cadCliente.add(new Cliente("334.214.634-99", "55276311898", "Dulce", 60, "F"));
        cadCliente.add(new Cliente("214.445.349-59", "73551160583", "Rita", 30, "F"));

        /**
         * ArrayList com 7 Carros cadastrados para fins de realizar testes
         */
        cadCarro.add(new Carro("Gol", "Volkswagen", "Vermelho", 2021, "MAZ-6674"));
        cadCarro.add(new Carro("Voyage", "Volkswagen", "Prata", 2021, "MKZ-3666"));
        cadCarro.add(new Carro("Ranger", "Ford", "Preto", 2022, "AKZ-6374"));
        cadCarro.add(new Carro("SW4", "Toyota", "Preto", 2021, "MYZ-3591"));
        cadCarro.add(new Carro("Mobi", "Fiat", "Vermelho", 2020, "TRZ-6585"));
        cadCarro.add(new Carro("logan", "Renault", "Azul", 2022, "KZZ-6484"));
        cadCarro.add(new Carro("Kwid", "Renault", "Branco", 2022, "ZKI-6667"));

        do {

            System.out.println("*************************************");
            System.out.println("        LOCADORA  SALVADOR           ");
            System.out.println("*************************************");
            System.out.println("*************************************");
            System.out.println("* 1 -  Cadastrar Carro              *");
            System.out.println("* 2 -  Cadastrar Cliente            *");
            System.out.println("* 3 -  Atualizar Carro              *");
            System.out.println("* 4-   Atualizar Cliente            *");
            System.out.println("* 5 -  Alugar Carro                 *");
            System.out.println("* 6 -  Listar Carro                 *");
            System.out.println("* 7 -  Listar Clientes              *");
            System.out.println("* 8 -  Exibir Carros Alugados       *");
            System.out.println("* 9 -  Buscar Cliente               *");
            System.out.println("* 10 - Buscar Carro                 *");
            System.out.println("* 11-  Remover Cliente              *");
            System.out.println("* 12-  Remover Carro                *");
            System.out.println("*************************************");
            System.out.println("* 13-             Sair              *");
            System.out.println("*************************************");
            System.out.print("     Escolha um número do menu:      ");
            try {
                opcao = opc.nextInt();
            } catch (Exception e) {
                
                System.out.println("Opção inválida");

                opc.next();
            }

            switch (opcao) {

                case 1:
                    /**
                     * Realiza o cadastro de novos carros
                     */
                    try {
                        Carro carroCadastro = new Carro();
                        System.out.println("Total de carros cadastrados: " + cadCarro.size());
                        System.out.print("Informe o Modelo: ");
                        carroCadastro.setModelo(tec.nextLine());
                        System.out.print("Informe a Marca: ");
                        carroCadastro.setMarca(tec.nextLine());
                        System.out.print("Informe a Cor: ");
                        carroCadastro.setCor(tec.nextLine());
                        System.out.print("Informe a Placa: ");
                        carroCadastro.setPlaca(tec.nextLine());
                        System.out.print("Informe o Ano: ");
                        carroCadastro.setAno(opc.nextInt());
                        System.out.println("");
                        cadastrarCarro(carroCadastro);
                    } catch (Exception e) {
                        System.out.println("Cadastro não realizado");
                        System.out.println("Tente novamente e preencha com dados válidos");
                        opc.next();
                    }

                    break;

                case 2:
                    /*
                     *Realiza o cadastro de novos clientes
                     */
                    try {
                        Cliente clienteCadastro = new Cliente();
                        System.out.println("Total de clientes cadastrados: " + cadCliente.size());
                        System.out.print("Informe CPF: ");
                        clienteCadastro.setCpf(tec.next());
                        System.out.print("Informe o número de registro CNH: ");
                        clienteCadastro.setCnh(tec.next());
                        System.out.print("Informe o Nome: ");
                        clienteCadastro.setNome(tec.next());
                        System.out.print("Insira a Idade: ");
                        clienteCadastro.setIdade(opc.nextInt());
                        System.out.print("Informe Sexo: ");
                        clienteCadastro.setSexo(tec.next());
                        cadastrarCliente(clienteCadastro);
                    } catch (Exception e) {
                        System.out.println("Cadastro não realizado");
                        System.out.println("Tente novamente e preencha com dados válidos");

                        opc.next();
                    }

                    break;

                case 3:
                    /*
                     * Realiza a atualização de carro com base na placa    
                     */
                    try {
                        System.out.print("Digite a placa do carro: ");
                        if (!atualizarCarro(tec.next())) {
                            System.out.println("***Carro  não encontrado***");
                        }
                    } catch (Exception e) {
                        System.out.println("Atualização não realizada");
                        System.out.println("Preencha com dados válidos");

                        opc.next();
                    }

                    break;

                case 4:
                    /*
                     * Realiza a atualização de carro com base no CPF   
                     */
                    try {
                        System.out.print("Digite o CPF do cliente: ");
                        if (!atualizarCliente(tec.next())) {
                            System.out.println("***CPF não cadastrado***");
                        }
                    } catch (Exception e) {
                        System.out.println("Atualização não realizada");
                        System.out.println("Preencha com dados válidos");

                        opc.next();
                    }

                    break;

                case 5:
                    /*
                     * Realiza o aluguel de um carro com base no CPF e placa
                     */
                    try {
                        System.out.println("Digite o CPF do cliente: ");
                        String cpfCliente = tec.next();
                        System.out.println("Digite a placa do carro: ");
                        String placaCarro = tec.next();
                        System.out.println("***Informe o tipo de carro***");
                        System.out.println(" 1 - Comum");
                        System.out.println(" 2 - Premium");
                        int tipo = opc.nextInt();
                        System.out.println("Informe a quantidade de dias: ");
                        int dias = opc.nextInt();

                        alugarCarro(cpfCliente, placaCarro, dias, tipo);
                    } catch (Exception e) {
                        System.out.println("Falha ao alugar ");
                        System.out.println("Preencha com dados válidos");

                        opc.next();
                    }

                    break;
                case 6:
                    /*
                     *Listagem  de carros cadastrados 
                     */

                    System.out.println("Total de carros cadastrados: " + cadCarro.size());
                    System.out.println("|   Marca    -   Modelo   -    Placa        |");

                    listarCarro();  // chama o  método que realiza a listagem 

                    break;

                case 7:
                    /*
                     *   Lista de clientes cadastrados 
                     */
                    System.out.println("Total de Clientes Cadastrados: " + cadCliente.size());
                    System.out.println("|  CPF                 |  NOME           |  IDADE     |");
                    listarCliente();  // chama método que realiza a listagem 

                    break;
                case 8:
                    /*
                     * Realiza a listagem dos carros alugados
                     */
                    listarAluguel();  // Chama método que realiza a listagem 

                    break;

                case 9:
                    /*
                     * Realiza a busca de cliente através de um de seus atributos
                     */
                    System.out.println("Digite o CPF , CNH ou nome do cliente: ");
                    buscarCliente(tec.next());
                    break;
                case 10:
                    /*
                     * Realiza a busca de um ou de varios carros a depender do atributo utilizado
                     */
                    System.out.println("Digite a Cor , Placa , Marca ou Modelo: ");
                    buscaCarro(tec.nextLine());

                    break;
                case 11:
                    /*
                     *Exclui o cliente cadastrado por CPF
                     */
                    try {
                        System.out.println("Digite o CPF do Cliente: ");
                        removerCliente(tec.nextLine());
                    } catch (Exception e) {
                        System.out.println("Não é possivel prosseguir ");
                        System.out.println("Tente novamente e preencha com dados válidos");

                        opc.next();
                    }
                    break;
                case 12:
                    /*
                     * Exclui o carro cadastrado pela placa
                     */
                    try {
                        System.out.println("Digite a Placa do Carro: ");
                        removerCarro(tec.nextLine());
                    } catch (Exception e) {
                        System.out.println("Não é Possivel Prosseguir ");
                        System.out.println("Tente novamente e preencha com dados válidos");

                        opc.next();
                    }

                    break;
            }

        } while (opcao != 13); //Encerra o programa
    }

    /**
     * Metodo que realiza o cadastro de veiculo, passando a instancia de carro
     * como parametro
     *
     * @exception pode ser gerada uma excessão ao digitar Caracter ao invés de
     * Número
     */
    private void cadastrarCarro(Carro carro) {
        cadCarro.add(carro);
    }

    /**
     * Metodo que realiza o cadastro de cliente, passando a instancia de cliente
     * como parametro
     *
     * @exception pode ser gerada uma excessão ao digitar Caracter ao invés de
     * Número
     */
    private void cadastrarCliente(Cliente cliente) {
        cadCliente.add(cliente);

    }

    /**
     * Realiza a busca de um cleinte a ser atualizado
     *
     * @param cpfpesquisa cpf a ser Pesquisado
     * @exception pode ser gerada uma excessão ao digitar Caracter ao invés de
     * número
     * @return Verdadeiro ou falso como protocolo de confirmação
     */
    private Boolean atualizarCliente(String cpfpesquisa) {
        for (Cliente cliente : cadCliente) {
            if (cpfpesquisa.equals(cliente.getCpf())) {
                cliente.statuscliente();
                System.out.println("Atualizar NOME: ");
                cliente.setNome(tec.next());
                System.out.println("Atualizar IDADE: ");
                cliente.setIdade(opc.nextInt());

                System.out.println("Atualizar CPF: ");
                cliente.setCpf(tec.next());

                System.out.println("Atualizar SEXO: ");
                cliente.setSexo(tec.next());
                return true;
            }

        }

        return false;
    }

    /**
     * Realiza a busca de um carro a ser atualizado
     *
     * @param placapesquisa cpf a ser pesquisado
     * @exception pode ser gerada uma excessão ao digitar Caracter ao invés de
     * Número
     * @return Verdadeiro ou falso como protocolo de confirmação
     */
    private Boolean atualizarCarro(String placapesquisa) {
        for (Carro carro : cadCarro) {

            if (placapesquisa.equals(carro.getPlaca())) {
                carro.detalhes();
                System.out.print("Digite o  Ano: ");
                carro.setAno(opc.nextInt());
                System.out.println("Digite o Modelo: ");
                carro.setModelo(tec.nextLine());
                System.out.println("Digite a Marca: ");
                carro.setMarca(tec.nextLine());
                System.out.println("Digite a Cor: ");
                carro.setCor(tec.nextLine());
                return true;

            }
        }
        return false;
    }

    /**
     * Realiza o aluguel de um carro
     *
     * @param cpfCliente CPF do cliente
     * @param placaCarro Placa do carro
     * @param dias quantidade de dias alugados
     * @param tipo tipo do carro a ser alugado
     * @exception pode ser gerada uma excessão ao digitar Caracter ao invés de
     * Número
     */
    private void alugarCarro(String cpfCliente, String placaCarro, Integer dias, Integer tipo) {
        Cliente clienteAluguel = null;
        Carro carroAluguel = null;
        for (int i = 0; i < cadCliente.size(); i++) {
            if (cpfCliente.equals(cadCliente.get(i).getCpf())) {
                clienteAluguel = cadCliente.get(i);
            }
        }

        if (clienteAluguel != null) {
            for (int i = 0; i < cadCarro.size(); i++) {
                if (placaCarro.equals(cadCarro.get(i).getPlaca())) {
                    carroAluguel = cadCarro.get(i);
                    carroAluguel.setDias(dias);
                    carroAluguel.setTipo(tipo);
                    cadAlugar.add(new Alugar(clienteAluguel, carroAluguel));
                    System.out.println("Aluguel realizado com sucesso!.");

                }

            }
        } else {
            System.out.println("Cliente ou Carro não encontrado.");
        }

    }

    /**
     * Realiza a busca do cliente
     *
     * @param buscarCliente busca o cliente por cpf , nome e cnh
     */
    private void buscarCliente(String buscarCliente) {
        for (Cliente Cliente : cadCliente) {
            if (buscarCliente.equals(Cliente.getCpf()) || buscarCliente.equals(Cliente.getNome()) || buscarCliente.equals(Cliente.getCnh())) {
                Cliente.statuscliente();
                this.localizado = true;

            }
        }

        if (localizado == false) {
            System.out.println("Cliente não encontrado! ");
        }
    }

    /**
     * Realiza a busca do carro
     *
     * @param buscarCarro busca o Carro por Cor , Marca, Modelo e Placa
     */
    private void buscaCarro(String buscarCarro) {
        for (Carro Carro : cadCarro) {
            if (buscarCarro.equals(Carro.getCor()) || buscarCarro.equals(Carro.getMarca())
                    || buscarCarro.equals(Carro.getModelo()) || buscarCarro.equals(Carro.getPlaca())) {

                Carro.detalhes();
                this.localizado = true;

            }
        }
        if (localizado == false) {
            System.out.println("Carro não encontrado! ");
        }

    }

    /**
     * Realiza a listagem de carro alugados e clientes
     */
    private void listarAluguel() {
        for (Alugar Alugar : cadAlugar) {
            Alugar.status();
        }
    }

    /**
     * Realiza a listagem de clientes por ordem alfabética
     */
    private void listarCliente() {
        Collections.sort(cadCliente, new Comparator<Cliente>() {
            public int compare(Cliente p1, Cliente p2) {
                return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
            }
        });

        cadCliente.stream().forEach((Cliente) -> {
            Cliente.listaCliente();
        });
    }

    /**
     * Realiza a Listagem de Carros por ordem alfabética
     */
    private void listarCarro() {
        Collections.sort(cadCarro, new Comparator<Carro>() {
            public int compare(Carro p1, Carro p2) {
                return p1.getMarca().toUpperCase().compareTo(p2.getMarca().toUpperCase());
            }
        });
        for (Carro Carro : cadCarro) {
            Carro.listaCarro();
        }
    }

    /**
     * Realiza a busca do cliente a ser removido
     *
     * @param cpfRemove cpf do cliente a ser removido
     */
    private void removerCliente(String cpfRemove) {
        for (int i = 0; i < cadCliente.size(); i++) {
            Cliente cliente = cadCliente.get(i);
            if (cpfRemove.equals(cliente.getCpf())) {
                cliente.statuscliente();
                this.localizado = true;
                System.out.println("Deseja mesmo remover ?");
                System.out.println(" 1 -SIM");
                System.out.println(" 2 -NÃO");
                do {

                    System.out.println(" Escolha uma opção");
                    int escolha = opc.nextInt();
                    if (escolha == 1) {
                        cadCliente.remove(cliente);
                        System.out.println("Cliente  Removido! ");
                        resposta = true;
                    } else if (escolha == 2) {
                        System.out.println("Operação cancelada");
                        resposta = true;
                    } else {
                        System.out.println("Escolha uma Opção valida ");
                        resposta = false;
                    }
                } while (resposta != true);

            }
        }
        if (localizado == false) {
            System.out.println("Cliente não encontrado");
        }
    }

    /**
     * Realiza a busca do carro a ser removido
     *
     * @param placaRemove Placa do carro a ser removido
     */
    private void removerCarro(String placaRemove) {
        for (int i = 0; i < cadCarro.size(); i++) {
            Carro c = cadCarro.get(i);
            if (placaRemove.equals(c.getPlaca())) {
                c.detalhes();
                this.localizado = true;
                System.out.println("Deseja mesmo remover ?");
                System.out.println(" 1 -SIM");
                System.out.println(" 2 -NÃO");
                do {

                    System.out.println(" Escolha uma opção");
                    int escolha = opc.nextInt();
                    if (escolha == 1) {
                        cadCarro.remove(c);
                        System.out.println("Carro removido! ");
                        resposta = true;
                    } else if (escolha == 2) {
                        System.out.println("Operação cancelada");
                        resposta = true;
                    } else {
                        System.out.println("Escolha uma Opção valida ");
                        resposta = false;
                    }
                } while (resposta != true);

            }

        }
        if (localizado == false) {
            System.out.println("Carro não encontrado");
        }
    }

}
