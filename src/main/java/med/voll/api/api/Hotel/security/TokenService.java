package med.voll.api.api.Hotel.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.api.Hotel.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generarToken(Usuario usuario){
        try{
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("hotel_api")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .sign(algoritmo);
        }catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
}
