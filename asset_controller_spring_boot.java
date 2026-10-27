package com.arcade.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "*")
public class AssetControllerSpringBoot {

    private static final String ASSETS = "/assets/";

    /**
     * Lista únicamente las canciones que existen.
     * Archivos: assets/0.mp3 y assets/1.mp3
     */
    @GetMapping("/playlist")
    public List<Map<String, String>> getPlaylist() {
        List<Map<String, String>> playlist = new ArrayList<>();

        playlist.add(createTrack(
            "0.mp3",
            "酔いどれ知らず",
            "【Kanaria】"
        ));

        playlist.add(createTrack(
            "1.mp3",
            "Esaka!! (KOF Theme)",
            "【SNK Sound Team】"
        ));

        return playlist;
    }

    /**
     * Efectos de sonido disponibles.
     * A.mp3 = entrada
     * C.mp3 = selección
     *
     * No se devuelve B.mp3 porque no existe en tus assets.
     */
    @GetMapping("/sfx")
    public Map<String, String> getSoundEffects() {
        Map<String, String> sfx = new LinkedHashMap<>();

        sfx.put("intro", ASSETS + "A.mp3");
        sfx.put("select", ASSETS + "C.mp3");

        return sfx;
    }

    /**
     * Voces disponibles para el narrador.
     */
    @GetMapping("/voices")
    public List<Map<String, String>> getVoices() {
        String[] names = {
            "chris",
            "iori",
            "kula",
            "kyo",
            "leona",
            "mai",
            "mary",
            "rock",
            "rugal",
            "terry"
        };

        List<Map<String, String>> voices = new ArrayList<>();

        for (String name : names) {
            Map<String, String> voice = new LinkedHashMap<>();
            voice.put("name", name);
            voice.put("src", ASSETS + "voices/" + name + ".mp3");
            voices.add(voice);
        }

        return voices;
    }

    /**
     * Datos de los personajes.
     * Las imágenes se mantienen en /assets/images/.
     * Si tus imágenes tienen otros nombres o están en otra carpeta,
     * tendrás que ajustar las rutas.
     */
    @GetMapping("/characters")
    public List<Map<String, String>> getCharacters() {
        String[] names = {
            "chris",
            "iori",
            "kula",
            "kyo",
            "leona",
            "mai",
            "mary",
            "rock",
            "rugal",
            "terry"
        };

        List<Map<String, String>> characters = new ArrayList<>();

        for (String name : names) {
            Map<String, String> character = new LinkedHashMap<>();

            character.put("name", name);
            character.put("image", ASSETS + "images/" + name + ".png");
            character.put("voice", ASSETS + "voices/" + name + ".mp3");

            characters.add(character);
        }

        return characters;
    }

    private Map<String, String> createTrack(
            String file,
            String title,
            String artist) {

        Map<String, String> track = new LinkedHashMap<>();

        track.put("src", ASSETS + file);
        track.put("title", title);
        track.put("artist", artist);

        return track;
    }
}
