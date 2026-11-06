package br.pucpr.codigomorse;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MorseSoundPlayer {

    private static final float SAMPLE_RATE = 44100f;
    private static final double FREQUENCY = 600.0;   // tom em hz
    private static final int UNIT_MS = 90;           // duracao de um ponto, em milissegundos
    private static final byte AMPLITUDE = 100;       // volume do bipe (0 a 127)

    // formato da entrada: letras separadas por espaco e palavras separadas por "/"
    // exemplo: ".- -... / .-.."
    public void playMorse(String morseCode) {
        if (morseCode == null || morseCode.isBlank()) {
            return;
        }

        // toca em uma thread separada para a janela nao travar
        Thread player = new Thread(() -> play(morseCode));
        player.setDaemon(true);
        player.start();
    }

    private void play(String morseCode) {
        AudioFormat format = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);

        try (SourceDataLine line = AudioSystem.getSourceDataLine(format)) {
            line.open(format);
            line.start();

            String[] words = morseCode.trim().split("/");
            for (int i = 0; i < words.length; i++) {
                playWord(line, words[i].trim());
                if (i < words.length - 1) {
                    playSilence(line, 7); // pausa entre palavras
                }
            }

            line.drain();
        } catch (LineUnavailableException e) {
            System.err.println("nao foi possivel tocar o som: " + e.getMessage());
        }
    }

    private void playWord(SourceDataLine line, String word) {
        if (word.isEmpty()) {
            return;
        }

        String[] letters = word.split("\\s+");
        for (int i = 0; i < letters.length; i++) {
            playLetter(line, letters[i]);
            if (i < letters.length - 1) {
                playSilence(line, 3); // pausa entre letras
            }
        }
    }

    private void playLetter(SourceDataLine line, String letter) {
        for (int i = 0; i < letter.length(); i++) {
            char symbol = letter.charAt(i);

            if (symbol == '.') {
                playTone(line, 1); // ponto = bipe curto
            } else if (symbol == '-') {
                playTone(line, 3); // traco = bipe longo
            } else {
                continue; // ignora qualquer simbolo que nao seja ponto ou traco
            }

            if (i < letter.length() - 1) {
                playSilence(line, 1); // pausa entre os sinais da mesma letra
            }
        }
    }

    private void playTone(SourceDataLine line, int units) {
        int samples = samplesFor(units);
        byte[] buffer = new byte[samples];

        for (int i = 0; i < samples; i++) {
            double angle = 2.0 * Math.PI * i * FREQUENCY / SAMPLE_RATE;
            buffer[i] = (byte) (Math.sin(angle) * AMPLITUDE);
        }

        line.write(buffer, 0, samples);
    }

    private void playSilence(SourceDataLine line, int units) {
        int samples = samplesFor(units);
        line.write(new byte[samples], 0, samples); // bytes em zero = silencio
    }

    private int samplesFor(int units) {
        return (int) (SAMPLE_RATE * UNIT_MS * units / 1000);
    }
}
