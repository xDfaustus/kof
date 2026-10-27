package com.arcade.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "*") // Permite peticiones desde el frontend HTML/JS
public class AssetController {

    // Estructura para las pistas de audio (música de fondo)
    public static class Track {
        private String title;
        private String artist;
        private String src;

        public Track(String title, String artist, String src) {
            this.title = title;
            this.artist = artist;
            this.src = src;
        }

        public String getTitle() { return title; }
        public String getArtist() { return artist; }
        public String getSrc() { return src; }
    }

    // Estructura para la información de cada personaje del selector
    public static class Character {
        private String id;
        private String name;
        private String color;
        private String img;
        private String voice;

        public Character(String id, String name, String color, String img, String voice) {
            this.id = id;
            this.name = name;
            this.color = color;
            this.img = img;
            this.voice = voice;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public String getColor() { return color; }
        public String getImg() { return img; }
        public String getVoice() { return voice; }
    }

    // Endpoint para la lista de reproducción (Música local 0.mp3 a 4.mp3)
    @GetMapping("/playlist")
    public ResponseEntity<List<Track>> getPlaylist() {
        List<Track> playlist = Arrays.asList(
            new Track("酔いどれ知らず", "【Kanaria】", "/assets/0.mp3"),
            new Track("Esaka!! (KOF Theme)", "【SNK Sound Team】", "/assets/1.mp3"),
            new Track("Lonely Wolf", "【Garou Asset Mix】", "/assets/2.mp3"),
            new Track("Arashi no Saxophone", "【Iori Theme Asset】", "/assets/3.mp3"),
            new Track("Final Boss Theme", "【Boss Asset】", "/assets/4.mp3")
        );
        return ResponseEntity.ok(playlist);
    }

    // Endpoint para efectos de sonido (SFX locales: A.mp3, B.mp3, C.mp3)
    @GetMapping("/sfx")
    public ResponseEntity<Map<String, String>> getSfx() {
        Map<String, String> sfx = new HashMap<>();
        sfx.put("intro", "/assets/A.mp3");  // Sonido de intro/apertura arcade
        sfx.put("nav", "/assets/B.mp3");    // Sonido al rotar/cambiar personaje
        sfx.put("select", "/assets/C.mp3"); // Sonido al confirmar selección (VS)
        return ResponseEntity.ok(sfx);
    }

    // Endpoint para obtener la lista de los 10 personajes usando assets locales
    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getCharacters() {
        List<Character> characters = Arrays.asList(
            new Character("kyo", "Kyo Kusanagi", "#ffcc00", "/assets/images/kyo.png", "/assets/voices/kyo.mp3"),
            new Character("rugal", "Rugal Bernstein", "#00e5ff", "/assets/images/rugal.png", "/assets/voices/rugal.mp3"),
            new Character("kula", "Kula Diamond", "#ff3366", "/assets/images/kula.png", "/assets/voices/kula.mp3"),
            new Character("chris", "Orochi Chris", "#cc33ff", "/assets/images/chris.png", "/assets/voices/chris.mp3"),
            new Character("rock", "Rock Howard", "#00ffcc", "/assets/images/rock.png", "/assets/voices/rock.mp3"),
            new Character("terry", "Terry Bogard", "#ff9900", "/assets/images/terry.png", "/assets/voices/terry.mp3"),
            new Character("mary", "Blue Mary", "#33ff66", "/assets/images/mary.png", "/assets/voices/mary.mp3"),
            new Character("mai", "Mai Shiranui", "#ff33cc", "/assets/images/mai.png", "/assets/voices/mai.mp3"),
            new Character("leona", "Leona Heidern", "#33ccff", "/assets/images/leona.png", "/assets/voices/leona.mp3"),
            new Character("iori", "Iori Yagami", "#ff3333", "/assets/images/iori.png", "/assets/voices/iori.mp3")
        );
        return ResponseEntity.ok(characters);
    }

    // Endpoint para la insignia del creador (Badge ҂shirou / ID)
    @GetMapping("/badge")
    public ResponseEntity<Map<String, String>> getBadgeInfo() {
        Map<String, String> badge = new HashMap<>();
        badge.put("text", "҂shirou");
        badge.put("id", "(1525823861)");
        return ResponseEntity.ok(badge);
    }
}
