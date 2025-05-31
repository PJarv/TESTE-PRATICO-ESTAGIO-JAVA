package emprestimo;

import biblioteca.Biblioteca;
import entidades.Aluno;
import entidades.Usuario;
import entidades.Livro;

public class DevolverLivroUseCase {
    private Biblioteca biblioteca;

    public DevolverLivroUseCase(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void devolverLivro(int livroId, Usuario usuario) {
        Livro livro = biblioteca.encontrarLivroPorId(livroId);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (!usuario.equals(livro.getEmprestadoPara())) {
            System.out.println("Livro de ID " + livroId + " não foi emprestado para " + usuario.getNome());
            return;
        }

        livro.setDisponivel(true);
        livro.setEmprestadoPara(null);

        if (usuario instanceof Aluno) {
            ((Aluno) usuario).ganharCredito();
        }

        System.out.println("Livro de ID " + livroId + " devolvido com sucesso.");
    }
}
