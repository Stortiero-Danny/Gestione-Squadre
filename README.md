# Gestione Squadre di Calcio – Java

Applicazione **Java da console** che simula la gestione di squadre di calcio e calciatori. Consente di creare squadre, aggiungere e rimuovere giocatori e visualizzarne le informazioni. Le classi includono inoltre operazioni per confrontare alcune caratteristiche fisiche dei calciatori e verificare le date.

## Funzionalità

- Creazione di squadre con **nome, città e anno di fondazione**.
- Gestione di un elenco di **massimo 30 calciatori** per squadra.
- Aggiunta, rimozione e visualizzazione dei calciatori.
- Memorizzazione di **nome, cognome, squadra, altezza, peso e data di nascita** per ciascun calciatore.
- Metodi per confrontare calciatori in base a **peso e altezza**.
- Classe dedicata alle date, con controlli di validità e gestione degli anni bisestili.
- Costruttori di copia per duplicare oggetti.

## Prova la demo

**[Esegui il progetto online](https://onlinegdb.com/pklSJJHip)**

## Esecuzione in locale

È necessario installare un **JDK (Java Development Kit)**.

Apri un terminale nella cartella `src` ed esegui:

```bash
javac Data.java Calciatore.java Squadra.java mainSquadra.java
java mainSquadra
```

## Struttura del progetto

```text
Gestione-Squadre-Java/
├── src/
│   ├── Data.java
│   ├── Calciatore.java
│   ├── Squadra.java
│   └── mainSquadra.java
└── README.md
```

## Organizzazione del codice

| Classe | Responsabilità |
| --- | --- |
| `Data` | Conserva e verifica giorno, mese e anno; include un metodo per la distanza tra date. |
| `Calciatore` | Gestisce i dati di un giocatore e fornisce metodi di confronto. |
| `Squadra` | Gestisce informazioni della squadra e un array di calciatori. |
| `mainSquadra` | Dimostra creazione di squadre e operazioni di aggiunta/rimozione. |

## Dettagli tecnici

Il progetto applica concetti di **programmazione orientata agli oggetti (OOP)**: classi e oggetti, incapsulamento, getter/setter, costruttori (anche di copia), array di oggetti e metodi.

## Note

Il codice nasce come **progetto didattico**. La logica di validazione della classe `Data` include un limite superiore dell'anno fissato a **2024**; inoltre, il metodo `distanza()` richiede verifiche aggiuntive per alcuni intervalli di date. I metodi di confronto sono disponibili nelle classi, ma non vengono mostrati dal `main` attuale.
