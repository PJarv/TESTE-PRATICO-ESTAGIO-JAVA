import biblioteca.Biblioteca;
import entidades.Aluno;
import entidades.Livro;
import emprestimo.EmprestarLivroUseCase;
import emprestimo.DevolverLivroUseCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private Aluno aluno;
    private EmprestarLivroUseCase emprestar;
    private DevolverLivroUseCase devolver;

    @BeforeEach
    public void setup() {
        biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(new Livro(1, "Livro 1", 1));
        aluno = new Aluno(1, "Aluno 1", 1);
        emprestar = new EmprestarLivroUseCase(biblioteca);
        devolver = new DevolverLivroUseCase(biblioteca);
    }

    @Test
    public void testEmprestarLivroAlunoComCredito() {
        emprestar.emprestarLivro(1, aluno);
        assertEquals(0, aluno.getCreditos());
    }

    @Test
    public void testEmprestarLivroAlunoSemCredito() {
        aluno.perderCredito();
        emprestar.emprestarLivro(1, aluno);
        assertNull(biblioteca.encontrarLivroPorId(1).getEmprestadoPara());
    }

    @Test
    public void testDevolverLivroAluno() {
        emprestar.emprestarLivro(1, aluno);
        devolver.devolverLivro(1, aluno);
        assertEquals(1, aluno.getCreditos());
        assertTrue(biblioteca.encontrarLivroPorId(1).isDisponivel());
    }
}
