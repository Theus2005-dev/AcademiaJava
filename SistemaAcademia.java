import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademia {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Plano> planos = new ArrayList<>();

    public static void main(String[] args) {

        planos.add(new Plano("p1", "Básico", "Mensal", 100, true));
        planos.add(new Plano("p2", "Premium", "Anual", 1000, true));

        while(true) {
            System.out.println("\n=== Sistema Academia ===");
            System.out.println("1. Entrar como Administrador");
            System.out.println("2. Entrar como Instrutor");
            System.out.println("3. Entrar como Aluno");
            System.out.println("4. Sair");
            String opcao = scanner.nextLine();

            switch(opcao) {
                case "1": menuAdministrador(); break;
                case "2": menuInstrutor(); break;
                case "3": menuAluno(); break;
                case "4": System.out.println("Saindo..."); return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    static void menuAdministrador() {
        while(true) {
            System.out.println("\n--- Menu Administrador ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Modificar aluno");
            System.out.println("3. Excluir aluno");
            System.out.println("4. Cadastrar plano");
            System.out.println("5. Modificar plano");
            System.out.println("6. Excluir plano");
            System.out.println("7. Consultar alunos");
            System.out.println("8. Consultar planos");
            System.out.println("9. Voltar");
            String opc = scanner.nextLine();

            switch(opc) {
                case "1": cadastrarAluno(); break;
                case "2": modificarAluno(); break;
                case "3": excluirAluno(); break;
                case "4": cadastrarPlano(); break;
                case "5": modificarPlano(); break;
                case "6": excluirPlano(); break;
                case "7": consultarAlunos(); break;
                case "8": consultarPlanos(); break;
                case "9": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    static void menuInstrutor() {
        while(true) {
            System.out.println("\n--- Menu Instrutor ---");
            System.out.println("1. Criar/Atualizar ficha de treino do aluno");
            System.out.println("2. Voltar");
            String opc = scanner.nextLine();

            switch(opc) {
                case "1": criarOuAtualizarFicha(); break;
                case "2": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    static void menuAluno() {
        System.out.println("Digite seu ID:");
        String id = scanner.nextLine();
        Aluno aluno = buscarAlunoPorId(id);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("\nBem vindo, " + aluno.getNome());
        System.out.println("Seu plano contratado:");
        if(aluno.getPlano() != null)
            System.out.println(aluno.getPlano());
        else
            System.out.println("Nenhum plano contratado.");

        System.out.println("Sua ficha de treino:");
        if(aluno.getFicha() != null)
            System.out.println(aluno.getFicha());
        else
            System.out.println("Nenhuma ficha atribuída.");
    }

    static void cadastrarAluno() {
        System.out.println("ID do aluno:");
        String id = scanner.nextLine();
        if (buscarAlunoPorId(id) != null) {
            System.out.println("Aluno com esse ID já existe.");
            return;
        }
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Idade:");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha o plano pelo ID:");
        listarPlanos(true);
        String planoId = scanner.nextLine();
        Plano plano = buscarPlanoPorId(planoId);
        if(plano == null) {
            System.out.println("Plano não encontrado, cadastro cancelado.");
            return;
        }

        Aluno aluno = new Aluno(id, nome, idade, plano);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    static void modificarAluno() {
        System.out.println("ID do aluno a modificar:");
        String id = scanner.nextLine();
        Aluno aluno = buscarAlunoPorId(id);
        if(aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        System.out.println("Novo nome:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Nova idade:");
        aluno.setIdade(Integer.parseInt(scanner.nextLine()));

        System.out.println("Escolha o novo plano pelo ID:");
        listarPlanos(true);
        String planoId = scanner.nextLine();
        Plano plano = buscarPlanoPorId(planoId);
        if(plano != null) aluno.setPlano(plano);

        System.out.println("Aluno modificado.");
    }