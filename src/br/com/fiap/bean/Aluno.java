/*
RM569568 - Carlos Henrique De Melo Franco
RM573620 - Henrique Bonachela de Carvalho Carabante
RM573977 - Murilo Almeida Rodrigues de Souza
*/

package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    private int registroMatricula;
    private String nomeCompleto;
    private LocalDate dataDeNascimento;
    public Aluno() {
    }
    public Aluno(int registroMatricula, String nomeCompleto, LocalDate dataDeNascimento) {
        setRegistroMatricula(registroMatricula);
        this.nomeCompleto = nomeCompleto;
        setDataDeNascimento(dataDeNascimento);
    }
    public int getRegistroMatricula() {
        return registroMatricula;
    }
    public void setRegistroMatricula(int registroMatricula) {
        try {
            if (registroMatricula >= 80000 && registroMatricula <= 599999) {
                this.registroMatricula = registroMatricula;
            } else {
                throw new Exception("O Registro de matrícula deve ser entre 80000-599999.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        try {
            LocalDate dataLimite = LocalDate.parse("01-01-1960").minusDays(1);
            LocalDate dataAtual = LocalDate.now().plusDays(1);
            if (dataDeNascimento.isAfter(dataLimite) && dataDeNascimento.isBefore(dataAtual)) {
                this.dataDeNascimento = dataDeNascimento;
            } else {
                throw new Exception("Inválido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public String calcularIdadeCompleta(LocalDate dataAtual) {
        Period periodoEntre = Period.between(dataDeNascimento, dataAtual);
        String idadeExtenso = String.format("%d anos, %d mês(s) e %d dia(s)",
                periodoEntre.getYears(), periodoEntre.getMonths(), periodoEntre.getDays());
        return idadeExtenso;
    }
}
