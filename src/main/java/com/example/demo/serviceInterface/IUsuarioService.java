package com.example.demo.serviceInterface;

import com.example.demo.modelo.Manga;
import com.example.demo.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
    List<Manga> getFavoritosByUsuario(String username);
    void addFavorito(String username, Long mangaId);
    void removeFavorito(String username, Long mangaId);
}
