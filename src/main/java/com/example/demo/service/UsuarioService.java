package com.example.demo.service;

import com.example.demo.modelo.Manga;

import com.example.demo.modelo.Usuario;
import com.example.demo.Repository.MangaRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.serviceInterface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MangaRepository mangaRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
        existingUsuario.setUsername(usuario.getUsername());
        existingUsuario.setEmail(usuario.getEmail());
        // Actualiza los demás campos...
        return usuarioRepository.save(existingUsuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Manga> getFavoritosByUsuario(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
        return usuario.getFavoritos();
    }

    @Override
    public void addFavorito(String username, Long mangaId) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
        Manga manga = mangaRepository.findById(mangaId)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
        usuario.getFavoritos().add(manga);
        usuarioRepository.save(usuario);
    }

    @Override
    public void removeFavorito(String username, Long mangaId) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
        Manga manga = mangaRepository.findById(mangaId)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
        usuario.getFavoritos().remove(manga);
        usuarioRepository.save(usuario);
    }
}

