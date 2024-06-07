package com.example.demo.controller;

import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Manga;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{username}/favoritos")
    public ResponseEntity<List<Manga>> getFavoritosByUsuario(@PathVariable String username) {
        List<Manga> favoritos = usuarioService.getFavoritosByUsuario(username);
        return ResponseEntity.ok(favoritos);
    }

    @PostMapping("/{username}/favoritos")
    public ResponseEntity<Void> addFavorito(@PathVariable String username, @RequestParam Long mangaId) {
        usuarioService.addFavorito(username, mangaId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{username}/favoritos/{mangaId}")
    public ResponseEntity<Void> removeFavorito(@PathVariable String username, @PathVariable Long mangaId) {
        usuarioService.removeFavorito(username, mangaId);
        return ResponseEntity.noContent().build();
    }
}