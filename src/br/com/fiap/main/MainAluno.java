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

        try {
            Aluno aluno1 = new Aluno();
            aluno1.setRegistroMatricula(Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do aluno 1:")));
            aluno1.setNomeCompleto(JOptionPane.showInputDialog("Digite o nome completo do aluno 1:"));
            aluno1.setDataDeNascimento(lerData("Digite a data de nascimento do aluno 1 (dd/MM/yyyy):", formatador));

            Aluno aluno2 = new Aluno();
            aluno2.setRegistroMatricula(Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do aluno 2:")));
            aluno2.setNomeCompleto(JOptionPane.showInputDialog("Digite o nome completo do aluno 2:"));
            aluno2.setDataDeNascimento(lerData("Digite a data de nascimento do aluno 2 (dd/MM/yyyy):", formatador));

            int rm3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do aluno 3:"));
            String nome3 = JOptionPane.showInputDialog("Digite o nome completo do aluno 3:");
            LocalDate nascimento3 = lerData("Digite a data de nascimento do aluno 3 (dd/MM/yyyy):", formatador);
            Aluno aluno3 = new Aluno(rm3, nome3, nascimento3);

            int rm4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do aluno 4:"));
            String nome4 = JOptionPane.showInputDialog("Digite o nome completo do aluno 4:");
            LocalDate nascimento4 = lerData("Digite a data de nascimento do aluno 4 (dd/MM/yyyy):", formatador);
            Aluno aluno4 = new Aluno(rm4, nome4, nascimento4);

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
            JOptionPane.showMessageDialog(null,
                    "O RM deve conter apenas números inteiros.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Erro de validação",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static LocalDate lerData(String mensagem, DateTimeFormatter formatador) {
        while (true) {
            String dataTexto = JOptionPane.showInputDialog(mensagem);

            try {
                LocalDate data = LocalDate.parse(dataTexto, formatador);

                if (data.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(
                            null,
                            "A data não pode estar no futuro.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    continue;
                }

                return data;

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Data inválida. Use o formato dd/MM/yyyy.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE

                );
            }
        }
    }
}