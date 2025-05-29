class Aluno {
    private String id;
    private String nome;
    private int idade;
    private Plano plano;
    private Ficha ficha;

    public Aluno(String id, String nome, int idade, Plano plano) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.plano = plano;
        this.ficha = null;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public Plano getPlano() { return plano; }
    public Ficha getFicha() { return ficha; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setPlano(Plano plano) { this.plano = plano; }
    public void setFicha(Ficha ficha) { this.ficha = ficha; }

    @Override
    public String toString() {
        return "Aluno: " +
                "Id: " + id +
                " Nome: " + nome +
                ", Idade: " + idade +
                ", Plano: " + (plano != null ? plano.getNome() : "Nenhum");
    }
}
