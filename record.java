package pilhajava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class record {
    private LocalDate dataRecord;
    private String nome;
    private double tempo;

    public LocalDate getDataRecord() {
        return dataRecord;
    }

    public void setDataRecord(LocalDate detaRecord) {
        this.dataRecord = detaRecord;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
    
    @Override
    public String toString() {
        String dataFormatada = 
                dataRecord.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "| Nome: " + this.nome + "| Tempo: " + this.tempo
                + "| Data: " + dataFormatada;
    }
    
}
