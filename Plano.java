class Plano {
    private String id;
    private String nome;
    private String tipo;
    private double preco;
    private boolean ativo;

    public Plano(String id, String nome, String tipo, double preco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.ativo = ativo;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public double getPreco() { return preco; }
    public boolean isAtivo() { return ativo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    @Override
    public String toString() {
        return "Plano: " +
                "id: " + id +
                ", nome: " + nome +
                ", tipo: " + tipo +
                ", preco: " + preco +
                ", ativo: " + ativo;
    }
}