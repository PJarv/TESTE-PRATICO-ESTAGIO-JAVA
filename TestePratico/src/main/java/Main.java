import biblioteca.Biblioteca;
import entidades.Aluno;
import entidades.Livro;
import entidades.Professor;
import emprestimo.EmprestarLivroUseCase;
import emprestimo.DevolverLivroUseCase;


public class Main {
    public static void main(String[] args) {

//Exemplos de uso:

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(new Livro(1, "Use Software", 1));
        biblioteca.adicionarLivro(new Livro(2, "Estruturas de Dados", 1));
        biblioteca.adicionarLivro(new Livro(3, "Programando em Java", 1));
        biblioteca.adicionarLivro(new Livro(4, "POO com Java", 1));

        Aluno aluno1 = new Aluno(1, "João", 2);
        Aluno aluno2 = new Aluno(2, "Pedro", 0);
        Professor professor1 = new Professor(1, "Maria");
        Professor professor2 = new Professor(2, "Carlos");

        EmprestarLivroUseCase emprestar = new EmprestarLivroUseCase(biblioteca);
        DevolverLivroUseCase devolver = new DevolverLivroUseCase(biblioteca);

        System.out.print("\n");

        System.out.println("\n- Livros disponíveis antes:");
        for (Livro livro : biblioteca.listarLivrosDisponiveis()) {
            System.out.println(livro);
        }

        System.out.print("\n");

        emprestar.emprestarLivro(1, aluno1);
        emprestar.emprestarLivro(2, professor1);
        emprestar.emprestarLivro(1, professor2);
        emprestar.emprestarLivro(3, aluno2);

        System.out.println("\n- Livros disponíveis depois:");
        for (Livro livro : biblioteca.listarLivrosDisponiveis()) {
            System.out.println(livro);
        }

        System.out.print("\n");

        devolver.devolverLivro(1, aluno1);
        devolver.devolverLivro(3, professor2);

        System.out.println("\n- Livros disponíveis depois da devolução:");
        for (Livro livro : biblioteca.listarLivrosDisponiveis()) {
            System.out.println(livro);
        }
    }
}
