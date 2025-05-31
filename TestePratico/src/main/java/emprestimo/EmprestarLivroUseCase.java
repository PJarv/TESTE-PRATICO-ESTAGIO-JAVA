package emprestimo;

import biblioteca.Biblioteca;
import entidades.Aluno;
import entidades.Usuario;
import entidades.Livro;

public class EmprestarLivroUseCase {
    private Biblioteca biblioteca;

    public EmprestarLivroUseCase(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void emprestarLivro(int livroId, Usuario usuario) {
        Livro livro = biblioteca.encontrarLivroPorId(livroId);
        if (livro == null) {
            System.out.println("Livro de ID " + livroId + " encontrado.");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Livro de ID " + livroId + " indisponível.");
            return;
        }

        if (usuario instanceof Aluno) {
            Aluno aluno = (Aluno) usuario;
            if (aluno.getCreditos() <= 0) {
                System.out.println("Livro de ID " + livroId + " não emprestado (sem créditos)");
                return;
            } else {
                aluno.perderCredito();
            }
        }

        livro.setDisponivel(false);
        livro.setEmprestadoPara(usuario);
        System.out.println("Livro de ID " + livroId + " emprestado com sucesso para " + usuario.getNome());
    }
}
