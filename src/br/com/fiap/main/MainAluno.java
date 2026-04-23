package br.com.fiap.main;

import br.com.fiap.bean.Aluno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class MainAluno {

    public static void main(String[] args) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        Aluno aluno1, aluno2, aluno3, aluno4;
        String auxiliar, nome, nascimento;
        int rm;

        // Instanciando dois objetos com construtor com passagem de parametros
        // Eles são os dois objetos que recebem nossos valores reais
        aluno1 = new Aluno(573977, "Murilo Almeida Rodrigues de Souza", LocalDate.parse("20/02/2008", formatador));
        aluno2 = new Aluno(573620, "Henrique Bonachela de Carvalho Carabante", LocalDate.parse("20/02/2008", formatador));

        // Objetos com entrada do usuário e construtores vazios
        try {
            aluno3 = new Aluno();
            auxiliar = JOptionPane.showInputDialog("Digite o RM do aluno 3:");
            aluno3.setRegistroMatricula(rm = Integer.parseInt(auxiliar));
            nome = JOptionPane.showInputDialog("Digite o nome completo do aluno 3:");
            aluno3.setNomeCompleto(nome);
            nascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno 3 (dd/MM/yyyy):");
            aluno3.setDataDeNascimento(LocalDate.parse(nascimento, formatador));

            aluno4 = new Aluno();
            auxiliar = JOptionPane.showInputDialog("Digite o RM do aluno 4:");
            aluno4.setRegistroMatricula(rm = Integer.parseInt(auxiliar));
            nome = JOptionPane.showInputDialog("Digite o nome completo do aluno 4:");
            aluno4.setNomeCompleto(nome);
            nascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno 4 (dd/MM/yyyy):");
            aluno4.setDataDeNascimento(LocalDate.parse(nascimento, formatador));

            String mensagem = String.format(
                    "Data atual: %s%n%n" +
                            "RM: %d%nNome: %s%nIdade completa: %s%n%n" +
                            "RM: %d%nNome: %s%nIdade completa: %s%n%n" +
                            "RM: %d%nNome: %s%nIdade completa: %s%n%n" +
                            "RM: %d%nNome: %s%nIdade completa: %s",
                    dataAtual.format(formatador),
                    aluno1.getRegistroMatricula(), aluno1.getNomeCompleto(), aluno1.calcularIdadeCompleta(dataAtual),
                    aluno2.getRegistroMatricula(), aluno2.getNomeCompleto(), aluno2.calcularIdadeCompleta(dataAtual),
                    aluno3.getRegistroMatricula(), aluno3.getNomeCompleto(), aluno3.calcularIdadeCompleta(dataAtual),
                    aluno4.getRegistroMatricula(), aluno4.getNomeCompleto(), aluno4.calcularIdadeCompleta(dataAtual)
            );

            JOptionPane.showMessageDialog(null, mensagem, "Dados dos Alunos", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}