package entidades;

public class Aluno extends Usuario {
    private int creditos;

    public Aluno(int id, String nome, int creditos) {
        super(id, nome);
        this.creditos = creditos;
    }

    public int getCreditos() { return creditos; }
    public void perderCredito() { creditos--; }
    public void ganharCredito() { creditos++; }
}
