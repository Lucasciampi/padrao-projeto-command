package org.example;

public class ConcluirTarefaCommand implements Command {

    private Tarefa tarefa;
    private String statusAnterior;

    public ConcluirTarefaCommand(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void executar() {
        this.statusAnterior = this.tarefa.getStatus();
        this.tarefa.concluir();
    }

    @Override
    public void desfazer() {
        this.tarefa.setStatus(this.statusAnterior);
    }

}
