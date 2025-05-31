package entidades;

public class Livro {
    private int id;
    private String titulo;
    private int valorCredito;
    private boolean disponivel;
    private Usuario emprestadoPara;

    public Livro(int id, String titulo, int valorCredito) {
        this.id = id;
        this.titulo = titulo;
        this.valorCredito = valorCredito;
        this.disponivel = true;
        this.emprestadoPara = null;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getValorCredito() { return valorCredito; }
    public boolean isDisponivel() { return disponivel; }
    public Usuario getEmprestadoPara() { return emprestadoPara; }

    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setEmprestadoPara(Usuario usuario) { this.emprestadoPara = usuario; }

    @Override
    public String toString() {
        return "Livro de ID " + id + ": " + titulo + ", disponível: " + disponivel;
    }
}
