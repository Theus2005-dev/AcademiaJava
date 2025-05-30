class Ficha {
    private String id;
    private String descricao;

    public Ficha(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() { return id; }
    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "Ficha:" +
                "id: " + id +
                ", descricao: " + descricao;
    }
}
