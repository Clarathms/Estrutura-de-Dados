package com.company;

public class Q6 {
    public boolean criaDiretorio() {
        Diretorio root = new Diretorio("root"); //Principal

        Diretorio docs = new Diretorio("DOCUMENTOS");     // CRIA DIRETORIO 1

        // Arquivos D1
        docs.insere(new Arquivo("Identidade"));
        docs.insere(new Arquivo("CPV de residência"));
        docs.insere(new Arquivo("Foto 3x4"));
        docs.insere(new Arquivo("Conta Bancária"));

        root.insere(docs);

        Diretorio faculdade = new Diretorio("TRABALHOS");   // CRIA DIRETORIO 1
        faculdade.insere(new Arquivo("EDD1"));
        faculdade.insere(new Arquivo("EDD2"));
        faculdade.insere(new Arquivo("R1"));

        Diretorio aces = new Diretorio("ACEs"); // Subdiretorio
        aces.insere(new Arquivo("ACE1"));
        aces.insere(new Arquivo("ACE2"));
        aces.insere(new Arquivo("ACE3"));
        faculdade.insere(aces);

        faculdade.insere(new Arquivo("TPD"));
        root.insere(faculdade);

        Diretorio series = new Diretorio("SÉRIES");
        Diretorio ms = new Diretorio("Melhores séries");

        Diretorio comedia = new Diretorio("Comédias leves");
        comedia.insere(new Arquivo("How I Met Your Mother"));
        comedia.insere(new Arquivo("FRIENDS"));
        comedia.insere(new Arquivo("Jane the virgin"));
        comedia.insere(new Arquivo("Cobra Kai"));

        ms.insere(comedia);       // Subdiretorio
        Diretorio marvel = new Diretorio("MARVEL");
        marvel.insere(new Arquivo("Marvel Runaaways"));
        ms.insere(marvel);
        series.insere(ms);

        Diretorio comediasRomanticas = new Diretorio("Comedias Romanticas");  // Diretório vazio
        series.insere(comediasRomanticas);
        root.insere(series);

        root.imprime(0);
        return false;
    }

}
