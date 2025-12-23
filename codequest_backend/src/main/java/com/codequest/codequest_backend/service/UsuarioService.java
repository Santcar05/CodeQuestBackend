package com.codequest.codequest_backend.service;

import com.codequest.codequest_backend.domain.RolUsuario;
import com.codequest.codequest_backend.domain.Usuario;
import com.codequest.codequest_backend.dto.UsuarioDTO;
import com.codequest.codequest_backend.dto.UsuarioRequestDTO;
import com.codequest.codequest_backend.mapper.UsuarioMapper;
import com.codequest.codequest_backend.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final BCryptPasswordEncoder passwordEncoder; 

    // Crear usuario
    public UsuarioDTO crearUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByCorreo(dto.getCorreo())) {
            throw new RuntimeException("Correo ya registrado");
        }
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setContrasenaHash(passwordEncoder.encode(dto.getPassword()));
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    // Listar todos los usuarios
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .toList();
    }

    // Obtener usuario por ID
    public UsuarioDTO obtenerUsuario(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Actualizar usuario
    public UsuarioDTO actualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setCorreo(dto.getCorreo());
        try {
    usuario.setRol(RolUsuario.valueOf(dto.getRol().toUpperCase()));
    } catch (IllegalArgumentException e) {
        throw new RuntimeException("Rol inválido: " + dto.getRol());
    }

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            usuario.setContrasenaHash(passwordEncoder.encode(dto.getPassword()));
        }
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
