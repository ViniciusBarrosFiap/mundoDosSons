/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author labsfiap
 */
public class Animais_DAO {
    private final String[] imagesPath = {
        "/Imagem/cat.png",
        "/Imagem/chicken.png",
        "/Imagem/cow.png",
        "/Imagem/dog.png",
        "/Imagem/duck.png",
        "/Imagem/elefant.png",
        "/Imagem/pig.png",
        "/Imagem/wolf.png"
    };
    private final String[] soundsPath = {
        "/Sons/cat.mp3",
        "/Sons/chicken.mp3",
        "/Sons/cow.mp3",
        "/Sons/dog.mp3",
        "/Sons/duck.mp3",
        "/Sons/Elefant.mp3",
        "/Sons/pig.mp3",
        "/Sons/wolf.mp3",
        
    };
    private int animalIndexAtual = 0;
    
        public ImageIcon getCurrentImageIcon() {
        String imagePath = imagesPath[animalIndexAtual];
        URL imgURL = getClass().getResource(imagePath);

        if (imgURL != null) {
            System.out.println("Imagem encontrada: " + imgURL.getPath());
            return new ImageIcon(imgURL);
        } else {
            System.out.println("Imagem não encontrada: " + imagePath);
            return null; // Retorna null ou uma imagem padrão para erro
        }
    }
    
    public String getCurrentSoundPath() {
        return soundsPath[animalIndexAtual];
    }
    
    public void nextAnimal() {
        animalIndexAtual = (animalIndexAtual + 1) % imagesPath.length;
    }
    public void previousAnimal() {
        animalIndexAtual = (animalIndexAtual - 1 + imagesPath.length) % imagesPath.length;
    }
    
    public void playCurrentAnimalSound() {
        String soundPath = getCurrentSoundPath();
        playSound(soundPath);
    }
    
    public void playSound(String soundPath) {
        InputStream in = getClass().getResourceAsStream(soundPath);

        if (in != null) {
            try {
                Player p = new Player(in);
                p.play();
                System.out.println("Som reproduzido: " + soundPath);
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Som não encontrado: " + soundPath);
        }
    }

}
